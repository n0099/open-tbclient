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
/* loaded from: classes11.dex */
public class d {
    public static String bWt = "weblog";
    private int bWA;
    private View bWB;
    private BaseActivity bWu;
    private f bWv;
    private TextView bWw;
    private RelativeLayout bWx;
    private int bWy;
    private CommonWebLayout byR;
    private View byS;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bWz = 0;
    private CustomMessageListener bWC = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.byR.canGoBack()) {
                d.this.byR.goBack();
            } else {
                d.this.bWv.fr(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bWu = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bWv = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bWC);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bWu.setContentView(this.mRootView);
        this.bWB = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bWB.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bWB.setLayoutParams(layoutParams);
            this.bWB.setVisibility(0);
        } else {
            this.bWB.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bWw = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bWx = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bWy == ResultCode.h5UploadDone.code) {
                    if (d.this.bWv != null) {
                        d.this.bWv.fr(d.this.bWy);
                        d.this.bWy = -1;
                    }
                } else if (d.this.byR.canGoBack()) {
                    d.this.byR.goBack();
                } else {
                    d.this.bWv.fr(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.byR.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bWv.fr(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bWz = aR(this.mUrl, "background");
            this.bWA = aR(this.mUrl, "tintColor");
            if (this.bWz != 0) {
                this.bWx.setBackgroundColor(this.bWz);
                this.mRootView.setBackgroundColor(this.bWz);
            }
            if (this.bWA != 0) {
                this.mBack.setColorFilter(this.bWA);
                this.bWw.setTextColor(this.bWA);
            }
        }
    }

    private void initWebView() {
        this.byR = new CommonWebLayout(this.mContext);
        this.byR.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.byR.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            /* renamed from: if */
            public void mo20if(String str) {
                super.mo20if(str);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fu(int i) {
                super.fu(i);
                if (i == 100 && d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ig(String str) {
                super.ig(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.byR.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bWt + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bWv == null || i != 1) {
                                d.this.bWy = -1;
                                return;
                            }
                            d.this.bWy = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.byR.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.byS != null) {
                    d.this.byS.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void jg(String str) {
                super.jg(str);
                if (d.this.bWw != null) {
                    d.this.mTitle = str;
                    d.this.bWw.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean jh(String str) {
                Log.i(d.bWt + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.jh(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean F(String str, boolean z) {
                return super.F(str, z);
            }
        });
        g gVar = new g();
        gVar.w(this.bWu.getPageContext().getPageActivity()).a(this.bWv).a(this.byR.getSchemeCallback());
        gVar.a(this.bWu);
        a[] aaf = gVar.aaf();
        for (a aVar : aaf) {
            this.byR.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.byR, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bWz != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gQ(this.bWz), this.bWu.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bWy == ResultCode.h5UploadDone.code) {
            if (this.bWv != null) {
                this.bWv.fr(this.bWy);
                this.bWy = -1;
                return true;
            }
            return true;
        } else if (this.byR.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.byR.canGoBack()) {
                this.byR.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.byR != null && !TextUtils.isEmpty(this.mUrl)) {
                this.byR.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.byR.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bWC);
    }

    private int aR(String str, String str2) {
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
