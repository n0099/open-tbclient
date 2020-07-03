package com.baidu.live.view.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.ResultCode;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    public static String boK = "weblog";
    private CommonWebLayout bdr;
    private View bds;
    private BaseActivity boL;
    private f boM;
    private TextView boN;
    private RelativeLayout boO;
    private int boP;
    private int boR;
    private View boS;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int boQ = 0;
    private CustomMessageListener boT = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bdr.canGoBack()) {
                d.this.bdr.goBack();
            } else {
                d.this.boM.cM(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.boL = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.boM = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.boT);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.boL.setContentView(this.mRootView);
        this.boS = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.boS.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.boS.setLayoutParams(layoutParams);
            this.boS.setVisibility(0);
        } else {
            this.boS.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.boN = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.boO = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.boP == ResultCode.h5UploadDone.code) {
                    if (d.this.boM != null) {
                        d.this.boM.cM(d.this.boP);
                        d.this.boP = -1;
                    }
                } else if (d.this.bdr.canGoBack()) {
                    d.this.bdr.goBack();
                } else {
                    d.this.boM.cM(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bdr.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.boM.cM(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.boQ = aE(this.mUrl, "background");
            this.boR = aE(this.mUrl, "tintColor");
            if (this.boQ != 0) {
                this.boO.setBackgroundColor(this.boQ);
                this.mRootView.setBackgroundColor(this.boQ);
            }
            if (this.boR != 0) {
                this.mBack.setColorFilter(this.boR);
                this.boN.setTextColor(this.boR);
            }
        }
    }

    private void initWebView() {
        this.bdr = new CommonWebLayout(this.mContext);
        this.bdr.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bdr.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fY(String str) {
                super.fY(str);
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dE(int i) {
                super.dE(i);
                if (i == 100 && d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fJ(String str) {
                super.fJ(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bdr.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.boK + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.boM == null || i != 1) {
                                d.this.boP = -1;
                                return;
                            }
                            d.this.boP = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bdr.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i("SuperCustomerHelper", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (i == 1) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913188, null));
                            }
                        }
                    });
                }
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bds != null) {
                    d.this.bds.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fZ(String str) {
                super.fZ(str);
                if (d.this.boN != null) {
                    d.this.mTitle = str;
                    d.this.boN.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean ga(String str) {
                Log.i(d.boK + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.ga(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean v(String str, boolean z) {
                return super.v(str, z);
            }
        });
        g gVar = new g();
        gVar.u(this.boL.getPageContext().getPageActivity()).b(this.boM).a(this.bdr.getSchemeCallback());
        gVar.a(this.boL);
        a[] KO = gVar.KO();
        for (a aVar : KO) {
            this.bdr.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bdr, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.boQ != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.dF(this.boQ), this.boL.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.boP == ResultCode.h5UploadDone.code) {
            if (this.boM != null) {
                this.boM.cM(this.boP);
                this.boP = -1;
                return true;
            }
            return true;
        } else if (this.bdr.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bdr.canGoBack()) {
                this.bdr.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bdr != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bdr.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bdr.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.boT);
    }

    private int aE(String str, String str2) {
        String str3;
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && str.indexOf("?") > 0) {
            String[] split = str.split("\\?");
            if (split.length >= 2) {
                String[] split2 = split[1].split(ETAG.ITEM_SEPARATOR);
                HashMap hashMap = new HashMap();
                if (split2.length >= 1) {
                    for (int i = 0; i < split2.length; i++) {
                        if (split2[i] != null) {
                            String[] split3 = split2[i].split(ETAG.EQUAL);
                            if (split3.length >= 2) {
                                hashMap.put(split3[0], split3[1]);
                            }
                        }
                    }
                    if (hashMap.get(str2) != null) {
                        str3 = (String) hashMap.get(str2);
                        if (TextUtils.isEmpty(str3) && str3.length() == 8) {
                            try {
                                int parseInt = Integer.parseInt(str3.substring(6, 8), 16);
                                if (parseInt < 0 || parseInt > 255) {
                                    return 0;
                                }
                                return ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + str3.substring(0, 6)), parseInt);
                            } catch (Exception e) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        str3 = queryParameter;
        return TextUtils.isEmpty(str3) ? 0 : 0;
    }
}
