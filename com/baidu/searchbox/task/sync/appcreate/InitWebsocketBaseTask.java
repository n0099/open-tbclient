package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ea;
import com.repackage.fe5;
import com.repackage.ja;
import com.repackage.kb;
import com.repackage.la;
import com.repackage.lb5;
import com.repackage.ma;
import com.repackage.q05;
import com.repackage.ra5;
import com.repackage.u05;
import com.repackage.w05;
import com.repackage.x05;
import com.repackage.y05;
import com.repackage.z55;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class InitWebsocketBaseTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitWebsocketBaseTask() {
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

    public static void initSocket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            lb5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
            registerImScoketTask.setPriority(-3);
            registerImScoketTask.e(false);
            registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
            registerImScoketTask.setNeedEncrypt(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
            arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
            new UseHttpdnsSdkSwitch();
            if (UseHttpdnsSdkSwitch.isOn()) {
                ea.h(TiebaIMConfig.url);
            } else {
                String h = q05.f().h();
                if (TextUtils.isEmpty(h)) {
                    ea.h(TiebaIMConfig.url);
                } else {
                    ea.h(h);
                }
            }
            ea.e(TiebaIMConfig.wsExtensions);
            ea.f(arrayList);
            BdSocketDaemonService.setLinkServiceDisconnectCallBack(new ma() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.repackage.ma
                public void onLinkServiceDisconnect() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        fe5.e().c(new fe5.b(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$0;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.repackage.fe5.b
                            public void onResult(boolean z) {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) || z) {
                                    return;
                                }
                                z55.b(0, 0, 0, 1, 8);
                                BdSocketLinkService.startService(false, "restart");
                            }
                        });
                    }
                }
            });
            BdSocketLinkService.init();
            z55.b(0, 0, 0, 1, 9);
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                BdSocketLinkService.startService(false, "TiebaImApplication init");
            }
        }
    }

    private void initWebsocketBase() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BdSocketLinkService.setAvailable(true);
            BdSocketLinkService.setCanOpenWebSocket(new la(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitWebsocketBaseTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.repackage.la
                public boolean canOpenWebSocket() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? !TbadkCoreApplication.getInst().isExitAppCloseWebSocket() : invokeV.booleanValue;
                }
            });
            int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
            if (imTimeOut != null && imTimeOut.length == 3) {
                kb.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
            }
            int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
            if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
                ea.g(socketReconnStratgy);
            }
            u05.j().k();
            MessageManager.getInstance().getSocketClient().G(u05.j());
            MessageManager.getInstance().addResponsedMessageRule(new y05());
            try {
                ja.a().d(TiebaIMConfig.getRSAPublicKey());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            x05.j().k();
            w05.y().z();
            initSocket();
            ra5.b().s(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static lb5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            lb5 lb5Var = new lb5(i);
            lb5Var.setResponsedClass(cls);
            lb5Var.h(z);
            lb5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(lb5Var);
            return lb5Var;
        }
        return (lb5) invokeCommon.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initWebsocketBase();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitWebsocketBase" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
