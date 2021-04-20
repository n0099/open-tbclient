package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import d.b.g0.a.i2.k0;
import d.b.g0.a.p.c.g;
import d.b.g0.e.a.e;
import d.b.g0.e.a.p.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InteractiveEndFrameView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public RewardWebView f12420e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.e.a.r.b f12421f;

    /* renamed from: g  reason: collision with root package name */
    public AdElementInfo f12422g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.a.q.g.b.a f12423h;
    public d.b.g0.a.q.g.a.a i;
    public JSONObject j;
    public String k;
    public String l;
    public SwanAdDownloadState m;
    public d.b.g0.a.q.b n;
    public g o;
    public RelativeLayout p;
    public RelativeLayout.LayoutParams q;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.q.g.a.a {
        public a() {
        }

        @Override // d.b.g0.a.q.g.a.a
        public void a(SwanAdDownloadState swanAdDownloadState, int i) {
            InteractiveEndFrameView.this.o.b(i);
        }

        @Override // d.b.g0.a.q.g.a.a
        public void b() {
            InteractiveEndFrameView.this.n.c("appinstallbegin");
        }

        @Override // d.b.g0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i) {
            InteractiveEndFrameView.this.o.e(swanAdDownloadState);
            if (InteractiveEndFrameView.this.m == swanAdDownloadState) {
                return;
            }
            if (InteractiveEndFrameView.this.m == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.n.c("appdownloadbegin");
            } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                InteractiveEndFrameView.this.n.c("appdownloadpause");
            } else if (InteractiveEndFrameView.this.m == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.n.c("appdownloadcontinue");
            } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                InteractiveEndFrameView.this.n.c("appdownloadfinish");
                InteractiveEndFrameView.this.n.c("appinstallbegin");
            } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                InteractiveEndFrameView.this.n.c("appinstallfinish");
            }
            InteractiveEndFrameView.this.m = swanAdDownloadState;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void d(String str) {
            InteractiveEndFrameView.this.y(str);
        }

        @Override // d.b.g0.a.q.g.a.a
        public String e() {
            InteractiveEndFrameView.this.n.c("appinstallopen");
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            return interactiveEndFrameView.v(interactiveEndFrameView.k);
        }

        @Override // d.b.g0.a.q.g.a.a
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
            g a2 = d.b.g0.a.w0.a.a();
            if (a2 == null) {
                return;
            }
            c.e(InteractiveEndFrameView.this.f12422g, InteractiveEndFrameView.this.f12421f);
            InteractiveEndFrameView.this.k = str;
            String v = InteractiveEndFrameView.this.v(str);
            if (!TextUtils.isEmpty(v)) {
                InteractiveEndFrameView.this.l = v;
            }
            InteractiveEndFrameView.this.f12423h = new d.b.g0.a.q.g.b.a(InteractiveEndFrameView.this.k, InteractiveEndFrameView.this.l);
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            interactiveEndFrameView.o = a2.f(interactiveEndFrameView.getContext(), InteractiveEndFrameView.this.f12423h, InteractiveEndFrameView.this.i);
            InteractiveEndFrameView.this.o.c(InteractiveEndFrameView.this.f12423h);
            InteractiveEndFrameView.this.o.d();
            if (k0.C(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.f12423h.f45880b) && InteractiveEndFrameView.this.p != null) {
                InteractiveEndFrameView.this.p.removeView(InteractiveEndFrameView.this.o.getRealView());
                InteractiveEndFrameView.this.p.addView(InteractiveEndFrameView.this.o.getRealView(), InteractiveEndFrameView.this.q);
                InteractiveEndFrameView.this.o.e(SwanAdDownloadState.INSTALLED);
                return;
            }
            d.b.g0.a.w0.a.d().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.f12423h.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.i);
        }
    }

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.l = "";
        this.m = SwanAdDownloadState.NOT_START;
        this.f12421f = new d.b.g0.e.a.r.b(context);
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.f12422g = adElementInfo;
        this.p = relativeLayout;
        String t = adElementInfo.t();
        RewardWebView rewardWebView = new RewardWebView(getContext());
        this.f12420e = rewardWebView;
        rewardWebView.setBackgroundColor(-1);
        this.f12420e.loadUrl(t);
        addView(this.f12420e, new RelativeLayout.LayoutParams(-1, -1));
        this.j = adElementInfo.i();
        this.n = new d.b.g0.a.q.b(getContext(), this.j);
        w();
        setDownloadListener();
    }

    public void setDownloadListener() {
        this.f12420e.setDownloadListener(new b());
    }

    public void t() {
        RewardWebView rewardWebView = this.f12420e;
        if (rewardWebView != null) {
            rewardWebView.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.m) {
            this.i = null;
            d.b.g0.a.w0.a.d().a(getContext(), this.f12423h.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.i);
        }
    }

    public final float u(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    public final String v(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }

    public void w() {
        if (d.b.g0.a.w0.a.a() == null) {
            return;
        }
        x();
        this.i = new a();
    }

    public final void x() {
        float u = u(getContext(), e.end_frame_download_btn_width);
        float u2 = u(getContext(), e.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.end_frame_download_btn_bottom_margin);
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
        edit.commit();
    }
}
