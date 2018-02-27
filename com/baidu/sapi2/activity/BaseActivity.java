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
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.baidu.c.a.a;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.utils.SapiWebViewUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseActivity extends Activity {
    private static final String CAPTURE_IMAGE_FILE = "camera_temp_image.jpg";
    public static final int FILECHOOSER_RESULTCODE = 1004;
    public static final int FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 1005;
    private static final int PERMISSION_CAMERA_WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 100;
    private static final int PERMISSION_WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 101;
    private static final int REQUEST_PICK_PHOTO = 1002;
    private static final int REQUEST_TAKE_PHOTO = 1001;
    private SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageForAndroid5;
    private SapiWebView.PickPhotoResult pickPhotoResult;
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
    public void init() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupViews() {
        this.sapiWebView = (SapiWebView) findViewById(a.d.sapi_webview);
        SapiWebViewUtil.addCustomView(this, this.sapiWebView);
        PassportViewManager.getInstance().setReloadWebviewObserver(new PassportViewManager.ReloadWebviewObserver() { // from class: com.baidu.sapi2.activity.BaseActivity.1
            @Override // com.baidu.sapi2.PassportViewManager.ReloadWebviewObserver
            public void onWebviewReload() {
                BaseActivity.this.sapiWebView.reload();
            }
        });
        this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.2
            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooser(ValueCallback<Uri> valueCallback) {
                BaseActivity.this.openFileChooserImpl(valueCallback);
            }

            @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
            public void onFileChooserForOSVersion5(ValueCallback<Uri[]> valueCallback) {
                BaseActivity.this.openFileChooserImplForAndroid5(valueCallback);
            }
        });
        this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.3
            @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
            public void onPickImage(int i, SapiWebView.PickPhotoResult pickPhotoResult) {
                BaseActivity.this.pickPhotoResult = pickPhotoResult;
                if (1 == i) {
                    if (Build.VERSION.SDK_INT < 23 || (BaseActivity.this.checkSelfPermission("android.permission.CAMERA") == 0 && BaseActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                        BaseActivity.this.takePhoto();
                    } else {
                        BaseActivity.this.requestPermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
                    }
                } else if (Build.VERSION.SDK_INT < 23 || BaseActivity.this.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    BaseActivity.this.pickPhoto();
                } else {
                    BaseActivity.this.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
                }
            }
        });
        this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.4
            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(int i, int i2, String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.biometricsIdentifyResult = biometricsIdentifyResult;
                BaseActivity.this.getStoken(i, str);
            }

            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(int i, int i2, String str, String str2, String str3, String str4, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.biometricsIdentifyResult = biometricsIdentifyResult;
                BaseActivity.this.livenessRecognize(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_CERTINFO, str, str2, str3, null, null, str4);
            }

            @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
            public void onBiometricsIdentify(int i, int i2, String str, String str2, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                BaseActivity.this.biometricsIdentifyResult = biometricsIdentifyResult;
                BaseActivity.this.livenessRecognize(BiometricsManager.LIVENESS_RECOGNIZE_TYPE_AUTHTOKEN, null, null, null, null, str, str2);
            }
        });
        this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.5
            @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback
            public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                BaseActivity.this.bioScanFace(BaseActivity.this, bioScanFaceResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFileChooserImpl(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1004);
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
        startActivityForResult(intent2, 1005);
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
            intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE)));
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
    public void getStoken(final int i, final String str) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session == null) {
            Toast.makeText(this, "请先登录", 1).show();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                String str2 = getTplStokenResult.tplStokenMap.get("pp");
                if (!TextUtils.isEmpty(str2)) {
                    if (i == 1) {
                        BaseActivity.this.livenessRecognize("bduss", null, null, null, str2, null, str);
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
    public void livenessRecognize(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        BiometricsManager.getInstance().livenessRecognize(getApplicationContext(), str, str2, str3, str4, str5, str6, str7, new RimServiceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.7
            /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.fsg.api.RimServiceCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(int i, Map<String, Object> map) {
                JSONException jSONException;
                String str8;
                String str9;
                String str10;
                if (i == 0) {
                    String str11 = (String) map.get("retMsg");
                    try {
                        JSONObject jSONObject = new JSONObject((String) map.get("result"));
                        String optString = jSONObject.optString("callbackkey");
                        try {
                            str10 = jSONObject.optString("authsid");
                            str9 = optString;
                        } catch (JSONException e) {
                            str8 = optString;
                            jSONException = e;
                            Log.e(jSONException);
                            str9 = str8;
                            str10 = null;
                            JSONObject livenessResult2JsonObj = BaseActivity.this.livenessResult2JsonObj(i, str11, str9, str10);
                            if (BaseActivity.this.biometricsIdentifyResult == null) {
                            }
                        }
                    } catch (JSONException e2) {
                        jSONException = e2;
                        str8 = null;
                    }
                    JSONObject livenessResult2JsonObj2 = BaseActivity.this.livenessResult2JsonObj(i, str11, str9, str10);
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
        BiometricsManager.getInstance().bioScanFace(context, bioScanFaceResult, new RimServiceCallback() { // from class: com.baidu.sapi2.activity.BaseActivity.8
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

    @Override // android.app.Activity
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
        if (i == 1004) {
            if (this.mUploadMessage != null) {
                this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                this.mUploadMessage = null;
            }
        } else if (i == 1005) {
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
            if (i2 == -1 && imageCropCallback != null) {
                imageCropCallback.onImageCrop(this, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CAPTURE_IMAGE_FILE)), new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.9
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        if (str == null || BaseActivity.this.pickPhotoResult == null) {
                            if (BaseActivity.this.pickPhotoResult != null) {
                                BaseActivity.this.pickPhotoResult.setImageData("");
                                return;
                            }
                            return;
                        }
                        BaseActivity.this.pickPhotoResult.setImageData(str);
                    }
                });
            } else if (this.pickPhotoResult != null) {
                this.pickPhotoResult.setImageData("");
            }
        } else if (i == 1002) {
            if (i2 == -1 && intent.getData() != null) {
                imageCropCallback.onImageCrop(this, intent.getData(), new ImageCropCallback.ImageCropResult() { // from class: com.baidu.sapi2.activity.BaseActivity.10
                    @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                    public void onImageResult(String str) {
                        if (str == null || BaseActivity.this.pickPhotoResult == null) {
                            if (BaseActivity.this.pickPhotoResult != null) {
                                BaseActivity.this.pickPhotoResult.setImageData("");
                                return;
                            }
                            return;
                        }
                        BaseActivity.this.pickPhotoResult.setImageData(str);
                    }
                });
            } else if (this.pickPhotoResult != null) {
                this.pickPhotoResult.setImageData("");
            }
        }
    }
}
