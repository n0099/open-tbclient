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
import c.a.n0.a.d0.k.d;
import c.a.n0.a.d0.k.e;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.t1.i;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LoadingActivity extends Activity implements c.a.n0.a.p2.g1.c<i.a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_ID_HIDE = "loading_hide";
    public static final String EXT_SO_LIB_NAME = "so_lib_name";
    public static final String LOTTIE_ANIM_FIRST_NAME = "swan-loading/aiapps_so_download_anim_first.json";
    public static final String LOTTIE_ANIM_SECOND_NAME = "swan-loading/aiapps_so_download_anim_second.json";
    public static final String LOTTIE_ASSETS_PATH = "swan-loading/images/";
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MIN = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.p2.g1.c<e> mFinishCallback;
    public boolean mFirstAnimIsLoaded;
    public LottieAnimationView mFirstLottieAnimationView;
    public ImageView mLogoView;
    public final c.a.n0.a.p2.g1.c<e> mProgressCallback;
    public TextView mProgressView;
    public LottieAnimationView mSecondLottieAnimationView;
    public SwanAppActionBar mSwanAppActionBar;
    public e mUpdating;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.a.p2.g1.c<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LoadingActivity a;

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1825a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC1825a(a aVar) {
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
                    this.a.a.updateUiProgress();
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                q0.e0(new RunnableC1825a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.n0.a.p2.g1.c<e> {
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
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.startSecondAnim();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
        this.mUpdating = null;
        this.mFirstAnimIsLoaded = false;
        this.mProgressCallback = new a(this);
        this.mFinishCallback = new b(this);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mProgressView.setText(getString(R.string.obfuscated_res_0x7f0f0192, new Object[]{0}));
            Intent intent = getIntent();
            Bitmap d2 = c.a.n0.g.k.b.b.b().d();
            if (d2 == null) {
                this.mLogoView.setImageResource(R.drawable.obfuscated_res_0x7f0801c0);
            } else {
                this.mLogoView.setImageBitmap(d2);
            }
            String stringExtra = intent == null ? "" : intent.getStringExtra(EXT_SO_LIB_NAME);
            e j = c.a.n0.a.d0.k.c.f4054d.j(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
            this.mUpdating = j;
            if (j != null && !j.n()) {
                this.mUpdating.v(this.mProgressCallback);
                this.mUpdating.u(this.mFinishCallback);
                updateUiProgress();
                return;
            }
            finish();
        }
    }

    private void initActionBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f09017e);
            this.mSwanAppActionBar = swanAppActionBar;
            swanAppActionBar.f(-16777216, false);
            this.mSwanAppActionBar.setRightExitOnClickListener(new d(this));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mProgressView = (TextView) findViewById(R.id.obfuscated_res_0x7f0901a8);
            this.mLogoView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0901a5);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a6);
            this.mFirstLottieAnimationView = lottieAnimationView;
            lottieAnimationView.setImageAssetsFolder(LOTTIE_ASSETS_PATH);
            this.mFirstLottieAnimationView.setAnimation(LOTTIE_ANIM_FIRST_NAME);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0901a7);
            this.mSecondLottieAnimationView = lottieAnimationView2;
            lottieAnimationView2.setImageAssetsFolder(LOTTIE_ASSETS_PATH);
            this.mSecondLottieAnimationView.setAnimation(LOTTIE_ANIM_SECOND_NAME);
            this.mSecondLottieAnimationView.setRepeatCount(-1);
            this.mSecondLottieAnimationView.setVisibility(4);
            this.mFirstLottieAnimationView.addAnimatorListener(new c(this));
            this.mFirstLottieAnimationView.playAnimation();
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            c.a.n0.a.t1.d.J().v(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSecondAnim() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.mFirstAnimIsLoaded) {
            return;
        }
        this.mFirstLottieAnimationView.cancelAnimation();
        this.mFirstLottieAnimationView.setVisibility(4);
        this.mSecondLottieAnimationView.setVisibility(0);
        this.mSecondLottieAnimationView.playAnimation();
        this.mFirstAnimIsLoaded = true;
    }

    private void unregisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            c.a.n0.a.t1.d.J().p(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            int c0 = q0.c0(this);
            super.onCreate(bundle);
            q0.g(this, c0);
            setContentView(R.layout.obfuscated_res_0x7f0d0040);
            initViews();
            initActionBar();
            n0.a(this);
            registerListener();
            init();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mFirstLottieAnimationView.removeAllAnimatorListeners();
            this.mFirstLottieAnimationView.cancelAnimation();
            this.mSecondLottieAnimationView.cancelAnimation();
            e eVar = this.mUpdating;
            if (eVar != null) {
                eVar.g(this.mFinishCallback);
                eVar.h(this.mProgressCallback);
            }
            unregisterListener();
            super.onDestroy();
        }
    }

    public void updateUiProgress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = this.mUpdating;
            d.b m = eVar == null ? null : eVar.m();
            if (m == null || !m.a()) {
                return;
            }
            int min = (int) ((Math.min(Math.max(m.a, 0L), m.f4060b) / m.f4060b) * 100.0d);
            TextView textView = this.mProgressView;
            if (textView == null || min <= 0) {
                return;
            }
            textView.setText(getString(R.string.obfuscated_res_0x7f0f0192, new Object[]{Integer.valueOf(min)}));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.p2.g1.c
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && TextUtils.equals(aVar.f6352b, EVENT_ID_HIDE)) {
            finish();
        }
    }
}
