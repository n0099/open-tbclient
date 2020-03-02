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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.ResultCode;
/* loaded from: classes3.dex */
public class d {
    public static String aGd = "weblog";
    private ImageView EU;
    private BaseActivity aGe;
    private e aGf;
    private CommonWebLayout aGg;
    private View aGh;
    private TextView aGi;
    private int aGj;
    private CustomMessageListener aGk = new CustomMessageListener(2913142) { // from class: com.baidu.live.view.web.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (d.this.aGg.canGoBack()) {
                d.this.aGg.goBack();
            } else {
                d.this.aGf.cY(-1);
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
        this.aGe = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.aGf = eVar;
        this.mIntent = intent;
        init();
        MessageManager.getInstance().registerListener(this.aGk);
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.aGe.setContentView(this.mRootView);
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
        this.aGi = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.EU = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.EU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aGj == ResultCode.h5UploadDone.code) {
                    if (d.this.aGf != null) {
                        d.this.aGf.cY(d.this.aGj);
                        d.this.aGj = -1;
                    }
                } else if (d.this.aGg.canGoBack()) {
                    d.this.aGg.goBack();
                } else {
                    d.this.aGf.cY(-1);
                }
            }
        });
        C(this.mIntent);
        initWebView();
        this.aGg.loadUrl(this.mUrl);
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.aGf.cY(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
        }
    }

    private void initWebView() {
        this.aGg = new CommonWebLayout(this.mContext);
        this.aGg.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.aGg.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void el(String str) {
                super.el(str);
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cX(int i) {
                super.cX(i);
                if (i == 100 && d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void em(String str) {
                super.em(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.aGg.evaluateJavascript("javascript:window.rmbCertifyDone", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            int i;
                            Log.i(d.aGd + "CommonWebController", "evaJS value:" + str2);
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                                i = -1;
                            }
                            if (d.this.aGf == null || i != 1) {
                                d.this.aGj = -1;
                                return;
                            }
                            d.this.aGj = ResultCode.h5UploadDone.code;
                        }
                    });
                }
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void c(String str, int i, String str2) {
                super.c(str, i, str2);
                if (d.this.aGh != null) {
                    d.this.aGh.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void en(String str) {
                super.en(str);
                if (d.this.aGi != null) {
                    d.this.mTitle = str;
                    d.this.aGi.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean eo(String str) {
                Log.i(d.aGd + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.eo(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean l(String str, boolean z) {
                return super.l(str, z);
            }
        });
        f fVar = new f();
        fVar.y(this.aGe.getPageContext().getPageActivity()).a(this.aGf).a(this.aGg.getSchemeCallback());
        a[] BC = fVar.BC();
        for (a aVar : BC) {
            this.aGg.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.aGg, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aGj == ResultCode.h5UploadDone.code) {
            if (this.aGf != null) {
                this.aGf.cY(this.aGj);
                this.aGj = -1;
                return true;
            }
            return true;
        } else if (this.aGg.onKeyDown(i, keyEvent)) {
            return true;
        } else {
            if (i == 4 && keyEvent.getRepeatCount() == 0 && this.aGg.canGoBack()) {
                this.aGg.goBack();
                return true;
            }
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if ((i2 == ResultCode.naCertifyDone.code || i2 == ResultCode.h5UploadDone.code) && this.aGg != null && !TextUtils.isEmpty(this.mUrl)) {
                this.aGg.loadUrl(this.mUrl);
                return;
            }
            return;
        }
        this.aGg.b(i, i2, intent);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aGk);
    }
}
