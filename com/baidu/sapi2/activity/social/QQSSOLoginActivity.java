package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.j.a.a.a;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.tencent.connect.UnionInfo;
import com.tencent.open.SocialOperation;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    private static final String DEFAULT_QQ_NOT_INSTALL_ERROR = "QQ未安装";
    private static final String TAG = QQSSOLoginActivity.class.getSimpleName();
    private IUiListener qqLoginListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface QqCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    private void getQQSSOToken(final QqCallback qqCallback) {
        final Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this, DEFAULT_QQ_NOT_INSTALL_ERROR, 1).show();
            qqCallback.onFailure();
            return;
        }
        this.qqLoginListener = new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.2
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
                } catch (Exception e) {
                    Log.e(e);
                    qqCallback.onFailure();
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qqCallback.onFailure();
            }
        };
        createInstance.login(this, "all", this.qqLoginListener);
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
                        qqCallback.onSuccess(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString(SocialOperation.GAME_UNION_ID));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d(TAG, "requestCode = " + i + " resultCode = " + i2 + " data = " + intent);
        if (i == 11101 || i == 10102) {
            Tencent.onActivityResultData(i, i2, intent, this.qqLoginListener);
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_qq);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        getQQSSOToken(new QqCallback() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QqCallback
            public void onFailure() {
                QQSSOLoginActivity qQSSOLoginActivity = QQSSOLoginActivity.this;
                qQSSOLoginActivity.handleBack(qQSSOLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QqCallback
            public void onSuccess(String str, String str2, String str3) {
                QQSSOLoginActivity.this.loadLoginInNA(ParamsUtil.getUrlQQBind(((SocialLoginBase) QQSSOLoginActivity.this).configuration, str, str2, str3), "授权QQ账号登录中");
            }
        });
    }
}
