package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.pass.view.CommonDialog;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.IdCardOcrDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.provider.FileProvider;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.IdCardOcrResult;
import com.baidu.sapi2.result.IdcardOcrImageRusult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.shell.manager.ScreenShotManager;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.touchid.FingerprintCallback;
import com.baidu.sapi2.touchid.FingerprintHelper;
import com.baidu.sapi2.utils.AccessibleUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.VibrateUtils;
import com.baidu.sapi2.utils.a;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.FingerprintDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.toolbar.CommonToolbarStatisticConstants;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
    public static final int RESULT_CODE_THIRD_PARTY_VERIFY = 4001;
    public static final String k = BaseActivity.class.getSimpleName();
    public static final String l = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";
    public static final String m = "camera_temp_image.jpg";
    public static final int n = 1001;
    public static final int o = 1002;
    public static final int p = 1003;
    public static final int q = 1005;
    public static final int r = 1006;
    public static final int s = 2001;
    public ValueCallback<Uri> a;
    public ValueCallback<Uri[]> b;
    public SapiWebView.PickPhotoResult c;
    public SapiWebView.BiometricsIdentifyResult d;
    public SapiScheme e;
    public int f;
    public int g;
    public ImageCropCallback.ImageCropResult h;
    public ScreenShotManager i;
    public IdcardOcrImageCallback j;
    public boolean loginStatusChange;
    public SapiWebView sapiWebView;

    private ActivityResultCallback a() {
        return new ActivityResultCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.23
            @Override // com.baidu.sapi2.callback.ActivityResultCallback
            public void onActivityResult(int i, int i2, Intent intent) {
                if (i == 1003) {
                    if (i2 == -1) {
                        byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                        if (byteArrayExtra != null && BaseActivity.this.h != null) {
                            BaseActivity.this.h.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                        }
                    } else if (BaseActivity.this.h != null) {
                        BaseActivity.this.h.onImageResult(null);
                    }
                }
            }
        };
    }

    private ImageCropCallback b() {
        return new ImageCropCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.22
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

    private void c() {
        try {
            if (Build.VERSION.SDK_INT == 19) {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                startActivityForResult(intent, 1005);
            } else {
                Intent intent2 = new Intent();
                intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                intent2.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent2, 1005);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public void initScreenShotManager() {
        ScreenShotManager screenShotManager = new ScreenShotManager();
        this.i = screenShotManager;
        screenShotManager.init(getContentResolver(), new IScreenShotListener() { // from class: com.baidu.sapi2.activity.BaseActivity.24
            @Override // com.baidu.sapi2.shell.listener.IScreenShotListener
            public void onScreenShot() {
                BaseActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.sapi2.activity.BaseActivity.24.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SapiWebView sapiWebView = BaseActivity.this.sapiWebView;
                        if (sapiWebView != null) {
                            sapiWebView.loadUrl(BaseActivity.l);
                        }
                    }
                });
            }
        });
        this.i.register();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseScreenShotManager();
        if (this.loginStatusChange) {
            SapiAccountManager.getGlobalCallback().onLoginStatusChange();
        }
        try {
            ((RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091fb6)).removeView(this.sapiWebView);
            this.sapiWebView.removeAllViews();
            this.sapiWebView.destroy();
            this.sapiWebView = null;
        } catch (Exception e) {
            Log.e(e);
        }
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
        try {
            if (this.sapiWebView != null) {
                this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
                this.sapiWebView.onPause();
            }
        } catch (Exception unused) {
        }
    }

    public void pickPhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this.configuration.context;
        permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        permissionsDTO.dialogTitle = "存储权限";
        permissionsDTO.dialogMsg = "为了正常使用图片上传、图片识别服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.16
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_STORAGE_PERM_MSG, 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
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
                        intent2.setAction("android.intent.action.PICK");
                        BaseActivity.this.startActivityForResult(intent2, 1002);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        });
    }

    public void releaseScreenShotManager() {
        ScreenShotManager screenShotManager = this.i;
        if (screenShotManager != null) {
            screenShotManager.unRegister();
        }
    }

    public void takePhoto() {
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = this.configuration.context;
        permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
        permissionsDTO.dialogTitle = "权限申请";
        permissionsDTO.dialogMsg = "为了正常使用拍照服务、图片上传、图片识别服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.15
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                Toast.makeText(BaseActivity.this, BaseOptionActivity.NO_CAMERA_PERM_MSG, 1).show();
                if (BaseActivity.this.c != null) {
                    BaseActivity.this.c.setImageData("");
                }
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                try {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        Toast.makeText(BaseActivity.this, (int) R.string.sapi_sdk_user_profile_sdcard_unavailable, 0).show();
                        return;
                    }
                    File file = new File(BaseActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
                    if (file.exists()) {
                        file.delete();
                    }
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.setAction("android.media.action.IMAGE_CAPTURE");
                    File file2 = new File(BaseActivity.this.getExternalCacheDir(), "camera_temp_image.jpg");
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.onKeyUp(i)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ValueCallback<Uri[]> valueCallback) {
        this.b = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
        startActivityForResult(intent2, 1011);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (SapiUtils.checkRequestPermission(h.i, this)) {
            initScreenShotManager();
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
        } catch (JSONException e) {
            Log.e(e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, final SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2 = bioScanFaceResult;
                if (bioScanFaceResult2 != null) {
                    bioScanFaceResult2.setScanFaceIdentifyResult(a.toString());
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
                    } catch (JSONException e) {
                        Log.e(e);
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
            jSONObject.put("userId", intent.getStringExtra("userId"));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_UNION_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_UNION_ID));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME));
            jSONObject.put(EXTRA_PARAM_THIRD_VERIFY_APP_ID, intent.getStringExtra(EXTRA_PARAM_THIRD_VERIFY_APP_ID));
            jSONObject.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
            promptResult.confirm(jSONObject.toString());
        } catch (JSONException unused) {
            promptResult.cancel();
        }
    }

    private void a(Uri uri) {
        Intent intent = new Intent(this, ImageClipActivity.class);
        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 2);
        intent.setData(uri);
        startActivityForResult(intent, 1006);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ValueCallback<Uri> valueCallback) {
        this.a = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
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
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.17
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
                    jSONObject.put("errno", -402);
                    jSONObject.put("errmsg", "服务异常，请稍后再试");
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(jSONObject.toString());
                }
            }
        }, currentAccount.bduss, arrayList);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                c();
            } else {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        IdCardOcrDTO idCardOcrDTO = new IdCardOcrDTO();
        idCardOcrDTO.context = this;
        idCardOcrDTO.type = str;
        CoreViewRouter.getInstance().loadIdCardOcr(idCardOcrDTO, new IdCardOcrCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.26
            @Override // com.baidu.sapi2.callback.IdCardOcrCallback
            public void onFailure(IdCardOcrResult idCardOcrResult) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.type = idCardOcrResult.type;
                    idcardOcrImageRusult.image = idCardOcrResult.image;
                    idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                    idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }

            @Override // com.baidu.sapi2.callback.IdCardOcrCallback
            public void onSuccess(IdCardOcrResult idCardOcrResult) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.type = idCardOcrResult.type;
                    idcardOcrImageRusult.image = idCardOcrResult.image;
                    idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                    idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                    BaseActivity.this.j.onSuccess(idcardOcrImageRusult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            if (shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                new CommonDialog.Builder(this).setTitle(String.format("%1$sApp将打开“%2$s", PassBiometricUtil.getAppName(this), "相册")).setMessage(String.format("为了您使用识别功能，请允许%1$sApp打开%2$s。您可以通过系统“设置”进行权限的管理", PassBiometricUtil.getAppName(this), "相册")).setPositiveBtn("继续", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.28
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BaseActivity.this.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2001);
                    }
                }).setNegativeButton("关闭", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.27
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (BaseActivity.this.j != null) {
                            IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                            idcardOcrImageRusult.setResultCode(-402);
                            idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                            BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                        }
                    }
                }).build().show();
                return;
            } else {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2001);
                return;
            }
        }
        c();
    }

    private void e() {
        CommonDialog build = new CommonDialog.Builder(this).setTitle("开启文件权限").setMessage("为了使用相册服务\n请开启文件权限").setPositiveBtn("去设置", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.30
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setData(Uri.fromParts("package", BaseActivity.this.getPackageName(), null));
                if (intent.resolveActivity(BaseActivity.this.getPackageManager()) != null) {
                    BaseActivity.this.startActivity(intent);
                }
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.setResultCode(-402);
                    idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }
        }).setNegativeButton("取消", new View.OnClickListener() { // from class: com.baidu.sapi2.activity.BaseActivity.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (BaseActivity.this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.setResultCode(-402);
                    idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                    BaseActivity.this.j.onFailure(idcardOcrImageRusult);
                }
            }
        }).build();
        build.setCancelable(false);
        if (!isFinishing() && !build.isShowing()) {
            build.show();
        }
    }

    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        PassFaceRecogType passFaceRecogType;
        String str2;
        String str3;
        BiometricsManager biometricsManager = BiometricsManager.getInstance();
        PassFaceRecogType passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_BDUSS;
        if ("bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                str3 = "";
            } else {
                str3 = currentAccount.bduss;
            }
            str2 = str3;
            passFaceRecogType = passFaceRecogType2;
        } else {
            if ("authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_AUTHTOKEN;
            } else if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType)) {
                passFaceRecogType2 = PassFaceRecogType.RECOG_TYPE_CERTINFO;
            }
            passFaceRecogType = passFaceRecogType2;
            str2 = null;
        }
        biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult.subPro, null, "0", str2, str, biometricsIdentifyResult.authToken, "", biometricsIdentifyResult.realName, biometricsIdentifyResult.idCardNum, biometricsIdentifyResult.phoneNum, false, false, biometricsIdentifyResult.extraParams, new PassFaceRecogCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a.toString());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                JSONObject a = BaseActivity.this.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                if (BaseActivity.this.d != null) {
                    BaseActivity.this.d.setIdentifyToken(a.toString());
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        Uri uri2;
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
            if (this.c == null) {
                return;
            }
            if (i2 == -1 && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), this.f, this.g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.20
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
        } else if (i == 1002) {
            if (this.c == null) {
                return;
            }
            if (i2 == -1 && intent.getData() != null && imageCropCallback2 != null) {
                imageCropCallback2.onImageCrop(this, intent.getData(), this.f, this.g, new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.21
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
        } else if (i == 2001 && i2 == 4001) {
            a(intent);
        } else if (i == 1005) {
            if (intent == null) {
                if (this.j != null) {
                    IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                    idcardOcrImageRusult.setResultCode(-404);
                    idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_ALBUM_ERROR);
                    this.j.onFailure(idcardOcrImageRusult);
                    return;
                }
                return;
            }
            a(intent.getData());
        } else if (i == 1006) {
            if (this.j == null) {
                return;
            }
            if (intent != null && intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE) != null) {
                byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
                if (decodeByteArray.getHeight() > decodeByteArray.getWidth()) {
                    decodeByteArray = a.b(decodeByteArray, -90);
                }
                byte[] a = a.a(decodeByteArray, 100);
                IdcardOcrImageRusult idcardOcrImageRusult2 = new IdcardOcrImageRusult();
                idcardOcrImageRusult2.setResultCode(0);
                idcardOcrImageRusult2.image = Base64Utils.encodeToString(a);
                this.j.onSuccess(idcardOcrImageRusult2);
                return;
            }
            IdcardOcrImageRusult idcardOcrImageRusult3 = new IdcardOcrImageRusult();
            idcardOcrImageRusult3.setResultCode(-404);
            idcardOcrImageRusult3.setResultMsg(IdCardOcrResult.MESSAGE_ALBUM_ERROR);
            this.j.onFailure(idcardOcrImageRusult3);
        } else if (i == 1010) {
            if (this.a == null) {
                return;
            }
            if (intent != null && i2 == -1) {
                uri2 = intent.getData();
            } else {
                uri2 = null;
            }
            this.a.onReceiveValue(uri2);
            this.a = null;
        } else if (i != 1011 || this.b == null) {
        } else {
            if (intent != null && i2 == -1) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                this.b.onReceiveValue(new Uri[]{uri});
            } else {
                this.b.onReceiveValue(new Uri[0]);
            }
            this.b = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (this.sapiWebView != null) {
                this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
                this.sapiWebView.onResume();
            }
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager != null && sapiAccountManager.getConfignation() != null && this.sapiWebView != null && Build.VERSION.SDK_INT >= 29 && !sapiAccountManager.getConfignation().isDarkMode && !sapiAccountManager.getConfignation().isNightMode) {
                if ((getResources().getConfiguration().uiMode & 48) == 32) {
                    this.sapiWebView.getSettings().setForceDark(2);
                } else {
                    this.sapiWebView.getSettings().setForceDark(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void setNewLoginTitleAndSetStyleChangeCallBack() {
        if (!this.configuration.isNewLogin) {
            return;
        }
        try {
            ((RelativeLayout.LayoutParams) findViewById(R.id.obfuscated_res_0x7f0920e2).getLayoutParams()).addRule(3, 0);
        } catch (Exception unused) {
            Log.e(k, "子activity重写了webview布局");
        }
        this.sapiWebView.setHadMakeBarHide(true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091fb6);
        if (this.mTitleLayout == null) {
            this.mTitleLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0920e0);
        }
        final ImageView imageView = null;
        RelativeLayout relativeLayout2 = this.mTitleLayout;
        if (relativeLayout2 != null && relativeLayout2.getChildCount() != 0) {
            relativeLayout.removeView(this.mTitleLayout);
            this.mTitleLayout.setBackgroundColor(0);
            for (int i = 0; i < this.mTitleLayout.getChildCount(); i++) {
                View childAt = this.mTitleLayout.getChildAt(i);
                if (childAt.getId() == R.id.obfuscated_res_0x7f0925c4 && this.configuration.showBottomBack) {
                    childAt.setVisibility(0);
                    imageView = (ImageView) childAt;
                } else {
                    childAt.setVisibility(8);
                }
            }
            try {
                ((RelativeLayout.LayoutParams) this.mTitleLayout.getLayoutParams()).topMargin = ViewUtility.getStatusBarHeight(this);
            } catch (Exception unused2) {
                Log.e(k, "子activity重写了title布局");
            }
            relativeLayout.addView(this.mTitleLayout);
        }
        ViewUtility.newLoginStatusBarTint(this);
        this.sapiWebView.setSwitchStyleForCloseBtnAndStatusBarCallBack(new SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.25
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        boolean z;
        super.setupViews();
        SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.obfuscated_res_0x7f0920e2);
        this.sapiWebView = sapiWebView;
        if (sapiWebView == null) {
            return;
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
            sapiWebView.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_color));
        }
        if (getWebDTO() != null && getWebDTO().loadingView != null) {
            b.a(this, this.sapiWebView, getWebDTO().loadingView);
        } else {
            SapiWebView sapiWebView2 = this.sapiWebView;
            if (getWebDTO() != null && getWebDTO().sweepLightLoading) {
                z = true;
            } else {
                z = false;
            }
            b.a(this, sapiWebView2, z);
        }
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                String string = BaseActivity.this.getString(R.string.sapi_sdk_account_center_webview_title_online_service);
                String string2 = BaseActivity.this.getString(R.string.sapi_sdk_account_center_webview_title_common_problem);
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
                if (webLoginDTO != null && (config = webLoginDTO.config) != null) {
                    return config.fastLoginFeatureList;
                }
                return null;
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
                    BaseActivity.this.takePhoto();
                } else {
                    BaseActivity.this.pickPhoto();
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.d = biometricsIdentifyResult;
                if (!"bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                    if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType) || "authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                        BaseActivity.this.livenessRecognize(null, biometricsIdentifyResult);
                        return;
                    }
                    return;
                }
                BaseActivity.this.a(biometricsIdentifyResult);
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
                BaseActivity.this.e = new SapiScheme();
                BaseActivity.this.e.invokeScApp(BaseActivity.this, str, str2, list, invokeScAppResult);
            }
        });
        this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.9
            @Override // com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback
            public void onChange() {
                BaseActivity.this.loginStatusChange = true;
            }
        });
        this.sapiWebView.setFingerprintCallback(new SapiJsCallBacks.FingerprintCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.10
            @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback
            public void onCallback(final SapiJsCallBacks.FingerprintResult fingerprintResult) {
                BaseActivity baseActivity = BaseActivity.this;
                new FingerprintHelper(baseActivity, new FingerprintDialog(baseActivity)).startAuthenticate(fingerprintResult.authType, new FingerprintCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.10.1
                    @Override // com.baidu.sapi2.touchid.FingerprintCallback
                    public void onCall(int i) {
                        fingerprintResult.setResult(i);
                    }
                });
            }
        });
        this.sapiWebView.setSocialVerificationHandler(new Handler() { // from class: com.baidu.sapi2.activity.BaseActivity.11
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                if (thirdPartyService != null) {
                    thirdPartyService.loadThirdPartyLogin(BaseActivity.this, (SocialType) message.obj, 2006, null, true);
                    SocialLoginBase.setWXLoginCallback(new WXInvokeCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.11.1
                        @Override // com.baidu.sapi2.social.WXInvokeCallback
                        public void onResult(int i, Intent intent) {
                            if (i != 4001) {
                                return;
                            }
                            BaseActivity.this.a(intent);
                        }
                    });
                }
            }
        });
        this.sapiWebView.setBiometricsIdentificationLiveCallBack(new SapiJsCallBacks.BiometricsIdentificationLiveCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.12
            @Override // com.baidu.sapi2.SapiJsCallBacks.BiometricsIdentificationLiveCallBack
            public void getLiveImage(int i, PassFaceRecogCallback passFaceRecogCallback) {
                BiometricsManager.getInstance().recogWithFaceLive(BaseActivity.this, i, passFaceRecogCallback);
            }
        });
        this.sapiWebView.setIdcardOcrImageCallBack(new SapiJsCallBacks.IdcardOcrImageCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.13
            @Override // com.baidu.sapi2.SapiJsCallBacks.IdcardOcrImageCallBack
            public void getIdcardImage(String str, String str2, IdcardOcrImageCallback idcardOcrImageCallback) {
                BaseActivity.this.j = idcardOcrImageCallback;
                if (!CommonToolbarStatisticConstants.TOOLBAR_MENU_STAT_SOURCE_PICTURE_BROWSER.equals(str)) {
                    if (!"camera".equals(str)) {
                        return;
                    }
                    BaseActivity.this.a(str2);
                    return;
                }
                BaseActivity.this.d();
            }
        });
        this.sapiWebView.setMakeVibrateCallBack(new SapiJsCallBacks.MakeVibrateCallBack() { // from class: com.baidu.sapi2.activity.BaseActivity.14
            @Override // com.baidu.sapi2.SapiJsCallBacks.MakeVibrateCallBack
            public void presetVibrate(String str) {
                VibrateUtils.presetVibrate(BaseActivity.this);
                AccessibleUtils.accessible(BaseActivity.this, str);
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.MakeVibrateCallBack
            public void vibrate(long[] jArr, int i, String str) {
                VibrateUtils.vibrate(BaseActivity.this, jArr, i);
                AccessibleUtils.accessible(BaseActivity.this, str);
            }
        });
    }
}
