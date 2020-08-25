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
    public static String buS = "weblog";
    private BaseActivity buT;
    private f buU;
    private CommonWebLayout buV;
    private View buW;
    private TextView buX;
    private RelativeLayout buY;
    private int buZ;
    private int bvb;
    private View bvc;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bva = 0;
    private CustomMessageListener bvd = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.buV.canGoBack()) {
                d.this.buV.goBack();
            } else {
                d.this.buU.fA(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.buT = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.buU = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bvd);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.buT.setContentView(this.mRootView);
        this.bvc = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bvc.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bvc.setLayoutParams(layoutParams);
            this.bvc.setVisibility(0);
        } else {
            this.bvc.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.buX = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.buY = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.buZ == ResultCode.h5UploadDone.code) {
                    if (d.this.buU != null) {
                        d.this.buU.fA(d.this.buZ);
                        d.this.buZ = -1;
                    }
                } else if (d.this.buV.canGoBack()) {
                    d.this.buV.goBack();
                } else {
                    d.this.buU.fA(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.buV.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.buU.fA(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bva = aI(this.mUrl, "background");
            this.bvb = aI(this.mUrl, "tintColor");
            if (this.bva != 0) {
                this.buY.setBackgroundColor(this.bva);
                this.mRootView.setBackgroundColor(this.bva);
            }
            if (this.bvb != 0) {
                this.mBack.setColorFilter(this.bvb);
                this.buX.setTextColor(this.bvb);
            }
        }
    }

    private void initWebView() {
        this.buV = new CommonWebLayout(this.mContext);
        this.buV.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.buV.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hr(String str) {
                super.hr(str);
                if (d.this.buW != null) {
                    d.this.buW.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fy(int i) {
                super.fy(i);
                if (i == 100 && d.this.buW != null) {
                    d.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hs(String str) {
                super.hs(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.buV.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.buS + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.buU == null || i != 1) {
                                d.this.buZ = -1;
                                return;
                            }
                            d.this.buZ = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.buV.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.buW != null) {
                    d.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.buW != null) {
                    d.this.buW.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ht(String str) {
                super.ht(str);
                if (d.this.buX != null) {
                    d.this.mTitle = str;
                    d.this.buX.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean hu(String str) {
                Log.i(d.buS + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.hu(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean A(String str, boolean z) {
                return super.A(str, z);
            }
        });
        g gVar = new g();
        gVar.v(this.buT.getPageContext().getPageActivity()).a(this.buU).a(this.buV.getSchemeCallback());
        gVar.a(this.buT);
        a[] QV = gVar.QV();
        for (a aVar : QV) {
            this.buV.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.buV, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bva != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.fz(this.bva), this.buT.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.buZ == ResultCode.h5UploadDone.code) {
            if (this.buU != null) {
                this.buU.fA(this.buZ);
                this.buZ = -1;
                return true;
            }
            return true;
        } else if (this.buV.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.buV.canGoBack()) {
                this.buV.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.buV != null && !TextUtils.isEmpty(this.mUrl)) {
                this.buV.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.buV.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bvd);
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
