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
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.GamenowRecommendPopViewAdapter;
import com.baidu.swan.game.guide.download.GamenowDownloadButtomView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.a.k;
import d.a.l0.f.j.h;
import d.a.l0.f.j.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class GamenowRecommendPopView extends RelativeLayout {
    public static final boolean t = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public Context f11645e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11646f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f11647g;

    /* renamed from: h  reason: collision with root package name */
    public View f11648h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f11649i;
    public TextView j;
    public TextView k;
    public SimpleDraweeView l;
    public e m;
    public d.a.l0.f.i.k.f.a n;
    public GamenowDownloadButtomView o;
    public GameGuideConfigInfo.CloseInfo p;
    public int q;
    public DownloadState r;
    public boolean s;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.f.i.k.f.a {
        public a() {
        }

        @Override // d.a.l0.f.i.k.f.a
        public void a(int i2) {
            d.a.l0.f.j.n.c.n().D(i2);
        }

        @Override // d.a.l0.f.i.k.f.a
        public void b() {
        }

        @Override // d.a.l0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            String str;
            if (GamenowRecommendPopView.this.r == downloadState) {
                return;
            }
            if (GamenowRecommendPopView.this.q == 0 || GamenowRecommendPopView.this.q == 1) {
                str = "2";
            } else {
                str = GamenowRecommendPopView.this.q == 2 ? "1" : "";
            }
            GamenowRecommendPopView.this.i(downloadState, str);
            d.a.l0.f.j.n.c.n().E(downloadState);
            GamenowRecommendPopView.this.r = downloadState;
            GamenowRecommendPopView.this.s = true;
        }

        @Override // d.a.l0.f.i.k.f.a
        public void d(String str) {
        }

        @Override // d.a.l0.f.i.k.f.a
        public String e() {
            return d.a.l0.f.j.b.o.I();
        }

        @Override // d.a.l0.f.i.k.f.a
        public void f(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GamenowRecommendPopView.this.q != 0 && GamenowRecommendPopView.this.q != 1) {
                if (GamenowRecommendPopView.this.q == 2) {
                    d.a.l0.f.j.r.b.n().b("gbADialogClick", "1", "", "");
                }
            } else {
                d.a.l0.f.j.r.b.n().b("gbBDialogClick", "1", "", "");
            }
            d.a.l0.f.j.n.c.n().w("");
            d.a.l0.f.j.n.c.n().x("");
            if (GamenowRecommendPopView.this.m != null) {
                GamenowRecommendPopView.this.m.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GamenowRecommendPopView.this.q == 2) {
                d.a.l0.f.j.r.b.n().b("gbADialogClick", "2", "", "");
            }
            d.a.l0.f.j.n.c.n().s(true);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f11653e;

        public d(List list) {
            this.f11653e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            GamenowRecommendPopView.this.f11649i.setAdapter(new GamenowRecommendPopViewAdapter(GamenowRecommendPopView.this.f11645e, this.f11653e));
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    public GamenowRecommendPopView(Context context) {
        super(context);
        this.r = DownloadState.NOT_START;
    }

    public final void i(DownloadState downloadState, String str) {
        String str2;
        String str3;
        String H = d.a.l0.f.j.b.o.H();
        if (TextUtils.equals(d.a.l0.f.j.b.o.I(), d.a.l0.f.j.m.c.f50548a)) {
            H = d.a.l0.f.j.n.c.n().o();
        }
        String str4 = H;
        if (TextUtils.isEmpty(str) || !str.equals("2")) {
            str2 = "";
            str3 = str2;
        } else {
            str2 = d.a.l0.f.j.n.c.n().l();
            str3 = d.a.l0.f.j.n.c.n().m();
        }
        DownloadState downloadState2 = this.r;
        if (downloadState2 != DownloadState.DOWNLOAD_PAUSED && downloadState2 != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
            d.a.l0.f.j.r.b.n().e("statusBeginDownload", "gbview", str, str2, str3, str4);
        } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
            if (this.s) {
                d.a.l0.f.j.r.b.n().e("statusDownloadPause", "gbview", str, str2, str3, str4);
            }
        } else if (downloadState == DownloadState.DOWNLOADED && this.s) {
            d.a.l0.f.j.r.b.n().e("statusDownloaded", "gbview", str, str2, str3, str4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        int i2;
        String str;
        SimpleDraweeView simpleDraweeView;
        int i3 = this.q;
        if (i3 == 0 || i3 == 1) {
            LayoutInflater.from(this.f11645e).inflate(i.aiapps_gamenow_recommend_game_view, this);
            this.f11649i = (RecyclerView) findViewById(h.rv_guide_game);
            this.f11649i.setLayoutManager(new GridLayoutManager(this.f11645e, 3));
        } else if (i3 == 2) {
            LayoutInflater.from(this.f11645e).inflate(i.aiapps_gamenow_recommend_view, this);
            this.j = (TextView) findViewById(h.gamenow_recommend_title);
            this.l = (SimpleDraweeView) findViewById(h.active_image_bg);
        }
        this.k = (TextView) findViewById(h.gamenow_recommend_sub_title);
        this.f11646f = (TextView) findViewById(h.gamenow_guide_exit_game);
        int parseColor = Color.parseColor("#333333");
        GradientDrawable gradientDrawable = null;
        try {
            if (!TextUtils.isEmpty(this.p.exitTextColor) && !this.p.exitTextColor.equals(StringUtil.NULL_STRING)) {
                parseColor = Color.parseColor(this.p.exitTextColor);
            }
            if (!TextUtils.isEmpty(this.p.exitBackgroundColor) && !this.p.exitBackgroundColor.equals(StringUtil.NULL_STRING) && (this.f11646f.getBackground() instanceof GradientDrawable)) {
                GradientDrawable gradientDrawable2 = (GradientDrawable) this.f11646f.getBackground();
                try {
                    gradientDrawable2.setColor(Color.parseColor(this.p.exitBackgroundColor));
                    gradientDrawable = gradientDrawable2;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    gradientDrawable = gradientDrawable2;
                    if (t) {
                        e.printStackTrace();
                    }
                    this.f11646f.setTextColor(parseColor);
                    this.f11647g = (LinearLayout) findViewById(h.gamenow_guide_download_container);
                    this.f11648h = findViewById(h.rl_guide_game_bg);
                    this.n = new a();
                    i2 = this.q;
                    str = "2";
                    if (i2 != 0) {
                        str = "1";
                    }
                    GamenowDownloadButtomView i4 = d.a.l0.f.j.n.c.n().i(this.n, "gbview", str);
                    this.o = i4;
                    this.f11647g.addView(i4);
                    this.f11646f.setOnClickListener(new b());
                    simpleDraweeView = this.l;
                    if (simpleDraweeView != null) {
                    }
                    d.a.l0.h.o0.g.f.e.b(this.f11646f, gradientDrawable);
                }
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
        }
        this.f11646f.setTextColor(parseColor);
        this.f11647g = (LinearLayout) findViewById(h.gamenow_guide_download_container);
        this.f11648h = findViewById(h.rl_guide_game_bg);
        this.n = new a();
        i2 = this.q;
        str = "2";
        if (i2 != 0 && i2 != 1 && i2 == 2) {
            str = "1";
        }
        GamenowDownloadButtomView i42 = d.a.l0.f.j.n.c.n().i(this.n, "gbview", str);
        this.o = i42;
        this.f11647g.addView(i42);
        this.f11646f.setOnClickListener(new b());
        simpleDraweeView = this.l;
        if (simpleDraweeView != null) {
            simpleDraweeView.setOnClickListener(new c());
        }
        d.a.l0.h.o0.g.f.e.b(this.f11646f, gradientDrawable);
    }

    public final void k() {
        ArrayList arrayList = new ArrayList();
        GameGuideConfigInfo.CloseInfo closeInfo = this.p;
        ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList2 = closeInfo.gameList;
        String str = closeInfo.gameRecommendTips;
        int i2 = this.q;
        int i3 = 3;
        if (i2 != 0) {
            if (i2 != 1) {
                i3 = 0;
            } else if (d.a.l0.a.a2.e.Q() == null || d.a.l0.a.a2.e.Q().L().d0() != 1) {
                i3 = 6;
            }
        }
        if (arrayList2 != null && arrayList2.size() >= i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.add(arrayList2.get(i4));
            }
        }
        post(new d(arrayList));
        if (this.k == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.k.setText(str);
    }

    public final void l() {
        GameGuideConfigInfo.CloseInfo closeInfo = this.p;
        String str = closeInfo.bannerTitle;
        String str2 = closeInfo.bannerSubTitle;
        String str3 = closeInfo.bannerImgUrl;
        if (this.j != null && !TextUtils.isEmpty(str)) {
            this.j.setText(str);
        }
        if (this.k != null && !TextUtils.isEmpty(str2)) {
            this.k.setText(str2);
        }
        if (this.l == null || TextUtils.isEmpty(str3)) {
            return;
        }
        this.l.setController(Fresco.newDraweeControllerBuilder().setUri(str3).setAutoPlayAnimations(true).build());
    }

    public final void m() {
        int i2 = this.q;
        if (i2 == 0 || i2 == 1) {
            k();
        } else if (i2 != 2) {
        } else {
            l();
        }
    }

    public void setOnClickListener(e eVar) {
        this.m = eVar;
    }

    public GamenowRecommendPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = DownloadState.NOT_START;
    }

    public GamenowRecommendPopView(Context context, GameGuideConfigInfo.CloseInfo closeInfo) {
        super(context);
        this.r = DownloadState.NOT_START;
        this.f11645e = context;
        this.p = closeInfo;
        this.q = closeInfo.type;
        j();
        m();
    }
}
