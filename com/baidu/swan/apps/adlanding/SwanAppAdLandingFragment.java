package com.baidu.swan.apps.adlanding;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.g;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.t;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.t.b.j;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a cBb;
    private JSONObject cBc;
    private b cBh;
    private FrameLayout cBi;
    private g cBl;
    private com.baidu.swan.apps.adlanding.download.a.a cBm;
    private com.baidu.swan.apps.adlanding.download.model.a cBn;
    private RelativeLayout cBp;
    private RelativeLayout cBq;
    private SimpleDraweeView cBr;
    private SimpleDraweeView cBs;
    private TextView cBt;
    private TextView cBu;
    private int cBv;
    private String cBw;
    private String cBx;
    private String cBy;
    private String cBz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cBg = LandingType.NORMAL;
    private String mFrom = "";
    private final String cBj = "swan-custom-ad";
    private final int cBk = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cBo = SwanAdDownloadState.NOT_START;
    private int cBA = 0;
    private int cBB = 0;
    private boolean cBC = true;
    private View.OnClickListener cBD = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cBv == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cBh.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.ch(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cBB;
        swanAppAdLandingFragment.cBB = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum ActionType {
        LP(1),
        DL(2);
        
        private int type;

        ActionType(int i) {
            this.type = i;
        }

        int value() {
            return this.type;
        }
    }

    private void alx() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cBz = jSONObject.optString("w_picurl", "");
                    this.cBy = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cBv = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cBv == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cBw = string;
                    this.cBx = jSONObject.optString("appname", "");
                    this.cBA = jSONObject.optInt("currentTime", 0);
                    this.cBc = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cBg = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        alx();
        FragmentActivity bff = bff();
        if (bff != null) {
            this.cBC = 1 == bff.getRequestedOrientation();
            if (!this.cBC) {
                setRequestedOrientation(1);
            }
        }
        if (DEBUG) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a.g.aiapps_webview_fragment, viewGroup, false);
        at(inflate);
        this.cBi = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        alA();
        B(this.cBi);
        n(this.cBi);
        if (alz()) {
            aly();
            A(this.cBi);
        }
        e(this.cBi);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.cBh = new b(getContext(), this.cBc, this.cBb);
        this.cBh.kZ("lpin");
        return enableSliding(initImmersion, this);
    }

    private void aly() {
        d dVar = new d(this.cBz, this.mVideoUrl, this.cQs.alj(), this.mVideoWidth, this.mVideoHeight, this.cBA);
        this.cBb = new com.baidu.swan.apps.media.b.a(getContext(), dVar.alF());
        this.cBb.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cBq.bringToFront();
                SwanAppAdLandingFragment.this.cBq.setVisibility(0);
                SwanAppAdLandingFragment.this.cBA = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cBh.kZ("vplayend");
                SwanAppAdLandingFragment.this.cBh.kZ("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cBh.kZ("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cBB == 0) {
                    SwanAppAdLandingFragment.this.cBh.kZ("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cBq.setVisibility(8);
                SwanAppAdLandingFragment.this.cBh.kZ("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cBh.kZ("vpause");
            }
        });
        this.cBb.d(dVar.alF());
        this.cBb.fK(false);
    }

    private void A(ViewGroup viewGroup) {
        this.cBp = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cBq = (RelativeLayout) this.cBp.findViewById(a.f.ad_tail_root);
        this.cBr = (SimpleDraweeView) this.cBp.findViewById(a.f.ad_tail_video_img);
        this.cBs = (SimpleDraweeView) this.cBp.findViewById(a.f.ad_tail_head_image);
        this.cBt = (TextView) this.cBp.findViewById(a.f.ad_tail_brand_name);
        this.cBu = (TextView) this.cBp.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cBw)) {
            this.cBu.setText(this.cBw);
            this.cBu.setVisibility(0);
        } else {
            this.cBu.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cBx)) {
            this.cBt.setText(this.cBx);
            this.cBt.setVisibility(0);
        } else {
            this.cBt.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cBy)) {
            this.cBs.setImageURI(Uri.parse(this.cBy));
            this.cBs.setVisibility(0);
        } else {
            this.cBs.setVisibility(8);
        }
        this.cBr.getHierarchy().s(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cBz)) {
            this.cBr.setImageURI(t.getUri(this.cBz));
        }
        this.cBr.setVisibility(0);
        this.cBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cBs.setOnClickListener(this.cBD);
        this.cBt.setOnClickListener(this.cBD);
        this.cBu.setOnClickListener(this.cBD);
        viewGroup.addView(this.cBq, layoutParams);
        this.cBq.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aNr().putString(this.cBn.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lb(String str) {
        return h.aNr().getString(str, "");
    }

    private void B(final ViewGroup viewGroup) {
        g azU = com.baidu.swan.apps.t.a.azU();
        if (azU != null) {
            this.cBm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eI(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cBl.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cBl.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cBl.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void lc(String str) {
                    SwanAppAdLandingFragment.this.la(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cBl.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cBo != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cBo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cBh.kZ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cBh.kZ("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cBo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cBh.kZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cBh.kZ("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cBh.kZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cBh.kZ("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cBo = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cBl.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void alD() {
                    SwanAppAdLandingFragment.this.cBh.kZ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String alE() {
                    SwanAppAdLandingFragment.this.cBh.kZ("appinstallopen");
                    return SwanAppAdLandingFragment.this.lb(SwanAppAdLandingFragment.this.cBn.url);
                }
            };
            this.cBn = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cBl = azU.a(getContext(), this.cBn, this.cBm);
            this.cBl.P(this.cBn);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void n(ViewGroup viewGroup) {
        this.cQs = ala();
        this.cQs.a(alB());
        this.czQ = this.cQs.alh();
        this.cQs.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.czQ.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.sI("#FFFFFF");
        this.cQs.b(frameLayout, cVar);
        this.cQs.a(frameLayout, cVar);
        this.cQs.b(frameLayout, covertToView);
        if (alz()) {
            layoutParams.topMargin = this.mVideoHeight;
        }
        if (TextUtils.equals("swan-custom-ad", this.mFrom)) {
            b(viewGroup, frameLayout);
        } else {
            viewGroup.addView(frameLayout);
        }
        covertToView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean as(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    private void b(final ViewGroup viewGroup, final ViewGroup viewGroup2) {
        final LinearLayout linearLayout = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(a.f.ad_footer);
        final CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        linearLayout2.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.cQs.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.czQ.getContentHeight()) * SwanAppAdLandingFragment.this.czQ.getScale()) - ((float) SwanAppAdLandingFragment.this.czQ.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.czQ.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cQs.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void it(String str) {
                super.it(str);
                if (Math.abs((SwanAppAdLandingFragment.this.czQ.getContentHeight() * SwanAppAdLandingFragment.this.czQ.getScale()) - SwanAppAdLandingFragment.this.czQ.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.as(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean alb() {
        if (isLandScape() && this.cBb != null) {
            return this.cBb.onBackPressed();
        }
        this.cBh.kZ("lpout");
        return super.alb();
    }

    private boolean alz() {
        return this.cBg == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bff().getResources().getConfiguration().orientation == 2;
    }

    private void alA() {
        DisplayMetrics displayMetrics = bff().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        this.cPk.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f ala() {
        e eVar = new e(getContext());
        eVar.alh().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cBl.akv();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cBn.name)) {
                    String lb = SwanAppAdLandingFragment.this.lb(str);
                    SwanAppAdLandingFragment.this.cBn.name = lb;
                    SwanAppAdLandingFragment.this.cBl.kV(lb);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cBn.name)) {
                    SwanAppAdLandingFragment.this.cBi.removeView(SwanAppAdLandingFragment.this.cBl.getRealView());
                    SwanAppAdLandingFragment.this.cBi.addView(SwanAppAdLandingFragment.this.cBl.getRealView());
                    SwanAppAdLandingFragment.this.cBl.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cBn.url)) {
                    SwanAppAdLandingFragment.this.cBn.url = str;
                }
                com.baidu.swan.apps.t.a.azk().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cBm);
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }
        });
        return eVar;
    }

    @Override // com.baidu.swan.apps.core.d.i
    protected com.baidu.swan.apps.core.f.d alB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eH(SwanAppAdLandingFragment.this.czQ.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void jn(final String str) {
                SwanAppAdLandingFragment.this.eH(SwanAppAdLandingFragment.this.czQ.canGoBack());
                SwanAppAdLandingFragment.this.cPk.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cPk.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void at(View view) {
        super.at(view);
        this.cPk.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cPk.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.arP();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean alC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (alz()) {
            this.cBh.kZ("vplayend");
        }
        if (this.cBb != null) {
            this.cBb.onDestroy();
        }
        if (!this.cBC) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
