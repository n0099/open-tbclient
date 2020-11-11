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
    public static String bNr = "weblog";
    private BaseActivity bNs;
    private f bNt;
    private TextView bNu;
    private RelativeLayout bNv;
    private int bNw;
    private int bNy;
    private View bNz;
    private CommonWebLayout bqH;
    private View bqI;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bNx = 0;
    private CustomMessageListener bNA = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bqH.canGoBack()) {
                d.this.bqH.goBack();
            } else {
                d.this.bNt.eX(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bNs = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bNt = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bNA);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.sdk_webview_layout, (ViewGroup) null);
        this.bNs.setContentView(this.mRootView);
        this.bNz = this.mRootView.findViewById(a.f.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bNz.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bNz.setLayoutParams(layoutParams);
            this.bNz.setVisibility(0);
        } else {
            this.bNz.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.f.contentView);
        this.bNu = (TextView) this.mRootView.findViewById(a.f.tv_title);
        this.bNv = (RelativeLayout) this.mRootView.findViewById(a.f.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.f.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bNw == ResultCode.h5UploadDone.code) {
                    if (d.this.bNt != null) {
                        d.this.bNt.eX(d.this.bNw);
                        d.this.bNw = -1;
                    }
                } else if (d.this.bqH.canGoBack()) {
                    d.this.bqH.goBack();
                } else {
                    d.this.bNt.eX(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bqH.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bNt.eX(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bNx = aT(this.mUrl, "background");
            this.bNy = aT(this.mUrl, "tintColor");
            if (this.bNx != 0) {
                this.bNv.setBackgroundColor(this.bNx);
                this.mRootView.setBackgroundColor(this.bNx);
            }
            if (this.bNy != 0) {
                this.mBack.setColorFilter(this.bNy);
                this.bNu.setTextColor(this.bNy);
            }
        }
    }

    private void initWebView() {
        this.bqH = new CommonWebLayout(this.mContext);
        this.bqH.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha0));
        this.bqH.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hU(String str) {
                super.hU(str);
                if (d.this.bqI != null) {
                    d.this.bqI.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fa(int i) {
                super.fa(i);
                if (i == 100 && d.this.bqI != null) {
                    d.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hV(String str) {
                super.hV(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bqH.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bNr + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bNt == null || i != 1) {
                                d.this.bNw = -1;
                                return;
                            }
                            d.this.bNw = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bqH.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bqI != null) {
                    d.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void e(String str, int i, String str2) {
                super.e(str, i, str2);
                if (d.this.bqI != null) {
                    d.this.bqI.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void iP(String str) {
                super.iP(str);
                if (d.this.bNu != null) {
                    d.this.mTitle = str;
                    d.this.bNu.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean iQ(String str) {
                Log.i(d.bNr + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.iQ(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean E(String str, boolean z) {
                return super.E(str, z);
            }
        });
        g gVar = new g();
        gVar.y(this.bNs.getPageContext().getPageActivity()).a(this.bNt).a(this.bqH.getSchemeCallback());
        gVar.a(this.bNs);
        a[] WX = gVar.WX();
        for (a aVar : WX) {
            this.bqH.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bqH, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bNx != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.gv(this.bNx), this.bNs.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bNw == ResultCode.h5UploadDone.code) {
            if (this.bNt != null) {
                this.bNt.eX(this.bNw);
                this.bNw = -1;
                return true;
            }
            return true;
        } else if (this.bqH.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bqH.canGoBack()) {
                this.bqH.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bqH != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bqH.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bqH.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bNA);
    }

    private int aT(String str, String str2) {
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
