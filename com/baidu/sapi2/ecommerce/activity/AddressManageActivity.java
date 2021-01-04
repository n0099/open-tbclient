package com.baidu.sapi2.ecommerce.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.l.a.a;
import com.baidu.pass.ecommerce.d.b;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.ecommerce.EcommerceRouter;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class AddressManageActivity extends SlideActiviy {
    private static final String ADDRESS_MANAGE_ACTIVITY = "AddressManageActivity";
    private static final String CREATE_EXTRA = "create_extra";
    private static final String EXTRA_ADAPTER = "extra_adapter";
    private static final String EXTRA_PARAMS_TYPE = "select";
    private static final String EXTRA_PARAMS_USESPEECH = "useSpeech";
    private static final String KEY_QUIT_ADDRESS_MODULE = "quit";
    private static final String TAG = AddressManageActivity.class.getSimpleName();
    private String adapter;
    private AddressManageCallback addressManageCallback;
    private AddressManageDTO addressManageDTO;
    private b recognitionDialog;
    private AddressManageCallback.VoiceRecognitionResult recognitionResult;
    private SapiJsCallBacks.SpeechRecognitionResult speechRecognitionResult;
    private AddressManageResult addressManageResult = new AddressManageResult();
    private boolean isEditPage = false;
    private int speechErrorNo = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void back() {
        if (this.isEditPage) {
            this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
        } else if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            this.addressManageResult.setResultCode(-301);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSpeechPermission(final boolean z) {
        PermissionsDTO permissionsDTO = this.addressManageDTO.permissionsDTO;
        if (permissionsDTO != null) {
            permissionsDTO.context = this;
            permissionsDTO.dialogTitle = TextUtils.isEmpty(permissionsDTO.dialogTitle) ? "麦克风权限" : permissionsDTO.dialogTitle;
            permissionsDTO.dialogMsg = TextUtils.isEmpty(permissionsDTO.dialogMsg) ? "为了正常使用语音录入服务，请允许使用麦克风权限。你可以通过系统\"设置\"进行权限的管理" : permissionsDTO.dialogMsg;
            permissionsDTO.showExplainDialogAfterForbid = false;
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.6
                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    if (i == -1) {
                        if (z) {
                            AddressManageActivity.this.showSpeechBox();
                            return;
                        }
                        return;
                    }
                    AddressManageActivity.this.speechRecognitionResult.setSpeechData(1, "");
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    if (z) {
                        AddressManageActivity.this.showSpeechBox();
                        return;
                    }
                    AddressManageActivity.this.addressManageCallback.onStartSpeech(AddressManageActivity.this.recognitionResult);
                    AddressManageActivity.this.recognitionDialog.b(0);
                    AddressManageActivity.this.recognitionDialog.a();
                }
            });
            return;
        }
        showSpeechBox();
        Log.d(TAG, "permissionsDTO is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitAddressModule() {
        Intent intent = new Intent(this, AddressManageActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(CREATE_EXTRA, KEY_QUIT_ADDRESS_MODULE);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpeechBox() {
        this.recognitionDialog = new b(this);
        this.recognitionDialog.show();
        this.recognitionResult = new AddressManageCallback.VoiceRecognitionResult() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.7
            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback.VoiceRecognitionResult
            public void onError(int i) {
                AddressManageActivity.this.recognitionDialog.c(i);
                AddressManageActivity.this.speechErrorNo = i;
            }

            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback.VoiceRecognitionResult
            public void onVoiceEnd() {
                AddressManageActivity.this.recognitionDialog.b();
                AddressManageActivity.this.recognitionDialog.b(1);
            }

            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback.VoiceRecognitionResult
            public void onVoiceResult(String str) {
                AddressManageActivity.this.speechRecognitionResult.setSpeechData(0, str);
                AddressManageActivity.this.recognitionDialog.o = 0;
                AddressManageActivity.this.recognitionDialog.dismiss();
            }

            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback.VoiceRecognitionResult
            public void onVolumeResult(int i) {
                AddressManageActivity.this.recognitionDialog.a(i);
            }

            @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback.VoiceRecognitionResult
            public void onWordResult(String str) {
                AddressManageActivity.this.recognitionDialog.a(str);
            }
        };
        this.addressManageCallback.onStartSpeech(this.recognitionResult);
        this.recognitionDialog.a(new b.g() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.8
            @Override // com.baidu.pass.ecommerce.d.b.g
            public void onReset() {
                AddressManageActivity.this.addressManageCallback.onStartSpeech(AddressManageActivity.this.recognitionResult);
            }
        });
        this.recognitionDialog.a(new b.h() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.9
            @Override // com.baidu.pass.ecommerce.d.b.h
            public void onStopSpeech() {
                AddressManageActivity.this.addressManageCallback.onStopSpeech();
            }
        });
        this.recognitionDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.10
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AddressManageActivity.this.addressManageCallback.onCancelSpeech();
                if (AddressManageActivity.this.speechErrorNo == 0) {
                    AddressManageActivity.this.speechErrorNo = AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL;
                }
                AddressManageActivity.this.speechRecognitionResult.setSpeechData(AddressManageActivity.this.speechErrorNo, "");
                AddressManageActivity.this.speechErrorNo = 0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        if ("2".equals(this.adapter)) {
            setTitleLayoutVisible(8);
        } else {
            super.configTitle();
        }
    }

    protected void finishActivity() {
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.onFinish(this.addressManageResult);
        }
        finish();
        EcommerceRouter.getInstance().release();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if (ADDRESS_MANAGE_ACTIVITY.equals(getClass().getSimpleName())) {
            this.addressManageResult.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return EcommerceRouter.getInstance().getAddressManageDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        AddressManageCallback addressManageCallback;
        super.init();
        this.addressManageDTO = EcommerceRouter.getInstance().getAddressManageDTO();
        this.addressManageCallback = EcommerceRouter.getInstance().getAddressManageCallback();
        this.adapter = getIntent().getStringExtra(EXTRA_ADAPTER);
        if (this.addressManageDTO != null && (addressManageCallback = this.addressManageCallback) != null) {
            addressManageCallback.activityOnCreate();
            return;
        }
        this.addressManageResult.setResultCode(-204);
        finishActivity();
    }

    public void loadAddressUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadAddressManage(list);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    protected void loadSlideWebview(String str, String str2, String str3) {
        if (!"address".equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent(this, AddressManageExternalActivity.class);
        intent.putExtra("extra_external_url", str2);
        intent.putExtra(EXTRA_ADAPTER, str3);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 9000 || this.recognitionResult == null || this.recognitionDialog == null) {
            return;
        }
        checkSpeechPermission(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        back();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "AddressManageActivity onCreate");
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.addressManageResult.setResultCode(-202);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "AddressManageActivity onDestroy");
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        back();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (TextUtils.equals(KEY_QUIT_ADDRESS_MODULE, intent.getStringExtra(CREATE_EXTRA))) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d(TAG, "AddressManageActivity onPause");
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AddressManageActivity.this.back();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AddressManageActivity.this.addressManageResult.setResultCode(-301);
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setAddressManageCallback(new SapiJsCallBacks.AddressManageCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback
            public void onGetContact(final SapiJsCallBacks.AddressManageCallback.GetContactResult getContactResult) {
                com.baidu.pass.ecommerce.a.c().a(AddressManageActivity.this, new com.baidu.pass.ecommerce.b.a() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.3.1
                    @Override // com.baidu.pass.ecommerce.b.a
                    public void onCall(com.baidu.pass.ecommerce.c.a aVar) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(BaseJsonData.TAG_ERRNO, 0);
                            jSONObject.put("name", aVar.f4102a);
                            jSONObject.put("phone", aVar.f4103b);
                        } catch (Exception e) {
                            Log.e(e);
                        }
                        getContactResult.setGetContactResult(jSONObject.toString());
                    }
                });
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
            @Override // com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onSelectedAddress(String str) {
                JSONException e;
                boolean z = false;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    boolean z2 = false;
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            if (TextUtils.equals(AddressManageActivity.KEY_QUIT_ADDRESS_MODULE, next)) {
                                z2 = true;
                            } else {
                                AddressManageActivity.this.addressManageResult.map.put(next, jSONObject.optString(next));
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            z = z2;
                            Log.e(e);
                            AddressManageActivity.this.addressManageResult.setResultCode(-205);
                            if (AddressManageActivity.this.addressManageCallback != null) {
                            }
                            if (z) {
                            }
                            EcommerceRouter.getInstance().release();
                            AddressManageActivity.this.finish();
                        }
                    }
                    AddressManageActivity.this.addressManageResult.setResultCode(0);
                    z = z2;
                } catch (JSONException e3) {
                    e = e3;
                }
                if (AddressManageActivity.this.addressManageCallback != null) {
                    AddressManageActivity.this.addressManageCallback.onFinish(AddressManageActivity.this.addressManageResult);
                }
                if (z) {
                    AddressManageActivity.this.quitAddressModule();
                }
                EcommerceRouter.getInstance().release();
                AddressManageActivity.this.finish();
            }
        });
        this.sapiWebView.setSpeechRecognitionCallback(new SapiJsCallBacks.SpeechRecognitionCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionCallback
            public void onSpeechRecognition(SapiJsCallBacks.SpeechRecognitionResult speechRecognitionResult) {
                AddressManageActivity.this.speechRecognitionResult = speechRecognitionResult;
                if (AddressManageActivity.this.addressManageCallback == null || !SapiUtils.isMethodOverWrited(AddressManageActivity.this.addressManageCallback, "onStopSpeech", AddressManageCallback.class, new Class[0])) {
                    AddressManageActivity.this.speechRecognitionResult.setSpeechData(1, "");
                } else {
                    AddressManageActivity.this.checkSpeechPermission(true);
                }
            }
        });
        this.sapiWebView.setGetCurrentPageNameCallback(new SapiJsCallBacks.GetCurrentPageNameCallback() { // from class: com.baidu.sapi2.ecommerce.activity.AddressManageActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.GetCurrentPageNameCallback
            public void getCurrentPageName(String str) {
                if (SapiJsCallBacks.GetCurrentPageNameCallback.ADDRESS_EDIT_PAGE.equals(str)) {
                    AddressManageActivity.this.isEditPage = true;
                }
            }
        });
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair("slidePage", "1"));
        AddressManageDTO addressManageDTO = this.addressManageDTO;
        if (addressManageDTO != null) {
            arrayList.add(new PassNameValuePair(EXTRA_PARAMS_TYPE, addressManageDTO.type));
            arrayList.add(new PassNameValuePair("tplse", this.addressManageDTO.tplse));
            arrayList.add(new PassNameValuePair("tplt", this.addressManageDTO.tplt));
            arrayList.add(new PassNameValuePair("pageName", this.addressManageDTO.openPageName));
            arrayList.add(new PassNameValuePair("backProduct", this.addressManageDTO.selectAddedAddress ? "1" : "0"));
            if ("1".equals(this.addressManageDTO.openPageName)) {
                this.isEditPage = true;
            }
        }
        AddressManageCallback addressManageCallback = this.addressManageCallback;
        if (addressManageCallback != null && SapiUtils.isMethodOverWrited(addressManageCallback, "onStartSpeech", AddressManageCallback.class, AddressManageCallback.VoiceRecognitionResult.class)) {
            arrayList.add(new PassNameValuePair(EXTRA_PARAMS_USESPEECH, "1"));
        }
        loadAddressUrl(arrayList);
    }
}
