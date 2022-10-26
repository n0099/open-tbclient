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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.ClipBoxView;
import com.baidu.sapi2.views.FingerprintDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseActivity extends TitleActivity {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final String k;
    public static final String l = "javascript:(function(){if(window.Pass && window.Pass.client && window.Pass.client.screenShot){Pass.client.screenShot()}}())";
    public static final String m = "camera_temp_image.jpg";
    public static final int n = 1001;
    public static final int o = 1002;
    public static final int p = 1003;
    public static final int q = 1005;
    public static final int r = 1006;
    public static final int s = 2001;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueCallback a;
    public ValueCallback b;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(683830381, "Lcom/baidu/sapi2/activity/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(683830381, "Lcom/baidu/sapi2/activity/BaseActivity;");
                return;
            }
        }
        k = BaseActivity.class.getSimpleName();
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private ActivityResultCallback a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return new ActivityResultCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.ActivityResultCallback
                public void onActivityResult(int i, int i2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIIL(1048576, this, i, i2, intent) == null) && i == 1003) {
                        if (i2 == -1) {
                            byte[] byteArrayExtra = intent.getByteArrayExtra(ImageClipActivity.EXTRA_IMAGE);
                            if (byteArrayExtra != null && this.a.h != null) {
                                this.a.h.onImageResult(SecurityUtil.base64Encode(byteArrayExtra));
                            }
                        } else if (this.a.h != null) {
                            this.a.h.onImageResult(null);
                        }
                    }
                }
            };
        }
        return (ActivityResultCallback) invokeV.objValue;
    }

    private ImageCropCallback b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            return new ImageCropCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.ImageCropCallback
                public void onImageCrop(Context context, Uri uri, int i, int i2, ImageCropCallback.ImageCropResult imageCropResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2), imageCropResult}) != null) {
                        return;
                    }
                    this.a.h = imageCropResult;
                    Intent intent = new Intent(context, ImageClipActivity.class);
                    if (i == ClipBoxView.H) {
                        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 0);
                    } else {
                        intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 1);
                    }
                    intent.putExtra(ImageClipActivity.EXTRA_PARAM_UPLOAD_IMAGE_MAX_SIZE, i2);
                    intent.setData(uri);
                    this.a.startActivityForResult(intent, 1003);
                }
            };
        }
        return (ImageCropCallback) invokeV.objValue;
    }

    public void initScreenShotManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScreenShotManager screenShotManager = new ScreenShotManager();
            this.i = screenShotManager;
            screenShotManager.init(getContentResolver(), new IScreenShotListener(this) { // from class: com.baidu.sapi2.activity.BaseActivity.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.shell.listener.IScreenShotListener
                public void onScreenShot() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.runOnUiThread(new Runnable(this) { // from class: com.baidu.sapi2.activity.BaseActivity.24.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass24 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                SapiWebView sapiWebView;
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (sapiWebView = this.a.a.sapiWebView) != null) {
                                    sapiWebView.loadUrl(BaseActivity.l);
                                }
                            }
                        });
                    }
                }
            });
            this.i.register();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onLeftBtnClick();
            SapiUtils.hideSoftInput(this);
            this.executeSubClassMethod = true;
            TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
            if (titleBtnCallback != null) {
                this.executeSubClassMethod = true ^ titleBtnCallback.onLeftBtnClick();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_PAUSE);
            try {
                this.sapiWebView.onPause();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            this.sapiWebView.asyncNaLifeCycle2H5(SapiWebView.ActivityLifeCycle.ON_RESUME);
            try {
                this.sapiWebView.onResume();
            } catch (Exception unused) {
            }
        }
    }

    public void releaseScreenShotManager() {
        ScreenShotManager screenShotManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (screenShotManager = this.i) != null) {
            screenShotManager.unRegister();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (this.sapiWebView.onKeyUp(i)) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (SapiUtils.checkRequestPermission(h.i, this)) {
                initScreenShotManager();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
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
        return (JSONObject) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, activity, bioScanFaceResult) == null) {
            BiometricsManager biometricsManager = BiometricsManager.getInstance();
            PassFaceRecogCallback passFaceRecogCallback = new PassFaceRecogCallback(this, bioScanFaceResult) { // from class: com.baidu.sapi2.activity.BaseActivity.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView.BioScanFaceCallback.BioScanFaceResult a;
                public final /* synthetic */ BaseActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bioScanFaceResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = bioScanFaceResult;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) != null) {
                        return;
                    }
                    JSONObject a = this.b.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                    SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2 = this.a;
                    if (bioScanFaceResult2 != null) {
                        bioScanFaceResult2.setScanFaceIdentifyResult(a.toString());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                    SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult2;
                    String str;
                    JSONObject jSONObject;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048579, this, passFaceRecogResult) != null) || (bioScanFaceResult2 = this.a) == null) {
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
                            this.a.setScanFaceIdentifyResult(str);
                            return;
                        }
                        str = "";
                        this.a.setScanFaceIdentifyResult(str);
                        return;
                    }
                    this.a.setScanFaceIdentifyResult(this.b.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid).toString());
                }
            };
            if (bioScanFaceResult.type == 1) {
                biometricsManager.recogWithFaceDetect(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, "", passFaceRecogCallback);
            } else {
                biometricsManager.recogWithFaceOuter(activity, bioScanFaceResult.subpro, bioScanFaceResult.transParamsMap, "0", bioScanFaceResult.uid, passFaceRecogCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        SapiWebView sapiWebView;
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, this, intent) != null) || (sapiWebView = this.sapiWebView) == null || (jsCallBacks = sapiWebView.getJsCallBacks()) == null || (promptResult = jsCallBacks.getPromptResult()) == null) {
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
            Toast.makeText(this, "cancel", 0).show();
        }
    }

    private void a(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, uri) == null) {
            Intent intent = new Intent(this, ImageClipActivity.class);
            intent.putExtra(ImageClipActivity.EXTRA_PARAM_FROM_BUSINESS, 2);
            intent.setData(uri);
            startActivityForResult(intent, 1006);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ValueCallback valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, valueCallback) == null) {
            this.a = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1010);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, biometricsIdentifyResult) == null) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                Toast.makeText(this, "请先登录", 1).show();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this, biometricsIdentifyResult) { // from class: com.baidu.sapi2.activity.BaseActivity.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiWebView.BiometricsIdentifyResult a;
                public final /* synthetic */ BaseActivity b;

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, biometricsIdentifyResult};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = biometricsIdentifyResult;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("errno", getTplStokenResult.getResultCode());
                            jSONObject.put("errmsg", getTplStokenResult.getResultMsg());
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                        if (this.b.d != null) {
                            this.b.d.setIdentifyToken(jSONObject.toString());
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) {
                        String str = (String) getTplStokenResult.tplStokenMap.get("pp");
                        if (!TextUtils.isEmpty(str)) {
                            SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult2 = this.a;
                            if (biometricsIdentifyResult2.biometricType == 1) {
                                this.b.livenessRecognize(str, biometricsIdentifyResult2);
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
                        if (this.b.d != null) {
                            this.b.d.setIdentifyToken(jSONObject.toString());
                        }
                    }
                }
            }, currentAccount.bduss, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ValueCallback valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, valueCallback) == null) {
            this.b = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INTENT", intent);
            intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
            startActivityForResult(intent2, 1011);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 2001) {
                if (iArr.length > 0 && iArr[0] == 0) {
                    c();
                } else {
                    e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, str) == null) {
            IdCardOcrDTO idCardOcrDTO = new IdCardOcrDTO();
            idCardOcrDTO.context = this;
            idCardOcrDTO.type = str;
            CoreViewRouter.getInstance().loadIdCardOcr(idCardOcrDTO, new IdCardOcrCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.IdCardOcrCallback
                public void onFailure(IdCardOcrResult idCardOcrResult) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, idCardOcrResult) == null) && this.a.j != null) {
                        IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                        idcardOcrImageRusult.type = idCardOcrResult.type;
                        idcardOcrImageRusult.image = idCardOcrResult.image;
                        idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                        idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                        this.a.j.onFailure(idcardOcrImageRusult);
                    }
                }

                @Override // com.baidu.sapi2.callback.IdCardOcrCallback
                public void onSuccess(IdCardOcrResult idCardOcrResult) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, idCardOcrResult) == null) && this.a.j != null) {
                        IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                        idcardOcrImageRusult.type = idCardOcrResult.type;
                        idcardOcrImageRusult.image = idCardOcrResult.image;
                        idcardOcrImageRusult.setResultCode(idCardOcrResult.getResultCode());
                        idcardOcrImageRusult.setResultMsg(idCardOcrResult.getResultMsg());
                        this.a.j.onSuccess(idcardOcrImageRusult);
                    }
                }
            });
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            try {
                if (Build.VERSION.SDK_INT == 19) {
                    Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                    startActivityForResult(intent, 1005);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                intent2.setAction("android.intent.action.GET_CONTENT");
                startActivityForResult(intent2, 1005);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            releaseScreenShotManager();
            if (this.loginStatusChange) {
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
            try {
                ((RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c80)).removeView(this.sapiWebView);
                this.sapiWebView.removeAllViews();
                this.sapiWebView.destroy();
                this.sapiWebView = null;
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    public void pickPhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = this.configuration.context;
            permissionsDTO.permissions = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
            permissionsDTO.dialogTitle = "存储权限";
            permissionsDTO.dialogMsg = "为了正常使用图片上传、图片识别服务，请允许使用存储权限。你可以通过系统\"设置\"进行权限的管理";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        Toast.makeText(this.a, BaseOptionActivity.NO_STORAGE_PERM_MSG, 1).show();
                        if (this.a.c != null) {
                            this.a.c.setImageData("");
                        }
                    }
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        try {
                            if (Build.VERSION.SDK_INT == 19) {
                                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                                this.a.startActivityForResult(intent, 1002);
                                return;
                            }
                            Intent intent2 = new Intent();
                            intent2.setType(BdUploadHandler.IMAGE_MIME_TYPE);
                            intent2.setAction("android.intent.action.PICK");
                            this.a.startActivityForResult(intent2, 1002);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    public void takePhoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            PermissionsDTO permissionsDTO = new PermissionsDTO();
            permissionsDTO.context = this.configuration.context;
            permissionsDTO.permissions = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            permissionsDTO.dialogTitle = "权限申请";
            permissionsDTO.dialogMsg = "为了正常使用拍照服务、图片上传、图片识别服务，请允许使用摄像头权限。你可以通过系统\"设置\"进行权限的管理";
            PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onFailure(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        Toast.makeText(this.a, BaseOptionActivity.NO_CAMERA_PERM_MSG, 1).show();
                        if (this.a.c != null) {
                            this.a.c.setImageData("");
                        }
                    }
                }

                @Override // com.baidu.pass.permissions.PermissionsCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        try {
                            if (!"mounted".equals(Environment.getExternalStorageState())) {
                                Toast.makeText(this.a, (int) R.string.obfuscated_res_0x7f0f10b4, 0).show();
                                return;
                            }
                            File file = new File(this.a.getExternalCacheDir(), "camera_temp_image.jpg");
                            if (file.exists()) {
                                file.delete();
                            }
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            intent.setAction("android.media.action.IMAGE_CAPTURE");
                            File file2 = new File(this.a.getExternalCacheDir(), "camera_temp_image.jpg");
                            if (Build.VERSION.SDK_INT >= 24 && this.a.getApplicationInfo().targetSdkVersion >= 24) {
                                BaseActivity baseActivity = this.a;
                                intent.putExtra("output", FileProvider.getUriForFile(baseActivity, this.a.getPackageName() + ".passfileprovider", file2));
                            } else {
                                intent.putExtra("output", Uri.fromFile(file2));
                            }
                            intent.putExtra("orientation", 0);
                            this.a.startActivityForResult(intent, 1001);
                        } catch (Throwable th) {
                            Log.e(th);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                if (shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    new CommonDialog.Builder(this).setTitle(String.format("%1$sApp将打开“%2$s", PassBiometricUtil.getAppName(this), "相册")).setMessage(String.format("为了您使用识别功能，请允许%1$sApp打开%2$s。您可以通过系统“设置”进行权限的管理", PassBiometricUtil.getAppName(this), "相册")).setPositiveBtn("继续", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.BaseActivity.28
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                this.a.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2001);
                            }
                        }
                    }).setNegativeButton("关闭", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.BaseActivity.27
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                                IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                                idcardOcrImageRusult.setResultCode(-402);
                                idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                                this.a.j.onFailure(idcardOcrImageRusult);
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
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            CommonDialog build = new CommonDialog.Builder(this).setTitle("开启文件权限").setMessage("为了使用相册服务\n请开启文件权限").setPositiveBtn("去设置", new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.BaseActivity.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                        intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
                        if (intent.resolveActivity(this.a.getPackageManager()) != null) {
                            this.a.startActivity(intent);
                        }
                        if (this.a.j != null) {
                            IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                            idcardOcrImageRusult.setResultCode(-402);
                            idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                            this.a.j.onFailure(idcardOcrImageRusult);
                        }
                    }
                }
            }).setNegativeButton(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL, new View.OnClickListener(this) { // from class: com.baidu.sapi2.activity.BaseActivity.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && this.a.j != null) {
                        IdcardOcrImageRusult idcardOcrImageRusult = new IdcardOcrImageRusult();
                        idcardOcrImageRusult.setResultCode(-402);
                        idcardOcrImageRusult.setResultMsg(IdCardOcrResult.MESSAGE_NO_ALBUM_PERMISSION);
                        this.a.j.onFailure(idcardOcrImageRusult);
                    }
                }
            }).build();
            build.setCancelable(false);
            if (!isFinishing() && !build.isShowing()) {
                build.show();
            }
        }
    }

    public void livenessRecognize(String str, SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
        PassFaceRecogType passFaceRecogType;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, biometricsIdentifyResult) == null) {
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
            biometricsManager.livenessRecognize(this, passFaceRecogType, biometricsIdentifyResult.subPro, null, "0", str2, str, biometricsIdentifyResult.authToken, "", biometricsIdentifyResult.realName, biometricsIdentifyResult.idCardNum, biometricsIdentifyResult.phoneNum, false, false, biometricsIdentifyResult.extraParams, new PassFaceRecogCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) != null) {
                        return;
                    }
                    JSONObject a = this.a.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), null, null);
                    if (this.a.d != null) {
                        this.a.d.setIdentifyToken(a.toString());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048579, this, passFaceRecogResult) != null) {
                        return;
                    }
                    JSONObject a = this.a.a(passFaceRecogResult.getResultCode(), passFaceRecogResult.getResultMsg(), passFaceRecogResult.callbackkey, passFaceRecogResult.authSid);
                    if (this.a.d != null) {
                        this.a.d.setIdentifyToken(a.toString());
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
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
                    imageCropCallback2.onImageCrop(this, Uri.fromFile(new File(getExternalCacheDir(), "camera_temp_image.jpg")), this.f, this.g, new ImageCropCallback.ImageCropResult(this) { // from class: com.baidu.sapi2.activity.BaseActivity.20
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                if (str != null) {
                                    this.a.c.setImageData(str);
                                } else {
                                    this.a.c.setImageData("");
                                }
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
                    imageCropCallback2.onImageCrop(this, intent.getData(), this.f, this.g, new ImageCropCallback.ImageCropResult(this) { // from class: com.baidu.sapi2.activity.BaseActivity.21
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseActivity a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.baidu.sapi2.callback.ImageCropCallback.ImageCropResult
                        public void onImageResult(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                if (str != null) {
                                    this.a.c.setImageData(str);
                                } else {
                                    this.a.c.setImageData("");
                                }
                            }
                        }
                    });
                } else {
                    this.c.setImageData("");
                }
            } else if (i == 2001 && i2 == 3001) {
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
    }

    public void setNewLoginTitleAndSetStyleChangeCallBack() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.configuration.isNewLogin) {
            return;
        }
        try {
            ((RelativeLayout.LayoutParams) findViewById(R.id.sapi_webview).getLayoutParams()).addRule(3, 0);
        } catch (Exception unused) {
            Log.e(k, "子activity重写了webview布局");
        }
        this.sapiWebView.setHadMakeBarHide(true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c80);
        if (this.mTitleLayout == null) {
            this.mTitleLayout = (RelativeLayout) findViewById(R.id.sapi_title_layout);
        }
        ImageView imageView = null;
        RelativeLayout relativeLayout2 = this.mTitleLayout;
        if (relativeLayout2 != null && relativeLayout2.getChildCount() != 0) {
            relativeLayout.removeView(this.mTitleLayout);
            this.mTitleLayout.setBackgroundColor(0);
            for (int i = 0; i < this.mTitleLayout.getChildCount(); i++) {
                View childAt = this.mTitleLayout.getChildAt(i);
                if (childAt.getId() == R.id.title_right_close && this.configuration.showBottomBack) {
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
        this.sapiWebView.setSwitchStyleForCloseBtnAndStatusBarCallBack(new SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack(this, imageView) { // from class: com.baidu.sapi2.activity.BaseActivity.25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImageView a;
            public final /* synthetic */ BaseActivity b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, imageView};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = imageView;
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.SwitchStyleForCloseBtnAndStatusBarCallBack
            public void switchStyle(String str) {
                Window window;
                Window window2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    if (str.equals("1")) {
                        ImageView imageView2 = this.a;
                        if (imageView2 != null) {
                            imageView2.setColorFilter(-1);
                        }
                        if (Build.VERSION.SDK_INT < 23 || (window2 = this.b.getWindow()) == null) {
                            return;
                        }
                        window2.getDecorView().setSystemUiVisibility(1280);
                        return;
                    }
                    ImageView imageView3 = this.a;
                    if (imageView3 != null) {
                        imageView3.setColorFilter(-16777216);
                    }
                    if (Build.VERSION.SDK_INT < 23 || (window = this.b.getWindow()) == null) {
                        return;
                    }
                    window.getDecorView().setSystemUiVisibility(9216);
                }
            }
        });
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.setupViews();
            SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.sapi_webview);
            this.sapiWebView = sapiWebView;
            if (sapiWebView == null) {
                return;
            }
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
                sapiWebView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609de));
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
            this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
                public void onTitleChange(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        String string = this.a.getString(R.string.obfuscated_res_0x7f0f1080);
                        String string2 = this.a.getString(R.string.obfuscated_res_0x7f0f107f);
                        if (string.equals(str)) {
                            str = string2;
                        }
                        this.a.setTitleText(str);
                    }
                }
            });
            this.sapiWebView.setLocalConfigCallback(new SapiWebView.LocalConfigCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.LocalConfigCallback
                public List getFastLoginFeatureList() {
                    InterceptResult invokeV;
                    WebLoginDTO.Config config;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                        if (webLoginDTO != null && (config = webLoginDTO.config) != null) {
                            return config.fastLoginFeatureList;
                        }
                        return null;
                    }
                    return (List) invokeV.objValue;
                }
            });
            this.sapiWebView.setFileChooserCallback(new SapiWebView.FileChooserCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
                public void onFileChooser(ValueCallback valueCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, valueCallback) != null) {
                        return;
                    }
                    this.a.a(valueCallback);
                }

                @Override // com.baidu.sapi2.SapiWebView.FileChooserCallback
                public void onFileChooserForOSVersion5(ValueCallback valueCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, valueCallback) != null) {
                        return;
                    }
                    this.a.b(valueCallback);
                }
            });
            this.sapiWebView.setPickPhotoCallback(new SapiWebView.PickPhotoCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.PickPhotoCallback
                public void onPickImage(int i, int i2, int i3, SapiWebView.PickPhotoResult pickPhotoResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), pickPhotoResult}) != null) {
                        return;
                    }
                    this.a.c = pickPhotoResult;
                    this.a.f = i2;
                    this.a.g = i3;
                    if (1 == i) {
                        this.a.takePhoto();
                    } else {
                        this.a.pickPhoto();
                    }
                }
            });
            this.sapiWebView.setBiometricsIdentifyCallback(new SapiWebView.BiometricsIdentifyCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyCallback
                public void onBiometricsIdentify(SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, biometricsIdentifyResult) != null) {
                        return;
                    }
                    this.a.d = biometricsIdentifyResult;
                    if (!"bduss".equals(biometricsIdentifyResult.livenessRecogType)) {
                        if ("certinfo".equals(biometricsIdentifyResult.livenessRecogType) || "authtoken".equals(biometricsIdentifyResult.livenessRecogType)) {
                            this.a.livenessRecognize(null, biometricsIdentifyResult);
                            return;
                        }
                        return;
                    }
                    this.a.a(biometricsIdentifyResult);
                }
            });
            this.sapiWebView.setPageStateCallback(new SapiJsCallBacks.PageStateCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.PageStateCallback
                public void pageState(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.a.updateBottomBack(i);
                    }
                }
            });
            this.sapiWebView.setBioScanFaceCallback(new SapiWebView.BioScanFaceCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback
                public void onBioScanFace(SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bioScanFaceResult) == null) {
                        BaseActivity baseActivity = this.a;
                        baseActivity.a(baseActivity, bioScanFaceResult);
                    }
                }
            });
            this.sapiWebView.setInvokeScAppCallback(new SapiWebView.InvokeScAppCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback
                public void onInvokeScApp(String str, String str2, List list, SapiWebView.InvokeScAppCallback.InvokeScAppResult invokeScAppResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, str2, list, invokeScAppResult) == null) {
                        this.a.e = new SapiScheme();
                        this.a.e.invokeScApp(this.a, str, str2, list, invokeScAppResult);
                    }
                }
            });
            this.sapiWebView.setLoginStatusChangeCallback(new SapiJsCallBacks.LoginStatusChangeCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.LoginStatusChangeCallback
                public void onChange() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.loginStatusChange = true;
                    }
                }
            });
            this.sapiWebView.setFingerprintCallback(new SapiJsCallBacks.FingerprintCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintCallback
                public void onCallback(SapiJsCallBacks.FingerprintResult fingerprintResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fingerprintResult) == null) {
                        BaseActivity baseActivity = this.a;
                        new FingerprintHelper(baseActivity, new FingerprintDialog(baseActivity)).startAuthenticate(fingerprintResult.authType, new FingerprintCallback(this, fingerprintResult) { // from class: com.baidu.sapi2.activity.BaseActivity.10.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ SapiJsCallBacks.FingerprintResult a;
                            public final /* synthetic */ AnonymousClass10 b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fingerprintResult};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = fingerprintResult;
                            }

                            @Override // com.baidu.sapi2.touchid.FingerprintCallback
                            public void onCall(int i) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeI(1048576, this, i) == null) {
                                    this.a.setResult(i);
                                }
                            }
                        });
                    }
                }
            });
            this.sapiWebView.setSocialVerificationHandler(new Handler(this) { // from class: com.baidu.sapi2.activity.BaseActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                        if (thirdPartyService != null) {
                            thirdPartyService.loadThirdPartyLogin(this.a, (SocialType) message.obj, 2006, null, true);
                            SocialLoginBase.setWXLoginCallback(new WXInvokeCallback(this) { // from class: com.baidu.sapi2.activity.BaseActivity.11.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass11 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // com.baidu.sapi2.social.WXInvokeCallback
                                public void onResult(int i, Intent intent) {
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 != null && interceptable3.invokeIL(1048576, this, i, intent) != null) || i != 3001) {
                                        return;
                                    }
                                    this.a.a.a(intent);
                                }
                            });
                        }
                    }
                }
            });
            this.sapiWebView.setBiometricsIdentificationLiveCallBack(new SapiJsCallBacks.BiometricsIdentificationLiveCallBack(this) { // from class: com.baidu.sapi2.activity.BaseActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.BiometricsIdentificationLiveCallBack
                public void getLiveImage(int i, PassFaceRecogCallback passFaceRecogCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, passFaceRecogCallback) == null) {
                        BiometricsManager.getInstance().recogWithFaceLive(this.a, i, passFaceRecogCallback);
                    }
                }
            });
            this.sapiWebView.setIdcardOcrImageCallBack(new SapiJsCallBacks.IdcardOcrImageCallBack(this) { // from class: com.baidu.sapi2.activity.BaseActivity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.IdcardOcrImageCallBack
                public void getIdcardImage(String str, String str2, IdcardOcrImageCallback idcardOcrImageCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, str, str2, idcardOcrImageCallback) != null) {
                        return;
                    }
                    this.a.j = idcardOcrImageCallback;
                    if (!"album".equals(str)) {
                        if (!"camera".equals(str)) {
                            return;
                        }
                        this.a.a(str2);
                        return;
                    }
                    this.a.d();
                }
            });
            this.sapiWebView.setMakeVibrateCallBack(new SapiJsCallBacks.MakeVibrateCallBack(this) { // from class: com.baidu.sapi2.activity.BaseActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.MakeVibrateCallBack
                public void presetVibrate(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        VibrateUtils.presetVibrate(this.a);
                        AccessibleUtils.accessible(this.a, str);
                    }
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.MakeVibrateCallBack
                public void vibrate(long[] jArr, int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jArr, i, str) == null) {
                        VibrateUtils.vibrate(this.a, jArr, i);
                        AccessibleUtils.accessible(this.a, str);
                    }
                }
            });
        }
    }
}
