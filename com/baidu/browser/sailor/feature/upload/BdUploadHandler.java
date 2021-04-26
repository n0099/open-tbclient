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
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.core.permission.BdPermissionActivity;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.h.a.g;
import d.a.h.a.j.a;
import d.a.h.a.j.b;
import java.io.File;
/* loaded from: classes.dex */
public class BdUploadHandler implements INoProGuard {
    public static final String AUDIO_MIME_TYPE = "audio/*";
    public static final String IMAGE_MIME_TYPE = "image/*";
    public static final String MEDIA_SOURCE_KEY = "capture";
    public static final String MEDIA_SOURCE_VALUE_CAMCORDER = "camcorder";
    public static final String MEDIA_SOURCE_VALUE_CAMERA = "camera";
    public static final String MEDIA_SOURCE_VALUE_FILE_SYSTEM = "filesystem";
    public static final String MEDIA_SOURCE_VALUE_MICROPHONE = "microphone";
    public static final String VIDEO_MIME_TYPE = "video/*";
    public Activity mActivity;
    public String mCameraFilePath;
    public boolean mCanHandleResult = false;
    public boolean mCaughtActivityNotFoundException;
    public boolean mHandled;
    public WebChromeClient.FileChooserParams mParams;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessage1;

    public BdUploadHandler(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent createCamcorderIntent() {
        if (b.a(this.mActivity)) {
            return new Intent("android.media.action.VIDEO_CAPTURE");
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra("request_code", 4099);
        intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
        a.b().a(4099, new d.a.h.b.c.b.b(this));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public Intent createCameraIntentAfterCheckPermission() {
        Uri fromFile;
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

    private Intent createChooserIntent(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", this.mActivity.getResources().getString(g.d("string", "sailor_choose_upload")));
        return intent;
    }

    private Intent createSoundRecorderIntent() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public void cancelUpload() {
        ValueCallback<Uri> valueCallback = this.mUploadMessage;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
        ValueCallback<Uri[]> valueCallback2 = this.mUploadMessage1;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
        }
    }

    public Intent createCameraIntent() {
        if (b.a(this.mActivity) && b.b(this.mActivity)) {
            return createCameraIntentAfterCheckPermission();
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra("request_code", 4099);
        intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION});
        a.b().a(4099, new d.a.h.b.c.b.a(this));
        return intent;
    }

    @SuppressLint({"NewApi"})
    public Intent createDefaultOpenableIntent() {
        WebChromeClient.FileChooserParams fileChooserParams;
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

    public Intent createOpenableIntent(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        return intent;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public String getFilePath() {
        return this.mCameraFilePath;
    }

    public boolean handled() {
        return this.mHandled;
    }

    public void onOpenFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.mUploadMessage1 = valueCallback;
        this.mParams = fileChooserParams;
    }

    public void onOpenFileChooser(ValueCallback<Uri> valueCallback, String str) {
        this.mUploadMessage = valueCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0041 A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:2:0x0000, B:4:0x0005, B:9:0x000d, B:13:0x0014, B:15:0x0018, B:21:0x0021, B:26:0x002c, B:29:0x0034, B:31:0x0041, B:33:0x0047, B:35:0x006c, B:37:0x007b, B:34:0x0068, B:38:0x007f, B:41:0x0085, B:42:0x008f, B:43:0x0094, B:45:0x0098, B:46:0x009d), top: B:51:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098 A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:2:0x0000, B:4:0x0005, B:9:0x000d, B:13:0x0014, B:15:0x0018, B:21:0x0021, B:26:0x002c, B:29:0x0034, B:31:0x0041, B:33:0x0047, B:35:0x006c, B:37:0x007b, B:34:0x0068, B:38:0x007f, B:41:0x0085, B:42:0x008f, B:43:0x0094, B:45:0x0098, B:46:0x009d), top: B:51:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResult(int i2, Intent intent) {
        Uri uri;
        File file;
        Uri fromFile;
        try {
            if (this.mCanHandleResult) {
                this.mCanHandleResult = false;
                return;
            }
            if (i2 == -1 && intent == null && this.mCameraFilePath == null) {
                i2 = 0;
            }
            if (i2 == 0 && this.mCaughtActivityNotFoundException) {
                this.mCaughtActivityNotFoundException = false;
                return;
            }
            if (intent != null && i2 == -1) {
                uri = intent.getData();
                if (uri == null && ((intent == null || intent.getData() == null) && i2 == -1)) {
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

    public void onResult(Uri uri) {
        ValueCallback<Uri> valueCallback = this.mUploadMessage;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uri);
        }
        ValueCallback<Uri[]> valueCallback2 = this.mUploadMessage1;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(new Uri[]{uri});
        }
    }

    public boolean openFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Intent intent;
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
                } catch (Exception e2) {
                    Log.printStackTrace(e2);
                }
            }
        }
        try {
            return startActivityForResult(createDefaultOpenableIntent(), 11);
        } catch (Exception e3) {
            Log.printStackTrace(e3);
            return false;
        }
    }

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        this.mUploadMessage = valueCallback;
        String[] split = str.split(";");
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

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mUploadMessage = valueCallback;
        String[] split = str.split(";");
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

    public boolean openFileChooser(String str, String str2) {
        if (str != null && str2 != null) {
            this.mCameraFilePath = null;
            try {
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
            if (str2.equals(IMAGE_MIME_TYPE)) {
                if (str.equals(MEDIA_SOURCE_VALUE_CAMERA)) {
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
                } catch (Exception e3) {
                    Log.printStackTrace(e3);
                }
            }
        }
        return false;
    }

    public boolean startActivityForResult(Intent intent, int i2) {
        try {
            this.mActivity.startActivityForResult(intent, i2);
            return true;
        } catch (ActivityNotFoundException e2) {
            try {
                this.mCaughtActivityNotFoundException = true;
                this.mActivity.startActivityForResult(createDefaultOpenableIntent(), i2);
                return true;
            } catch (ActivityNotFoundException unused) {
                Log.printStackTrace(e2);
                cancelUpload();
                return false;
            }
        }
    }
}
