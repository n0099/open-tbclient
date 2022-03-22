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
import c.a.n0.a.f.e.f;
import c.a.n0.a.q2.c;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements f<NgWebView>, c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public FrameLayout w;
    public View.OnClickListener x;
    public NetworkErrorView y;
    public ImageView z;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.this$0.m1();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, i, str, str2) == null) || i == -10) {
                return;
            }
            this.this$0.y.setVisibility(0);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str)) == null) {
                if (GameWebViewManager.B) {
                    Log.d("SwanGameWebViewManager", "shouldOverrideUrlLoading url: " + str);
                }
                boolean z = !c.a.n0.a.u1.a.b.h(str);
                if (!z && (c.a.n0.a.u1.a.b.e(str) || c.a.n0.a.u1.a.b.f(str))) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        e a0 = e.a0();
                        if (a0 != null) {
                            a0.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e2) {
                        if (GameWebViewManager.B) {
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameWebViewManager a;

        public a(GameWebViewManager gameWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameWebViewManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onClick(view);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameWebViewManager a;

        public b(GameWebViewManager gameWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameWebViewManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && SwanAppNetworkUtils.i(this.a.a) && c.a.n0.a.u1.a.b.h(this.a.u().getUrl())) {
                this.a.u().reload();
                this.a.y.setVisibility(8);
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
        B = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        q1();
        l1();
        b1(new GameWebViewClient(this, null));
        t1(context);
    }

    @Override // c.a.n0.a.f.e.f
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.n0.j.p0.b.a(this.w, c.a.n0.a.c1.e.a.a.a());
            c.a.n0.j.p0.b.c(this);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u().addJavascriptInterface(new GameWebViewJavascriptInterface(), "swan");
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, swanAppWebViewManager) == null) {
        }
    }

    @Override // c.a.n0.a.q2.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SwanGameWebView" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.e.f
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w.getParent() != null : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.q2.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r1();
            u().onPause();
        }
    }

    @Override // c.a.n0.a.f.e.f
    public void i(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (imageView = this.A) == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // c.a.n0.a.f.e.f
    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c1(new BdSailorWebViewClientExt(this) { // from class: com.baidu.swan.games.view.webview.GameWebViewManager.3
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        if (GameWebViewManager.B) {
                            Log.d("SwanGameWebViewManager", "onSubFrameBeforeRequest url: " + str);
                        }
                        return !c.a.n0.a.u1.a.b.h(str);
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d, c.a.n0.a.x.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (B) {
                Log.i("SwanGameWebViewManager", "loadUrl:" + str);
            }
            if (c.a.n0.a.u1.a.b.h(str)) {
                s1();
                super.loadUrl(str);
            }
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.z.getVisibility() == 0) {
            this.z.clearAnimation();
            this.z.setVisibility(8);
        }
    }

    @Override // c.a.n0.a.q2.c
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            u().onResume();
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.A == null) {
            this.A = new ImageView(this.a.getBaseContext());
            Resources resources = this.a.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706d8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706d9);
            layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706d7);
            this.A.setLayoutParams(layoutParams);
            this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.A.setImageResource(R.drawable.obfuscated_res_0x7f0811ba);
            this.A.setClickable(true);
            this.A.setOnClickListener(new a(this));
            this.w.addView(this.A);
        }
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NetworkErrorView networkErrorView = new NetworkErrorView(this.a.getBaseContext());
            this.y = networkErrorView;
            networkErrorView.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0603a6));
            u().addView(this.y, -1, -1);
            this.y.setVisibility(8);
            b bVar = new b(this);
            this.y.setOnClickListener(bVar);
            this.y.setReloadClickListener(bVar);
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.z = new ImageView(this.a.getBaseContext());
            int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706da);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.gravity = 17;
            this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.z.setImageResource(R.drawable.obfuscated_res_0x7f0811bb);
            this.w.addView(this.z, layoutParams);
        }
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a.getBaseContext());
            this.w = frameLayout;
            frameLayout.addView(u(), -1, -1);
            n1();
            o1();
            p1();
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            U0("var eles = document.querySelectorAll('video,audio');eles && eles.forEach(function (item, index) {item.pause();});");
        }
    }

    @Override // c.a.n0.a.f.e.f
    public void removeFromParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            u().stopLoading();
            u().clearView();
            c.a.n0.j.p0.b.d(this.w);
            c.a.n0.j.p0.b.e(this);
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f01012f);
            this.z.setVisibility(0);
            this.z.startAnimation(loadAnimation);
        }
    }

    public final void t1(Context context) {
        c.a.n0.a.f.d.c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, context) == null) || (a2 = d.J().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }
}
