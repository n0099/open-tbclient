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
/* loaded from: classes19.dex */
public class b implements g {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.adlanding.download.a.a djP;
    private SwanAdDownloadButtonView dkv;
    private a dkw;
    private Context mContext;

    private void aIH() {
        this.dkv = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.aoJ().getResources().getDisplayMetrics().heightPixels);
        this.dkv.setLayoutParams(layoutParams);
        float p = p(this.mContext, c.C0481c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aA(this.dkv);
        this.dkv.O(dp2pxf(this.mContext, p)).gs(true).kJ(-1).kI(color).gr(true);
        this.dkv.setText(string);
        this.dkv.setVisibility(0);
        this.dkv.setProgress(this.dkw.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aII() {
        this.dkv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dkw.dkn == SwanAdDownloadState.NOT_START || b.this.dkw.dkn == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.aoT().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aIK()).abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.djP);
                }
                if (b.this.dkw.dkn == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.aoT().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aIK()).abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.djP);
                }
                if (b.this.dkw.dkn == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.aoT().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aIK()).abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.djP);
                }
                if (b.this.dkw.dkn == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.aoT().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aIK()).abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.djP);
                }
                if (b.this.dkw.dkn == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.djP.abo();
                    com.baidu.swan.apps.t.a.aoT().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aIK()).abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.djP);
                }
                if (b.this.dkw.dkn == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String abp = b.this.djP.abp();
                    if (TextUtils.isEmpty(b.this.dkw.name) && !TextUtils.isEmpty(abp)) {
                        b.this.iH(abp);
                    }
                    b.this.tL(b.this.dkw.name);
                }
            }
        });
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aA(View view) {
        if (view != null) {
            float p = p(this.mContext, c.C0481c.swanapp_round_width_size);
            float p2 = p(this.mContext, c.C0481c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.dkw.dkn) {
            this.dkw.dkn = swanAdDownloadState;
            aIJ();
        }
    }

    private void setProgress(int i) {
        if (i != this.dkw.percent) {
            this.dkw.percent = i;
            aIJ();
        }
    }

    private void aIJ() {
        String string;
        if (this.dkw.dkn == SwanAdDownloadState.DOWNLOADING) {
            if (this.dkv != null && this.dkv.getVisibility() != 8) {
                if (this.dkw.percent < this.dkv.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dkw.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dkv.setText(string);
                this.dkv.setProgress(this.dkw.percent);
            }
        } else {
            if (e.af(this.mContext, this.dkw.name)) {
                this.dkw.dkn = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dkw.dkn));
            if (this.dkw.dkn == SwanAdDownloadState.DOWNLOADED) {
                this.dkv.setProgress(100);
            }
            if (this.dkw.dkn == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dkv.setProgress(this.dkw.percent);
            }
            this.dkv.setText(string2);
        }
        if (this.dkv != null) {
            this.dkv.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(String str) {
        ResolveInfo Z;
        if (!TextUtils.isEmpty(str) && (Z = Z(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(Z.activityInfo.packageName, Z.activityInfo.name));
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

    private ResolveInfo Z(Context context, String str) {
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
    public void iH(String str) {
        this.dkw.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dkv;
    }

    public Object aIK() {
        return this.dkv.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void L(Object obj) {
        this.dkv.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void aag() {
        aA(this.dkv);
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
        this.dkw = a.cB(aVar.url, aVar.name);
        this.djP = aVar2;
        aIH();
        aII();
        return this;
    }
}
