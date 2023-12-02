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
import com.baidu.tieba.R;
import com.baidu.tieba.cv3;
import com.baidu.tieba.cw3;
import com.baidu.tieba.kv3;
import com.baidu.tieba.lu3;
import com.baidu.tieba.qu3;
import com.baidu.tieba.su3;
import com.baidu.tieba.tv3;
import com.baidu.tieba.uv3;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    public RewardWebView a;
    public kv3 b;
    public AdElementInfo c;
    public DownloadParams d;
    public lu3 e;
    public JSONObject f;
    public String g;
    public String h;
    public DownloadState i;
    public uv3 j;
    public qu3 k;
    public RelativeLayout l;
    public RelativeLayout.LayoutParams m;

    /* loaded from: classes4.dex */
    public class a implements lu3 {
        public a() {
        }

        @Override // com.baidu.tieba.lu3
        public void a(int i) {
            InteractiveEndFrameView.this.k.d(i);
        }

        @Override // com.baidu.tieba.lu3
        public void d(String str) {
            InteractiveEndFrameView.this.y(str);
        }

        @Override // com.baidu.tieba.lu3
        public void b() {
            InteractiveEndFrameView.this.j.c("appinstallbegin");
        }

        @Override // com.baidu.tieba.lu3
        public String e() {
            InteractiveEndFrameView.this.j.c("appinstallopen");
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            return interactiveEndFrameView.v(interactiveEndFrameView.g);
        }

        @Override // com.baidu.tieba.lu3
        public void c(DownloadState downloadState, int i) {
            InteractiveEndFrameView.this.k.b(downloadState);
            if (InteractiveEndFrameView.this.i == downloadState) {
                return;
            }
            if (InteractiveEndFrameView.this.i == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.j.c("appdownloadbegin");
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                InteractiveEndFrameView.this.j.c("appdownloadpause");
            } else if (InteractiveEndFrameView.this.i == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                InteractiveEndFrameView.this.j.c("appdownloadcontinue");
            } else if (downloadState == DownloadState.DOWNLOADED) {
                InteractiveEndFrameView.this.j.c("appdownloadfinish");
                InteractiveEndFrameView.this.j.c("appinstallbegin");
            } else if (downloadState == DownloadState.INSTALLED) {
                InteractiveEndFrameView.this.j.c("appinstallfinish");
            }
            InteractiveEndFrameView.this.i = downloadState;
        }

        @Override // com.baidu.tieba.lu3
        public void f(boolean z) {
            if (InteractiveEndFrameView.this.l == null) {
                return;
            }
            if (z) {
                InteractiveEndFrameView.this.l.removeView(InteractiveEndFrameView.this.k.getRealView());
                InteractiveEndFrameView.this.l.addView(InteractiveEndFrameView.this.k.getRealView(), InteractiveEndFrameView.this.m);
                return;
            }
            InteractiveEndFrameView.this.l.removeView(InteractiveEndFrameView.this.k.getRealView());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DownloadListener {
        public b() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            tv3.h(InteractiveEndFrameView.this.c, InteractiveEndFrameView.this.b);
            InteractiveEndFrameView.this.g = str;
            String v = InteractiveEndFrameView.this.v(str);
            if (!TextUtils.isEmpty(v)) {
                InteractiveEndFrameView.this.h = v;
            }
            InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
            interactiveEndFrameView.d = new DownloadParams(interactiveEndFrameView.g, InteractiveEndFrameView.this.h);
            InteractiveEndFrameView.this.k = new su3();
            InteractiveEndFrameView interactiveEndFrameView2 = InteractiveEndFrameView.this;
            qu3 qu3Var = interactiveEndFrameView2.k;
            qu3Var.c(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.d, InteractiveEndFrameView.this.e);
            interactiveEndFrameView2.k = qu3Var;
            InteractiveEndFrameView.this.k.e(InteractiveEndFrameView.this.d);
            InteractiveEndFrameView.this.k.f();
            if (cw3.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.d.b) && InteractiveEndFrameView.this.l != null) {
                InteractiveEndFrameView.this.l.removeView(InteractiveEndFrameView.this.k.getRealView());
                InteractiveEndFrameView.this.l.addView(InteractiveEndFrameView.this.k.getRealView(), InteractiveEndFrameView.this.m);
                InteractiveEndFrameView.this.k.b(DownloadState.INSTALLED);
                return;
            }
            cv3.b().d(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.d.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.e);
        }
    }

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.h = "";
        this.i = DownloadState.NOT_START;
        this.b = new kv3(context);
    }

    public final String v(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }

    public final void y(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.g, str);
            edit.apply();
        }
    }

    public final float u(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    public void s(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.c = adElementInfo;
        this.l = relativeLayout;
        String endFrameUrl = adElementInfo.getEndFrameUrl();
        RewardWebView rewardWebView = new RewardWebView(getContext());
        this.a = rewardWebView;
        rewardWebView.setBackgroundColor(-1);
        this.a.loadUrl(endFrameUrl);
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        this.f = adElementInfo.getAdMonitors();
        this.j = new uv3(getContext(), this.f);
        w();
        setDownloadListener();
    }

    public void setDownloadListener() {
        this.a.setDownloadListener(new b());
    }

    public void t() {
        RewardWebView rewardWebView = this.a;
        if (rewardWebView != null) {
            rewardWebView.destroy();
        }
        if (DownloadState.DOWNLOADING == this.i) {
            this.e = null;
            cv3.b().d(getContext(), this.d.a(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.e);
        }
    }

    public void w() {
        x();
        this.e = new a();
    }

    public final void x() {
        float u = u(getContext(), R.dimen.obfuscated_res_0x7f070449);
        float u2 = u(getContext(), R.dimen.obfuscated_res_0x7f070448);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070447);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (getContext().getResources().getDisplayMetrics().widthPixels * u), (int) (getContext().getResources().getDisplayMetrics().heightPixels * u2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.m = layoutParams;
    }
}
