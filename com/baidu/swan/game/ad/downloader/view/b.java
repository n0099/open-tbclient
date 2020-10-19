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
    private com.baidu.swan.apps.adlanding.download.a.a dxX;
    private SwanAdDownloadButtonView dyD;
    private a dyE;
    private Context mContext;

    private void aMb() {
        this.dyD = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.asf().getResources().getDisplayMetrics().heightPixels);
        this.dyD.setLayoutParams(layoutParams);
        float p = p(this.mContext, c.C0493c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aD(this.dyD);
        this.dyD.Q(dp2pxf(this.mContext, p)).gM(true).lr(-1).lq(color).gL(true);
        this.dyD.setText(string);
        this.dyD.setVisibility(0);
        this.dyD.setProgress(this.dyE.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aMc() {
        this.dyD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dyE.dyv == SwanAdDownloadState.NOT_START || b.this.dyE.dyv == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.asq().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aMe()).aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dxX);
                }
                if (b.this.dyE.dyv == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.asq().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aMe()).aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dxX);
                }
                if (b.this.dyE.dyv == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.asq().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aMe()).aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dxX);
                }
                if (b.this.dyE.dyv == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.asq().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aMe()).aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dxX);
                }
                if (b.this.dyE.dyv == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dxX.aeJ();
                    com.baidu.swan.apps.t.a.asq().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aMe()).aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dxX);
                }
                if (b.this.dyE.dyv == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String aeK = b.this.dxX.aeK();
                    if (TextUtils.isEmpty(b.this.dyE.name) && !TextUtils.isEmpty(aeK)) {
                        b.this.jM(aeK);
                    }
                    b.this.uQ(b.this.dyE.name);
                }
            }
        });
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aD(View view) {
        if (view != null) {
            float p = p(this.mContext, c.C0493c.swanapp_round_width_size);
            float p2 = p(this.mContext, c.C0493c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.dyE.dyv) {
            this.dyE.dyv = swanAdDownloadState;
            aMd();
        }
    }

    private void setProgress(int i) {
        if (i != this.dyE.percent) {
            this.dyE.percent = i;
            aMd();
        }
    }

    private void aMd() {
        String string;
        if (this.dyE.dyv == SwanAdDownloadState.DOWNLOADING) {
            if (this.dyD != null && this.dyD.getVisibility() != 8) {
                if (this.dyE.percent < this.dyD.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dyE.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dyD.setText(string);
                this.dyD.setProgress(this.dyE.percent);
            }
        } else {
            if (e.al(this.mContext, this.dyE.name)) {
                this.dyE.dyv = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dyE.dyv));
            if (this.dyE.dyv == SwanAdDownloadState.DOWNLOADED) {
                this.dyD.setProgress(100);
            }
            if (this.dyE.dyv == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dyD.setProgress(this.dyE.percent);
            }
            this.dyD.setText(string2);
        }
        if (this.dyD != null) {
            this.dyD.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(String str) {
        ResolveInfo af;
        if (!TextUtils.isEmpty(str) && (af = af(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(af.activityInfo.packageName, af.activityInfo.name));
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

    private ResolveInfo af(Context context, String str) {
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
    public void jM(String str) {
        this.dyE.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dyD;
    }

    public Object aMe() {
        return this.dyD.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dyD.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void adB() {
        aD(this.dyD);
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
        this.dyE = a.cG(aVar.url, aVar.name);
        this.dxX = aVar2;
        aMb();
        aMc();
        return this;
    }
}
