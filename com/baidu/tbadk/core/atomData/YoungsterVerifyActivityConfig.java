package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class YoungsterVerifyActivityConfig extends TbWebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAMA_AUTH_ID = "authid";
    public static final String PARAMA_SCENE = "scene";
    public static final String PARAMA_TIEBA_AUTH = "tieba_auth";
    public static final String VERIFY_URL_PREFIX = "https://wappass.baidu.com/v6/authwidget?adapter=3&clientfrom=wap&tpl=tieba&u=";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoungsterVerifyActivityConfig(Context context, String str, String str2, boolean z) {
        super(context, str, str2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String getYoungsterVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                String encode = URLEncoder.encode(TbConfig.SERVER_ADDRESS + TbConfig.URL_YOUNGSTER_VERIFY_AUTHID, IMAudioTransRequest.CHARSET);
                return VERIFY_URL_PREFIX + encode + "&scene=" + PARAMA_TIEBA_AUTH;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public void setKeyYoungsterPasswordFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            getIntent().putExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, i);
        }
    }
}
