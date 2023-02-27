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
    public static final int MAX_RETRY_COUNT = 1;
    public static final int MIN_UPDATE_INTERVAL = 10;
    public static final String PLAYER_SERVER = "https://mbd.baidu.com/playserver/ctlconf?";
    public static final int REMOVE_OBSERVER_WORK_MSG = 3;
    public static final String TAG = "PlayerServer-PlcyImplmnt";
    public static final int TIMER_UPDATE_WORK_MSG = 1;
    public HandlerThread mHandlerThread;
    public Handler mWorkHandler;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public List<IPlayerConfig> list = Collections.synchronizedList(new LinkedList());
    public long mUpdateInterval = 180;
    public volatile int mRequested = 0;
    public volatile int mPullCfgSuccessfully = 0;
    public volatile long mRetryCount = 0;
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
                    long j;
                    int i = message.what;
                    if (i == 1) {
                        PlayerPolicyImplement.this.onUpdateConfig();
                        if (PlayerPolicyImplement.access$104(PlayerPolicyImplement.this) > 1) {
                            PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                        }
                        if (PlayerPolicyImplement.this.mPullCfgSuccessfully != 0) {
                            j = PlayerPolicyImplement.this.mUpdateInterval;
                        } else {
                            j = 10;
                        }
                        sendEmptyMessageDelayed(1, j * 1000);
                    } else if (i != 2) {
                        if (i == 3) {
                            Object obj = message.obj;
                            if (!(obj instanceof IPlayerConfig)) {
                                return;
                            }
                            PlayerPolicyImplement.this.onUnregister((IPlayerConfig) obj);
                        }
                    } else {
                        Object obj2 = message.obj;
                        if (!(obj2 instanceof IPlayerConfig)) {
                            return;
                        }
                        PlayerPolicyImplement.this.onRegister((IPlayerConfig) obj2);
                    }
                }
            };
        }
    }

    public static /* synthetic */ long access$104(PlayerPolicyImplement playerPolicyImplement) {
        long j = playerPolicyImplement.mRetryCount + 1;
        playerPolicyImplement.mRetryCount = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list = this.list;
        if (list != null && iPlayerConfig != null) {
            list.add(iPlayerConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnregister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list = this.list;
        if (list != null && iPlayerConfig != null) {
            list.remove(iPlayerConfig);
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
    public void unregister(IPlayerConfig iPlayerConfig) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 3, 0, 0, iPlayerConfig).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateConfig() {
        try {
            String processUrl = CommonUrlParamManager.getInstance().processUrl(PLAYER_SERVER);
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
                    PlayerPolicyImplement.this.mPullCfgSuccessfully = 0;
                    if (response != null) {
                        try {
                            if (response.body() != null && (string = response.body().string()) != null && !string.isEmpty()) {
                                PlayerPolicyImplement.this.notify(string);
                                try {
                                    JSONObject jSONObject = new JSONObject(string);
                                    if (jSONObject.getInt("errno") == 0) {
                                        PlayerPolicyImplement.this.mUpdateInterval = jSONObject.getJSONObject("bandwidth_config").getLong("update_interval");
                                        PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                                        PlayerPolicyImplement.this.mRetryCount = 0L;
                                    }
                                } catch (Exception e) {
                                    Log.e(PlayerPolicyImplement.TAG, "Get json fail => ", e);
                                }
                            }
                        } catch (IOException e2) {
                            Log.e(PlayerPolicyImplement.TAG, "onResponse: ", e2);
                        }
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "onUpdateConfig: ", e);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void start() {
        if (this.mRequested == 0) {
            this.mRequested = 1;
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
}
