package com.baidu.livesdk.api.http.download;

import com.baidu.livesdk.api.http.HttpRequestEntity;
/* loaded from: classes2.dex */
public class DownloadEntity extends HttpRequestEntity {
    public String localPath;

    public String getLocalPath() {
        return this.localPath;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }
}
