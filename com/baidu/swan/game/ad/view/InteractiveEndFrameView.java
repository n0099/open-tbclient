package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import c.a.o0.f.i.k.f.f;
import c.a.o0.f.i.q.c;
import c.a.o0.f.i.r.g;
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
/* loaded from: classes6.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SWAN_GAME_STORAGE = "swan_game_video_ad_storage";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RewardWebView f46792e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.f.i.o.b f46793f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f46794g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadParams f46795h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.o0.f.i.k.f.a f46796i;

    /* renamed from: j  reason: collision with root package name */
    public JSONObject f46797j;
    public String k;
    public String l;
    public DownloadState m;
    public c n;
    public f o;
    public RelativeLayout p;
    public RelativeLayout.LayoutParams q;

    /* loaded from: classes6.dex */
    public class a implements c.a.o0.f.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f46798a;

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
            this.f46798a = interactiveEndFrameView;
        }

        @Override // c.a.o0.f.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f46798a.o.d(i2);
            }
        }

        @Override // c.a.o0.f.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f46798a.n.c("appinstallbegin");
            }
        }

        @Override // c.a.o0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) {
                this.f46798a.o.b(downloadState);
                if (this.f46798a.m == downloadState) {
                    return;
                }
                if (this.f46798a.m == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.f46798a.n.c("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.f46798a.n.c("appdownloadpause");
                } else if (this.f46798a.m == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.f46798a.n.c("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.f46798a.n.c("appdownloadfinish");
                    this.f46798a.n.c("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.f46798a.n.c("appinstallfinish");
                }
                this.f46798a.m = downloadState;
            }
        }

        @Override // c.a.o0.f.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f46798a.v(str);
            }
        }

        @Override // c.a.o0.f.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f46798a.n.c("appinstallopen");
                InteractiveEndFrameView interactiveEndFrameView = this.f46798a;
                return interactiveEndFrameView.t(interactiveEndFrameView.k);
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.o0.f.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.f46798a.p == null) {
                return;
            }
            if (z) {
                this.f46798a.p.removeView(this.f46798a.o.getRealView());
                this.f46798a.p.addView(this.f46798a.o.getRealView(), this.f46798a.q);
                return;
            }
            this.f46798a.p.removeView(this.f46798a.o.getRealView());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InteractiveEndFrameView f46799a;

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
            this.f46799a = interactiveEndFrameView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                c.a.o0.f.i.q.b.h(this.f46799a.f46794g, this.f46799a.f46793f);
                this.f46799a.k = str;
                String t = this.f46799a.t(str);
                if (!TextUtils.isEmpty(t)) {
                    this.f46799a.l = t;
                }
                InteractiveEndFrameView interactiveEndFrameView = this.f46799a;
                interactiveEndFrameView.f46795h = new DownloadParams(interactiveEndFrameView.k, this.f46799a.l);
                this.f46799a.o = new c.a.o0.f.i.k.g.b();
                InteractiveEndFrameView interactiveEndFrameView2 = this.f46799a;
                f fVar = interactiveEndFrameView2.o;
                fVar.c(this.f46799a.getContext(), this.f46799a.f46795h, this.f46799a.f46796i);
                interactiveEndFrameView2.o = fVar;
                this.f46799a.o.e(this.f46799a.f46795h);
                this.f46799a.o.f();
                if (g.a(this.f46799a.getContext(), this.f46799a.f46795h.f46780b) && this.f46799a.p != null) {
                    this.f46799a.p.removeView(this.f46799a.o.getRealView());
                    this.f46799a.p.addView(this.f46799a.o.getRealView(), this.f46799a.q);
                    this.f46799a.o.b(DownloadState.INSTALLED);
                    return;
                }
                c.a.o0.f.i.m.a.b().b(this.f46799a.getContext(), this.f46799a.f46795h.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.f46799a.f46796i);
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
        this.f46793f = new c.a.o0.f.i.o.b(context);
    }

    public void addWebView(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adElementInfo, relativeLayout) == null) {
            this.f46794g = adElementInfo;
            this.p = relativeLayout;
            String endFrameUrl = adElementInfo.getEndFrameUrl();
            RewardWebView rewardWebView = new RewardWebView(getContext());
            this.f46792e = rewardWebView;
            rewardWebView.setBackgroundColor(-1);
            this.f46792e.loadUrl(endFrameUrl);
            addView(this.f46792e, new RelativeLayout.LayoutParams(-1, -1));
            this.f46797j = adElementInfo.getAdMonitors();
            this.n = new c(getContext(), this.f46797j);
            initDownload();
            setDownloadListener();
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RewardWebView rewardWebView = this.f46792e;
            if (rewardWebView != null) {
                rewardWebView.destroy();
            }
            if (DownloadState.DOWNLOADING == this.m) {
                this.f46796i = null;
                c.a.o0.f.i.m.a.b().b(getContext(), this.f46795h.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f46796i);
            }
        }
    }

    public void initDownload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            u();
            this.f46796i = new a(this);
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
            this.f46792e.setDownloadListener(new b(this));
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
            float s = s(getContext(), c.a.o0.f.i.c.end_frame_download_btn_width);
            float s2 = s(getContext(), c.a.o0.f.i.c.end_frame_download_btn_height);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.a.o0.f.i.c.end_frame_download_btn_bottom_margin);
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
