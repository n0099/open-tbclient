package com.baidu.payment;

import android.app.Activity;
import com.baidu.poly.wallet.paychannel.IChannelAuth;
import com.baidu.tieba.fh1;
import com.baidu.tieba.og1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PaymentAliChannelAuth implements IChannelAuth {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PaymentAliChannelAuth() {
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

    @Override // com.baidu.poly.wallet.paychannel.IChannelAuth
    public void aLiAuth(Activity activity, String str, fh1<JSONObject> fh1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, fh1Var) == null) {
            og1.a().aLiAuth(activity, str, fh1Var);
        }
    }
}
