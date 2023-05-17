package com.baidu.searchbox.datacollector.growth.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datacollector.growth.model.ActiveData;
import com.baidu.searchbox.datacollector.growth.model.ChannelData;
import com.baidu.searchbox.datacollector.growth.model.ClipBoardData;
import com.baidu.searchbox.datacollector.growth.utils.DeviceUtil;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback;
import com.baidu.searchbox.datacollector.growth.utils.PackageUtil;
import com.baidu.searchbox.datacollector.growth.utils.UBCEncryptor;
import com.baidu.ubc.UBCManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GrowthCollectProcessor {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "GrowthCollect";
    public static volatile GrowthCollectProcessor sSingleton;
    public ExecutorService mExecutorService;
    public long mLastDeviceRecordTime;
    public UBCManager ubcManager;

    public GrowthCollectProcessor() {
        init();
    }

    public static GrowthCollectProcessor getInstance() {
        if (sSingleton == null) {
            synchronized (GrowthCollectProcessor.class) {
                if (sSingleton == null) {
                    sSingleton = new GrowthCollectProcessor();
                }
            }
        }
        return sSingleton;
    }

    private void init() {
        this.mExecutorService = new ThreadPoolExecutor(1, 1, 600000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    private String generateDeviceInfo(ActiveData activeData, Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        String channel = activeData.getChannel();
        String iMei = DeviceUtil.getIMei(context);
        try {
            jSONObject.put("channel", channel);
            jSONObject.put("imei", iMei);
            jSONObject.put("oaid", str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeGenerateActiveStatistic(final ActiveData activeData, final Context context, final String str) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.6
            @Override // java.lang.Runnable
            public void run() {
                GrowthCollectProcessor.this.generateActiveStatistic(activeData, context, str);
            }
        });
    }

    private String generateDeviceIdInfo(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", DeviceUtil.getIMei(context));
            jSONObject.put("oaid", str);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeActiveStatistic(final ActiveData activeData, final Context context) {
        Context context2;
        if (this.ubcManager == null) {
            return;
        }
        if (!(context instanceof Application)) {
            context2 = context.getApplicationContext();
        } else {
            context2 = context;
        }
        DeviceUtil.generateOaid(context2, new IDeviceCallback() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.5
            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onFail() {
                if (GrowthCollectProcessor.DEBUG) {
                    Log.d(GrowthCollectProcessor.TAG, "oaid fail: ");
                }
                GrowthCollectProcessor.this.invokeGenerateActiveStatistic(activeData, context, "");
            }

            @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
            public void onSuccess(String str) {
                if (GrowthCollectProcessor.DEBUG) {
                    Log.d(GrowthCollectProcessor.TAG, "oaid: " + str);
                }
                GrowthCollectProcessor.this.invokeGenerateActiveStatistic(activeData, context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeGenerateDeviceStatistic(final Context context, final String str) {
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.8
            @Override // java.lang.Runnable
            public void run() {
                GrowthCollectProcessor.this.generateDeviceStatistic(context, str);
            }
        });
    }

    public void statisticActiveData(final ActiveData activeData, final Context context) {
        if (activeData != null && context != null) {
            this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    GrowthCollectProcessor.this.invokeActiveStatistic(activeData, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateActiveStatistic(ActiveData activeData, Context context, String str) {
        String type = activeData.getType();
        if (TextUtils.isEmpty(type)) {
            type = "active";
        }
        String firstInstallTime = PackageUtil.getFirstInstallTime(context);
        String lastUpdateTime = PackageUtil.getLastUpdateTime(context);
        UBCEncryptor.MixedEncryptedResult encryptByRSAAndAESMixed = UBCEncryptor.encryptByRSAAndAESMixed(generateDeviceInfo(activeData, context, str));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", type);
            jSONObject.put(GrowthConstant.UBC_KEY_FIT, firstInstallTime);
            jSONObject.put(GrowthConstant.UBC_KEY_LUT, lastUpdateTime);
            jSONObject.put(GrowthConstant.UBC_KEY_AES_KEY, encryptByRSAAndAESMixed.encryptedAESKeys);
            jSONObject.put(GrowthConstant.UBC_KEY_USS, encryptByRSAAndAESMixed.encryptedInput);
            JSONObject extend = activeData.getExtend();
            if (extend != null) {
                jSONObject.put("ext", extend);
            }
            if (DEBUG) {
                Log.d(TAG, "active content: " + jSONObject);
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_ACTIVE, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateDeviceStatistic(Context context, String str) {
        UBCEncryptor.MixedEncryptedResult encryptByRSAAndAESMixed = UBCEncryptor.encryptByRSAAndAESMixed(generateDeviceIdInfo(context, str));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO);
            jSONObject.put(GrowthConstant.UBC_KEY_AES_KEY, encryptByRSAAndAESMixed.encryptedAESKeys);
            jSONObject.put(GrowthConstant.UBC_KEY_USS, encryptByRSAAndAESMixed.encryptedInput);
            if (DEBUG) {
                Log.d(TAG, "device content: " + jSONObject);
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_DEVICE, jSONObject);
            SharedPreferences.Editor edit = context.getSharedPreferences(GrowthConstant.PREF_NAME, 0).edit();
            long currentTimeMillis = System.currentTimeMillis();
            edit.putLong(GrowthConstant.SP_KEY_LAST_DEVICE_RECORD_TIME, currentTimeMillis);
            edit.apply();
            this.mLastDeviceRecordTime = currentTimeMillis;
            if (DEBUG) {
                Log.d(TAG, "update device record time: " + currentTimeMillis);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelStatistic(ChannelData channelData) {
        if (this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", channelData.getType());
            jSONObject.put("source", channelData.getSource());
            jSONObject.put(GrowthConstant.UBC_KEY_LAUNCH_CH, channelData.getLaunchChannel());
            jSONObject.put(GrowthConstant.UBC_KEY_DOWN_CH, channelData.getDownChannel());
            jSONObject.put("schema", channelData.getSchema());
            JSONObject extend = channelData.getExtend();
            if (extend != null) {
                jSONObject.put("ext", extend);
            }
            if (DEBUG) {
                Log.d(TAG, "channel content: " + jSONObject);
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_CHANNEL, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClipBoardStatistic(ClipBoardData clipBoardData) {
        if (this.ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
            jSONObject.put("source", clipBoardData.getSource());
            jSONObject.put(GrowthConstant.UBC_KEY_LAUNCH_CH, clipBoardData.getLaunchChanel());
            jSONObject.put(GrowthConstant.UBC_KEY_DOWN_CH, clipBoardData.getDownChannel());
            jSONObject.put("schema", clipBoardData.getSchema());
            JSONObject extend = clipBoardData.getExtend();
            if (extend != null) {
                jSONObject.put("ext", extend);
            }
            if (DEBUG) {
                Log.d(TAG, "clip board content: " + jSONObject);
            }
            this.ubcManager.onEvent(GrowthConstant.UBC_ID_CLIP_BOARD, jSONObject);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDeviceStatistic(final Context context) {
        Context context2;
        if (this.ubcManager != null && context != null) {
            if (this.mLastDeviceRecordTime == 0) {
                this.mLastDeviceRecordTime = context.getSharedPreferences(GrowthConstant.PREF_NAME, 0).getLong(GrowthConstant.SP_KEY_LAST_DEVICE_RECORD_TIME, 0L);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mLastDeviceRecordTime;
            if (currentTimeMillis <= 86400000) {
                if (DEBUG) {
                    Log.d(TAG, "diffTime: " + currentTimeMillis + ", not record this data");
                    return;
                }
                return;
            }
            if (!(context instanceof Application)) {
                context2 = context.getApplicationContext();
            } else {
                context2 = context;
            }
            DeviceUtil.generateOaid(context2, new IDeviceCallback() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.7
                @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
                public void onFail() {
                    GrowthCollectProcessor.this.invokeGenerateDeviceStatistic(context, "");
                }

                @Override // com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback
                public void onSuccess(String str) {
                    GrowthCollectProcessor.this.invokeGenerateDeviceStatistic(context, str);
                }
            });
        }
    }

    public void statisticChannelData(final ChannelData channelData) {
        if (channelData == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.2
            @Override // java.lang.Runnable
            public void run() {
                GrowthCollectProcessor.this.invokeChannelStatistic(channelData);
            }
        });
    }

    public void statisticClipBoardData(final ClipBoardData clipBoardData) {
        if (clipBoardData == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                GrowthCollectProcessor.this.invokeClipBoardStatistic(clipBoardData);
            }
        });
    }

    public void statisticDeviceData(final Context context) {
        if (context == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.baidu.searchbox.datacollector.growth.service.GrowthCollectProcessor.4
            @Override // java.lang.Runnable
            public void run() {
                GrowthCollectProcessor.this.invokeDeviceStatistic(context);
            }
        });
    }
}
