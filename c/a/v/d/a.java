package c.a.v.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.v.d.b.c;
import c.a.v.e.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes4.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.v.b.a f30064a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30065b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30066c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30065b = b.a().b();
    }

    @Override // c.a.v.d.b.c
    public void a(String str) {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.F(str);
    }

    @Override // c.a.v.d.b.a
    public void b() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.G();
    }

    @Override // c.a.v.d.b.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.v.d.b.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.v.d.b.a
    public void e() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.K();
    }

    @Override // c.a.v.d.b.c
    public void f() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.E();
    }

    @Override // c.a.v.d.b.a
    public void g() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.L();
    }

    @Override // c.a.v.d.b.d
    public void h() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.H();
    }

    @Override // c.a.v.d.b.c
    public View i(FragmentActivity fragmentActivity, Fragment fragment, String str) {
        InterceptResult invokeLLL;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fragmentActivity, fragment, str)) == null) {
            j("onCreateView hostType:   page: " + str);
            if (this.f30064a == null) {
                int i2 = this.f30065b;
                if (fragment != null) {
                    supportFragmentManager = fragment.getChildFragmentManager();
                } else {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                this.f30064a = new c.a.v.b.a(fragmentActivity, i2, supportFragmentManager, str, "", this.f30066c);
                c.a.v.b.c.a.r(fragmentActivity, "", "zhibopindao");
            }
            return this.f30064a.v();
        }
        return (View) invokeLLL.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            LiveFeedPageSdk.l("LiveFeedPageViewImpl " + str + GlideException.IndentedAppendable.INDENT + this.f30064a);
        }
    }

    @Override // c.a.v.d.b.c
    public void onUserVisibleHint(boolean z) {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (aVar = this.f30064a) == null) {
            return;
        }
        aVar.M(z);
    }
}
