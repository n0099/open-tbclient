package com.baidu.livesdk.sdk.http.download;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.api.http.ResponseCallback;
import com.baidu.livesdk.api.http.download.DownloadCallback;
import com.baidu.livesdk.api.http.download.DownloadEntity;
import com.baidu.livesdk.api.http.download.Downloader;
import com.baidu.livesdk.sdk.http.OkHttpRequest;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Response;
/* loaded from: classes8.dex */
public class OkHttpDownloader extends OkHttpRequest implements Downloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OkHttpDownloader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.livesdk.api.http.download.Downloader
    public void download(DownloadCallback downloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadCallback) == null) {
            super.request(downloadCallback);
        }
    }

    @Override // com.baidu.livesdk.sdk.http.OkHttpRequest
    public void onFailureCallback(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, iOException) == null) {
            super.onFailureCallback(call, iOException);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.livesdk.sdk.http.OkHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponseCallback(Call call, Response response) {
        Exception exc;
        FileOutputStream fileOutputStream;
        IOException e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, call, response) != null) {
            return;
        }
        if (response == null || response.body() == null) {
            if (response != null) {
                ResponseCallback responseCallback = this.mCallback;
                int i2 = response.isSuccessful() ? -1 : 4;
                if (response.isSuccessful()) {
                    exc = new Exception("http error code=" + response.code());
                } else {
                    exc = new Exception("response body is null");
                }
                responseCallback.onFail(i2, exc);
                return;
            }
            this.mCallback.onFail(-1, new Exception(ADConfigError.REASON_NULL_RESPONSE));
        } else if (!response.isSuccessful()) {
            this.mCallback.onFail(4, new Exception("http error code=" + response.code()));
        } else {
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
                            int i3 = 0;
                            while (true) {
                                int read = byteStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                i3 += read;
                                if (downloadCallback != null) {
                                    downloadCallback.onFileUpdateProgress(i3, contentLength);
                                }
                            }
                            fileOutputStream.flush();
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = byteStream;
                            if (downloadCallback != null) {
                                try {
                                    downloadCallback.onFail(-1, e);
                                } catch (Throwable th) {
                                    th = th;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            if (downloadCallback != null) {
                                                downloadCallback.onFail(3, e4);
                                            }
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            if (downloadCallback != null) {
                                                downloadCallback.onFail(3, e5);
                                            }
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e6) {
                                    if (downloadCallback != null) {
                                        downloadCallback.onFail(3, e6);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e7) {
                                    e2 = e7;
                                    if (downloadCallback == null) {
                                        return;
                                    }
                                    downloadCallback.onFail(3, e2);
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
                        } catch (IOException e8) {
                            if (downloadCallback != null) {
                                downloadCallback.onFail(3, e8);
                            }
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e9) {
                            e2 = e9;
                            if (downloadCallback == null) {
                                return;
                            }
                            downloadCallback.onFail(3, e2);
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }
    }
}
