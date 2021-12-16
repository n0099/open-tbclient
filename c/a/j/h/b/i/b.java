package c.a.j.h.b.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<? extends c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>>> a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<? extends c.a.j.h.c.d.a<?>> f3591b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3592c;

    public b(Class<? extends c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>>> cls, Class<? extends c.a.j.h.c.d.a<?>> cls2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cls;
        this.f3591b = cls2;
        this.f3592c = z;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3592c : invokeV.booleanValue;
    }

    public final Class<? extends c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (Class) invokeV.objValue;
    }

    public final Class<? extends c.a.j.h.c.d.a<?>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3591b : (Class) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.f3591b, bVar.f3591b)) {
                        if (this.f3592c == bVar.f3592c) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Class<? extends c.a.j.h.c.d.b<? extends c.a.j.h.c.d.a<?>>> cls = this.a;
            int hashCode = (cls != null ? cls.hashCode() : 0) * 31;
            Class<? extends c.a.j.h.c.d.a<?>> cls2 = this.f3591b;
            int hashCode2 = (hashCode + (cls2 != null ? cls2.hashCode() : 0)) * 31;
            boolean z = this.f3592c;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return hashCode2 + i2;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ToastPlugin(viewClass=" + this.a + ", viewModelClass=" + this.f3591b + ", needSysToastFix=" + this.f3592c + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
