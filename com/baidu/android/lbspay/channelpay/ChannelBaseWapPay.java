package com.baidu.android.lbspay.channelpay;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.activity.WapPayActivity;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class ChannelBaseWapPay extends AbstractChannelPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChannelBaseWapPay() {
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

    public abstract String getUrl(GetPayContent getPayContent);

    @Override // com.baidu.android.lbspay.channelpay.AbstractChannelPay, com.baidu.android.lbspay.channelpay.IChannelPay
    public void pay(Activity activity, GetPayContent getPayContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, getPayContent) == null) {
            super.pay(activity, getPayContent);
            String url = getUrl(getPayContent);
            if (TextUtils.isEmpty(url)) {
                return;
            }
            Intent intent = new Intent(activity, WapPayActivity.class);
            intent.putExtra(WapPayActivity.URL, url);
            activity.startActivityForResult(intent, 99);
        }
    }
}
