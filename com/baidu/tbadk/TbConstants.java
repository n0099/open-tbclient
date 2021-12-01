package com.baidu.tbadk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TbConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRS_POST_THREAD = 2;
    public static final int HOME_PAGE_POST_THREAD = 1;
    public static final int LOGIN_STATUS_TYPE_ACCOUNT_CHANGE = 2;
    public static final int LOGIN_STATUS_TYPE_NEED_INIT = 1;
    public static final int STRETAGY_ALTERNATE_BEAR_FIRST = 103;
    public static final int STRETAGY_ALTERNATE_CPC_FIRST = 104;
    public static final int STRETAGY_BEAR_FIRST = 101;
    public static final int STRETAGY_CLOSE_CPC = 105;
    public static final int STRETAGY_CLOSE_CPC_AND_BEAR = 106;
    public static final int STRETAGY_CPC_FIRST = 102;
    public transient /* synthetic */ FieldHolder $fh;

    public TbConstants() {
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
