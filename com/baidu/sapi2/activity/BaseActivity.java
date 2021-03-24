package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.f.a;
import com.baidu.sapi2.g.c;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.FingerprintDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.a0.a.b;
import d.b.a0.a.e;
import d.b.a0.a.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseActivity extends TitleActivity {
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_ACCOUNT_CENTER = 2003;
    public static final int EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION = 2006;
    public static final int EXTRA_PARAM_FROM_CHOICE_SHARE = 2004;
    public static final int EXTRA_PARAM_FROM_GRANT_WAP = 2005;
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final String EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN = "accessToken";
    public static final String EXTRA_PARAM_THIRD_VERIFY_APP_ID = "appId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE = "authorizationCode";
    public static final String EXTRA_PARAM_THIRD_VERIFY_OPEN_ID = "openId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TPL = "tpl";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE = "typeCode";
    public static final String EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME = "typeName";
    public static final String EXTRA_PARAM_THIRD_VERIFY_UNION_ID = "unionId";
    public static final String EXTRA_PARAM_THIRD_VERIFY_USER_ID = "userId";
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    public static final int REQUEST_CODE_LOGIN = 1004;
    public static final int RESULT_CODE_THIRD_PARTY_VERIFY = 3001;
    public static final String j = BaseActivity.class.getSimpleName();
    public static final String k = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";
    public static final String l = "camera_temp_image.jpg";
    public static final int m = 1001;
    public static final int n = 1002;
    public static final int o = 1003;

    /* renamed from: a  reason: collision with root package name */
    public ValueCallback<Uri> f10921a;

    /* renamed from: b  reason: collision with root package name */
    public ValueCallback<Uri[]> f10922b;

    /* renamed from: c  reason: collision with root package name */
    public SapiWebView.PickPhotoResult f10923c;

    /* renamed from: d  reason: collision with root package name */
    public SapiWebView.BiometricsIdentifyResult f10924d;

    /* renamed from: e  reason: collision with root package name */
    public a f10925e;

    /* renamed from: f  reason: collision with root package name */
    public int f10926f;

    /* renamed from: g  reason: collision with root package name */
    public int f10927g;

    /* renamed from: h  reason: collision with root package name */
    public ImageCropCallback.ImageCropResult f10928h;
    public com.baidu.sapi2.shell.a.a i;
    public boolean loginStatusChange;
    public SapiWebView sapiWebView;

    public void initScreenShotManager() {
        com.baidu.sapi2.shell.a.a aVar = new com.baidu.sapi2.shell.a.a();
        this.i = aVar;
        aVar.a(getContentResolver(), new IScreenShotListener() { // from class: com.baidu.sapi2.activity.BaseActivity.21
            @Override // com.baidu.sapi2.shell.listener.IScreenShotListener
            public void onScreenShot() {
                BaseActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.sapi2.activity.BaseActivity.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView sapiWebView = BaseActivity.this.sapiWebView;
                        if (sapiWebView != null) {
                            sapiWebView.loadUrl(BaseActivity.k);
                        }
                    }
                });
            }
        });
        this.i.a();
    }

    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        String str2;
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType = PassFaceRecogType.RECOG_TYPE_BDUSS;
        if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            str2 = currentAccount == null ? "" : currentAccount.bduss;
        } else {
            if ("authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                passFaceRecogType = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
            } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType)) {
                passFaceRecogType = PassFaceRecogType.RECOG_TYPE_CERTINFO;
            }
            str2 = null;
        }
        biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult.subPro, null, "0", str2, str, biometricsIdentifyResult.authToken, "", biometricsIdentifyResult.realName, biometricsIdentifyResult.idCardNum, biometricsIdentifyResult.phoneNum, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (BaseActivity.this.f10924d != null) {
                    BaseActivity.this.f10924d.setIdentifyToken(a2.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.f10924d != null) {
                    BaseActivity.this.f10924d.setIdentifyToken(a2.toString());
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            imageCropCallback = b();
            activityResultCallback = a();
        }
        ImageCropCallback imageCropCallback2 = imageCropCallback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i, i2, intent);
        }
        if (i == 1001) {
            if (this.f10923c == null) {
                return;
            }
            if (i2 == -1 && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg")), this.f10926f, this.f10927g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.17
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        if (str != null) {
                            BaseActivity.this.f10923c.setImageData(str);
                        } else {
                            BaseActivity.this.f10923c.setImageData("");
                        }
                    }
                });
            } else {
                this.f10923c.setImageData("");
            }
        } else if (i != 1002) {
            if (i == 2001 && i2 == 3001) {
                a(intent);
            }
        } else if (this.f10923c == null) {
        } else {
            if (i2 == -1 && intent.getData() != null && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, intent.getData(), this.f10926f, this.f10927g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.18
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        if (str != null) {
                            BaseActivity.this.f10923c.setImageData(str);
                        } else {
                            BaseActivity.this.f10923c.setImageData("");
                        }
                    }
                });
            } else {
                this.f10923c.setImageData("");
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this)) {
            initScreenShotManager();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseScreenShotManager();
        if (this.loginStatusChange) {
            SapiAccountManager.getGlobalCallback().onLoginStatusChange();
        }
        try {
            ((RelativeLayout) findViewById(e.root_view)).removeView(this.sapiWebView);
            this.sapiWebView.removeAllViews();
            this.sapiWebView.destroy();
            this.sapiWebView = null;
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.sapiWebView.onKeyUp(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            this.executeSubClassMethod = true ^ titleBtnCallback.onLeftBtnClick();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
        try {
            this.sapiWebView.onPause();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
        try {
            this.sapiWebView.onResume();
        } catch (Exception unused) {
        }
    }

    public void pickPhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this.configuration.context;
        permissionsDTO.permissions = new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        permissionsDTO.dialogTitle = "存储权限";
        permissionsDTO.dialogMsg = "为了正常使用图片上传、图片识别服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.13
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_STORAGE_PERM_MSG, 1).show();
                if (BaseActivity.this.f10923c != null) {
                    BaseActivity.this.f10923c.setImageData("");
                }
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (Build.VERSION.SDK_INT == 19) {
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                        BaseActivity.this.startActivityForResult(intent, 1002);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                        intent2.setAction("android.intent.action.GET_CONTENT");
                        BaseActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void releaseScreenShotManager() {
        com.baidu.sapi2.shell.a.a aVar = this.i;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setNewLoginTitleAndSetStyleChangeCallBack() {
        if (this.configuration.isNewLogin) {
            try {
                ((RelativeLayout.LayoutParams) findViewById(e.sapi_webview).getLayoutParams()).addRule(3, 0);
            } catch (Exception unused) {
                Log.e(j, "子activity重写了webview布局");
            }
            this.sapiWebView.setHadMakeBarHide(true);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.root_view);
            if (this.mTitleLayout == null) {
                this.mTitleLayout = (RelativeLayout) findViewById(e.sapi_title_layout);
            }
            final ImageView imageView = null;
            RelativeLayout relativeLayout2 = this.mTitleLayout;
            if (relativeLayout2 != null && relativeLayout2.getChildCount() != 0) {
                relativeLayout.removeView(this.mTitleLayout);
                this.mTitleLayout.setBackgroundColor(0);
                for (int i = 0; i < this.mTitleLayout.getChildCount(); i++) {
                    View childAt = this.mTitleLayout.getChildAt(i);
                    if (childAt.getId() == e.title_right_close && this.configuration.showBottomBack) {
                        childAt.setVisibility(0);
                        imageView = (ImageView) childAt;
                    } else {
                        childAt.setVisibility(8);
                    }
                }
                try {
                    ((RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams()).topMargin = ViewUtility.getStatusBarHeight(this);
                } catch (Exception unused2) {
                    Log.e(j, "子activity重写了title布局");
                }
                relativeLayout.addView(this.mTitleLayout);
            }
            ViewUtility.newLoginStatusBarTint(this);
            this.sapiWebView.setSwitchStyleForCloseBtnAndStatusBarCallBack(new SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.22
                @Override // com.baidu.sapi2.SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack
                public void switchStyle(String str) {
                    Window window;
                    Window window2;
                    if (str.equals("1")) {
                        ImageView imageView2 = imageView;
                        if (imageView2 != null) {
                            imageView2.setColorFilter(-1);
                        }
                        if (Build.VERSION.SDK_INT < 23 || (window2 = BaseActivity.this.getWindow()) == null) {
                            return;
                        }
                        window2.getDecorView().setSystemUiVisibility(1280);
                        return;
                    }
                    ImageView imageView3 = imageView;
                    if (imageView3 != null) {
                        imageView3.setColorFilter(-16777216);
                    }
                    if (Build.VERSION.SDK_INT < 23 || (window = BaseActivity.this.getWindow()) == null) {
                        return;
                    }
                    window.getDecorView().setSystemUiVisibility(9216);
                }
            });
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView = (SapiWebView) findViewById(e.sapi_webview);
        this.sapiWebView = sapiWebView;
        if (this.configuration.isDarkMode) {
            sapiWebView.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_color));
        }
        i.a(this, this.sapiWebView, getWebDTO() != null && getWebDTO().sweepLightLoading);
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                String string = BaseActivity.this.getString(g.sapi_sdk_account_center_webview_title_online_service);
                String string2 = BaseActivity.this.getString(g.sapi_sdk_account_center_webview_title_common_problem);
                if (string.equals(str)) {
                    str = string2;
                }
                BaseActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setLocalConfigCallback(new SapiWebView.LocalConfigCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.2
            @Override // com.baidu.sapi2.SapiWebView.LocalConfigCallback
            public List<FastLoginFeature> getFastLoginFeatureList() {
                WebLoginDTO.Config config;
                WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                if (webLoginDTO == null || (config = webLoginDTO.config) == null) {
                    return null;
                }
                return config.fastLoginFeatureList;
            }
        });
        this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.3
            @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
            public void onPickImage(int i, int i2, int i3, SapiWebView.PickPhotoResult pickPhotoResult) {
                BaseActivity.this.f10923c = pickPhotoResult;
                BaseActivity.this.f10926f = i2;
                BaseActivity.this.f10927g = i3;
                if (1 == i) {
                    BaseActivity.this.takePhoto();
                } else {
                    BaseActivity.this.pickPhoto();
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.4
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.f10924d = biometricsIdentifyResult;
                if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.a(biometricsIdentifyResult);
                } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType) || "authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.livenessRecognize(null, biometricsIdentifyResult);
                }
            }
        });
        this.sapiWebView.setPageStateCallback(new SapiJsCallBacks.PageStateCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiJsCallBacks.PageStateCallback
            public void pageState(int i) {
                BaseActivity.this.updateBottomBack(i);
            }
        });
        this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.6
            @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback
            public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.a(baseActivity, bioScanFaceResult);
            }
        });
        this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.7
            @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback
            public void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                BaseActivity.this.f10925e = new a();
                BaseActivity.this.f10925e.a(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
        this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.8
            @Override // com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback
            public void onChange() {
                BaseActivity.this.loginStatusChange = true;
            }
        });
        this.sapiWebView.setFingerprintCallback(new SapiJsCallBacks.FingerprintCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.9
            @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback
            public void onCallback(final SapiJsCallBacks.FingerprintResult fingerprintResult) {
                BaseActivity baseActivity = BaseActivity.this;
                new c(baseActivity, new FingerprintDialog(baseActivity)).a(fingerprintResult.authType, new com.baidu.sapi2.g.a() { // from class: com.baidu.sapi2.activity.BaseActivity.9.1
                    @Override // com.baidu.sapi2.g.a
                    public void onCall(int i) {
                        fingerprintResult.setResult(i);
                    }
                });
            }
        });
        this.sapiWebView.setSocialVerificationHandler(new Handler() { // from class: com.baidu.sapi2.activity.BaseActivity.10
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                if (thirdPartyService != null) {
                    thirdPartyService.loadThirdPartyLogin(BaseActivity.this, (SocialType) message.obj, 2006, null, true);
                    SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.10.1
                        @Override // com.baidu.sapi2.social.WXInvokeCallback
                        public void onResult(int i, Intent intent) {
                            if (i == 3001) {
                                BaseActivity.this.a(intent);
                            }
                        }
                    });
                }
            }
        });
        this.sapiWebView.setBiometricsIdentificationLiveCallBack(new SapiJsCallBacks.BiometricsIdentificationLiveCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.11
            @Override // com.baidu.sapi2.SapiJsCallBacks.BiometricsIdentificationLiveCallBack
            public void getLiveImage(int i, PassFaceRecogCallback passFaceRecogCallback) {
                BiometricsManager.getInstance().recogWithFaceLive(BaseActivity.this, i, passFaceRecogCallback);
            }
        });
    }

    public void takePhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this.configuration.context;
        permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = "为了正常使用拍照服务、图片上传、图片识别服务，请允许使用摄像头和存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.12
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_CAMERA_PERM_MSG, 1).show();
                if (BaseActivity.this.f10923c != null) {
                    BaseActivity.this.f10923c.setImageData("");
                }
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, g.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(Environment.getExternalStorageDirectory(), "camera_temp_image.jpg");
                    if (Build.VERSION.SDK_INT >= 24 && BaseActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                        BaseActivity baseActivity = BaseActivity.this;
                        intent.putExtra("output", FileProvider.getUriForFile(baseActivity, BaseActivity.this.getPackageName() + ".passfileprovider", file2));
                    } else {
                        intent.putExtra("output", Uri.fromFile(file2));
                    }
                    intent.putExtra("orientation", 0);
                    BaseActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    private ImageCropCallback b() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.19
            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropCallback.ImageCropResult imageCropResult) {
                BaseActivity.this.f10928h = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i == ClipBoxView.H) {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                } else {
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                }
                intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i2);
                intent.setData(uri);
                BaseActivity.this.startActivityForResult(intent, 1003);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            Toast.makeText(this, "请先登录", 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.14
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", getTplStokenResult.getResultCode());
                    jSONObject.put("errmsg", getTplStokenResult.getResultMsg());
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                if (BaseActivity.this.f10924d != null) {
                    BaseActivity.this.f10924d.setIdentifyToken(jSONObject.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String str = getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str)) {
                    SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult2 = biometricsIdentifyResult;
                    if (biometricsIdentifyResult2.biometricType == 1) {
                        BaseActivity.this.livenessRecognize(str, biometricsIdentifyResult2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", -402);
                    jSONObject.put("errmsg", "服务异常，请稍后再试");
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                if (BaseActivity.this.f10924d != null) {
                    BaseActivity.this.f10924d.setIdentifyToken(jSONObject.toString());
                }
            }
        }, currentAccount.bduss, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2 = bioScanFaceResult;
                if (bioScanFaceResult2 != null) {
                    bioScanFaceResult2.setScanFaceIdentifyResult(a2.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                String str;
                JSONObject jSONObject;
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2 = bioScanFaceResult;
                if (bioScanFaceResult2 == null) {
                    return;
                }
                if (bioScanFaceResult2.type == 1) {
                    try {
                        jSONObject = passFaceRecogResult.extraJson;
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                    if (jSONObject != null) {
                        jSONObject.remove("faceimage");
                        jSONObject.remove("imgdigests");
                        jSONObject.put("errno", passFaceRecogResult.getResultCode());
                        jSONObject.put("errmsg", passFaceRecogResult.getResultMsg());
                        str = jSONObject.toString();
                        bioScanFaceResult.setScanFaceIdentifyResult(str);
                        return;
                    }
                    str = "";
                    bioScanFaceResult.setScanFaceIdentifyResult(str);
                    return;
                }
                bioScanFaceResult.setScanFaceIdentifyResult(BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
            }
        };
        if (bioScanFaceResult.type == 1) {
            biometricsManager.recogWithFaceDetect(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, "", passFaceRecogCallback);
        } else {
            biometricsManager.recogWithFaceOuter(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, passFaceRecogCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(int i, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", i);
            jSONObject.put("errmsg", str);
            if (i == 0) {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("credentialKey", str2);
                    jSONObject.put("callbackkey", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("authsid", str3);
                }
            }
        } catch (JSONException e2) {
            Log.e(e2);
        }
        return jSONObject;
    }

    private ActivityResultCallback a() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.20
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i, int i2, Intent intent) {
                if (i == 1003) {
                    if (i2 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra == null || BaseActivity.this.f10928h == null) {
                            return;
                        }
                        BaseActivity.this.f10928h.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                    } else if (BaseActivity.this.f10928h != null) {
                        BaseActivity.this.f10928h.onImageResult(null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || (jsCallBacks = sapiWebView.getJsCallBacks()) == null || (promptResult = jsCallBacks.getPromptResult()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errno", "0");
            if (intent == null) {
                promptResult.confirm(jSONObject.toString());
                Toast.makeText(this, jSONObject.toString(), 0).show();
                return;
            }
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_UNION_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_UNION_ID));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_APP_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_APP_ID));
            jSONObject.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
            promptResult.confirm(jSONObject.toString());
            Toast.makeText(this, jSONObject.toString(), 0).show();
        } catch (JSONException unused) {
            promptResult.cancel();
            Toast.makeText(this, QueryResponse.Options.CANCEL, 0).show();
        }
    }
}
