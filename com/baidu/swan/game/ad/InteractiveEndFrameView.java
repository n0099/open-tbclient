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
    private com.baidu.swan.apps.adlanding.b chA;
    private g chE;
    private com.baidu.swan.apps.adlanding.download.a.a chF;
    private com.baidu.swan.apps.adlanding.download.model.a chG;
    private SwanAdDownloadState chH;
    private JSONObject chv;
    private com.baidu.swan.game.ad.e.b dxk;
    private RewardWebView dxq;
    private AdElementInfo dxr;
    private RelativeLayout dxs;
    private RelativeLayout.LayoutParams dxt;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.chH = SwanAdDownloadState.NOT_START;
        this.dxk = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dxr = adElementInfo;
        this.dxs = relativeLayout;
        String aMi = adElementInfo.aMi();
        this.dxq = new RewardWebView(getContext());
        this.dxq.setBackgroundColor(-1);
        this.dxq.loadUrl(aMi);
        addView(this.dxq, new RelativeLayout.LayoutParams(-1, -1));
        this.chv = adElementInfo.aMq();
        this.chA = new com.baidu.swan.apps.adlanding.b(getContext(), this.chv);
        initDownload();
        setDownloadListener();
    }

    private void aLC() {
        float p = p(getContext(), c.C0493c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0493c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0493c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dxt = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.ata() != null) {
            aLC();
            this.chF = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dU(boolean z) {
                    if (InteractiveEndFrameView.this.dxs != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dxs.removeView(InteractiveEndFrameView.this.chE.getRealView());
                            InteractiveEndFrameView.this.dxs.addView(InteractiveEndFrameView.this.chE.getRealView(), InteractiveEndFrameView.this.dxt);
                            return;
                        }
                        InteractiveEndFrameView.this.dxs.removeView(InteractiveEndFrameView.this.chE.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jT(String str) {
                    InteractiveEndFrameView.this.jR(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.chE.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.chH != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.chH == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.chA.jQ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.chA.jQ("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.chH == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.chA.jQ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.chA.jQ("appdownloadfinish");
                            InteractiveEndFrameView.this.chA.jQ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.chA.jQ("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.chH = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.chE.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aeJ() {
                    InteractiveEndFrameView.this.chA.jQ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aeK() {
                    InteractiveEndFrameView.this.chA.jQ("appinstallopen");
                    return InteractiveEndFrameView.this.jS(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dxq.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g ata = com.baidu.swan.apps.t.a.ata();
                if (ata != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dxr, InteractiveEndFrameView.this.dxk);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String jS = InteractiveEndFrameView.this.jS(str);
                    if (!TextUtils.isEmpty(jS)) {
                        InteractiveEndFrameView.this.mPackageName = jS;
                    }
                    InteractiveEndFrameView.this.chG = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.chE = ata.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.chG, InteractiveEndFrameView.this.chF);
                    InteractiveEndFrameView.this.chE.P(InteractiveEndFrameView.this.chG);
                    InteractiveEndFrameView.this.chE.adB();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.chG.name) && InteractiveEndFrameView.this.dxs != null) {
                        InteractiveEndFrameView.this.dxs.removeView(InteractiveEndFrameView.this.chE.getRealView());
                        InteractiveEndFrameView.this.dxs.addView(InteractiveEndFrameView.this.chE.getRealView(), InteractiveEndFrameView.this.dxt);
                        InteractiveEndFrameView.this.chE.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.asq().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.chF);
                }
            }
        });
    }

    public void destroy() {
        if (this.dxq != null) {
            this.dxq.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.chH) {
            this.chF = null;
            com.baidu.swan.apps.t.a.asq().a(getContext(), this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.chF);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jS(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
