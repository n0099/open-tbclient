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
    final /* synthetic */ IBaiduListener dxO;
    final /* synthetic */ MultipartRequestParams dxR;
    final /* synthetic */ MediaType dxS;
    final /* synthetic */ CloudBatchShareHandler dxT;

    public ba(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, MediaType mediaType, IBaiduListener iBaiduListener) {
        this.dxT = cloudBatchShareHandler;
        this.dxR = multipartRequestParams;
        this.dxS = mediaType;
        this.dxO = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.dxT.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.dxR.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.dxT.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.dxT.a(shareUrl, this.dxS, this.dxR, this.dxO);
    }
}
