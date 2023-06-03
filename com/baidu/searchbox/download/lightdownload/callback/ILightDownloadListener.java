package com.baidu.searchbox.download.lightdownload.callback;

import com.baidu.searchbox.download.lightdownload.error.LightDownloadError;
/* loaded from: classes3.dex */
public interface ILightDownloadListener {
    void onFail(LightDownloadError lightDownloadError);

    void onSuccess();
}
