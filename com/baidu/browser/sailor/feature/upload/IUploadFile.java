package com.baidu.browser.sailor.feature.upload;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.baidu.browser.core.INoProGuard;
import com.baidu.webkit.sdk.WebChromeClient;
/* loaded from: classes4.dex */
public interface IUploadFile extends INoProGuard {
    void cancelUpload(Activity activity);

    void onOpenFileChooser(Activity activity, ValueCallback<Uri> valueCallback);

    void onOpenFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

    void onResult(Activity activity, int i2, Intent intent);

    void onResult(Activity activity, Uri uri);

    boolean startCameraActivityForResult(Activity activity);

    boolean startImageActivityForResult(Activity activity);
}
