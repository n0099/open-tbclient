package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
/* loaded from: classes2.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    public Thread n;
    public boolean o;
    public c p;

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XiaomiOAuthFuture f9815a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                XiaomiSSOLoginActivity.this.p.a();
            }
        }

        /* renamed from: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0123b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f9818a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f9819b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f9820c;

            public RunnableC0123b(String str, String str2, String str3) {
                this.f9818a = str;
                this.f9819b = str2;
                this.f9820c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                XiaomiSSOLoginActivity.this.p.a(this.f9818a, this.f9819b, this.f9820c);
            }
        }

        public b(XiaomiOAuthFuture xiaomiOAuthFuture) {
            this.f9815a = xiaomiOAuthFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) this.f9815a.getResult();
                if (xiaomiOAuthResults.hasError()) {
                    new Handler(Looper.getMainLooper()).post(new a());
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0123b(xiaomiOAuthResults.getAccessToken(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()));
                }
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();

        void a(String str, String str2, String str3);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        Thread thread = this.n;
        if (thread == null || !thread.isAlive()) {
            return;
        }
        this.n.interrupt();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.o) {
            this.p.a();
        }
        this.o = true;
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(d.a.a0.a.j.a.sapi_sdk_title_login_xiaomi);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.p = new a();
        d();
    }

    private void d() {
        Thread thread = new Thread(new b(new XiaomiOAuthorize().setAppId(this.configuration.xiaomiAppID.longValue()).setUseSystemAccountLogin(true).setScope(new int[]{1, 3}).setRedirectUrl(this.configuration.xiaomiRedirectUri).startGetAccessToken(this)));
        this.n = thread;
        thread.start();
    }

    /* loaded from: classes2.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a(String str, String str2, String str3) {
            if (XiaomiSSOLoginActivity.this.sapiWebView != null) {
                SapiConfiguration sapiConfiguration = XiaomiSSOLoginActivity.this.configuration;
                SocialType socialType = SocialType.XIAOMI;
                XiaomiSSOLoginActivity.this.a(ParamsUtil.getUrlBind(sapiConfiguration, socialType, str, str2, XiaomiSSOLoginActivity.this.configuration.xiaomiAppID + ""), "小米授权登录中");
                XiaomiSSOLoginActivity.this.o = false;
            }
        }

        @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.c
        public void a() {
            XiaomiSSOLoginActivity xiaomiSSOLoginActivity = XiaomiSSOLoginActivity.this;
            xiaomiSSOLoginActivity.a(((BaseSSOLoginActivity) xiaomiSSOLoginActivity).f9790g);
        }
    }
}
