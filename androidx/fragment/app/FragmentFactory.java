package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class FragmentFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final SimpleArrayMap<String, Class<?>> sClassMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1894637772, "Landroidx/fragment/app/FragmentFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1894637772, "Landroidx/fragment/app/FragmentFactory;");
                return;
            }
        }
        sClassMap = new SimpleArrayMap<>();
    }

    public FragmentFactory() {
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

    public static boolean isFragmentClass(@NonNull ClassLoader classLoader, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, classLoader, str)) == null) {
            try {
                return Fragment.class.isAssignableFrom(loadClass(classLoader, str));
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static Class<?> loadClass(@NonNull ClassLoader classLoader, @NonNull String str) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, classLoader, str)) == null) {
            Class<?> cls = sClassMap.get(str);
            if (cls == null) {
                Class<?> cls2 = Class.forName(str, false, classLoader);
                sClassMap.put(str, cls2);
                return cls2;
            }
            return cls;
        }
        return (Class) invokeLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends androidx.fragment.app.Fragment> */
    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader classLoader, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, classLoader, str)) == null) {
            try {
                return loadClass(classLoader, str);
            } catch (ClassCastException e2) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
            } catch (ClassNotFoundException e3) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e3);
            }
        }
        return (Class) invokeLL.objValue;
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, classLoader, str)) == null) {
            try {
                return loadFragmentClass(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            } catch (InstantiationException e3) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
            } catch (NoSuchMethodException e4) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
            } catch (InvocationTargetException e5) {
                throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
            }
        }
        return (Fragment) invokeLL.objValue;
    }
}
