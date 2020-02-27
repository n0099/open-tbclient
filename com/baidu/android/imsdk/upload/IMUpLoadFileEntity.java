package com.baidu.android.imsdk.upload;

import com.baidu.android.imsdk.utils.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.FileEntity;
/* loaded from: classes3.dex */
public class IMUpLoadFileEntity extends FileEntity {
    IUploadTransferListener mListener;

    public IMUpLoadFileEntity(File file, String str) {
        super(file, str);
    }

    public void setTransferListener(IUploadTransferListener iUploadTransferListener) {
        this.mListener = iUploadTransferListener;
    }

    @Override // org.apache.http.entity.FileEntity, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        long length = this.file.length();
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            int i = -1;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                    j += read;
                    LogUtils.d("UpLoadTask", "write bytes:" + read + "  total:" + j + "  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
                    int i2 = (int) ((100 * j) / length);
                    if (i2 != i) {
                        notifyProgress(i2);
                    } else {
                        i2 = i;
                    }
                    i = i2;
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    private void notifyProgress(int i) {
        this.mListener.onProgress(i);
    }
}
