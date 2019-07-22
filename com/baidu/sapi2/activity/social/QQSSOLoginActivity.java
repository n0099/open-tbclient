package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.tencent.connect.UnionInfo;
import com.tencent.open.SocialOperation;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QQSSOLoginActivity extends BaseSSOLoginActivity {
    private static final String DEFAULT_QQ_NOT_INSTALL_ERROR = "QQ未安装";
    private IUiListener qqLoginListener;

    /* loaded from: classes2.dex */
    public interface QrCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.b.sapi_sdk_title_login_qq);
        getQQSSOToken(new QrCallback() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QrCallback
            public void onSuccess(String str, String str2, String str3) {
                if (QQSSOLoginActivity.this.sapiWebView != null) {
                    QQSSOLoginActivity.this.sapiWebView.loadQQSSOLogin(QQSSOLoginActivity.this.getStatParamList(), str, str2, str3);
                }
            }

            @Override // com.baidu.sapi2.activity.social.QQSSOLoginActivity.QrCallback
            public void onFailure() {
                QQSSOLoginActivity.this.handleBack(QQSSOLoginActivity.this.businessFrom);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 11101 || i == 10102) {
            Tencent.onActivityResultData(i, i2, intent, this.qqLoginListener);
        }
    }

    private void getQQSSOToken(final QrCallback qrCallback) {
        final Tencent createInstance = Tencent.createInstance(SapiAccountManager.getInstance().getConfignation().qqAppID, this);
        if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
            Toast.makeText(this, DEFAULT_QQ_NOT_INSTALL_ERROR, 1).show();
            qrCallback.onFailure();
            return;
        }
        this.qqLoginListener = new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.2
            @Override // com.tencent.tauth.IUiListener
            public void onComplete(Object obj) {
                if (obj == null) {
                    qrCallback.onFailure();
                    return;
                }
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() == 0) {
                    qrCallback.onFailure();
                    return;
                }
                try {
                    String string = jSONObject.getString("access_token");
                    String string2 = jSONObject.getString("expires_in");
                    String string3 = jSONObject.getString("openid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                        createInstance.setAccessToken(string, string2);
                        createInstance.setOpenId(string3);
                        QQSSOLoginActivity.this.getQQUnionId(createInstance, qrCallback);
                    } else {
                        qrCallback.onFailure();
                    }
                } catch (Exception e) {
                    Log.e(e);
                    qrCallback.onFailure();
                }
            }

            @Override // com.tencent.tauth.IUiListener
            public void onError(UiError uiError) {
                qrCallback.onFailure();
            }

            @Override // com.tencent.tauth.IUiListener
            public void onCancel() {
                qrCallback.onFailure();
            }
        };
        createInstance.login(this, "all", this.qqLoginListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getQQUnionId(final Tencent tencent, final QrCallback qrCallback) {
        if (tencent != null && tencent.isSessionValid()) {
            new UnionInfo(this, tencent.getQQToken()).getUnionId(new IUiListener() { // from class: com.baidu.sapi2.activity.social.QQSSOLoginActivity.3
                @Override // com.tencent.tauth.IUiListener
                public void onError(UiError uiError) {
                    qrCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onComplete(Object obj) {
                    if (obj != null) {
                        qrCallback.onSuccess(tencent.getAccessToken(), tencent.getOpenId(), ((JSONObject) obj).optString(SocialOperation.GAME_UNION_ID));
                        return;
                    }
                    qrCallback.onFailure();
                }

                @Override // com.tencent.tauth.IUiListener
                public void onCancel() {
                    qrCallback.onFailure();
                }
            });
            return;
        }
        qrCallback.onFailure();
    }
}
