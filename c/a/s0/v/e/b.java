package c.a.s0.v.e;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<PlaceId, List<AdvertAppInfo>> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<PlaceId, Long> f24653b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.s0.v.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1440b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677455690, "Lc/a/s0/v/e/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(677455690, "Lc/a/s0/v/e/b$b;");
                    return;
                }
            }
            a = new b(null);
        }
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C1440b.a : (b) invokeV.objValue;
    }

    public void a(@NonNull PlaceId placeId, @NonNull List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, placeId, list) == null) {
            List<AdvertAppInfo> list2 = this.a.get(placeId);
            if (list2 == null) {
                synchronized (this.a) {
                    list2 = Collections.synchronizedList(new ArrayList());
                    this.a.put(placeId, list2);
                }
            }
            list2.addAll(list);
            this.f24653b.put(placeId, Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Nullable
    public List<AdvertAppInfo> b(@NonNull PlaceId placeId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, placeId)) == null) {
            List<AdvertAppInfo> list = this.a.get(placeId);
            if (c.a.s0.x1.o.k.a.e(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list);
            c.a.s0.x1.o.k.a.c(list);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public AdvertAppInfo c(@NonNull PlaceId placeId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, placeId)) == null) {
            List<AdvertAppInfo> list = this.a.get(placeId);
            if (c.a.s0.x1.o.k.a.e(list)) {
                return null;
            }
            return list.remove(0);
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public long e(PlaceId placeId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, placeId)) == null) {
            Long l = this.f24653b.get(placeId);
            if (l == null) {
                return 0L;
            }
            return l.longValue();
        }
        return invokeL.longValue;
    }

    public boolean f(@NonNull PlaceId placeId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, placeId)) == null) ? !c.a.s0.x1.o.k.a.e(this.a.get(placeId)) : invokeL.booleanValue;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.f24653b = new ConcurrentHashMap();
    }
}
