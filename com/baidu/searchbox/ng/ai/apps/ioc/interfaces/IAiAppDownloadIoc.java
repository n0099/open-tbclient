package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.download.DownloadActionCallback;
/* loaded from: classes2.dex */
public interface IAiAppDownloadIoc {
    boolean downloadApp(Context context, String str, String str2, DownloadActionCallback downloadActionCallback);

    Object registerDownloadTips(Activity activity, boolean z, boolean z2);

    void unRegisterDownloadTips(Object obj);
}
