package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.f.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AddressManageCallback;
import com.baidu.sapi2.dto.AddressManageDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.permissions.PassPermissions;
import com.baidu.sapi2.permissions.PermissionsCallback;
import com.baidu.sapi2.permissions.PermissionsDTO;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.views.m;
import com.baidu.sapi2.views.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AddressManageActivity extends SlideActiviy {
    private static final String A = "AddressManageActivity";
    private static final String B = "select";
    private static final String C = "useSpeech";
    private static final String D = "slidePage";
    private static final String z = "AddressManageActivity";
    private AddressManageDTO E;
    private AddressManageCallback F;
    private SapiJsCallBacks.SpeechRecognitionResult H;
    private AddressManageResult G = new AddressManageResult();
    private boolean I = true;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.onFinish(this.G);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        final o oVar = new o(this);
        final m mVar = new m(this);
        this.F.onStartSpeech(new AddressManageCallback.VoiceRecognitionResult() { // from class: com.baidu.sapi2.activity.AddressManageActivity.6
            @Override // com.baidu.sapi2.callback.AddressManageCallback.VoiceRecognitionResult
            public void onVoiceResult(String str) {
                AddressManageActivity.this.I = false;
                AddressManageActivity.this.H.setSpeechData(0, str);
                oVar.dismiss();
                if (mVar.isShowing()) {
                    mVar.dismiss();
                    AddressManageActivity.this.I = true;
                }
            }

            @Override // com.baidu.sapi2.callback.AddressManageCallback.VoiceRecognitionResult
            public void onVolumeResult(int i) {
                oVar.a(i);
            }
        });
        oVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.sapi2.activity.AddressManageActivity.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AddressManageActivity.this.F.onStopSpeech();
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.sapi2.activity.AddressManageActivity.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AddressManageActivity.this.I) {
                            mVar.show();
                        }
                        AddressManageActivity.this.I = true;
                    }
                }, 500L);
            }
        });
        oVar.show();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(a.d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if ("AddressManageActivity".equals(getClass().getSimpleName())) {
            this.G.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAddressManageDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        AddressManageCallback addressManageCallback;
        super.init();
        this.E = PassportSDK.getInstance().getAddressManageDTO();
        this.F = PassportSDK.getInstance().getAddressManageCallback();
        if (this.E != null && (addressManageCallback = this.F) != null) {
            addressManageCallback.activityOnCreate();
            return;
        }
        this.G.setResultCode(-204);
        finishActivity();
    }

    public void loadAddressUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadAddressManage(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        g();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(z, "AddressManageActivity onCreate");
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.G.setResultCode(-202);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(z, "AddressManageActivity onDestroy");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d(z, "AddressManageActivity onPause");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnPause();
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.d(z, "AddressManageActivity onResume");
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null) {
            addressManageCallback.activityOnResume();
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    protected void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AddressManageActivity.this.g();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AddressManageActivity.this.G.setResultCode(-301);
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setAddressManageCallback(new SapiJsCallBacks.AddressManageCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.AddressManageCallback
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        AddressManageActivity.this.G.map.put(next, jSONObject.optString(next));
                    }
                    AddressManageActivity.this.G.setResultCode(0);
                } catch (JSONException e) {
                    Log.e(e);
                    AddressManageActivity.this.G.setResultCode(-205);
                }
                AddressManageActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setSpeechRecognitionCallback(new SapiJsCallBacks.SpeechRecognitionCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionCallback
            public void onSpeechRecognition(SapiJsCallBacks.SpeechRecognitionResult speechRecognitionResult) {
                AddressManageActivity.this.H = speechRecognitionResult;
                if (AddressManageActivity.this.F == null || !SapiUtils.isMethodOverWrited(AddressManageActivity.this.F, "onStopSpeech", AddressManageCallback.class, new Class[0])) {
                    AddressManageActivity.this.H.setSpeechData(1, "");
                } else {
                    AddressManageActivity.this.h();
                }
            }
        });
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new PassNameValuePair(D, "1"));
        AddressManageDTO addressManageDTO = this.E;
        if (addressManageDTO != null) {
            arrayList.add(new PassNameValuePair(B, addressManageDTO.type));
        }
        AddressManageCallback addressManageCallback = this.F;
        if (addressManageCallback != null && SapiUtils.isMethodOverWrited(addressManageCallback, "onStartSpeech", AddressManageCallback.class, AddressManageCallback.VoiceRecognitionResult.class)) {
            arrayList.add(new PassNameValuePair(C, "1"));
        }
        loadAddressUrl(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.G.setResultCode(-301);
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        PermissionsDTO permissionsDTO = this.E.permissionsDTO;
        if (permissionsDTO != null) {
            permissionsDTO.context = this;
            permissionsDTO.dialogTitle = TextUtils.isEmpty(permissionsDTO.dialogTitle) ? "权限申请" : permissionsDTO.dialogTitle;
            permissionsDTO.dialogMsg = TextUtils.isEmpty(permissionsDTO.dialogMsg) ? "为保证您正常地使用此功能，需要获取您的语音等使用权限，请允许" : permissionsDTO.dialogMsg;
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.AddressManageActivity.5
                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public AlertDialogInterface getDialog(Activity activity) {
                    return AddressManageActivity.this.F.getDialog(activity);
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onFailure() {
                    AddressManageActivity.this.H.setSpeechData(1, "");
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onSuccess() {
                    AddressManageActivity.this.i();
                }
            });
            return;
        }
        i();
        Log.d(z, "permissionsDTO is null");
    }
}
