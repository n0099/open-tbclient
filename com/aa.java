package com;

import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.imgloader.CompressBitmapTask;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class aa implements CompressBitmapTask.ICompressBitmapListener {
    final /* synthetic */ MultipartRequestParams a;
    final /* synthetic */ IBaiduListener b;
    final /* synthetic */ CloudBatchShareHandler c;

    public aa(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, IBaiduListener iBaiduListener) {
        this.c = cloudBatchShareHandler;
        this.a = multipartRequestParams;
        this.b = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.c.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.a.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.c.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.c.a(shareUrl, this.a, this.b);
    }
}
