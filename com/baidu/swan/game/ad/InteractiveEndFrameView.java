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
/* loaded from: classes3.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject cFS;
    private com.baidu.swan.apps.adlanding.b cFX;
    private g cGb;
    private com.baidu.swan.apps.adlanding.download.a.a cGc;
    private com.baidu.swan.apps.adlanding.download.model.a cGd;
    private SwanAdDownloadState cGe;
    private com.baidu.swan.game.ad.e.b dZM;
    private RewardWebView dZS;
    private AdElementInfo dZT;
    private RelativeLayout dZU;
    private RelativeLayout.LayoutParams dZV;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cGe = SwanAdDownloadState.NOT_START;
        this.dZM = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dZT = adElementInfo;
        this.dZU = relativeLayout;
        String aVu = adElementInfo.aVu();
        this.dZS = new RewardWebView(getContext());
        this.dZS.setBackgroundColor(-1);
        this.dZS.loadUrl(aVu);
        addView(this.dZS, new RelativeLayout.LayoutParams(-1, -1));
        this.cFS = adElementInfo.aVC();
        this.cFX = new com.baidu.swan.apps.adlanding.b(getContext(), this.cFS);
        initDownload();
        setDownloadListener();
    }

    private void aUO() {
        float z = z(getContext(), c.C0522c.end_frame_download_btn_width);
        float z2 = z(getContext(), c.C0522c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0522c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (z * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * z2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dZV = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.aBm() != null) {
            aUO();
            this.cGc = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eR(boolean z) {
                    if (InteractiveEndFrameView.this.dZU != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dZU.removeView(InteractiveEndFrameView.this.cGb.getRealView());
                            InteractiveEndFrameView.this.dZU.addView(InteractiveEndFrameView.this.cGb.getRealView(), InteractiveEndFrameView.this.dZV);
                            return;
                        }
                        InteractiveEndFrameView.this.dZU.removeView(InteractiveEndFrameView.this.cGb.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kV(String str) {
                    InteractiveEndFrameView.this.kT(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cGb.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cGe != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cGe == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cFX.kS("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cFX.kS("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cGe == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cFX.kS("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cFX.kS("appdownloadfinish");
                            InteractiveEndFrameView.this.cFX.kS("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cFX.kS("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cGe = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cGb.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void amO() {
                    InteractiveEndFrameView.this.cFX.kS("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String amP() {
                    InteractiveEndFrameView.this.cFX.kS("appinstallopen");
                    return InteractiveEndFrameView.this.kU(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dZS.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g aBm = com.baidu.swan.apps.t.a.aBm();
                if (aBm != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dZT, InteractiveEndFrameView.this.dZM);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String kU = InteractiveEndFrameView.this.kU(str);
                    if (!TextUtils.isEmpty(kU)) {
                        InteractiveEndFrameView.this.mPackageName = kU;
                    }
                    InteractiveEndFrameView.this.cGd = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cGb = aBm.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cGd, InteractiveEndFrameView.this.cGc);
                    InteractiveEndFrameView.this.cGb.P(InteractiveEndFrameView.this.cGd);
                    InteractiveEndFrameView.this.cGb.alG();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cGd.name) && InteractiveEndFrameView.this.dZU != null) {
                        InteractiveEndFrameView.this.dZU.removeView(InteractiveEndFrameView.this.cGb.getRealView());
                        InteractiveEndFrameView.this.dZU.addView(InteractiveEndFrameView.this.cGb.getRealView(), InteractiveEndFrameView.this.dZV);
                        InteractiveEndFrameView.this.cGb.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.aAC().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cGc);
                }
            }
        });
    }

    public void destroy() {
        if (this.dZS != null) {
            this.dZS.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cGe) {
            this.cGc = null;
            com.baidu.swan.apps.t.a.aAC().a(getContext(), this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cGc);
        }
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kU(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
