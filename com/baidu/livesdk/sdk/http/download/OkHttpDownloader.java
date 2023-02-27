package com.baidu.livesdk.sdk.http.download;

import com.baidu.livesdk.api.http.ResponseCallback;
import com.baidu.livesdk.api.http.download.DownloadCallback;
import com.baidu.livesdk.api.http.download.DownloadEntity;
import com.baidu.livesdk.api.http.download.Downloader;
import com.baidu.livesdk.sdk.http.OkHttpRequest;
import com.baidu.nadcore.exp.ADConfigError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class OkHttpDownloader extends OkHttpRequest implements Downloader {
    @Override // com.baidu.livesdk.api.http.download.Downloader
    public void download(DownloadCallback downloadCallback) {
        super.request(downloadCallback);
    }

    @Override // com.baidu.livesdk.sdk.http.OkHttpRequest
    public void onFailureCallback(Call call, IOException iOException) {
        super.onFailureCallback(call, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponseCallback(Call call, Response response) {
        Exception exc;
        FileOutputStream fileOutputStream;
        IOException e;
        int i = 4;
        if (response != null && response.body() != null) {
            if (!response.isSuccessful()) {
                this.mCallback.onFail(4, new Exception("http error code=" + response.code()));
                return;
            }
            DownloadCallback downloadCallback = (DownloadCallback) this.mCallback;
            InputStream inputStream = null;
            r0 = null;
            r0 = null;
            FileOutputStream fileOutputStream2 = null;
            inputStream = null;
            try {
                InputStream byteStream = response.body().byteStream();
                try {
                    long contentLength = response.body().contentLength();
                    if (byteStream != null) {
                        fileOutputStream = new FileOutputStream(new File(((DownloadEntity) getHttpRequestEntity()).getLocalPath()));
                        try {
                            byte[] bArr = new byte[1024];
                            int i2 = 0;
                            while (true) {
                                int read = byteStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                i2 += read;
                                if (downloadCallback != null) {
                                    downloadCallback.onFileUpdateProgress(i2, contentLength);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = byteStream;
                            if (downloadCallback != null) {
                                try {
                                    downloadCallback.onFail(-1, e);
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e3) {
                                            if (downloadCallback != null) {
                                                downloadCallback.onFail(3, e3);
                                            }
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            if (downloadCallback != null) {
                                                downloadCallback.onFail(3, e4);
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e5) {
                                    if (downloadCallback != null) {
                                        downloadCallback.onFail(3, e5);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e6) {
                                    e = e6;
                                    if (downloadCallback == null) {
                                        return;
                                    }
                                    downloadCallback.onFail(3, e);
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = byteStream;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (downloadCallback != null) {
                        downloadCallback.onSuccess(getHttpResponse(response));
                    }
                    if (byteStream != null) {
                        try {
                            byteStream.close();
                        } catch (IOException e7) {
                            if (downloadCallback != null) {
                                downloadCallback.onFail(3, e7);
                            }
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e8) {
                            e = e8;
                            if (downloadCallback == null) {
                                return;
                            }
                            downloadCallback.onFail(3, e);
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } else if (response != null) {
            ResponseCallback responseCallback = this.mCallback;
            if (response.isSuccessful()) {
                i = -1;
            }
            if (response.isSuccessful()) {
                exc = new Exception("http error code=" + response.code());
            } else {
                exc = new Exception("response body is null");
            }
            responseCallback.onFail(i, exc);
        } else {
            this.mCallback.onFail(-1, new Exception(ADConfigError.REASON_NULL_RESPONSE));
        }
    }
}
