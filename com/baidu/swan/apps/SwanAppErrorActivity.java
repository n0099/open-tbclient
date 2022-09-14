package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.f22;
import com.baidu.tieba.fm2;
import com.baidu.tieba.i53;
import com.baidu.tieba.ij1;
import com.baidu.tieba.n83;
import com.baidu.tieba.sg3;
import com.baidu.tieba.vn2;
import com.baidu.tieba.wg4;
import com.baidu.tieba.xz2;
import com.baidu.tieba.zz2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public vn2 j;
    public ForbiddenInfo k;
    public String l;
    public n83 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public int t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537864007, "Lcom/baidu/swan/apps/SwanAppErrorActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(537864007, "Lcom/baidu/swan/apps/SwanAppErrorActivity;");
                return;
            }
        }
        u = ij1.a;
    }

    public SwanAppErrorActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = 0;
        this.o = 0;
        this.r = "";
    }

    public final void A(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        this.j = vn2.d1(intent);
        this.k = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
        this.p = intent.getIntExtra("swan_error_menu_notice_count", 0);
        this.q = intent.getIntExtra("swan_error_menu_privacy_count", 0);
        this.s = intent.getStringExtra(DeepLinkItem.DEEPLINK_WEBURL_KEY);
        this.t = intent.getIntExtra("webPermit", -1);
        this.r = intent.getStringExtra("swan_error_code");
        if (TextUtils.isEmpty(this.j.H()) && (forbiddenInfo = this.k) != null) {
            this.j.v0(forbiddenInfo.appId);
        }
        this.l = intent.getStringExtra("swan_error_type");
    }

    public final void B(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.n = i;
            this.o = i2;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.n == 0 && this.o == 0) {
                return;
            }
            overridePendingTransition(this.n, this.o);
            this.n = 0;
            this.o = 0;
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            z(fm2.M().a());
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.finish();
            C();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.og4, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            B(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010023);
            int c0 = sg3.c0(this);
            super.onCreate(bundle);
            sg3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d00a1);
            A(getIntent());
            y();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            super.onNewIntent(intent);
            A(intent);
            y();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            D();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        xz2 i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            if (TextUtils.equals(this.l, "type_app_forbidden") && (i = zz2.k().i(this.k.appId)) != null && i.E()) {
                i53.K(this.k.appId);
            }
        }
    }

    public ForbiddenInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : (ForbiddenInfo) invokeV.objValue;
    }

    public vn2 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (vn2) invokeV.objValue;
    }

    public final void y() {
        f22 f22Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            wg4 a = l().a();
            if (getIntent() != null) {
                f22Var = f22.f3(this.r, this.l, this.s, this.t, this.k, this.p, this.q);
            } else if (this.j == null) {
                if (u) {
                    Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                    return;
                }
                return;
            } else {
                f22Var = new f22();
            }
            a.a(R.id.obfuscated_res_0x7f090179, f22Var);
            a.e();
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Window window = getWindow();
            if (window == null) {
                if (u) {
                    Log.e("SwanAppErrorActivity", "activity or window is null");
                    return;
                }
                return;
            }
            if (this.m == null) {
                this.m = new n83();
            }
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (z) {
                this.m.a(viewGroup);
            } else {
                this.m.b(viewGroup);
            }
        }
    }
}
