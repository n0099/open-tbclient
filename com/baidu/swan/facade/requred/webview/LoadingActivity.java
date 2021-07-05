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
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import d.a.q0.a.n0.k.d;
import d.a.q0.a.n0.k.e;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
/* loaded from: classes4.dex */
public class LoadingActivity extends Activity implements d.a.q0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_ID_HIDE = "loading_hide";
    public static final String EXT_SO_LIB_NAME = "so_lib_name";
    public static final String LOTTIE_ANIM_FIRST_NAME = "aiapps_so_download_anim_first.json";
    public static final String LOTTIE_ANIM_SECOND_NAME = "aiapps_so_download_anim_second.json";
    public static final String LOTTIE_ASSETS_PATH = "images/";
    public static final int PROGRESS_MAX = 100;
    public static final int PROGRESS_MIN = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final d.a.q0.a.v2.e1.b<e> mFinishCallback;
    public boolean mFirstAnimIsLoaded;
    public LottieAnimationView mFirstLottieAnimationView;
    public ImageView mLogoView;
    public final d.a.q0.a.v2.e1.b<e> mProgressCallback;
    public TextView mProgressView;
    public LottieAnimationView mSecondLottieAnimationView;
    public SwanAppActionBar mSwanAppActionBar;
    public e mUpdating;

    /* loaded from: classes4.dex */
    public class a implements d.a.q0.a.v2.e1.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingActivity f11732e;

        /* renamed from: com.baidu.swan.facade.requred.webview.LoadingActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0182a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11733e;

            public RunnableC0182a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11733e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11733e.f11732e.updateUiProgress();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11732e = loadingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                q0.b0(new RunnableC0182a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.q0.a.v2.e1.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingActivity f11734e;

        public b(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11734e = loadingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                this.f11734e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingActivity f11735e;

        public c(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11735e = loadingActivity;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.f11735e.startSecondAnim();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LoadingActivity f11736e;

        public d(LoadingActivity loadingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loadingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11736e = loadingActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11736e.finish();
            }
        }
    }

    public LoadingActivity() {
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
        this.mUpdating = null;
        this.mFirstAnimIsLoaded = false;
        this.mProgressCallback = new a(this);
        this.mFinishCallback = new b(this);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mProgressView.setText(getString(d.a.q0.e.e.aiapps_loading_text, new Object[]{0}));
            Intent intent = getIntent();
            Bitmap d2 = d.a.q0.e.o.b.b.b().d();
            if (d2 == null) {
                this.mLogoView.setImageResource(d.a.q0.e.b.aiapps_so_download_logo);
            } else {
                this.mLogoView.setImageBitmap(d2);
            }
            String stringExtra = intent == null ? "" : intent.getStringExtra(EXT_SO_LIB_NAME);
            e j = d.a.q0.a.n0.k.c.f49579d.j(TextUtils.isEmpty(stringExtra) ? "" : stringExtra);
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
            SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(d.a.q0.e.c.ai_apps_title_bar);
            this.mSwanAppActionBar = swanAppActionBar;
            swanAppActionBar.f(-16777216, false);
            this.mSwanAppActionBar.setRightExitOnClickListener(new d(this));
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.mProgressView = (TextView) findViewById(d.a.q0.e.c.aiapps_so_download_progress);
            this.mLogoView = (ImageView) findViewById(d.a.q0.e.c.aiapps_so_download_logo);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(d.a.q0.e.c.aiapps_so_download_lottie);
            this.mFirstLottieAnimationView = lottieAnimationView;
            lottieAnimationView.setImageAssetsFolder(LOTTIE_ASSETS_PATH);
            this.mFirstLottieAnimationView.setAnimation(LOTTIE_ANIM_FIRST_NAME);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(d.a.q0.e.c.aiapps_so_download_lottie2);
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            d.a.q0.a.a2.d.g().v(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSecondAnim() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.mFirstAnimIsLoaded) {
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
            d.a.q0.a.a2.d.g().p(this);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            int Z = q0.Z(this);
            super.onCreate(bundle);
            q0.g(this, Z);
            setContentView(d.a.q0.e.d.activity_loading);
            initViews();
            initActionBar();
            n0.a(this);
            registerListener();
            init();
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
            int min = (int) ((Math.min(Math.max(m.f49589a, 0L), m.f49590b) / m.f49590b) * 100.0d);
            TextView textView = this.mProgressView;
            if (textView == null || min <= 0) {
                return;
            }
            textView.setText(getString(d.a.q0.e.e.aiapps_loading_text, new Object[]{Integer.valueOf(min)}));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.v2.e1.b
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && TextUtils.equals(aVar.f46689f, EVENT_ID_HIDE)) {
            finish();
        }
    }
}
