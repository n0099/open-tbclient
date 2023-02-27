package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.ChangeUsernameResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChangeUserNameActivity extends BaseActivity {
    public ChangeUsernameCallback t;
    public ChangeUserNameDTO u;
    public ChangeUsernameResult v;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        if (this.v == null) {
            ChangeUsernameResult changeUsernameResult = new ChangeUsernameResult();
            this.v = changeUsernameResult;
            changeUsernameResult.setResultCode(-301);
            this.v.setResultMsg("您已取消操作");
        }
        ChangeUsernameCallback changeUsernameCallback = this.t;
        if (changeUsernameCallback != null) {
            changeUsernameCallback.onFinish(this.v);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    private void b() {
        HashMap<String, String> hashMap;
        JSONObject jSONObject = new JSONObject();
        ChangeUserNameDTO changeUserNameDTO = this.u;
        if (changeUserNameDTO != null && (hashMap = changeUserNameDTO.extraParams) != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("loadChangeUsernameUrl params is error", new Object[0]);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientParamsObj", jSONObject.toString()));
        this.sapiWebView.loadChangeUsernameUrl(arrayList);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.t = CoreViewRouter.getInstance().getChangeUsernameCallback();
            this.u = CoreViewRouter.getInstance().getChangeUserNameDTO();
            CoreViewRouter.getInstance().releaseChangeUsernameCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            ChangeUsernameResult changeUsernameResult = new ChangeUsernameResult();
            this.v = changeUsernameResult;
            changeUsernameResult.setResultCode(-202);
            this.v.setResultMsg("网络连接失败，请检查网络设置");
            ChangeUsernameCallback changeUsernameCallback = this.t;
            if (changeUsernameCallback != null) {
                changeUsernameCallback.onFinish(this.v);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.ChangeUserNameActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                ChangeUserNameActivity.this.a();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.ChangeUserNameActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                ChangeUserNameActivity.this.onClose();
            }
        });
        this.sapiWebView.setSyncAccountCallback(new SapiJsCallBacks.SyncAccountCallBack() { // from class: com.baidu.sapi2.activity.ChangeUserNameActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.SyncAccountCallBack
            public void onSyncAccount(SapiAccount sapiAccount) {
                ChangeUserNameActivity.this.v = new ChangeUsernameResult();
                ChangeUserNameActivity.this.v.setResultCode(110000);
                ChangeUserNameActivity.this.v.setResultMsg("成功");
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.ChangeUserNameActivity.4
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(ChangeUserNameActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                ChangeUserNameActivity.this.startActivity(intent);
            }
        });
        this.sapiWebView.setOpenDuVipPayCallback(new SapiJsCallBacks.OpenDuVipPayCallback() { // from class: com.baidu.sapi2.activity.ChangeUserNameActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.OpenDuVipPayCallback
            public void onOpenDuVipPay(LoadDuVipPayCallBack loadDuVipPayCallBack) {
                if (ChangeUserNameActivity.this.t != null) {
                    ChangeUserNameActivity.this.t.onOpenDuVipPay(loadDuVipPayCallBack);
                }
            }
        });
        b();
    }
}
