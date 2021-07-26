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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.c.e.c.i;
import d.a.d.e.m.f;
import d.a.d.e.p.l;
import d.a.d.e.r.h;
import d.a.d.e.r.j;
import d.a.d.e.r.k;
import java.util.Map;
/* loaded from: classes.dex */
public class BdSocketLinkService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALLREADY;
    public static int BASE_ERROR_NO = -100001000;
    public static final int BEGIN_OPEN;
    public static final int CONNECT_OPEN;
    public static final int LINK_ERROR_CODE_CONNECT = -1001;
    public static final int LINK_ERROR_CODE_SERVICE = -1000;
    public static final String MODULE_NAME = "linkservice";
    public static final String REASON = "reason";
    public static final String RE_OPEN = "reopen";
    public static final int START_SERVICE_ERROR;
    public static final int STOP_RECONN;
    public static final int TIMEOUT_EVENT = 1;
    public static j connCallback;
    public static d.a.d.c.e.c.k.a connStateCallBack;
    public static boolean hasAbsoluteClose;
    public static boolean isAvailable;
    public static d.a.d.c.e.c.k.b mCanOpenWebSocket;
    public static final Handler mHandler;
    public static d.a.d.c.e.c.k.d reConnStra;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdSocketLinkService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.a.d.c.e.c.b r;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || !"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (r = MessageManager.getInstance().getSocketClient().r()) == null) {
                return;
            }
            r.d("Screen on");
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    public static class b extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.d.e.r.g
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.a(str);
        }

        @Override // d.a.d.e.r.j, d.a.d.e.r.g
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onClose", i2, str);
                if (i2 == 6 || i2 == 5 || i2 == 2 || i2 == 3 || i2 == 4) {
                    i.d();
                }
                BdSocketLinkService.mHandler.removeMessages(1);
                if ((BdSocketLinkService.connStateCallBack != null ? BdSocketLinkService.connStateCallBack.b(i2, null) : false) || i2 == 1 || !l.D()) {
                    return;
                }
                d.a.d.c.e.c.k.d dVar = BdSocketLinkService.reConnStra;
                dVar.e("onClose:" + i2 + ":" + str);
            }
        }

        @Override // d.a.d.e.r.g
        public void c(d.a.d.e.r.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.c(cVar);
        }

        @Override // d.a.d.e.r.g
        public void f(k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, kVar) == null) || BdSocketLinkService.connStateCallBack == null) {
                return;
            }
            BdSocketLinkService.connStateCallBack.d(kVar);
        }

        @Override // d.a.d.e.r.g
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
                i.a(BdSocketLinkService.MODULE_NAME, 0, 0, "onOpen", 0, "LinkService:onOpen");
                i.d();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSocketLinkService f2173e;

        public c(BdSocketLinkService bdSocketLinkService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketLinkService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2173e = bdSocketLinkService;
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdSocketLinkService f2174e;

        public d(BdSocketLinkService bdSocketLinkService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketLinkService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2174e = bdSocketLinkService;
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
        CONNECT_OPEN = (-100001000) - 1;
        BEGIN_OPEN = (-100001000) - 2;
        START_SERVICE_ERROR = (-100001000) - 3;
        ALLREADY = (-100001000) - 4;
        STOP_RECONN = (-100001000) - 5;
        reConnStra = new d.a.d.c.e.c.k.d();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
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
            h.j().r(d.a.d.c.e.c.h.d(), d.a.d.c.e.c.h.a(), null, d.a.d.c.e.c.h.b());
            h.j().c(connCallback);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? (h.j().l() || h.j().s()) ? false : true : invokeV.booleanValue;
    }

    public static boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? h.j().l() : invokeV.booleanValue;
    }

    private boolean open(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            i.a(MODULE_NAME, 0, 0, "open", 0, str);
            BdLog.w("启动连接");
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, d.a.d.c.j.c.c().b().b());
            try {
                return h.j().u();
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
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static boolean sendMessage(d.a.d.e.r.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cVar)) == null) {
            if (cVar != null && h.j().l() && h.j().k()) {
                return h.j().v(cVar);
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

    public static void setCanOpenWebSocket(d.a.d.c.e.c.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, bVar) == null) {
            mCanOpenWebSocket = bVar;
        }
    }

    public static void setConnStateCallBack(d.a.d.c.e.c.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, aVar) == null) {
            connStateCallBack = aVar;
        }
    }

    public static void setHasAbsoluteClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, null, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("manual close socketLink");
            sb.append(z ? IntentConfig.CLOSE : "open");
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
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                connCallback.b(-1000, "startService error");
                i.a(MODULE_NAME, 0, 0, "startService_exception", START_SERVICE_ERROR, e2.getMessage());
            }
        }
    }

    public static void stopReConnStrategy(String str) {
        d.a.d.c.e.c.k.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, null, str) == null) || (dVar = reConnStra) == null) {
            return;
        }
        dVar.f(str);
    }

    private void unRegisterScreenOnBroadcastReciver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            try {
                if (this.mScreenOnBroadcastReciver != null) {
                    unregisterReceiver(this.mScreenOnBroadcastReciver);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public void bindServiceInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.a(this, new Intent(this, BdSocketDaemonService.class), this.conn, 1);
        }
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h.j().k() : invokeV.booleanValue;
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
                    d.a.d.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
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
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, intent, i2) == null) {
            super.onStart(intent, i2);
            d.a.d.c.e.c.k.b bVar = mCanOpenWebSocket;
            if (bVar != null && !bVar.a()) {
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
                } else if (h.j().l() || h.j().s()) {
                } else {
                    BdLog.w("进行连接" + stringExtra);
                    close(stringExtra);
                    open(stringExtra);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, intent, i2, i3)) == null) ? super.onStartCommand(intent, i2, i3) : invokeLII.intValue;
    }

    public static void close(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str) == null) || isClose()) {
            return;
        }
        i.a(MODULE_NAME, 0, 0, IntentConfig.CLOSE, i2, str);
        i.d();
        mHandler.removeMessages(1);
        h.j().f(i2, str);
    }
}
