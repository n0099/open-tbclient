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
/* loaded from: classes10.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject bVh;
    private com.baidu.swan.apps.adlanding.b bVm;
    private g bVq;
    private com.baidu.swan.apps.adlanding.download.a.a bVr;
    private com.baidu.swan.apps.adlanding.download.model.a bVs;
    private SwanAdDownloadState bVt;
    private com.baidu.swan.game.ad.e.b dle;
    private RewardWebView dlk;
    private AdElementInfo dll;
    private RelativeLayout dlm;
    private RelativeLayout.LayoutParams dln;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.bVt = SwanAdDownloadState.NOT_START;
        this.dle = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dll = adElementInfo;
        this.dlm = relativeLayout;
        String aJz = adElementInfo.aJz();
        this.dlk = new RewardWebView(getContext());
        this.dlk.setBackgroundColor(-1);
        this.dlk.loadUrl(aJz);
        addView(this.dlk, new RelativeLayout.LayoutParams(-1, -1));
        this.bVh = adElementInfo.aJH();
        this.bVm = new com.baidu.swan.apps.adlanding.b(getContext(), this.bVh);
        initDownload();
        setDownloadListener();
    }

    private void aIT() {
        float p = p(getContext(), c.C0476c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0476c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0476c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dln = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.aqo() != null) {
            aIT();
            this.bVr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void dy(boolean z) {
                    if (InteractiveEndFrameView.this.dlm != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dlm.removeView(InteractiveEndFrameView.this.bVq.getRealView());
                            InteractiveEndFrameView.this.dlm.addView(InteractiveEndFrameView.this.bVq.getRealView(), InteractiveEndFrameView.this.dln);
                            return;
                        }
                        InteractiveEndFrameView.this.dlm.removeView(InteractiveEndFrameView.this.bVq.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void jh(String str) {
                    InteractiveEndFrameView.this.jf(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bVq.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.bVt != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.bVt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bVm.je("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.bVm.je("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.bVt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.bVm.je("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.bVm.je("appdownloadfinish");
                            InteractiveEndFrameView.this.bVm.je("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.bVm.je("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.bVt = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.bVq.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void abX() {
                    InteractiveEndFrameView.this.bVm.je("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String abY() {
                    InteractiveEndFrameView.this.bVm.je("appinstallopen");
                    return InteractiveEndFrameView.this.jg(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dlk.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g aqo = com.baidu.swan.apps.t.a.aqo();
                if (aqo != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dll, InteractiveEndFrameView.this.dle);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String jg = InteractiveEndFrameView.this.jg(str);
                    if (!TextUtils.isEmpty(jg)) {
                        InteractiveEndFrameView.this.mPackageName = jg;
                    }
                    InteractiveEndFrameView.this.bVs = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.bVq = aqo.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bVs, InteractiveEndFrameView.this.bVr);
                    InteractiveEndFrameView.this.bVq.M(InteractiveEndFrameView.this.bVs);
                    InteractiveEndFrameView.this.bVq.aaP();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bVs.name) && InteractiveEndFrameView.this.dlm != null) {
                        InteractiveEndFrameView.this.dlm.removeView(InteractiveEndFrameView.this.bVq.getRealView());
                        InteractiveEndFrameView.this.dlm.addView(InteractiveEndFrameView.this.bVq.getRealView(), InteractiveEndFrameView.this.dln);
                        InteractiveEndFrameView.this.bVq.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.apE().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.bVr);
                }
            }
        });
    }

    public void destroy() {
        if (this.dlk != null) {
            this.dlk.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.bVt) {
            this.bVr = null;
            com.baidu.swan.apps.t.a.apE().a(getContext(), this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bVr);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jg(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
