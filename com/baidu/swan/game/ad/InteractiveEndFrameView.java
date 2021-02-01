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
/* loaded from: classes5.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject cDC;
    private com.baidu.swan.apps.adlanding.b cDH;
    private g cDL;
    private com.baidu.swan.apps.adlanding.download.a.a cDM;
    private com.baidu.swan.apps.adlanding.download.model.a cDN;
    private SwanAdDownloadState cDO;
    private com.baidu.swan.game.ad.e.b dXi;
    private RewardWebView dXo;
    private AdElementInfo dXp;
    private RelativeLayout dXq;
    private RelativeLayout.LayoutParams dXr;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cDO = SwanAdDownloadState.NOT_START;
        this.dXi = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dXp = adElementInfo;
        this.dXq = relativeLayout;
        String aRQ = adElementInfo.aRQ();
        this.dXo = new RewardWebView(getContext());
        this.dXo.setBackgroundColor(-1);
        this.dXo.loadUrl(aRQ);
        addView(this.dXo, new RelativeLayout.LayoutParams(-1, -1));
        this.cDC = adElementInfo.aRX();
        this.cDH = new com.baidu.swan.apps.adlanding.b(getContext(), this.cDC);
        initDownload();
        setDownloadListener();
    }

    private void aRk() {
        float z = z(getContext(), c.C0502c.end_frame_download_btn_width);
        float z2 = z(getContext(), c.C0502c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0502c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (z * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * z2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dXr = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.axQ() != null) {
            aRk();
            this.cDM = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eP(boolean z) {
                    if (InteractiveEndFrameView.this.dXq != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dXq.removeView(InteractiveEndFrameView.this.cDL.getRealView());
                            InteractiveEndFrameView.this.dXq.addView(InteractiveEndFrameView.this.cDL.getRealView(), InteractiveEndFrameView.this.dXr);
                            return;
                        }
                        InteractiveEndFrameView.this.dXq.removeView(InteractiveEndFrameView.this.cDL.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kc(String str) {
                    InteractiveEndFrameView.this.ka(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cDL.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cDO != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cDO == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cDH.jZ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cDH.jZ("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cDO == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cDH.jZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cDH.jZ("appdownloadfinish");
                            InteractiveEndFrameView.this.cDH.jZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cDH.jZ("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cDO = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cDL.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajs() {
                    InteractiveEndFrameView.this.cDH.jZ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String ajt() {
                    InteractiveEndFrameView.this.cDH.jZ("appinstallopen");
                    return InteractiveEndFrameView.this.kb(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dXo.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g axQ = com.baidu.swan.apps.t.a.axQ();
                if (axQ != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dXp, InteractiveEndFrameView.this.dXi);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String kb = InteractiveEndFrameView.this.kb(str);
                    if (!TextUtils.isEmpty(kb)) {
                        InteractiveEndFrameView.this.mPackageName = kb;
                    }
                    InteractiveEndFrameView.this.cDN = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cDL = axQ.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cDN, InteractiveEndFrameView.this.cDM);
                    InteractiveEndFrameView.this.cDL.P(InteractiveEndFrameView.this.cDN);
                    InteractiveEndFrameView.this.cDL.aik();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cDN.name) && InteractiveEndFrameView.this.dXq != null) {
                        InteractiveEndFrameView.this.dXq.removeView(InteractiveEndFrameView.this.cDL.getRealView());
                        InteractiveEndFrameView.this.dXq.addView(InteractiveEndFrameView.this.cDL.getRealView(), InteractiveEndFrameView.this.dXr);
                        InteractiveEndFrameView.this.cDL.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.axg().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cDM);
                }
            }
        });
    }

    public void destroy() {
        if (this.dXo != null) {
            this.dXo.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cDO) {
            this.cDM = null;
            com.baidu.swan.apps.t.a.axg().a(getContext(), this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cDM);
        }
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kb(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
