package com.baidu.searchbox.retrieve.file.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PATH_EXTERNAL = "external:";
    public static final String PATH_INTERNAL = "internal:";
    public static final String PATH_PARENT = "../";
    public static final String UPLOAD_WIFI_TYPE = "1";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class FetchType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FETCH_FILE_TYPE = "file";
        public static final String FETCH_FLOW_TYPE = "flow";
        public static final String FETCH_TIMER_CANCEL_TYPE = "cancel_job";
        public static final String FETCH_TIMER_TYPE = "timer_upload_yalog";
        public transient /* synthetic */ FieldHolder $fh;

        public FetchType() {
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

        public static boolean isCancelType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                return TextUtils.equals(FETCH_TIMER_CANCEL_TYPE, str);
            }
            return invokeL.booleanValue;
        }

        public static boolean isTimerType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return TextUtils.equals(FETCH_TIMER_TYPE, str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class MetaError {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ERROR_COPY = "2";
        public static final String ERROR_EXIST = "1";
        public static final String ERROR_NON = "0";
        public static final String ERROR_PATH = "4";
        public static final String ERROR_SIZE = "3";
        public transient /* synthetic */ FieldHolder $fh;

        public MetaError() {
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

    public Constants() {
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
