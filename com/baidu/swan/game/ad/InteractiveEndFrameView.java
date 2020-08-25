package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject bTd;
    private com.baidu.swan.apps.adlanding.b bTi;
    private g bTm;
    private com.baidu.swan.apps.adlanding.download.a.a bTn;
    private com.baidu.swan.apps.adlanding.download.model.a bTo;
    private SwanAdDownloadState bTp;
    private com.baidu.swan.game.ad.e.b diY;
    private RewardWebView dje;
    private AdElementInfo djf;
    private RelativeLayout djg;
    private RelativeLayout.LayoutParams djh;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.bTp = SwanAdDownloadState.NOT_START;
        this.diY = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.djf = adElementInfo;
        this.djg = relativeLayout;
        String aIO = adElementInfo.aIO();
        this.dje = new RewardWebView(getContext());
        this.dje.setBackgroundColor(-1);
        this.dje.loadUrl(aIO);
        addView(this.dje, new RelativeLayout.LayoutParams(-1, -1));
        this.bTd = adElementInfo.aIW();
        this.bTi = new com.baidu.swan.apps.adlanding.b(getContext(), this.bTd);
        initDownload();
        setDownloadListener();
    }

    private void aIi() {
        float p = p(getContext(), c.C0481c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0481c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0481c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.djh = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.apE() != null) {
            aIi();
            this.bTn = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dz(boolean z) {
                    if (InteractiveEndFrameView.this.djg != null) {
                        if (z) {
                            InteractiveEndFrameView.this.djg.removeView(InteractiveEndFrameView.this.bTm.getRealView());
                            InteractiveEndFrameView.this.djg.addView(InteractiveEndFrameView.this.bTm.getRealView(), InteractiveEndFrameView.this.djh);
                            return;
                        }
                        InteractiveEndFrameView.this.djg.removeView(InteractiveEndFrameView.this.bTm.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void iN(String str) {
                    InteractiveEndFrameView.this.iL(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bTm.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.bTp != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.bTp == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bTi.iK("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.bTi.iK("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.bTp == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bTi.iK("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.bTi.iK("appdownloadfinish");
                            InteractiveEndFrameView.this.bTi.iK("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.bTi.iK("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.bTp = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bTm.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abo() {
                    InteractiveEndFrameView.this.bTi.iK("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abp() {
                    InteractiveEndFrameView.this.bTi.iK("appinstallopen");
                    return InteractiveEndFrameView.this.iM(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dje.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g apE = com.baidu.swan.apps.t.a.apE();
                if (apE != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.djf, InteractiveEndFrameView.this.diY);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String iM = InteractiveEndFrameView.this.iM(str);
                    if (!TextUtils.isEmpty(iM)) {
                        InteractiveEndFrameView.this.mPackageName = iM;
                    }
                    InteractiveEndFrameView.this.bTo = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.bTm = apE.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTo, InteractiveEndFrameView.this.bTn);
                    InteractiveEndFrameView.this.bTm.L(InteractiveEndFrameView.this.bTo);
                    InteractiveEndFrameView.this.bTm.aag();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTo.name) && InteractiveEndFrameView.this.djg != null) {
                        InteractiveEndFrameView.this.djg.removeView(InteractiveEndFrameView.this.bTm.getRealView());
                        InteractiveEndFrameView.this.djg.addView(InteractiveEndFrameView.this.bTm.getRealView(), InteractiveEndFrameView.this.djh);
                        InteractiveEndFrameView.this.bTm.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.aoT().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.bTn);
                }
            }
        });
    }

    public void destroy() {
        if (this.dje != null) {
            this.dje.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.bTp) {
            this.bTn = null;
            com.baidu.swan.apps.t.a.aoT().a(getContext(), this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTn);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iM(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
