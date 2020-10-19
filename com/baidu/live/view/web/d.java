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
    public static String bEN = "weblog";
    private BaseActivity bEO;
    private f bEP;
    private TextView bEQ;
    private RelativeLayout bER;
    private int bES;
    private int bEU;
    private View bEV;
    private CommonWebLayout bnB;
    private View bnC;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bET = 0;
    private CustomMessageListener bEW = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bnB.canGoBack()) {
                d.this.bnB.goBack();
            } else {
                d.this.bEP.eU(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bEO = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bEP = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bEW);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.bEO.setContentView(this.mRootView);
        this.bEV = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bEV.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bEV.setLayoutParams(layoutParams);
            this.bEV.setVisibility(0);
        } else {
            this.bEV.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.bEQ = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bER = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bES == ResultCode.h5UploadDone.code) {
                    if (d.this.bEP != null) {
                        d.this.bEP.eU(d.this.bES);
                        d.this.bES = -1;
                    }
                } else if (d.this.bnB.canGoBack()) {
                    d.this.bnB.goBack();
                } else {
                    d.this.bEP.eU(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bnB.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bEP.eU(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bET = aM(this.mUrl, "background");
            this.bEU = aM(this.mUrl, "tintColor");
            if (this.bET != 0) {
                this.bER.setBackgroundColor(this.bET);
                this.mRootView.setBackgroundColor(this.bET);
            }
            if (this.bEU != 0) {
                this.mBack.setColorFilter(this.bEU);
                this.bEQ.setTextColor(this.bEU);
            }
        }
    }

    private void initWebView() {
        this.bnB = new CommonWebLayout(this.mContext);
        this.bnB.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bnB.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hF(String str) {
                super.hF(str);
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eX(int i) {
                super.eX(i);
                if (i == 100 && d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hG(String str) {
                super.hG(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bnB.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bEN + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bEP == null || i != 1) {
                                d.this.bES = -1;
                                return;
                            }
                            d.this.bES = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bnB.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bnC != null) {
                    d.this.bnC.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ir(String str) {
                super.ir(str);
                if (d.this.bEQ != null) {
                    d.this.mTitle = str;
                    d.this.bEQ.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean is(String str) {
                Log.i(d.bEN + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.is(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean D(String str, boolean z) {
                return super.D(str, z);
            }
        });
        g gVar = new g();
        gVar.x(this.bEO.getPageContext().getPageActivity()).a(this.bEP).a(this.bnB.getSchemeCallback());
        gVar.a(this.bEO);
        a[] Tx = gVar.Tx();
        for (a aVar : Tx) {
            this.bnB.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bnB, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bET != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gc(this.bET), this.bEO.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bES == ResultCode.h5UploadDone.code) {
            if (this.bEP != null) {
                this.bEP.eU(this.bES);
                this.bES = -1;
                return true;
            }
            return true;
        } else if (this.bnB.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bnB.canGoBack()) {
                this.bnB.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bnB != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bnB.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bnB.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bEW);
    }

    private int aM(String str, String str2) {
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
