package b.a.r0.d4.j;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f15867a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f15868b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.r0.d4.j.a f15869c;

    /* renamed from: d  reason: collision with root package name */
    public View f15870d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f15871e;

    /* renamed from: f  reason: collision with root package name */
    public View f15872f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15873g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.g0.a f15874h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.q0.s.g0.c f15875i;
    public boolean j;
    public float k;
    public Runnable l;
    public Runnable m;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15876e;

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
            this.f15876e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15876e.f15871e == null) {
                return;
            }
            this.f15876e.p(false);
            this.f15876e.s();
        }
    }

    /* renamed from: b.a.r0.d4.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0808b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15877e;

        public RunnableC0808b(b bVar) {
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
            this.f15877e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15877e.f15868b == null) {
                return;
            }
            this.f15877e.f15868b.ShowSoftKeyPadDelay(this.f15877e.f15871e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15878e;

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
            this.f15878e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15878e.f15869c.e();
                this.f15878e.f15868b.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15879a;

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
            this.f15879a = bVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f15879a.j = true;
                if (this.f15879a.f15869c != null) {
                    this.f15879a.f15869c.d();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f15879a.p(false);
                this.f15879a.f15868b.showToast(R.string.neterror);
                this.f15879a.f15868b.finish();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (StringUtils.isNull(str) || this.f15879a.f15869c == null) {
                    return false;
                }
                if (!this.f15879a.j) {
                    this.f15879a.j = true;
                    this.f15879a.p(false);
                    this.f15879a.s();
                    this.f15879a.f15869c.d();
                    return true;
                }
                return this.f15879a.f15869c.f(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f15880e;

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
            this.f15880e = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f15880e.f15868b.finish();
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
        this.f15868b = null;
        this.f15869c = null;
        this.f15870d = null;
        this.f15871e = null;
        this.f15872f = null;
        this.f15873g = null;
        this.f15874h = null;
        this.f15875i = null;
        this.j = false;
        this.k = 1.2631578f;
        this.l = new a(this);
        this.m = new RunnableC0808b(this);
        if (accountAccessActivity == null) {
            return;
        }
        this.f15868b = accountAccessActivity;
        if (j(accountAccessActivity)) {
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

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15867a : invokeV.floatValue;
    }

    public BaseActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15868b : (BaseActivity) invokeV.objValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.floatValue;
    }

    public WebView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15871e : (WebView) invokeV.objValue;
    }

    public final boolean j(AccountAccessActivity accountAccessActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, accountAccessActivity)) == null) {
            accountAccessActivity.setActivityBgTransparent();
            accountAccessActivity.setSwipeBackEnabled(false);
            accountAccessActivity.setContentView(R.layout.account_access_activity);
            View findViewById = accountAccessActivity.findViewById(R.id.account_access_black_layout);
            this.f15870d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = accountAccessActivity.findViewById(R.id.aa_post_thread_loading_view);
            this.f15872f = findViewById2;
            TextView textView = (TextView) findViewById2.findViewById(R.id.custom_loading_text);
            this.f15873g = textView;
            textView.setText(accountAccessActivity.getResources().getString(R.string.sending));
            b.a.q0.s.g0.c cVar = new b.a.q0.s.g0.c();
            this.f15875i = cVar;
            cVar.f12958a = 1000L;
            this.f15867a = l.k(accountAccessActivity.getBaseContext()) / l.i(accountAccessActivity.getBaseContext());
            if (this.f15871e == null) {
                try {
                    this.f15871e = (BaseWebView) accountAccessActivity.findViewById(R.id.account_access_webview);
                    UtilHelper.setSupportHeight(accountAccessActivity.getPageContext().getPageActivity(), this.f15871e, this.k);
                    this.f15871e.setBackgroundColor(accountAccessActivity.getResources().getColor(17170443));
                    this.f15871e.setWebViewClient(new d(this));
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

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.l);
            b.a.e.e.m.e.a().removeCallbacks(this.m);
            this.f15874h = null;
        }
    }

    public void l(b.a.r0.d4.j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f15869c = aVar;
        }
    }

    public void m(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.k = f2;
            UtilHelper.setSupportHeight(this.f15868b.getPageContext().getPageActivity(), this.f15871e, f2);
        }
    }

    public void n(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) && (this.f15871e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f15871e.getLayoutParams();
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            this.f15871e.setLayoutParams(marginLayoutParams);
        }
    }

    public void o(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (view = this.f15872f) == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.f15874h == null) {
                b.a.q0.s.g0.a aVar = new b.a.q0.s.g0.a(this.f15868b.getPageContext());
                this.f15874h = aVar;
                aVar.e(new e(this));
            }
            this.f15874h.h(z);
        }
    }

    public void q(boolean z) {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (baseWebView = this.f15871e) == null) {
            return;
        }
        if (z) {
            baseWebView.setVisibility(0);
        } else {
            baseWebView.setVisibility(4);
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            b.a.e.e.m.e.a().postDelayed(this.l, i2);
        }
    }

    public void s() {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (baseActivity = this.f15868b) == null) {
            return;
        }
        if (this.k == this.f15867a) {
            int i2 = l.i(baseActivity.getBaseContext());
            BaseWebView baseWebView = this.f15871e;
            baseWebView.startAnimation(f(i2 - (baseWebView.getWidth() * 1.2631578f), 0.0f));
            b.a.e.e.m.e.a().postDelayed(this.m, 800L);
            return;
        }
        BaseWebView baseWebView2 = this.f15871e;
        baseWebView2.startAnimation(f(baseWebView2.getHeight(), 0.0f));
    }
}
