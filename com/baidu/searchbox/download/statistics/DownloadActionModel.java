package com.baidu.searchbox.download.statistics;

import com.baidu.searchbox.NoProGuard;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class DownloadActionModel implements NoProGuard {
    public long downloadId;
    public String extraInfo;
    public String fileName;
    public String mRedirectUris;
    public String mimeType;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadActionModel=(downloadId: " + this.downloadId);
        sb.append(", fileName: " + this.fileName);
        sb.append(", mimeType: " + this.mimeType);
        sb.append(", extraInfo" + this.extraInfo);
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }
}
