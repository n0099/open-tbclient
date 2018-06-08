package com.baidu.ar.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.task.HttpTaskUtility;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.ARSDKInfo;
import com.baidu.ar.util.DeviceUuidFactory;
import com.baidu.ar.util.HttpUtils;
import com.baidu.ar.util.UrlUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class StatisticHelper {
    private String a;
    private Context b;
    private boolean c;
    private boolean d;
    private boolean e;
    private b f;
    private HandlerThread g;
    private final int h;
    private long i;
    private long j;
    private int k;
    private long l;
    private long m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final StatisticHelper a = new StatisticHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private StatisticHelper a;

        public b(Looper looper, StatisticHelper statisticHelper) {
            super(looper);
            this.a = statisticHelper;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    this.a.a(this.a.b, (Map) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    private StatisticHelper() {
        this.c = false;
        this.d = false;
        this.e = true;
        this.h = 300;
    }

    private void a() {
        if (this.g == null) {
            this.g = new HandlerThread("statistic_helper_handler_thread");
            this.g.start();
            this.f = new b(this.g.getLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Map<String, String> map) {
        if (context == null) {
            return;
        }
        String statisticUrl = UrlUtils.getStatisticUrl();
        String uuid = new DeviceUuidFactory(context).getDeviceUuid().toString();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!TextUtils.isEmpty(ARConfig.getARKey())) {
                jSONObject.put("ar_key", ARConfig.getARKey());
            }
            jSONObject.put("ar_id", ARConfig.getARId());
            jSONObject.put(ARConfigKey.AR_FROM, ARConfig.getArFrom());
            jSONObject.put(HttpConstants.AIP_APP_ID, DuMixARConfig.getAipAppId());
            HttpTaskUtility.addCheckInfo(jSONObject);
            HttpTaskUtility.addSystemInfo(context, jSONObject);
            jSONObject.put("os_type", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put(StatisticConstants.OS_VERSION, Build.MODEL);
            jSONObject.put(StatisticConstants.DEVICE_TYPE, Build.BRAND);
            jSONObject.put("device_id", uuid);
            jSONObject.put(StatisticConstants.OS_VERSION, Build.VERSION.SDK_INT);
            jSONObject.put("app_version", ARSDKInfo.getVersionCode());
            jSONObject.put(HttpConstants.HTTP_ENGINE_VERSION, ARSDKInfo.getVersionCode());
            if (!TextUtils.isEmpty(ARSDKInfo.getAppId(context))) {
                jSONObject.put(HttpConstants.HTTP_APP_ID, ARSDKInfo.getAppId(context));
            }
            jSONObject.put(HttpConstants.HTTP_SYSTEM_VERSION, Build.VERSION.SDK_INT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ARLog.d("statistic params = " + jSONObject.toString());
        ARLog.d("result = " + HttpUtils.postRequest(statisticUrl, jSONObject.toString()));
    }

    private void a(Map<String, String> map) {
        if (this.f != null) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.obj = map;
            this.f.sendMessage(obtainMessage);
        }
    }

    public static StatisticHelper getInstance() {
        return a.a;
    }

    public void initStatistic(Context context) {
        this.b = context;
        if (ARConfig.getARKey() != null) {
            this.a = ARConfig.getARKey() + Calendar.getInstance().getTimeInMillis();
        } else {
            this.a = String.valueOf(Calendar.getInstance().getTimeInMillis());
        }
        a();
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.EVENT_ID, StatisticConstants.AR_ENTRANCE);
        hashMap.put(StatisticConstants.EVENT_PARAM, ARConfig.getArValue());
        a(hashMap);
    }

    public void release() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        this.a = null;
        StatisticConstants.reset();
    }

    public void statisticFrameRate(String str) {
        if (this.k < 300) {
            if (this.k == 0) {
                this.i = Calendar.getInstance().getTimeInMillis();
            }
            this.j = Calendar.getInstance().getTimeInMillis();
            this.l = this.j - this.i;
            this.i = this.j;
            this.m += this.l;
            this.k++;
            if (this.k == 300) {
                getInstance().statisticInfo(str, String.valueOf((((float) this.m) * 1.0f) / this.k));
            }
        }
    }

    public void statisticInfo(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.REQUEST_ID, this.a);
        hashMap.put("ar_type", String.valueOf(ARConfig.getARType()));
        hashMap.put(StatisticConstants.EVENT_ID, str);
        a(hashMap);
    }

    public void statisticInfo(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        hashMap.put(StatisticConstants.REQUEST_ID, this.a);
        hashMap.put("ar_type", String.valueOf(ARConfig.getARType()));
        hashMap.put(StatisticConstants.EVENT_ID, str);
        hashMap.put(StatisticConstants.EVENT_PARAM, str2);
        a(hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.ar.statistic.StatisticHelper */
    /* JADX WARN: Multi-variable type inference failed */
    public void statisticInfo(String str, Map map) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("time", String.valueOf(Long.valueOf(System.currentTimeMillis())));
        map.put(StatisticConstants.REQUEST_ID, this.a);
        map.put("ar_type", String.valueOf(ARConfig.getARType()));
        map.put(StatisticConstants.EVENT_ID, str);
        a(map);
    }

    public void statisticTrackedStatus(boolean z) {
        if (this.e) {
            if (z) {
                this.e = false;
                this.d = true;
            }
        } else if (this.c) {
        } else {
            if (!z) {
                if (this.d) {
                    this.d = false;
                    getInstance().statisticInfo(StatisticConstants.UNTRACKED);
                }
            } else if (this.d) {
            } else {
                this.d = true;
                this.c = true;
                getInstance().statisticInfo(StatisticConstants.TRACKED);
            }
        }
    }
}
