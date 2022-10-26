package com.baidu.sapi2.result;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class GetTplStokenResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_CODE_BDUSS_NOT_EXIST = -301;
    public static final int ERROR_CODE_GET_STOKEN_FAILURE = 8;
    public static final int ERROR_CODE_PARSE_DATA_FAIL = -304;
    public static final int ERROR_CODE_PTOKEN_EMPTY = -305;
    public static final int ERROR_CODE_STOKENS_NOT_MATCH = -306;
    public static final int ERROR_CODE_TARGET_TPL_LIST_EMPTY = -302;
    public static final String ERROR_MSG_BDUSS_NOT_EXIST = "bduss 本地不存在";
    public transient /* synthetic */ FieldHolder $fh;
    public FailureType failureType;
    public Map tplStokenMap;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class FailureType {
        public static final /* synthetic */ FailureType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FailureType BDUSS_EXPIRED;
        public static final FailureType BDUSS_PTOKEN_NOT_MATCH;
        public static final FailureType PTOKEN_EMPTY;
        public static final FailureType UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(623050750, "Lcom/baidu/sapi2/result/GetTplStokenResult$FailureType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(623050750, "Lcom/baidu/sapi2/result/GetTplStokenResult$FailureType;");
                    return;
                }
            }
            PTOKEN_EMPTY = new FailureType("PTOKEN_EMPTY", 0);
            BDUSS_PTOKEN_NOT_MATCH = new FailureType("BDUSS_PTOKEN_NOT_MATCH", 1);
            BDUSS_EXPIRED = new FailureType("BDUSS_EXPIRED", 2);
            FailureType failureType = new FailureType(RomUtils.UNKNOWN, 3);
            UNKNOWN = failureType;
            $VALUES = new FailureType[]{PTOKEN_EMPTY, BDUSS_PTOKEN_NOT_MATCH, BDUSS_EXPIRED, failureType};
        }

        public FailureType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FailureType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (FailureType) Enum.valueOf(FailureType.class, str);
            }
            return (FailureType) invokeL.objValue;
        }

        public static FailureType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (FailureType[]) $VALUES.clone();
            }
            return (FailureType[]) invokeV.objValue;
        }
    }

    public GetTplStokenResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.tplStokenMap = new HashMap();
        this.failureType = FailureType.UNKNOWN;
        this.msgMap.put(-301, ERROR_MSG_BDUSS_NOT_EXIST);
    }
}
