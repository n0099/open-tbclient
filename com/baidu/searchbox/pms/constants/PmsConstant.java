package com.baidu.searchbox.pms.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class PmsConstant {
    public static /* synthetic */ Interceptable $ic;
    public static boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class DynamicDBVersion {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DB_VERSION_10_6_0 = 1;
        public static final int DB_VERSION_12_12_0 = 2;
        public static final int DB_VERSION_12_14_0 = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public DynamicDBVersion() {
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

    /* loaded from: classes9.dex */
    public static final class EnvParam {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static final class Key {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String CPU_ABI = "cpu_abi";
            public static final String CPU_FEATURE = "cpu_feature";
            public static final String FREE_SPACE = "free_space";
            public static final String WHOLE_SPACE = "whole_space";
            public transient /* synthetic */ FieldHolder $fh;

            public Key() {
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

        public EnvParam() {
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

    /* loaded from: classes9.dex */
    public static final class Statistic {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String STATISTIC_CHANNELID = "channel_id";
        public static final String STATISTIC_CHANNELIDS = "channel_ids";
        public static final String STATISTIC_DEGRADE = "degrade";
        public static final String STATISTIC_ERRCODE = "err_code";
        public static final String STATISTIC_ERRMSG = "err_msg";
        public static final String STATISTIC_IP = "ip_address";
        public static final String STATISTIC_NETWORK = "network_type";
        public static final String STATISTIC_PKGNAME = "package_name";
        public static final String STATISTIC_RETRY_COUNT = "retry_count";
        public static final String STATISTIC_URL = "url";
        public static final String STATISTIC_VERSION = "version";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public static final class Key {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String REV_DETAIL = "detail";
            public static final String REV_EXT = "ext";
            public static final String REV_FROM = "from";
            public static final String REV_ITEM_PRODUCT = "product";
            public static final String REV_ITEM_VALID = "valid";
            public static final String REV_ITEM_VERSION = "version";
            public static final String REV_SOURCE = "source";
            public static final String REV_SUCCESS_COUNT = "successCount";
            public static final String REV_TIMESTAMP = "timeStamp";
            public static final String REV_TOTAL_COUNT = "totalCount";
            public static final String REV_VERSION_FILTER_COUNT = "versionFilterCount";
            public transient /* synthetic */ FieldHolder $fh;

            public Key() {
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

        /* loaded from: classes9.dex */
        public static final class UBC {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String UBC_REV_ID = "645";
            public transient /* synthetic */ FieldHolder $fh;

            public UBC() {
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

        /* loaded from: classes9.dex */
        public static final class Value {
            public static /* synthetic */ Interceptable $ic = null;
            public static final String REV_FROM = "research";
            public static final String REV_ITEM_VALID = "1";
            public static final String REV_SOURCE_APS = "aps";
            public static final String REV_SOURCE_APS_LC = "aps_lc";
            public static final int REV_VERSION_FILTER_COUNT = 0;
            public transient /* synthetic */ FieldHolder $fh;

            public Value() {
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

        public Statistic() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1403212012, "Lcom/baidu/searchbox/pms/constants/PmsConstant;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1403212012, "Lcom/baidu/searchbox/pms/constants/PmsConstant;");
        }
    }

    public PmsConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
