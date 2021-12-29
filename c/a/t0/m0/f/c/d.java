package c.a.t0.m0.f.c;

import androidx.core.view.InputDeviceCompat;
import c.b.a.a.e;
import c.b.a.a.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class d extends b implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final g f19750i;

    /* renamed from: j  reason: collision with root package name */
    public final Comparator<c.b.a.a.d> f19751j;

    /* renamed from: k  reason: collision with root package name */
    public final List<c.b.a.a.d> f19752k;
    public boolean l;

    public /* synthetic */ d(c.a.t0.m0.f.a aVar, g gVar, Comparator comparator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, gVar, (i2 & 4) != 0 ? new c() : comparator);
    }

    @Override // c.b.a.a.e
    public void a(c.b.a.a.d entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.f19752k.remove(entity);
            this.l = true;
        }
    }

    @Override // c.b.a.a.e
    public void b(c.b.a.a.d entity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entity) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.f19752k.add(entity);
            this.l = true;
        }
    }

    @Override // c.b.a.a.f
    public void c(c.b.a.a.c engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.f19752k.clear();
            c.b.a.c.b<c.b.a.a.d> newEntities = engine.j(this.f19750i);
            if (newEntities.size() > 0) {
                List<c.b.a.a.d> list = this.f19752k;
                Intrinsics.checkNotNullExpressionValue(newEntities, "newEntities");
                CollectionsKt__MutableCollectionsKt.addAll(list, newEntities);
            }
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.f19752k, this.f19751j);
            this.l = false;
            engine.f(this.f19750i, this);
        }
    }

    @Override // c.a.t0.m0.f.c.b, c.b.a.a.f
    public void g(c.b.a.a.c engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
            super.g(engine);
            engine.o(this);
            this.f19752k.clear();
            this.l = false;
        }
    }

    @Override // c.a.t0.m0.f.c.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final List<c.b.a.a.d> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            m();
            return this.f19752k;
        }
        return (List) invokeV.objValue;
    }

    public abstract void l(c.b.a.a.d dVar, float f2);

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.l) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(this.f19752k, this.f19751j);
            this.l = false;
        }
    }

    @Override // c.b.a.a.f
    public void update(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            m();
            for (c.b.a.a.d dVar : this.f19752k) {
                l(dVar, f2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.t0.m0.f.a context, g family, Comparator<c.b.a.a.d> comparator) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, family, comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.t0.m0.f.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        this.f19750i = family;
        this.f19751j = comparator;
        this.f19752k = new ArrayList();
    }
}
