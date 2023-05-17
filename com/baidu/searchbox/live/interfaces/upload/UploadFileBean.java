package com.baidu.searchbox.live.interfaces.upload;
/* loaded from: classes3.dex */
public class UploadFileBean {
    public String ak = "";
    public String sk = "";
    public String token = "";
    public String endpoint = "";
    public String bucketName = "";
    public String objectName = "";
    public String filePath = "";

    public String toString() {
        return "UploadFileBean{ak='" + this.ak + "', sk='" + this.sk + "', token='" + this.token + "', endpoint='" + this.endpoint + "', bucketName='" + this.bucketName + "', objectName='" + this.objectName + "', filePath='" + this.filePath + "'}";
    }
}
