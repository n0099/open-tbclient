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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.GamenowRecommendPopViewAdapter;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class GamenowRecommendPopView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29498b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f29499c;

    /* renamed from: d  reason: collision with root package name */
    public View f29500d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f29501e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29502f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29503g;

    /* renamed from: h  reason: collision with root package name */
    public SimpleDraweeView f29504h;
    public e i;
    public c.a.n0.h.a.c.f.a j;
    public GamenowDownloadButtomView k;
    public GameGuideConfigInfo.CloseInfo l;
    public int m;
    public DownloadState n;
    public boolean o;

    /* loaded from: classes4.dex */
    public class a implements c.a.n0.h.a.c.f.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamenowRecommendPopView;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                c.a.n0.h.b.f.c.n().D(i);
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public void c(DownloadState downloadState, int i) {
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, downloadState, i) == null) || this.a.n == downloadState) {
                return;
            }
            if (this.a.m == 0 || this.a.m == 1) {
                str = "2";
            } else {
                str = this.a.m == 2 ? "1" : "";
            }
            this.a.i(downloadState, str);
            c.a.n0.h.b.f.c.n().E(downloadState);
            this.a.n = downloadState;
            this.a.o = true;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            }
        }

        @Override // c.a.n0.h.a.c.f.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.n0.h.b.b.o.I() : (String) invokeV.objValue;
        }

        @Override // c.a.n0.h.a.c.f.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamenowRecommendPopView a;

        public b(GamenowRecommendPopView gamenowRecommendPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamenowRecommendPopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.m != 0 && this.a.m != 1) {
                    if (this.a.m == 2) {
                        c.a.n0.h.b.j.b.n().b("gbADialogClick", "1", "", "");
                    }
                } else {
                    c.a.n0.h.b.j.b.n().b("gbBDialogClick", "1", "", "");
                }
                c.a.n0.h.b.f.c.n().w("");
                c.a.n0.h.b.f.c.n().x("");
                if (this.a.i != null) {
                    this.a.i.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GamenowRecommendPopView a;

        public c(GamenowRecommendPopView gamenowRecommendPopView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gamenowRecommendPopView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.m == 2) {
                    c.a.n0.h.b.j.b.n().b("gbADialogClick", "2", "", "");
                }
                c.a.n0.h.b.f.c.n().s(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GamenowRecommendPopView f29505b;

        public d(GamenowRecommendPopView gamenowRecommendPopView, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamenowRecommendPopView, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29505b = gamenowRecommendPopView;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29505b.f29501e.setAdapter(new GamenowRecommendPopViewAdapter(this.f29505b.a, this.a));
            }
        }
    }

    /* loaded from: classes4.dex */
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
        p = c.a.n0.a.a.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = DownloadState.NOT_START;
    }

    public final void i(DownloadState downloadState, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, downloadState, str) == null) {
            String H = c.a.n0.h.b.b.o.H();
            if (TextUtils.equals(c.a.n0.h.b.b.o.I(), c.a.n0.h.b.e.c.a)) {
                H = c.a.n0.h.b.f.c.n().o();
            }
            String str4 = H;
            if (TextUtils.isEmpty(str) || !str.equals("2")) {
                str2 = "";
                str3 = str2;
            } else {
                str2 = c.a.n0.h.b.f.c.n().l();
                str3 = c.a.n0.h.b.f.c.n().m();
            }
            DownloadState downloadState2 = this.n;
            if (downloadState2 != DownloadState.DOWNLOAD_PAUSED && downloadState2 != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
                c.a.n0.h.b.j.b.n().e("statusBeginDownload", "gbview", str, str2, str3, str4);
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                if (this.o) {
                    c.a.n0.h.b.j.b.n().e("statusDownloadPause", "gbview", str, str2, str3, str4);
                }
            } else if (downloadState == DownloadState.DOWNLOADED && this.o) {
                c.a.n0.h.b.j.b.n().e("statusDownloaded", "gbview", str, str2, str3, str4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        int i;
        String str;
        SimpleDraweeView simpleDraweeView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.m;
            if (i2 == 0 || i2 == 1) {
                LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00af, this);
                this.f29501e = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091b07);
                this.f29501e.setLayoutManager(new GridLayoutManager(this.a, 3));
            } else if (i2 == 2) {
                LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00b1, this);
                this.f29502f = (TextView) findViewById(R.id.obfuscated_res_0x7f090c82);
                this.f29504h = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f09006d);
            }
            this.f29503g = (TextView) findViewById(R.id.obfuscated_res_0x7f090c81);
            this.f29498b = (TextView) findViewById(R.id.obfuscated_res_0x7f090c7f);
            int parseColor = Color.parseColor("#333333");
            GradientDrawable gradientDrawable = null;
            try {
                if (!TextUtils.isEmpty(this.l.exitTextColor) && !this.l.exitTextColor.equals(StringUtil.NULL_STRING)) {
                    parseColor = Color.parseColor(this.l.exitTextColor);
                }
                if (!TextUtils.isEmpty(this.l.exitBackgroundColor) && !this.l.exitBackgroundColor.equals(StringUtil.NULL_STRING) && (this.f29498b.getBackground() instanceof GradientDrawable)) {
                    GradientDrawable gradientDrawable2 = (GradientDrawable) this.f29498b.getBackground();
                    try {
                        gradientDrawable2.setColor(Color.parseColor(this.l.exitBackgroundColor));
                        gradientDrawable = gradientDrawable2;
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        gradientDrawable = gradientDrawable2;
                        if (p) {
                            e.printStackTrace();
                        }
                        this.f29498b.setTextColor(parseColor);
                        this.f29499c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c7e);
                        this.f29500d = findViewById(R.id.obfuscated_res_0x7f091aca);
                        this.j = new a(this);
                        i = this.m;
                        str = "2";
                        if (i != 0) {
                            str = "1";
                        }
                        GamenowDownloadButtomView i3 = c.a.n0.h.b.f.c.n().i(this.j, "gbview", str);
                        this.k = i3;
                        this.f29499c.addView(i3);
                        this.f29498b.setOnClickListener(new b(this));
                        simpleDraweeView = this.f29504h;
                        if (simpleDraweeView != null) {
                        }
                        c.a.n0.j.p0.g.f.e.b(this.f29498b, gradientDrawable);
                    }
                }
            } catch (IllegalArgumentException e3) {
                e = e3;
            }
            this.f29498b.setTextColor(parseColor);
            this.f29499c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090c7e);
            this.f29500d = findViewById(R.id.obfuscated_res_0x7f091aca);
            this.j = new a(this);
            i = this.m;
            str = "2";
            if (i != 0 && i != 1 && i == 2) {
                str = "1";
            }
            GamenowDownloadButtomView i32 = c.a.n0.h.b.f.c.n().i(this.j, "gbview", str);
            this.k = i32;
            this.f29499c.addView(i32);
            this.f29498b.setOnClickListener(new b(this));
            simpleDraweeView = this.f29504h;
            if (simpleDraweeView != null) {
                simpleDraweeView.setOnClickListener(new c(this));
            }
            c.a.n0.j.p0.g.f.e.b(this.f29498b, gradientDrawable);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ArrayList arrayList = new ArrayList();
            GameGuideConfigInfo.CloseInfo closeInfo = this.l;
            ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList2 = closeInfo.gameList;
            String str = closeInfo.gameRecommendTips;
            int i = this.m;
            int i2 = 3;
            if (i != 0) {
                if (i != 1) {
                    i2 = 0;
                } else if (c.a.n0.a.t1.e.a0() == null || c.a.n0.a.t1.e.a0().V().d0() != 1) {
                    i2 = 6;
                }
            }
            if (arrayList2 != null && arrayList2.size() >= i2) {
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayList.add(arrayList2.get(i3));
                }
            }
            post(new d(this, arrayList));
            if (this.f29503g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f29503g.setText(str);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            GameGuideConfigInfo.CloseInfo closeInfo = this.l;
            String str = closeInfo.bannerTitle;
            String str2 = closeInfo.bannerSubTitle;
            String str3 = closeInfo.bannerImgUrl;
            if (this.f29502f != null && !TextUtils.isEmpty(str)) {
                this.f29502f.setText(str);
            }
            if (this.f29503g != null && !TextUtils.isEmpty(str2)) {
                this.f29503g.setText(str2);
            }
            if (this.f29504h == null || TextUtils.isEmpty(str3)) {
                return;
            }
            this.f29504h.setController(Fresco.newDraweeControllerBuilder().setUri(str3).setAutoPlayAnimations(true).build());
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = this.m;
            if (i == 0 || i == 1) {
                k();
            } else if (i != 2) {
            } else {
                l();
            }
        }
    }

    public void setOnClickListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.i = eVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = DownloadState.NOT_START;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.n = DownloadState.NOT_START;
        this.a = context;
        this.l = closeInfo;
        this.m = closeInfo.type;
        j();
        m();
    }
}
