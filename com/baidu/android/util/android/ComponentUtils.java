package com.baidu.android.util.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ComponentUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ComponentUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.util.android.ComponentUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1598873669, "Lcom/baidu/android/util/android/ComponentUtils$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1598873669, "Lcom/baidu/android/util/android/ComponentUtils$1;");
                    return;
                }
            }
            int[] iArr = new int[ComponentType.values().length];
            $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType = iArr;
            try {
                iArr[ComponentType.RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.SERVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[ComponentType.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ComponentType {
        public static final /* synthetic */ ComponentType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ComponentType ACTIVITY;
        public static final ComponentType ALL;
        public static final ComponentType PROVIDER;
        public static final ComponentType RECEIVER;
        public static final ComponentType SERVICE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(627570037, "Lcom/baidu/android/util/android/ComponentUtils$ComponentType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(627570037, "Lcom/baidu/android/util/android/ComponentUtils$ComponentType;");
                    return;
                }
            }
            ALL = new ComponentType("ALL", 0);
            ACTIVITY = new ComponentType("ACTIVITY", 1);
            SERVICE = new ComponentType("SERVICE", 2);
            RECEIVER = new ComponentType("RECEIVER", 3);
            ComponentType componentType = new ComponentType("PROVIDER", 4);
            PROVIDER = componentType;
            $VALUES = new ComponentType[]{ALL, ACTIVITY, SERVICE, RECEIVER, componentType};
        }

        public ComponentType(String str, int i) {
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

        public static ComponentType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ComponentType) Enum.valueOf(ComponentType.class, str);
            }
            return (ComponentType) invokeL.objValue;
        }

        public static ComponentType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ComponentType[]) $VALUES.clone();
            }
            return (ComponentType[]) invokeV.objValue;
        }
    }

    public ComponentUtils() {
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

    public static ComponentInfo getActivityInfo(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, componentName)) == null) {
            try {
                return context.getPackageManager().getActivityInfo(componentName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (ComponentInfo) invokeLL.objValue;
    }

    public static ComponentInfo getProviderInfo(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, componentName)) == null) {
            try {
                return context.getPackageManager().getProviderInfo(componentName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (ComponentInfo) invokeLL.objValue;
    }

    public static ComponentInfo getReceiverInfo(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, componentName)) == null) {
            try {
                return context.getPackageManager().getReceiverInfo(componentName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (ComponentInfo) invokeLL.objValue;
    }

    public static ComponentInfo getServiceInfo(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, componentName)) == null) {
            try {
                return context.getPackageManager().getServiceInfo(componentName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (ComponentInfo) invokeLL.objValue;
    }

    public static boolean isComponentEnabledSetting(Context context, ComponentName componentName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, componentName)) == null) {
            if (1 == context.getPackageManager().getComponentEnabledSetting(componentName)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static ComponentInfo getComponentInfo(Context context, ComponentType componentType, ComponentName componentName) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, componentType, componentName)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[componentType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            ComponentInfo receiverInfo = getReceiverInfo(context, componentName);
                            if (receiverInfo == null) {
                                receiverInfo = getActivityInfo(context, componentName);
                            }
                            if (receiverInfo == null) {
                                receiverInfo = getServiceInfo(context, componentName);
                            }
                            if (receiverInfo == null) {
                                return getProviderInfo(context, componentName);
                            }
                            return receiverInfo;
                        }
                        return getProviderInfo(context, componentName);
                    }
                    return getServiceInfo(context, componentName);
                }
                return getActivityInfo(context, componentName);
            }
            return getReceiverInfo(context, componentName);
        }
        return (ComponentInfo) invokeLLL.objValue;
    }

    public static boolean isComponetEnable(Context context, ComponentType componentType, ComponentName componentName) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, componentType, componentName)) == null) {
            ComponentInfo componentInfo = getComponentInfo(context, componentType, componentName);
            if (componentInfo != null) {
                return componentInfo.enabled;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void setComponentEnabledSetting(Context context, ComponentType componentType, ComponentName componentName, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, componentType, componentName, Boolean.valueOf(z)}) == null) {
            boolean isComponetEnable = isComponetEnable(context, componentType, componentName);
            if (z) {
                if (!isComponetEnable) {
                    context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                }
            } else if (isComponetEnable) {
                context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
            }
        }
    }
}
