package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import c.a.n0.h.a.c.f.f;
import c.a.n0.h.a.h.c;
import c.a.n0.h.a.k.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RewardWebView a;

    /* renamed from: b  reason: collision with root package name */
    public c f29473b;

    /* renamed from: c  reason: collision with root package name */
    public AdElementInfo f29474c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams f29475d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.a.c.f.a f29476e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f29477f;

    /* renamed from: g  reason: collision with root package name */
    public String f29478g;

    /* renamed from: h  reason: collision with root package name */
    public String f29479h;
    public DownloadState i;
    public c.a.n0.h.a.j.c j;
    public f k;
    public RelativeLayout l;
    public RelativeLayout.LayoutParams m;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.h.a.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InteractiveEndFrameView a;

        public a(InteractiveEndFrameView interactiveEndFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interactiveEndFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interactiveEndFrameView;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.k.d(i);
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j.c("appinstallbegin");
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void c(DownloadState downloadState, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) {
                this.a.k.b(downloadState);
                if (this.a.i == downloadState) {
                    return;
                }
                if (this.a.i == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                    this.a.j.c("appdownloadbegin");
                } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                    this.a.j.c("appdownloadpause");
                } else if (this.a.i == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                    this.a.j.c("appdownloadcontinue");
                } else if (downloadState == DownloadState.DOWNLOADED) {
                    this.a.j.c("appdownloadfinish");
                    this.a.j.c("appinstallbegin");
                } else if (downloadState == DownloadState.INSTALLED) {
                    this.a.j.c("appinstallfinish");
                }
                this.a.i = downloadState;
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.y(str);
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.j.c("appinstallopen");
                InteractiveEndFrameView interactiveEndFrameView = this.a;
                return interactiveEndFrameView.v(interactiveEndFrameView.f29478g);
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.a.l == null) {
                return;
            }
            if (z) {
                this.a.l.removeView(this.a.k.getRealView());
                this.a.l.addView(this.a.k.getRealView(), this.a.m);
                return;
            }
            this.a.l.removeView(this.a.k.getRealView());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InteractiveEndFrameView a;

        public b(InteractiveEndFrameView interactiveEndFrameView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interactiveEndFrameView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interactiveEndFrameView;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                c.a.n0.h.a.j.b.h(this.a.f29474c, this.a.f29473b);
                this.a.f29478g = str;
                String v = this.a.v(str);
                if (!TextUtils.isEmpty(v)) {
                    this.a.f29479h = v;
                }
                InteractiveEndFrameView interactiveEndFrameView = this.a;
                interactiveEndFrameView.f29475d = new DownloadParams(interactiveEndFrameView.f29478g, this.a.f29479h);
                this.a.k = new c.a.n0.h.a.c.g.b();
                InteractiveEndFrameView interactiveEndFrameView2 = this.a;
                f fVar = interactiveEndFrameView2.k;
                fVar.c(this.a.getContext(), this.a.f29475d, this.a.f29476e);
                interactiveEndFrameView2.k = fVar;
                this.a.k.e(this.a.f29475d);
                this.a.k.f();
                if (g.a(this.a.getContext(), this.a.f29475d.f29461b) && this.a.l != null) {
                    this.a.l.removeView(this.a.k.getRealView());
                    this.a.l.addView(this.a.k.getRealView(), this.a.m);
                    this.a.k.b(DownloadState.INSTALLED);
                    return;
                }
                c.a.n0.h.a.f.a.b().d(this.a.getContext(), this.a.f29475d.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.f29476e);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29479h = "";
        this.i = DownloadState.NOT_START;
        this.f29473b = new c(context);
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adElementInfo, relativeLayout) == null) {
            this.f29474c = adElementInfo;
            this.l = relativeLayout;
            String endFrameUrl = adElementInfo.getEndFrameUrl();
            RewardWebView rewardWebView = new RewardWebView(getContext());
            this.a = rewardWebView;
            rewardWebView.setBackgroundColor(-1);
            this.a.loadUrl(endFrameUrl);
            addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
            this.f29477f = adElementInfo.getAdMonitors();
            this.j = new c.a.n0.h.a.j.c(getContext(), this.f29477f);
            w();
            setDownloadListener();
        }
    }

    public void setDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setDownloadListener(new b(this));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RewardWebView rewardWebView = this.a;
            if (rewardWebView != null) {
                rewardWebView.destroy();
            }
            if (DownloadState.DOWNLOADING == this.i) {
                this.f29476e = null;
                c.a.n0.h.a.f.a.b().d(getContext(), this.f29475d.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f29476e);
            }
        }
    }

    public final float u(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            TypedValue typedValue = new TypedValue();
            context.getResources().getValue(i, typedValue, true);
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
            this.f29476e = new a(this);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float u = u(getContext(), R.dimen.obfuscated_res_0x7f070316);
            float u2 = u(getContext(), R.dimen.obfuscated_res_0x7f070315);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070314);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels * u), (int) (getContext().getResources().getDisplayMetrics().heightPixels * u2));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = dimensionPixelSize;
            layoutParams.addRule(14);
            this.m = layoutParams;
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
        edit.putString(this.f29478g, str);
        edit.apply();
    }
}
