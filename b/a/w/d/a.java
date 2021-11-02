package b.a.w.d;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.w.d.b.c;
import b.a.w.e.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes6.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.w.b.a f29275a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29276b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29277c;

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
        this.f29276b = b.a().b();
    }

    @Override // b.a.w.d.b.c
    public void a(String str) {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.E(str);
    }

    @Override // b.a.w.d.b.c
    public void b() {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.D();
    }

    @Override // b.a.w.d.b.d
    public void c() {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.G();
    }

    @Override // b.a.w.d.b.c
    public View d(FragmentActivity fragmentActivity, Fragment fragment, String str) {
        InterceptResult invokeLLL;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fragmentActivity, fragment, str)) == null) {
            e("onCreateView hostType:   page: " + str);
            if (this.f29275a == null) {
                int i2 = this.f29276b;
                if (fragment != null) {
                    supportFragmentManager = fragment.getChildFragmentManager();
                } else {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                this.f29275a = new b.a.w.b.a(fragmentActivity, i2, supportFragmentManager, str, "", this.f29277c);
                b.a.w.b.c.a.r(fragmentActivity, "", "zhibopindao");
            }
            return this.f29275a.u();
        }
        return (View) invokeLLL.objValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            LiveFeedPageSdk.l("LiveFeedPageViewImpl " + str + GlideException.IndentedAppendable.INDENT + this.f29275a);
        }
    }

    @Override // b.a.w.d.b.c
    public void onUserVisibleHint(boolean z) {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.L(z);
    }

    @Override // b.a.w.d.b.a
    public void onViewDestroy() {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.F();
    }

    @Override // b.a.w.d.b.a
    public void onViewPause() {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.J();
    }

    @Override // b.a.w.d.b.a
    public void onViewResume() {
        b.a.w.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f29275a) == null) {
            return;
        }
        aVar.K();
    }

    @Override // b.a.w.d.b.a
    public void onViewStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // b.a.w.d.b.a
    public void onViewStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }
}
