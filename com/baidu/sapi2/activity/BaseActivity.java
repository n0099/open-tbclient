package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.d.a.a;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.permissions.PassPermissions;
import com.baidu.sapi2.permissions.PermissionsCallback;
import com.baidu.sapi2.permissions.PermissionsDTO;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.touchid.FingerprintCallback;
import com.baidu.sapi2.touchid.FingerprintHelper;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SapiWebViewUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.CustomAlertDialog;
import com.baidu.sapi2.views.FingerprintDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseActivity extends TitleActivity {
    private static final String CAPTURE_IMAGE_FILE = "camera_temp_image.jpg";
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_ACCOUNT_CENTER = 2003;
    public static final int EXTRA_PARAM_FROM_CHOICE_SHARE = 2004;
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    protected static final int REQUEST_CODE_LOGIN = 1004;
    private static final int REQUEST_CROP_IMAGE = 1003;
    private static final int REQUEST_PICK_PHOTO = 1002;
    private static final int REQUEST_TAKE_PHOTO = 1001;
    private SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult;
    private SapiJsCallBacks.FingerprintResult fingerprintResult;
    private ImageCropCallback.ImageCropResult imageCropResult;
    protected boolean loginStatusChange;
    private int mSence;
    private int mSize;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageForAndroid5;
    private SapiWebView.PickPhotoResult pickPhotoResult;
    private SapiScheme sapiScheme;
    protected SapiWebView sapiWebView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
        try {
            this.sapiWebView.onResume();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
        try {
            this.sapiWebView.onPause();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.sapiWebView.onKeyUp(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        if (this.titleBtnCallback != null) {
            this.executeSubClassMethod = this.titleBtnCallback.onLeftBtnClick() ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView = (SapiWebView) findViewById(a.e.sapi_webview);
        SapiWebViewUtil.addCustomView(this, this.sapiWebView, getWebDTO() != null && getWebDTO().sweepLightLoading);
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                String string = BaseActivity.this.getString(a.g.sapi_sdk_account_center_webview_title_online_service);
                String string2 = BaseActivity.this.getString(a.g.sapi_sdk_account_center_webview_title_common_problem);
                if (string.equals(str)) {
                    str = string2;
                }
                BaseActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setLocalConfigCallback(new SapiWebView.LocalConfigCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.2
            @Override // com.baidu.sapi2.SapiWebView.LocalConfigCallback
            public List<FastLoginFeature> getFastLoginFeatureList() {
                WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                if (webLoginDTO == null || webLoginDTO.config == null) {
                    return null;
                }
                return webLoginDTO.config.fastLoginFeatureList;
            }
        });
        this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.3
            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooser(ValueCallback<Uri> valueCallback) {
                BaseActivity.this.openFileChooserImpl(valueCallback);
            }

            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                BaseActivity.this.openFileChooserImplForAndroid5(valueCallback);
            }
        });
        this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.4
            @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
            public void onPickImage(int i, int i2, int i3, SapiWebView.PickPhotoResult pickPhotoResult) {
                BaseActivity.this.pickPhotoResult = pickPhotoResult;
                BaseActivity.this.mSence = i2;
                BaseActivity.this.mSize = i3;
                if (1 == i) {
                    BaseActivity.this.takePhoto();
                } else {
                    BaseActivity.this.pickPhoto();
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.biometricsIdentifyResult = biometricsIdentifyResult;
                if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.getStoken(biometricsIdentifyResult);
                } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType) || "authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.livenessRecognize(null, biometricsIdentifyResult);
                }
            }
        });
        this.sapiWebView.setPageStateCallback(new SapiJsCallBacks.PageStateCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.6
            @Override // com.baidu.sapi2.SapiJsCallBacks.PageStateCallback
            public void pageState(int i) {
                BaseActivity.this.updateBottomBack(i);
            }
        });
        this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.7
            @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback
            public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                BaseActivity.this.bioScanFace(BaseActivity.this, bioScanFaceResult);
            }
        });
        this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.8
            @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback
            public void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                BaseActivity.this.sapiScheme = new SapiScheme();
                BaseActivity.this.sapiScheme.invokeScApp(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
        if (PassportSDK.getLoginStatusChangeCallback() != null) {
            this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.9
                @Override // com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback
                public void onChange() {
                    BaseActivity.this.loginStatusChange = true;
                }
            });
        }
        this.sapiWebView.setBuildCustomAlertDialog(new SapiJsCallBacks.BuildCustomAlertDialog() { // from class: com.baidu.sapi2.activity.BaseActivity.10
            @Override // com.baidu.sapi2.SapiJsCallBacks.BuildCustomAlertDialog
            public AlertDialogInterface buildDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }
        });
        this.sapiWebView.setFingerprintCallback(new AnonymousClass11());
    }

    /* renamed from: com.baidu.sapi2.activity.BaseActivity$11  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass11 extends SapiJsCallBacks.FingerprintCallback {
        AnonymousClass11() {
        }

        @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback
        public void onCallback(SapiJsCallBacks.FingerprintResult fingerprintResult) {
            BaseActivity.this.fingerprintResult = fingerprintResult;
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = BaseActivity.this;
            permissionsDTO.permissions = new String[]{"android.permission.USE_FINGERPRINT"};
            permissionsDTO.dialogTitle = "权限申请";
            permissionsDTO.dialogMsg = String.format(BaseActivity.this.getString(a.g.sapi_sdk_pmn_msg_use_fingerprint), SapiUtils.getAppName(BaseActivity.this), "指纹权限");
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.11.1
                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onSuccess() {
                    new FingerprintHelper(BaseActivity.this, new FingerprintDialog(BaseActivity.this)).startAuthenticate(BaseActivity.this.fingerprintResult.authType, new FingerprintCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.11.1.1
                        @Override // com.baidu.sapi2.touchid.FingerprintCallback
                        public void onCall(int i) {
                            BaseActivity.this.fingerprintResult.setResult(i);
                        }
                    });
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public void onFailure() {
                    Toast.makeText(BaseActivity.this, "请开启指纹权限", 1).show();
                }

                @Override // com.baidu.sapi2.permissions.PermissionsCallback
                public AlertDialogInterface getDialog(Activity activity) {
                    return new CustomAlertDialog(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFileChooserImpl(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFileChooserImplForAndroid5(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMessageForAndroid5 = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = String.format(getString(a.g.sapi_sdk_pmn_msg_set_portrait), SapiUtils.getAppName(this), "相机和存储权限");
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.12
            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, a.g.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), BaseActivity.CAPTURE_IMAGE_FILE);
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(Environment.getExternalStorageDirectory(), BaseActivity.CAPTURE_IMAGE_FILE);
                    if (Build.VERSION.SDK_INT >= 24 && BaseActivity.this.getApplicationInfo().targetSdkVersion >= 24) {
                        intent.putExtra("output", FileProvider.getUriForFile(BaseActivity.this, BaseActivity.this.getPackageName() + ".fileprovider", file2));
                    } else {
                        intent.putExtra("output", Uri.fromFile(file2));
                    }
                    intent.putExtra("orientation", 0);
                    BaseActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onFailure() {
                Toast.makeText(BaseActivity.this, "请开启相机和存储权限", 1).show();
                if (BaseActivity.this.pickPhotoResult != null) {
                    BaseActivity.this.pickPhotoResult.setImageData("");
                }
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public AlertDialogInterface getDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pickPhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = String.format(getString(a.g.sapi_sdk_pmn_msg_set_portrait), SapiUtils.getAppName(this), "存储权限");
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.13
            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (Build.VERSION.SDK_INT == 19) {
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        BaseActivity.this.startActivityForResult(intent, 1002);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setType("image/*");
                        intent2.setAction("android.intent.action.GET_CONTENT");
                        BaseActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public void onFailure() {
                Toast.makeText(BaseActivity.this, "请开启存储权限", 1).show();
                if (BaseActivity.this.pickPhotoResult != null) {
                    BaseActivity.this.pickPhotoResult.setImageData("");
                }
            }

            @Override // com.baidu.sapi2.permissions.PermissionsCallback
            public AlertDialogInterface getDialog(Activity activity) {
                return new CustomAlertDialog(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStoken(final SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            Toast.makeText(this, "请先登录", 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String str = getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str)) {
                    if (biometricsIdentifyResult.biometricType == 1) {
                        BaseActivity.this.livenessRecognize(str, biometricsIdentifyResult);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", SapiWebView.BiometricsIdentifyResult.ERROR_CODE_GET_STOKEN_FAILED);
                    jSONObject.put("errmsg", "服务异常，请稍后再试");
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.biometricsIdentifyResult != null) {
                    BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(jSONObject.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetTplStokenResult getTplStokenResult) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", getTplStokenResult.getResultCode());
                    jSONObject.put("errmsg", getTplStokenResult.getResultMsg());
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.biometricsIdentifyResult != null) {
                    BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(jSONObject.toString());
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, session.bduss, arrayList);
    }

    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType = PassFaceRecogType.RECOG_TYPE_BDUSS;
        String str2 = null;
        if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
            str2 = SapiAccountManager.getInstance().getSession().bduss;
        } else if ("authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
            passFaceRecogType = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
        } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType)) {
            passFaceRecogType = PassFaceRecogType.RECOG_TYPE_CERTINFO;
        }
        biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult.subPro, null, "0", str2, str, biometricsIdentifyResult.authToken, "", biometricsIdentifyResult.realName, biometricsIdentifyResult.idCardNum, biometricsIdentifyResult.phoneNum, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.biometricsIdentifyResult != null) {
                    BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(livenessResult2JsonObj.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (BaseActivity.this.biometricsIdentifyResult != null) {
                    BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(livenessResult2JsonObj.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bioScanFace(Context context, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                if (bioScanFaceResult != null) {
                    String str = "";
                    if (bioScanFaceResult.type != 1) {
                        bioScanFaceResult.setScanFaceIdentifyResult(BaseActivity.this.livenessResult2JsonObj(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
                        return;
                    }
                    try {
                        JSONObject jSONObject = passFaceRecogResult.extraJson;
                        if (jSONObject != null) {
                            jSONObject.remove("faceimage");
                            jSONObject.remove("imgdigests");
                            jSONObject.put("errno", passFaceRecogResult.getResultCode());
                            jSONObject.put("errmsg", passFaceRecogResult.getResultMsg());
                            str = jSONObject.toString();
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    bioScanFaceResult.setScanFaceIdentifyResult(str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (bioScanFaceResult != null) {
                    bioScanFaceResult.setScanFaceIdentifyResult(livenessResult2JsonObj.toString());
                }
            }
        };
        if (bioScanFaceResult.type == 1) {
            biometricsManager.recogWithFaceDetect(context, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, "", passFaceRecogCallback);
        } else {
            biometricsManager.recogWithFaceOuter(context, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, passFaceRecogCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject livenessResult2JsonObj(int i, String str, String str2, String str3) {
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
        } catch (JSONException e) {
            Log.e(e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LoginStatusChangeCallback loginStatusChangeCallback = PassportSDK.getLoginStatusChangeCallback();
        if (this.loginStatusChange && loginStatusChangeCallback != null) {
            loginStatusChangeCallback.onChange();
        }
        try {
            ((RelativeLayout) findViewById(a.e.root_view)).removeView(this.sapiWebView);
            this.sapiWebView.removeAllViews();
            this.sapiWebView.destroy();
            this.sapiWebView = null;
        } catch (Exception e) {
            Log.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ImageCropCallback defaultImageCropCallback;
        ActivityResultCallback defaultImageCropActivityResult;
        super.onActivityResult(i, i2, intent);
        ImageCropCallback imageCropCallback = PassportSDK.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = PassportSDK.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            defaultImageCropCallback = getDefaultImageCropCallback();
            defaultImageCropActivityResult = getDefaultImageCropActivityResult();
        } else {
            defaultImageCropCallback = imageCropCallback;
            defaultImageCropActivityResult = activityResultCallback;
        }
        if (defaultImageCropActivityResult != null) {
            defaultImageCropActivityResult.onActivityResult(i, i2, intent);
        }
        if (i == 1010) {
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.mUploadMessage = null;
            }
        } else if (i == 1011) {
            if (this.mUploadMessageForAndroid5 != null) {
                Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data != null) {
                    this.mUploadMessageForAndroid5.onReceiveValue(new Uri[]{data});
                } else {
                    this.mUploadMessageForAndroid5.onReceiveValue(new Uri[0]);
                }
                this.mUploadMessageForAndroid5 = null;
            }
        } else if (i == 1001) {
            if (this.pickPhotoResult != null) {
                if (i2 == -1 && defaultImageCropCallback != null) {
                    defaultImageCropCallback.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE)), this.mSence, this.mSize, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.17
                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            if (str != null) {
                                BaseActivity.this.pickPhotoResult.setImageData(str);
                            } else {
                                BaseActivity.this.pickPhotoResult.setImageData("");
                            }
                        }
                    });
                } else {
                    this.pickPhotoResult.setImageData("");
                }
            }
        } else if (i == 1002) {
            if (this.pickPhotoResult != null) {
                if (i2 == -1 && intent.getData() != null && defaultImageCropCallback != null) {
                    defaultImageCropCallback.onImageCrop(this, intent.getData(), this.mSence, this.mSize, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.18
                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            if (str != null) {
                                BaseActivity.this.pickPhotoResult.setImageData(str);
                            } else {
                                BaseActivity.this.pickPhotoResult.setImageData("");
                            }
                        }
                    });
                } else {
                    this.pickPhotoResult.setImageData("");
                }
            }
        } else if (i == 3001 && this.sapiScheme != null) {
            this.sapiScheme.onActivityResult(i, i2, intent);
        }
    }

    private ImageCropCallback getDefaultImageCropCallback() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.19
            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropCallback.ImageCropResult imageCropResult) {
                BaseActivity.this.imageCropResult = imageCropResult;
                Intent intent = new Intent(context, ImageClipActivity.class);
                if (i == ClipBoxView.CLIP_IMAGE_SQUARE) {
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

    private ActivityResultCallback getDefaultImageCropActivityResult() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.20
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i, int i2, Intent intent) {
                if (i == 1003) {
                    if (i2 != -1) {
                        if (BaseActivity.this.imageCropResult != null) {
                            BaseActivity.this.imageCropResult.onImageResult(null);
                            return;
                        }
                        return;
                    }
                    byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                    if (byteArrayExtra != null && BaseActivity.this.imageCropResult != null) {
                        BaseActivity.this.imageCropResult.onImageResult(SapiDeviceUtils.DeviceCrypto.base64Encode(byteArrayExtra));
                    }
                }
            }
        };
    }
}
