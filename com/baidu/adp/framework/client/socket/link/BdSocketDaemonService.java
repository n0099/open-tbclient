package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import b.a.e.c.e.c.k.c;
import b.a.e.f.m.f;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BdSocketDaemonService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static c sCallBack;
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceConnection conn;
    public b myBinder;

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(BdSocketDaemonService bdSocketDaemonService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketDaemonService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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
                if (BdSocketDaemonService.sCallBack != null) {
                    BdSocketDaemonService.sCallBack.a();
                } else {
                    BdSocketLinkService.startService(false, "restart");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Binder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(BdSocketDaemonService bdSocketDaemonService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketDaemonService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public BdSocketDaemonService() {
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
        this.myBinder = new b(this);
        this.conn = new a(this);
    }

    public static void setLinkServiceDisconnectCallBack(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            sCallBack = cVar;
        }
    }

    public static void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f.startService(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
        }
    }

    public void bindServiceInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.bindService(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? this.myBinder : (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onCreate();
            if (Build.VERSION.SDK_INT < 18) {
                try {
                    startForeground(2147483646, new Notification());
                } catch (Exception unused) {
                    b.a.e.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.b("loc", BdSocketDaemonService.class.getName() + "-onCreate-startForeground");
                    BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
                }
            }
            bindServiceInternal();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            try {
                unbindService(this.conn);
            } catch (Exception unused) {
                b.a.e.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-unbindService");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
            Intent intent = new Intent();
            intent.setClass(this, BdSocketDaemonService.class);
            try {
                startService(intent);
            } catch (Exception unused2) {
                b.a.e.f.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem2.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-startService");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, intent, i2, i3)) == null) {
            return 1;
        }
        return invokeLII.intValue;
    }
}
