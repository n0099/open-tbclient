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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.ResultCode;
/* loaded from: classes2.dex */
public class d {
    public static String aBV = "weblog";
    private ImageView Ez;
    private BaseActivity aBW;
    private e aBX;
    private CommonWebLayout aBY;
    private View aBZ;
    private TextView aCa;
    private int aCb;
    private CustomMessageListener aCc = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.aBY.canGoBack()) {
                d.this.aBY.goBack();
            } else {
                d.this.aBX.cI(-1);
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
        this.aBW = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aBX = eVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.aCc);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.aBW.setContentView(this.mRootView);
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
        this.aCa = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.Ez = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.Ez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aCb == ResultCode.h5UploadDone.code) {
                    if (d.this.aBX != null) {
                        d.this.aBX.cI(d.this.aCb);
                        d.this.aCb = -1;
                    }
                } else if (d.this.aBY.canGoBack()) {
                    d.this.aBY.goBack();
                } else {
                    d.this.aBX.cI(-1);
                }
            }
        });
        C(this.mIntent);
        initWebView();
        this.aBY.loadUrl(this.mUrl);
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.aBX.cI(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
        }
    }

    private void initWebView() {
        this.aBY = new CommonWebLayout(this.mContext);
        this.aBY.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.aBY.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dW(String str) {
                super.dW(str);
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cH(int i) {
                super.cH(i);
                if (i == 100 && d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dX(String str) {
                super.dX(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.aBY.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.aBV + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.aBX == null || i != 1) {
                                d.this.aCb = -1;
                                return;
                            }
                            d.this.aCb = ResultCode.h5UploadDone.code;
                        }
                    });
                }
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.aBZ != null) {
                    d.this.aBZ.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dY(String str) {
                super.dY(str);
                if (d.this.aCa != null) {
                    d.this.mTitle = str;
                    d.this.aCa.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean dZ(String str) {
                Log.i(d.aBV + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.dZ(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean l(String str, boolean z) {
                return super.l(str, z);
            }
        });
        f fVar = new f();
        fVar.x(this.aBW.getPageContext().getPageActivity()).a(this.aBX).a(this.aBY.getSchemeCallback());
        a[] zk = fVar.zk();
        for (a aVar : zk) {
            this.aBY.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.aBY, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aCb == ResultCode.h5UploadDone.code) {
            if (this.aBX != null) {
                this.aBX.cI(this.aCb);
                this.aCb = -1;
                return true;
            }
            return true;
        } else if (this.aBY.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.aBY.canGoBack()) {
                this.aBY.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.aBY != null && !TextUtils.isEmpty(this.mUrl)) {
                this.aBY.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.aBY.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aCc);
    }
}
