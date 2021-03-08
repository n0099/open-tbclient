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
    private com.baidu.swan.apps.adlanding.download.a.a dZv;
    private SwanAdDownloadButtonView eaa;
    private a eab;
    private Context mContext;

    private void aRM() {
        this.eaa = new SwanAdDownloadButtonView(this.mContext);
        String string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) (0.04d * com.baidu.swan.apps.t.a.awZ().getResources().getDisplayMetrics().heightPixels);
        this.eaa.setLayoutParams(layoutParams);
        float z = z(this.mContext, c.C0508c.swanapp_round_text_size);
        int color = this.mContext.getResources().getColor(c.b.swanapp_ad_download_button_color);
        aP(this.eaa);
        this.eaa.aa(dp2pxf(this.mContext, z)).hQ(true).kM(-1).kL(color).hP(true);
        this.eaa.setText(string);
        this.eaa.setVisibility(0);
        this.eaa.setProgress(this.eab.percent);
    }

    public static float dp2pxf(@Nullable Context context, float f) {
        DisplayMetrics displayMetrics = AppRuntime.getAppContext().getResources().getDisplayMetrics();
        return (displayMetrics != null ? displayMetrics.density : 0.0f) * f;
    }

    private void aRN() {
        this.eaa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.downloader.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.eab.dZS == SwanAdDownloadState.NOT_START || b.this.eab.dZS == SwanAdDownloadState.DELETED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download start");
                    }
                    com.baidu.swan.apps.t.a.axj().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRP()).ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dZv);
                }
                if (b.this.eab.dZS == SwanAdDownloadState.DOWNLOADING) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download pause");
                    }
                    com.baidu.swan.apps.t.a.axj().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRP()).ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, b.this.dZv);
                }
                if (b.this.eab.dZS == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download resume");
                    }
                    com.baidu.swan.apps.t.a.axj().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRP()).ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dZv);
                }
                if (b.this.eab.dZS == SwanAdDownloadState.DOWNLOAD_FAILED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download retry");
                    }
                    com.baidu.swan.apps.t.a.axj().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRP()).ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, b.this.dZv);
                }
                if (b.this.eab.dZS == SwanAdDownloadState.DOWNLOADED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "download install");
                    }
                    b.this.dZv.ajv();
                    com.baidu.swan.apps.t.a.axj().a(b.this.mContext, ((com.baidu.swan.apps.adlanding.download.model.a) b.this.aRP()).ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, b.this.dZv);
                }
                if (b.this.eab.dZS == SwanAdDownloadState.INSTALLED) {
                    if (b.DEBUG) {
                        Log.d("SwanAppAdDownloadViewImpl", "open app");
                    }
                    String ajw = b.this.dZv.ajw();
                    if (TextUtils.isEmpty(b.this.eab.name) && !TextUtils.isEmpty(ajw)) {
                        b.this.kc(ajw);
                    }
                    b.this.vn(b.this.eab.name);
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
            float z = z(this.mContext, c.C0508c.swanapp_round_width_size);
            float z2 = z(this.mContext, c.C0508c.swanapp_round_height_size);
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
        if (swanAdDownloadState != this.eab.dZS) {
            this.eab.dZS = swanAdDownloadState;
            aRO();
        }
    }

    private void setProgress(int i) {
        if (i != this.eab.percent) {
            this.eab.percent = i;
            aRO();
        }
    }

    private void aRO() {
        String string;
        if (this.eab.dZS == SwanAdDownloadState.DOWNLOADING) {
            if (this.eaa != null && this.eaa.getVisibility() != 8) {
                if (this.eab.percent < this.eaa.getMax()) {
                    string = String.format(this.mContext.getResources().getString(c.g.swanapp_ad_button_downloading), this.eab.percent + "%");
                } else {
                    string = this.mContext.getResources().getString(c.g.swanapp_ad_download_button_install);
                }
                this.eaa.setText(string);
                this.eaa.setProgress(this.eab.percent);
            }
        } else {
            if (e.as(this.mContext, this.eab.name)) {
                this.eab.dZS = SwanAdDownloadState.INSTALLED;
            }
            String string2 = this.mContext.getResources().getString(c(this.eab.dZS));
            if (this.eab.dZS == SwanAdDownloadState.DOWNLOADED) {
                this.eaa.setProgress(100);
            }
            if (this.eab.dZS == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.eaa.setProgress(this.eab.percent);
            }
            this.eaa.setText(string2);
        }
        if (this.eaa != null) {
            this.eaa.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(String str) {
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
    public void kc(String str) {
        this.eab.name = str;
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public View getRealView() {
        return this.eaa;
    }

    public Object aRP() {
        return this.eaa.getTag();
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void R(Object obj) {
        this.eaa.setTag(obj);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void a(SwanAdDownloadState swanAdDownloadState) {
        b(swanAdDownloadState);
    }

    @Override // com.baidu.swan.apps.adaptation.a.g
    public void ain() {
        aP(this.eaa);
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
        this.eab = a.cL(aVar.url, aVar.name);
        this.dZv = aVar2;
        aRM();
        aRN();
        return this;
    }
}
