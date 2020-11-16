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
    public static String bLH = "weblog";
    private BaseActivity bLI;
    private f bLJ;
    private TextView bLK;
    private RelativeLayout bLL;
    private int bLM;
    private int bLO;
    private View bLP;
    private CommonWebLayout boW;
    private View boX;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bLN = 0;
    private CustomMessageListener bLQ = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.boW.canGoBack()) {
                d.this.boW.goBack();
            } else {
                d.this.bLJ.eT(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bLI = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bLJ = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bLQ);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bLI.setContentView(this.mRootView);
        this.bLP = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bLP.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bLP.setLayoutParams(layoutParams);
            this.bLP.setVisibility(0);
        } else {
            this.bLP.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bLK = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bLL = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bLM == ResultCode.h5UploadDone.code) {
                    if (d.this.bLJ != null) {
                        d.this.bLJ.eT(d.this.bLM);
                        d.this.bLM = -1;
                    }
                } else if (d.this.boW.canGoBack()) {
                    d.this.boW.goBack();
                } else {
                    d.this.bLJ.eT(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.boW.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bLJ.eT(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bLN = aS(this.mUrl, "background");
            this.bLO = aS(this.mUrl, "tintColor");
            if (this.bLN != 0) {
                this.bLL.setBackgroundColor(this.bLN);
                this.mRootView.setBackgroundColor(this.bLN);
            }
            if (this.bLO != 0) {
                this.mBack.setColorFilter(this.bLO);
                this.bLK.setTextColor(this.bLO);
            }
        }
    }

    private void initWebView() {
        this.boW = new CommonWebLayout(this.mContext);
        this.boW.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.boW.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hO(String str) {
                super.hO(str);
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eW(int i) {
                super.eW(i);
                if (i == 100 && d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hP(String str) {
                super.hP(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.boW.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bLH + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bLJ == null || i != 1) {
                                d.this.bLM = -1;
                                return;
                            }
                            d.this.bLM = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.boW.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.boX != null) {
                    d.this.boX.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iJ(String str) {
                super.iJ(str);
                if (d.this.bLK != null) {
                    d.this.mTitle = str;
                    d.this.bLK.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean iK(String str) {
                Log.i(d.bLH + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.iK(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean E(String str, boolean z) {
                return super.E(str, z);
            }
        });
        g gVar = new g();
        gVar.x(this.bLI.getPageContext().getPageActivity()).a(this.bLJ).a(this.boW.getSchemeCallback());
        gVar.a(this.bLI);
        a[] Wo = gVar.Wo();
        for (a aVar : Wo) {
            this.boW.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.boW, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bLN != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gr(this.bLN), this.bLI.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bLM == ResultCode.h5UploadDone.code) {
            if (this.bLJ != null) {
                this.bLJ.eT(this.bLM);
                this.bLM = -1;
                return true;
            }
            return true;
        } else if (this.boW.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.boW.canGoBack()) {
                this.boW.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.boW != null && !TextUtils.isEmpty(this.mUrl)) {
                this.boW.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.boW.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bLQ);
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
