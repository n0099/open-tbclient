package com.baidu.searchbox.playerserver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.common.param.CommonUrlParamManager;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PlayerPolicyImplement implements IPlayerPolicy {
    public static final int ADD_OBSERVER_WORK_MSG = 2;
    public static final int JELLY_BEAN_MR2 = 18;
    public static final int REMOVE_OBSERVER_WORK_MSG = 3;
    public static final String TAG = "PlayerServer-PlcyImplmnt";
    public static final int TIMER_UPDATE_WORK_MSG = 1;
    public static final int UPDATE_CONFIG_MAIN_MSG = 1;
    public HandlerThread mHandlerThread;
    public Handler mWorkHandler;
    public final String PLAYER_SERVER = "http://mbd.baidu.com/playserver/ctlconf?";
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public List<IPlayerConfig> list = Collections.synchronizedList(new LinkedList());
    public long mUpdateInterval = 3000;
    public long mLastUpdateTimeStamp = 0;
    public long mFirstUpdateTimeStamp = 0;
    public OkHttpClient mOkHttpClient = null;

    public PlayerPolicyImplement() {
        this.mWorkHandler = null;
        this.mHandlerThread = null;
        HandlerThread handlerThread = new HandlerThread("player_policy_implement");
        this.mHandlerThread = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.mWorkHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i2 = message.what;
                    if (i2 == 1) {
                        PlayerPolicyImplement.this.onUpdateConfig();
                    } else if (i2 == 2) {
                        Object obj = message.obj;
                        if (obj instanceof IPlayerConfig) {
                            PlayerPolicyImplement.this.onRegister((IPlayerConfig) obj);
                        }
                    } else if (i2 != 3) {
                    } else {
                        Object obj2 = message.obj;
                        if (obj2 instanceof IPlayerConfig) {
                            PlayerPolicyImplement.this.onUnregister((IPlayerConfig) obj2);
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list = this.list;
        if (list == null || iPlayerConfig == null) {
            return;
        }
        list.add(iPlayerConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnregister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list = this.list;
        if (list == null || iPlayerConfig == null) {
            return;
        }
        list.remove(iPlayerConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateConfig() {
        try {
            String processUrl = CommonUrlParamManager.getInstance().processUrl("http://mbd.baidu.com/playserver/ctlconf?");
            if (processUrl == null) {
                return;
            }
            Request build = new Request.Builder().url(processUrl).build();
            if (this.mOkHttpClient == null) {
                this.mOkHttpClient = new OkHttpClient();
            }
            this.mOkHttpClient.newCall(build).enqueue(new Callback() { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Log.d(PlayerPolicyImplement.TAG, "onFailure: ");
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    String string;
                    if (response != null) {
                        try {
                            if (response.body() == null || (string = response.body().string()) == null || string.isEmpty()) {
                                return;
                            }
                            PlayerPolicyImplement.this.notify(string);
                            try {
                                PlayerPolicyImplement.this.mUpdateInterval = new JSONObject(string).getJSONObject("bandwidth_config").getLong("update_interval");
                            } catch (Exception e2) {
                                Log.e(PlayerPolicyImplement.TAG, "Get json fail => ", e2);
                            }
                        } catch (IOException e3) {
                            Log.e(PlayerPolicyImplement.TAG, "onResponse: ", e3);
                        }
                    }
                }
            });
        } catch (Exception e2) {
            Log.e(TAG, "onUpdateConfig: ", e2);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void notify(final String str) {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.3
                @Override // java.lang.Runnable
                public void run() {
                    for (IPlayerConfig iPlayerConfig : PlayerPolicyImplement.this.list) {
                        if (iPlayerConfig != null) {
                            iPlayerConfig.update(str);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void register(IPlayerConfig iPlayerConfig) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 2, 0, 0, iPlayerConfig).sendToTarget();
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void start() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.mFirstUpdateTimeStamp == 0) {
            this.mFirstUpdateTimeStamp = currentTimeMillis;
        }
        boolean z = currentTimeMillis - this.mFirstUpdateTimeStamp < this.mUpdateInterval;
        boolean z2 = currentTimeMillis - this.mLastUpdateTimeStamp > this.mUpdateInterval;
        Log.e(TAG, "first period : " + z + " second period : " + z2);
        long j = this.mUpdateInterval;
        if (currentTimeMillis - this.mFirstUpdateTimeStamp < j || currentTimeMillis - this.mLastUpdateTimeStamp > j) {
            this.mLastUpdateTimeStamp = currentTimeMillis;
            this.mWorkHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void stop() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    handlerThread.getLooper().quitSafely();
                    return;
                } catch (NoSuchMethodError unused) {
                    this.mHandlerThread.getLooper().quit();
                    return;
                }
            }
            handlerThread.getLooper().quit();
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void unregister(IPlayerConfig iPlayerConfig) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 3, 0, 0, iPlayerConfig).sendToTarget();
        }
    }
}
