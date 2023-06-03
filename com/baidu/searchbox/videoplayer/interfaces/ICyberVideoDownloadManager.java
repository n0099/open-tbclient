package com.baidu.searchbox.videoplayer.interfaces;

import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface ICyberVideoDownloadManager {
    public static final String NAME = "download";
    public static final String NAME_SPACE = "cyber_download";
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference(NAME_SPACE, "download");

    void cancelDownload(String str);

    void deleteDownload(String str);

    void pauseDownload(String str);

    void setOption(String str, String str2);

    String startDownload(String str, VideoSourceInfo videoSourceInfo);
}
