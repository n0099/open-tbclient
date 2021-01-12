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
/* loaded from: classes14.dex */
public class b implements g {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.adlanding.download.a.a dVN;
    private SwanAdDownloadButtonView dWs;
    private a dWt;
    private Context mContext;

    private void aRt() {
        this.dWs = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.awy().getResources().getDisplayMetrics().heightPixels);
        this.dWs.setLayoutParams(layoutParams);
        float z = z(this.mContext, c.C0505c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aT(this.dWs);
        this.dWs.V(dp2pxf(this.mContext, z)).hO(true).kI(-1).kH(color).hN(true);
        this.dWs.setText(string);
        this.dWs.setVisibility(0);
        this.dWs.setProgress(this.dWt.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aRu() {
        this.dWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dWt.dWk == SwanAdDownloadState.NOT_START || b.this.dWt.dWk == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.awI().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRw()).aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dVN);
                }
                if (b.this.dWt.dWk == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.awI().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRw()).aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dVN);
                }
                if (b.this.dWt.dWk == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.awI().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRw()).aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dVN);
                }
                if (b.this.dWt.dWk == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.awI().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRw()).aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dVN);
                }
                if (b.this.dWt.dWk == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dVN.aiU();
                    com.baidu.swan.apps.t.a.awI().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRw()).aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dVN);
                }
                if (b.this.dWt.dWk == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String aiV = b.this.dVN.aiV();
                    if (TextUtils.isEmpty(b.this.dWt.name) && !TextUtils.isEmpty(aiV)) {
                        b.this.jD(aiV);
                    }
                    b.this.uN(b.this.dWt.name);
                }
            }
        });
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    private void aT(View view) {
        if (view != null) {
            float z = z(this.mContext, c.C0505c.swanapp_round_width_size);
            float z2 = z(this.mContext, c.C0505c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.dWt.dWk) {
            this.dWt.dWk = swanAdDownloadState;
            aRv();
        }
    }

    private void setProgress(int i) {
        if (i != this.dWt.percent) {
            this.dWt.percent = i;
            aRv();
        }
    }

    private void aRv() {
        String string;
        if (this.dWt.dWk == SwanAdDownloadState.DOWNLOADING) {
            if (this.dWs != null && this.dWs.getVisibility() != 8) {
                if (this.dWt.percent < this.dWs.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.dWt.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.dWs.setText(string);
                this.dWs.setProgress(this.dWt.percent);
            }
        } else {
            if (e.au(this.mContext, this.dWt.name)) {
                this.dWt.dWk = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.dWt.dWk));
            if (this.dWt.dWk == SwanAdDownloadState.DOWNLOADED) {
                this.dWs.setProgress(100);
            }
            if (this.dWt.dWk == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dWs.setProgress(this.dWt.percent);
            }
            this.dWs.setText(string2);
        }
        if (this.dWs != null) {
            this.dWs.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(String str) {
        ResolveInfo am;
        if (!TextUtils.isEmpty(str) && (am = am(this.mContext, str)) != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(new ComponentName(am.activityInfo.packageName, am.activityInfo.name));
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

    private ResolveInfo am(Context context, String str) {
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
    public void jD(String str) {
        this.dWt.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.dWs;
    }

    public Object aRw() {
        return this.dWs.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void P(Object obj) {
        this.dWs.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ahM() {
        aT(this.dWs);
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
        this.dWt = a.cR(aVar.url, aVar.name);
        this.dVN = aVar2;
        aRt();
        aRu();
        return this;
    }
}
