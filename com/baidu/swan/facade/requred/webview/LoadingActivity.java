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
import com.repackage.d13;
import com.repackage.oa2;
import com.repackage.pa2;
import com.repackage.qa2;
import com.repackage.qe3;
import com.repackage.sf3;
import com.repackage.te3;
import com.repackage.tn3;
import com.repackage.y03;
/* loaded from: classes3.dex */
public class LoadingActivity extends Activity implements sf3<d13.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActionBar a;
    public LottieAnimationView b;
    public LottieAnimationView c;
    public ImageView d;
    public TextView e;
    public qa2 f;
    public boolean g;
    public final sf3<qa2> h;
    public final sf3<qa2> i;

    /* loaded from: classes3.dex */
    public class a implements sf3<qa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0185a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0185a(a aVar) {
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa2Var) == null) {
                te3.e0(new RunnableC0185a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements sf3<qa2> {
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
        @Override // com.repackage.sf3
        /* renamed from: b */
        public void a(qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa2Var) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            this.e.setText(getString(R.string.obfuscated_res_0x7f0f019b, new Object[]{0}));
            Intent intent = getIntent();
            Bitmap d2 = tn3.b().d();
            if (d2 == null) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f0801bf);
            } else {
                this.d.setImageBitmap(d2);
            }
            String stringExtra = intent == null ? "" : intent.getStringExtra("so_lib_name");
            qa2 j = oa2.d.j(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
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
            SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f090180);
            this.a = swanAppActionBar;
            swanAppActionBar.f(-16777216, false);
            this.a.setRightExitOnClickListener(new d(this));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0901aa);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901a7);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.b = lottieAnimationView;
            lottieAnimationView.setImageAssetsFolder("swan-loading/images/");
            this.b.setAnimation("swan-loading/aiapps_so_download_anim_first.json");
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a9);
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
    @Override // com.repackage.sf3
    /* renamed from: f */
    public void a(d13.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) && TextUtils.equals(aVar.b, "loading_hide")) {
            finish();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            y03.K().u(this);
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
            y03.K().o(this);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qa2 qa2Var = this.f;
            pa2.b m = qa2Var == null ? null : qa2Var.m();
            if (m == null || !m.a()) {
                return;
            }
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.b) / m.b) * 100.0d);
            TextView textView = this.e;
            if (textView == null || min <= 0) {
                return;
            }
            textView.setText(getString(R.string.obfuscated_res_0x7f0f019b, new Object[]{Integer.valueOf(min)}));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            int c0 = te3.c0(this);
            super.onCreate(bundle);
            te3.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d0040);
            e();
            d();
            qe3.a(this);
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
            qa2 qa2Var = this.f;
            if (qa2Var != null) {
                qa2Var.g(this.i);
                qa2Var.h(this.h);
            }
            i();
            super.onDestroy();
        }
    }
}
