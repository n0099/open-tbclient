package c.a.r0.j2.k.e;

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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20210a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f20211b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f20212c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f20213d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f20214e;

    /* renamed from: f  reason: collision with root package name */
    public View f20215f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f20216g;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f20217e;

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
            this.f20217e = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f20217e.f20216g != null) {
                        this.f20217e.f20216g.destroy();
                        this.f20217e.f20216g = null;
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
        this.f20210a = view;
        this.f20211b = (ViewStub) view.findViewById(R.id.gift_list_viewStub);
        this.f20213d = (ViewStub) view.findViewById(R.id.link_thread_viewStub);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f20216g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f20216g.getSettings().setBuiltInZoomControls(true);
        this.f20216g.setVisibility(8);
        c.a.e.e.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(d1 d1Var, String str, String str2, long j2, long j3, long j4) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{d1Var, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if (d1Var != null && !ListUtils.isEmpty(d1Var.a()) && (viewStub = this.f20211b) != null) {
                if (this.f20212c == null) {
                    this.f20212c = (PbGiftListView) viewStub.inflate();
                }
                this.f20212c.setVisibility(0);
                this.f20212c.fillGiftData(d1Var, str, str2, j2, j3, j4);
                this.f20212c.onChangeSkinType();
                return;
            }
            PbGiftListView pbGiftListView = this.f20212c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(c.a.q0.s.q.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r0Var) == null) || r0Var == null || c.a.e.e.p.k.isEmpty(r0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f20216g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && r0Var.c() == c.a.q0.s.q.r0.f14291g && this.f20213d != null) {
            if (r0Var.f()) {
                LinearLayout linearLayout = this.f20214e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f20214e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f20213d.inflate();
                this.f20214e = linearLayout2;
                this.f20215f = linearLayout2.findViewById(R.id.link_thread_divider);
                this.f20216g = (BaseWebView) this.f20214e.findViewById(R.id.link_thread_webview);
            }
            this.f20215f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f20215f, R.color.CAM_X0204);
            this.f20216g.setVisibility(0);
            this.f20216g.setFocusable(false);
            this.f20216g.setBackgroundColor(0);
            this.f20216g.getSettings().setCacheMode(-1);
            this.f20216g.setVerticalScrollBarEnabled(false);
            this.f20216g.setHorizontalScrollBarEnabled(false);
            this.f20216g.getSettings().setAllowFileAccess(true);
            this.f20216g.getSettings().setAppCacheEnabled(true);
            this.f20216g.getSettings().setDomStorageEnabled(true);
            this.f20216g.getSettings().setDatabaseEnabled(true);
            this.f20216g.setOnLoadUrlListener(new a(this));
            this.f20216g.setOnPageFinishedListener(new b(this));
            this.f20216g.loadUrl(r0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f20216g) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f20216g) == null) {
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
