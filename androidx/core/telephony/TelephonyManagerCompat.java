package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class TelephonyManagerCompat {
    public static /* synthetic */ Interceptable $ic;
    public static Method sGetDeviceIdMethod;
    public static Method sGetSubIdMethod;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api23Impl() {
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

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(h.c)
        @DoNotInline
        public static String getDeviceId(TelephonyManager telephonyManager, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, telephonyManager, i)) == null) {
                return telephonyManager.getDeviceId(i);
            }
            return (String) invokeLI.objValue;
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static class Api26Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api26Impl() {
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

        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission(h.c)
        @DoNotInline
        public static String getImei(TelephonyManager telephonyManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, telephonyManager)) == null) {
                return ApiReplaceUtil.getImei(telephonyManager);
            }
            return (String) invokeL.objValue;
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api30Impl() {
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

        @DoNotInline
        public static int getSubscriptionId(TelephonyManager telephonyManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, telephonyManager)) == null) {
                return telephonyManager.getSubscriptionId();
            }
            return invokeL.intValue;
        }
    }

    public TelephonyManagerCompat() {
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

    @Nullable
    @RequiresPermission(h.c)
    @SuppressLint({"MissingPermission"})
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        int subscriptionId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, telephonyManager)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                return Api26Impl.getImei(telephonyManager);
            }
            if (i >= 22 && (subscriptionId = getSubscriptionId(telephonyManager)) != Integer.MAX_VALUE && subscriptionId != -1) {
                int slotIndex = SubscriptionManagerCompat.getSlotIndex(subscriptionId);
                if (Build.VERSION.SDK_INT >= 23) {
                    return Api23Impl.getDeviceId(telephonyManager, slotIndex);
                }
                try {
                    if (sGetDeviceIdMethod == null) {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                        sGetDeviceIdMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    return (String) sGetDeviceIdMethod.invoke(telephonyManager, Integer.valueOf(slotIndex));
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return null;
                }
            }
            return ApiReplaceUtil.getDeviceId(telephonyManager);
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, telephonyManager)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return Api30Impl.getSubscriptionId(telephonyManager);
            }
            if (i >= 22) {
                try {
                    if (sGetSubIdMethod == null) {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                        sGetSubIdMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, new Object[0]);
                    if (num != null && num.intValue() != -1) {
                        return num.intValue();
                    }
                    return Integer.MAX_VALUE;
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }
}
