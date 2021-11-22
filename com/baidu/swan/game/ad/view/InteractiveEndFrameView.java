package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import b.a.p0.h.i.k.f.f;
import b.a.p0.h.i.p.c;
import b.a.p0.h.i.s.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SWAN_GAME_STORAGE = "swan_game_video_ad_storage";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RewardWebView f45368e;

    /* renamed from: f  reason: collision with root package name */
    public c f45369f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f45370g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadParams f45371h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.h.i.k.f.a f45372i;
    public JSONObject j;
    public String k;
    public String l;
    public DownloadState m;
    public b.a.p0.h.i.r.c n;
    public f o;
    public RelativeLayout p;
    public RelativeLayout.LayoutParams q;

    /* loaded from: classes8.dex */
    public class a implements b.a.p0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f45373a;

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
            this.f45373a = interactiveEndFrameView;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f45373a.o.d(i2);
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45373a.n.c("appinstallbegin");
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.f45373a.o.b(downloadState);
                if (this.f45373a.m == downloadState) {
                    return;
                }
                if (this.f45373a.m == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f45373a.n.c("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.f45373a.n.c("appdownloadpause");
                } else if (this.f45373a.m == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.f45373a.n.c("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.f45373a.n.c("appdownloadfinish");
                    this.f45373a.n.c("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.f45373a.n.c("appinstallfinish");
                }
                this.f45373a.m = downloadState;
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f45373a.v(str);
            }
        }

        @Override // b.a.p0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f45373a.n.c("appinstallopen");
                InteractiveEndFrameView interactiveEndFrameView = this.f45373a;
                return interactiveEndFrameView.t(interactiveEndFrameView.k);
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f45373a.p == null) {
                return;
            }
            if (z) {
                this.f45373a.p.removeView(this.f45373a.o.getRealView());
                this.f45373a.p.addView(this.f45373a.o.getRealView(), this.f45373a.q);
                return;
            }
            this.f45373a.p.removeView(this.f45373a.o.getRealView());
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f45374a;

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
            this.f45374a = interactiveEndFrameView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                b.a.p0.h.i.r.b.h(this.f45374a.f45370g, this.f45374a.f45369f);
                this.f45374a.k = str;
                String t = this.f45374a.t(str);
                if (!TextUtils.isEmpty(t)) {
                    this.f45374a.l = t;
                }
                InteractiveEndFrameView interactiveEndFrameView = this.f45374a;
                interactiveEndFrameView.f45371h = new DownloadParams(interactiveEndFrameView.k, this.f45374a.l);
                this.f45374a.o = new b.a.p0.h.i.k.g.b();
                InteractiveEndFrameView interactiveEndFrameView2 = this.f45374a;
                f fVar = interactiveEndFrameView2.o;
                fVar.c(this.f45374a.getContext(), this.f45374a.f45371h, this.f45374a.f45372i);
                interactiveEndFrameView2.o = fVar;
                this.f45374a.o.e(this.f45374a.f45371h);
                this.f45374a.o.f();
                if (g.a(this.f45374a.getContext(), this.f45374a.f45371h.f45357b) && this.f45374a.p != null) {
                    this.f45374a.p.removeView(this.f45374a.o.getRealView());
                    this.f45374a.p.addView(this.f45374a.o.getRealView(), this.f45374a.q);
                    this.f45374a.o.b(DownloadState.INSTALLED);
                    return;
                }
                b.a.p0.h.i.n.a.b().d(this.f45374a.getContext(), this.f45374a.f45371h.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f45374a.f45372i);
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
        this.f45369f = new c(context);
    }

    public void addWebView(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adElementInfo, relativeLayout) == null) {
            this.f45370g = adElementInfo;
            this.p = relativeLayout;
            String endFrameUrl = adElementInfo.getEndFrameUrl();
            RewardWebView rewardWebView = new RewardWebView(getContext());
            this.f45368e = rewardWebView;
            rewardWebView.setBackgroundColor(-1);
            this.f45368e.loadUrl(endFrameUrl);
            addView(this.f45368e, new RelativeLayout.LayoutParams(-1, -1));
            this.j = adElementInfo.getAdMonitors();
            this.n = new b.a.p0.h.i.r.c(getContext(), this.j);
            initDownload();
            setDownloadListener();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RewardWebView rewardWebView = this.f45368e;
            if (rewardWebView != null) {
                rewardWebView.destroy();
            }
            if (DownloadState.DOWNLOADING == this.m) {
                this.f45372i = null;
                b.a.p0.h.i.n.a.b().d(getContext(), this.f45371h.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f45372i);
            }
        }
    }

    public void initDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u();
            this.f45372i = new a(this);
        }
    }

    public final float s(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i2)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i2, typedValue, true);
            return typedValue.getFloat();
        }
        return invokeLI.floatValue;
    }

    public void setDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f45368e.setDownloadListener(new b(this));
        }
    }

    public final String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Context context = getContext();
            getContext();
            return context.getSharedPreferences(SWAN_GAME_STORAGE, 0).getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float s = s(getContext(), b.a.p0.h.i.c.end_frame_download_btn_width);
            float s2 = s(getContext(), b.a.p0.h.i.c.end_frame_download_btn_height);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(b.a.p0.h.i.c.end_frame_download_btn_bottom_margin);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels * s), (int) (getContext().getResources().getDisplayMetrics().heightPixels * s2));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = dimensionPixelSize;
            layoutParams.addRule(14);
            this.q = layoutParams;
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Context context = getContext();
        getContext();
        SharedPreferences.Editor edit = context.getSharedPreferences(SWAN_GAME_STORAGE, 0).edit();
        edit.putString(this.k, str);
        edit.apply();
    }
}
