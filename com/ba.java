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
    final /* synthetic */ IBaiduListener dvV;
    final /* synthetic */ MultipartRequestParams dvY;
    final /* synthetic */ MediaType dvZ;
    final /* synthetic */ CloudBatchShareHandler dwa;

    public ba(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, MediaType mediaType, IBaiduListener iBaiduListener) {
        this.dwa = cloudBatchShareHandler;
        this.dvY = multipartRequestParams;
        this.dvZ = mediaType;
        this.dvV = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.dwa.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.dvY.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.dwa.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.dwa.a(shareUrl, this.dvZ, this.dvY, this.dvV);
    }
}
