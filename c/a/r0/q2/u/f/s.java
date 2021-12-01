package c.a.r0.q2.u.f;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import c.a.q0.s.q.d1;
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
/* loaded from: classes6.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f22125b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f22126c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f22127d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f22128e;

    /* renamed from: f  reason: collision with root package name */
    public View f22129f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f22130g;

    /* loaded from: classes6.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
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

    /* loaded from: classes6.dex */
    public class b implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
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

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f22131e;

        public c(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22131e = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f22131e.f22130g != null) {
                        this.f22131e.f22130g.destroy();
                        this.f22131e.f22130g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public s(View view) {
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
        this.f22125b = (ViewStub) view.findViewById(c.a.r0.q2.i.gift_list_viewStub);
        this.f22127d = (ViewStub) view.findViewById(c.a.r0.q2.i.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f22130g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f22130g.getSettings().setBuiltInZoomControls(true);
        this.f22130g.setVisibility(8);
        c.a.d.f.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(d1 d1Var, String str, String str2, long j2, long j3, long j4) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d1Var, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (d1Var != null && !ListUtils.isEmpty(d1Var.a()) && (viewStub = this.f22125b) != null) {
                if (this.f22126c == null) {
                    this.f22126c = (PbGiftListView) viewStub.inflate();
                }
                this.f22126c.setVisibility(0);
                this.f22126c.fillGiftData(d1Var, str, str2, j2, j3, j4);
                this.f22126c.onChangeSkinType();
                return;
            }
            PbGiftListView pbGiftListView = this.f22126c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(c.a.q0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0Var) == null) || r0Var == null || c.a.d.f.p.k.isEmpty(r0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f22130g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && r0Var.c() == c.a.q0.s.q.r0.f13037g && this.f22127d != null) {
            if (r0Var.f()) {
                LinearLayout linearLayout = this.f22128e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f22128e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f22127d.inflate();
                this.f22128e = linearLayout2;
                this.f22129f = linearLayout2.findViewById(c.a.r0.q2.i.link_thread_divider);
                this.f22130g = (BaseWebView) this.f22128e.findViewById(c.a.r0.q2.i.link_thread_webview);
            }
            this.f22129f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f22129f, c.a.r0.q2.f.CAM_X0204);
            this.f22130g.setVisibility(0);
            this.f22130g.setFocusable(false);
            this.f22130g.setBackgroundColor(0);
            this.f22130g.getSettings().setCacheMode(-1);
            this.f22130g.setVerticalScrollBarEnabled(false);
            this.f22130g.setHorizontalScrollBarEnabled(false);
            this.f22130g.getSettings().setAllowFileAccess(true);
            this.f22130g.getSettings().setAppCacheEnabled(true);
            this.f22130g.getSettings().setDomStorageEnabled(true);
            this.f22130g.getSettings().setDatabaseEnabled(true);
            this.f22130g.setOnLoadUrlListener(new a(this));
            this.f22130g.setOnPageFinishedListener(new b(this));
            this.f22130g.loadUrl(r0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f22130g) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f22130g) == null) {
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
