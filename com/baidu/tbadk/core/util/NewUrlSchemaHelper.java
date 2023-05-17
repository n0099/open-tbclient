package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NewUrlSchemaHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME = "com.baidu.tieba://";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class Jump {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String JUMP_TO_TBWEBVIEW = "com.baidu.tieba://tbwebview";
        public static final String JUMP_TO_USER_CENTER = "com.baidu.tieba://usercenter";
        public static final String JUMP_TO_VIDEO_SQUARE = "com.baidu.tieba://videosquare";
        public transient /* synthetic */ FieldHolder $fh;

        public Jump() {
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

    public NewUrlSchemaHelper() {
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
