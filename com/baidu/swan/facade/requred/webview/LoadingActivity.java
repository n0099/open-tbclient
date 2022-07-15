package com.baidu.swan.facade.requred.webview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.af3;
import com.repackage.be3;
import com.repackage.bn3;
import com.repackage.g03;
import com.repackage.l03;
import com.repackage.w92;
import com.repackage.x92;
import com.repackage.y92;
import com.repackage.yd3;
/* loaded from: classes2.dex */
public class LoadingActivity extends Activity implements af3<l03.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public y92 f;
    public boolean g;
    public final af3<y92> h;
    public final af3<y92> i;

    /* loaded from: classes2.dex */
    public class a implements af3<y92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0170a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0170a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.j();
                }
            }
        }

        public a(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y92Var) == null) {
                be3.e0(new RunnableC0170a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements af3<y92> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        public b(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y92Var) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        public c(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingActivity;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        public d(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = loadingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    public LoadingActivity() {
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
        this.f = null;
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setText(getString(R.string.obfuscated_res_0x7f0f0198, new Object[]{0}));
            Intent intent = getIntent();
            Bitmap d2 = bn3.b().d();
            if (d2 == null) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801bf);
            } else {
                this.d.setImageBitmap(d2);
            }
            String stringExtra = intent == null ? "" : intent.getStringExtra("so_lib_name");
            y92 j = w92.d.j(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
            this.f = j;
            if (j != null && !j.n()) {
                this.f.v(this.h);
                this.f.u(this.i);
                j();
                return;
            }
            finish();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f09017a);
            this.a = swanAppActionBar;
            swanAppActionBar.f(-16777216, false);
            this.a.setRightExitOnClickListener(new d(this));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901a4);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901a1);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a2);
            this.b = lottieAnimationView;
            lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
            this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a3);
            this.c = lottieAnimationView2;
            lottieAnimationView2.setImageAssetsFolder("swan-loading/images/");
            this.c.setAnimation("swan-loading/aiapps_so_download_anim_second.json");
            this.c.setRepeatCount(-1);
            this.c.setVisibility(4);
            this.b.addAnimatorListener(new c(this));
            this.b.playAnimation();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.af3
    /* renamed from: f */
    public void a(l03.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g03.K().u(this);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.g) {
            return;
        }
        this.b.cancelAnimation();
        this.b.setVisibility(4);
        this.c.setVisibility(0);
        this.c.playAnimation();
        this.g = true;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            g03.K().o(this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            y92 y92Var = this.f;
            x92.b m = y92Var == null ? null : y92Var.m();
            if (m == null || !m.a()) {
                return;
            }
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView == null || min <= 0) {
                return;
            }
            textView.setText(getString(R.string.obfuscated_res_0x7f0f0198, new Object[]{Integer.valueOf(min)}));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            int c0 = be3.c0(this);
            super.onCreate(bundle);
            be3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d0040);
            e();
            d();
            yd3.a(this);
            g();
            c();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.removeAllAnimatorListeners();
            this.b.cancelAnimation();
            this.c.cancelAnimation();
            y92 y92Var = this.f;
            if (y92Var != null) {
                y92Var.g(this.i);
                y92Var.h(this.h);
            }
            i();
            super.onDestroy();
        }
    }
}
