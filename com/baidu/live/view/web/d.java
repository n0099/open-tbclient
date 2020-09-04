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
/* loaded from: classes7.dex */
public class d {
    public static String buV = "weblog";
    private BaseActivity buW;
    private f buX;
    private CommonWebLayout buY;
    private View buZ;
    private TextView bva;
    private RelativeLayout bvb;
    private int bvc;
    private int bve;
    private View bvf;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bvd = 0;
    private CustomMessageListener bvg = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.buY.canGoBack()) {
                d.this.buY.goBack();
            } else {
                d.this.buX.fA(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.buW = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.buX = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bvg);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.buW.setContentView(this.mRootView);
        this.bvf = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bvf.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bvf.setLayoutParams(layoutParams);
            this.bvf.setVisibility(0);
        } else {
            this.bvf.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.bva = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bvb = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bvc == ResultCode.h5UploadDone.code) {
                    if (d.this.buX != null) {
                        d.this.buX.fA(d.this.bvc);
                        d.this.bvc = -1;
                    }
                } else if (d.this.buY.canGoBack()) {
                    d.this.buY.goBack();
                } else {
                    d.this.buX.fA(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.buY.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.buX.fA(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bvd = aI(this.mUrl, "background");
            this.bve = aI(this.mUrl, "tintColor");
            if (this.bvd != 0) {
                this.bvb.setBackgroundColor(this.bvd);
                this.mRootView.setBackgroundColor(this.bvd);
            }
            if (this.bve != 0) {
                this.mBack.setColorFilter(this.bve);
                this.bva.setTextColor(this.bve);
            }
        }
    }

    private void initWebView() {
        this.buY = new CommonWebLayout(this.mContext);
        this.buY.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.buY.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ht(String str) {
                super.ht(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.buY.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.buV + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.buX == null || i != 1) {
                                d.this.bvc = -1;
                                return;
                            }
                            d.this.bvc = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.buY.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.buZ != null) {
                    d.this.buZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hu(String str) {
                super.hu(str);
                if (d.this.bva != null) {
                    d.this.mTitle = str;
                    d.this.bva.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean hv(String str) {
                Log.i(d.buV + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.hv(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean A(String str, boolean z) {
                return super.A(str, z);
            }
        });
        g gVar = new g();
        gVar.v(this.buW.getPageContext().getPageActivity()).a(this.buX).a(this.buY.getSchemeCallback());
        gVar.a(this.buW);
        a[] QV = gVar.QV();
        for (a aVar : QV) {
            this.buY.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.buY, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bvd != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.fz(this.bvd), this.buW.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bvc == ResultCode.h5UploadDone.code) {
            if (this.buX != null) {
                this.buX.fA(this.bvc);
                this.bvc = -1;
                return true;
            }
            return true;
        } else if (this.buY.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.buY.canGoBack()) {
                this.buY.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.buY != null && !TextUtils.isEmpty(this.mUrl)) {
                this.buY.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.buY.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bvg);
    }

    private int aI(String str, String str2) {
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
