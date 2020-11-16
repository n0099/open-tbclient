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
/* loaded from: classes12.dex */
public class InteractiveEndFrameView extends RelativeLayout {
    private JSONObject cui;
    private com.baidu.swan.apps.adlanding.b cun;
    private g cus;
    private com.baidu.swan.apps.adlanding.download.a.a cuu;
    private com.baidu.swan.apps.adlanding.download.model.a cuv;
    private SwanAdDownloadState cuw;
    private com.baidu.swan.game.ad.e.b dJR;
    private RewardWebView dJX;
    private AdElementInfo dJY;
    private RelativeLayout dJZ;
    private RelativeLayout.LayoutParams dKa;
    private String mDownloadUrl;
    private String mPackageName;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mPackageName = "";
        this.cuw = SwanAdDownloadState.NOT_START;
        this.dJR = new com.baidu.swan.game.ad.e.b(context);
    }

    public void a(AdElementInfo adElementInfo, RelativeLayout relativeLayout) {
        this.dJY = adElementInfo;
        this.dJZ = relativeLayout;
        String aPU = adElementInfo.aPU();
        this.dJX = new RewardWebView(getContext());
        this.dJX.setBackgroundColor(-1);
        this.dJX.loadUrl(aPU);
        addView(this.dJX, new RelativeLayout.LayoutParams(-1, -1));
        this.cui = adElementInfo.aQc();
        this.cun = new com.baidu.swan.apps.adlanding.b(getContext(), this.cui);
        initDownload();
        setDownloadListener();
    }

    private void aPo() {
        float p = p(getContext(), c.C0517c.end_frame_download_btn_width);
        float p2 = p(getContext(), c.C0517c.end_frame_download_btn_height);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0517c.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (p * getContext().getResources().getDisplayMetrics().widthPixels), (int) (getContext().getResources().getDisplayMetrics().heightPixels * p2));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = dimensionPixelSize;
        layoutParams.addRule(14);
        this.dKa = layoutParams;
    }

    public void initDownload() {
        if (com.baidu.swan.apps.t.a.awM() != null) {
            aPo();
            this.cuu = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.1
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void et(boolean z) {
                    if (InteractiveEndFrameView.this.dJZ != null) {
                        if (z) {
                            InteractiveEndFrameView.this.dJZ.removeView(InteractiveEndFrameView.this.cus.getRealView());
                            InteractiveEndFrameView.this.dJZ.addView(InteractiveEndFrameView.this.cus.getRealView(), InteractiveEndFrameView.this.dKa);
                            return;
                        }
                        InteractiveEndFrameView.this.dJZ.removeView(InteractiveEndFrameView.this.cus.getRealView());
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kv(String str) {
                    InteractiveEndFrameView.this.kt(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cus.a(swanAdDownloadState);
                    if (InteractiveEndFrameView.this.cuw != swanAdDownloadState) {
                        if (InteractiveEndFrameView.this.cuw == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cun.ks("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            InteractiveEndFrameView.this.cun.ks("appdownloadpause");
                        } else if (InteractiveEndFrameView.this.cuw == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            InteractiveEndFrameView.this.cun.ks("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            InteractiveEndFrameView.this.cun.ks("appdownloadfinish");
                            InteractiveEndFrameView.this.cun.ks("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            InteractiveEndFrameView.this.cun.ks("appinstallfinish");
                        }
                        InteractiveEndFrameView.this.cuw = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    InteractiveEndFrameView.this.cus.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void aiv() {
                    InteractiveEndFrameView.this.cun.ks("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String aiw() {
                    InteractiveEndFrameView.this.cun.ks("appinstallopen");
                    return InteractiveEndFrameView.this.ku(InteractiveEndFrameView.this.mDownloadUrl);
                }
            };
        }
    }

    public void setDownloadListener() {
        this.dJX.setDownloadListener(new DownloadListener() { // from class: com.baidu.swan.game.ad.InteractiveEndFrameView.2
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                g awM = com.baidu.swan.apps.t.a.awM();
                if (awM != null) {
                    com.baidu.swan.game.ad.c.c.c(InteractiveEndFrameView.this.dJY, InteractiveEndFrameView.this.dJR);
                    InteractiveEndFrameView.this.mDownloadUrl = str;
                    String ku = InteractiveEndFrameView.this.ku(str);
                    if (!TextUtils.isEmpty(ku)) {
                        InteractiveEndFrameView.this.mPackageName = ku;
                    }
                    InteractiveEndFrameView.this.cuv = new com.baidu.swan.apps.adlanding.download.model.a(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                    InteractiveEndFrameView.this.cus = awM.a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cuv, InteractiveEndFrameView.this.cuu);
                    InteractiveEndFrameView.this.cus.P(InteractiveEndFrameView.this.cuv);
                    InteractiveEndFrameView.this.cus.ahn();
                    if (ak.isAppInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cuv.name) && InteractiveEndFrameView.this.dJZ != null) {
                        InteractiveEndFrameView.this.dJZ.removeView(InteractiveEndFrameView.this.cus.getRealView());
                        InteractiveEndFrameView.this.dJZ.addView(InteractiveEndFrameView.this.cus.getRealView(), InteractiveEndFrameView.this.dKa);
                        InteractiveEndFrameView.this.cus.a(SwanAdDownloadState.INSTALLED);
                        return;
                    }
                    com.baidu.swan.apps.t.a.awc().a(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.cuu);
                }
            }
        });
    }

    public void destroy() {
        if (this.dJX != null) {
            this.dJX.destroy();
        }
        if (SwanAdDownloadState.DOWNLOADING == this.cuw) {
            this.cuu = null;
            com.baidu.swan.apps.t.a.awc().a(getContext(), this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cuu);
        }
    }

    private float p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return typedValue.getFloat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kt(String str) {
        if (!TextUtils.isEmpty(str)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor edit = context.getSharedPreferences("swan_game_video_ad_storage", 0).edit();
            edit.putString(this.mDownloadUrl, str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ku(String str) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences("swan_game_video_ad_storage", 0).getString(str, "");
    }
}
