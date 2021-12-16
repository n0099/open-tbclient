package com.baidu.searchbox.logsystem.logsys;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class CrashUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static String CRASH_TAG = null;
    public static final String SEPERATOR = "#";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class CrashpadConstant {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FULL_BDMP_PERFIX = "fullbdmp-";
        public static final String JSON_EXTRA = "json-extra_info";
        public static final String MIND_BDMP_PREFIX = "minibdmp-";
        public static final String TXT_EXTRA = "txt-json_supplement";
        public transient /* synthetic */ FieldHolder $fh;

        public CrashpadConstant() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-942374366, "Lcom/baidu/searchbox/logsystem/logsys/CrashUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-942374366, "Lcom/baidu/searchbox/logsystem/logsys/CrashUtil;");
                return;
            }
        }
        CRASH_TAG = AperfRuntime.Runtime.getProcessUUID().replaceAll("#", "") + "#" + System.currentTimeMillis();
    }

    public CrashUtil() {
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

    public static final String getCrashTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? CRASH_TAG : (String) invokeV.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
        }
    }

    /* loaded from: classes10.dex */
    public static final class CrashTAG {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mCrashProcessUUID;
        public long mTimeStamp;

        public CrashTAG(@NonNull String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCrashProcessUUID = str;
            this.mTimeStamp = j2;
        }

        public static CrashTAG getCrashTAG(@NonNull String str) {
            InterceptResult invokeL;
            String[] split;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (str == null || TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2 || TextUtils.isEmpty(split[0])) {
                    return null;
                }
                try {
                    j2 = Long.valueOf(split[1]).longValue();
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    j2 = 0;
                }
                if (j2 <= 0) {
                    return null;
                }
                return new CrashTAG(split[0], j2);
            }
            return (CrashTAG) invokeL.objValue;
        }

        public static String getCrashTAG(@NonNull CrashTAG crashTAG) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, crashTAG)) == null) {
                if (crashTAG == null || TextUtils.isEmpty(crashTAG.mCrashProcessUUID) || crashTAG.mTimeStamp < 0) {
                    return null;
                }
                return crashTAG.mCrashProcessUUID.replaceAll("#", "") + "#" + crashTAG.mTimeStamp;
            }
            return (String) invokeL.objValue;
        }
    }
}
