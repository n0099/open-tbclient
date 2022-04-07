package com.baidu.android.imsdk.retrieve;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSSINESS_EXPIRED = "1";
    public static final String DATA_KEY_MISS = "1";
    public static final String DATA_NULL = "0";
    public static final String NO_TYPE = "2";
    public static final String PATH_EXTERNAL = "external:";
    public static final String PATH_INTERNAL = "internal:";
    public static final String PATH_PARENT = "../";
    public static final String RETRIEVE_DONE = "0";
    public static final String RETRIEVE_ERRNO_SUCCESS = "0";
    public static final String RETRIEVE_NO_FILE = "1";
    public static final String RETRIEVE_TYPE_FILE = "file";
    public static final String RETRIEVE_UPLOAD_FAIL = "2";
    public static final String RETRIEVE_VALID = "1";
    public static final int RETRY_COUNT = 1;
    public static final String SUCCESS = "0";
    public static final String VALUE_BUS_DONE = "4";
    public static final String VALUE_BUS_PARAMES_ERROR = "2";
    public static final String VALUE_BUS_START = "3";
    public static final String VALUE_DISPATCH_SUCCESS = "1";
    public static final String VALUE_SERVER_PARAMES_ERROR = "-1";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public final class MetaError {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ERROR_COPY = "2";
        public static final String ERROR_EXIST = "1";
        public static final String ERROR_NON = "0";
        public static final String ERROR_PATH = "4";
        public static final String ERROR_SIZE = "3";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Constants this$0;

        public MetaError(Constants constants) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constants};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = constants;
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
