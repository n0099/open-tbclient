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
    private SwanAdDownloadButtonView dMS;
    private a dMT;
    private com.baidu.swan.apps.adlanding.download.a.a dMm;
    private Context mContext;

    private void aQv() {
        this.dMS = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.awA().getResources().getDisplayMetrics().heightPixels);
        this.dMS.setLayoutParams(layoutParams);
        float p = p(this.mContext, c.C0519c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aI(this.dMS);
        this.dMS.U(dp2pxf(this.mContext, p)).hi(true).lM(-1).lL(color).hh(true);
        this.dMS.setText(string);
        this.dMS.setVisibility(0);
        this.dMS.setProgress(this.dMT.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aQw() {
        this.dMS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dMT.dMK == SwanAdDownloadState.NOT_START || b.this.dMT.dMK == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.awK().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aQy()).ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dMm);
                }
                if (b.this.dMT.dMK == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.awK().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aQy()).ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dMm);
                }
                if (b.this.dMT.dMK == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.awK().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aQy()).ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dMm);
                }
                if (b.this.dMT.dMK == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.awK().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aQy()).ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dMm);
                }
                if (b.this.dMT.dMK == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dMm.ajd();
                    com.baidu.swan.apps.t.a.awK().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aQy()).ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dMm);
                }
                if (b.this.dMT.dMK == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String aje = b.this.dMm.aje();
                    if (TextUtils.isEmpty(b.this.dMT.name) && !TextUtils.isEmpty(aje)) {
                        b.this.ku(aje);
                    }
                    b.this.vx(b.this.dMT.name);
                }
            }
        });
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aI(View view) {
        if (view != null) {
            float p = p(this.mContext, c.C0519c.swanapp_round_width_size);
            float p2 = p(this.mContext, c.C0519c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.dMT.dMK) {
            this.dMT.dMK = swanAdDownloadState;
            aQx();
        }
    }

    private void setProgress(int i) {
        if (i != this.dMT.percent) {
            this.dMT.percent = i;
            aQx();
        }
    }

    private void aQx() {
        String string;
        if (this.dMT.dMK == SwanAdDownloadState.DOWNLOADING) {
            if (this.dMS != null && this.dMS.getVisibility() != 8) {
                if (this.dMT.percent < this.dMS.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dMT.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dMS.setText(string);
                this.dMS.setProgress(this.dMT.percent);
            }
        } else {
            if (e.am(this.mContext, this.dMT.name)) {
                this.dMT.dMK = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dMT.dMK));
            if (this.dMT.dMK == SwanAdDownloadState.DOWNLOADED) {
                this.dMS.setProgress(100);
            }
            if (this.dMT.dMK == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dMS.setProgress(this.dMT.percent);
            }
            this.dMS.setText(string2);
        }
        if (this.dMS != null) {
            this.dMS.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx(String str) {
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
    public void ku(String str) {
        this.dMT.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dMS;
    }

    public Object aQy() {
        return this.dMS.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dMS.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ahV() {
        aI(this.dMS);
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
        this.dMT = a.cN(aVar.url, aVar.name);
        this.dMm = aVar2;
        aQv();
        aQw();
        return this;
    }
}
