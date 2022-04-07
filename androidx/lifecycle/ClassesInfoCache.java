package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ClassesInfoCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CALL_TYPE_NO_ARG = 0;
    public static final int CALL_TYPE_PROVIDER = 1;
    public static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    public static ClassesInfoCache sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<?>, CallbackInfo> mCallbackMap;
    public final Map<Class<?>, Boolean> mHasLifecycleMethods;

    /* loaded from: classes.dex */
    public static class CallbackInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Lifecycle.Event, List<MethodReference>> mEventToHandlers;
        public final Map<MethodReference, Lifecycle.Event> mHandlerToEvent;

        public CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHandlerToEvent = map;
            this.mEventToHandlers = new HashMap();
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.mEventToHandlers.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.mEventToHandlers.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void invokeMethodsForEvent(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(65537, null, list, lifecycleOwner, event, obj) == null) || list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).invokeCallback(lifecycleOwner, event, obj);
            }
        }

        public void invokeCallbacks(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, lifecycleOwner, event, obj) == null) {
                invokeMethodsForEvent(this.mEventToHandlers.get(event), lifecycleOwner, event, obj);
                invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MethodReference {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mCallType;
        public final Method mMethod;

        public MethodReference(int i, Method method) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallType = i;
            this.mMethod = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || MethodReference.class != obj.getClass()) {
                    return false;
                }
                MethodReference methodReference = (MethodReference) obj;
                return this.mCallType == methodReference.mCallType && this.mMethod.getName().equals(methodReference.mMethod.getName());
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.mCallType * 31) + this.mMethod.getName().hashCode() : invokeV.intValue;
        }

        public void invokeCallback(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, lifecycleOwner, event, obj) == null) {
                try {
                    int i = this.mCallType;
                    if (i == 0) {
                        this.mMethod.invoke(obj, new Object[0]);
                    } else if (i == 1) {
                        this.mMethod.invoke(obj, lifecycleOwner);
                    } else if (i != 2) {
                    } else {
                        this.mMethod.invoke(obj, lifecycleOwner, event);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1723527762, "Landroidx/lifecycle/ClassesInfoCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1723527762, "Landroidx/lifecycle/ClassesInfoCache;");
                return;
            }
        }
        sInstance = new ClassesInfoCache();
    }

    public ClassesInfoCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCallbackMap = new HashMap();
        this.mHasLifecycleMethods = new HashMap();
    }

    private CallbackInfo createInfo(Class<?> cls, @Nullable Method[] methodArr) {
        InterceptResult invokeLL;
        int i;
        CallbackInfo info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, methodArr)) == null) {
            Class<? super Object> superclass = cls.getSuperclass();
            HashMap hashMap = new HashMap();
            if (superclass != null && (info = getInfo(superclass)) != null) {
                hashMap.putAll(info.mHandlerToEvent);
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                for (Map.Entry<MethodReference, Lifecycle.Event> entry : getInfo(cls2).mHandlerToEvent.entrySet()) {
                    verifyAndPutHandler(hashMap, entry.getKey(), entry.getValue(), cls);
                }
            }
            if (methodArr == null) {
                methodArr = getDeclaredMethods(cls);
            }
            boolean z = false;
            for (Method method : methodArr) {
                OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
                if (onLifecycleEvent != null) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length <= 0) {
                        i = 0;
                    } else if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    } else {
                        i = 1;
                    }
                    Lifecycle.Event value = onLifecycleEvent.value();
                    if (parameterTypes.length > 1) {
                        if (parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                            if (value != Lifecycle.Event.ON_ANY) {
                                throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                            }
                            i = 2;
                        } else {
                            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                        }
                    }
                    if (parameterTypes.length <= 2) {
                        verifyAndPutHandler(hashMap, new MethodReference(i, method), value, cls);
                        z = true;
                    } else {
                        throw new IllegalArgumentException("cannot have more than 2 params");
                    }
                }
            }
            CallbackInfo callbackInfo = new CallbackInfo(hashMap);
            this.mCallbackMap.put(cls, callbackInfo);
            this.mHasLifecycleMethods.put(cls, Boolean.valueOf(z));
            return callbackInfo;
        }
        return (CallbackInfo) invokeLL.objValue;
    }

    private Method[] getDeclaredMethods(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cls)) == null) {
            try {
                return cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        return (Method[]) invokeL.objValue;
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, map, methodReference, event, cls) == null) {
            Lifecycle.Event event2 = map.get(methodReference);
            if (event2 == null || event == event2) {
                if (event2 == null) {
                    map.put(methodReference, event);
                    return;
                }
                return;
            }
            Method method = methodReference.mMethod;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        }
    }

    public CallbackInfo getInfo(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            CallbackInfo callbackInfo = this.mCallbackMap.get(cls);
            return callbackInfo != null ? callbackInfo : createInfo(cls, null);
        }
        return (CallbackInfo) invokeL.objValue;
    }

    public boolean hasLifecycleMethods(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            Boolean bool = this.mHasLifecycleMethods.get(cls);
            if (bool != null) {
                return bool.booleanValue();
            }
            Method[] declaredMethods = getDeclaredMethods(cls);
            for (Method method : declaredMethods) {
                if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                    createInfo(cls, declaredMethods);
                    return true;
                }
            }
            this.mHasLifecycleMethods.put(cls, Boolean.FALSE);
            return false;
        }
        return invokeL.booleanValue;
    }
}
