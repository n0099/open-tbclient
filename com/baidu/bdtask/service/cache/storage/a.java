package com.baidu.bdtask.service.cache.storage;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.hv;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H$¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0012\u001a\u00020\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0014\u001a\u00020\u0002\"\b\b\u0000\u0010\u0010*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J3\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050 8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R(\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0(8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/ConcurrentStorage;", "Lcom/baidu/tieba/hv;", "", DownloadStatisticConstants.UBC_VALUE_CLEAR, "()V", "", "key", "", "contains", "(Ljava/lang/String;)Z", "", "getAny", "(Ljava/lang/String;)Ljava/lang/Object;", "onStorageChanged", "remove", "(Ljava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "value", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "setIfAbsent", "defaultValue", "Lkotlin/Function0;", "action", "withCheck", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "()Z", "isReady", "Z", "setReady", "(Z)V", "", "getKeys", "()Ljava/util/Set;", SavedStateHandle.KEYS, "", "getSize", "()I", "size", "", "storage", "Ljava/util/Map;", "getStorage", "()Ljava/util/Map;", "<init>", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class a implements hv {
    public static /* synthetic */ Interceptable $ic;
    public static final ReentrantLock c;
    public static final C0078a d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final Map<String, Object> b;

    public abstract void g();

    /* renamed from: com.baidu.bdtask.service.cache.storage.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0078a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0078a() {
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return a.c;
            }
            return (ReentrantLock) invokeV.objValue;
        }

        public /* synthetic */ C0078a(DefaultConstructorMarker defaultConstructorMarker) {
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
        d = new C0078a(null);
        c = new ReentrantLock(true);
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
        this.b = new ConcurrentHashMap();
    }

    public final Map<String, Object> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (Map) invokeV.objValue;
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

    public final <T> T b(T t, Function0<? extends T> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, function0)) == null) {
            ReentrantLock a = d.a();
            a.lock();
            try {
                if (this.a) {
                    return function0.invoke();
                }
                return t;
            } finally {
                a.unlock();
            }
        }
        return (T) invokeLL.objValue;
    }

    public <T> void d(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, t) == null) {
            this.b.put(str, t);
            a(this, null, new Function0<Unit>(this) { // from class: com.baidu.bdtask.service.cache.storage.ConcurrentStorage$set$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.g();
                    }
                }
            }, 1, null);
        }
    }

    @Override // com.baidu.tieba.hv
    public Object b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.b.get(str);
        }
        return invokeL.objValue;
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public boolean f(final String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Boolean bool = (Boolean) b(Boolean.FALSE, new Function0<Boolean>(this, str) { // from class: com.baidu.bdtask.service.cache.storage.ConcurrentStorage$contains$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String $key;
                public final /* synthetic */ a this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$key = str;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.this$0.c().containsKey(this.$key);
                    }
                    return invokeV.booleanValue;
                }
            });
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
