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
/* loaded from: classes10.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a cpV;
    private JSONObject cpW;
    private b cqb;
    private FrameLayout cqc;
    private g cqf;
    private com.baidu.swan.apps.adlanding.download.a.a cqg;
    private com.baidu.swan.apps.adlanding.download.model.a cqh;
    private RelativeLayout cqj;
    private RelativeLayout cqk;
    private SimpleDraweeView cql;
    private SimpleDraweeView cqm;
    private TextView cqn;
    private TextView cqo;
    private int cqp;
    private String cqq;
    private String cqr;
    private String cqs;
    private String cqt;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cqa = LandingType.NORMAL;
    private String mFrom = "";
    private final String cqd = "swan-custom-ad";
    private final int cqe = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cqi = SwanAdDownloadState.NOT_START;
    private int cqu = 0;
    private int cqv = 0;
    private boolean cqw = true;
    private View.OnClickListener cqx = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cqp == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cqb.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.cb(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cqv;
        swanAppAdLandingFragment.cqv = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

    private void agx() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cqt = jSONObject.optString("w_picurl", "");
                    this.cqs = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cqp = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cqp == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cqq = string;
                    this.cqr = jSONObject.optString("appname", "");
                    this.cqu = jSONObject.optInt("currentTime", 0);
                    this.cpW = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cqa = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        agx();
        FragmentActivity bah = bah();
        if (bah != null) {
            this.cqw = 1 == bah.getRequestedOrientation();
            if (!this.cqw) {
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
        an(inflate);
        this.cqc = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        agA();
        D(this.cqc);
        q(this.cqc);
        if (agz()) {
            agy();
            C(this.cqc);
        }
        b(this.cqc);
        View initImmersion = immersionEnabled() ? initImmersion(inflate) : inflate;
        this.cqb = new b(getContext(), this.cpW, this.cpV);
        this.cqb.kj("lpin");
        return enableSliding(initImmersion, this);
    }

    private void agy() {
        d dVar = new d(this.cqt, this.mVideoUrl, this.cFq.agj(), this.mVideoWidth, this.mVideoHeight, this.cqu);
        this.cpV = new com.baidu.swan.apps.media.b.a(getContext(), dVar.agF());
        this.cpV.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cqk.bringToFront();
                SwanAppAdLandingFragment.this.cqk.setVisibility(0);
                SwanAppAdLandingFragment.this.cqu = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cqb.kj("vplayend");
                SwanAppAdLandingFragment.this.cqb.kj("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cqb.kj("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cqv == 0) {
                    SwanAppAdLandingFragment.this.cqb.kj("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cqk.setVisibility(8);
                SwanAppAdLandingFragment.this.cqb.kj("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cqb.kj("vpause");
            }
        });
        this.cpV.d(dVar.agF());
        this.cpV.fj(false);
    }

    private void C(ViewGroup viewGroup) {
        this.cqj = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cqk = (RelativeLayout) this.cqj.findViewById(a.f.ad_tail_root);
        this.cql = (SimpleDraweeView) this.cqj.findViewById(a.f.ad_tail_video_img);
        this.cqm = (SimpleDraweeView) this.cqj.findViewById(a.f.ad_tail_head_image);
        this.cqn = (TextView) this.cqj.findViewById(a.f.ad_tail_brand_name);
        this.cqo = (TextView) this.cqj.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cqq)) {
            this.cqo.setText(this.cqq);
            this.cqo.setVisibility(0);
        } else {
            this.cqo.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cqr)) {
            this.cqn.setText(this.cqr);
            this.cqn.setVisibility(0);
        } else {
            this.cqn.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cqs)) {
            this.cqm.setImageURI(Uri.parse(this.cqs));
            this.cqm.setVisibility(0);
        } else {
            this.cqm.setVisibility(8);
        }
        this.cql.getHierarchy().r(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cqt)) {
            this.cql.setImageURI(t.getUri(this.cqt));
        }
        this.cql.setVisibility(0);
        this.cql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cqm.setOnClickListener(this.cqx);
        this.cqn.setOnClickListener(this.cqx);
        this.cqo.setOnClickListener(this.cqx);
        viewGroup.addView(this.cqk, layoutParams);
        this.cqk.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aIs().putString(this.cqh.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kl(String str) {
        return h.aIs().getString(str, "");
    }

    private void D(final ViewGroup viewGroup) {
        g auU = com.baidu.swan.apps.t.a.auU();
        if (auU != null) {
            this.cqg = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eh(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cqf.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cqf.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cqf.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void km(String str) {
                    SwanAppAdLandingFragment.this.kk(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cqf.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cqi != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cqi == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cqb.kj("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cqb.kj("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cqi == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cqb.kj("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cqb.kj("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cqb.kj("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cqb.kj("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cqi = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cqf.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void agD() {
                    SwanAppAdLandingFragment.this.cqb.kj("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String agE() {
                    SwanAppAdLandingFragment.this.cqb.kj("appinstallopen");
                    return SwanAppAdLandingFragment.this.kl(SwanAppAdLandingFragment.this.cqh.url);
                }
            };
            this.cqh = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cqf = auU.a(getContext(), this.cqh, this.cqg);
            this.cqf.P(this.cqh);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void q(ViewGroup viewGroup) {
        this.cFq = aga();
        this.cFq.a(agB());
        this.coJ = this.cFq.agh();
        this.cFq.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.coJ.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.fv("#FFFFFF");
        this.cFq.b(frameLayout, cVar);
        this.cFq.a(frameLayout, cVar);
        this.cFq.a(frameLayout, covertToView);
        if (agz()) {
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
    public boolean am(View view) {
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
        this.cFq.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.coJ.getContentHeight()) * SwanAppAdLandingFragment.this.coJ.getScale()) - ((float) SwanAppAdLandingFragment.this.coJ.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.coJ.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cFq.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void hO(String str) {
                super.hO(str);
                if (Math.abs((SwanAppAdLandingFragment.this.coJ.getContentHeight() * SwanAppAdLandingFragment.this.coJ.getScale()) - SwanAppAdLandingFragment.this.coJ.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.am(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean agb() {
        if (isLandScape() && this.cpV != null) {
            return this.cpV.onBackPressed();
        }
        this.cqb.kj("lpout");
        return super.agb();
    }

    private boolean agz() {
        return this.cqa == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bah().getResources().getConfiguration().orientation == 2;
    }

    private void agA() {
        DisplayMetrics displayMetrics = bah().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(boolean z) {
        this.cEi.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aga() {
        e eVar = new e(getContext());
        eVar.agh().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cqf.afv();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cqh.name)) {
                    String kl = SwanAppAdLandingFragment.this.kl(str);
                    SwanAppAdLandingFragment.this.cqh.name = kl;
                    SwanAppAdLandingFragment.this.cqf.kf(kl);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cqh.name)) {
                    SwanAppAdLandingFragment.this.cqc.removeView(SwanAppAdLandingFragment.this.cqf.getRealView());
                    SwanAppAdLandingFragment.this.cqc.addView(SwanAppAdLandingFragment.this.cqf.getRealView());
                    SwanAppAdLandingFragment.this.cqf.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cqh.url)) {
                    SwanAppAdLandingFragment.this.cqh.url = str;
                }
                com.baidu.swan.apps.t.a.auk().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cqg);
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
    protected com.baidu.swan.apps.core.f.d agB() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eg(SwanAppAdLandingFragment.this.coJ.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iC(final String str) {
                SwanAppAdLandingFragment.this.eg(SwanAppAdLandingFragment.this.coJ.canGoBack());
                SwanAppAdLandingFragment.this.cEi.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cEi.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void an(View view) {
        super.an(view);
        this.cEi.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cEi.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.amP();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean agC() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (agz()) {
            this.cqb.kj("vplayend");
        }
        if (this.cpV != null) {
            this.cpV.onDestroy();
        }
        if (!this.cqw) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
