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
/* loaded from: classes14.dex */
public class b implements g {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.adlanding.download.a.a dGu;
    private SwanAdDownloadButtonView dHa;
    private a dHb;
    private Context mContext;

    private void aNV() {
        this.dHa = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.aua().getResources().getDisplayMetrics().heightPixels);
        this.dHa.setLayoutParams(layoutParams);
        float p = p(this.mContext, c.C0507c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aE(this.dHa);
        this.dHa.S(dp2pxf(this.mContext, p)).gZ(true).lC(-1).lB(color).gY(true);
        this.dHa.setText(string);
        this.dHa.setVisibility(0);
        this.dHa.setProgress(this.dHb.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aNW() {
        this.dHa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dHb.dGS == SwanAdDownloadState.NOT_START || b.this.dHb.dGS == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.auk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aNY()).agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dGu);
                }
                if (b.this.dHb.dGS == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.auk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aNY()).agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dGu);
                }
                if (b.this.dHb.dGS == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.auk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aNY()).agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dGu);
                }
                if (b.this.dHb.dGS == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.auk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aNY()).agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dGu);
                }
                if (b.this.dHb.dGS == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dGu.agD();
                    com.baidu.swan.apps.t.a.auk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aNY()).agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dGu);
                }
                if (b.this.dHb.dGS == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String agE = b.this.dGu.agE();
                    if (TextUtils.isEmpty(b.this.dHb.name) && !TextUtils.isEmpty(agE)) {
                        b.this.kf(agE);
                    }
                    b.this.vj(b.this.dHb.name);
                }
            }
        });
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aE(View view) {
        if (view != null) {
            float p = p(this.mContext, c.C0507c.swanapp_round_width_size);
            float p2 = p(this.mContext, c.C0507c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.dHb.dGS) {
            this.dHb.dGS = swanAdDownloadState;
            aNX();
        }
    }

    private void setProgress(int i) {
        if (i != this.dHb.percent) {
            this.dHb.percent = i;
            aNX();
        }
    }

    private void aNX() {
        String string;
        if (this.dHb.dGS == SwanAdDownloadState.DOWNLOADING) {
            if (this.dHa != null && this.dHa.getVisibility() != 8) {
                if (this.dHb.percent < this.dHa.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dHb.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dHa.setText(string);
                this.dHa.setProgress(this.dHb.percent);
            }
        } else {
            if (e.am(this.mContext, this.dHb.name)) {
                this.dHb.dGS = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dHb.dGS));
            if (this.dHb.dGS == SwanAdDownloadState.DOWNLOADED) {
                this.dHa.setProgress(100);
            }
            if (this.dHb.dGS == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dHa.setProgress(this.dHb.percent);
            }
            this.dHa.setText(string2);
        }
        if (this.dHa != null) {
            this.dHa.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(String str) {
        ResolveInfo ag;
        if (!TextUtils.isEmpty(str) && (ag = ag(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(ag.activityInfo.packageName, ag.activityInfo.name));
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

    private ResolveInfo ag(Context context, String str) {
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
    public void kf(String str) {
        this.dHb.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dHa;
    }

    public Object aNY() {
        return this.dHa.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dHa.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void afv() {
        aE(this.dHa);
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
        this.dHb = a.cN(aVar.url, aVar.name);
        this.dGu = aVar2;
        aNV();
        aNW();
        return this;
    }
}
