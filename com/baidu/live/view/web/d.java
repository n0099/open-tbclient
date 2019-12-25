package com.baidu.live.view.web;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.ResultCode;
/* loaded from: classes2.dex */
public class d {
    public static String aBd = "weblog";
    private ImageView Eu;
    private BaseActivity aBe;
    private e aBf;
    private CommonWebLayout aBg;
    private View aBh;
    private TextView aBi;
    private int aBj;
    private CustomMessageListener aBk = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.aBg.canGoBack()) {
                d.this.aBg.goBack();
            } else {
                d.this.aBf.cH(-1);
            }
        }
    };
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;

    public d(BaseActivity baseActivity, e eVar, Intent intent) {
        this.aBe = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aBf = eVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.aBk);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.aBe.setContentView(this.mRootView);
        View findViewById = this.mRootView.findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.mContentView = (FrameLayout) this.mRootView.findViewById(a.g.contentView);
        this.aBi = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.Eu = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.Eu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aBj == ResultCode.h5UploadDone.code) {
                    if (d.this.aBf != null) {
                        d.this.aBf.cH(d.this.aBj);
                        d.this.aBj = -1;
                    }
                } else if (d.this.aBg.canGoBack()) {
                    d.this.aBg.goBack();
                } else {
                    d.this.aBf.cH(-1);
                }
            }
        });
        C(this.mIntent);
        initWebView();
        this.aBg.loadUrl(this.mUrl);
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.aBf.cH(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
        }
    }

    private void initWebView() {
        this.aBg = new CommonWebLayout(this.mContext);
        this.aBg.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.aBg.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dU(String str) {
                super.dU(str);
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cG(int i) {
                super.cG(i);
                if (i == 100 && d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dV(String str) {
                super.dV(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.aBg.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.aBd + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.aBf == null || i != 1) {
                                d.this.aBj = -1;
                                return;
                            }
                            d.this.aBj = ResultCode.h5UploadDone.code;
                        }
                    });
                }
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.aBh != null) {
                    d.this.aBh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dW(String str) {
                super.dW(str);
                if (d.this.aBi != null) {
                    d.this.mTitle = str;
                    d.this.aBi.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean dX(String str) {
                Log.i(d.aBd + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.dX(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean l(String str, boolean z) {
                return super.l(str, z);
            }
        });
        f fVar = new f();
        fVar.x(this.aBe.getPageContext().getPageActivity()).a(this.aBf).a(this.aBg.getSchemeCallback());
        a[] yO = fVar.yO();
        for (a aVar : yO) {
            this.aBg.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.aBg, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aBj == ResultCode.h5UploadDone.code) {
            if (this.aBf != null) {
                this.aBf.cH(this.aBj);
                this.aBj = -1;
                return true;
            }
            return true;
        } else if (this.aBg.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.aBg.canGoBack()) {
                this.aBg.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.aBg != null && !TextUtils.isEmpty(this.mUrl)) {
                this.aBg.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.aBg.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBk);
    }
}
