package com.baidu.swan.games.view.webview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.k;
import d.a.n0.a.p.e.f;
import d.a.n0.a.w2.c;
import d.a.n0.f.d;
/* loaded from: classes3.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements f<NgWebView>, c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public View.OnClickListener B;
    public NetworkErrorView C;
    public ImageView D;
    public ImageView E;

    /* loaded from: classes3.dex */
    public class GameWebViewClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameWebViewManager this$0;

        public GameWebViewClient(GameWebViewManager gameWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = gameWebViewManager;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                this.this$0.j1();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, i2, str, str2) == null) || i2 == -10) {
                return;
            }
            this.this$0.C.setVisibility(0);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str)) == null) {
                if (GameWebViewManager.F) {
                    Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
                }
                boolean z = !d.a.n0.a.b2.a.b.h(str);
                if (!z && (d.a.n0.a.b2.a.b.e(str) || d.a.n0.a.b2.a.b.f(str))) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        e Q = e.Q();
                        if (Q != null) {
                            Q.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e2) {
                        if (GameWebViewManager.F) {
                            e2.printStackTrace();
                        }
                    }
                }
                return z;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ GameWebViewClient(GameWebViewManager gameWebViewManager, a aVar) {
            this(gameWebViewManager);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameWebViewManager f11985e;

        public a(GameWebViewManager gameWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11985e = gameWebViewManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f11985e.B == null) {
                return;
            }
            this.f11985e.B.onClick(view);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GameWebViewManager f11986e;

        public b(GameWebViewManager gameWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11986e = gameWebViewManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && SwanAppNetworkUtils.i(this.f11986e.f10936e) && d.a.n0.a.b2.a.b.h(this.f11986e.u().getUrl())) {
                this.f11986e.u().reload();
                this.f11986e.C.setVisibility(8);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1419382643, "Lcom/baidu/swan/games/view/webview/GameWebViewManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1419382643, "Lcom/baidu/swan/games/view/webview/GameWebViewManager;");
                return;
            }
        }
        F = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameWebViewManager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n1();
        i1();
        Y0(new GameWebViewClient(this, null));
        q1(context);
    }

    @Override // d.a.n0.a.p.e.f
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.n0.h.o0.b.a(this.A, d.a.n0.a.l1.e.a.a.d());
            d.a.n0.h.o0.b.c(this);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, swanAppWebViewManager) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanGameWebView" : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.f
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.A.getParent() != null : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.w2.c
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            o1();
            u().onPause();
        }
    }

    @Override // d.a.n0.a.p.e.f
    public void h(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (imageView = this.E) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Z0(new BdSailorWebViewClientExt(this) { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GameWebViewManager this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
                public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, bdSailorWebView, str)) == null) {
                        if (GameWebViewManager.F) {
                            Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                        }
                        return !d.a.n0.a.b2.a.b.h(str);
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // d.a.n0.a.p.e.f
    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.B = onClickListener;
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.D.getVisibility() == 0) {
            this.D.clearAnimation();
            this.D.setVisibility(8);
        }
    }

    @Override // d.a.n0.a.w2.c
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            destroy();
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.E == null) {
            this.E = new ImageView(this.f10936e.getBaseContext());
            Resources resources = this.f10936e.getResources();
            int dimension = (int) resources.getDimension(d.a.n0.f.c.swangame_webview_button_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(d.a.n0.f.c.swangame_webview_button_top_margin);
            layoutParams.leftMargin = (int) resources.getDimension(d.a.n0.f.c.swangame_webview_button_left_margin);
            this.E.setLayoutParams(layoutParams);
            this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.E.setImageResource(d.swangame_webview_close_button);
            this.E.setClickable(true);
            this.E.setOnClickListener(new a(this));
            this.A.addView(this.E);
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            NetworkErrorView networkErrorView = new NetworkErrorView(this.f10936e.getBaseContext());
            this.C = networkErrorView;
            networkErrorView.setBackgroundColor(this.f10936e.getResources().getColor(d.a.n0.f.b.aiapps_game_white));
            u().addView(this.C, -1, -1);
            this.C.setVisibility(8);
            b bVar = new b(this);
            this.C.setOnClickListener(bVar);
            this.C.setReloadClickListener(bVar);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (F) {
                Log.i("SwanGameWebViewManager", "loadUrl:" + str);
            }
            if (d.a.n0.a.b2.a.b.h(str)) {
                p1();
                super.loadUrl(str);
            }
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.D = new ImageView(this.f10936e.getBaseContext());
            int dimension = (int) this.f10936e.getResources().getDimension(d.a.n0.f.c.swangame_webview_loading_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.gravity = 17;
            this.D.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.D.setImageResource(d.swangame_webview_loading);
            this.A.addView(this.D, layoutParams);
        }
    }

    @Override // d.a.n0.a.w2.c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            u().onResume();
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f10936e.getBaseContext());
            this.A = frameLayout;
            frameLayout.addView(u(), -1, -1);
            k1();
            l1();
            m1();
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            R0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f10936e, d.a.n0.f.a.swangame_webview_loading);
            this.D.setVisibility(0);
            this.D.startAnimation(loadAnimation);
        }
    }

    public final void q1(Context context) {
        d.a.n0.a.p.d.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, context) == null) || (a2 = d.a.n0.a.a2.d.g().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }

    @Override // d.a.n0.a.p.e.f
    public void removeFromParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            u().stopLoading();
            u().clearView();
            d.a.n0.h.o0.b.d(this.A);
            d.a.n0.h.o0.b.e(this);
        }
    }
}
