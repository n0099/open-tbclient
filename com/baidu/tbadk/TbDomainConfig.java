package com.baidu.tbadk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class TbDomainConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOMAIN_HTTPS_BAIDU = "http://www.baidu.com/";
    public static final String DOMAIN_HTTPS_BCS_CDN = "http://bcscdn.baidu.com/";
    public static final String DOMAIN_HTTPS_GSP = "https://gsp0.baidu.com/";
    public static final String DOMAIN_HTTPS_IMAGE_SRC = "http://imgsrc.baidu.com/";
    public static final String DOMAIN_HTTPS_MOBILE_BAIDU = "http://m.baidu.com/";
    public static final String DOMAIN_HTTPS_QUICK_WEBVIEW_ADDRESS = "https://tieba.baidu.com/";
    public static final String DOMAIN_HTTPS_SERVER_ADDRESS = "http://c.tieba.baidu.com/";
    public static final String DOMAIN_HTTPS_STATIC_SERVER = "http://tb1.bdstatic.com/";
    public static final String DOMAIN_HTTPS_TB_HI_IMAGE = "http://tb.himg.baidu.com/";
    public static final String DOMAIN_HTTPS_TIEBA = "http://tieba.baidu.com/";
    public static final String DOMAIN_HTTPS_TIEBAC = "https://tiebac.baidu.com/";
    public static final String DOMAIN_HTTP_TIEBA = "https://tieba.baidu.com/";
    public static final String DOMAIN_HTTP_TIEBAC = "http://tiebac.baidu.com/";
    public transient /* synthetic */ FieldHolder $fh;

    public TbDomainConfig() {
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
}
