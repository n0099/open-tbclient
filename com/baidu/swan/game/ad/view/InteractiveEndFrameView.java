package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import d.a.i0.f.i.k.f.f;
import d.a.i0.f.i.q.c;
import d.a.i0.f.i.r.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InteractiveEndFrameView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public RewardWebView f11645e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.f.i.o.b f11646f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f11647g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadParams f11648h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.f.i.k.f.a f11649i;
    public JSONObject j;
    public String k;
    public String l;
    public DownloadState m;
    public c n;
    public f o;
    public RelativeLayout p;
    public RelativeLayout.LayoutParams q;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.f.i.k.f.a {
        public a() {
        }

        @Override // d.a.i0.f.i.k.f.a
        public void a(int i2) {
            InteractiveEndFrameView.this.o.d(i2);
        }

        @Override // d.a.i0.f.i.k.f.a
        public void b() {
            InteractiveEndFrameView.this.n.c("appinstallbegin");
        }

        @Override // d.a.i0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            InteractiveEndFrameView.this.o.b(downloadState);
            if (InteractiveEndFrameView.this.m == downloadState) {
                return;
            }
            if (InteractiveEndFrameView.this.m == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.n.c("appdownloadbegin");
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                InteractiveEndFrameView.this.n.c("appdownloadpause");
            } else if (InteractiveEndFrameView.this.m == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.n.c("appdownloadcontinue");
            } else if (downloadState == DownloadState.DOWNLOADED) {
                InteractiveEndFrameView.this.n.c("appdownloadfinish");
                InteractiveEndFrameView.this.n.c("appinstallbegin");
            } else if (downloadState == DownloadState.INSTALLED) {
                InteractiveEndFrameView.this.n.c("appinstallfinish");
            }
            InteractiveEndFrameView.this.m = downloadState;
        }

        @Override // d.a.i0.f.i.k.f.a
        public void d(String str) {
            InteractiveEndFrameView.this.y(str);
        }

        @Override // d.a.i0.f.i.k.f.a
        public String e() {
            InteractiveEndFrameView.this.n.c("appinstallopen");
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            return interactiveEndFrameView.v(interactiveEndFrameView.k);
        }

        @Override // d.a.i0.f.i.k.f.a
        public void f(boolean z) {
            if (InteractiveEndFrameView.this.p == null) {
                return;
            }
            if (z) {
                InteractiveEndFrameView.this.p.removeView(InteractiveEndFrameView.this.o.getRealView());
                InteractiveEndFrameView.this.p.addView(InteractiveEndFrameView.this.o.getRealView(), InteractiveEndFrameView.this.q);
                return;
            }
            InteractiveEndFrameView.this.p.removeView(InteractiveEndFrameView.this.o.getRealView());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            d.a.i0.f.i.q.b.h(InteractiveEndFrameView.this.f11647g, InteractiveEndFrameView.this.f11646f);
            InteractiveEndFrameView.this.k = str;
            String v = InteractiveEndFrameView.this.v(str);
            if (!TextUtils.isEmpty(v)) {
                InteractiveEndFrameView.this.l = v;
            }
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            interactiveEndFrameView.f11648h = new DownloadParams(interactiveEndFrameView.k, InteractiveEndFrameView.this.l);
            InteractiveEndFrameView.this.o = new d.a.i0.f.i.k.g.b();
            InteractiveEndFrameView interactiveEndFrameView2 = InteractiveEndFrameView.this;
            f fVar = interactiveEndFrameView2.o;
            fVar.c(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.f11648h, InteractiveEndFrameView.this.f11649i);
            interactiveEndFrameView2.o = fVar;
            InteractiveEndFrameView.this.o.e(InteractiveEndFrameView.this.f11648h);
            InteractiveEndFrameView.this.o.f();
            if (g.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.f11648h.f11634b) && InteractiveEndFrameView.this.p != null) {
                InteractiveEndFrameView.this.p.removeView(InteractiveEndFrameView.this.o.getRealView());
                InteractiveEndFrameView.this.p.addView(InteractiveEndFrameView.this.o.getRealView(), InteractiveEndFrameView.this.q);
                InteractiveEndFrameView.this.o.b(DownloadState.INSTALLED);
                return;
            }
            d.a.i0.f.i.m.a.b().b(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.f11648h.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.f11649i);
        }
    }

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.l = "";
        this.m = DownloadState.NOT_START;
        this.f11646f = new d.a.i0.f.i.o.b(context);
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.f11647g = adElementInfo;
        this.p = relativeLayout;
        String t = adElementInfo.t();
        RewardWebView rewardWebView = new RewardWebView(getContext());
        this.f11645e = rewardWebView;
        rewardWebView.setBackgroundColor(-1);
        this.f11645e.loadUrl(t);
        addView(this.f11645e, new RelativeLayout.LayoutParams(-1, -1));
        this.j = adElementInfo.i();
        this.n = new c(getContext(), this.j);
        w();
        setDownloadListener();
    }

    public void setDownloadListener() {
        this.f11645e.setDownloadListener(new b());
    }

    public void t() {
        RewardWebView rewardWebView = this.f11645e;
        if (rewardWebView != null) {
            rewardWebView.destroy();
        }
        if (DownloadState.DOWNLOADING == this.m) {
            this.f11649i = null;
            d.a.i0.f.i.m.a.b().b(getContext(), this.f11648h.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.f11649i);
        }
    }

    public final float u(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i2, typedValue, true);
        return typedValue.getFloat();
    }

    public final String v(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }

    public void w() {
        x();
        this.f11649i = new a();
    }

    public final void x() {
        float u = u(getContext(), d.a.i0.f.i.c.end_frame_download_btn_width);
        float u2 = u(getContext(), d.a.i0.f.i.c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.a.i0.f.i.c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels * u), (int) (getContext().getResources().getDisplayMetrics().heightPixels * u2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.q = layoutParams;
    }

    public final void y(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = getContext();
        getContext();
        SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
        edit.putString(this.k, str);
        edit.apply();
    }
}
