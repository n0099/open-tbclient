package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class BdUploadFeature extends com.baidu.browser.sailor.feature.a implements INoProGuard, IUploadFile {
    public static final int FILE_SELECTED = 11;
    protected Map<Activity, BdUploadHandler> mUploadHandlers;

    public BdUploadFeature(Context context) {
        super(context);
        this.mUploadHandlers = new HashMap();
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void cancelUpload(Activity activity) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler != null) {
            uploadHandler.cancelUpload();
            this.mUploadHandlers.remove(activity);
        }
    }

    @Override // com.baidu.browser.sailor.feature.a
    public String getName() {
        return BdSailorConfig.SAILOR_BASE_UPLOAD;
    }

    public BdUploadHandler getUploadHandler(Activity activity) {
        if (this.mUploadHandlers == null || this.mUploadHandlers.size() <= 0) {
            return null;
        }
        return this.mUploadHandlers.get(activity);
    }

    protected BdUploadHandler makeUploadHandler(Activity activity) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler == null) {
            BdUploadHandler bdUploadHandler = new BdUploadHandler(activity);
            this.mUploadHandlers.put(activity, bdUploadHandler);
            return bdUploadHandler;
        }
        return uploadHandler;
    }

    public void onDestroy(Activity activity) {
        BdUploadHandler bdUploadHandler;
        if (activity == null || this.mUploadHandlers == null || this.mUploadHandlers.size() <= 0 || (bdUploadHandler = this.mUploadHandlers.get(activity)) == null) {
            return;
        }
        this.mUploadHandlers.remove(activity);
        if (bdUploadHandler.handled()) {
            return;
        }
        bdUploadHandler.onResult(0, null);
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onOpenFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        if (activity != null) {
            makeUploadHandler(activity).onOpenFileChooser(valueCallback, "");
        }
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onOpenFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (activity != null) {
            BdUploadHandler makeUploadHandler = makeUploadHandler(activity);
            if (fileChooserParams != null) {
                makeUploadHandler.onOpenFileChooser(valueCallback, fileChooserParams);
            }
        }
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onResult(Activity activity, int i, Intent intent) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler == null) {
            Log.d("BdUploadHandler is null.");
            return;
        }
        uploadHandler.onResult(i, intent);
        this.mUploadHandlers.remove(activity);
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public void onResult(Activity activity, Uri uri) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler == null) {
            Log.d("BdUploadHandler is null.");
            return;
        }
        uploadHandler.onResult(uri);
        this.mUploadHandlers.remove(activity);
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, "") : false;
        if (!openFileChooser) {
            valueCallback.onReceiveValue(null);
            if (activity != null && this.mUploadHandlers != null) {
                this.mUploadHandlers.remove(activity);
            }
        }
        return openFileChooser;
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        boolean z = false;
        if (activity != null) {
            BdUploadHandler makeUploadHandler = makeUploadHandler(activity);
            if (fileChooserParams != null) {
                z = makeUploadHandler.openFileChooser(valueCallback, fileChooserParams);
            }
        }
        if (!z) {
            valueCallback.onReceiveValue(null);
            if (activity != null && this.mUploadHandlers != null) {
                this.mUploadHandlers.remove(activity);
            }
        }
        return z;
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, str) : false;
        if (!openFileChooser) {
            valueCallback.onReceiveValue(null);
            if (activity != null && this.mUploadHandlers != null) {
                this.mUploadHandlers.remove(activity);
            }
        }
        return openFileChooser;
    }

    public boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        boolean openFileChooser = activity != null ? makeUploadHandler(activity).openFileChooser(valueCallback, str, str2) : false;
        if (!openFileChooser) {
            valueCallback.onReceiveValue(null);
            if (activity != null && this.mUploadHandlers != null) {
                this.mUploadHandlers.remove(activity);
            }
        }
        return openFileChooser;
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public boolean startCameraActivityForResult(Activity activity) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler != null) {
            return uploadHandler.startActivityForResult(uploadHandler.createCameraIntent(), 11);
        }
        return false;
    }

    @Override // com.baidu.browser.sailor.feature.upload.IUploadFile
    public boolean startImageActivityForResult(Activity activity) {
        BdUploadHandler uploadHandler = getUploadHandler(activity);
        if (uploadHandler != null) {
            return uploadHandler.startActivityForResult(uploadHandler.createOpenableIntent("image/*"), 11);
        }
        return false;
    }
}
