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
    public static String bWZ = "weblog";
    private BaseActivity bXa;
    private f bXb;
    private CommonWebLayout bXc;
    private View bXd;
    private TextView bXe;
    private RelativeLayout bXf;
    private int bXg;
    private int bXi;
    private View bXj;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bXh = 0;
    private CustomMessageListener bXk = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bXc.canGoBack()) {
                d.this.bXc.goBack();
            } else {
                d.this.bXb.fq(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bXa = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bXb = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bXk);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bXa.setContentView(this.mRootView);
        this.bXj = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bXj.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bXj.setLayoutParams(layoutParams);
            this.bXj.setVisibility(0);
        } else {
            this.bXj.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bXe = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bXf = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bXg == ResultCode.h5UploadDone.code) {
                    if (d.this.bXb != null) {
                        d.this.bXb.fq(d.this.bXg);
                        d.this.bXg = -1;
                    }
                } else if (d.this.bXc.canGoBack()) {
                    d.this.bXc.goBack();
                } else {
                    d.this.bXb.fq(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bXc.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bXb.fq(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bXh = aQ(this.mUrl, "background");
            this.bXi = aQ(this.mUrl, "tintColor");
            if (this.bXh != 0) {
                this.bXf.setBackgroundColor(this.bXh);
                this.mRootView.setBackgroundColor(this.bXh);
            }
            if (this.bXi != 0) {
                this.mBack.setColorFilter(this.bXi);
                this.bXe.setTextColor(this.bXi);
            }
        }
    }

    private void initWebView() {
        this.bXc = new CommonWebLayout(this.mContext);
        this.bXc.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.bXc.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iz(String str) {
                super.iz(str);
                if (d.this.bXd != null) {
                    d.this.bXd.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fo(int i) {
                super.fo(i);
                if (i == 100 && d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iA(String str) {
                super.iA(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bXc.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bWZ + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bXb == null || i != 1) {
                                d.this.bXg = -1;
                                return;
                            }
                            d.this.bXg = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bXc.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void f(String str, int i, String str2) {
                super.f(str, i, str2);
                if (d.this.bXd != null) {
                    d.this.bXd.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iB(String str) {
                super.iB(str);
                if (d.this.bXe != null) {
                    d.this.mTitle = str;
                    d.this.bXe.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean iC(String str) {
                Log.i(d.bWZ + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.iC(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean F(String str, boolean z) {
                return super.F(str, z);
            }
        });
        g gVar = new g();
        gVar.t(this.bXa.getPageContext().getPageActivity()).a(this.bXb).a(this.bXc.getSchemeCallback());
        gVar.a(this.bXa);
        a[] Yb = gVar.Yb();
        for (a aVar : Yb) {
            this.bXc.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bXc, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bXh != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.fp(this.bXh), this.bXa.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bXg == ResultCode.h5UploadDone.code) {
            if (this.bXb != null) {
                this.bXb.fq(this.bXg);
                this.bXg = -1;
                return true;
            }
            return true;
        } else if (this.bXc.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bXc.canGoBack()) {
                this.bXc.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bXc != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bXc.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bXc.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bXk);
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
