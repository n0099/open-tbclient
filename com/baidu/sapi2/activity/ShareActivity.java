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
import com.baidu.ar.constants.HttpConstants;
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
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.ImageUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.CircleImageView;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ShareActivity extends Activity {
    private static final String REASON_BDUSS_EXPIRED = "互通登录失败，请换种登录方式";
    private static final String REASON_CANCLE = "您已取消%s授权登录";
    private static final String REASON_NETWORK_ERROR = "网络请求失败，请稍后再试";
    private static final String REASON_SDK_NOT_INIT = "互通请求失败，请换种登录方式";
    private static final String REASON_SIGN_ERROR = "互通登录失败，该应用暂未授权";
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
        checkSapiInit();
        initView();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.hasOpenLoginPage) {
            if (SapiContext.getInstance(this).getCurrentAccount() != null) {
                getUserInfo();
                return;
            } else {
                loginFail(String.format(REASON_CANCLE, this.currentAppName));
                return;
            }
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

    private void checkSapiInit() {
        if (SapiAccountManager.getInstance().getConfignation() == null && SapiAccountManager.getReceiveShareListener() != null) {
            SapiAccountManager.getReceiveShareListener().onReceiveShare();
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
        bundle.putParcelable(SHARE_ACCOUNT, SapiContext.getInstance(this).getCurrentAccount());
        boolean shareFaceLoginEnable = SapiContext.getInstance(this).getShareFaceLoginEnable();
        if (SapiContext.getInstance(this).shareLivingunameEnable() || shareFaceLoginEnable) {
            bundle.putString("FACE_LOGIN_UID", SapiContext.getInstance(this).getFaceLoginUid());
        }
        if (shareFaceLoginEnable) {
            String faceLoginModel = SapiContext.getInstance(this).getFaceLoginModel();
            if (new FaceLoginService().convertResult2Model(faceLoginModel) != null) {
                bundle.putString("FACE_LOGIN_MODEL", faceLoginModel);
            }
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
        if (SapiAccountManager.getInstance().getConfignation() == null) {
            loginFail(REASON_SDK_NOT_INIT);
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
        PassportSDK.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.ShareActivity.2
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
        }, webLoginDTO);
    }

    private void getUserInfo() {
        final SapiAccount currentAccount = SapiContext.getInstance(this).getCurrentAccount();
        if (currentAccount == null) {
            if (this.hasOpenLoginPage) {
                loginFail(String.format(REASON_CANCLE, this.currentAppName));
                return;
            } else {
                openLoginPage();
                return;
            }
        }
        this.displayName.setText(currentAccount.displayname);
        if (SapiAccountManager.getInstance().getConfignation() != null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.activity.ShareActivity.3
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
                    if (!ShareActivity.this.hasOpenLoginPage) {
                        ShareActivity.this.openLoginPage();
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("device", Build.MODEL);
                    hashMap.put("uid", currentAccount.uid);
                    hashMap.put("bduss", currentAccount.bduss);
                    StatService.onEvent("share_bduss_expired", hashMap, false);
                    ShareActivity.this.loginFail(ShareActivity.REASON_BDUSS_EXPIRED);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("device", Build.MODEL);
                    hashMap.put("code", getUserInfoResult.getResultCode() + "");
                    hashMap.put("msg", getUserInfoResult.getResultMsg());
                    hashMap.put("has_active_network", SapiUtils.hasActiveNetwork(ShareActivity.this) + "");
                    hashMap.put(HttpConstants.NETWORK_TYPE, SapiUtils.getNetworkClass(ShareActivity.this));
                    StatService.onEvent("share_bduss_expired", hashMap, true);
                    ShareActivity.this.loginSuccess();
                }
            }, currentAccount.bduss);
        }
    }
}
