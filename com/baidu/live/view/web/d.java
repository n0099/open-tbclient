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
    public static String bQM = "weblog";
    private BaseActivity bQN;
    private f bQO;
    private TextView bQP;
    private RelativeLayout bQQ;
    private int bQR;
    private int bQT;
    private View bQU;
    private CommonWebLayout bug;
    private View buh;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bQS = 0;
    private CustomMessageListener bQV = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bug.canGoBack()) {
                d.this.bug.goBack();
            } else {
                d.this.bQO.fr(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bQN = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bQO = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bQV);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bQN.setContentView(this.mRootView);
        this.bQU = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bQU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bQU.setLayoutParams(layoutParams);
            this.bQU.setVisibility(0);
        } else {
            this.bQU.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bQP = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bQQ = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bQR == ResultCode.h5UploadDone.code) {
                    if (d.this.bQO != null) {
                        d.this.bQO.fr(d.this.bQR);
                        d.this.bQR = -1;
                    }
                } else if (d.this.bug.canGoBack()) {
                    d.this.bug.goBack();
                } else {
                    d.this.bQO.fr(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bug.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bQO.fr(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bQS = aW(this.mUrl, "background");
            this.bQT = aW(this.mUrl, "tintColor");
            if (this.bQS != 0) {
                this.bQQ.setBackgroundColor(this.bQS);
                this.mRootView.setBackgroundColor(this.bQS);
            }
            if (this.bQT != 0) {
                this.mBack.setColorFilter(this.bQT);
                this.bQP.setTextColor(this.bQT);
            }
        }
    }

    private void initWebView() {
        this.bug = new CommonWebLayout(this.mContext);
        this.bug.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.bug.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void is(String str) {
                super.is(str);
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void it(String str) {
                super.it(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bug.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bQM + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bQO == null || i != 1) {
                                d.this.bQR = -1;
                                return;
                            }
                            d.this.bQR = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bug.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.buh != null) {
                    d.this.buh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void jn(String str) {
                super.jn(str);
                if (d.this.bQP != null) {
                    d.this.mTitle = str;
                    d.this.bQP.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean jo(String str) {
                Log.i(d.bQM + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.jo(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean F(String str, boolean z) {
                return super.F(str, z);
            }
        });
        g gVar = new g();
        gVar.x(this.bQN.getPageContext().getPageActivity()).a(this.bQO).a(this.bug.getSchemeCallback());
        gVar.a(this.bQN);
        a[] YO = gVar.YO();
        for (a aVar : YO) {
            this.bug.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bug, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bQS != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gP(this.bQS), this.bQN.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bQR == ResultCode.h5UploadDone.code) {
            if (this.bQO != null) {
                this.bQO.fr(this.bQR);
                this.bQR = -1;
                return true;
            }
            return true;
        } else if (this.bug.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bug.canGoBack()) {
                this.bug.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bug != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bug.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bug.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bQV);
    }

    private int aW(String str, String str2) {
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
                            String[] split3 = split2[i].split("=");
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
