package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject cBg;
    private com.baidu.swan.apps.adlanding.b cBl;
    private g cBp;
    private com.baidu.swan.apps.adlanding.download.a.a cBq;
    private com.baidu.swan.apps.adlanding.download.model.a cBr;
    private SwanAdDownloadState cBs;
    private com.baidu.swan.game.ad.e.b dVa;
    private RewardWebView dVg;
    private AdElementInfo dVh;
    private RelativeLayout dVi;
    private RelativeLayout.LayoutParams dVj;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cBs = SwanAdDownloadState.NOT_START;
        this.dVa = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dVh = adElementInfo;
        this.dVi = relativeLayout;
        String aRA = adElementInfo.aRA();
        this.dVg = new RewardWebView(getContext());
        this.dVg.setBackgroundColor(-1);
        this.dVg.loadUrl(aRA);
        addView(this.dVg, new RelativeLayout.LayoutParams(-1, -1));
        this.cBg = adElementInfo.aRI();
        this.cBl = new com.baidu.swan.apps.adlanding.b(getContext(), this.cBg);
        initDownload();
        setDownloadListener();
    }

    private void aQU() {
        float z = z(getContext(), c.C0505c.end_frame_download_btn_width);
        float z2 = z(getContext(), c.C0505c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0505c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (z * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * z2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dVj = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.axs() != null) {
            aQU();
            this.cBq = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eN(boolean z) {
                    if (InteractiveEndFrameView.this.dVi != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dVi.removeView(InteractiveEndFrameView.this.cBp.getRealView());
                            InteractiveEndFrameView.this.dVi.addView(InteractiveEndFrameView.this.cBp.getRealView(), InteractiveEndFrameView.this.dVj);
                            return;
                        }
                        InteractiveEndFrameView.this.dVi.removeView(InteractiveEndFrameView.this.cBp.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jK(String str) {
                    InteractiveEndFrameView.this.jI(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cBp.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cBs != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cBs == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cBl.jH("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cBl.jH("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cBs == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cBl.jH("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cBl.jH("appdownloadfinish");
                            InteractiveEndFrameView.this.cBl.jH("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cBl.jH("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cBs = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cBp.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aiU() {
                    InteractiveEndFrameView.this.cBl.jH("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aiV() {
                    InteractiveEndFrameView.this.cBl.jH("appinstallopen");
                    return InteractiveEndFrameView.this.jJ(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dVg.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g axs = com.baidu.swan.apps.t.a.axs();
                if (axs != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dVh, InteractiveEndFrameView.this.dVa);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String jJ = InteractiveEndFrameView.this.jJ(str);
                    if (!TextUtils.isEmpty(jJ)) {
                        InteractiveEndFrameView.this.mPackageName = jJ;
                    }
                    InteractiveEndFrameView.this.cBr = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cBp = axs.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBr, InteractiveEndFrameView.this.cBq);
                    InteractiveEndFrameView.this.cBp.P(InteractiveEndFrameView.this.cBr);
                    InteractiveEndFrameView.this.cBp.ahM();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBr.name) && InteractiveEndFrameView.this.dVi != null) {
                        InteractiveEndFrameView.this.dVi.removeView(InteractiveEndFrameView.this.cBp.getRealView());
                        InteractiveEndFrameView.this.dVi.addView(InteractiveEndFrameView.this.cBp.getRealView(), InteractiveEndFrameView.this.dVj);
                        InteractiveEndFrameView.this.cBp.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.awI().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cBq);
                }
            }
        });
    }

    public void destroy() {
        if (this.dVg != null) {
            this.dVg.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cBs) {
            this.cBq = null;
            com.baidu.swan.apps.t.a.awI().a(getContext(), this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBq);
        }
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jJ(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
