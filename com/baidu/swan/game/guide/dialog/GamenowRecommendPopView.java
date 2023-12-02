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
import com.baidu.tieba.R;
import com.baidu.tieba.ga4;
import com.baidu.tieba.gx3;
import com.baidu.tieba.jw3;
import com.baidu.tieba.k63;
import com.baidu.tieba.lu3;
import com.baidu.tieba.ow3;
import com.baidu.tieba.uw3;
import com.baidu.tieba.vm1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GamenowRecommendPopView extends RelativeLayout {
    public static final boolean p = vm1.a;
    public Context a;
    public TextView b;
    public LinearLayout c;
    public View d;
    public RecyclerView e;
    public TextView f;
    public TextView g;
    public SimpleDraweeView h;
    public e i;
    public lu3 j;
    public GamenowDownloadButtomView k;
    public GameGuideConfigInfo.CloseInfo l;
    public int m;
    public DownloadState n;
    public boolean o;

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes4.dex */
    public class a implements lu3 {
        @Override // com.baidu.tieba.lu3
        public void b() {
        }

        @Override // com.baidu.tieba.lu3
        public void d(String str) {
        }

        @Override // com.baidu.tieba.lu3
        public void f(boolean z) {
        }

        public a() {
        }

        @Override // com.baidu.tieba.lu3
        public void a(int i) {
            uw3.n().D(i);
        }

        @Override // com.baidu.tieba.lu3
        public void c(DownloadState downloadState, int i) {
            String str;
            if (GamenowRecommendPopView.this.n == downloadState) {
                return;
            }
            if (GamenowRecommendPopView.this.m != 0 && GamenowRecommendPopView.this.m != 1) {
                if (GamenowRecommendPopView.this.m == 2) {
                    str = "1";
                } else {
                    str = "";
                }
            } else {
                str = "2";
            }
            GamenowRecommendPopView.this.i(downloadState, str);
            uw3.n().E(downloadState);
            GamenowRecommendPopView.this.n = downloadState;
            GamenowRecommendPopView.this.o = true;
        }

        @Override // com.baidu.tieba.lu3
        public String e() {
            return jw3.o.I();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GamenowRecommendPopView.this.m != 0 && GamenowRecommendPopView.this.m != 1) {
                if (GamenowRecommendPopView.this.m == 2) {
                    gx3.n().b("gbADialogClick", "1", "", "");
                }
            } else {
                gx3.n().b("gbBDialogClick", "1", "", "");
            }
            uw3.n().w("");
            uw3.n().x("");
            if (GamenowRecommendPopView.this.i != null) {
                GamenowRecommendPopView.this.i.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (GamenowRecommendPopView.this.m == 2) {
                gx3.n().b("gbADialogClick", "2", "", "");
            }
            uw3.n().s(true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public final /* synthetic */ List a;

        public d(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            GamenowRecommendPopView.this.e.setAdapter(new GamenowRecommendPopViewAdapter(GamenowRecommendPopView.this.a, this.a));
        }
    }

    public final void m() {
        int i = this.m;
        if (i != 0 && i != 1) {
            if (i == 2) {
                l();
                return;
            }
            return;
        }
        k();
    }

    public GamenowRecommendPopView(Context context) {
        super(context);
        this.n = DownloadState.NOT_START;
    }

    public void setOnClickListener(e eVar) {
        this.i = eVar;
    }

    public GamenowRecommendPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = DownloadState.NOT_START;
    }

    public GamenowRecommendPopView(Context context, GameGuideConfigInfo.CloseInfo closeInfo) {
        super(context);
        this.n = DownloadState.NOT_START;
        this.a = context;
        this.l = closeInfo;
        this.m = closeInfo.type;
        j();
        m();
    }

    public final void i(DownloadState downloadState, String str) {
        String str2;
        String str3;
        String H = jw3.o.H();
        if (TextUtils.equals(jw3.o.I(), ow3.a)) {
            H = uw3.n().o();
        }
        String str4 = H;
        if (TextUtils.isEmpty(str) || !str.equals("2")) {
            str2 = "";
            str3 = str2;
        } else {
            str2 = uw3.n().l();
            str3 = uw3.n().m();
        }
        DownloadState downloadState2 = this.n;
        if (downloadState2 != DownloadState.DOWNLOAD_PAUSED && downloadState2 != DownloadState.DOWNLOAD_FAILED && downloadState == DownloadState.DOWNLOADING) {
            gx3.n().e("statusBeginDownload", "gbview", str, str2, str3, str4);
        } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
            if (this.o) {
                gx3.n().e("statusDownloadPause", "gbview", str, str2, str3, str4);
            }
        } else if (downloadState == DownloadState.DOWNLOADED && this.o) {
            gx3.n().e("statusDownloaded", "gbview", str, str2, str3, str4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        int i;
        String str;
        SimpleDraweeView simpleDraweeView;
        int i2 = this.m;
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2) {
                LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00b6, this);
                this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090e88);
                this.h = (SimpleDraweeView) findViewById(R.id.obfuscated_res_0x7f090096);
            }
        } else {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d00b4, this);
            this.e = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f0920a0);
            this.e.setLayoutManager(new GridLayoutManager(this.a, 3));
        }
        this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090e87);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090e85);
        int parseColor = Color.parseColor("#333333");
        GradientDrawable gradientDrawable = null;
        try {
            if (!TextUtils.isEmpty(this.l.exitTextColor) && !this.l.exitTextColor.equals(StringUtil.NULL_STRING)) {
                parseColor = Color.parseColor(this.l.exitTextColor);
            }
            if (!TextUtils.isEmpty(this.l.exitBackgroundColor) && !this.l.exitBackgroundColor.equals(StringUtil.NULL_STRING) && (this.b.getBackground() instanceof GradientDrawable)) {
                GradientDrawable gradientDrawable2 = (GradientDrawable) this.b.getBackground();
                try {
                    gradientDrawable2.setColor(Color.parseColor(this.l.exitBackgroundColor));
                    gradientDrawable = gradientDrawable2;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    gradientDrawable = gradientDrawable2;
                    if (p) {
                        e.printStackTrace();
                    }
                    this.b.setTextColor(parseColor);
                    this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e84);
                    this.d = findViewById(R.id.obfuscated_res_0x7f09203c);
                    this.j = new a();
                    i = this.m;
                    str = "2";
                    if (i != 0) {
                        str = "1";
                    }
                    GamenowDownloadButtomView i3 = uw3.n().i(this.j, "gbview", str);
                    this.k = i3;
                    this.c.addView(i3);
                    this.b.setOnClickListener(new b());
                    simpleDraweeView = this.h;
                    if (simpleDraweeView != null) {
                    }
                    ga4.b(this.b, gradientDrawable);
                }
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
        }
        this.b.setTextColor(parseColor);
        this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090e84);
        this.d = findViewById(R.id.obfuscated_res_0x7f09203c);
        this.j = new a();
        i = this.m;
        str = "2";
        if (i != 0 && i != 1 && i == 2) {
            str = "1";
        }
        GamenowDownloadButtomView i32 = uw3.n().i(this.j, "gbview", str);
        this.k = i32;
        this.c.addView(i32);
        this.b.setOnClickListener(new b());
        simpleDraweeView = this.h;
        if (simpleDraweeView != null) {
            simpleDraweeView.setOnClickListener(new c());
        }
        ga4.b(this.b, gradientDrawable);
    }

    public final void k() {
        ArrayList arrayList = new ArrayList();
        GameGuideConfigInfo.CloseInfo closeInfo = this.l;
        ArrayList<GameGuideConfigInfo.RecommendGameInfo> arrayList2 = closeInfo.gameList;
        String str = closeInfo.gameRecommendTips;
        int i = this.m;
        int i2 = 3;
        if (i != 0) {
            if (i == 1) {
                if (k63.c0() == null || k63.c0().X().e0() != 1) {
                    i2 = 6;
                }
            } else {
                i2 = 0;
            }
        }
        if (arrayList2 != null && arrayList2.size() >= i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(arrayList2.get(i3));
            }
        }
        post(new d(arrayList));
        if (this.g != null && !TextUtils.isEmpty(str)) {
            this.g.setText(str);
        }
    }

    public final void l() {
        GameGuideConfigInfo.CloseInfo closeInfo = this.l;
        String str = closeInfo.bannerTitle;
        String str2 = closeInfo.bannerSubTitle;
        String str3 = closeInfo.bannerImgUrl;
        if (this.f != null && !TextUtils.isEmpty(str)) {
            this.f.setText(str);
        }
        if (this.g != null && !TextUtils.isEmpty(str2)) {
            this.g.setText(str2);
        }
        if (this.h != null && !TextUtils.isEmpty(str3)) {
            this.h.setController(Fresco.newDraweeControllerBuilder().setUri(str3).setAutoPlayAnimations(true).build());
        }
    }
}
