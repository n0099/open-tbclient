package c.a.q0.i2.k.e;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import c.a.p0.s.q.d1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19587a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f19588b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f19589c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f19590d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f19591e;

    /* renamed from: f  reason: collision with root package name */
    public View f19592f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f19593g;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
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

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f19594e;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19594e = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f19594e.f19593g != null) {
                        this.f19594e.f19593g.destroy();
                        this.f19594e.f19593g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public r(View view) {
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
        this.f19587a = view;
        this.f19588b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f19590d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f19593g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f19593g.getSettings().setBuiltInZoomControls(true);
        this.f19593g.setVisibility(8);
        c.a.e.e.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(d1 d1Var, String str, String str2, long j2, long j3, long j4) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d1Var, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (d1Var != null && !ListUtils.isEmpty(d1Var.a()) && (viewStub = this.f19588b) != null) {
                if (this.f19589c == null) {
                    this.f19589c = (PbGiftListView) viewStub.inflate();
                }
                this.f19589c.setVisibility(0);
                this.f19589c.fillGiftData(d1Var, str, str2, j2, j3, j4);
                this.f19589c.onChangeSkinType();
                return;
            }
            PbGiftListView pbGiftListView = this.f19589c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(c.a.p0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0Var) == null) || r0Var == null || c.a.e.e.p.k.isEmpty(r0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f19593g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && r0Var.c() == c.a.p0.s.q.r0.f14328g && this.f19590d != null) {
            if (r0Var.f()) {
                LinearLayout linearLayout = this.f19591e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f19591e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f19590d.inflate();
                this.f19591e = linearLayout2;
                this.f19592f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f19593g = (BaseWebView) this.f19591e.findViewById(R.id.link_thread_webview);
            }
            this.f19592f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f19592f, R.color.CAM_X0204);
            this.f19593g.setVisibility(0);
            this.f19593g.setFocusable(false);
            this.f19593g.setBackgroundColor(0);
            this.f19593g.getSettings().setCacheMode(-1);
            this.f19593g.setVerticalScrollBarEnabled(false);
            this.f19593g.setHorizontalScrollBarEnabled(false);
            this.f19593g.getSettings().setAllowFileAccess(true);
            this.f19593g.getSettings().setAppCacheEnabled(true);
            this.f19593g.getSettings().setDomStorageEnabled(true);
            this.f19593g.getSettings().setDatabaseEnabled(true);
            this.f19593g.setOnLoadUrlListener(new a(this));
            this.f19593g.setOnPageFinishedListener(new b(this));
            this.f19593g.loadUrl(r0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f19593g) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f19593g) == null) {
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
