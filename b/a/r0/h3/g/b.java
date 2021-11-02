package b.a.r0.h3.g;

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
public class b implements b.a.r0.h3.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f17776a;

    /* renamed from: b  reason: collision with root package name */
    public f f17777b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final b.a.r0.h3.b.c f17778c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final b.a.r0.h3.b.d f17779d;

    public b(@NonNull b.a.r0.h3.b.c cVar, @NonNull b.a.r0.h3.b.d dVar) {
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
        this.f17778c = cVar;
        this.f17779d = dVar;
    }

    @Override // b.a.r0.h3.b.a
    public void a() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f17777b) == null) {
            return;
        }
        fVar.n();
    }

    @Override // b.a.r0.h3.b.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e eVar = new e(this.f17778c, this.f17779d, this);
            if (this.f17778c.isFromHotSplash()) {
                return false;
            }
            if (this.f17777b == null) {
                this.f17777b = new f(this.f17778c.getActivity());
            }
            if (this.f17777b.h()) {
                this.f17776a = this.f17777b.k(0.8125d);
                this.f17778c.getRootView().addView(this.f17776a);
                this.f17777b.r(eVar);
                this.f17777b.t();
                return true;
            }
            this.f17777b.i();
            return false;
        }
        return invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view = this.f17776a;
            if (view != null) {
                return view.getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.h3.b.a
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) {
        }
    }

    @Override // b.a.r0.h3.b.a
    public void onPause() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f17777b) == null) {
            return;
        }
        fVar.o();
    }

    @Override // b.a.r0.h3.b.a
    public void onResume() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f17777b) == null) {
            return;
        }
        fVar.p();
    }
}
