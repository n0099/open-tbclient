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
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aa;
import com.repackage.ba;
import com.repackage.ga;
import com.repackage.gb;
import com.repackage.ha;
import com.repackage.ja;
import com.repackage.jj;
import com.repackage.oi;
import com.repackage.oj;
import com.repackage.qg;
import com.repackage.qj;
import com.repackage.rj;
import com.repackage.u9;
import com.repackage.ug;
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
    public static qj connCallback;
    public static ga connStateCallBack;
    public static boolean hasAbsoluteClose;
    public static boolean isAvailable;
    public static ha mCanOpenWebSocket;
    public static final Handler mHandler;
    public static ja reConnStra;
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
            u9 q;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || !"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (q = MessageManager.getInstance().getSocketClient().q()) == null) {
                return;
            }
            q.d("Screen on");
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
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
    public static class b extends qj {
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

        @Override // com.repackage.nj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.a(str);
        }

        @Override // com.repackage.qj, com.repackage.nj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ba.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onClose", i, str);
                if (i == 6 || i == 5 || i == 2 || i == 3 || i == 4) {
                    ba.d();
                }
                BdSocketLinkService.mHandler.removeMessages(1);
                if ((BdSocketLinkService.connStateCallBack != null ? BdSocketLinkService.connStateCallBack.b(i, null) : false) || i == 1 || !oi.C()) {
                    return;
                }
                ja jaVar = BdSocketLinkService.reConnStra;
                jaVar.e("onClose:" + i + ":" + str);
            }
        }

        @Override // com.repackage.nj
        public void c(jj jjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jjVar) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.c(jjVar);
        }

        @Override // com.repackage.nj
        public void f(rj rjVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, rjVar) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.d(rjVar);
        }

        @Override // com.repackage.nj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                ba.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onOpen", 0, "LinkService:onOpen");
                ba.d();
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
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            }
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
        reConnStra = new ja();
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

    public static void close(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            close(1, str);
        }
    }

    public static boolean hasAbsoluteClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? hasAbsoluteClose : invokeV.booleanValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            oj.j().r(aa.d(), aa.a(), null, aa.b());
            oj.j().c(connCallback);
        }
    }

    public static boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? isAvailable : invokeV.booleanValue;
    }

    public static boolean isClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (oj.j().l() || oj.j().s()) ? false : true : invokeV.booleanValue;
    }

    public static boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? oj.j().l() : invokeV.booleanValue;
    }

    private boolean open(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            ba.a(MODULE_NAME, 0, 0, "open", 0, str);
            BdLog.w("启动连接");
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, gb.c().b().b());
            try {
                return oj.j().u();
            } catch (Throwable th) {
                connCallback.b(-1001, "open error");
                BdLog.e(th.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
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

    public static boolean sendMessage(jj jjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jjVar)) == null) {
            if (jjVar != null && oj.j().l() && oj.j().k()) {
                return oj.j().v(jjVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void setAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            isAvailable = z;
        }
    }

    public static void setCanOpenWebSocket(ha haVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, haVar) == null) {
            mCanOpenWebSocket = haVar;
        }
    }

    public static void setConnStateCallBack(ga gaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, gaVar) == null) {
            connStateCallBack = gaVar;
        }
    }

    public static void setHasAbsoluteClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("manual close socketLink");
            sb.append(z ? "close" : "open");
            BdLog.d(sb.toString());
            hasAbsoluteClose = z;
        }
    }

    public static void startService(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65555, null, z, str) == null) && !hasAbsoluteClose() && isAvailable()) {
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
                ba.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e.getMessage());
            }
        }
    }

    public static void stopReConnStrategy(String str) {
        ja jaVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, str) == null) || (jaVar = reConnStra) == null) {
            return;
        }
        jaVar.f(str);
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
            qg.bindService(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
        }
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? oj.j().k() : invokeV.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) ? this.myBinder : (IBinder) invokeL.objValue;
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
                    ug statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.b("loc", BdSocketLinkService.class.getName() + "-onCreate-startForeground");
                    BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
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

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, intent, i) == null) {
            super.onStart(intent, i);
            ha haVar = mCanOpenWebSocket;
            if (haVar != null && !haVar.canOpenWebSocket()) {
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
                } else if (oj.j().l() || oj.j().s()) {
                } else {
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i, i2)) == null) ? super.onStartCommand(intent, i, i2) : invokeLII.intValue;
    }

    public static void close(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65541, null, i, str) == null) || isClose()) {
            return;
        }
        ba.a(MODULE_NAME, 0, 0, "close", i, str);
        ba.d();
        mHandler.removeMessages(1);
        oj.j().f(i, str);
    }
}
