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
/* loaded from: classes14.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject cpW;
    private com.baidu.swan.apps.adlanding.b cqb;
    private g cqf;
    private com.baidu.swan.apps.adlanding.download.a.a cqg;
    private com.baidu.swan.apps.adlanding.download.model.a cqh;
    private SwanAdDownloadState cqi;
    private com.baidu.swan.game.ad.e.b dFH;
    private RewardWebView dFN;
    private AdElementInfo dFO;
    private RelativeLayout dFP;
    private RelativeLayout.LayoutParams dFQ;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cqi = SwanAdDownloadState.NOT_START;
        this.dFH = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dFO = adElementInfo;
        this.dFP = relativeLayout;
        String aOc = adElementInfo.aOc();
        this.dFN = new RewardWebView(getContext());
        this.dFN.setBackgroundColor(-1);
        this.dFN.loadUrl(aOc);
        addView(this.dFN, new RelativeLayout.LayoutParams(-1, -1));
        this.cpW = adElementInfo.aOk();
        this.cqb = new com.baidu.swan.apps.adlanding.b(getContext(), this.cpW);
        initDownload();
        setDownloadListener();
    }

    private void aNw() {
        float p = p(getContext(), c.C0507c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0507c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0507c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dFQ = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.auU() != null) {
            aNw();
            this.cqg = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eh(boolean z) {
                    if (InteractiveEndFrameView.this.dFP != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dFP.removeView(InteractiveEndFrameView.this.cqf.getRealView());
                            InteractiveEndFrameView.this.dFP.addView(InteractiveEndFrameView.this.cqf.getRealView(), InteractiveEndFrameView.this.dFQ);
                            return;
                        }
                        InteractiveEndFrameView.this.dFP.removeView(InteractiveEndFrameView.this.cqf.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void km(String str) {
                    InteractiveEndFrameView.this.kk(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cqf.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cqi != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cqi == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cqb.kj("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cqb.kj("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cqi == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cqb.kj("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cqb.kj("appdownloadfinish");
                            InteractiveEndFrameView.this.cqb.kj("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cqb.kj("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cqi = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cqf.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void agD() {
                    InteractiveEndFrameView.this.cqb.kj("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String agE() {
                    InteractiveEndFrameView.this.cqb.kj("appinstallopen");
                    return InteractiveEndFrameView.this.kl(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dFN.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g auU = com.baidu.swan.apps.t.a.auU();
                if (auU != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dFO, InteractiveEndFrameView.this.dFH);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String kl = InteractiveEndFrameView.this.kl(str);
                    if (!TextUtils.isEmpty(kl)) {
                        InteractiveEndFrameView.this.mPackageName = kl;
                    }
                    InteractiveEndFrameView.this.cqh = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cqf = auU.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cqh, InteractiveEndFrameView.this.cqg);
                    InteractiveEndFrameView.this.cqf.P(InteractiveEndFrameView.this.cqh);
                    InteractiveEndFrameView.this.cqf.afv();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cqh.name) && InteractiveEndFrameView.this.dFP != null) {
                        InteractiveEndFrameView.this.dFP.removeView(InteractiveEndFrameView.this.cqf.getRealView());
                        InteractiveEndFrameView.this.dFP.addView(InteractiveEndFrameView.this.cqf.getRealView(), InteractiveEndFrameView.this.dFQ);
                        InteractiveEndFrameView.this.cqf.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.auk().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cqg);
                }
            }
        });
    }

    public void destroy() {
        if (this.dFN != null) {
            this.dFN.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cqi) {
            this.cqg = null;
            com.baidu.swan.apps.t.a.auk().a(getContext(), this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cqg);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kl(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
