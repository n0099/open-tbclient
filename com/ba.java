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
    final /* synthetic */ IBaiduListener gdF;
    final /* synthetic */ MultipartRequestParams gnt;
    final /* synthetic */ MediaType gnu;
    final /* synthetic */ CloudBatchShareHandler gnv;

    public ba(CloudBatchShareHandler cloudBatchShareHandler, MultipartRequestParams multipartRequestParams, MediaType mediaType, IBaiduListener iBaiduListener) {
        this.gnv = cloudBatchShareHandler;
        this.gnt = multipartRequestParams;
        this.gnu = mediaType;
        this.gdF = iBaiduListener;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.CompressBitmapTask.ICompressBitmapListener
    public void onComplete(ByteArrayOutputStream byteArrayOutputStream) {
        String shareUrl = this.gnv.getShareUrl();
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() != 0) {
            this.gnt.put("pic", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            shareUrl = this.gnv.getShareUploadUrl();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        this.gnv.a(shareUrl, this.gnu, this.gnt, this.gdF);
    }
}
