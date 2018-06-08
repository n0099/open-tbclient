package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.c.a.a;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.ImageUtil;
import com.baidu.sapi2.views.CircleImageView;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
/* loaded from: classes2.dex */
public class ShareActivity extends Activity {
    private static final String REASON_BDUSS_EXPIRED = "互通登录失败，请换种登录方式";
    private static final String REASON_CANCLE = "您已取消%s授权登录";
    private static final String REASON_NETWORK_ERROR = "网络请求失败，请稍后再试";
    private static final String REASON_SIGN_ERROR = "互通登录失败，请从官方下载该应用";
    public static final String SHARE_ACCOUNT = "share_account";
    public static final String SHARE_FAIL_REASON = "share_fail_reason";
    private String currentAppName;
    private TextView displayName;
    private ImageView fromIcon;
    private TextView fromName;
    private boolean hasOpenLoginPage = false;
    private ImageView leftBtnIv;
    private AsyncTask loadImageAsyncTask;
    private Dialog loadingDialog;
    private CircleImageView portrait;
    private TextView prompt;
    private TextView title;
    private ImageView toIcon;
    private TextView toName;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_share_activity);
        checkCallingPermission();
        initView();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.hasOpenLoginPage) {
            if (SapiAccountManager.getInstance().isLogin()) {
                getUserInfo();
                return;
            }
            setResult(0);
            loginFail(REASON_CANCLE);
            return;
        }
        getUserInfo();
    }

    private void checkCallingPermission() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            loginFail(REASON_SIGN_ERROR);
        }
        if (!new ShareCallPacking().checkPkgSign(this, callingPackage)) {
            loginFail(REASON_SIGN_ERROR);
        }
    }

    private void initView() {
        this.leftBtnIv = (ImageView) findViewById(a.d.title_btn_left_iv);
        this.title = (TextView) findViewById(a.d.title);
        this.fromIcon = (ImageView) findViewById(a.d.sapi_share_accout_from_icon);
        this.toIcon = (ImageView) findViewById(a.d.sapi_share_accout_to_icon);
        this.fromName = (TextView) findViewById(a.d.sapi_share_accout_from_name);
        this.toName = (TextView) findViewById(a.d.sapi_share_accout_to_name);
        this.prompt = (TextView) findViewById(a.d.sapi_share_account_prompt);
        this.portrait = (CircleImageView) findViewById(a.d.sapi_share_account_portrait);
        this.displayName = (TextView) findViewById(a.d.sapi_share_account_displayname);
        this.leftBtnIv.setOnClickListener(new GoBackOnClick());
        findViewById(a.d.sapi_share_account_ok_btn).setOnClickListener(new OkBtnOnclick());
        this.title.setText("百度帐号登录");
        this.currentAppName = setAppIconAndNameByPkg(getPackageName(), this.fromIcon, this.fromName);
        setAppIconAndNameByPkg(getCallingPackage(), this.toIcon, this.toName);
        this.prompt.setText(getString(a.f.sapi_sdk_share_account_prompt));
        String stringExtra = getIntent().getStringExtra("android.intent.extra.TEXT");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.loadImageAsyncTask = ImageUtil.loadImage(stringExtra, new ImageUtil.ImageLoaderListener() { // from class: com.baidu.sapi2.activity.ShareActivity.1
                @Override // com.baidu.sapi2.utils.ImageUtil.ImageLoaderListener
                public void onSuccess(Bitmap bitmap) {
                    ShareActivity.this.portrait.setImageBitmap(bitmap);
                }

                @Override // com.baidu.sapi2.utils.ImageUtil.ImageLoaderListener
                public void onError(Exception exc) {
                    Log.e(exc);
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        loginFail(String.format(REASON_CANCLE, this.currentAppName));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GoBackOnClick implements View.OnClickListener {
        private GoBackOnClick() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareActivity.this.loginFail(String.format(ShareActivity.REASON_CANCLE, ShareActivity.this.currentAppName));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class OkBtnOnclick implements View.OnClickListener {
        private OkBtnOnclick() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareActivity.this.loginSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuccess() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SHARE_ACCOUNT, SapiAccountManager.getInstance().getSession());
        if (SapiContext.getInstance(this).shareLivingunameEnable()) {
            bundle.putString("FACE_LOGIN_UID", SapiContext.getInstance(this).getFaceLoginUid());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(SHARE_FAIL_REASON, str);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    private String setAppIconAndNameByPkg(String str, ImageView imageView, TextView textView) {
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            imageView.setImageDrawable(packageInfo.applicationInfo.loadIcon(packageManager));
            String charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            textView.setText(charSequence);
            return charSequence;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(e);
            return "";
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.loadImageAsyncTask != null && this.loadImageAsyncTask.getStatus() == AsyncTask.Status.RUNNING) {
            this.loadImageAsyncTask.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLoginPage() {
        this.hasOpenLoginPage = true;
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void getUserInfo() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            if (this.hasOpenLoginPage) {
                loginFail(String.format(REASON_CANCLE, this.currentAppName));
                return;
            } else {
                openLoginPage();
                return;
            }
        }
        this.displayName.setText(session.displayname);
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                ShareActivity.this.loadingDialog = new LoadingDialog.Builder(ShareActivity.this).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                ShareActivity.this.loadingDialog.show();
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                ViewUtility.dismissDialog(ShareActivity.this, ShareActivity.this.loadingDialog);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                if (ShareActivity.this.hasOpenLoginPage) {
                    ShareActivity.this.loginFail(ShareActivity.REASON_BDUSS_EXPIRED);
                } else {
                    ShareActivity.this.openLoginPage();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                ShareActivity.this.loginFail(ShareActivity.REASON_NETWORK_ERROR);
            }
        }, session.bduss);
    }
}
