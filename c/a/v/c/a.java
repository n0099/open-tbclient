package c.a.v.c;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.v.c.b.d;
import c.a.v.f.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes3.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.v.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21483b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21484c;

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
        this.f21483b = b.a().b();
    }

    @Override // c.a.v.c.b.d
    public void a(String str) {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.O(str);
    }

    @Override // c.a.v.c.b.b
    public void b() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.P();
    }

    @Override // c.a.v.c.b.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.v.c.b.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.v.c.b.b
    public void e() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.T();
    }

    @Override // c.a.v.c.b.d
    public void f() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.K();
    }

    @Override // c.a.v.c.b.b
    public void g() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.U();
    }

    @Override // c.a.v.c.b.e
    public void h() {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.Q();
    }

    @Override // c.a.v.c.b.d
    public View i(FragmentActivity fragmentActivity, Fragment fragment, String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        FragmentManager supportFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{fragmentActivity, fragment, str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            j("onCreateView hostType:   page: " + str);
            if (this.a == null) {
                int i = this.f21483b;
                if (fragment != null) {
                    supportFragmentManager = fragment.getChildFragmentManager();
                } else {
                    supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                }
                this.a = new c.a.v.b.a(fragmentActivity, i, supportFragmentManager, str, str2, this.f21484c, str3, str4, z);
                c.a.v.b.c.a.s(fragmentActivity, "", "zhibopindao");
            }
            return this.a.z();
        }
        return (View) invokeCommon.objValue;
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            LiveFeedPageSdk.m("LiveFeedPageViewImpl " + str + GlideException.IndentedAppendable.INDENT + this.a);
        }
    }

    @Override // c.a.v.c.b.d
    public void onUserVisibleHint(boolean z) {
        c.a.v.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.V(z);
    }
}
