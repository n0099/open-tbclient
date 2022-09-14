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
import com.baidu.tieba.R;
import com.baidu.tieba.er3;
import com.baidu.tieba.gr3;
import com.baidu.tieba.hs3;
import com.baidu.tieba.is3;
import com.baidu.tieba.qr3;
import com.baidu.tieba.qs3;
import com.baidu.tieba.yr3;
import com.baidu.tieba.zq3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RewardWebView a;
    public yr3 b;
    public AdElementInfo c;
    public DownloadParams d;
    public zq3 e;
    public JSONObject f;
    public String g;
    public String h;
    public DownloadState i;
    public is3 j;
    public er3 k;
    public RelativeLayout l;
    public RelativeLayout.LayoutParams m;

    /* loaded from: classes3.dex */
    public class a implements zq3 {
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

        @Override // com.baidu.tieba.zq3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.k.d(i);
            }
        }

        @Override // com.baidu.tieba.zq3
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j.c("appinstallbegin");
            }
        }

        @Override // com.baidu.tieba.zq3
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

        @Override // com.baidu.tieba.zq3
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.a.y(str);
            }
        }

        @Override // com.baidu.tieba.zq3
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.a.j.c("appinstallopen");
                InteractiveEndFrameView interactiveEndFrameView = this.a;
                return interactiveEndFrameView.v(interactiveEndFrameView.g);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.zq3
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

    /* loaded from: classes3.dex */
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
                hs3.h(this.a.c, this.a.b);
                this.a.g = str;
                String v = this.a.v(str);
                if (!TextUtils.isEmpty(v)) {
                    this.a.h = v;
                }
                InteractiveEndFrameView interactiveEndFrameView = this.a;
                interactiveEndFrameView.d = new DownloadParams(interactiveEndFrameView.g, this.a.h);
                this.a.k = new gr3();
                InteractiveEndFrameView interactiveEndFrameView2 = this.a;
                er3 er3Var = interactiveEndFrameView2.k;
                er3Var.c(this.a.getContext(), this.a.d, this.a.e);
                interactiveEndFrameView2.k = er3Var;
                this.a.k.e(this.a.d);
                this.a.k.f();
                if (qs3.a(this.a.getContext(), this.a.d.b) && this.a.l != null) {
                    this.a.l.removeView(this.a.k.getRealView());
                    this.a.l.addView(this.a.k.getRealView(), this.a.m);
                    this.a.k.b(DownloadState.INSTALLED);
                    return;
                }
                qr3.b().d(this.a.getContext(), this.a.d.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.a.e);
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
        this.h = "";
        this.i = DownloadState.NOT_START;
        this.b = new yr3(context);
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, adElementInfo, relativeLayout) == null) {
            this.c = adElementInfo;
            this.l = relativeLayout;
            String endFrameUrl = adElementInfo.getEndFrameUrl();
            RewardWebView rewardWebView = new RewardWebView(getContext());
            this.a = rewardWebView;
            rewardWebView.setBackgroundColor(-1);
            this.a.loadUrl(endFrameUrl);
            addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
            this.f = adElementInfo.getAdMonitors();
            this.j = new is3(getContext(), this.f);
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
                this.e = null;
                qr3.b().d(getContext(), this.d.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.e);
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
            this.e = new a(this);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float u = u(getContext(), R.dimen.obfuscated_res_0x7f07031d);
            float u2 = u(getContext(), R.dimen.obfuscated_res_0x7f07031c);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07031b);
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
        edit.putString(this.g, str);
        edit.apply();
    }
}
