package c.a.q0.b4.j;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f16171a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f16172b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.b4.j.a f16173c;

    /* renamed from: d  reason: collision with root package name */
    public View f16174d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f16175e;

    /* renamed from: f  reason: collision with root package name */
    public View f16176f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16177g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.s.f0.a f16178h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.s.f0.c f16179i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16180j;
    public float k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16181e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16181e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16181e.f16175e == null) {
                return;
            }
            this.f16181e.q(false);
            this.f16181e.t();
        }
    }

    /* renamed from: c.a.q0.b4.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0770b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16182e;

        public RunnableC0770b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16182e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16182e.f16172b == null) {
                return;
            }
            this.f16182e.f16172b.ShowSoftKeyPadDelay(this.f16182e.f16175e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16183e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16183e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16183e.f16173c.e();
                this.f16183e.f16172b.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16184a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16184a = bVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f16184a.f16180j = true;
                if (this.f16184a.f16173c != null) {
                    this.f16184a.f16173c.d();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f16184a.q(false);
                this.f16184a.f16172b.showToast(R.string.neterror);
                this.f16184a.f16172b.finish();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || this.f16184a.f16173c == null) {
                    return false;
                }
                if (!this.f16184a.f16180j) {
                    this.f16184a.f16180j = true;
                    this.f16184a.q(false);
                    this.f16184a.t();
                    this.f16184a.f16173c.d();
                    return true;
                }
                return this.f16184a.f16173c.f(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16185e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16185e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f16185e.f16172b.finish();
            }
        }
    }

    public b(AccountAccessActivity accountAccessActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {accountAccessActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16172b = null;
        this.f16173c = null;
        this.f16174d = null;
        this.f16175e = null;
        this.f16176f = null;
        this.f16177g = null;
        this.f16178h = null;
        this.f16179i = null;
        this.f16180j = false;
        this.k = 1.2631578f;
        this.l = new a(this);
        this.m = new RunnableC0770b(this);
        if (accountAccessActivity == null) {
            return;
        }
        this.f16172b = accountAccessActivity;
        if (k(accountAccessActivity)) {
            return;
        }
        accountAccessActivity.finish();
    }

    public Animation f(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f2, f3);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(300L);
            return translateAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public BaseActivity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16172b : (BaseActivity) invokeV.objValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16171a : invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.floatValue;
    }

    public WebView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16175e : (WebView) invokeV.objValue;
    }

    public final boolean k(AccountAccessActivity accountAccessActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, accountAccessActivity)) == null) {
            accountAccessActivity.setActivityBgTransparent();
            accountAccessActivity.setSwipeBackEnabled(false);
            accountAccessActivity.setContentView(R.layout.account_access_activity);
            View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
            this.f16174d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
            this.f16176f = findViewById2;
            TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
            this.f16177g = textView;
            textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
            c.a.p0.s.f0.c cVar = new c.a.p0.s.f0.c();
            this.f16179i = cVar;
            cVar.f13861a = 1000L;
            this.f16171a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
            if (this.f16175e == null) {
                try {
                    this.f16175e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                    UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f16175e, this.k);
                    this.f16175e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                    this.f16175e.setWebViewClient(new d(this));
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.l);
            c.a.e.e.m.e.a().removeCallbacks(this.m);
            this.f16178h = null;
        }
    }

    public void m(c.a.q0.b4.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f16173c = aVar;
        }
    }

    public void n(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.k = f2;
            UtilHelper.setSupportHeight(this.f16172b.getPageContext().getPageActivity(), this.f16175e, f2);
        }
    }

    public void o(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) && (this.f16175e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16175e.getLayoutParams();
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            this.f16175e.setLayoutParams(marginLayoutParams);
        }
    }

    public void p(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (view = this.f16176f) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.f16178h == null) {
                c.a.p0.s.f0.a aVar = new c.a.p0.s.f0.a(this.f16172b.getPageContext());
                this.f16178h = aVar;
                aVar.e(new e(this));
            }
            this.f16178h.h(z);
        }
    }

    public void r(boolean z) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (baseWebView = this.f16175e) == null) {
            return;
        }
        if (z) {
            baseWebView.setVisibility(0);
        } else {
            baseWebView.setVisibility(4);
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            c.a.e.e.m.e.a().postDelayed(this.l, i2);
        }
    }

    public void t() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (baseActivity = this.f16172b) == null) {
            return;
        }
        if (this.k == this.f16171a) {
            int i2 = l.i(baseActivity.getBaseContext());
            BaseWebView baseWebView = this.f16175e;
            baseWebView.startAnimation(f(i2 - (baseWebView.getWidth() * 1.2631578f), 0.0f));
            c.a.e.e.m.e.a().postDelayed(this.m, 800L);
            return;
        }
        BaseWebView baseWebView2 = this.f16175e;
        baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
    }
}
