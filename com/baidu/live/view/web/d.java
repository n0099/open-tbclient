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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    public static String bcc = "weblog";
    private ImageView Yj;
    private BaseActivity bcd;
    private f bce;
    private CommonWebLayout bcf;
    private View bcg;
    private TextView bch;
    private RelativeLayout bci;
    private int bcj;
    private int bcl;
    private View bcm;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;
    private int bck = 0;
    private CustomMessageListener bcn = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.bcf.canGoBack()) {
                d.this.bcf.goBack();
            } else {
                d.this.bce.mo22do(-1);
            }
        }
    };

    public d(BaseActivity baseActivity, f fVar, Intent intent) {
        this.bcd = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.bce = fVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.bcn);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.bcd.setContentView(this.mRootView);
        this.bcm = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.bcm.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.bcm.setLayoutParams(layoutParams);
            this.bcm.setVisibility(0);
        } else {
            this.bcm.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.bch = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.bci = (RelativeLayout) this.mRootView.findViewById(a.g.title);
        this.Yj = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.Yj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bcj == ResultCode.h5UploadDone.code) {
                    if (d.this.bce != null) {
                        d.this.bce.mo22do(d.this.bcj);
                        d.this.bcj = -1;
                    }
                } else if (d.this.bcf.canGoBack()) {
                    d.this.bcf.goBack();
                } else {
                    d.this.bce.mo22do(-1);
                }
            }
        });
        B(this.mIntent);
        initWebView();
        this.bcf.loadUrl(this.mUrl);
    }

    private void B(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.bce.mo22do(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
            this.bck = an(this.mUrl, "background");
            this.bcl = an(this.mUrl, "tintColor");
            if (this.bck != 0) {
                this.bci.setBackgroundColor(this.bck);
                this.mRootView.setBackgroundColor(this.bck);
            }
            if (this.bcl != 0) {
                this.Yj.setColorFilter(this.bcl);
                this.bch.setTextColor(this.bcl);
            }
        }
    }

    private void initWebView() {
        this.bcf = new CommonWebLayout(this.mContext);
        this.bcf.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.bcf.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fd(String str) {
                super.fd(str);
                if (d.this.bcg != null) {
                    d.this.bcg.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dm(int i) {
                super.dm(i);
                if (i == 100 && d.this.bcg != null) {
                    d.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void fe(String str) {
                super.fe(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.bcf.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.bcc + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.bce == null || i != 1) {
                                d.this.bcj = -1;
                                return;
                            }
                            d.this.bcj = ResultCode.h5UploadDone.code;
                        }
                    });
                    d.this.bcf.evaluateJavascript("javascript:window.isSuperCustomer", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.2
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
                if (d.this.bcg != null) {
                    d.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.bcg != null) {
                    d.this.bcg.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void ff(String str) {
                super.ff(str);
                if (d.this.bch != null) {
                    d.this.mTitle = str;
                    d.this.bch.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean fg(String str) {
                Log.i(d.bcc + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.fg(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean p(String str, boolean z) {
                return super.p(str, z);
            }
        });
        g gVar = new g();
        gVar.u(this.bcd.getPageContext().getPageActivity()).a(this.bce).a(this.bcf.getSchemeCallback());
        a[] HN = gVar.HN();
        for (a aVar : HN) {
            this.bcf.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.bcf, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        if (this.bck != 0) {
            UtilHelper.changeStatusBarIconAndTextColor(e.dn(this.bck), this.bcd.getActivity());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bcj == ResultCode.h5UploadDone.code) {
            if (this.bce != null) {
                this.bce.mo22do(this.bcj);
                this.bcj = -1;
                return true;
            }
            return true;
        } else if (this.bcf.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.bcf.canGoBack()) {
                this.bcf.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.bcf != null && !TextUtils.isEmpty(this.mUrl)) {
                this.bcf.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.bcf.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bcn);
    }

    private int an(String str, String str2) {
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
