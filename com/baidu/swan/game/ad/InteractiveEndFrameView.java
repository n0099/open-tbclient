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
    private JSONObject cFc;
    private com.baidu.swan.apps.adlanding.b cFh;
    private g cFl;
    private com.baidu.swan.apps.adlanding.download.a.a cFm;
    private com.baidu.swan.apps.adlanding.download.model.a cFn;
    private SwanAdDownloadState cFo;
    private com.baidu.swan.game.ad.e.b dYJ;
    private RewardWebView dYP;
    private AdElementInfo dYQ;
    private RelativeLayout dYR;
    private RelativeLayout.LayoutParams dYS;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cFo = SwanAdDownloadState.NOT_START;
        this.dYJ = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dYQ = adElementInfo;
        this.dYR = relativeLayout;
        String aRT = adElementInfo.aRT();
        this.dYP = new RewardWebView(getContext());
        this.dYP.setBackgroundColor(-1);
        this.dYP.loadUrl(aRT);
        addView(this.dYP, new RelativeLayout.LayoutParams(-1, -1));
        this.cFc = adElementInfo.aSa();
        this.cFh = new com.baidu.swan.apps.adlanding.b(getContext(), this.cFc);
        initDownload();
        setDownloadListener();
    }

    private void aRn() {
        float z = z(getContext(), c.C0508c.end_frame_download_btn_width);
        float z2 = z(getContext(), c.C0508c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0508c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (z * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * z2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dYS = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.axT() != null) {
            aRn();
            this.cFm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eP(boolean z) {
                    if (InteractiveEndFrameView.this.dYR != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dYR.removeView(InteractiveEndFrameView.this.cFl.getRealView());
                            InteractiveEndFrameView.this.dYR.addView(InteractiveEndFrameView.this.cFl.getRealView(), InteractiveEndFrameView.this.dYS);
                            return;
                        }
                        InteractiveEndFrameView.this.dYR.removeView(InteractiveEndFrameView.this.cFl.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kj(String str) {
                    InteractiveEndFrameView.this.kh(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cFl.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cFo != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cFo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cFh.kg("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cFh.kg("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cFo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cFh.kg("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cFh.kg("appdownloadfinish");
                            InteractiveEndFrameView.this.cFh.kg("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cFh.kg("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cFo = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cFl.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajv() {
                    InteractiveEndFrameView.this.cFh.kg("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String ajw() {
                    InteractiveEndFrameView.this.cFh.kg("appinstallopen");
                    return InteractiveEndFrameView.this.ki(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dYP.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g axT = com.baidu.swan.apps.t.a.axT();
                if (axT != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dYQ, InteractiveEndFrameView.this.dYJ);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String ki = InteractiveEndFrameView.this.ki(str);
                    if (!TextUtils.isEmpty(ki)) {
                        InteractiveEndFrameView.this.mPackageName = ki;
                    }
                    InteractiveEndFrameView.this.cFn = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cFl = axT.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cFn, InteractiveEndFrameView.this.cFm);
                    InteractiveEndFrameView.this.cFl.R(InteractiveEndFrameView.this.cFn);
                    InteractiveEndFrameView.this.cFl.ain();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cFn.name) && InteractiveEndFrameView.this.dYR != null) {
                        InteractiveEndFrameView.this.dYR.removeView(InteractiveEndFrameView.this.cFl.getRealView());
                        InteractiveEndFrameView.this.dYR.addView(InteractiveEndFrameView.this.cFl.getRealView(), InteractiveEndFrameView.this.dYS);
                        InteractiveEndFrameView.this.cFl.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.axj().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cFm);
                }
            }
        });
    }

    public void destroy() {
        if (this.dYP != null) {
            this.dYP.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cFo) {
            this.cFm = null;
            com.baidu.swan.apps.t.a.axj().a(getContext(), this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cFm);
        }
    }

    private float z(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ki(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
