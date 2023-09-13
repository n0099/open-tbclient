package com.baidu.tbadk.clientConfig;

import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.a05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes4.dex */
public class ClientConfigModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a05 a;
    public final NetMessageListener b;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClientConfigModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ClientConfigModel clientConfigModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {clientConfigModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = clientConfigModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (!this.a.P(responsedMessage)) {
                    if (this.a.a != null) {
                        this.a.a.onError("");
                    }
                } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                        this.a.Q(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                    } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                        this.a.Q(((ClientConfigSocketResponse) responsedMessage).getData());
                    } else if (this.a.a != null) {
                        this.a.a.onError("");
                    }
                } else {
                    String errorString = responsedMessage.getErrorString();
                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e40);
                    if (StringUtils.isNull(errorString)) {
                        errorString = string;
                    }
                    if (this.a.a != null) {
                        this.a.a.onError(errorString);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientConfigModel(BdBaseFragmentActivity<?> bdBaseFragmentActivity, a05 a05Var) {
        super(bdBaseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdBaseFragmentActivity, a05Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.b = aVar;
        this.a = a05Var;
        registerListener(aVar);
    }

    public final boolean P(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, responsedMessage)) == null) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void Q(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            if (dataRes == null) {
                if (this.a != null) {
                    this.a.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
                    return;
                }
                return;
            }
            a05 a05Var = this.a;
            if (a05Var != null) {
                a05Var.a(dataRes);
            }
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
            clientConfigNetMessage.setType(str);
            sendMessage(clientConfigNetMessage);
        }
    }
}
