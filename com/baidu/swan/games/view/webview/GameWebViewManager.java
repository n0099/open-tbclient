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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a13;
import com.repackage.c34;
import com.repackage.i03;
import com.repackage.if3;
import com.repackage.j03;
import com.repackage.pq2;
import com.repackage.tg1;
import com.repackage.tm1;
import com.repackage.vj1;
/* loaded from: classes2.dex */
public class GameWebViewManager extends SwanAppWebViewManager implements tm1<NgWebView>, if3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public FrameLayout w;
    public View.OnClickListener x;
    public NetworkErrorView y;
    public ImageView z;

    /* loaded from: classes2.dex */
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
                boolean z = !a13.h(str);
                if (!z && (a13.e(str) || a13.f(str))) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        j03 a0 = j03.a0();
                        if (a0 != null) {
                            a0.x().startActivity(intent);
                            return true;
                        }
                    } catch (Exception e) {
                        if (GameWebViewManager.B) {
                            e.printStackTrace();
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

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onClick(view2);
        }
    }

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && SwanAppNetworkUtils.i(this.a.a) && a13.h(this.a.u().getUrl())) {
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
        B = tg1.a;
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

    @Override // com.repackage.tm1
    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c34.a(this.w, pq2.a());
            c34.c(this);
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

    @Override // com.repackage.if3
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.rm1
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "SwanGameWebView" : (String) invokeV.objValue;
    }

    @Override // com.repackage.tm1
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w.getParent() != null : invokeV.booleanValue;
    }

    @Override // com.repackage.if3
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r1();
            u().onPause();
        }
    }

    @Override // com.repackage.tm1
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

    @Override // com.repackage.tm1
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
                        return !a13.h(str);
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.rm1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (B) {
                Log.i("SwanGameWebViewManager", "loadUrl:" + str);
            }
            if (a13.h(str)) {
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

    @Override // com.repackage.if3
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
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706e5);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.topMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706e6);
            layoutParams.leftMargin = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f0706e4);
            this.A.setLayoutParams(layoutParams);
            this.A.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.A.setImageResource(R.drawable.obfuscated_res_0x7f0811c5);
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
            int dimension = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706e7);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
            layoutParams.gravity = 17;
            this.z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.z.setImageResource(R.drawable.obfuscated_res_0x7f0811c6);
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

    @Override // com.repackage.tm1
    public void removeFromParent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            u().stopLoading();
            u().clearView();
            c34.d(this.w);
            c34.e(this);
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010135);
            this.z.setVisibility(0);
            this.z.startAnimation(loadAnimation);
        }
    }

    public final void t1(Context context) {
        vj1 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, context) == null) || (a2 = i03.J().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }
}
