package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask;
/* loaded from: classes2.dex */
public interface IAiAppPluginIoc {
    void compressVideo(Context context, Bundle bundle, PickVideoTask.OnCompressResultCallback onCompressResultCallback);

    boolean isReadPluginAvailable(Context context, String str);

    void openDocument(Activity activity, Uri uri, String str);
}
