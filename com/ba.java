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
    final /* synthetic */ IBaiduListener glQ;
    final /* synthetic */ MultipartRequestParams glT;
    final /* synthetic */ MediaType glU;
    final /* synthetic */ CloudBatchShareHandler glV;

    public ba(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, MediaType mediaType, IBaiduListener iBaiduListener) {
        this.glV = cloudBatchShareHandler;
        this.glT = multipartRequestParams;
        this.glU = mediaType;
        this.glQ = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.glV.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.glT.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.glV.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.glV.a(shareUrl, this.glU, this.glT, this.glQ);
    }
}
