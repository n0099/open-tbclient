package com.baidu.adp.plugin.install;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import c.a.e.h.g.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PluginInstallerService extends HighPriorityIntentService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_INSTALL = "com.baidu.adp.plugin.action.install";
    public static final String ACTION_UNINSTALL = "com.baidu.adp.plugin.action.uninstall";
    public static int APK_LIB_CPUABI_OFFSITE = 4;
    public static final String APK_LIB_DIR_PREFIX = "lib/";
    public static final String APK_LIB_SUFFIX = ".so";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler handler;
    public Messenger messenger;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PluginInstallerService f36322a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PluginInstallerService pluginInstallerService, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pluginInstallerService, looper};
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
            this.f36322a = pluginInstallerService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null || message.replyTo == null) {
                return;
            }
            Message message2 = new Message();
            try {
                message2.setData(message.getData());
                message.replyTo.send(message2);
            } catch (RemoteException e2) {
                BdLog.detailException(e2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-382870885, "Lcom/baidu/adp/plugin/install/PluginInstallerService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-382870885, "Lcom/baidu/adp/plugin/install/PluginInstallerService;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginInstallerService() {
        super(PluginInstallerService.class.getSimpleName());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.handler = new a(this, Looper.getMainLooper());
        this.messenger = new Messenger(this.handler);
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) ? this.messenger.getBinder() : (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            if (Build.VERSION.SDK_INT < 18) {
                startForeground(2147483646, new Notification());
            }
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService
    public void onHandleIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            d.p(intent);
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, intent, i2) == null) {
            super.onStart(intent, i2);
        }
    }

    @Override // com.baidu.adp.plugin.install.HighPriorityIntentService, android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, intent, i2, i3)) == null) {
            super.onStartCommand(intent, i2, i3);
            return 2;
        }
        return invokeLII.intValue;
    }
}
