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
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.t;
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
/* loaded from: classes9.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a cDB;
    private JSONObject cDC;
    private b cDH;
    private FrameLayout cDI;
    private g cDL;
    private com.baidu.swan.apps.adlanding.download.a.a cDM;
    private com.baidu.swan.apps.adlanding.download.model.a cDN;
    private RelativeLayout cDP;
    private RelativeLayout cDQ;
    private SimpleDraweeView cDR;
    private SimpleDraweeView cDS;
    private TextView cDT;
    private TextView cDU;
    private int cDV;
    private String cDW;
    private String cDX;
    private String cDY;
    private String cDZ;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cDG = LandingType.NORMAL;
    private String mFrom = "";
    private final String cDJ = "swan-custom-ad";
    private final int cDK = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cDO = SwanAdDownloadState.NOT_START;
    private int cEa = 0;
    private int cEb = 0;
    private boolean cEc = true;
    private View.OnClickListener cEd = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cDV == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cDH.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bZ(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cEb;
        swanAppAdLandingFragment.cEb = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
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

    private void ajm() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cDZ = jSONObject.optString("w_picurl", "");
                    this.cDY = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cDV = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cDV == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cDW = string;
                    this.cDX = jSONObject.optString("appname", "");
                    this.cEa = jSONObject.optInt("currentTime", 0);
                    this.cDC = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cDG = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ajm();
        FragmentActivity bdU = bdU();
        if (bdU != null) {
            this.cEc = 1 == bdU.getRequestedOrientation();
            if (!this.cEc) {
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
        aq(inflate);
        this.cDI = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        ajp();
        C(this.cDI);
        x(this.cDI);
        if (ajo()) {
            ajn();
            B(this.cDI);
        }
        e(this.cDI);
        View av = aoI() ? av(inflate) : inflate;
        this.cDH = new b(getContext(), this.cDC, this.cDB);
        this.cDH.jZ("lpin");
        return a(av, this);
    }

    private void ajn() {
        d dVar = new d(this.cDZ, this.mVideoUrl, this.cSQ.aiY(), this.mVideoWidth, this.mVideoHeight, this.cEa);
        this.cDB = new com.baidu.swan.apps.media.b.a(getContext(), dVar.aju());
        this.cDB.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cDQ.bringToFront();
                SwanAppAdLandingFragment.this.cDQ.setVisibility(0);
                SwanAppAdLandingFragment.this.cEa = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cDH.jZ("vplayend");
                SwanAppAdLandingFragment.this.cDH.jZ("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cDH.jZ("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cEb == 0) {
                    SwanAppAdLandingFragment.this.cDH.jZ("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cDQ.setVisibility(8);
                SwanAppAdLandingFragment.this.cDH.jZ("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cDH.jZ("vpause");
            }
        });
        this.cDB.d(dVar.aju());
        this.cDB.fR(false);
    }

    private void B(ViewGroup viewGroup) {
        this.cDP = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cDQ = (RelativeLayout) this.cDP.findViewById(a.f.ad_tail_root);
        this.cDR = (SimpleDraweeView) this.cDP.findViewById(a.f.ad_tail_video_img);
        this.cDS = (SimpleDraweeView) this.cDP.findViewById(a.f.ad_tail_head_image);
        this.cDT = (TextView) this.cDP.findViewById(a.f.ad_tail_brand_name);
        this.cDU = (TextView) this.cDP.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cDW)) {
            this.cDU.setText(this.cDW);
            this.cDU.setVisibility(0);
        } else {
            this.cDU.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cDX)) {
            this.cDT.setText(this.cDX);
            this.cDT.setVisibility(0);
        } else {
            this.cDT.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cDY)) {
            this.cDS.setImageURI(Uri.parse(this.cDY));
            this.cDS.setVisibility(0);
        } else {
            this.cDS.setVisibility(8);
        }
        this.cDR.getHierarchy().A(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cDZ)) {
            this.cDR.setImageURI(t.tV(this.cDZ));
        }
        this.cDR.setVisibility(0);
        this.cDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cDS.setOnClickListener(this.cEd);
        this.cDT.setOnClickListener(this.cEd);
        this.cDU.setOnClickListener(this.cEd);
        viewGroup.addView(this.cDQ, layoutParams);
        this.cDQ.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aMh().putString(this.cDN.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kb(String str) {
        return h.aMh().getString(str, "");
    }

    private void C(final ViewGroup viewGroup) {
        g axQ = com.baidu.swan.apps.t.a.axQ();
        if (axQ != null) {
            this.cDM = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eP(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cDL.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cDL.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cDL.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kc(String str) {
                    SwanAppAdLandingFragment.this.ka(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cDL.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cDO != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cDO == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cDH.jZ("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cDH.jZ("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cDO == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cDH.jZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cDH.jZ("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cDH.jZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cDH.jZ("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cDO = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cDL.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajs() {
                    SwanAppAdLandingFragment.this.cDH.jZ("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String ajt() {
                    SwanAppAdLandingFragment.this.cDH.jZ("appinstallopen");
                    return SwanAppAdLandingFragment.this.kb(SwanAppAdLandingFragment.this.cDN.url);
                }
            };
            this.cDN = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cDL = axQ.a(getContext(), this.cDN, this.cDM);
            this.cDL.P(this.cDN);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void x(ViewGroup viewGroup) {
        this.cSQ = aiP();
        this.cSQ.a(ajq());
        this.cCq = this.cSQ.aiW();
        this.cSQ.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.cCq.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.rM("#FFFFFF");
        this.cSQ.b(frameLayout, cVar);
        this.cSQ.a(frameLayout, cVar);
        this.cSQ.b(frameLayout, covertToView);
        if (ajo()) {
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
    public boolean ap(View view) {
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
        this.cSQ.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.cCq.getContentHeight()) * SwanAppAdLandingFragment.this.cCq.getScale()) - ((float) SwanAppAdLandingFragment.this.cCq.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.cCq.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cSQ.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void iu(String str) {
                super.iu(str);
                if (Math.abs((SwanAppAdLandingFragment.this.cCq.getContentHeight() * SwanAppAdLandingFragment.this.cCq.getScale()) - SwanAppAdLandingFragment.this.cCq.covertToView().getHeight()) < 10.0f) {
                    customerAdScrollView.setIsWebViewOnBottom(true);
                } else {
                    customerAdScrollView.setIsWebViewOnBottom(false);
                }
            }
        });
        customerAdScrollView.setScrollViewListener(new com.baidu.swan.apps.adlanding.customer.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.10
            @Override // com.baidu.swan.apps.adlanding.customer.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.ap(linearLayout));
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    public boolean aiQ() {
        if (isLandScape() && this.cDB != null) {
            return this.cDB.onBackPressed();
        }
        this.cDH.jZ("lpout");
        return super.aiQ();
    }

    private boolean ajo() {
        return this.cDG == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bdU().getResources().getConfiguration().orientation == 2;
    }

    private void ajp() {
        DisplayMetrics displayMetrics = bdU().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(boolean z) {
        this.cRH.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aiP() {
        e eVar = new e(getContext());
        eVar.aiW().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cDL.aik();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cDN.name)) {
                    String kb = SwanAppAdLandingFragment.this.kb(str);
                    SwanAppAdLandingFragment.this.cDN.name = kb;
                    SwanAppAdLandingFragment.this.cDL.jV(kb);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cDN.name)) {
                    SwanAppAdLandingFragment.this.cDI.removeView(SwanAppAdLandingFragment.this.cDL.getRealView());
                    SwanAppAdLandingFragment.this.cDI.addView(SwanAppAdLandingFragment.this.cDL.getRealView());
                    SwanAppAdLandingFragment.this.cDL.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cDN.url)) {
                    SwanAppAdLandingFragment.this.cDN.url = str;
                }
                com.baidu.swan.apps.t.a.axg().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cDM);
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
    protected com.baidu.swan.apps.core.f.d ajq() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eO(SwanAppAdLandingFragment.this.cCq.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iv(final String str) {
                SwanAppAdLandingFragment.this.eO(SwanAppAdLandingFragment.this.cCq.canGoBack());
                SwanAppAdLandingFragment.this.cRH.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cRH.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aq(View view) {
        super.aq(view);
        this.cRH.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cRH.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.apL();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean ajr() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (ajo()) {
            this.cDH.jZ("vplayend");
        }
        if (this.cDB != null) {
            this.cDB.onDestroy();
        }
        if (!this.cEc) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
