package com.baidu.cyberplayer.sdk.videodownload;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.Keep;
@Keep
/* loaded from: classes3.dex */
public class DuMediaDownloadBean {
    public String createTimestamp;
    public String errorMessage;
    public String extraJsonStr;
    public String httpStatusCode;
    public String md5;
    public String mimeType;
    public String playUrl;
    public int progress;
    public long receivedBytes;
    public int speed;
    public int status;
    public String taskId;
    public long totalBytes;
    public String url;

    public String toString() {
        return "DuMediaDownloadBean{url=" + this.url + StringUtil.ARRAY_ELEMENT_SEPARATOR + "taskId=" + this.taskId + StringUtil.ARRAY_ELEMENT_SEPARATOR + "extraJsonStr=" + this.extraJsonStr + StringUtil.ARRAY_ELEMENT_SEPARATOR + "mimeType=" + this.mimeType + StringUtil.ARRAY_ELEMENT_SEPARATOR + "status=" + this.status + StringUtil.ARRAY_ELEMENT_SEPARATOR + "errorMessage=" + this.errorMessage + StringUtil.ARRAY_ELEMENT_SEPARATOR + "httpStatusCode=" + this.httpStatusCode + StringUtil.ARRAY_ELEMENT_SEPARATOR + "playUrl=" + this.playUrl + StringUtil.ARRAY_ELEMENT_SEPARATOR + "md5=" + this.md5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + "progress=" + this.progress + StringUtil.ARRAY_ELEMENT_SEPARATOR + "totalBytes=" + this.totalBytes + StringUtil.ARRAY_ELEMENT_SEPARATOR + "receivedBytes=" + this.receivedBytes + StringUtil.ARRAY_ELEMENT_SEPARATOR + "speed=" + this.speed + StringUtil.ARRAY_ELEMENT_SEPARATOR + "createTimestamp=" + this.createTimestamp + "}";
    }
}
