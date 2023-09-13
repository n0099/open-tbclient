package com.baidu.sapi2.activity.social;

import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    public Thread n;
    public c o;

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void a(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ XiaomiOAuthFuture a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                XiaomiSSOLoginActivity.this.o.a();
            }
        }

        /* renamed from: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0132b implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public RunnableC0132b(String str, String str2, String str3) {
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                XiaomiSSOLoginActivity.this.o.a(this.a, this.b, this.c);
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                XiaomiSSOLoginActivity.this.o.a();
            }
        }

        public b(XiaomiOAuthFuture xiaomiOAuthFuture) {
            this.a = xiaomiOAuthFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) this.a.getResult();
                if (xiaomiOAuthResults.hasError()) {
                    new Handler(Looper.getMainLooper()).post(new a());
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0132b(xiaomiOAuthResults.getCode(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()));
                }
            } catch (OperationCanceledException e) {
                new Handler(Looper.getMainLooper()).post(new c());
                Log.e(e);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a() {
            XiaomiSSOLoginActivity xiaomiSSOLoginActivity = XiaomiSSOLoginActivity.this;
            xiaomiSSOLoginActivity.a(((BaseSSOLoginActivity) xiaomiSSOLoginActivity).g);
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a(String str, String str2, String str3) {
            if (XiaomiSSOLoginActivity.this.sapiWebView != null) {
                SapiConfiguration sapiConfiguration = XiaomiSSOLoginActivity.this.configuration;
                SocialType socialType = SocialType.XIAOMI;
                String urlBind = ParamsUtil.getUrlBind(sapiConfiguration, socialType, "", str2, XiaomiSSOLoginActivity.this.configuration.xiaomiAppID + "");
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("redirect_uri", XiaomiSSOLoginActivity.this.configuration.xiaomiRedirectUri);
                XiaomiSSOLoginActivity.this.a(ParamsUtil.addExtras(urlBind, hashMap), "小米授权登录中");
            }
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        Thread thread = this.n;
        if (thread != null && thread.isAlive()) {
            this.n.interrupt();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_xiaomi);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.o = new a();
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    private void d() {
        Thread thread = new Thread(new b(new XiaomiOAuthorize().setAppId(this.configuration.xiaomiAppID.longValue()).setUseSystemAccountLogin(true).setScope(new int[]{1, 3}).setRedirectUrl(this.configuration.xiaomiRedirectUri).startGetOAuthCode(this)));
        this.n = thread;
        thread.start();
    }
}
