package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class BundleCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class BundleCompatBaseImpl {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "BundleCompatBaseImpl";
        public static Method sGetIBinderMethod;
        public static boolean sGetIBinderMethodFetched;
        public static Method sPutIBinderMethod;
        public static boolean sPutIBinderMethodFetched;
        public transient /* synthetic */ FieldHolder $fh;

        public BundleCompatBaseImpl() {
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

        public static IBinder getBinder(Bundle bundle, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, str)) == null) {
                if (!sGetIBinderMethodFetched) {
                    try {
                        Method method = Bundle.class.getMethod("getIBinder", String.class);
                        sGetIBinderMethod = method;
                        method.setAccessible(true);
                    } catch (NoSuchMethodException e2) {
                        Log.i(TAG, "Failed to retrieve getIBinder method", e2);
                    }
                    sGetIBinderMethodFetched = true;
                }
                Method method2 = sGetIBinderMethod;
                if (method2 != null) {
                    try {
                        return (IBinder) method2.invoke(bundle, str);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                        Log.i(TAG, "Failed to invoke getIBinder via reflection", e3);
                        sGetIBinderMethod = null;
                    }
                }
                return null;
            }
            return (IBinder) invokeLL.objValue;
        }

        public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, bundle, str, iBinder) == null) {
                if (!sPutIBinderMethodFetched) {
                    try {
                        Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                        sPutIBinderMethod = method;
                        method.setAccessible(true);
                    } catch (NoSuchMethodException e2) {
                        Log.i(TAG, "Failed to retrieve putIBinder method", e2);
                    }
                    sPutIBinderMethodFetched = true;
                }
                Method method2 = sPutIBinderMethod;
                if (method2 != null) {
                    try {
                        method2.invoke(bundle, str, iBinder);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                        Log.i(TAG, "Failed to invoke putIBinder via reflection", e3);
                        sPutIBinderMethod = null;
                    }
                }
            }
        }
    }

    public BundleCompat() {
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
    public static IBinder getBinder(@NonNull Bundle bundle, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bundle, str)) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                return bundle.getBinder(str);
            }
            return BundleCompatBaseImpl.getBinder(bundle, str);
        }
        return (IBinder) invokeLL.objValue;
    }

    public static void putBinder(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, bundle, str, iBinder) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                bundle.putBinder(str, iBinder);
            } else {
                BundleCompatBaseImpl.putBinder(bundle, str, iBinder);
            }
        }
    }
}
