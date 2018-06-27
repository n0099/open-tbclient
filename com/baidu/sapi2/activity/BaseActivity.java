package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.baidu.c.a.a;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SapiWebViewUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.views.CustomAlertDialog;
import com.baidu.sapi2.views.ViewUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
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
    private static final int PERMISSION_CAMERA_WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 100;
    private static final int PERMISSION_WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 101;
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    protected static final int REQUEST_CODE_LOGIN = 1004;
    protected static final int REQUEST_CODE_SOCIAL_BIND = 1003;
    private static final int REQUEST_PICK_PHOTO = 1002;
    private static final int REQUEST_TAKE_PHOTO = 1001;
    private SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult;
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
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        if (this.sapiWebView.notifyKefuBack()) {
            this.executeSubClassMethod = false;
        } else if (this.titleBtnCallback != null) {
            this.executeSubClassMethod = this.titleBtnCallback.onLeftBtnClick() ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView = (SapiWebView) findViewById(a.d.sapi_webview);
        SapiWebViewUtil.addCustomView(this, this.sapiWebView);
        PassportViewManager.getInstance().setReloadWebviewObserver(new PassportViewManager.ReloadWebviewObserver() { // from class: com.baidu.sapi2.activity.BaseActivity.1
            @Override // com.baidu.sapi2.PassportViewManager.ReloadWebviewObserver
            public void onWebviewReload() {
                BaseActivity.this.sapiWebView.reload();
            }
        });
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.2
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                String string = BaseActivity.this.getString(a.f.sapi_sdk_account_center_webview_title_online_service);
                String string2 = BaseActivity.this.getString(a.f.sapi_sdk_account_center_webview_title_common_problem);
                if (string.equals(str)) {
                    str = string2;
                }
                BaseActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setLocalConfigCallback(new SapiWebView.LocalConfigCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.3
            @Override // com.baidu.sapi2.SapiWebView.LocalConfigCallback
            public List<FastLoginFeature> getFastLoginFeatureList() {
                WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                if (webLoginDTO == null || webLoginDTO.config == null) {
                    return null;
                }
                return webLoginDTO.config.fastLoginFeatureList;
            }
        });
        this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.4
            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooser(ValueCallback<Uri> valueCallback) {
                BaseActivity.this.openFileChooserImpl(valueCallback);
            }

            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                BaseActivity.this.openFileChooserImplForAndroid5(valueCallback);
            }
        });
        this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
            public void onPickImage(int i, SapiWebView.PickPhotoResult pickPhotoResult) {
                BaseActivity.this.pickPhotoResult = pickPhotoResult;
                if (1 == i) {
                    if (Build.VERSION.SDK_INT < 23 || (BaseActivity.this.checkSelfPermission("android.permission.CAMERA") == 0 && BaseActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                        BaseActivity.this.takePhoto();
                    } else {
                        BaseActivity.this.getPermission(BaseActivity.this, true);
                    }
                } else if (Build.VERSION.SDK_INT < 23 || BaseActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    BaseActivity.this.pickPhoto();
                } else {
                    BaseActivity.this.getPermission(BaseActivity.this, false);
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.6
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.biometricsIdentifyResult = biometricsIdentifyResult;
                if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.getStoken(biometricsIdentifyResult);
                } else if (SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_CERTINFO.equals(biometricsIdentifyResult.livenessRecogType) || SapiWebView.BiometricsIdentifyResult.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN.equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.livenessRecognize(null, biometricsIdentifyResult);
                }
            }
        });
        this.sapiWebView.setPageStateCallback(new SapiJsCallBacks.PageStateCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.7
            @Override // com.baidu.sapi2.SapiJsCallBacks.PageStateCallback
            public void pageState(int i) {
                BaseActivity.this.updateBottomBack(i);
            }
        });
        this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.8
            @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback
            public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                BaseActivity.this.bioScanFace(BaseActivity.this, bioScanFaceResult);
            }
        });
        this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.9
            @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback
            public void onInvokeScApp(String str, String str2, List<NameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                BaseActivity.this.sapiScheme = new SapiScheme();
                BaseActivity.this.sapiScheme.invokeScApp(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void getPermission(final Context context, final boolean z) {
        if (!SapiAccountManager.getInstance().getConfignation().showPmnRationaleDialog) {
            requestPermission(context, z);
            return;
        }
        final CustomAlertDialog customAlertDialog = new CustomAlertDialog(context);
        customAlertDialog.setPositiveBtn(getString(a.f.sapi_sdk_pmn_ok), new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewUtility.dismissDialog(BaseActivity.this, customAlertDialog);
                BaseActivity.this.requestPermission(context, z);
            }
        });
        customAlertDialog.setNegativeBtn(getString(a.f.sapi_sdk_pmn_cancel), new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewUtility.dismissDialog(BaseActivity.this, customAlertDialog);
                if (BaseActivity.this.pickPhotoResult != null) {
                    BaseActivity.this.pickPhotoResult.setImageData("");
                }
            }
        });
        if (z) {
            if (shouldShowRequestPermissionRationale("android.permission.CAMERA") || shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                customAlertDialog.setTitleText(String.format(getString(a.f.sapi_sdk_pmn_title_set_portrait), SapiUtils.getAppName(context), "摄像头/相机、存储权限"));
                customAlertDialog.setMessageText(String.format(getString(a.f.sapi_sdk_pmn_msg_set_portrait), SapiUtils.getAppName(context), "存储权限"));
                customAlertDialog.show();
                return;
            }
            requestPermission(context, z);
        } else if (shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
            customAlertDialog.setTitleText(String.format(getString(a.f.sapi_sdk_pmn_title_set_portrait), SapiUtils.getAppName(context), "存储权限"));
            customAlertDialog.setMessageText(String.format(getString(a.f.sapi_sdk_pmn_msg_set_portrait), SapiUtils.getAppName(context), "存储权限"));
            customAlertDialog.show();
        } else {
            requestPermission(context, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void requestPermission(Context context, boolean z) {
        if (z) {
            requestPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
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
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                Toast.makeText(this, a.f.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                return;
            }
            File file = new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE);
            if (file.exists()) {
                file.delete();
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            File file2 = new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE);
            if (Build.VERSION.SDK_INT >= 24 && getApplicationInfo().targetSdkVersion >= 24) {
                intent.putExtra("output", FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file2));
            } else {
                intent.putExtra("output", Uri.fromFile(file2));
            }
            intent.putExtra("orientation", 0);
            startActivityForResult(intent, 1001);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pickPhoto() {
        try {
            if (Build.VERSION.SDK_INT == 19) {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, 1002);
            } else {
                Intent intent2 = new Intent();
                intent2.setType("image/*");
                intent2.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent2, 1002);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
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
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.12
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
                    jSONObject.put("errmsg", "获取stoken 失败");
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
                    jSONObject.put("errmsg", "获取stoken 失败");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        BiometricsManager.getInstance().livenessRecognize(getApplicationContext(), str, biometricsIdentifyResult, new RimServiceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.13
            /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.fsg.api.RimServiceCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(int i, Map<String, Object> map) {
                JSONException jSONException;
                String str2;
                String str3;
                String str4;
                if (i == 0) {
                    String str5 = (String) map.get("retMsg");
                    try {
                        JSONObject jSONObject = new JSONObject((String) map.get("result"));
                        String optString = jSONObject.optString("callbackkey");
                        try {
                            str4 = jSONObject.optString("authsid");
                            str3 = optString;
                        } catch (JSONException e) {
                            str2 = optString;
                            jSONException = e;
                            Log.e(jSONException);
                            str3 = str2;
                            str4 = null;
                            JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(i, str5, str3, str4);
                            if (BaseActivity.this.biometricsIdentifyResult == null) {
                            }
                        }
                    } catch (JSONException e2) {
                        jSONException = e2;
                        str2 = null;
                    }
                    JSONObject livenessResult2JsonObj2 = BaseActivity.this.livenessResult2JsonObj(i, str5, str3, str4);
                    if (BaseActivity.this.biometricsIdentifyResult == null) {
                        BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(livenessResult2JsonObj2.toString());
                        return;
                    }
                    return;
                }
                JSONObject livenessResult2JsonObj3 = BaseActivity.this.livenessResult2JsonObj(i, (String) map.get("retMsg"), null, null);
                if (BaseActivity.this.biometricsIdentifyResult != null) {
                    BaseActivity.this.biometricsIdentifyResult.setIdentifyToken(livenessResult2JsonObj3.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bioScanFace(Context context, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager.getInstance().bioScanFace(context, bioScanFaceResult, new RimServiceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.14
            /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.fsg.api.RimServiceCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(int i, Map<String, Object> map) {
                JSONException jSONException;
                JSONObject jSONObject;
                JSONObject jSONObject2;
                if (i == 0) {
                    String str = (String) map.get("retMsg");
                    try {
                        jSONObject2 = new JSONObject((String) map.get("result"));
                    } catch (JSONException e) {
                        jSONException = e;
                        jSONObject = null;
                    }
                    try {
                        jSONObject2.remove("faceimage");
                        jSONObject2.remove("imgdigests");
                        jSONObject2.put("errno", i);
                        jSONObject2.put("errmsg", str);
                        jSONObject = jSONObject2;
                    } catch (JSONException e2) {
                        jSONException = e2;
                        jSONObject = jSONObject2;
                        Log.e(jSONException);
                        if (bioScanFaceResult == null) {
                        }
                    }
                    if (bioScanFaceResult == null) {
                        bioScanFaceResult.setScanFaceIdentifyResult(jSONObject.toString());
                        return;
                    }
                    return;
                }
                JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(i, (String) map.get("retMsg"), null, null);
                if (bioScanFaceResult != null) {
                    bioScanFaceResult.setScanFaceIdentifyResult(livenessResult2JsonObj.toString());
                }
            }
        });
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

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            if (iArr[0] == 0 && iArr[1] == 0) {
                takePhoto();
                return;
            }
            Toast.makeText(this, "请开启相机和存储权限", 1).show();
            if (this.pickPhotoResult != null) {
                this.pickPhotoResult.setImageData("");
            }
        } else if (i == 101) {
            if (iArr[0] == 0) {
                pickPhoto();
                return;
            }
            Toast.makeText(this, "请开启存储权限", 1).show();
            if (this.pickPhotoResult != null) {
                this.pickPhotoResult.setImageData("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ImageCropCallback imageCropCallback = PassportSDK.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = PassportSDK.getInstance().getActivityResultCallback();
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(i, i2, intent);
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
                if (i2 == -1 && imageCropCallback != null) {
                    imageCropCallback.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE)), new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.15
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
                if (i2 == -1 && intent.getData() != null && imageCropCallback != null) {
                    imageCropCallback.onImageCrop(this, intent.getData(), new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.16
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
}
