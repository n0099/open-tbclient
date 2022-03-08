package com.baidu.tbadk.abtest;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class ABTestConst {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BRANCH_A = "a";
    public static final String BRANCH_B = "b";
    public static final String KEY_FLUTTER_PAGE_TEST = "flutter_page_test";
    public static final String KEY_IMAGEVIEWER_CLEAN = "picpage_content_clear";
    public static final String KEY_NEW_BES_AD_SPLASH_SDK = "ad_xuzhang_splash_sdk";
    public static final String KEY_PERF_START_TEST = "performance_start_small_flow";
    public static final String KEY_PIC_REQ_TEST = "pic_req_switch_key";
    public static final String KEY_STATIC_OPT_TEST = "static_opt_open_test";
    public transient /* synthetic */ FieldHolder $fh;

    public ABTestConst() {
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
