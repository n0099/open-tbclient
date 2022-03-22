package com.baidu.searchbox.retrieve.file.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PATH_EXTERNAL = "external:";
    public static final String PATH_INTERNAL = "internal:";
    public static final String PATH_PARENT = "../";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class FetchType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FETCH_FILE_TYPE = "file";
        public static final String FETCH_FLOW_TYPE = "flow";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Constants this$0;

        public FetchType(Constants constants) {
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

    /* loaded from: classes4.dex */
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
