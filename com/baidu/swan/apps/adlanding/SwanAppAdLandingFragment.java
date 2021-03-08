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
/* loaded from: classes8.dex */
public class SwanAppAdLandingFragment extends i {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.media.b.a cFb;
    private JSONObject cFc;
    private b cFh;
    private FrameLayout cFi;
    private g cFl;
    private com.baidu.swan.apps.adlanding.download.a.a cFm;
    private com.baidu.swan.apps.adlanding.download.model.a cFn;
    private RelativeLayout cFp;
    private RelativeLayout cFq;
    private SimpleDraweeView cFr;
    private SimpleDraweeView cFs;
    private TextView cFt;
    private TextView cFu;
    private int cFv;
    private String cFw;
    private String cFx;
    private String cFy;
    private String cFz;
    private String mUrl;
    private int mVideoHeight;
    private String mVideoUrl;
    private int mVideoWidth;
    private LandingType cFg = LandingType.NORMAL;
    private String mFrom = "";
    private final String cFj = "swan-custom-ad";
    private final int cFk = 10;
    private String mDownloadUrl = "";
    private String mPackageName = "";
    private SwanAdDownloadState cFo = SwanAdDownloadState.NOT_START;
    private int cFA = 0;
    private int cFB = 0;
    private boolean cFC = true;
    private View.OnClickListener cFD = new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.cFv == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.cFh.d("c", hashMap);
            i.b("adLanding", com.baidu.swan.apps.model.b.bZ(SwanAppAdLandingFragment.this.mUrl, SwanAppAdLandingFragment.this.mUrl));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    static /* synthetic */ int b(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i = swanAppAdLandingFragment.cFB;
        swanAppAdLandingFragment.cFB = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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

    private void ajp() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mUrl = arguments.getString("url", "");
            if (!TextUtils.isEmpty(this.mParams)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams);
                    this.mVideoUrl = jSONObject.optString("vurl", "");
                    this.cFz = jSONObject.optString("w_picurl", "");
                    this.cFy = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
                    this.cFv = jSONObject.optInt("act", ActionType.LP.value());
                    if (this.cFv == ActionType.DL.value()) {
                        string = getString(a.h.swanapp_ad_download_button);
                    } else {
                        string = getString(a.h.swanapp_ad_landingpage_button);
                    }
                    this.cFw = string;
                    this.cFx = jSONObject.optString("appname", "");
                    this.cFA = jSONObject.optInt("currentTime", 0);
                    this.cFc = jSONObject.optJSONObject("monitors");
                    this.mDownloadUrl = jSONObject.optString("url", "");
                    this.mPackageName = jSONObject.optString("name", "");
                    this.mFrom = jSONObject.optString("from", "");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(this.mVideoUrl)) {
                    this.cFg = LandingType.VIDEO;
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ajp();
        FragmentActivity bdW = bdW();
        if (bdW != null) {
            this.cFC = 1 == bdW.getRequestedOrientation();
            if (!this.cFC) {
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
        this.cFi = (FrameLayout) inflate.findViewById(a.f.aiapps_webView_container);
        ajs();
        C(this.cFi);
        x(this.cFi);
        if (ajr()) {
            ajq();
            B(this.cFi);
        }
        e(this.cFi);
        View av = aoL() ? av(inflate) : inflate;
        this.cFh = new b(getContext(), this.cFc, this.cFb);
        this.cFh.kg("lpin");
        return a(av, this);
    }

    private void ajq() {
        d dVar = new d(this.cFz, this.mVideoUrl, this.cUq.ajb(), this.mVideoWidth, this.mVideoHeight, this.cFA);
        this.cFb = new com.baidu.swan.apps.media.b.a(getContext(), dVar.ajx());
        this.cFb.a(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.1
            @Override // com.baidu.swan.apps.media.b.b
            public void a(j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(j jVar, int i, int i2) {
                return false;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(j jVar) {
                SwanAppAdLandingFragment.this.cFq.bringToFront();
                SwanAppAdLandingFragment.this.cFq.setVisibility(0);
                SwanAppAdLandingFragment.this.cFA = 0;
                SwanAppAdLandingFragment.b(SwanAppAdLandingFragment.this);
                SwanAppAdLandingFragment.this.cFh.kg("vplayend");
                SwanAppAdLandingFragment.this.cFh.kg("scard");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(j jVar) {
                SwanAppAdLandingFragment.this.cFh.kg("vcontinueplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(j jVar) {
                if (SwanAppAdLandingFragment.this.cFB == 0) {
                    SwanAppAdLandingFragment.this.cFh.kg("vstart");
                    return;
                }
                SwanAppAdLandingFragment.this.cFq.setVisibility(8);
                SwanAppAdLandingFragment.this.cFh.kg("vrepeatedplay");
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(j jVar) {
                SwanAppAdLandingFragment.this.cFh.kg("vpause");
            }
        });
        this.cFb.d(dVar.ajx());
        this.cFb.fR(false);
    }

    private void B(ViewGroup viewGroup) {
        this.cFp = (RelativeLayout) LayoutInflater.from(getContext()).inflate(a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.mVideoHeight;
        this.cFq = (RelativeLayout) this.cFp.findViewById(a.f.ad_tail_root);
        this.cFr = (SimpleDraweeView) this.cFp.findViewById(a.f.ad_tail_video_img);
        this.cFs = (SimpleDraweeView) this.cFp.findViewById(a.f.ad_tail_head_image);
        this.cFt = (TextView) this.cFp.findViewById(a.f.ad_tail_brand_name);
        this.cFu = (TextView) this.cFp.findViewById(a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.cFw)) {
            this.cFu.setText(this.cFw);
            this.cFu.setVisibility(0);
        } else {
            this.cFu.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.cFx)) {
            this.cFt.setText(this.cFx);
            this.cFt.setVisibility(0);
        } else {
            this.cFt.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.cFy)) {
            this.cFs.setImageURI(Uri.parse(this.cFy));
            this.cFs.setVisibility(0);
        } else {
            this.cFs.setVisibility(8);
        }
        this.cFr.getHierarchy().A(getResources().getDrawable(a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.cFz)) {
            this.cFr.setImageURI(t.uc(this.cFz));
        }
        this.cFr.setVisibility(0);
        this.cFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.cFs.setOnClickListener(this.cFD);
        this.cFt.setOnClickListener(this.cFD);
        this.cFu.setOnClickListener(this.cFD);
        viewGroup.addView(this.cFq, layoutParams);
        this.cFq.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.aMk().putString(this.cFn.url, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ki(String str) {
        return h.aMk().getString(str, "");
    }

    private void C(final ViewGroup viewGroup) {
        g axT = com.baidu.swan.apps.t.a.axT();
        if (axT != null) {
            this.cFm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.5
                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void eP(boolean z) {
                    if (z) {
                        viewGroup.removeView(SwanAppAdLandingFragment.this.cFl.getRealView());
                        viewGroup.addView(SwanAppAdLandingFragment.this.cFl.getRealView());
                        return;
                    }
                    viewGroup.removeView(SwanAppAdLandingFragment.this.cFl.getRealView());
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void kj(String str) {
                    SwanAppAdLandingFragment.this.kh(str);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cFl.a(swanAdDownloadState);
                    if (SwanAppAdLandingFragment.this.cFo != swanAdDownloadState) {
                        if (SwanAppAdLandingFragment.this.cFo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cFh.kg("appdownloadbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                            SwanAppAdLandingFragment.this.cFh.kg("appdownloadpause");
                        } else if (SwanAppAdLandingFragment.this.cFo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            SwanAppAdLandingFragment.this.cFh.kg("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            SwanAppAdLandingFragment.this.cFh.kg("appdownloadfinish");
                            SwanAppAdLandingFragment.this.cFh.kg("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            SwanAppAdLandingFragment.this.cFh.kg("appinstallfinish");
                        }
                        SwanAppAdLandingFragment.this.cFo = swanAdDownloadState;
                    }
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                    SwanAppAdLandingFragment.this.cFl.updateProgress(i);
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public void ajv() {
                    SwanAppAdLandingFragment.this.cFh.kg("appinstallbegin");
                }

                @Override // com.baidu.swan.apps.adlanding.download.a.a
                public String ajw() {
                    SwanAppAdLandingFragment.this.cFh.kg("appinstallopen");
                    return SwanAppAdLandingFragment.this.ki(SwanAppAdLandingFragment.this.cFn.url);
                }
            };
            this.cFn = new com.baidu.swan.apps.adlanding.download.model.a(this.mDownloadUrl, this.mPackageName);
            this.cFl = axT.a(getContext(), this.cFn, this.cFm);
            this.cFl.R(this.cFn);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void x(ViewGroup viewGroup) {
        this.cUq = aiS();
        this.cUq.a(ajt());
        this.cDQ = this.cUq.aiZ();
        this.cUq.loadUrl(this.mUrl);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.cDQ.covertToView();
        com.baidu.swan.apps.runtime.config.c cVar = new com.baidu.swan.apps.runtime.config.c();
        cVar.backgroundColor = SwanAppConfigData.rT("#FFFFFF");
        this.cUq.b(frameLayout, cVar);
        this.cUq.a(frameLayout, cVar);
        this.cUq.b(frameLayout, covertToView);
        if (ajr()) {
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
        this.cUq.a(new com.baidu.swan.apps.core.f.c() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.6
            @Override // com.baidu.swan.apps.core.f.c
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                customerAdScrollView.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.cDQ.getContentHeight()) * SwanAppAdLandingFragment.this.cDQ.getScale()) - ((float) SwanAppAdLandingFragment.this.cDQ.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.cDQ.getWebViewScrollY()) < 10.0f);
            }
        });
        viewGroup2.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.7
            @Override // java.lang.Runnable
            public void run() {
                viewGroup2.setLayoutParams(new LinearLayout.LayoutParams(-1, viewGroup.getHeight()));
            }
        });
        this.cUq.a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.8
            @Override // com.baidu.swan.apps.core.g
            public void iA(String str) {
                super.iA(str);
                if (Math.abs((SwanAppAdLandingFragment.this.cDQ.getContentHeight() * SwanAppAdLandingFragment.this.cDQ.getScale()) - SwanAppAdLandingFragment.this.cDQ.covertToView().getHeight()) < 10.0f) {
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
    public boolean aiT() {
        if (isLandScape() && this.cFb != null) {
            return this.cFb.onBackPressed();
        }
        this.cFh.kg("lpout");
        return super.aiT();
    }

    private boolean ajr() {
        return this.cFg == LandingType.VIDEO;
    }

    private boolean isLandScape() {
        return bdW().getResources().getConfiguration().orientation == 2;
    }

    private void ajs() {
        DisplayMetrics displayMetrics = bdW().getResources().getDisplayMetrics();
        int i = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.mVideoHeight = (i * 9) / 16;
        this.mVideoWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(boolean z) {
        this.cTh.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // com.baidu.swan.apps.core.d.i
    public f aiS() {
        e eVar = new e(getContext());
        eVar.aiZ().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (SwanAppAdLandingFragment.DEBUG) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.cFl.ain();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cFn.name)) {
                    String ki = SwanAppAdLandingFragment.this.ki(str);
                    SwanAppAdLandingFragment.this.cFn.name = ki;
                    SwanAppAdLandingFragment.this.cFl.kc(ki);
                }
                if (ak.isAppInstalled(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cFn.name)) {
                    SwanAppAdLandingFragment.this.cFi.removeView(SwanAppAdLandingFragment.this.cFl.getRealView());
                    SwanAppAdLandingFragment.this.cFi.addView(SwanAppAdLandingFragment.this.cFl.getRealView());
                    SwanAppAdLandingFragment.this.cFl.a(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.cFn.url)) {
                    SwanAppAdLandingFragment.this.cFn.url = str;
                }
                com.baidu.swan.apps.t.a.axj().a(SwanAppAdLandingFragment.this.getContext(), SwanAppAdLandingFragment.this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.cFm);
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
    protected com.baidu.swan.apps.core.f.d ajt() {
        return new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2
            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void goBack() {
                SwanAppAdLandingFragment.this.eO(SwanAppAdLandingFragment.this.cDQ.canGoBack());
            }

            @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
            public void iB(final String str) {
                SwanAppAdLandingFragment.this.eO(SwanAppAdLandingFragment.this.cDQ.canGoBack());
                SwanAppAdLandingFragment.this.cTh.post(new Runnable() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppAdLandingFragment.this.cTh.setTitle(TextUtils.isEmpty(str) ? "" : str);
                    }
                });
            }
        };
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected void aq(View view) {
        super.aq(view);
        this.cTh.setLeftHomeViewSrc(a.e.aiapps_action_bar_close_black_selector);
        this.cTh.setLeftHomeViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.apO();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.apps.core.d.c
    protected boolean aju() {
        return true;
    }

    @Override // com.baidu.swan.apps.core.d.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (ajr()) {
            this.cFh.kg("vplayend");
        }
        if (this.cFb != null) {
            this.cFb.onDestroy();
        }
        if (!this.cFC) {
            setRequestedOrientation(0);
        }
        super.onDestroy();
    }
}
