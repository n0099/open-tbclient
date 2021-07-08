package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.f.i.k.f.f;
import d.a.n0.f.i.q.c;
import d.a.n0.f.i.r.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RewardWebView f11774e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.f.i.o.b f11775f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f11776g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadParams f11777h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.f.i.k.f.a f11778i;
    public JSONObject j;
    public String k;
    public String l;
    public DownloadState m;
    public c n;
    public f o;
    public RelativeLayout p;
    public RelativeLayout.LayoutParams q;

    /* loaded from: classes3.dex */
    public class a implements d.a.n0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f11779a;

        public a(InteractiveEndFrameView interactiveEndFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interactiveEndFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11779a = interactiveEndFrameView;
        }

        @Override // d.a.n0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11779a.o.d(i2);
            }
        }

        @Override // d.a.n0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f11779a.n.c("appinstallbegin");
            }
        }

        @Override // d.a.n0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.f11779a.o.b(downloadState);
                if (this.f11779a.m == downloadState) {
                    return;
                }
                if (this.f11779a.m == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f11779a.n.c("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.f11779a.n.c("appdownloadpause");
                } else if (this.f11779a.m == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.f11779a.n.c("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.f11779a.n.c("appdownloadfinish");
                    this.f11779a.n.c("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.f11779a.n.c("appinstallfinish");
                }
                this.f11779a.m = downloadState;
            }
        }

        @Override // d.a.n0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f11779a.y(str);
            }
        }

        @Override // d.a.n0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f11779a.n.c("appinstallopen");
                InteractiveEndFrameView interactiveEndFrameView = this.f11779a;
                return interactiveEndFrameView.v(interactiveEndFrameView.k);
            }
            return (String) invokeV.objValue;
        }

        @Override // d.a.n0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f11779a.p == null) {
                return;
            }
            if (z) {
                this.f11779a.p.removeView(this.f11779a.o.getRealView());
                this.f11779a.p.addView(this.f11779a.o.getRealView(), this.f11779a.q);
                return;
            }
            this.f11779a.p.removeView(this.f11779a.o.getRealView());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f11780a;

        public b(InteractiveEndFrameView interactiveEndFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interactiveEndFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11780a = interactiveEndFrameView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                d.a.n0.f.i.q.b.h(this.f11780a.f11776g, this.f11780a.f11775f);
                this.f11780a.k = str;
                String v = this.f11780a.v(str);
                if (!TextUtils.isEmpty(v)) {
                    this.f11780a.l = v;
                }
                InteractiveEndFrameView interactiveEndFrameView = this.f11780a;
                interactiveEndFrameView.f11777h = new DownloadParams(interactiveEndFrameView.k, this.f11780a.l);
                this.f11780a.o = new d.a.n0.f.i.k.g.b();
                InteractiveEndFrameView interactiveEndFrameView2 = this.f11780a;
                f fVar = interactiveEndFrameView2.o;
                fVar.c(this.f11780a.getContext(), this.f11780a.f11777h, this.f11780a.f11778i);
                interactiveEndFrameView2.o = fVar;
                this.f11780a.o.e(this.f11780a.f11777h);
                this.f11780a.o.f();
                if (g.a(this.f11780a.getContext(), this.f11780a.f11777h.f11763b) && this.f11780a.p != null) {
                    this.f11780a.p.removeView(this.f11780a.o.getRealView());
                    this.f11780a.p.addView(this.f11780a.o.getRealView(), this.f11780a.q);
                    this.f11780a.o.b(DownloadState.INSTALLED);
                    return;
                }
                d.a.n0.f.i.m.a.b().b(this.f11780a.getContext(), this.f11780a.f11777h.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f11780a.f11778i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractiveEndFrameView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = "";
        this.m = DownloadState.NOT_START;
        this.f11775f = new d.a.n0.f.i.o.b(context);
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adElementInfo, relativeLayout) == null) {
            this.f11776g = adElementInfo;
            this.p = relativeLayout;
            String endFrameUrl = adElementInfo.getEndFrameUrl();
            RewardWebView rewardWebView = new RewardWebView(getContext());
            this.f11774e = rewardWebView;
            rewardWebView.setBackgroundColor(-1);
            this.f11774e.loadUrl(endFrameUrl);
            addView(this.f11774e, new RelativeLayout.LayoutParams(-1, -1));
            this.j = adElementInfo.getAdMonitors();
            this.n = new c(getContext(), this.j);
            w();
            setDownloadListener();
        }
    }

    public void setDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f11774e.setDownloadListener(new b(this));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RewardWebView rewardWebView = this.f11774e;
            if (rewardWebView != null) {
                rewardWebView.destroy();
            }
            if (DownloadState.DOWNLOADING == this.m) {
                this.f11778i = null;
                d.a.n0.f.i.m.a.b().b(getContext(), this.f11777h.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f11778i);
            }
        }
    }

    public final float u(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i2, typedValue, true);
            return typedValue.getFloat();
        }
        return invokeLI.floatValue;
    }

    public final String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Context context = getContext();
            getContext();
            return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            x();
            this.f11778i = new a(this);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float u = u(getContext(), d.a.n0.f.i.c.end_frame_download_btn_width);
            float u2 = u(getContext(), d.a.n0.f.i.c.end_frame_download_btn_height);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.a.n0.f.i.c.end_frame_download_btn_bottom_margin);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels * u), (int) (getContext().getResources().getDisplayMetrics().heightPixels * u2));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = dimensionPixelSize;
            layoutParams.addRule(14);
            this.q = layoutParams;
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Context context = getContext();
        getContext();
        SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
        edit.putString(this.k, str);
        edit.apply();
    }
}
