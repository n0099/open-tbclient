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
    private JSONObject bTh;
    private com.baidu.swan.apps.adlanding.b bTm;
    private g bTq;
    private com.baidu.swan.apps.adlanding.download.a.a bTr;
    private com.baidu.swan.apps.adlanding.download.model.a bTs;
    private SwanAdDownloadState bTt;
    private com.baidu.swan.game.ad.e.b djc;
    private RewardWebView dji;
    private AdElementInfo djj;
    private RelativeLayout djk;
    private RelativeLayout.LayoutParams djl;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.bTt = SwanAdDownloadState.NOT_START;
        this.djc = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.djj = adElementInfo;
        this.djk = relativeLayout;
        String aIO = adElementInfo.aIO();
        this.dji = new RewardWebView(getContext());
        this.dji.setBackgroundColor(-1);
        this.dji.loadUrl(aIO);
        addView(this.dji, new RelativeLayout.LayoutParams(-1, -1));
        this.bTh = adElementInfo.aIW();
        this.bTm = new com.baidu.swan.apps.adlanding.b(getContext(), this.bTh);
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
        this.djl = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.apE() != null) {
            aIi();
            this.bTr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dA(boolean z) {
                    if (InteractiveEndFrameView.this.djk != null) {
                        if (z) {
                            InteractiveEndFrameView.this.djk.removeView(InteractiveEndFrameView.this.bTq.getRealView());
                            InteractiveEndFrameView.this.djk.addView(InteractiveEndFrameView.this.bTq.getRealView(), InteractiveEndFrameView.this.djl);
                            return;
                        }
                        InteractiveEndFrameView.this.djk.removeView(InteractiveEndFrameView.this.bTq.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void iO(String str) {
                    InteractiveEndFrameView.this.iM(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bTq.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.bTt != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.bTt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bTm.iL("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.bTm.iL("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.bTt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bTm.iL("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.bTm.iL("appdownloadfinish");
                            InteractiveEndFrameView.this.bTm.iL("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.bTm.iL("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.bTt = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bTq.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abo() {
                    InteractiveEndFrameView.this.bTm.iL("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abp() {
                    InteractiveEndFrameView.this.bTm.iL("appinstallopen");
                    return InteractiveEndFrameView.this.iN(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dji.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g apE = com.baidu.swan.apps.t.a.apE();
                if (apE != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.djj, InteractiveEndFrameView.this.djc);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String iN = InteractiveEndFrameView.this.iN(str);
                    if (!TextUtils.isEmpty(iN)) {
                        InteractiveEndFrameView.this.mPackageName = iN;
                    }
                    InteractiveEndFrameView.this.bTs = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.bTq = apE.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTs, InteractiveEndFrameView.this.bTr);
                    InteractiveEndFrameView.this.bTq.L(InteractiveEndFrameView.this.bTs);
                    InteractiveEndFrameView.this.bTq.aag();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTs.name) && InteractiveEndFrameView.this.djk != null) {
                        InteractiveEndFrameView.this.djk.removeView(InteractiveEndFrameView.this.bTq.getRealView());
                        InteractiveEndFrameView.this.djk.addView(InteractiveEndFrameView.this.bTq.getRealView(), InteractiveEndFrameView.this.djl);
                        InteractiveEndFrameView.this.bTq.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.aoT().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.bTr);
                }
            }
        });
    }

    public void destroy() {
        if (this.dji != null) {
            this.dji.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.bTt) {
            this.bTr = null;
            com.baidu.swan.apps.t.a.aoT().a(getContext(), this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTr);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iN(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
