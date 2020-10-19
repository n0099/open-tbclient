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
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.k.a.a;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
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
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.f.a;
import com.baidu.sapi2.g.c;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BaseActivity extends TitleActivity {
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_ACCOUNT_CENTER = 2003;
    public static final int EXTRA_PARAM_FROM_CHOICE_SHARE = 2004;
    public static final int EXTRA_PARAM_FROM_GRANT_WAP = 2005;
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final int REQUEST_CODE_FILECHOOSER = 1010;
    public static final int REQUEST_CODE_FILECHOOSER_FOR_ANDROID_5 = 1011;
    protected static final int REQUEST_CODE_LOGIN = 1004;
    private static final String j = BaseActivity.class.getSimpleName();
    private static final String k = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";
    private static final String l = "camera_temp_image.jpg";
    private static final int m = 1001;
    private static final int n = 1002;
    private static final int o = 1003;

    /* renamed from: a  reason: collision with root package name */
    private ValueCallback<Uri> f3317a;
    private ValueCallback<Uri[]> b;
    private SapiWebView.PickPhotoResult c;
    private SapiWebView.BiometricsIdentifyResult d;
    private a e;
    private int f;
    private int g;
    private ImageCropCallback.ImageCropResult h;
    private com.baidu.sapi2.shell.a.a i;
    protected boolean loginStatusChange;
    protected SapiWebView sapiWebView;

    public void initScreenShotManager() {
        this.i = new com.baidu.sapi2.shell.a.a();
        this.i.a(getContentResolver(), new IScreenShotListener() { // from class: com.baidu.sapi2.activity.BaseActivity.20
            @Override // com.baidu.sapi2.shell.listener.IScreenShotListener
            public void onScreenShot() {
                BaseActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.sapi2.activity.BaseActivity.20.1
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
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType = PassFaceRecogType.RECOG_TYPE_BDUSS;
        String str2 = null;
        if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            str2 = currentAccount == null ? "" : currentAccount.bduss;
        } else if ("authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
            passFaceRecogType = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
        } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType)) {
            passFaceRecogType = PassFaceRecogType.RECOG_TYPE_CERTINFO;
        }
        biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult.subPro, null, "0", str2, str, biometricsIdentifyResult.authToken, "", biometricsIdentifyResult.realName, biometricsIdentifyResult.idCardNum, biometricsIdentifyResult.phoneNum, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a2.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a2 = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a2.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        ImageCropCallback b;
        ActivityResultCallback a2;
        a aVar;
        super.onActivityResult(i, i2, intent);
        ImageCropCallback imageCropCallback = CoreViewRouter.getInstance().getImageCropCallback();
        ActivityResultCallback activityResultCallback = CoreViewRouter.getInstance().getActivityResultCallback();
        if (imageCropCallback == null || activityResultCallback == null) {
            b = b();
            a2 = a();
        } else {
            b = imageCropCallback;
            a2 = activityResultCallback;
        }
        if (a2 != null) {
            a2.onActivityResult(i, i2, intent);
        }
        if (i == 1010) {
            if (this.f3317a != null) {
                this.f3317a.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.f3317a = null;
            }
        } else if (i == 1011) {
            if (this.b != null) {
                Uri data = (intent == null || i2 != -1) ? null : intent.getData();
                if (data != null) {
                    this.b.onReceiveValue(new Uri[]{data});
                } else {
                    this.b.onReceiveValue(new Uri[0]);
                }
                this.b = null;
            }
        } else if (i == 1001) {
            if (this.c != null) {
                if (i2 == -1 && b != null) {
                    b.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), l)), this.f, this.g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.16
                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            if (str != null) {
                                BaseActivity.this.c.setImageData(str);
                            } else {
                                BaseActivity.this.c.setImageData("");
                            }
                        }
                    });
                } else {
                    this.c.setImageData("");
                }
            }
        } else if (i != 1002) {
            if (i != 3001 || (aVar = this.e) == null) {
                return;
            }
            aVar.a(i, i2, intent);
        } else if (this.c != null) {
            if (i2 == -1 && intent.getData() != null && b != null) {
                b.onImageCrop(this, intent.getData(), this.f, this.g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.17
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        if (str != null) {
                            BaseActivity.this.c.setImageData(str);
                        } else {
                            BaseActivity.this.c.setImageData("");
                        }
                    }
                });
            } else {
                this.c.setImageData("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SapiUtils.checkRequestPermission("android.permission.READ_EXTERNAL_STORAGE", this)) {
            initScreenShotManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseScreenShotManager();
        LoginStatusChangeCallback loginStatusChangeCallback = CoreViewRouter.getLoginStatusChangeCallback();
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
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            this.executeSubClassMethod = !titleBtnCallback.onLeftBtnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
        try {
            this.sapiWebView.onPause();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
        try {
            this.sapiWebView.onResume();
        } catch (Exception e) {
        }
    }

    public void releaseScreenShotManager() {
        com.baidu.sapi2.shell.a.a aVar = this.i;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView = (SapiWebView) findViewById(a.e.sapi_webview);
        if (this.configuration.isDarkMode) {
            this.sapiWebView.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_color));
        }
        g.a(this, this.sapiWebView, getWebDTO() != null && getWebDTO().sweepLightLoading);
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
                WebLoginDTO.Config config;
                WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                if (webLoginDTO == null || (config = webLoginDTO.config) == null) {
                    return null;
                }
                return config.fastLoginFeatureList;
            }
        });
        this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.3
            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooser(ValueCallback<Uri> valueCallback) {
                BaseActivity.this.a(valueCallback);
            }

            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                BaseActivity.this.b(valueCallback);
            }
        });
        this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.4
            @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
            public void onPickImage(int i, int i2, int i3, SapiWebView.PickPhotoResult pickPhotoResult) {
                BaseActivity.this.c = pickPhotoResult;
                BaseActivity.this.f = i2;
                BaseActivity.this.g = i3;
                if (1 == i) {
                    BaseActivity.this.d();
                } else {
                    BaseActivity.this.c();
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.d = biometricsIdentifyResult;
                if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    BaseActivity.this.a(biometricsIdentifyResult);
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
                BaseActivity baseActivity = BaseActivity.this;
                baseActivity.a(baseActivity, bioScanFaceResult);
            }
        });
        this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.8
            @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback
            public void onInvokeScApp(String str, String str2, List<PassNameValuePair> list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                BaseActivity.this.e = new com.baidu.sapi2.f.a();
                BaseActivity.this.e.a(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
        if (CoreViewRouter.getLoginStatusChangeCallback() != null) {
            this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.9
                @Override // com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback
                public void onChange() {
                    BaseActivity.this.loginStatusChange = true;
                }
            });
        }
        this.sapiWebView.setFingerprintCallback(new SapiJsCallBacks.FingerprintCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.10
            @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback
            public void onCallback(final SapiJsCallBacks.FingerprintResult fingerprintResult) {
                BaseActivity baseActivity = BaseActivity.this;
                new c(baseActivity, new com.baidu.sapi2.views.a(baseActivity)).a(fingerprintResult.authType, new com.baidu.sapi2.g.a() { // from class: com.baidu.sapi2.activity.BaseActivity.10.1
                    @Override // com.baidu.sapi2.g.a
                    public void onCall(int i) {
                        fingerprintResult.setResult(i);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "存储权限";
        permissionsDTO.dialogMsg = "为了正常使用图片上传、图片识别服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.12
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, "请开启存储权限", 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
                }
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this;
        permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = "为了正常使用拍照服务、图片上传、图片识别服务，请允许使用摄像头和存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.11
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, "请开启相机和存储权限", 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
                }
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, a.g.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory(), BaseActivity.l);
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(Environment.getExternalStorageDirectory(), BaseActivity.l);
                    if (Build.VERSION.SDK_INT < 24 || BaseActivity.this.getApplicationInfo().targetSdkVersion < 24) {
                        intent.putExtra("output", Uri.fromFile(file2));
                    } else {
                        intent.putExtra("output", FileProvider.getUriForFile(BaseActivity.this, BaseActivity.this.getPackageName() + ".passfileprovider", file2));
                    }
                    intent.putExtra("orientation", 0);
                    BaseActivity.this.startActivityForResult(intent, 1001);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ValueCallback<Uri[]> valueCallback) {
        this.b = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 1011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ValueCallback<Uri> valueCallback) {
        this.f3317a = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
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
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.13
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
                    jSONObject.put(BaseJsonData.TAG_ERRNO, getTplStokenResult.getResultCode());
                    jSONObject.put(BaseJsonData.TAG_ERRMSG, getTplStokenResult.getResultMsg());
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(jSONObject.toString());
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
                    jSONObject.put(BaseJsonData.TAG_ERRNO, -402);
                    jSONObject.put(BaseJsonData.TAG_ERRMSG, "服务异常，请稍后再试");
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(jSONObject.toString());
                }
            }
        }, currentAccount.bduss, arrayList);
    }

    private ImageCropCallback b() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.18
            @Override // com.baidu.sapi2.callback.ImageCropCallback
            public void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropCallback.ImageCropResult imageCropResult) {
                BaseActivity.this.h = imageCropResult;
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
    public void a(Activity activity, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.15
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
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2 = bioScanFaceResult;
                if (bioScanFaceResult2 != null) {
                    String str = "";
                    if (bioScanFaceResult2.type != 1) {
                        bioScanFaceResult.setScanFaceIdentifyResult(BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
                        return;
                    }
                    try {
                        JSONObject jSONObject = passFaceRecogResult.extraJson;
                        if (jSONObject != null) {
                            jSONObject.remove("faceimage");
                            jSONObject.remove("imgdigests");
                            jSONObject.put(BaseJsonData.TAG_ERRNO, passFaceRecogResult.getResultCode());
                            jSONObject.put(BaseJsonData.TAG_ERRMSG, passFaceRecogResult.getResultMsg());
                            str = jSONObject.toString();
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    bioScanFaceResult.setScanFaceIdentifyResult(str);
                }
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
            jSONObject.put(BaseJsonData.TAG_ERRNO, i);
            jSONObject.put(BaseJsonData.TAG_ERRMSG, str);
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

    private ActivityResultCallback a() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.19
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i, int i2, Intent intent) {
                if (i == 1003) {
                    if (i2 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra != null && BaseActivity.this.h != null) {
                            BaseActivity.this.h.onImageResult(SapiDeviceUtils.DeviceCrypto.base64Encode(byteArrayExtra));
                        }
                    } else if (BaseActivity.this.h != null) {
                        BaseActivity.this.h.onImageResult(null);
                    }
                }
            }
        };
    }
}
