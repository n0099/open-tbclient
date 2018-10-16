package com.baidu.browser.sailor.feature.b;

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
import com.baidu.browser.core.permission.BdPermissionActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    private String VR;
    private ValueCallback<Uri[]> VS;
    private WebChromeClient.FileChooserParams VT;
    private boolean VU;
    private boolean VV = false;
    private Activity mActivity;
    private ValueCallback<Uri> mUploadMessage;

    public b(Activity activity) {
        this.mActivity = activity;
    }

    private Intent a(Intent... intentArr) {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        intent.putExtra("android.intent.extra.TITLE", this.mActivity.getResources().getString(com.baidu.browser.core.b.R("string", "sailor_choose_upload")));
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public Intent qF() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + File.separator + "browser-photos");
        file.mkdirs();
        this.VR = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
        if (Build.VERSION.SDK_INT >= 24) {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_data", this.VR);
            intent.putExtra("output", com.baidu.browser.sailor.a.qq().getAppContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
        } else {
            intent.putExtra("output", Uri.fromFile(new File(this.VR)));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            intent.setFlags(3);
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent qH() {
        if (com.baidu.browser.core.permission.b.aX(this.mActivity)) {
            return new Intent("android.media.action.VIDEO_CAPTURE");
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra(IntentConfig.REQUEST_CODE, 4099);
        intent.putExtra("permissions", new String[]{"android.permission.CAMERA"});
        com.baidu.browser.core.permission.a.qo().a(4099, new d(this));
        return intent;
    }

    private Intent qI() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    protected boolean U(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        this.VR = null;
        if (str2.equals("image/*")) {
            if (str.equals("camera")) {
                try {
                    return a(qG(), 11);
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
            } else if (str.equals("filesystem")) {
                try {
                    return a(cw("image/*"), 11);
                } catch (Exception e2) {
                    Log.printStackTrace(e2);
                }
            } else {
                try {
                    Intent a = a(qG());
                    a.putExtra("android.intent.extra.INTENT", cw("image/*"));
                    return a(a, 11);
                } catch (Exception e3) {
                    Log.printStackTrace(e3);
                }
            }
        } else if (str2.equals("video/*")) {
            if (str.equals("camcorder")) {
                try {
                    return a(qH(), 11);
                } catch (Exception e4) {
                    Log.printStackTrace(e4);
                }
            } else if (str.equals("filesystem")) {
                try {
                    return a(cw("video/*"), 11);
                } catch (Exception e5) {
                    Log.printStackTrace(e5);
                }
            } else {
                try {
                    Intent a2 = a(qH());
                    a2.putExtra("android.intent.extra.INTENT", cw("video/*"));
                    return a(a2, 11);
                } catch (Exception e6) {
                    Log.printStackTrace(e6);
                }
            }
        } else if (str2.equals("audio/*")) {
            if (str.equals("microphone")) {
                try {
                    return a(qI(), 11);
                } catch (Exception e7) {
                    Log.printStackTrace(e7);
                }
            } else if (str.equals("filesystem")) {
                try {
                    return a(cw("audio/*"), 11);
                } catch (Exception e8) {
                    Log.printStackTrace(e8);
                }
            } else {
                try {
                    Intent a3 = a(qI());
                    a3.putExtra("android.intent.extra.INTENT", cw("audio/*"));
                    return a(a3, 11);
                } catch (Exception e9) {
                    Log.printStackTrace(e9);
                }
            }
        }
        try {
            return a(qE(), 11);
        } catch (Exception e10) {
            Log.printStackTrace(e10);
            return false;
        }
    }

    public boolean a(Intent intent, int i) {
        try {
            this.mActivity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException e) {
            try {
                this.VU = true;
                this.mActivity.startActivityForResult(qE(), i);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.printStackTrace(e);
                qJ();
                return false;
            }
        }
    }

    public boolean a(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        Intent intent;
        this.VS = valueCallback;
        this.VT = fileChooserParams;
        String str = "*/*";
        String[] acceptTypes = this.VT.getAcceptTypes();
        if (acceptTypes != null && acceptTypes.length > 0) {
            str = acceptTypes[0];
        }
        Intent[] intentArr = null;
        if (str.equals("image/*")) {
            intentArr = new Intent[]{qG()};
        } else if (str.equals("video/*")) {
            intentArr = new Intent[]{qH()};
        } else if (str.equals("audio/*")) {
            intentArr = new Intent[]{qI()};
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
                    return a(intent, 11);
                } catch (Exception e) {
                    Log.printStackTrace(e);
                }
            }
        }
        try {
            return a(qE(), 11);
        } catch (Exception e2) {
            Log.printStackTrace(e2);
            return false;
        }
    }

    public boolean a(ValueCallback<Uri> valueCallback, String str) {
        String str2 = "";
        this.mUploadMessage = valueCallback;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String str3 = split[0];
        for (String str4 : split) {
            String[] split2 = str4.split(ETAG.EQUAL);
            if (split2.length == 2 && "capture".equals(split2[0])) {
                str2 = split2[1];
            }
        }
        return U(str2, str3);
    }

    public boolean a(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mUploadMessage = valueCallback;
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String str3 = split[0];
        String str4 = str2.length() > 0 ? str2 : "";
        if (str2.equals("filesystem")) {
            for (String str5 : split) {
                String[] split2 = str5.split(ETAG.EQUAL);
                if (split2.length == 2 && "capture".equals(split2[0])) {
                    str4 = split2[1];
                }
            }
        }
        return U(str4, str3);
    }

    public Intent cw(String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        return intent;
    }

    @SuppressLint({"NewApi"})
    public Intent qE() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Intent a = a(qG(), qH(), qI());
        a.putExtra("android.intent.extra.INTENT", intent);
        if (Build.VERSION.SDK_INT >= 21 && this.VT != null) {
            a.putExtra("android.intent.extra.INTENT", this.VT.createIntent());
        }
        return a;
    }

    public Intent qG() {
        if (com.baidu.browser.core.permission.b.aX(this.mActivity)) {
            return qF();
        }
        Intent intent = new Intent(this.mActivity.getApplicationContext(), BdPermissionActivity.class);
        intent.putExtra(IntentConfig.REQUEST_CODE, 4099);
        intent.putExtra("permissions", new String[]{"android.permission.CAMERA"});
        com.baidu.browser.core.permission.a.qo().a(4099, new c(this));
        return intent;
    }

    public void qJ() {
        if (this.mUploadMessage != null) {
            this.mUploadMessage.onReceiveValue(null);
        }
        if (this.VS != null) {
            this.VS.onReceiveValue(null);
        }
    }
}
