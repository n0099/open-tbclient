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
/* loaded from: classes4.dex */
public class d {
    public static String bHM = "weblog";
    private BaseActivity bHN;
    private f bHO;
    private TextView bHP;
    private RelativeLayout bHQ;
    private int bHR;
    private int bHT;
    private View bHU;
    private CommonWebLayout bpo;
    private View bpp;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bHS = 0;
    private CustomMessageListener bHV = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bpo.canGoBack()) {
                d.this.bpo.goBack();
            } else {
                d.this.bHO.eX(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bHN = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bHO = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bHV);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.bHN.setContentView(this.mRootView);
        this.bHU = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bHU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bHU.setLayoutParams(layoutParams);
            this.bHU.setVisibility(0);
        } else {
            this.bHU.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.bHP = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bHQ = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bHR == ResultCode.h5UploadDone.code) {
                    if (d.this.bHO != null) {
                        d.this.bHO.eX(d.this.bHR);
                        d.this.bHR = -1;
                    }
                } else if (d.this.bpo.canGoBack()) {
                    d.this.bpo.goBack();
                } else {
                    d.this.bHO.eX(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bpo.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bHO.eX(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bHS = aS(this.mUrl, "background");
            this.bHT = aS(this.mUrl, "tintColor");
            if (this.bHS != 0) {
                this.bHQ.setBackgroundColor(this.bHS);
                this.mRootView.setBackgroundColor(this.bHS);
            }
            if (this.bHT != 0) {
                this.mBack.setColorFilter(this.bHT);
                this.bHP.setTextColor(this.bHT);
            }
        }
    }

    private void initWebView() {
        this.bpo = new CommonWebLayout(this.mContext);
        this.bpo.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bpo.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hN(String str) {
                super.hN(str);
                if (d.this.bpp != null) {
                    d.this.bpp.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && d.this.bpp != null) {
                    d.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bpo.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bHM + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bHO == null || i != 1) {
                                d.this.bHR = -1;
                                return;
                            }
                            d.this.bHR = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bpo.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bpp != null) {
                    d.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bpp != null) {
                    d.this.bpp.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iC(String str) {
                super.iC(str);
                if (d.this.bHP != null) {
                    d.this.mTitle = str;
                    d.this.bHP.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean iD(String str) {
                Log.i(d.bHM + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.iD(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean E(String str, boolean z) {
                return super.E(str, z);
            }
        });
        g gVar = new g();
        gVar.x(this.bHN.getPageContext().getPageActivity()).a(this.bHO).a(this.bpo.getSchemeCallback());
        gVar.a(this.bHN);
        a[] Ux = gVar.Ux();
        for (a aVar : Ux) {
            this.bpo.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bpo, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bHS != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gk(this.bHS), this.bHN.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bHR == ResultCode.h5UploadDone.code) {
            if (this.bHO != null) {
                this.bHO.eX(this.bHR);
                this.bHR = -1;
                return true;
            }
            return true;
        } else if (this.bpo.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bpo.canGoBack()) {
                this.bpo.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bpo != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bpo.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bpo.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bHV);
    }

    private int aS(String str, String str2) {
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
