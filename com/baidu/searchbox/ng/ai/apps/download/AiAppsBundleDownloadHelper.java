package com.baidu.searchbox.ng.ai.apps.download;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public class AiAppsBundleDownloadHelper {
    private static final int MODE_FAILED = 1;
    private static final int MODE_PROGRESS = 2;
    private static final int MODE_SUCCESS = 0;
    private OkHttpClient okHttpClient = new OkHttpClient();

    public void startDownload(AiAppsBundleHelper.InternalUseDownloadInfo internalUseDownloadInfo, String str, final AiAppsBundleHelper.InternalUseDownloadCb internalUseDownloadCb) {
        final File file = new File(str);
        this.okHttpClient.newCall(new Request.Builder().url(internalUseDownloadInfo.mDownloadUrl).build()).enqueue(new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.download.AiAppsBundleDownloadHelper.1
            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                AiAppsBundleDownloadHelper.this.notifyResult(internalUseDownloadCb, 1, 0);
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
            @Override // okhttp3.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                InputStream inputStream;
                Throwable th;
                InputStream inputStream2;
                FileOutputStream fileOutputStream;
                ResponseBody body = response.body();
                if (body == null) {
                    AiAppsBundleDownloadHelper.this.notifyResult(internalUseDownloadCb, 1, 0);
                    return;
                }
                byte[] bArr = new byte[2048];
                FileOutputStream fileOutputStream2 = null;
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                    file.createNewFile();
                }
                try {
                    inputStream = body.byteStream();
                    try {
                        long contentLength = body.contentLength();
                        fileOutputStream = new FileOutputStream(file);
                        long j = 0;
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j += read;
                                AiAppsBundleDownloadHelper.this.notifyResult(internalUseDownloadCb, 2, contentLength <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) contentLength)) * 100.0f));
                            } catch (Exception e) {
                                inputStream2 = inputStream;
                                try {
                                    AiAppsBundleDownloadHelper.this.notifyResult(internalUseDownloadCb, 1, 0);
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    inputStream = inputStream2;
                                    fileOutputStream2 = fileOutputStream;
                                    th = th2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                fileOutputStream2 = fileOutputStream;
                                th = th3;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream2 != null) {
                                }
                                throw th;
                            }
                        }
                        fileOutputStream.flush();
                        AiAppsBundleDownloadHelper.this.notifyResult(internalUseDownloadCb, 0, 100);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e2) {
                        fileOutputStream = null;
                        inputStream2 = inputStream;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e3) {
                    inputStream2 = null;
                    fileOutputStream = null;
                } catch (Throwable th5) {
                    inputStream = null;
                    th = th5;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResult(final AiAppsBundleHelper.InternalUseDownloadCb internalUseDownloadCb, int i, final int i2) {
        Runnable runnable;
        if (internalUseDownloadCb != null) {
            switch (i) {
                case 0:
                    runnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.download.AiAppsBundleDownloadHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            internalUseDownloadCb.onSuccess();
                        }
                    };
                    break;
                case 1:
                default:
                    runnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.download.AiAppsBundleDownloadHelper.3
                        @Override // java.lang.Runnable
                        public void run() {
                            internalUseDownloadCb.onFailed();
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.download.AiAppsBundleDownloadHelper.4
                        @Override // java.lang.Runnable
                        public void run() {
                            internalUseDownloadCb.onProgressChanged(i2);
                        }
                    };
                    break;
            }
            AiAppsUtils.runOnUiThread(runnable);
        }
    }
}
