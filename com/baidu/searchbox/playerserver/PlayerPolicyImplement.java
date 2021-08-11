package com.baidu.searchbox.playerserver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class PlayerPolicyImplement implements IPlayerPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADD_OBSERVER_WORK_MSG = 2;
    public static final int JELLY_BEAN_MR2 = 18;
    public static final int REMOVE_OBSERVER_WORK_MSG = 3;
    public static final String TAG = "PlayerServer-PlcyImplmnt";
    public static final int TIMER_UPDATE_WORK_MSG = 1;
    public static final int UPDATE_CONFIG_MAIN_MSG = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String PLAYER_SERVER;
    public List<IPlayerConfig> list;
    public long mFirstUpdateTimeStamp;
    public HandlerThread mHandlerThread;
    public long mLastUpdateTimeStamp;
    public Handler mMainHandler;
    public OkHttpClient mOkHttpClient;
    public long mUpdateInterval;
    public Handler mWorkHandler;

    public PlayerPolicyImplement() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.PLAYER_SERVER = "http://mbd.baidu.com/playserver/ctlconf?";
        this.mWorkHandler = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mHandlerThread = null;
        this.list = Collections.synchronizedList(new LinkedList());
        this.mUpdateInterval = 3000L;
        this.mLastUpdateTimeStamp = 0L;
        this.mFirstUpdateTimeStamp = 0L;
        this.mOkHttpClient = null;
        HandlerThread handlerThread = new HandlerThread("player_policy_implement");
        this.mHandlerThread = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.mWorkHandler = new Handler(this, this.mHandlerThread.getLooper()) { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PlayerPolicyImplement this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((Looper) newInitContext2.callArgs[0]);
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        int i4 = message.what;
                        if (i4 == 1) {
                            this.this$0.onUpdateConfig();
                        } else if (i4 == 2) {
                            Object obj = message.obj;
                            if (obj instanceof IPlayerConfig) {
                                this.this$0.onRegister((IPlayerConfig) obj);
                            }
                        } else if (i4 != 3) {
                        } else {
                            Object obj2 = message.obj;
                            if (obj2 instanceof IPlayerConfig) {
                                this.this$0.onUnregister((IPlayerConfig) obj2);
                            }
                        }
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, iPlayerConfig) == null) || (list = this.list) == null || iPlayerConfig == null) {
            return;
        }
        list.add(iPlayerConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnregister(IPlayerConfig iPlayerConfig) {
        List<IPlayerConfig> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, iPlayerConfig) == null) || (list = this.list) == null || iPlayerConfig == null) {
            return;
        }
        list.remove(iPlayerConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            try {
                String processUrl = CommonUrlParamManager.getInstance().processUrl("http://mbd.baidu.com/playserver/ctlconf?");
                if (processUrl == null) {
                    return;
                }
                Request build = new Request.Builder().url(processUrl).build();
                if (this.mOkHttpClient == null) {
                    this.mOkHttpClient = new OkHttpClient();
                }
                this.mOkHttpClient.newCall(build).enqueue(new Callback(this) { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PlayerPolicyImplement this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException iOException) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, call, iOException) == null) {
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) {
                        String string;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) || response == null) {
                            return;
                        }
                        try {
                            if (response.body() == null || (string = response.body().string()) == null || string.isEmpty()) {
                                return;
                            }
                            this.this$0.notify(string);
                            this.this$0.mUpdateInterval = new JSONObject(string).getJSONObject("bandwidth_config").getLong("update_interval");
                        } catch (IOException | Exception unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void notify(String str) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (handler = this.mMainHandler) == null) {
            return;
        }
        handler.post(new Runnable(this, str) { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlayerPolicyImplement this$0;
            public final /* synthetic */ String val$theJson;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$theJson = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    for (IPlayerConfig iPlayerConfig : this.this$0.list) {
                        if (iPlayerConfig != null) {
                            iPlayerConfig.update(this.val$theJson);
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void register(IPlayerConfig iPlayerConfig) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iPlayerConfig) == null) || (handler = this.mWorkHandler) == null) {
            return;
        }
        Message.obtain(handler, 2, 0, 0, iPlayerConfig).sendToTarget();
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.mFirstUpdateTimeStamp == 0) {
                this.mFirstUpdateTimeStamp = currentTimeMillis;
            }
            String str = "first period : " + (currentTimeMillis - this.mFirstUpdateTimeStamp < this.mUpdateInterval) + " second period : " + (currentTimeMillis - this.mLastUpdateTimeStamp > this.mUpdateInterval);
            long j2 = this.mUpdateInterval;
            if (currentTimeMillis - this.mFirstUpdateTimeStamp < j2 || currentTimeMillis - this.mLastUpdateTimeStamp > j2) {
                this.mLastUpdateTimeStamp = currentTimeMillis;
                this.mWorkHandler.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void stop() {
        HandlerThread handlerThread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (handlerThread = this.mHandlerThread) == null) {
            return;
        }
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

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void unregister(IPlayerConfig iPlayerConfig) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iPlayerConfig) == null) || (handler = this.mWorkHandler) == null) {
            return;
        }
        Message.obtain(handler, 3, 0, 0, iPlayerConfig).sendToTarget();
    }
}
