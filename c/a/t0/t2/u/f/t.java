package c.a.t0.t2.u.f;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import c.a.s0.s.q.d1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f23290b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f23291c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f23292d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f23293e;

    /* renamed from: f  reason: collision with root package name */
    public View f23294f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f23295g;

    /* loaded from: classes8.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f23296e;

        public c(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23296e = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f23296e.f23295g != null) {
                        this.f23296e.f23295g.destroy();
                        this.f23296e.f23295g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f23290b = (ViewStub) view.findViewById(c.a.t0.t2.i.gift_list_viewStub);
        this.f23292d = (ViewStub) view.findViewById(c.a.t0.t2.i.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f23295g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f23295g.getSettings().setBuiltInZoomControls(true);
        this.f23295g.setVisibility(8);
        c.a.d.f.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(d1 d1Var, String str, String str2, long j2, long j3, long j4) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d1Var, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (d1Var != null && !ListUtils.isEmpty(d1Var.a()) && (viewStub = this.f23290b) != null) {
                if (this.f23291c == null) {
                    this.f23291c = (PbGiftListView) viewStub.inflate();
                }
                this.f23291c.setVisibility(0);
                this.f23291c.fillGiftData(d1Var, str, str2, j2, j3, j4);
                this.f23291c.onChangeSkinType();
                return;
            }
            PbGiftListView pbGiftListView = this.f23291c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(c.a.s0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0Var) == null) || r0Var == null || c.a.d.f.p.m.isEmpty(r0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f23295g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && r0Var.c() == c.a.s0.s.q.r0.f13666g && this.f23292d != null) {
            if (r0Var.f()) {
                LinearLayout linearLayout = this.f23293e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f23293e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f23292d.inflate();
                this.f23293e = linearLayout2;
                this.f23294f = linearLayout2.findViewById(c.a.t0.t2.i.link_thread_divider);
                this.f23295g = (BaseWebView) this.f23293e.findViewById(c.a.t0.t2.i.link_thread_webview);
            }
            this.f23294f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f23294f, c.a.t0.t2.f.CAM_X0204);
            this.f23295g.setVisibility(0);
            this.f23295g.setFocusable(false);
            this.f23295g.setBackgroundColor(0);
            this.f23295g.getSettings().setCacheMode(-1);
            this.f23295g.setVerticalScrollBarEnabled(false);
            this.f23295g.setHorizontalScrollBarEnabled(false);
            this.f23295g.getSettings().setAllowFileAccess(true);
            this.f23295g.getSettings().setAppCacheEnabled(true);
            this.f23295g.getSettings().setDomStorageEnabled(true);
            this.f23295g.getSettings().setDatabaseEnabled(true);
            this.f23295g.setOnLoadUrlListener(new a(this));
            this.f23295g.setOnPageFinishedListener(new b(this));
            this.f23295g.loadUrl(r0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f23295g) == null) {
            return;
        }
        try {
            baseWebView.onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f23295g) == null) {
            return;
        }
        try {
            baseWebView.onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }
}
