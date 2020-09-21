package com.baidu.swan.game.ad.downloader.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.downloader.e;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements g {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.adlanding.download.a.a dlR;
    private SwanAdDownloadButtonView dmx;
    private a dmy;
    private Context mContext;

    private void aJs() {
        this.dmx = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.apu().getResources().getDisplayMetrics().heightPixels);
        this.dmx.setLayoutParams(layoutParams);
        float p = p(this.mContext, c.C0476c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aC(this.dmx);
        this.dmx.O(dp2pxf(this.mContext, p)).gq(true).kU(-1).kT(color).gp(true);
        this.dmx.setText(string);
        this.dmx.setVisibility(0);
        this.dmx.setProgress(this.dmy.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aJt() {
        this.dmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dmy.dmp == SwanAdDownloadState.NOT_START || b.this.dmy.dmp == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.apE().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aJv()).aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dlR);
                }
                if (b.this.dmy.dmp == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.apE().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aJv()).aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dlR);
                }
                if (b.this.dmy.dmp == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.apE().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aJv()).aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dlR);
                }
                if (b.this.dmy.dmp == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.apE().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aJv()).aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dlR);
                }
                if (b.this.dmy.dmp == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dlR.abX();
                    com.baidu.swan.apps.t.a.apE().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aJv()).aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dlR);
                }
                if (b.this.dmy.dmp == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String abY = b.this.dlR.abY();
                    if (TextUtils.isEmpty(b.this.dmy.name) && !TextUtils.isEmpty(abY)) {
                        b.this.ja(abY);
                    }
                    b.this.ue(b.this.dmy.name);
                }
            }
        });
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aC(View view) {
        if (view != null) {
            float p = p(this.mContext, c.C0476c.swanapp_round_width_size);
            float p2 = p(this.mContext, c.C0476c.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (p >= 0.0f && p <= 1.0f) {
                p *= this.mContext.getResources().getDisplayMetrics().widthPixels;
            }
            if (p2 > 0.0f && p2 <= 1.0f) {
                p2 *= this.mContext.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) p;
            layoutParams.height = (int) p2;
        }
    }

    private void b(SwanAdDownloadState swanAdDownloadState) {
        if (swanAdDownloadState != this.dmy.dmp) {
            this.dmy.dmp = swanAdDownloadState;
            aJu();
        }
    }

    private void setProgress(int i) {
        if (i != this.dmy.percent) {
            this.dmy.percent = i;
            aJu();
        }
    }

    private void aJu() {
        String string;
        if (this.dmy.dmp == SwanAdDownloadState.DOWNLOADING) {
            if (this.dmx != null && this.dmx.getVisibility() != 8) {
                if (this.dmy.percent < this.dmx.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dmy.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dmx.setText(string);
                this.dmx.setProgress(this.dmy.percent);
            }
        } else {
            if (e.ai(this.mContext, this.dmy.name)) {
                this.dmy.dmp = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dmy.dmp));
            if (this.dmy.dmp == SwanAdDownloadState.DOWNLOADED) {
                this.dmx.setProgress(100);
            }
            if (this.dmy.dmp == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dmx.setProgress(this.dmy.percent);
            }
            this.dmx.setText(string2);
        }
        if (this.dmx != null) {
            this.dmx.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ue(String str) {
        ResolveInfo ac;
        if (!TextUtils.isEmpty(str) && (ac = ac(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(ac.activityInfo.packageName, ac.activityInfo.name));
            intent.setFlags(268435456);
            try {
                this.mContext.startActivity(intent);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ResolveInfo ac(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        return queryIntentActivities.iterator().next();
    }

    private int c(SwanAdDownloadState swanAdDownloadState) {
        switch (swanAdDownloadState) {
            case NOT_START:
                return c.g.swanapp_ad_download_button;
            case DOWNLOADING:
                return c.g.swanapp_ad_download_button_pause;
            case DOWNLOAD_PAUSED:
                return c.g.swanapp_ad_download_button_continue;
            case DOWNLOADED:
                return c.g.swanapp_ad_download_button_install;
            case DOWNLOAD_FAILED:
                return c.g.swanapp_ad_download_button_failed_retry;
            case INSTALLED:
                return c.g.swanapp_ad_download_button_open;
            default:
                return c.g.swanapp_ad_download_button;
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ja(String str) {
        this.dmy.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dmx;
    }

    public Object aJv() {
        return this.dmx.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void M(Object obj) {
        this.dmx.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void aaP() {
        aC(this.dmx);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void updateProgress(int i) {
        setProgress(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.a.g
    /* renamed from: b */
    public b a(Context context, com.baidu.swan.apps.adlanding.download.model.a aVar, com.baidu.swan.apps.adlanding.download.a.a aVar2) {
        this.mContext = context;
        this.dmy = a.cB(aVar.url, aVar.name);
        this.dlR = aVar2;
        aJs();
        aJt();
        return this;
    }
}
