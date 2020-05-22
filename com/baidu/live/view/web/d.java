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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.ResultCode;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    public static String bjH = "weblog";
    private BaseActivity bjI;
    private f bjJ;
    private CommonWebLayout bjK;
    private View bjL;
    private TextView bjM;
    private RelativeLayout bjN;
    private int bjO;
    private int bjQ;
    private View bjR;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bjP = 0;
    private CustomMessageListener bjS = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bjK.canGoBack()) {
                d.this.bjK.goBack();
            } else {
                d.this.bjJ.dt(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bjI = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bjJ = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bjS);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.bjI.setContentView(this.mRootView);
        this.bjR = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bjR.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bjR.setLayoutParams(layoutParams);
            this.bjR.setVisibility(0);
        } else {
            this.bjR.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.bjM = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bjN = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bjO == ResultCode.h5UploadDone.code) {
                    if (d.this.bjJ != null) {
                        d.this.bjJ.dt(d.this.bjO);
                        d.this.bjO = -1;
                    }
                } else if (d.this.bjK.canGoBack()) {
                    d.this.bjK.goBack();
                } else {
                    d.this.bjJ.dt(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bjK.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bjJ.dt(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bjP = aC(this.mUrl, "background");
            this.bjQ = aC(this.mUrl, "tintColor");
            if (this.bjP != 0) {
                this.bjN.setBackgroundColor(this.bjP);
                this.mRootView.setBackgroundColor(this.bjP);
            }
            if (this.bjQ != 0) {
                this.mBack.setColorFilter(this.bjQ);
                this.bjM.setTextColor(this.bjQ);
            }
        }
    }

    private void initWebView() {
        this.bjK = new CommonWebLayout(this.mContext);
        this.bjK.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bjK.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fP(String str) {
                super.fP(str);
                if (d.this.bjL != null) {
                    d.this.bjL.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dr(int i) {
                super.dr(i);
                if (i == 100 && d.this.bjL != null) {
                    d.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fQ(String str) {
                super.fQ(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bjK.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bjH + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bjJ == null || i != 1) {
                                d.this.bjO = -1;
                                return;
                            }
                            d.this.bjO = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bjK.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bjL != null) {
                    d.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bjL != null) {
                    d.this.bjL.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fR(String str) {
                super.fR(str);
                if (d.this.bjM != null) {
                    d.this.mTitle = str;
                    d.this.bjM.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean fS(String str) {
                Log.i(d.bjH + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.fS(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean t(String str, boolean z) {
                return super.t(str, z);
            }
        });
        g gVar = new g();
        gVar.u(this.bjI.getPageContext().getPageActivity()).a(this.bjJ).a(this.bjK.getSchemeCallback());
        gVar.a(this.bjI);
        a[] JF = gVar.JF();
        for (a aVar : JF) {
            this.bjK.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bjK, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bjP != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.ds(this.bjP), this.bjI.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bjO == ResultCode.h5UploadDone.code) {
            if (this.bjJ != null) {
                this.bjJ.dt(this.bjO);
                this.bjO = -1;
                return true;
            }
            return true;
        } else if (this.bjK.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bjK.canGoBack()) {
                this.bjK.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bjK != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bjK.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bjK.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bjS);
    }

    private int aC(String str, String str2) {
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
