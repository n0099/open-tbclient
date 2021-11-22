package b.a.r0.i3.g;

import android.content.res.Configuration;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements b.a.r0.i3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19487a;

    /* renamed from: b  reason: collision with root package name */
    public f f19488b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b.a.r0.i3.b.c f19489c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.i3.b.d f19490d;

    public b(@NonNull b.a.r0.i3.b.c cVar, @NonNull b.a.r0.i3.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19489c = cVar;
        this.f19490d = dVar;
    }

    @Override // b.a.r0.i3.b.a
    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f19488b) == null) {
            return;
        }
        fVar.n();
    }

    @Override // b.a.r0.i3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e eVar = new e(this.f19489c, this.f19490d, this);
            if (this.f19489c.isFromHotSplash()) {
                return false;
            }
            if (this.f19488b == null) {
                this.f19488b = new f(this.f19489c.getActivity());
            }
            if (this.f19488b.h()) {
                this.f19487a = this.f19488b.k(0.8125d);
                this.f19489c.getRootView().addView(this.f19487a);
                this.f19488b.r(eVar);
                this.f19488b.t();
                return true;
            }
            this.f19488b.i();
            return false;
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view = this.f19487a;
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.i3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
        }
    }

    @Override // b.a.r0.i3.b.a
    public void onPause() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f19488b) == null) {
            return;
        }
        fVar.o();
    }

    @Override // b.a.r0.i3.b.a
    public void onResume() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f19488b) == null) {
            return;
        }
        fVar.p();
    }
}
