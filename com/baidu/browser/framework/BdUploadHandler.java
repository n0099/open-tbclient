package com.baidu.browser.framework;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import com.baidu.browser.webkit.BdValueCallback;
import java.io.File;
/* loaded from: classes.dex */
public class BdUploadHandler {
    public static final int FILE_SELECTED_1 = 1;
    public static final int FILE_SELECTED_2 = 2;
    private Activity mActivity;
    private String mCameraFilePath;
    private boolean mCaughtActivityNotFoundException;
    private boolean mHandled;
    private BdValueCallback mUploadMessage;

    public BdUploadHandler(Activity activity) {
        this.mActivity = activity;
    }

    String getFilePath() {
        return this.mCameraFilePath;
    }

    public boolean handled() {
        return this.mHandled;
    }

    public void onResult(int i, Intent intent) {
        if (i == 0 && this.mCaughtActivityNotFoundException) {
            this.mCaughtActivityNotFoundException = false;
            return;
        }
        Uri data = (intent == null || i != -1) ? null : intent.getData();
        if (data == null && intent == null && i == -1) {
            File file = new File(this.mCameraFilePath);
            if (file.exists()) {
                data = Uri.fromFile(file);
                this.mActivity.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", data));
            }
        }
        this.mUploadMessage.onReceiveValue(data);
        this.mHandled = true;
        this.mCaughtActivityNotFoundException = false;
    }

    public void openFileChooser(BdValueCallback bdValueCallback, String str) {
        String str2 = "";
        if (this.mUploadMessage == null) {
            this.mUploadMessage = bdValueCallback;
            String[] split = str.split(";");
            String str3 = split[0];
            for (String str4 : split) {
                String[] split2 = str4.split("=");
                if (split2.length == 2 && "capture".equals(split2[0])) {
                    str2 = split2[1];
                }
            }
            this.mCameraFilePath = null;
            if (str3.equals("image/*")) {
                if (str2.equals("camera")) {
                    startActivity(createCameraIntent());
                } else if (str2.equals("filesystem")) {
                    startActivity(createOpenableIntent("image/*"));
                } else {
                    Intent createChooserIntent = createChooserIntent(createCameraIntent());
                    createChooserIntent.putExtra("android.intent.extra.INTENT", createOpenableIntent("image/*"));
                    startActivity(createChooserIntent);
                }
            } else if (str3.equals("video/*")) {
                if (str2.equals("camcorder")) {
                    startActivity(createCamcorderIntent());
                } else if (str2.equals("filesystem")) {
                    startActivity(createOpenableIntent("video/*"));
                } else {
                    Intent createChooserIntent2 = createChooserIntent(createCamcorderIntent());
                    createChooserIntent2.putExtra("android.intent.extra.INTENT", createOpenableIntent("video/*"));
                    startActivity(createChooserIntent2);
                }
            } else if (str3.equals("audio/*")) {
                if (str2.equals("microphone")) {
                    startActivity(createSoundRecorderIntent());
                } else if (str2.equals("filesystem")) {
                    startActivity(createOpenableIntent("audio/*"));
                } else {
                    Intent createChooserIntent3 = createChooserIntent(createSoundRecorderIntent());
                    createChooserIntent3.putExtra("android.intent.extra.INTENT", createOpenableIntent("audio/*"));
                    startActivity(createChooserIntent3);
                }
            } else {
                startActivity(createDefaultOpenableIntent());
            }
        }
    }

    private void startActivity(Intent intent) {
        try {
            this.mActivity.startActivityForResult(intent, 2);
        } catch (ActivityNotFoundException e) {
            try {
                this.mCaughtActivityNotFoundException = true;
                this.mActivity.startActivityForResult(createDefaultOpenableIntent(), 2);
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(this.mActivity, this.mActivity.getResources().getIdentifier("browser_uploads_disabled", "string", this.mActivity.getPackageName()), 1).show();
            }
        }
    }

    private Intent createDefaultOpenableIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent createChooserIntent = createChooserIntent(createCameraIntent(), createCamcorderIntent(), createSoundRecorderIntent());
        createChooserIntent.putExtra("android.intent.extra.INTENT", intent);
        return createChooserIntent;
    }

    private Intent createChooserIntent(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", this.mActivity.getResources().getString(this.mActivity.getResources().getIdentifier("browser_choose_upload", "string", this.mActivity.getPackageName())));
        return intent;
    }

    private Intent createOpenableIntent(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        return intent;
    }

    private Intent createCameraIntent() {
        File externalStorageDirectory;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT > 7) {
            externalStorageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        } else {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        }
        File file = new File(String.valueOf(externalStorageDirectory.getAbsolutePath()) + File.separator + "browser-photos");
        file.mkdirs();
        this.mCameraFilePath = String.valueOf(file.getAbsolutePath()) + File.separator + System.currentTimeMillis() + ".jpg";
        intent.putExtra("output", Uri.fromFile(new File(this.mCameraFilePath)));
        return intent;
    }

    private Intent createCamcorderIntent() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    private Intent createSoundRecorderIntent() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }
}
