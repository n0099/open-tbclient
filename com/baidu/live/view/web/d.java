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
    public static String byk = "weblog";
    private CommonWebLayout bjO;
    private View bjP;
    private BaseActivity byl;
    private f bym;
    private TextView byn;
    private RelativeLayout byo;
    private int byp;
    private int byr;
    private View bys;
    private ImageView mBack;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int byq = 0;
    private CustomMessageListener byt = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bjO.canGoBack()) {
                d.this.bjO.goBack();
            } else {
                d.this.bym.eL(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.byl = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bym = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.byt);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.byl.setContentView(this.mRootView);
        this.bys = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bys.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bys.setLayoutParams(layoutParams);
            this.bys.setVisibility(0);
        } else {
            this.bys.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.byn = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.byo = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.mBack = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.byp == ResultCode.h5UploadDone.code) {
                    if (d.this.bym != null) {
                        d.this.bym.eL(d.this.byp);
                        d.this.byp = -1;
                    }
                } else if (d.this.bjO.canGoBack()) {
                    d.this.bjO.goBack();
                } else {
                    d.this.bym.eL(-1);
                }
            }
        });
        k(this.mIntent);
        initWebView();
        this.bjO.loadUrl(this.mUrl);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, PASSMethodCallTransfer.DynamicCallbak.ERROR_MSG_PARAMS_ERROR, 0).show();
                this.bym.eL(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.byq = aI(this.mUrl, "background");
            this.byr = aI(this.mUrl, "tintColor");
            if (this.byq != 0) {
                this.byo.setBackgroundColor(this.byq);
                this.mRootView.setBackgroundColor(this.byq);
            }
            if (this.byr != 0) {
                this.mBack.setColorFilter(this.byr);
                this.byn.setTextColor(this.byr);
            }
        }
    }

    private void initWebView() {
        this.bjO = new CommonWebLayout(this.mContext);
        this.bjO.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bjO.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ho(String str) {
                super.ho(str);
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void eO(int i) {
                super.eO(i);
                if (i == 100 && d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hp(String str) {
                super.hp(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bjO.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.byk + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bym == null || i != 1) {
                                d.this.byp = -1;
                                return;
                            }
                            d.this.byp = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bjO.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bjP != null) {
                    d.this.bjP.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void hQ(String str) {
                super.hQ(str);
                if (d.this.byn != null) {
                    d.this.mTitle = str;
                    d.this.byn.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean hR(String str) {
                Log.i(d.byk + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.hR(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean A(String str, boolean z) {
                return super.A(str, z);
            }
        });
        g gVar = new g();
        gVar.w(this.byl.getPageContext().getPageActivity()).a(this.bym).a(this.bjO.getSchemeCallback());
        gVar.a(this.byl);
        a[] RE = gVar.RE();
        for (a aVar : RE) {
            this.bjO.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bjO, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.byq != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.fJ(this.byq), this.byl.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.byp == ResultCode.h5UploadDone.code) {
            if (this.bym != null) {
                this.bym.eL(this.byp);
                this.byp = -1;
                return true;
            }
            return true;
        } else if (this.bjO.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bjO.canGoBack()) {
                this.bjO.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bjO != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bjO.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bjO.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.byt);
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
