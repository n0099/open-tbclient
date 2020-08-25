package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.vod.model.GenerateMediaIdResponse;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class UploadCacheBean {
    public boolean completeMultipartUpload;
    public boolean completeTranscode;
    public boolean isCompressSucceed;
    public GenerateMediaIdResponse mediaRes;
    public boolean needJumpCompress;
    public ArrayList<PartETag> parts;
    public HttpRequestTokenModule.STSInfo stsInfo;
    public String uploadId;
    public String videoCompressPath;
    public String videoPath;
    public String videoPathMd5;

    public void initBean() {
        this.videoPath = "";
        this.videoPathMd5 = "";
        this.videoCompressPath = "";
        this.isCompressSucceed = false;
        this.needJumpCompress = false;
        if (this.stsInfo == null) {
            this.stsInfo = new HttpRequestTokenModule.STSInfo();
        }
        this.stsInfo.ak = "";
        this.stsInfo.sk = "";
        this.stsInfo.token = "";
        if (this.mediaRes == null) {
            this.mediaRes = new GenerateMediaIdResponse();
        }
        this.mediaRes.setMediaId("");
        this.mediaRes.setSourceBucket("");
        this.mediaRes.setSourceKey("");
        this.uploadId = "";
        if (this.parts == null) {
            this.parts = new ArrayList<>();
        }
        this.parts.clear();
        this.completeMultipartUpload = false;
        this.completeTranscode = false;
    }

    public void updateNewVideo(String str, String str2) {
        initBean();
        this.videoPath = str;
        this.videoPathMd5 = str2;
    }

    public void getUpLoadIdReset() {
        this.parts.clear();
        this.completeMultipartUpload = false;
        this.completeTranscode = false;
    }
}
