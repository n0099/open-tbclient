package com.baidu.swan.game.guide.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.a.k;
import c.a.r0.h.j.h;
import c.a.r0.h.j.i;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.GamenowRecommendPopViewAdapter;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class GamenowRecommendPopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f39699e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39700f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f39701g;

    /* renamed from: h  reason: collision with root package name */
    public View f39702h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f39703i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f39704j;
    public TextView k;
    public SimpleDraweeView l;
    public e m;
    public c.a.r0.h.i.k.f.a n;
    public GamenowDownloadButtomView o;
    public GameGuideConfigInfo.CloseInfo p;
    public int q;
    public DownloadState r;
    public boolean s;

    /* loaded from: classes11.dex */
    public class a implements c.a.r0.h.i.k.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamenowRecommendPopView a;

        public a(GamenowRecommendPopView gamenowRecommendPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamenowRecommendPopView;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.r0.h.j.n.c.n().D(i2);
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i2) == null) || this.a.r == downloadState) {
                return;
            }
            if (this.a.q == 0 || this.a.q == 1) {
                str = "2";
            } else {
                str = this.a.q == 2 ? "1" : "";
            }
            this.a.i(downloadState, str);
            c.a.r0.h.j.n.c.n().E(downloadState);
            this.a.r = downloadState;
            this.a.s = true;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.r0.h.i.k.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.r0.h.j.b.o.I() : (String) invokeV.objValue;
        }

        @Override // c.a.r0.h.i.k.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GamenowRecommendPopView f39705e;

        public b(GamenowRecommendPopView gamenowRecommendPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39705e = gamenowRecommendPopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f39705e.q != 0 && this.f39705e.q != 1) {
                    if (this.f39705e.q == 2) {
                        c.a.r0.h.j.r.b.n().b("gbADialogClick", "1", "", "");
                    }
                } else {
                    c.a.r0.h.j.r.b.n().b("gbBDialogClick", "1", "", "");
                }
                c.a.r0.h.j.n.c.n().w("");
                c.a.r0.h.j.n.c.n().x("");
                if (this.f39705e.m != null) {
                    this.f39705e.m.a();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GamenowRecommendPopView f39706e;

        public c(GamenowRecommendPopView gamenowRecommendPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39706e = gamenowRecommendPopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f39706e.q == 2) {
                    c.a.r0.h.j.r.b.n().b("gbADialogClick", "2", "", "");
                }
                c.a.r0.h.j.n.c.n().s(true);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f39707e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GamenowRecommendPopView f39708f;

        public d(GamenowRecommendPopView gamenowRecommendPopView, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39708f = gamenowRecommendPopView;
            this.f39707e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39708f.f39703i.setAdapter(new GamenowRecommendPopViewAdapter(this.f39708f.f39699e, this.f39707e));
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface e {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-251160572, "Lcom/baidu/swan/game/guide/dialog/GamenowRecommendPopView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-251160572, "Lcom/baidu/swan/game/guide/dialog/GamenowRecommendPopView;");
                return;
            }
        }
        t = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamenowRecommendPopView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = DownloadState.NOT_START;
    }

    public final void i(DownloadState downloadState, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, downloadState, str) == null) {
            String H = c.a.r0.h.j.b.o.H();
            if (TextUtils.equals(c.a.r0.h.j.b.o.I(), c.a.r0.h.j.m.c.a)) {
                H = c.a.r0.h.j.n.c.n().o();
            }
            String str4 = H;
            if (TextUtils.isEmpty(str) || !str.equals("2")) {
                str2 = "";
                str3 = str2;
            } else {
                str2 = c.a.r0.h.j.n.c.n().l();
                str3 = c.a.r0.h.j.n.c.n().m();
            }
            DownloadState downloadState2 = this.r;
            if (downloadState2 != DownloadState.DOWNLOAD_PAUSED && downloadState2 != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                c.a.r0.h.j.r.b.n().e("statusBeginDownload", "gbview", str, str2, str3, str4);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (this.s) {
                    c.a.r0.h.j.r.b.n().e("statusDownloadPause", "gbview", str, str2, str3, str4);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && this.s) {
                c.a.r0.h.j.r.b.n().e("statusDownloaded", "gbview", str, str2, str3, str4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        int i2;
        String str;
        SimpleDraweeView simpleDraweeView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i3 = this.q;
            if (i3 == 0 || i3 == 1) {
                LayoutInflater.from(this.f39699e).inflate(i.aiapps_gamenow_recommend_game_view, this);
                this.f39703i = (RecyclerView) findViewById(h.rv_guide_game);
                this.f39703i.setLayoutManager(new GridLayoutManager(this.f39699e, 3));
            } else if (i3 == 2) {
                LayoutInflater.from(this.f39699e).inflate(i.aiapps_gamenow_recommend_view, this);
                this.f39704j = (TextView) findViewById(h.gamenow_recommend_title);
                this.l = (SimpleDraweeView) findViewById(h.active_image_bg);
            }
            this.k = (TextView) findViewById(h.gamenow_recommend_sub_title);
            this.f39700f = (TextView) findViewById(h.gamenow_guide_exit_game);
            int parseColor = Color.parseColor("#333333");
            GradientDrawable gradientDrawable = null;
            try {
                if (!TextUtils.isEmpty(this.p.exitTextColor) && !this.p.exitTextColor.equals(StringUtil.NULL_STRING)) {
                    parseColor = Color.parseColor(this.p.exitTextColor);
                }
                if (!TextUtils.isEmpty(this.p.exitBackgroundColor) && !this.p.exitBackgroundColor.equals(StringUtil.NULL_STRING) && (this.f39700f.getBackground() instanceof GradientDrawable)) {
                    GradientDrawable gradientDrawable2 = (GradientDrawable) this.f39700f.getBackground();
                    try {
                        gradientDrawable2.setColor(Color.parseColor(this.p.exitBackgroundColor));
                        gradientDrawable = gradientDrawable2;
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        gradientDrawable = gradientDrawable2;
                        if (t) {
                            e.printStackTrace();
                        }
                        this.f39700f.setTextColor(parseColor);
                        this.f39701g = (LinearLayout) findViewById(h.gamenow_guide_download_container);
                        this.f39702h = findViewById(h.rl_guide_game_bg);
                        this.n = new a(this);
                        i2 = this.q;
                        str = "2";
                        if (i2 != 0) {
                            str = "1";
                        }
                        GamenowDownloadButtomView i4 = c.a.r0.h.j.n.c.n().i(this.n, "gbview", str);
                        this.o = i4;
                        this.f39701g.addView(i4);
                        this.f39700f.setOnClickListener(new b(this));
                        simpleDraweeView = this.l;
                        if (simpleDraweeView != null) {
                        }
                        c.a.r0.j.p0.g.f.d.b(this.f39700f, gradientDrawable);
                    }
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
            }
            this.f39700f.setTextColor(parseColor);
            this.f39701g = (LinearLayout) findViewById(h.gamenow_guide_download_container);
            this.f39702h = findViewById(h.rl_guide_game_bg);
            this.n = new a(this);
            i2 = this.q;
            str = "2";
            if (i2 != 0 && i2 != 1 && i2 == 2) {
                str = "1";
            }
            GamenowDownloadButtomView i42 = c.a.r0.h.j.n.c.n().i(this.n, "gbview", str);
            this.o = i42;
            this.f39701g.addView(i42);
            this.f39700f.setOnClickListener(new b(this));
            simpleDraweeView = this.l;
            if (simpleDraweeView != null) {
                simpleDraweeView.setOnClickListener(new c(this));
            }
            c.a.r0.j.p0.g.f.d.b(this.f39700f, gradientDrawable);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ArrayList arrayList = new ArrayList();
            GameGuideConfigInfo.CloseInfo closeInfo = this.p;
            ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList2 = closeInfo.gameList;
            String str = closeInfo.gameRecommendTips;
            int i2 = this.q;
            int i3 = 3;
            if (i2 != 0) {
                if (i2 != 1) {
                    i3 = 0;
                } else if (c.a.r0.a.d2.e.a0() == null || c.a.r0.a.d2.e.a0().V().d0() != 1) {
                    i3 = 6;
                }
            }
            if (arrayList2 != null && arrayList2.size() >= i3) {
                for (int i4 = 0; i4 < i3; i4++) {
                    arrayList.add(arrayList2.get(i4));
                }
            }
            post(new d(this, arrayList));
            if (this.k == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.k.setText(str);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            GameGuideConfigInfo.CloseInfo closeInfo = this.p;
            String str = closeInfo.bannerTitle;
            String str2 = closeInfo.bannerSubTitle;
            String str3 = closeInfo.bannerImgUrl;
            if (this.f39704j != null && !TextUtils.isEmpty(str)) {
                this.f39704j.setText(str);
            }
            if (this.k != null && !TextUtils.isEmpty(str2)) {
                this.k.setText(str2);
            }
            if (this.l == null || TextUtils.isEmpty(str3)) {
                return;
            }
            this.l.setController(Fresco.newDraweeControllerBuilder().setUri(str3).setAutoPlayAnimations(true).build());
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = this.q;
            if (i2 == 0 || i2 == 1) {
                k();
            } else if (i2 != 2) {
            } else {
                l();
            }
        }
    }

    public void setOnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.m = eVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamenowRecommendPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.r = DownloadState.NOT_START;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamenowRecommendPopView(Context context, GameGuideConfigInfo.CloseInfo closeInfo) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, closeInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.r = DownloadState.NOT_START;
        this.f39699e = context;
        this.p = closeInfo;
        this.q = closeInfo.type;
        j();
        m();
    }
}
