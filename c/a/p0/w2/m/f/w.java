package c.a.p0.w2.m.f;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
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
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f20327b;

    /* renamed from: c  reason: collision with root package name */
    public PbGiftListView f20328c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f20329d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f20330e;

    /* renamed from: f  reason: collision with root package name */
    public View f20331f;

    /* renamed from: g  reason: collision with root package name */
    public BaseWebView f20332g;

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public b(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public final /* synthetic */ w a;

        public c(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.f20332g != null) {
                        this.a.f20332g.destroy();
                        this.a.f20332g = null;
                    }
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
        }
    }

    public w(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f20327b = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f090ca7);
        this.f20329d = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f091274);
    }

    public void a() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (baseWebView = this.f20332g) == null) {
            return;
        }
        baseWebView.removeAllViews();
        this.f20332g.getSettings().setBuiltInZoomControls(true);
        this.f20332g.setVisibility(8);
        c.a.d.f.m.e.a().postDelayed(new c(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
    }

    public void b(c.a.o0.r.r.b1 b1Var, String str, String str2, long j, long j2, long j3) {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{b1Var, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (b1Var != null && !ListUtils.isEmpty(b1Var.a()) && (viewStub = this.f20327b) != null) {
                if (this.f20328c == null) {
                    this.f20328c = (PbGiftListView) viewStub.inflate();
                }
                this.f20328c.setVisibility(0);
                this.f20328c.g(b1Var, str, str2, j, j2, j3);
                this.f20328c.i();
                return;
            }
            PbGiftListView pbGiftListView = this.f20328c;
            if (pbGiftListView != null) {
                pbGiftListView.setVisibility(8);
            }
        }
    }

    public void c(c.a.o0.r.r.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q0Var) == null) || q0Var == null || c.a.d.f.p.m.isEmpty(q0Var.e())) {
            return;
        }
        BaseWebView baseWebView = this.f20332g;
        if ((baseWebView == null || !baseWebView.getIsLoaded()) && q0Var.c() == c.a.o0.r.r.q0.f10930g && this.f20329d != null) {
            if (q0Var.f()) {
                LinearLayout linearLayout = this.f20330e;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f20330e == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.f20329d.inflate();
                this.f20330e = linearLayout2;
                this.f20331f = linearLayout2.findViewById(R.id.obfuscated_res_0x7f09126f);
                this.f20332g = (BaseWebView) this.f20330e.findViewById(R.id.obfuscated_res_0x7f091275);
            }
            this.f20331f.setVisibility(0);
            SkinManager.setBackgroundColor(this.f20331f, R.color.CAM_X0204);
            this.f20332g.setVisibility(0);
            this.f20332g.setFocusable(false);
            this.f20332g.setBackgroundColor(0);
            this.f20332g.getSettings().setCacheMode(-1);
            this.f20332g.setVerticalScrollBarEnabled(false);
            this.f20332g.setHorizontalScrollBarEnabled(false);
            this.f20332g.getSettings().setAllowFileAccess(true);
            this.f20332g.getSettings().setAppCacheEnabled(true);
            this.f20332g.getSettings().setDomStorageEnabled(true);
            this.f20332g.getSettings().setDatabaseEnabled(true);
            this.f20332g.setOnLoadUrlListener(new a(this));
            this.f20332g.setOnPageFinishedListener(new b(this));
            this.f20332g.loadUrl(q0Var.e());
        }
    }

    public void d() {
        BaseWebView baseWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (baseWebView = this.f20332g) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (baseWebView = this.f20332g) == null) {
            return;
        }
        try {
            baseWebView.onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }
}
