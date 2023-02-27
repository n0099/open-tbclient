package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.DoubleListCallback;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DoubleListActivity extends SlideActiviy {
    public DoubleListCallback C;
    public ChangeUserNameDTO D;

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
        DoubleListCallback doubleListCallback = this.C;
        if (doubleListCallback != null) {
            doubleListCallback.onFinish();
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

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.mTitleLayout.setVisibility(8);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.DoubleListActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                DoubleListActivity.this.a();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.DoubleListActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                DoubleListActivity.this.onClose();
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() { // from class: com.baidu.sapi2.activity.DoubleListActivity.3
            @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(DoubleListActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                DoubleListActivity.this.startActivity(intent);
            }
        });
        b();
    }

    private void b() {
        HashMap<String, String> hashMap;
        JSONObject jSONObject = new JSONObject();
        ChangeUserNameDTO changeUserNameDTO = this.D;
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
        this.sapiWebView.loadDoubleListUrl(arrayList);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void loadSlideWebview(String str, String str2, String str3) {
        Intent intent = new Intent(this, LoadExternalWebViewActivity.class);
        Uri.parse(str2);
        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
        intent.putExtra("extra_external_url", str2);
        startActivity(intent);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.C = CoreViewRouter.getInstance().getDoubleListCallback();
            this.D = CoreViewRouter.getInstance().getChangeUserNameDTO();
            CoreViewRouter.getInstance().releaseDoubleListCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            DoubleListCallback doubleListCallback = this.C;
            if (doubleListCallback != null) {
                doubleListCallback.onFinish();
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }
}
