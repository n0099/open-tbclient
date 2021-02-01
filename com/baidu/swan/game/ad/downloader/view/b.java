package com.baidu.swan.game.ad.downloader.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.downloader.e;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements g {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.adlanding.download.a.a dXU;
    private a dYA;
    private SwanAdDownloadButtonView dYz;
    private Context mContext;

    private void aRJ() {
        this.dYz = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.awW().getResources().getDisplayMetrics().heightPixels);
        this.dYz.setLayoutParams(layoutParams);
        float z = z(this.mContext, c.C0502c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aP(this.dYz);
        this.dYz.W(dp2pxf(this.mContext, z)).hQ(true).kL(-1).kK(color).hP(true);
        this.dYz.setText(string);
        this.dYz.setVisibility(0);
        this.dYz.setProgress(this.dYA.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aRK() {
        this.dYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dYA.dYr == SwanAdDownloadState.NOT_START || b.this.dYA.dYr == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.axg().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRM()).ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dXU);
                }
                if (b.this.dYA.dYr == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.axg().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRM()).ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dXU);
                }
                if (b.this.dYA.dYr == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.axg().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRM()).ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dXU);
                }
                if (b.this.dYA.dYr == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.axg().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRM()).ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dXU);
                }
                if (b.this.dYA.dYr == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dXU.ajs();
                    com.baidu.swan.apps.t.a.axg().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRM()).ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dXU);
                }
                if (b.this.dYA.dYr == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String ajt = b.this.dXU.ajt();
                    if (TextUtils.isEmpty(b.this.dYA.name) && !TextUtils.isEmpty(ajt)) {
                        b.this.jV(ajt);
                    }
                    b.this.vg(b.this.dYA.name);
                }
            }
        });
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aP(View view) {
        if (view != null) {
            float z = z(this.mContext, c.C0502c.swanapp_round_width_size);
            float z2 = z(this.mContext, c.C0502c.swanapp_round_height_size);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                view.setLayoutParams(layoutParams);
            }
            if (z >= 0.0f && z <= 1.0f) {
                z *= this.mContext.getResources().getDisplayMetrics().widthPixels;
            }
            if (z2 > 0.0f && z2 <= 1.0f) {
                z2 *= this.mContext.getResources().getDisplayMetrics().heightPixels;
            }
            layoutParams.width = (int) z;
            layoutParams.height = (int) z2;
        }
    }

    private void b(SwanAdDownloadState swanAdDownloadState) {
        if (swanAdDownloadState != this.dYA.dYr) {
            this.dYA.dYr = swanAdDownloadState;
            aRL();
        }
    }

    private void setProgress(int i) {
        if (i != this.dYA.percent) {
            this.dYA.percent = i;
            aRL();
        }
    }

    private void aRL() {
        String string;
        if (this.dYA.dYr == SwanAdDownloadState.DOWNLOADING) {
            if (this.dYz != null && this.dYz.getVisibility() != 8) {
                if (this.dYA.percent < this.dYz.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dYA.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dYz.setText(string);
                this.dYz.setProgress(this.dYA.percent);
            }
        } else {
            if (e.as(this.mContext, this.dYA.name)) {
                this.dYA.dYr = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dYA.dYr));
            if (this.dYA.dYr == SwanAdDownloadState.DOWNLOADED) {
                this.dYz.setProgress(100);
            }
            if (this.dYA.dYr == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dYz.setProgress(this.dYA.percent);
            }
            this.dYz.setText(string2);
        }
        if (this.dYz != null) {
            this.dYz.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg(String str) {
        ResolveInfo ak;
        if (!TextUtils.isEmpty(str) && (ak = ak(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(ak.activityInfo.packageName, ak.activityInfo.name));
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

    private ResolveInfo ak(Context context, String str) {
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
    public void jV(String str) {
        this.dYA.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dYz;
    }

    public Object aRM() {
        return this.dYz.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dYz.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void aik() {
        aP(this.dYz);
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
        this.dYA = a.cL(aVar.url, aVar.name);
        this.dXU = aVar2;
        aRJ();
        aRK();
        return this;
    }
}
