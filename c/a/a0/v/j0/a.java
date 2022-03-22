package c.a.a0.v.j0;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends j implements c.a.a0.v.f0.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f1740e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.a0.v.f0.a f1741f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1740e = new FrameLayout(this.f1743c);
        O(8);
    }

    @Override // c.a.a0.v.j0.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            H(this);
        }
    }

    public void K(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f1740e.addView(view);
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1740e.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f1740e.removeAllViews();
        }
    }

    public void N(c.a.a0.v.f0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f1741f = aVar;
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f1740e.setVisibility(i);
        }
    }

    @Override // c.a.a0.v.f0.k
    public boolean e(@NonNull c.a.a0.v.c0.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pVar)) == null) {
            c.a.a0.v.f0.a aVar = this.f1741f;
            if (aVar == null) {
                return false;
            }
            return aVar.b(pVar.c());
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.a0.v.j0.o
    @NonNull
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1740e : (View) invokeV.objValue;
    }

    @Override // c.a.a0.v.f0.k
    public c.a.a0.v.f0.j getInterceptorLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (c.a.a0.v.f0.j) invokeV.objValue;
    }

    @Override // c.a.a0.v.j0.j, c.a.a0.v.j0.b, c.a.a0.v.j0.o
    public void onLayerRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onLayerRelease();
            H(null);
            c.a.a0.v.f0.a aVar = this.f1741f;
            if (aVar != null) {
                aVar.onLayerRelease();
                this.f1741f = null;
            }
        }
    }
}
