package c.a.t0.r3.g;

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
public class b implements c.a.t0.r3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public f f22506b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final c.a.t0.r3.b.b f22507c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final c.a.t0.r3.b.c f22508d;

    public b(@NonNull c.a.t0.r3.b.b bVar, @NonNull c.a.t0.r3.b.c cVar) {
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
        this.f22507c = bVar;
        this.f22508d = cVar;
    }

    @Override // c.a.t0.r3.b.a
    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f22506b) == null) {
            return;
        }
        fVar.n();
    }

    @Override // c.a.t0.r3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e eVar = new e(this.f22507c, this.f22508d, this);
            if (this.f22507c.i()) {
                return false;
            }
            if (this.f22506b == null) {
                this.f22506b = new f(this.f22507c.getActivity());
            }
            if (this.f22506b.h()) {
                this.a = this.f22506b.k(0.8125d);
                this.f22507c.getRootView().addView(this.a);
                this.f22506b.r(eVar);
                this.f22506b.t();
                return true;
            }
            this.f22506b.i();
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

    @Override // c.a.t0.r3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
        }
    }

    @Override // c.a.t0.r3.b.a
    public void onPause() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f22506b) == null) {
            return;
        }
        fVar.o();
    }

    @Override // c.a.t0.r3.b.a
    public void onResume() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f22506b) == null) {
            return;
        }
        fVar.p();
    }
}
