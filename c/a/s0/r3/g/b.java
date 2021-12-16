package c.a.s0.r3.g;

import android.content.res.Configuration;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b implements c.a.s0.r3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public f f21994b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.s0.r3.b.b f21995c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.r3.b.c f21996d;

    public b(@NonNull c.a.s0.r3.b.b bVar, @NonNull c.a.s0.r3.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21995c = bVar;
        this.f21996d = cVar;
    }

    @Override // c.a.s0.r3.b.a
    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f21994b) == null) {
            return;
        }
        fVar.n();
    }

    @Override // c.a.s0.r3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e eVar = new e(this.f21995c, this.f21996d, this);
            if (this.f21995c.i()) {
                return false;
            }
            if (this.f21994b == null) {
                this.f21994b = new f(this.f21995c.getActivity());
            }
            if (this.f21994b.h()) {
                this.a = this.f21994b.k(0.8125d);
                this.f21995c.getRootView().addView(this.a);
                this.f21994b.r(eVar);
                this.f21994b.t();
                return true;
            }
            this.f21994b.i();
            return false;
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view = this.a;
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.s0.r3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
        }
    }

    @Override // c.a.s0.r3.b.a
    public void onPause() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f21994b) == null) {
            return;
        }
        fVar.o();
    }

    @Override // c.a.s0.r3.b.a
    public void onResume() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f21994b) == null) {
            return;
        }
        fVar.p();
    }
}
