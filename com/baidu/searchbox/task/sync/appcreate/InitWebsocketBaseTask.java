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
import com.baidu.tieba.ab;
import com.baidu.tieba.bc;
import com.baidu.tieba.cb;
import com.baidu.tieba.db;
import com.baidu.tieba.dh5;
import com.baidu.tieba.i55;
import com.baidu.tieba.jg5;
import com.baidu.tieba.m55;
import com.baidu.tieba.o55;
import com.baidu.tieba.p55;
import com.baidu.tieba.q55;
import com.baidu.tieba.sa5;
import com.baidu.tieba.va;
import com.baidu.tieba.wj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class InitWebsocketBaseTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initWebsocketBase();
        }
    }

    public static void initSocket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            dh5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
            registerImScoketTask.setPriority(-3);
            registerImScoketTask.e(false);
            registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
            registerImScoketTask.setNeedEncrypt(false);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
            arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
            new UseHttpdnsSdkSwitch();
            if (UseHttpdnsSdkSwitch.isOn()) {
                va.h(TiebaIMConfig.url);
            } else {
                String h = i55.f().h();
                if (TextUtils.isEmpty(h)) {
                    va.h(TiebaIMConfig.url);
                } else {
                    va.h(h);
                }
            }
            va.e(TiebaIMConfig.wsExtensions);
            va.f(arrayList);
            BdSocketDaemonService.setLinkServiceDisconnectCallBack(new db() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
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

                @Override // com.baidu.tieba.db
                public void onLinkServiceDisconnect() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        wj5.e().c(new wj5.b(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2.1
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

                            @Override // com.baidu.tieba.wj5.b
                            public void onResult(boolean z) {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) && !z) {
                                    sa5.b(0, 0, 0, 1, 8);
                                    BdSocketLinkService.startService(false, "restart");
                                }
                            }
                        });
                    }
                }
            });
            BdSocketLinkService.init();
            sa5.b(0, 0, 0, 1, 9);
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
            BdSocketLinkService.setCanOpenWebSocket(new cb(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
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

                @Override // com.baidu.tieba.cb
                public boolean canOpenWebSocket() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
                    }
                    return invokeV.booleanValue;
                }
            });
            int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
            if (imTimeOut != null && imTimeOut.length == 3) {
                bc.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
            }
            int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
            if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
                va.g(socketReconnStratgy);
            }
            m55.j().k();
            MessageManager.getInstance().getSocketClient().G(m55.j());
            MessageManager.getInstance().addResponsedMessageRule(new q55());
            try {
                ab.a().d(TiebaIMConfig.getRSAPublicKey());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            p55.j().k();
            o55.y().z();
            initSocket();
            jg5.b().s(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public static dh5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            dh5 dh5Var = new dh5(i);
            dh5Var.setResponsedClass(cls);
            dh5Var.h(z);
            dh5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(dh5Var);
            return dh5Var;
        }
        return (dh5) invokeCommon.objValue;
    }
}
