package com.baidu.swan.apps.k;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.install.c;
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
public class a {
    private OkHttpClient okHttpClient = new OkHttpClient();

    public void a(c.C0144c c0144c, String str, final c.b bVar) {
        final File file = new File(str);
        this.okHttpClient.newCall(new Request.Builder().url(c0144c.mDownloadUrl).build()).enqueue(new Callback() { // from class: com.baidu.swan.apps.k.a.1
            @Override // okhttp3.Callback
            public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                a.this.a(bVar, 1, 0);
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
                    a.this.a(bVar, 1, 0);
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
                                a.this.a(bVar, 2, contentLength <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) contentLength)) * 100.0f));
                            } catch (Exception e) {
                                inputStream2 = inputStream;
                                try {
                                    a.this.a(bVar, 1, 0);
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
                        a.this.a(bVar, 0, 100);
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
    public void a(final c.b bVar, int i, final int i2) {
        Runnable runnable;
        if (bVar != null) {
            switch (i) {
                case 0:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.k.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onSuccess();
                        }
                    };
                    break;
                case 1:
                default:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.k.a.3
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onFailed();
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.k.a.4
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.cv(i2);
                        }
                    };
                    break;
            }
            aa.runOnUiThread(runnable);
        }
    }
}
