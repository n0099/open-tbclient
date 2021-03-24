package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.connect.UnionInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String DEFAULT_QQ_NOT_INSTALL_ERROR = "QQ未安装";
    public static final String TAG = QQSSOLoginActivity.class.getSimpleName();
    public IUiListener qqLoginListener;

    /* loaded from: classes2.dex */
    public interface QqCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    private void getQQSSOToken(final QqCallback qqCallback) {
        final Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this.configuration.context, DEFAULT_QQ_NOT_INSTALL_ERROR, 0).show();
            qqCallback.onFailure();
            return;
        }
        IUiListener iUiListener = new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.2
            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qqCallback.onFailure();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                if (obj == null) {
                    qqCallback.onFailure();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() == 0) {
                    qqCallback.onFailure();
                    return;
                }
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                        QQSSOLoginActivity.this.getQQUnionId(createInstance, qqCallback);
                    } else {
                        qqCallback.onFailure();
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    qqCallback.onFailure();
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qqCallback.onFailure();
            }
        };
        this.qqLoginListener = iUiListener;
        createInstance.login(this, "all", iUiListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQQUnionId(final Tencent tencent, final QqCallback qqCallback) {
        if (tencent != null && tencent.isSessionValid()) {
            new UnionInfo(this, tencent.getQQToken()).getUnionId(new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.3
                @Override // com.tencent.tauth.IUiListener
                public void onCancel() {
                    qqCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    if (obj != null) {
                        qqCallback.onSuccess(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString("unionid"));
                        return;
                    }
                    qqCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    qqCallback.onFailure();
                }
            });
            return;
        }
        qqCallback.onFailure();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        Log.d(str, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        if (i == 11101 || i == 10102) {
            Tencent.onActivityResultData(i, i2, intent, this.qqLoginListener);
        }
        if (this.mIsVerification && i == 11101 && i2 == 0) {
            setActivtyResult(3001);
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("QQ帐号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        getQQSSOToken(new QqCallback() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QqCallback
            public void onFailure() {
                QQSSOLoginActivity qQSSOLoginActivity = QQSSOLoginActivity.this;
                if (qQSSOLoginActivity.mIsVerification) {
                    qQSSOLoginActivity.setActivtyResult(3001);
                    QQSSOLoginActivity.this.finish();
                    return;
                }
                qQSSOLoginActivity.handleBack(qQSSOLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QqCallback
            public void onSuccess(String str, String str2, String str3) {
                QQSSOLoginActivity qQSSOLoginActivity = QQSSOLoginActivity.this;
                if (!qQSSOLoginActivity.mIsVerification) {
                    QQSSOLoginActivity.this.loadLoginInNA(ParamsUtil.getUrlQQBind(qQSSOLoginActivity.configuration, str, str2, str3), "授权QQ账号登录中");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, str);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_UNION_ID, str3);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "qzone");
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().qqAppID);
                QQSSOLoginActivity.this.setActivtyResult(3001, intent);
                QQSSOLoginActivity.this.finish();
            }
        });
    }
}
