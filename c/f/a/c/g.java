package c.f.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f32257a;

    /* renamed from: b  reason: collision with root package name */
    public final Method f32258b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32259c;

    /* renamed from: d  reason: collision with root package name */
    public final EventBus.ThreadMode f32260d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f32261e;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, method, str, Integer.valueOf(i2), threadMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32257a = obj;
        this.f32258b = method;
        this.f32259c = i2;
        this.f32260d = threadMode;
        this.f32261e = true;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return this.f32257a == gVar.f32257a && this.f32258b.equals(gVar.f32258b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32257a.hashCode() + this.f32258b.hashCode() : invokeV.intValue;
    }
}
