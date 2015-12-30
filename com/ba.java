package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.imgloader.CompressBitmapTask;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class ba implements CompressBitmapTask.ICompressBitmapListener {
    final /* synthetic */ IBaiduListener edE;
    final /* synthetic */ MultipartRequestParams edH;
    final /* synthetic */ MediaType edI;
    final /* synthetic */ CloudBatchShareHandler edJ;

    public ba(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, MediaType mediaType, IBaiduListener iBaiduListener) {
        this.edJ = cloudBatchShareHandler;
        this.edH = multipartRequestParams;
        this.edI = mediaType;
        this.edE = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.edJ.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.edH.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.edJ.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.edJ.a(shareUrl, this.edI, this.edH, this.edE);
    }
}
