package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class Lifecycling {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GENERATED_CALLBACK = 2;
    public static final int REFLECTIVE_CALLBACK = 1;
    public static Map<Class<?>, Integer> sCallbackCache;
    public static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1746958029, "Landroidx/lifecycle/Lifecycling;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1746958029, "Landroidx/lifecycle/Lifecycling;");
                return;
            }
        }
        sCallbackCache = new HashMap();
        sClassToAdapters = new HashMap();
    }

    public Lifecycling() {
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

    public static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, constructor, obj)) == null) {
            try {
                return constructor.newInstance(obj);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(e4);
            }
        }
        return (GeneratedAdapter) invokeLL.objValue;
    }

    @Nullable
    public static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            try {
                Package r0 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r0 != null ? r0.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String adapterName = getAdapterName(canonicalName);
                if (!name.isEmpty()) {
                    adapterName = name + "." + adapterName;
                }
                Constructor declaredConstructor = Class.forName(adapterName).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                return declaredConstructor;
            } catch (ClassNotFoundException unused) {
                return null;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (Constructor) invokeL.objValue;
    }

    public static String getAdapterName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return str.replace(".", "_") + "_LifecycleAdapter";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    public static GenericLifecycleObserver getCallback(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? new GenericLifecycleObserver(lifecycleEventObserver(obj)) { // from class: androidx.lifecycle.Lifecycling.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LifecycleEventObserver val$observer;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$observer = r6;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                    this.val$observer.onStateChanged(lifecycleOwner, event);
                }
            }
        } : (GenericLifecycleObserver) invokeL.objValue;
    }

    public static int getObserverConstructorType(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            Integer num = sCallbackCache.get(cls);
            if (num != null) {
                return num.intValue();
            }
            int resolveObserverCallbackType = resolveObserverCallbackType(cls);
            sCallbackCache.put(cls, Integer.valueOf(resolveObserverCallbackType));
            return resolveObserverCallbackType;
        }
        return invokeL.intValue;
    }

    public static boolean isLifecycleParent(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? cls != null && LifecycleObserver.class.isAssignableFrom(cls) : invokeL.booleanValue;
    }

    @NonNull
    public static LifecycleEventObserver lifecycleEventObserver(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
            boolean z = obj instanceof LifecycleEventObserver;
            boolean z2 = obj instanceof FullLifecycleObserver;
            if (z && z2) {
                return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
            }
            if (z2) {
                return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, null);
            }
            if (z) {
                return (LifecycleEventObserver) obj;
            }
            Class<?> cls = obj.getClass();
            if (getObserverConstructorType(cls) == 2) {
                List<Constructor<? extends GeneratedAdapter>> list = sClassToAdapters.get(cls);
                if (list.size() == 1) {
                    return new SingleGeneratedAdapterObserver(createGeneratedAdapter(list.get(0), obj));
                }
                GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    generatedAdapterArr[i2] = createGeneratedAdapter(list.get(i2), obj);
                }
                return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
            }
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        return (LifecycleEventObserver) invokeL.objValue;
    }

    public static int resolveObserverCallbackType(Class<?> cls) {
        InterceptResult invokeL;
        Class<?>[] interfaces;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) {
            if (cls.getCanonicalName() == null) {
                return 1;
            }
            Constructor<? extends GeneratedAdapter> generatedConstructor = generatedConstructor(cls);
            if (generatedConstructor != null) {
                sClassToAdapters.put(cls, Collections.singletonList(generatedConstructor));
                return 2;
            } else if (ClassesInfoCache.sInstance.hasLifecycleMethods(cls)) {
                return 1;
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                ArrayList arrayList = null;
                if (isLifecycleParent(superclass)) {
                    if (getObserverConstructorType(superclass) == 1) {
                        return 1;
                    }
                    arrayList = new ArrayList(sClassToAdapters.get(superclass));
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (isLifecycleParent(cls2)) {
                        if (getObserverConstructorType(cls2) == 1) {
                            return 1;
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(sClassToAdapters.get(cls2));
                    }
                }
                if (arrayList != null) {
                    sClassToAdapters.put(cls, arrayList);
                    return 2;
                }
                return 1;
            }
        }
        return invokeL.intValue;
    }
}
