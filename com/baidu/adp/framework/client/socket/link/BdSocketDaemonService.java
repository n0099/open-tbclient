package com.baidu.adp.framework.client.socket.link;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ah;
import com.baidu.tieba.eh;
import com.baidu.tieba.wa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdSocketDaemonService extends BdBaseService {
    public static /* synthetic */ Interceptable $ic;
    public static wa sCallBack;
    public transient /* synthetic */ FieldHolder $fh;
    public ServiceConnection conn;
    public b myBinder;

    @Override // com.baidu.adp.base.BdBaseService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, intent, i, i2)) == null) {
            return 1;
        }
        return invokeLII.intValue;
    }

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSocketDaemonService a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            }
        }

        public a(BdSocketDaemonService bdSocketDaemonService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketDaemonService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSocketDaemonService;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (BdSocketDaemonService.sCallBack == null) {
                    BdSocketLinkService.startService(false, "restart");
                } else {
                    BdSocketDaemonService.sCallBack.onLinkServiceDisconnect();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Binder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSocketDaemonService a;

        public b(BdSocketDaemonService bdSocketDaemonService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSocketDaemonService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSocketDaemonService;
        }
    }

    public BdSocketDaemonService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.myBinder = new b(this);
        this.conn = new a(this);
    }

    public static void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ah.startService(BdBaseApplication.getInst().getApp(), new Intent(BdBaseApplication.getInst().getApp(), BdSocketDaemonService.class));
        }
    }

    public void bindServiceInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ah.bindService(this, new Intent(this, BdSocketLinkService.class), this.conn, 1);
        }
    }

    public static void setLinkServiceDisconnectCallBack(wa waVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, waVar) == null) {
            sCallBack = waVar;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return this.myBinder;
        }
        return (IBinder) invokeL.objValue;
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
                    eh statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
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
                eh statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-unbindService");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem);
            }
            Intent intent = new Intent();
            intent.setClass(this, BdSocketDaemonService.class);
            try {
                startService(intent);
            } catch (Exception unused2) {
                eh statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem2.b("loc", BdSocketDaemonService.class.getName() + "-onDestroy-startService");
                BdStatisticsManager.getInstance().debug("PARCEL_NULLPOINT", statsItem2);
            }
        }
    }
}
