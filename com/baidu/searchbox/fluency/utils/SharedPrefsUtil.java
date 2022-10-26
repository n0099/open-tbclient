package com.baidu.searchbox.fluency.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SharedPrefsUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.fluency.utils.SharedPrefsUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class FpsPreferences extends SharedPrefsWrapper {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String FLUENCY_FPS_PREF_NAME = "com.baidu.searchbox.fluency.fps.pref";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes2.dex */
        public final class Holder {
            public static /* synthetic */ Interceptable $ic;
            public static final FpsPreferences INSTANCE;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1379163946, "Lcom/baidu/searchbox/fluency/utils/SharedPrefsUtil$FpsPreferences$Holder;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1379163946, "Lcom/baidu/searchbox/fluency/utils/SharedPrefsUtil$FpsPreferences$Holder;");
                        return;
                    }
                }
                INSTANCE = new FpsPreferences(null);
            }

            public Holder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FpsPreferences() {
            super(FLUENCY_FPS_PREF_NAME);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static FpsPreferences getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return Holder.INSTANCE;
            }
            return (FpsPreferences) invokeV.objValue;
        }

        public /* synthetic */ FpsPreferences(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public SharedPrefsUtil() {
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

    public static SharedPrefsWrapper getFpsPreference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return FpsPreferences.getInstance();
        }
        return (SharedPrefsWrapper) invokeV.objValue;
    }

    public static boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return getFpsPreference().contains(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            return getFpsPreference().getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public static int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            return getFpsPreference().getInt(str, i);
        }
        return invokeLI.intValue;
    }

    public static long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            return getFpsPreference().getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    public static String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            return getFpsPreference().getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, str, z) == null) {
            getFpsPreference().putBoolean(str, z);
        }
    }

    public static void putInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65544, null, str, i) == null) {
            getFpsPreference().putInt(str, i);
        }
    }

    public static void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65545, null, str, j) == null) {
            getFpsPreference().putLong(str, j);
        }
    }

    public static void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            getFpsPreference().putString(str, str2);
        }
    }
}
