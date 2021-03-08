package com.baidu.ar.ihttp;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.h.i;
import com.baidu.ar.h.k;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import org.apache.http.client.methods.HttpHead;
/* loaded from: classes3.dex */
public final class Downloader {
    private String rs;
    private int rt = 0;

    public Downloader(String str) {
        this.rs = str;
    }

    private static void a(InputStream inputStream, String str, int i, IProgressCallback iProgressCallback) {
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream;
        int i2 = 0;
        i.c(new File(str));
        byte[] bArr = new byte[8192];
        try {
            randomAccessFile = new RandomAccessFile(str, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            try {
                randomAccessFile.seek(0L);
                bufferedInputStream = new BufferedInputStream(inputStream, 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 8192);
                        if (read == -1) {
                            k.closeQuietly(bufferedInputStream);
                            k.closeQuietly(randomAccessFile);
                            return;
                        }
                        randomAccessFile.write(bArr, 0, read);
                        i2 += read;
                        if (iProgressCallback != null) {
                            iProgressCallback.onProgress(i2, i);
                        }
                    } catch (Throwable th) {
                        th = th;
                        k.closeQuietly(bufferedInputStream);
                        k.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            bufferedInputStream = null;
        }
    }

    public static int getNetFileSize(String str) {
        return HttpFactory.newRequest().setUrl(str).setMethod(HttpHead.METHOD_NAME).execute().getContentLength();
    }

    public int download(String str, IProgressCallback iProgressCallback) {
        int fileSize = getFileSize();
        IHttpResponse execute = HttpFactory.newRequest().setUrl(this.rs).setMethod("GET").execute();
        if (execute.isSuccess()) {
            a(execute.getStream(), str, fileSize, iProgressCallback);
            return fileSize;
        }
        throw new HttpException(4, "下载失败");
    }

    public IHttpRequest downloadAsync(String str, ICallbackWith<Integer> iCallbackWith, ICallbackWith<Exception> iCallbackWith2) {
        return downloadAsync(str, iCallbackWith, iCallbackWith2, null);
    }

    public IHttpRequest downloadAsync(final String str, final ICallbackWith<Integer> iCallbackWith, final ICallbackWith<Exception> iCallbackWith2, final IProgressCallback iProgressCallback) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        newRequest.setUrl(this.rs).setMethod(HttpHead.METHOD_NAME).enqueue(new a() { // from class: com.baidu.ar.ihttp.Downloader.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                iCallbackWith2.run(httpException);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                Downloader.this.rt = iHttpResponse.getContentLength();
                try {
                    Downloader.this.download(str, iProgressCallback);
                    iCallbackWith.run(Integer.valueOf(Downloader.this.rt));
                } catch (Exception e) {
                    e.printStackTrace();
                    iCallbackWith2.run(e);
                }
            }
        });
        return newRequest;
    }

    public int getFileSize() {
        if (this.rt == 0) {
            this.rt = getNetFileSize(this.rs);
        }
        return this.rt;
    }
}
