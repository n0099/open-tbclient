package com.baidu.mobads.container.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.util.network.NetworkRequestFilterManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes3.dex */
public class SDKLogSecurityManager {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] TYPE_LIST_DANGER;
    public static final int[] TYPE_LIST_SECRET;
    public static final int[] TYPE_LIST_UNDEFINED;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LogTypeLevel {
        public static final /* synthetic */ LogTypeLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final LogTypeLevel DANGER;
        public static final LogTypeLevel NORMAL;
        public static final LogTypeLevel SECRET;
        public static final LogTypeLevel UNDEFINED;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLevel;
        public String mName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2030873530, "Lcom/baidu/mobads/container/util/SDKLogSecurityManager$LogTypeLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2030873530, "Lcom/baidu/mobads/container/util/SDKLogSecurityManager$LogTypeLevel;");
                    return;
                }
            }
            UNDEFINED = new LogTypeLevel("UNDEFINED", 0, SessionMonitorEngine.PUBLIC_DATA_UNDIFNED, -1);
            NORMAL = new LogTypeLevel("NORMAL", 1, "normal", 0);
            SECRET = new LogTypeLevel("SECRET", 2, "secret", 1);
            LogTypeLevel logTypeLevel = new LogTypeLevel("DANGER", 3, "danger", 2);
            DANGER = logTypeLevel;
            $VALUES = new LogTypeLevel[]{UNDEFINED, NORMAL, SECRET, logTypeLevel};
        }

        public LogTypeLevel(String str, int i2, String str2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mName = str2;
            this.mLevel = i3;
        }

        public static LogTypeLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LogTypeLevel) Enum.valueOf(LogTypeLevel.class, str) : (LogTypeLevel) invokeL.objValue;
        }

        public static LogTypeLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LogTypeLevel[]) $VALUES.clone() : (LogTypeLevel[]) invokeV.objValue;
        }

        public int getLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLevel : invokeV.intValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mName : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1675927674, "Lcom/baidu/mobads/container/util/SDKLogSecurityManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1675927674, "Lcom/baidu/mobads/container/util/SDKLogSecurityManager;");
                return;
            }
        }
        TYPE_LIST_UNDEFINED = new int[0];
        TYPE_LIST_SECRET = new int[]{527, 528, 529, 9, 11};
        TYPE_LIST_DANGER = new int[0];
    }

    public SDKLogSecurityManager() {
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

    public static String encryptValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Base64.encode(str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getLogTypeLevel(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (isListContainsType(TYPE_LIST_UNDEFINED, i2)) {
                return LogTypeLevel.UNDEFINED.getLevel();
            }
            if (isListContainsType(TYPE_LIST_SECRET, i2)) {
                return LogTypeLevel.SECRET.getLevel();
            }
            if (isListContainsType(TYPE_LIST_DANGER, i2)) {
                return LogTypeLevel.DANGER.getLevel();
            }
            return LogTypeLevel.NORMAL.getLevel();
        }
        return invokeI.intValue;
    }

    public static boolean isEnvSecurity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            NetworkRequestFilterManager networkRequestFilterManager = NetworkRequestFilterManager.getInstance(XAdRemoteCommonUtils.getApplicationContext());
            return networkRequestFilterManager.isAdbDebugConnected() || networkRequestFilterManager.isProxyRunning() || networkRequestFilterManager.isRooted();
        }
        return invokeV.booleanValue;
    }

    public static boolean isListContainsType(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, iArr, i2)) == null) {
            if (iArr != null && iArr.length > 0) {
                for (int i3 : iArr) {
                    if (i2 == i3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean isLogTypeEnable(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (XAdSDKRemoteConfig.DEBUG_MODE) {
                return true;
            }
            int logTypeLevel = getLogTypeLevel(i2);
            if (logTypeLevel == LogTypeLevel.UNDEFINED.getLevel()) {
                return false;
            }
            if (logTypeLevel == LogTypeLevel.NORMAL.getLevel()) {
                return true;
            }
            return logTypeLevel == LogTypeLevel.SECRET.getLevel() ? !isEnvSecurity() : z;
        }
        return invokeCommon.booleanValue;
    }
}
