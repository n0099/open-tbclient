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
    public static String atj = "weblog";
    private ImageView BO;
    private BaseActivity atk;
    private e atl;
    private CommonWebLayout atm;
    private View atn;
    private TextView ato;
    private FrameLayout mContentView;
    private Context mContext;
    private Intent mIntent;
    private LinearLayout mRootView;
    private String mTitle;
    protected String mUrl;

    public d(BaseActivity baseActivity, e eVar, Intent intent) {
        this.atk = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.atl = eVar;
        this.mIntent = intent;
        init();
    }

    private void init() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_webview_layout, (ViewGroup) null);
        this.atk.setContentView(this.mRootView);
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
        this.ato = (TextView) this.mRootView.findViewById(a.g.tv_title);
        this.BO = (ImageView) this.mRootView.findViewById(a.g.img_back);
        this.BO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.web.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.atm.canGoBack()) {
                    d.this.atm.goBack();
                } else {
                    d.this.atl.cs(-1);
                }
            }
        });
        C(this.mIntent);
        initWebView();
        this.atm.loadUrl(this.mUrl);
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.mUrl = intent.getStringExtra("tag_url");
            if (TextUtils.isEmpty(this.mUrl)) {
                Toast.makeText(this.mContext, "参数错误", 0).show();
                this.atl.cs(-1);
            }
            this.mTitle = intent.getStringExtra("tag_url");
        }
    }

    private void initWebView() {
        this.atm = new CommonWebLayout(this.mContext);
        this.atm.setBackgroundColor(this.mContext.getResources().getColor(a.d.sdk_black_alpha0));
        this.atm.setCallback(new c() { // from class: com.baidu.live.view.web.d.2
            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void da(String str) {
                super.da(str);
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(0);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void cr(int i) {
                super.cr(i);
                if (i == 100 && d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void db(String str) {
                super.db(str);
                d.this.mUrl = str;
                if (Build.VERSION.SDK_INT >= 19) {
                    d.this.atm.evaluateJavascript("javascript:window.rmbCertifyDone != undefined", new ValueCallback<String>() { // from class: com.baidu.live.view.web.d.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                            Log.i(d.atj + "CommonWebController", "evaJS value:" + str2);
                            int i = -1;
                            try {
                                i = Integer.valueOf(str2).intValue();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (d.this.atl != null && i == 1) {
                                d.this.atl.cs(i);
                            }
                        }
                    });
                }
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void b(String str, int i, String str2) {
                super.b(str, i, str2);
                if (d.this.atn != null) {
                    d.this.atn.setVisibility(8);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public void dc(String str) {
                super.dc(str);
                if (d.this.ato != null) {
                    d.this.mTitle = str;
                    d.this.ato.setText(str);
                }
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean dd(String str) {
                Log.i(d.atj + "CommonWebController", "shouldOverrideUrlLoading url:" + str);
                return super.dd(str);
            }

            @Override // com.baidu.live.view.web.c, com.baidu.live.view.web.b
            public boolean i(String str, boolean z) {
                return super.i(str, z);
            }
        });
        f fVar = new f();
        fVar.az(this.atk.getPageContext().getPageActivity()).a(this.atl).a(this.atm.getSchemeCallback());
        a[] wP = fVar.wP();
        for (a aVar : wP) {
            this.atm.addJavascriptInterface(aVar, aVar.getName());
        }
        this.mContentView.addView(this.atm, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.atm.onKeyDown(i, keyEvent)) {
            return true;
        }
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.atm.canGoBack()) {
                this.atm.goBack();
                return true;
            } else if (this.atl != null) {
                this.atl.cs(-1);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25047 == i && intent != null) {
            if (intent.getIntExtra("resultCode", -1) == 0 && this.atm != null && !TextUtils.isEmpty(this.mUrl)) {
                Log.i(atj + "CommonWebController", "H5 onActivityResult mUrl:" + this.mUrl);
                this.atm.loadUrl(this.mUrl);
                showToast(this.mContext.getResources().getString(a.i.sdk_authen_suc), 17);
                return;
            }
            return;
        }
        this.atm.a(i, i2, intent);
    }

    private void showToast(String str, int i) {
        Toast makeText = Toast.makeText(this.mContext, (CharSequence) null, 0);
        makeText.setGravity(i, 0, 0);
        makeText.setText(str);
        makeText.show();
    }
}
