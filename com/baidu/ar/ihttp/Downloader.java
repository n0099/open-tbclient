package com.baidu.ar.ihttp;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.f.g;
import com.baidu.ar.f.i;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes11.dex */
public final class Downloader {
    private String qx;
    private int qy = 0;

    public Downloader(String str) {
        this.qx = str;
    }

    private static void a(InputStream inputStream, String str, int i, IProgressCallback iProgressCallback) {
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream = null;
        int i2 = 0;
        g.c(new File(str));
        byte[] bArr = new byte[8192];
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile.seek(0L);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr, 0, 8192);
                        if (read == -1) {
                            i.closeQuietly(bufferedInputStream2);
                            i.closeQuietly(randomAccessFile);
                            return;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        i2 += read;
                        if (iProgressCallback != null) {
                            iProgressCallback.onProgress(i2, i);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        i.closeQuietly(bufferedInputStream);
                        i.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public static int getNetFileSize(String str) {
        return HttpFactory.newRequest().setUrl(str).setMethod(HttpHead.METHOD_NAME).execute().getContentLength();
    }

    public int download(String str, IProgressCallback iProgressCallback) {
        int fileSize = getFileSize();
        IHttpResponse execute = HttpFactory.newRequest().setUrl(this.qx).setMethod("GET").execute();
        if (execute.isSuccess()) {
            a(execute.getStream(), str, fileSize, iProgressCallback);
            return fileSize;
        }
        throw new HttpException(4, "下载失败");
    }

    public IHttpRequest downloadAsync(final String str, final ICallbackWith<Integer> iCallbackWith, final ICallbackWith<Exception> iCallbackWith2) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        newRequest.setUrl(this.qx).setMethod(HttpHead.METHOD_NAME).enqueue(new a() { // from class: com.baidu.ar.ihttp.Downloader.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                iCallbackWith2.run(httpException);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                Downloader.this.qy = iHttpResponse.getContentLength();
                try {
                    Downloader.this.download(str, null);
                    iCallbackWith.run(Integer.valueOf(Downloader.this.qy));
                } catch (Exception e) {
                    e.printStackTrace();
                    iCallbackWith2.run(e);
                }
            }
        });
        return newRequest;
    }

    public int getFileSize() {
        if (this.qy == 0) {
            this.qy = getNetFileSize(this.qx);
        }
        return this.qy;
    }
}
