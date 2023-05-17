package com.baidu.tbadk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbDomainConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOMAIN_HTTPS_BAIDU = "http://www.baidu.com/";
    public static final String DOMAIN_HTTPS_BCS_CDN = "http://bcscdn.baidu.com/";
    public static final String DOMAIN_HTTPS_GSP = "https://gsp0.baidu.com/";
    public static final String DOMAIN_HTTPS_MOBILE_BAIDU = "http://m.baidu.com/";
    public static final String DOMAIN_HTTPS_SERVER_ADDRESS = "https://tiebac.baidu.com/";
    public static final String DOMAIN_HTTPS_STATIC_SERVER = "http://tb1.bdstatic.com/";
    public static final String DOMAIN_HTTPS_TB_HI_IMAGE = "http://tb.himg.baidu.com/";
    public static final String DOMAIN_HTTPS_TIEBA = "https://tieba.baidu.com/";
    public static final String DOMAIN_TIEBA = "tieba.baidu.com/";
    public static final String DOMAIN_TIEBAC = "tiebac.baidu.com/";
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public transient /* synthetic */ FieldHolder $fh;

    public TbDomainConfig() {
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
}
