package com.baidu.live.view.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
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
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.ResultCode;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class d {
    public static String bRH = "weblog";
    private BaseActivity bRI;
    private f bRJ;
    private TextView bRK;
    private RelativeLayout bRL;
    private int bRM;
    private int bRO;
    private View bRP;
    private CommonWebLayout bue;
    private View bug;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bRN = 0;
    private CustomMessageListener bRQ = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bue.canGoBack()) {
                d.this.bue.goBack();
            } else {
                d.this.bRJ.dL(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bRI = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bRJ = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bRQ);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bRI.setContentView(this.mRootView);
        this.bRP = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bRP.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bRP.setLayoutParams(layoutParams);
            this.bRP.setVisibility(0);
        } else {
            this.bRP.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bRK = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bRL = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bRM == ResultCode.h5UploadDone.code) {
                    if (d.this.bRJ != null) {
                        d.this.bRJ.dL(d.this.bRM);
                        d.this.bRM = -1;
                    }
                } else if (d.this.bue.canGoBack()) {
                    d.this.bue.goBack();
                } else {
                    d.this.bRJ.dL(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bue.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bRJ.dL(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bRN = aQ(this.mUrl, "background");
            this.bRO = aQ(this.mUrl, "tintColor");
            if (this.bRN != 0) {
                this.bRL.setBackgroundColor(this.bRN);
                this.mRootView.setBackgroundColor(this.bRN);
            }
            if (this.bRO != 0) {
                this.mBack.setColorFilter(this.bRO);
                this.bRK.setTextColor(this.bRO);
            }
        }
    }

    private void initWebView() {
        this.bue = new CommonWebLayout(this.mContext);
        this.bue.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.bue.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gU(String str) {
                super.gU(str);
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dO(int i) {
                super.dO(i);
                if (i == 100 && d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void gV(String str) {
                super.gV(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bue.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bRH + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bRJ == null || i != 1) {
                                d.this.bRM = -1;
                                return;
                            }
                            d.this.bRM = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bue.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bug != null) {
                    d.this.bug.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                if (d.this.bRK != null) {
                    d.this.mTitle = str;
                    d.this.bRK.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean hW(String str) {
                Log.i(d.bRH + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.hW(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean F(String str, boolean z) {
                return super.F(str, z);
            }
        });
        g gVar = new g();
        gVar.w(this.bRI.getPageContext().getPageActivity()).a(this.bRJ).a(this.bue.getSchemeCallback());
        gVar.a(this.bRI);
        a[] Wm = gVar.Wm();
        for (a aVar : Wm) {
            this.bue.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bue, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bRN != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.fj(this.bRN), this.bRI.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bRM == ResultCode.h5UploadDone.code) {
            if (this.bRJ != null) {
                this.bRJ.dL(this.bRM);
                this.bRM = -1;
                return true;
            }
            return true;
        } else if (this.bue.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bue.canGoBack()) {
                this.bue.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bue != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bue.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bue.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bRQ);
    }

    private int aQ(String str, String str2) {
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
                                return ColorUtils.setAlphaComponent(Color.parseColor('#' + str3.substring(0, 6)), parseInt);
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
