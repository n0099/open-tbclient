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
    private JSONObject cBc;
    private com.baidu.swan.apps.adlanding.b cBh;
    private g cBl;
    private com.baidu.swan.apps.adlanding.download.a.a cBm;
    private com.baidu.swan.apps.adlanding.download.model.a cBn;
    private SwanAdDownloadState cBo;
    private com.baidu.swan.game.ad.e.b dQP;
    private RewardWebView dQV;
    private AdElementInfo dQW;
    private RelativeLayout dQX;
    private RelativeLayout.LayoutParams dQY;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cBo = SwanAdDownloadState.NOT_START;
        this.dQP = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dQW = adElementInfo;
        this.dQX = relativeLayout;
        String aSZ = adElementInfo.aSZ();
        this.dQV = new RewardWebView(getContext());
        this.dQV.setBackgroundColor(-1);
        this.dQV.loadUrl(aSZ);
        addView(this.dQV, new RelativeLayout.LayoutParams(-1, -1));
        this.cBc = adElementInfo.aTh();
        this.cBh = new com.baidu.swan.apps.adlanding.b(getContext(), this.cBc);
        initDownload();
        setDownloadListener();
    }

    private void aSt() {
        float y = y(getContext(), c.C0529c.end_frame_download_btn_width);
        float y2 = y(getContext(), c.C0529c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0529c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (y * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * y2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dQY = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.azU() != null) {
            aSt();
            this.cBm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eI(boolean z) {
                    if (InteractiveEndFrameView.this.dQX != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dQX.removeView(InteractiveEndFrameView.this.cBl.getRealView());
                            InteractiveEndFrameView.this.dQX.addView(InteractiveEndFrameView.this.cBl.getRealView(), InteractiveEndFrameView.this.dQY);
                            return;
                        }
                        InteractiveEndFrameView.this.dQX.removeView(InteractiveEndFrameView.this.cBl.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void lc(String str) {
                    InteractiveEndFrameView.this.la(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cBl.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cBo != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cBo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cBh.kZ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cBh.kZ("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cBo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cBh.kZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cBh.kZ("appdownloadfinish");
                            InteractiveEndFrameView.this.cBh.kZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cBh.kZ("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cBo = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cBl.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void alD() {
                    InteractiveEndFrameView.this.cBh.kZ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String alE() {
                    InteractiveEndFrameView.this.cBh.kZ("appinstallopen");
                    return InteractiveEndFrameView.this.lb(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dQV.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g azU = com.baidu.swan.apps.t.a.azU();
                if (azU != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dQW, InteractiveEndFrameView.this.dQP);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String lb = InteractiveEndFrameView.this.lb(str);
                    if (!TextUtils.isEmpty(lb)) {
                        InteractiveEndFrameView.this.mPackageName = lb;
                    }
                    InteractiveEndFrameView.this.cBn = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cBl = azU.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBn, InteractiveEndFrameView.this.cBm);
                    InteractiveEndFrameView.this.cBl.P(InteractiveEndFrameView.this.cBn);
                    InteractiveEndFrameView.this.cBl.akv();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBn.name) && InteractiveEndFrameView.this.dQX != null) {
                        InteractiveEndFrameView.this.dQX.removeView(InteractiveEndFrameView.this.cBl.getRealView());
                        InteractiveEndFrameView.this.dQX.addView(InteractiveEndFrameView.this.cBl.getRealView(), InteractiveEndFrameView.this.dQY);
                        InteractiveEndFrameView.this.cBl.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.azk().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cBm);
                }
            }
        });
    }

    public void destroy() {
        if (this.dQV != null) {
            this.dQV.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cBo) {
            this.cBm = null;
            com.baidu.swan.apps.t.a.azk().a(getContext(), this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBm);
        }
    }

    private float y(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lb(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
