package com.baidu.bdtask.service.cache.storage;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H$¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0012\u001a\u00020\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0014\u001a\u00020\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J3\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R(\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0(8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/ConcurrentStorage;", "Lc/a/j/j/g/b/a;", "", "clear", "()V", "", "key", "", "contains", "(Ljava/lang/String;)Z", "", "getAny", "(Ljava/lang/String;)Ljava/lang/Object;", "onStorageChanged", "remove", "(Ljava/lang/String;)V", "T", "value", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "setIfAbsent", "defaultValue", "Lkotlin/Function0;", "action", "withCheck", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "()Z", "isReady", "Z", "setReady", "(Z)V", "", "getKeys", "()Ljava/util/Set;", SavedStateHandle.KEYS, "", "getSize", "()I", "size", "", "storage", "Ljava/util/Map;", "getStorage", "()Ljava/util/Map;", "<init>", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class a implements c.a.j.j.g.b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ReentrantLock f24947c;

    /* renamed from: d  reason: collision with root package name */
    public static final C1735a f24948d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f24949b;

    /* renamed from: com.baidu.bdtask.service.cache.storage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1735a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1735a() {
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

        public final ReentrantLock a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f24947c : (ReentrantLock) invokeV.objValue;
        }

        public /* synthetic */ C1735a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(638978127, "Lcom/baidu/bdtask/service/cache/storage/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(638978127, "Lcom/baidu/bdtask/service/cache/storage/a;");
                return;
            }
        }
        f24948d = new C1735a(null);
        f24947c = new ReentrantLock(true);
    }

    public a() {
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
        this.f24949b = new ConcurrentHashMap();
    }

    public static /* synthetic */ Object a(a aVar, Object obj, Function0 function0, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return aVar.b(obj, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withCheck");
    }

    @Override // c.a.j.j.g.b.a
    public Object b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f24949b.get(str) : invokeL.objValue;
    }

    public final Map<String, Object> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24949b : (Map) invokeV.objValue;
    }

    public <T> void d(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, t) == null) {
            this.f24949b.put(str, t);
            a(this, null, new ConcurrentStorage$set$1(this), 1, null);
        }
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Boolean bool = (Boolean) b(Boolean.FALSE, new ConcurrentStorage$contains$1(this, str));
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract void g();

    public final <T> T b(T t, Function0<? extends T> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, function0)) == null) {
            ReentrantLock a = f24948d.a();
            a.lock();
            try {
                return this.a ? function0.invoke() : t;
            } finally {
                a.unlock();
            }
        }
        return (T) invokeLL.objValue;
    }
}
