package c.a.p0.n0.f.d.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes2.dex */
public final class a extends g<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Function1<Long, Boolean> f16482e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function1<? super Long, Boolean> selfPredicate) {
        super(2048, false, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {selfPredicate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(selfPredicate, "selfPredicate");
        this.f16482e = selfPredicate;
    }

    @Override // c.a.p0.n0.f.d.e.g, c.a.p0.n0.f.d.e.b
    public boolean b(c.a.p0.n0.e.a item, c.a.p0.n0.k.b timer, c.a.p0.n0.a config) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, timer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(timer, "timer");
            Intrinsics.checkNotNullParameter(config, "config");
            c.a.p0.n0.e.b e2 = item.e();
            if (!this.f16482e.invoke(e2.o()).booleanValue()) {
                Set<String> d2 = d();
                if (!(d2 instanceof Collection) || !d2.isEmpty()) {
                    for (String str : d2) {
                        if (StringsKt__StringsKt.contains$default((CharSequence) e2.c(), (CharSequence) str, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.n0.f.d.e.g
    /* renamed from: e */
    public String c(c.a.p0.n0.e.b data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.c();
        }
        return (String) invokeL.objValue;
    }
}
