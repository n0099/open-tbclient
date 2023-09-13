package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.da;
import com.baidu.tieba.dj;
import com.baidu.tieba.fj;
import com.baidu.tieba.gj;
import com.baidu.tieba.ja;
import com.baidu.tieba.jg;
import com.baidu.tieba.ka;
import com.baidu.tieba.lb;
import com.baidu.tieba.pa;
import com.baidu.tieba.qa;
import com.baidu.tieba.sa;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSocketLinkService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALLREADY;
    public static int BASE_ERROR_NO = -100001000;
    public static final int LINK_ERROR_CODE_CONNECT = -1001;
    public static final int LINK_ERROR_CODE_SERVICE = -1000;
    public static final String MODULE_NAME = "linkservice";
    public static final String REASON = "reason";
    public static final String RE_OPEN = "reopen";
    public static final int START_SERVICE_ERROR;
    public static final int STOP_RECONN;
    public static final int TIMEOUT_EVENT = 1;
    public static fj connCallback;
    public static pa connStateCallBack;
    public static boolean hasAbsoluteClose;
    public static boolean isAvailable;
    public static qa mCanOpenWebSocket;
    public static final Handler mHandler;
    public static sa reConnStra;
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceConnection conn;
    public ScreenOnBroadcastReciver mScreenOnBroadcastReciver;
    public d myBinder;

    /* loaded from: classes.dex */
    public class ScreenOnBroadcastReciver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSocketLinkService this$0;

        public ScreenOnBroadcastReciver(BdSocketLinkService bdSocketLinkService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketLinkService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdSocketLinkService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            da q;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "android.intent.action.SCREEN_ON".equals(intent.getAction()) && (q = MessageManager.getInstance().getSocketClient().q()) != null) {
                q.d("Screen on");
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                BdLog.w("tcp建立和握手超时");
                BdSocketLinkService.close(9, "connect timeout");
                BdSocketLinkService.reConnStra.e("tcp or websocket handshake timeout");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends fj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.a(str);
            }
        }

        @Override // com.baidu.tieba.cj
        public void c(yi yiVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yiVar) == null) && BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.c(yiVar);
            }
        }

        @Override // com.baidu.tieba.cj
        public void f(gj gjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, gjVar) == null) && BdSocketLinkService.connStateCallBack != null) {
                BdSocketLinkService.connStateCallBack.d(gjVar);
            }
        }

        @Override // com.baidu.tieba.fj, com.baidu.tieba.cj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ka.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onClose", i, str);
                if (i == 6 || i == 5 || i == 2 || i == 3 || i == 4) {
                    ka.d();
                }
                BdSocketLinkService.mHandler.removeMessages(1);
                boolean z = false;
                if (BdSocketLinkService.connStateCallBack != null) {
                    z = BdSocketLinkService.connStateCallBack.b(i, null);
                }
                if (!z && i != 1 && BdUtilHelper.isNetOk()) {
                    sa saVar = BdSocketLinkService.reConnStra;
                    saVar.e("onClose:" + i + ":" + str);
                }
            }
        }

        @Override // com.baidu.tieba.cj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                ka.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onOpen", 0, "LinkService:onOpen");
                ka.d();
                BdSocketLinkService.mHandler.removeMessages(1);
                if (BdSocketLinkService.connStateCallBack != null) {
                    BdSocketLinkService.connStateCallBack.g(map);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSocketLinkService a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            }
        }

        public c(BdSocketLinkService bdSocketLinkService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketLinkService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSocketLinkService;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                BdSocketDaemonService.startService();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends Binder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSocketLinkService a;

        public d(BdSocketLinkService bdSocketLinkService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketLinkService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSocketLinkService;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62450737, "Lcom/baidu/adp/framework/client/socket/link/BdSocketLinkService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(62450737, "Lcom/baidu/adp/framework/client/socket/link/BdSocketLinkService;");
                return;
            }
        }
        START_SERVICE_ERROR = (-100001000) - 3;
        ALLREADY = (-100001000) - 4;
        STOP_RECONN = (-100001000) - 5;
        reConnStra = new sa();
        isAvailable = true;
        hasAbsoluteClose = false;
        mHandler = new a(Looper.getMainLooper());
        connCallback = new b();
    }

    public BdSocketLinkService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.myBinder = new d(this);
        this.conn = new c(this);
    }

    public static boolean hasAbsoluteClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return hasAbsoluteClose;
        }
        return invokeV.booleanValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            dj.h().l(ja.d(), ja.a(), null, ja.b());
            dj.h().c(connCallback);
        }
    }

    public static boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return isAvailable;
        }
        return invokeV.booleanValue;
    }

    public static boolean isClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (!dj.h().j() && !dj.h().m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return dj.h().j();
        }
        return invokeV.booleanValue;
    }

    private void registerScreenOnBroadcastReciver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            try {
                this.mScreenOnBroadcastReciver = new ScreenOnBroadcastReciver(this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                registerReceiver(this.mScreenOnBroadcastReciver, intentFilter);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    private void unRegisterScreenOnBroadcastReciver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            try {
                if (this.mScreenOnBroadcastReciver != null) {
                    unregisterReceiver(this.mScreenOnBroadcastReciver);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void bindServiceInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jg.bindService(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
        }
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return dj.h().i();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onCreate();
            if (Build.VERSION.SDK_INT < 18) {
                try {
                    startForeground(2147483646, new Notification());
                } catch (Exception unused) {
                }
            }
            registerScreenOnBroadcastReciver();
            bindServiceInternal();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            close("service onDestroy");
            unRegisterScreenOnBroadcastReciver();
        }
    }

    public static void close(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65541, null, i, str) == null) && !isClose()) {
            ka.a(MODULE_NAME, 0, 0, "close", i, str);
            ka.d();
            mHandler.removeMessages(1);
            dj.h().f(i, str);
        }
    }

    public static void close(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            close(1, str);
        }
    }

    public static void setAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            isAvailable = z;
        }
    }

    public static void setCanOpenWebSocket(qa qaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, qaVar) == null) {
            mCanOpenWebSocket = qaVar;
        }
    }

    public static void setConnStateCallBack(pa paVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, paVar) == null) {
            connStateCallBack = paVar;
        }
    }

    public static void setHasAbsoluteClose(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("manual close socketLink");
            if (z) {
                str = "close";
            } else {
                str = "open";
            }
            sb.append(str);
            BdLog.d(sb.toString());
            hasAbsoluteClose = z;
        }
    }

    public static void stopReConnStrategy(String str) {
        sa saVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, null, str) == null) && (saVar = reConnStra) != null) {
            saVar.f(str);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            return this.myBinder;
        }
        return (IBinder) invokeL.objValue;
    }

    private boolean open(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            ka.a(MODULE_NAME, 0, 0, "open", 0, str);
            BdLog.w("启动连接");
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, lb.c().b().b());
            try {
                return dj.h().o();
            } catch (Throwable th) {
                connCallback.b(-1001, "open error");
                BdLog.e(th.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean sendMessage(yi yiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, yiVar)) == null) {
            if (yiVar != null && dj.h().j() && dj.h().i()) {
                return dj.h().p(yiVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void startService(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(65555, null, z, str) != null) || hasAbsoluteClose() || !isAvailable()) {
            return;
        }
        try {
            Intent intent = new Intent(BdBaseApplication.getInst().getApp(), BdSocketLinkService.class);
            intent.putExtra(RE_OPEN, z);
            intent.putExtra("reason", str);
            if (BdBaseApplication.getInst().getApp().startService(intent) == null) {
                connCallback.b(-1000, "startService error");
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            connCallback.b(-1000, "startService error");
            ka.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e.getMessage());
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, intent, i) == null) {
            super.onStart(intent, i);
            qa qaVar = mCanOpenWebSocket;
            if (qaVar != null && !qaVar.canOpenWebSocket()) {
                close("exit app");
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra == null) {
                    stringExtra = "--";
                }
                if (intent.getBooleanExtra(RE_OPEN, false)) {
                    BdLog.w("进行重连" + stringExtra);
                    close(stringExtra);
                    open(stringExtra);
                } else if (!dj.h().j() && !dj.h().m()) {
                    BdLog.w("进行连接" + stringExtra);
                    close(stringExtra);
                    open(stringExtra);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i, i2)) == null) {
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
