package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.ImageUtil;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.CircleImageView;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ShareActivity extends Activity {
    private static final long MIN_INVOKE_INTER_TIME = 500;
    public static final String SHARE_ACCOUNT = "share_account";
    public static final String SHARE_FAIL_REASON = "share_fail_reason";
    public static final String TAG = ShareActivity.class.getSimpleName();
    private String currentAppName;
    private TextView displayName;
    private ImageView fromIcon;
    private TextView fromName;
    private ImageView leftBtnIv;
    private AsyncTask loadImageAsyncTask;
    private Dialog loadingDialog;
    private CircleImageView portrait;
    private TextView prompt;
    private TextView title;
    private ImageView toIcon;
    private TextView toName;
    private WebAuthListener webAuthListener;
    private boolean hasOpenLoginPage = false;
    private long lastInvokeTime = 0;
    private ShareResult shareResult = new ShareResult();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.f.layout_sapi_sdk_share_activity);
        if (checkSapiInit()) {
            SapiStatUtil.statShareV2Oauth();
            if (checkCallingPermission()) {
                initView();
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.hasOpenLoginPage) {
            if (SapiContext.getInstance(this).getCurrentAccount() != null) {
                getUserInfo();
                return;
            }
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
            this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.currentAppName));
            loginFail();
            return;
        }
        getUserInfo();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.webAuthListener = null;
    }

    private boolean checkCallingPermission() {
        String callingPackage = getCallingPackage();
        if (TextUtils.isEmpty(callingPackage)) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
            loginFail();
            return false;
        } else if (!new ShareCallPacking().checkPkgSign(this, callingPackage)) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
            loginFail();
            return false;
        } else {
            return true;
        }
    }

    private boolean checkSapiInit() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
        }
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            Log.e(TAG, "pass sdk have not been initialized");
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
            loginFail();
            return false;
        }
        return true;
    }

    private void initView() {
        ViewUtility.enableStatusBarTint(this, -1);
        this.leftBtnIv = (ImageView) findViewById(a.e.title_btn_left_iv);
        this.title = (TextView) findViewById(a.e.title);
        this.fromIcon = (ImageView) findViewById(a.e.sapi_share_accout_from_icon);
        this.toIcon = (ImageView) findViewById(a.e.sapi_share_accout_to_icon);
        this.fromName = (TextView) findViewById(a.e.sapi_share_accout_from_name);
        this.toName = (TextView) findViewById(a.e.sapi_share_accout_to_name);
        this.prompt = (TextView) findViewById(a.e.sapi_share_account_prompt);
        this.portrait = (CircleImageView) findViewById(a.e.sapi_share_account_portrait);
        this.displayName = (TextView) findViewById(a.e.sapi_share_account_displayname);
        this.leftBtnIv.setOnClickListener(new GoBackOnClick());
        findViewById(a.e.sapi_share_account_ok_btn).setOnClickListener(new OkBtnOnclick());
        this.title.setText("百度帐号登录");
        this.currentAppName = setAppIconAndNameByPkg(getPackageName(), this.fromIcon, this.fromName);
        setAppIconAndNameByPkg(getCallingPackage(), this.toIcon, this.toName);
        this.prompt.setText(getString(a.g.sapi_sdk_share_account_prompt));
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
        this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
        this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.currentAppName));
        loginFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GoBackOnClick implements View.OnClickListener {
        private GoBackOnClick() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ShareActivity.this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
            ShareActivity.this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, ShareActivity.this.currentAppName));
            ShareActivity.this.loginFail();
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
        if (System.currentTimeMillis() - this.lastInvokeTime >= MIN_INVOKE_INTER_TIME) {
            this.lastInvokeTime = System.currentTimeMillis();
            SapiStatUtil.statShareV2OauthSuc(this);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
            currentAccount.app = SapiUtils.getAppName(this);
            bundle.putParcelable(SHARE_ACCOUNT, currentAccount);
            bundle.putInt(ShareCallPacking.EXTRA_SDK_VERSION, 200);
            bundle.putString("PKG", getPackageName());
            if (SapiContext.getInstance(this).shareLivingunameEnable()) {
                bundle.putString("FACE_LOGIN_UID", SapiContext.getInstance(this).getFaceLoginUid());
                bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance(this).getV2FaceLivingUnames());
            }
            intent.putExtras(bundle);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFail() {
        SapiStatUtil.statShareV2OtherFail(this, this.shareResult.getResultCode());
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(SHARE_FAIL_REASON, this.shareResult.getResultMsg());
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
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
            loginFail();
            return;
        }
        this.hasOpenLoginPage = true;
        final boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        this.webAuthListener = new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z;
            }
        };
        PassportSDK.getInstance().startLogin(this, this.webAuthListener, webLoginDTO);
    }

    private void getUserInfo() {
        final SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        if (currentAccount == null) {
            if (this.hasOpenLoginPage) {
                this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
                this.shareResult.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, this.currentAppName));
                loginFail();
                return;
            }
            SapiStatUtil.statShareV2Invoke(this, "1");
            openLoginPage();
            return;
        }
        this.displayName.setText(currentAccount.displayname);
        SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.3
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                ShareActivity.this.loadingDialog = new LoadingDialog.Builder(ShareActivity.this).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                if (!ShareActivity.this.isFinishing() && !ShareActivity.this.loadingDialog.isShowing()) {
                    ShareActivity.this.loadingDialog.show();
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                ViewUtility.dismissDialog(ShareActivity.this, ShareActivity.this.loadingDialog);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                if (ShareActivity.this.hasOpenLoginPage) {
                    SapiStatUtil.statShareV2ActiveLoginSuc();
                } else {
                    SapiStatUtil.statShareV2Invoke(ShareActivity.this, "0");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                if (ShareActivity.this.hasOpenLoginPage) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("device", Build.MODEL);
                    hashMap.put("uid", currentAccount.uid);
                    hashMap.put("bduss", currentAccount.bduss);
                    StatService.onEvent("share_bduss_expired", hashMap, false);
                    ShareActivity.this.shareResult.setResultCode(ShareResult.ERROR_CODE_REASON_BDUSS_EXPIRED);
                    ShareActivity.this.loginFail();
                    return;
                }
                SapiStatUtil.statShareV2Invoke(ShareActivity.this, "2");
                ShareActivity.this.openLoginPage();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                HashMap hashMap = new HashMap();
                hashMap.put("device", Build.MODEL);
                hashMap.put("code", getUserInfoResult.getResultCode() + "");
                hashMap.put("msg", getUserInfoResult.getResultMsg());
                hashMap.put("has_active_network", SapiUtils.hasActiveNetwork(ShareActivity.this) + "");
                hashMap.put("network_type", SapiUtils.getNetworkClass(ShareActivity.this));
                StatService.onEvent("share_bduss_expired", hashMap, true);
                if (ShareActivity.this.hasOpenLoginPage) {
                    SapiStatUtil.statShareV2ActiveLoginSuc();
                } else {
                    SapiStatUtil.statShareV2Invoke(ShareActivity.this, "3");
                }
            }
        }, currentAccount.bduss);
    }
}
