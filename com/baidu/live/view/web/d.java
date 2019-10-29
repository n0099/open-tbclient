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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class d {
    public static String atB = "weblog";
    private ImageView Co;
    private BaseActivity atC;
    private e atD;
    private CommonWebLayout atE;
    private View atF;
    private TextView atG;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;

    public d(BaseActivity baseActivity, e eVar, Intent intent) {
        this.atC = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.atD = eVar;
        this.mIntent = intent;
        init();
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.atC.setContentView(this.mRootView);
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
        this.atG = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.Co = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.Co.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.atE.canGoBack()) {
                    d.this.atE.goBack();
                } else {
                    d.this.atD.cs(-1);
                }
            }
        });
        C(this.mIntent);
        initWebView();
        this.atE.loadUrl(this.mUrl);
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.atD.cs(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
        }
    }

    private void initWebView() {
        this.atE = new CommonWebLayout(this.mContext);
        this.atE.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.atE.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.atE.evaluateJavascript("javascript:window.rmbCertifyDone != undefined", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            Log.i(d.atB + "CommonWebController", "evaJS value:" + str2);
                            int i = -1;
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (d.this.atD != null && i == 1) {
                                d.this.atD.cs(i);
                            }
                        }
                    });
                }
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.atF != null) {
                    d.this.atF.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dc(String str) {
                super.dc(str);
                if (d.this.atG != null) {
                    d.this.mTitle = str;
                    d.this.atG.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean dd(String str) {
                Log.i(d.atB + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.dd(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean i(String str, boolean z) {
                return super.i(str, z);
            }
        });
        f fVar = new f();
        fVar.az(this.atC.getPageContext().getPageActivity()).a(this.atD).a(this.atE.getSchemeCallback());
        a[] wO = fVar.wO();
        for (a aVar : wO) {
            this.atE.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.atE, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.atE.onKeyDown(i, keyEvent)) {
            return true;
        }
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.atE.canGoBack()) {
                this.atE.goBack();
                return true;
            } else if (this.atD != null) {
                this.atD.cs(-1);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if (intent.getIntExtra("resultCode", -1) == 0 && this.atE != null && !TextUtils.isEmpty(this.mUrl)) {
                Log.i(atB + "CommonWebController", "H5 onActivityResult mUrl:" + this.mUrl);
                this.atE.loadUrl(this.mUrl);
                showToast(this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                return;
            }
            return;
        }
        this.atE.a(i, i2, intent);
    }

    private void showToast(String str, int i) {
        Toast makeText = Toast.makeText(this.mContext, (CharSequence) null, 0);
        makeText.setGravity(i, 0, 0);
        makeText.setText(str);
        makeText.show();
    }
}
