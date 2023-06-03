package com.baidu.searchbox.downloadcenter.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public interface IDownloadCenterFun {
    public static final String NAME = "downloadcenter";
    public static final String NAME_SPACE = "baidudownload";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(NAME_SPACE, "downloadcenter");

    /* loaded from: classes3.dex */
    public interface LoginCallback {
        void onLogin();
    }

    Intent buildDownloadActivityIntent(Context context);

    void findDataAndPreview(Activity activity, Uri uri, PreviewResultCallback previewResultCallback);

    void openLogin(Context context, String str, LoginCallback loginCallback);

    Object registerDownloadProcessReceiver(Context context);

    Object registerDownloadProcessReceiver(Context context, DownloadProcessData downloadProcessData);

    void startDownloadCenterActivity(Context context, String str);

    boolean startDownloadCenterActivity(Context context, String str, boolean z, String str2, String str3, String str4, String str5);

    boolean startDownloadCenterActivity(Context context, boolean z, String str);

    void unregisterDownloadProcessReceiver(Object obj);

    void uploadToPan(Activity activity, ArrayList<Uri> arrayList);
}
