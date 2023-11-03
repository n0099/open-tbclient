package com.baidu.browser.sailor.feature.upload;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.core.permission.BdPermissionActivity;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.or;
import com.baidu.tieba.vr;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebKitFactory;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
/* loaded from: classes3.dex */
public class BdUploadHandler implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUDIO_MIME_TYPE = "audio/*";
    public static final String IMAGE_MIME_TYPE = "image/*";
    public static final String MEDIA_SOURCE_KEY = "capture";
    public static final String MEDIA_SOURCE_VALUE_CAMCORDER = "camcorder";
    public static final String MEDIA_SOURCE_VALUE_CAMERA = "camera";
    public static final String MEDIA_SOURCE_VALUE_FILE_SYSTEM = "filesystem";
    public static final String MEDIA_SOURCE_VALUE_MICROPHONE = "microphone";
    public static final String VIDEO_MIME_TYPE = "video/*";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public String mCameraFilePath;
    public boolean mCanHandleResult;
    public boolean mCaughtActivityNotFoundException;
    public boolean mHandled;
    public WebChromeClient.FileChooserParams mParams;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessage1;

    /* loaded from: classes3.dex */
    public class a implements ActivityCompat.OnRequestPermissionsResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdUploadHandler a;

        public a(BdUploadHandler bdUploadHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdUploadHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdUploadHandler;
        }

        @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
        public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                boolean z = iArr.length != 0;
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    Intent createCameraIntentAfterCheckPermission = this.a.createCameraIntentAfterCheckPermission();
                    this.a.mCanHandleResult = true;
                    this.a.startActivityForResult(createCameraIntentAfterCheckPermission, 11);
                }
                vr.b().d(4099);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ActivityCompat.OnRequestPermissionsResultCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdUploadHandler a;

        public b(BdUploadHandler bdUploadHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdUploadHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdUploadHandler;
        }

        @Override // com.baidu.permissionhelper.app.ActivityCompat.OnRequestPermissionsResultCallback
        public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                boolean z = iArr.length != 0;
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.mCanHandleResult = true;
                    this.a.mActivity.startActivityForResult(this.a.createCamcorderIntent(), 11);
                }
                vr.b().d(4099);
            }
        }
    }

    public BdUploadHandler(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCanHandleResult = false;
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent createCamcorderIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (wr.a(this.mActivity)) {
                return new Intent("android.media.action.VIDEO_CAPTURE");
            }
            Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
            vr.b().a(4099, new b(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public Intent createCameraIntentAfterCheckPermission() {
        InterceptResult invokeV;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (WebKitFactory.getContext() != null) {
                File externalFilesDir = WebKitFactory.getContext().getExternalFilesDir(Environment.DIRECTORY_DCIM);
                File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "browser-photos");
                file.mkdirs();
                this.mCameraFilePath = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
                if (Build.VERSION.SDK_INT >= 24) {
                    ContentValues contentValues = new ContentValues(1);
                    contentValues.put("_data", this.mCameraFilePath);
                    fromFile = BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                } else {
                    fromFile = Uri.fromFile(new File(this.mCameraFilePath));
                }
                intent.putExtra("output", fromFile);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                intent.setFlags(3);
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    private Intent createChooserIntent(Intent... intentArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, intentArr)) == null) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", this.mActivity.getResources().getString(or.d(EMABTest.TYPE_STRING, "sailor_choose_upload")));
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    private Intent createSoundRecorderIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new Intent("android.provider.MediaStore.RECORD_SOUND") : (Intent) invokeV.objValue;
    }

    public void cancelUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueCallback<Uri> valueCallback = this.mUploadMessage;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.mUploadMessage1;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
    }

    public Intent createCameraIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (wr.a(this.mActivity) && wr.b(this.mActivity)) {
                return createCameraIntentAfterCheckPermission();
            }
            Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"});
            vr.b().a(4099, new a(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    public Intent createDefaultOpenableIntent() {
        InterceptResult invokeV;
        WebChromeClient.FileChooserParams fileChooserParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent createChooserIntent = createChooserIntent(createCameraIntent(), createCamcorderIntent(), createSoundRecorderIntent());
            createChooserIntent.putExtra("android.intent.extra.INTENT", intent);
            if (Build.VERSION.SDK_INT >= 21 && (fileChooserParams = this.mParams) != null) {
                createChooserIntent.putExtra("android.intent.extra.INTENT", fileChooserParams.createIntent());
            }
            return createChooserIntent;
        }
        return (Intent) invokeV.objValue;
    }

    public Intent createOpenableIntent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActivity : (Activity) invokeV.objValue;
    }

    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCameraFilePath : (String) invokeV.objValue;
    }

    public boolean handled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHandled : invokeV.booleanValue;
    }

    public void onOpenFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, valueCallback, fileChooserParams) == null) {
            this.mUploadMessage1 = valueCallback;
            this.mParams = fileChooserParams;
        }
    }

    public void onOpenFileChooser(ValueCallback<Uri> valueCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, valueCallback, str) == null) {
            this.mUploadMessage = valueCallback;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0045 A[Catch: all -> 0x00a6, TryCatch #0 {all -> 0x00a6, blocks: (B:4:0x0004, B:6:0x0009, B:11:0x0011, B:15:0x0018, B:17:0x001c, B:23:0x0025, B:28:0x0030, B:31:0x0038, B:33:0x0045, B:35:0x004b, B:37:0x0070, B:39:0x007f, B:36:0x006c, B:40:0x0083, B:43:0x0089, B:44:0x0093, B:45:0x0098, B:47:0x009c, B:48:0x00a1), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009c A[Catch: all -> 0x00a6, TryCatch #0 {all -> 0x00a6, blocks: (B:4:0x0004, B:6:0x0009, B:11:0x0011, B:15:0x0018, B:17:0x001c, B:23:0x0025, B:28:0x0030, B:31:0x0038, B:33:0x0045, B:35:0x004b, B:37:0x0070, B:39:0x007f, B:36:0x006c, B:40:0x0083, B:43:0x0089, B:44:0x0093, B:45:0x0098, B:47:0x009c, B:48:0x00a1), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResult(int i, Intent intent) {
        Uri uri;
        File file;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, intent) == null) {
            try {
                if (this.mCanHandleResult) {
                    this.mCanHandleResult = false;
                    return;
                }
                if (i == -1 && intent == null && this.mCameraFilePath == null) {
                    i = 0;
                }
                if (i == 0 && this.mCaughtActivityNotFoundException) {
                    this.mCaughtActivityNotFoundException = false;
                    return;
                }
                if (intent != null && i == -1) {
                    uri = intent.getData();
                    if (uri == null && ((intent == null || intent.getData() == null) && i == -1)) {
                        file = new File(this.mCameraFilePath);
                        if (file.exists()) {
                            if (Build.VERSION.SDK_INT >= 24) {
                                ContentValues contentValues = new ContentValues(1);
                                contentValues.put("_data", file.getAbsolutePath());
                                fromFile = BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            } else {
                                fromFile = Uri.fromFile(file);
                            }
                            uri = fromFile;
                            this.mActivity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
                            if (uri == null) {
                                uri = Uri.fromFile(file);
                            }
                        }
                    }
                    if (this.mUploadMessage1 != null) {
                        if (uri != null) {
                            this.mUploadMessage1.onReceiveValue(new Uri[]{uri});
                        } else {
                            this.mUploadMessage1.onReceiveValue(null);
                        }
                    }
                    if (this.mUploadMessage != null) {
                        this.mUploadMessage.onReceiveValue(uri);
                    }
                    this.mHandled = true;
                    this.mCaughtActivityNotFoundException = false;
                }
                uri = null;
                if (uri == null) {
                    file = new File(this.mCameraFilePath);
                    if (file.exists()) {
                    }
                }
                if (this.mUploadMessage1 != null) {
                }
                if (this.mUploadMessage != null) {
                }
                this.mHandled = true;
                this.mCaughtActivityNotFoundException = false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void onResult(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, uri) == null) {
            ValueCallback<Uri> valueCallback = this.mUploadMessage;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(uri);
            }
            ValueCallback<Uri[]> valueCallback2 = this.mUploadMessage1;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(new Uri[]{uri});
            }
        }
    }

    public boolean openFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, valueCallback, fileChooserParams)) == null) {
            this.mUploadMessage1 = valueCallback;
            this.mParams = fileChooserParams;
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            String str = (acceptTypes == null || acceptTypes.length <= 0) ? "*/*" : acceptTypes[0];
            Intent[] intentArr = null;
            if (str.equals(IMAGE_MIME_TYPE)) {
                intentArr = new Intent[]{createCameraIntent()};
            } else if (str.equals(VIDEO_MIME_TYPE)) {
                intentArr = new Intent[]{createCamcorderIntent()};
            } else if (str.equals(AUDIO_MIME_TYPE)) {
                intentArr = new Intent[]{createSoundRecorderIntent()};
            }
            if (intentArr != null && intentArr.length > 0) {
                if (fileChooserParams.isCaptureEnabled() && intentArr.length == 1) {
                    intent = intentArr[0];
                } else {
                    Intent intent2 = new Intent("android.intent.action.CHOOSER");
                    intent2.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
                    if (Build.VERSION.SDK_INT >= 21 && fileChooserParams != null) {
                        intent2.putExtra("android.intent.extra.INTENT", fileChooserParams.createIntent());
                    }
                    intent = intent2;
                }
                if (intent != null) {
                    try {
                        return startActivityForResult(intent, 11);
                    } catch (Exception e) {
                        Log.printStackTrace(e);
                    }
                }
            }
            try {
                return startActivityForResult(createDefaultOpenableIntent(), 11);
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, valueCallback, str)) == null) {
            this.mUploadMessage = valueCallback;
            String[] split = str.split(ParamableElem.DIVIDE_PARAM);
            String str2 = split[0];
            String str3 = "";
            for (String str4 : split) {
                String[] split2 = str4.split("=");
                if (split2.length == 2 && MEDIA_SOURCE_KEY.equals(split2[0])) {
                    str3 = split2[1];
                }
            }
            return openFileChooser(str3, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, valueCallback, str, str2)) == null) {
            this.mUploadMessage = valueCallback;
            String[] split = str.split(ParamableElem.DIVIDE_PARAM);
            String str3 = split[0];
            String str4 = str2.length() > 0 ? str2 : "";
            if (str2.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                for (String str5 : split) {
                    String[] split2 = str5.split("=");
                    if (split2.length == 2 && MEDIA_SOURCE_KEY.equals(split2[0])) {
                        str4 = split2[1];
                    }
                }
            }
            return openFileChooser(str4, str3);
        }
        return invokeLLL.booleanValue;
    }

    public boolean openFileChooser(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                this.mCameraFilePath = null;
                try {
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
                if (str2.equals(IMAGE_MIME_TYPE)) {
                    if (str.equals("camera")) {
                        return startActivityForResult(createCameraIntent(), 11);
                    }
                    if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                        return startActivityForResult(createOpenableIntent(IMAGE_MIME_TYPE), 11);
                    }
                    Intent createChooserIntent = createChooserIntent(createCameraIntent());
                    createChooserIntent.putExtra("android.intent.extra.INTENT", createOpenableIntent(IMAGE_MIME_TYPE));
                    return startActivityForResult(createChooserIntent, 11);
                } else if (str2.equals(VIDEO_MIME_TYPE)) {
                    if (str.equals(MEDIA_SOURCE_VALUE_CAMCORDER)) {
                        return startActivityForResult(createCamcorderIntent(), 11);
                    }
                    if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                        return startActivityForResult(createOpenableIntent(VIDEO_MIME_TYPE), 11);
                    }
                    Intent createChooserIntent2 = createChooserIntent(createCamcorderIntent());
                    createChooserIntent2.putExtra("android.intent.extra.INTENT", createOpenableIntent(VIDEO_MIME_TYPE));
                    return startActivityForResult(createChooserIntent2, 11);
                } else {
                    if (str2.equals(AUDIO_MIME_TYPE)) {
                        if (str.equals(MEDIA_SOURCE_VALUE_MICROPHONE)) {
                            return startActivityForResult(createSoundRecorderIntent(), 11);
                        }
                        if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                            return startActivityForResult(createOpenableIntent(AUDIO_MIME_TYPE), 11);
                        }
                        Intent createChooserIntent3 = createChooserIntent(createSoundRecorderIntent());
                        createChooserIntent3.putExtra("android.intent.extra.INTENT", createOpenableIntent(AUDIO_MIME_TYPE));
                        return startActivityForResult(createChooserIntent3, 11);
                    }
                    try {
                        return startActivityForResult(createDefaultOpenableIntent(), 11);
                    } catch (Exception e2) {
                        Log.printStackTrace(e2);
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, intent, i)) == null) {
            try {
                this.mActivity.startActivityForResult(intent, i);
                return true;
            } catch (ActivityNotFoundException e) {
                try {
                    this.mCaughtActivityNotFoundException = true;
                    this.mActivity.startActivityForResult(createDefaultOpenableIntent(), i);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    Log.printStackTrace(e);
                    cancelUpload();
                    return false;
                }
            }
        }
        return invokeLI.booleanValue;
    }
}
