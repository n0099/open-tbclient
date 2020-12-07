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
    private com.baidu.swan.apps.adlanding.download.a.a dRC;
    private SwanAdDownloadButtonView dSh;
    private a dSi;
    private Context mContext;

    private void aSS() {
        this.dSh = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.aza().getResources().getDisplayMetrics().heightPixels);
        this.dSh.setLayoutParams(layoutParams);
        float y = y(this.mContext, c.C0529c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aK(this.dSh);
        this.dSh.T(dp2pxf(this.mContext, y)).hA(true).mg(-1).mf(color).hz(true);
        this.dSh.setText(string);
        this.dSh.setVisibility(0);
        this.dSh.setProgress(this.dSi.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aST() {
        this.dSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dSi.dRZ == SwanAdDownloadState.NOT_START || b.this.dSi.dRZ == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.azk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aSV()).alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dRC);
                }
                if (b.this.dSi.dRZ == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.azk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aSV()).alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dRC);
                }
                if (b.this.dSi.dRZ == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.azk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aSV()).alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dRC);
                }
                if (b.this.dSi.dRZ == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.azk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aSV()).alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dRC);
                }
                if (b.this.dSi.dRZ == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dRC.alD();
                    com.baidu.swan.apps.t.a.azk().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aSV()).alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dRC);
                }
                if (b.this.dSi.dRZ == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String alE = b.this.dRC.alE();
                    if (TextUtils.isEmpty(b.this.dSi.name) && !TextUtils.isEmpty(alE)) {
                        b.this.kV(alE);
                    }
                    b.this.vZ(b.this.dSi.name);
                }
            }
        });
    }

    private float y(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aK(View view) {
        if (view != null) {
            float y = y(this.mContext, c.C0529c.swanapp_round_width_size);
            float y2 = y(this.mContext, c.C0529c.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (y >= 0.0f && y <= 1.0f) {
                y *= this.mContext.getResources().getDisplayMetrics().widthPixels;
            }
            if (y2 > 0.0f && y2 <= 1.0f) {
                y2 *= this.mContext.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) y;
            layoutParams.height = (int) y2;
        }
    }

    private void b(SwanAdDownloadState swanAdDownloadState) {
        if (swanAdDownloadState != this.dSi.dRZ) {
            this.dSi.dRZ = swanAdDownloadState;
            aSU();
        }
    }

    private void setProgress(int i) {
        if (i != this.dSi.percent) {
            this.dSi.percent = i;
            aSU();
        }
    }

    private void aSU() {
        String string;
        if (this.dSi.dRZ == SwanAdDownloadState.DOWNLOADING) {
            if (this.dSh != null && this.dSh.getVisibility() != 8) {
                if (this.dSi.percent < this.dSh.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dSi.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dSh.setText(string);
                this.dSh.setProgress(this.dSi.percent);
            }
        } else {
            if (e.am(this.mContext, this.dSi.name)) {
                this.dSi.dRZ = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dSi.dRZ));
            if (this.dSi.dRZ == SwanAdDownloadState.DOWNLOADED) {
                this.dSh.setProgress(100);
            }
            if (this.dSi.dRZ == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dSh.setProgress(this.dSi.percent);
            }
            this.dSh.setText(string2);
        }
        if (this.dSh != null) {
            this.dSh.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ(String str) {
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
    public void kV(String str) {
        this.dSi.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dSh;
    }

    public Object aSV() {
        return this.dSh.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dSh.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void akv() {
        aK(this.dSh);
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
        this.dSi = a.cT(aVar.url, aVar.name);
        this.dRC = aVar2;
        aSS();
        aST();
        return this;
    }
}
