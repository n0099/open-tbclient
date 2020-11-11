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
    private JSONObject cvU;
    private com.baidu.swan.apps.adlanding.b cvZ;
    private g cwd;
    private com.baidu.swan.apps.adlanding.download.a.a cwe;
    private com.baidu.swan.apps.adlanding.download.model.a cwf;
    private SwanAdDownloadState cwg;
    private RewardWebView dLF;
    private AdElementInfo dLG;
    private RelativeLayout dLH;
    private RelativeLayout.LayoutParams dLI;
    private com.baidu.swan.game.ad.e.b dLz;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cwg = SwanAdDownloadState.NOT_START;
        this.dLz = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dLG = adElementInfo;
        this.dLH = relativeLayout;
        String aQC = adElementInfo.aQC();
        this.dLF = new RewardWebView(getContext());
        this.dLF.setBackgroundColor(-1);
        this.dLF.loadUrl(aQC);
        addView(this.dLF, new RelativeLayout.LayoutParams(-1, -1));
        this.cvU = adElementInfo.aQK();
        this.cvZ = new com.baidu.swan.apps.adlanding.b(getContext(), this.cvU);
        initDownload();
        setDownloadListener();
    }

    private void aPW() {
        float p = p(getContext(), c.C0519c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0519c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0519c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dLI = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.axu() != null) {
            aPW();
            this.cwe = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eq(boolean z) {
                    if (InteractiveEndFrameView.this.dLH != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dLH.removeView(InteractiveEndFrameView.this.cwd.getRealView());
                            InteractiveEndFrameView.this.dLH.addView(InteractiveEndFrameView.this.cwd.getRealView(), InteractiveEndFrameView.this.dLI);
                            return;
                        }
                        InteractiveEndFrameView.this.dLH.removeView(InteractiveEndFrameView.this.cwd.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kB(String str) {
                    InteractiveEndFrameView.this.kz(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cwd.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cwg != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cwg == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cvZ.ky("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cvZ.ky("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cwg == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cvZ.ky("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cvZ.ky("appdownloadfinish");
                            InteractiveEndFrameView.this.cvZ.ky("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cvZ.ky("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cwg = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cwd.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajd() {
                    InteractiveEndFrameView.this.cvZ.ky("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aje() {
                    InteractiveEndFrameView.this.cvZ.ky("appinstallopen");
                    return InteractiveEndFrameView.this.kA(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dLF.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g axu = com.baidu.swan.apps.t.a.axu();
                if (axu != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dLG, InteractiveEndFrameView.this.dLz);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String kA = InteractiveEndFrameView.this.kA(str);
                    if (!TextUtils.isEmpty(kA)) {
                        InteractiveEndFrameView.this.mPackageName = kA;
                    }
                    InteractiveEndFrameView.this.cwf = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cwd = axu.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cwf, InteractiveEndFrameView.this.cwe);
                    InteractiveEndFrameView.this.cwd.P(InteractiveEndFrameView.this.cwf);
                    InteractiveEndFrameView.this.cwd.ahV();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cwf.name) && InteractiveEndFrameView.this.dLH != null) {
                        InteractiveEndFrameView.this.dLH.removeView(InteractiveEndFrameView.this.cwd.getRealView());
                        InteractiveEndFrameView.this.dLH.addView(InteractiveEndFrameView.this.cwd.getRealView(), InteractiveEndFrameView.this.dLI);
                        InteractiveEndFrameView.this.cwd.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.awK().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cwe);
                }
            }
        });
    }

    public void destroy() {
        if (this.dLF != null) {
            this.dLF.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cwg) {
            this.cwe = null;
            com.baidu.swan.apps.t.a.awK().a(getContext(), this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cwe);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kA(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
