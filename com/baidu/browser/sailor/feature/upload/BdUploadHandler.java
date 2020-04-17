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
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.core.g;
import com.baidu.browser.core.permission.BdPermissionActivity;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
/* loaded from: classes11.dex */
public class BdUploadHandler implements INoProGuard {
    private static final String AUDIO_MIME_TYPE = "audio/*";
    private static final String IMAGE_MIME_TYPE = "image/*";
    private static final String MEDIA_SOURCE_KEY = "capture";
    private static final String MEDIA_SOURCE_VALUE_CAMCORDER = "camcorder";
    private static final String MEDIA_SOURCE_VALUE_CAMERA = "camera";
    private static final String MEDIA_SOURCE_VALUE_FILE_SYSTEM = "filesystem";
    private static final String MEDIA_SOURCE_VALUE_MICROPHONE = "microphone";
    private static final String VIDEO_MIME_TYPE = "video/*";
    private Activity mActivity;
    private String mCameraFilePath;
    private boolean mCanHandleResult = false;
    private boolean mCaughtActivityNotFoundException;
    private boolean mHandled;
    private WebChromeClient.FileChooserParams mParams;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessage1;

    public BdUploadHandler(Activity activity) {
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent createCamcorderIntent() {
        if (com.baidu.browser.core.permission.b.checkCamera(this.mActivity)) {
            return new Intent("android.media.action.VIDEO_CAPTURE");
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra("request_code", 4099);
        intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
        com.baidu.browser.core.permission.a.rd().a(4099, new b(this));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public Intent createCameraIntentAfterCheckPermission() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "browser-photos");
        file.mkdirs();
        this.mCameraFilePath = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
        if (Build.VERSION.SDK_INT >= 24) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_data", this.mCameraFilePath);
            intent.putExtra("output", BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
        } else {
            intent.putExtra("output", Uri.fromFile(new File(this.mCameraFilePath)));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            intent.setFlags(3);
        }
        return intent;
    }

    private Intent createChooserIntent(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", this.mActivity.getResources().getString(g.N("string", "sailor_choose_upload")));
        return intent;
    }

    private Intent createSoundRecorderIntent() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public void cancelUpload() {
        if (this.mUploadMessage != null) {
            this.mUploadMessage.onReceiveValue(null);
        }
        if (this.mUploadMessage1 != null) {
            this.mUploadMessage1.onReceiveValue(null);
        }
    }

    public Intent createCameraIntent() {
        if (com.baidu.browser.core.permission.b.checkCamera(this.mActivity)) {
            return createCameraIntentAfterCheckPermission();
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra("request_code", 4099);
        intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
        com.baidu.browser.core.permission.a.rd().a(4099, new a(this));
        return intent;
    }

    @SuppressLint({"NewApi"})
    public Intent createDefaultOpenableIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent createChooserIntent = createChooserIntent(createCameraIntent(), createCamcorderIntent(), createSoundRecorderIntent());
        createChooserIntent.putExtra("android.intent.extra.INTENT", intent);
        if (Build.VERSION.SDK_INT >= 21 && this.mParams != null) {
            createChooserIntent.putExtra("android.intent.extra.INTENT", this.mParams.createIntent());
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

    String getFilePath() {
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

    public void onResult(int i, Intent intent) {
        Uri uri = null;
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
            }
            if (uri == null && ((intent == null || intent.getData() == null) && i == -1)) {
                File file = new File(this.mCameraFilePath);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file.getAbsolutePath());
                        uri = BdSailor.getInstance().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        uri = Uri.fromFile(file);
                    }
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
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResult(Uri uri) {
        if (this.mUploadMessage != null) {
            this.mUploadMessage.onReceiveValue(uri);
        }
        if (this.mUploadMessage1 != null) {
            this.mUploadMessage1.onReceiveValue(new Uri[]{uri});
        }
    }

    public boolean openFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Intent intent;
        this.mUploadMessage1 = valueCallback;
        this.mParams = fileChooserParams;
        String str = "*/*";
        String[] acceptTypes = this.mParams.getAcceptTypes();
        if (acceptTypes != null && acceptTypes.length > 0) {
            str = acceptTypes[0];
        }
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
                intent = new Intent("android.intent.action.CHOOSER");
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
                if (Build.VERSION.SDK_INT >= 21 && fileChooserParams != null) {
                    intent.putExtra("android.intent.extra.INTENT", fileChooserParams.createIntent());
                }
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

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        String str2 = "";
        this.mUploadMessage = valueCallback;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String str3 = split[0];
        for (String str4 : split) {
            String[] split2 = str4.split(ETAG.EQUAL);
            if (split2.length == 2 && MEDIA_SOURCE_KEY.equals(split2[0])) {
                str2 = split2[1];
            }
        }
        return openFileChooser(str2, str3);
    }

    public boolean openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mUploadMessage = valueCallback;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String str3 = split[0];
        String str4 = str2.length() > 0 ? str2 : "";
        if (str2.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
            for (String str5 : split) {
                String[] split2 = str5.split(ETAG.EQUAL);
                if (split2.length == 2 && MEDIA_SOURCE_KEY.equals(split2[0])) {
                    str4 = split2[1];
                }
            }
        }
        return openFileChooser(str4, str3);
    }

    protected boolean openFileChooser(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        this.mCameraFilePath = null;
        if (str2.equals(IMAGE_MIME_TYPE)) {
            if (str.equals("camera")) {
                try {
                    return startActivityForResult(createCameraIntent(), 11);
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
            } else if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                try {
                    return startActivityForResult(createOpenableIntent(IMAGE_MIME_TYPE), 11);
                } catch (Exception e2) {
                    Log.printStackTrace(e2);
                }
            } else {
                try {
                    Intent createChooserIntent = createChooserIntent(createCameraIntent());
                    createChooserIntent.putExtra("android.intent.extra.INTENT", createOpenableIntent(IMAGE_MIME_TYPE));
                    return startActivityForResult(createChooserIntent, 11);
                } catch (Exception e3) {
                    Log.printStackTrace(e3);
                }
            }
        } else if (str2.equals(VIDEO_MIME_TYPE)) {
            if (str.equals(MEDIA_SOURCE_VALUE_CAMCORDER)) {
                try {
                    return startActivityForResult(createCamcorderIntent(), 11);
                } catch (Exception e4) {
                    Log.printStackTrace(e4);
                }
            } else if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                try {
                    return startActivityForResult(createOpenableIntent(VIDEO_MIME_TYPE), 11);
                } catch (Exception e5) {
                    Log.printStackTrace(e5);
                }
            } else {
                try {
                    Intent createChooserIntent2 = createChooserIntent(createCamcorderIntent());
                    createChooserIntent2.putExtra("android.intent.extra.INTENT", createOpenableIntent(VIDEO_MIME_TYPE));
                    return startActivityForResult(createChooserIntent2, 11);
                } catch (Exception e6) {
                    Log.printStackTrace(e6);
                }
            }
        } else if (str2.equals(AUDIO_MIME_TYPE)) {
            if (str.equals(MEDIA_SOURCE_VALUE_MICROPHONE)) {
                try {
                    return startActivityForResult(createSoundRecorderIntent(), 11);
                } catch (Exception e7) {
                    Log.printStackTrace(e7);
                }
            } else if (str.equals(MEDIA_SOURCE_VALUE_FILE_SYSTEM)) {
                try {
                    return startActivityForResult(createOpenableIntent(AUDIO_MIME_TYPE), 11);
                } catch (Exception e8) {
                    Log.printStackTrace(e8);
                }
            } else {
                try {
                    Intent createChooserIntent3 = createChooserIntent(createSoundRecorderIntent());
                    createChooserIntent3.putExtra("android.intent.extra.INTENT", createOpenableIntent(AUDIO_MIME_TYPE));
                    return startActivityForResult(createChooserIntent3, 11);
                } catch (Exception e9) {
                    Log.printStackTrace(e9);
                }
            }
        }
        try {
            return startActivityForResult(createDefaultOpenableIntent(), 11);
        } catch (Exception e10) {
            Log.printStackTrace(e10);
            return false;
        }
    }

    public boolean startActivityForResult(Intent intent, int i) {
        try {
            this.mActivity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            try {
                this.mCaughtActivityNotFoundException = true;
                this.mActivity.startActivityForResult(createDefaultOpenableIntent(), i);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.printStackTrace(e);
                cancelUpload();
                return false;
            }
        }
    }
}
