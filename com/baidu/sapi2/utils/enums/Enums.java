package com.baidu.sapi2.utils.enums;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Enums {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class FingerprintAuthType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOGIN = 3;
        public transient /* synthetic */ FieldHolder $fh;

        public FingerprintAuthType() {
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

    /* loaded from: classes2.dex */
    public static class NormalizeWay {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NONE = 0;
        public static final int PWD = 3;
        public static final int SMS = 1;
        public static final int SMS_EXIST = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public NormalizeWay() {
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

    /* loaded from: classes2.dex */
    public static class PreLoginType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CHINA_MOBILE_OAUTH = 12;
        public static final int CHOICE_SHARE = 8;
        public static final int CHOICE_SHARE_V2 = 9;
        public static final int CM = 16;
        public static final int CT = 18;
        public static final int CU = 17;
        public static final int FACE = 3;
        public static final int HUAWEI = 10;
        public static final int MEIZU = 14;
        public static final int NA_QR_LOGIN = 20;
        public static final int NONE = 0;
        public static final int OTHER = 11;
        public static final int PWD = 1;
        public static final int QQ = 6;
        public static final int SLIENT_SHARE = 7;
        public static final int SMS = 2;
        public static final int SWITCH = 19;
        public static final int TOUCHID = 15;
        public static final int WECHAT = 4;
        public static final int WEIBO = 5;
        public static final int XIAOMI = 13;
        public static final int YY = 100;
        public transient /* synthetic */ FieldHolder $fh;

        public PreLoginType() {
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

    public Enums() {
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
