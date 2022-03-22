package c.a.p0.n0.f.d.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public abstract class g<T> extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f16486b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<T> f16487c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16488d;

    public /* synthetic */ g(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    @Override // c.a.p0.n0.f.d.e.b
    public boolean b(c.a.p0.n0.e.a item, c.a.p0.n0.k.b timer, c.a.p0.n0.a config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, timer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(timer, "timer");
            Intrinsics.checkNotNullParameter(config, "config");
            if (this.f16488d) {
                boolean contains = this.f16487c.contains(c(item.e()));
                return this.f16486b ? !contains : contains;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public abstract T c(c.a.p0.n0.e.b bVar);

    public final Set<T> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Set<T> mFilterSet = this.f16487c;
            Intrinsics.checkNotNullExpressionValue(mFilterSet, "mFilterSet");
            return mFilterSet;
        }
        return (Set) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, boolean z) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16486b = z;
        this.f16487c = Collections.synchronizedSet(new LinkedHashSet());
        this.f16488d = true;
    }
}
