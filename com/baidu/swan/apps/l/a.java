package com.baidu.swan.apps.l;

import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.r.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes8.dex */
public class a {
    public void a(d.c cVar, String str, final d.b bVar) {
        final File file = new File(str);
        com.baidu.swan.a.b.a aVar = new com.baidu.swan.a.b.a(cVar.mDownloadUrl, new ResponseCallback() { // from class: com.baidu.swan.apps.l.a.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public Object parseResponse(Response response, int i) throws Exception {
                a.this.a(response, bVar, file);
                return response;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(Object obj, int i) {
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.this.a(bVar, 1, 0);
            }
        });
        aVar.dES = false;
        aVar.dET = false;
        aVar.dEU = false;
        com.baidu.swan.a.c.a.aSW().a(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [117=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response, d.b bVar, File file) throws IOException {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        ResponseBody body = response.body();
        if (body == null) {
            a(bVar, 1, 0);
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
                            fileOutputStream.flush();
                            a(bVar, 0, 100);
                            com.baidu.swan.c.d.closeSafely(inputStream);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        j += read;
                        a(bVar, 2, contentLength <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) contentLength)) * 100.0f));
                    } catch (Exception e) {
                        inputStream2 = inputStream;
                        try {
                            a(bVar, 1, 0);
                            com.baidu.swan.c.d.closeSafely(inputStream2);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return;
                        } catch (Throwable th2) {
                            inputStream = inputStream2;
                            fileOutputStream2 = fileOutputStream;
                            th = th2;
                            com.baidu.swan.c.d.closeSafely(inputStream);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        com.baidu.swan.c.d.closeSafely(inputStream);
                        com.baidu.swan.c.d.closeSafely(fileOutputStream2);
                        throw th;
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d.b bVar, int i, final int i2) {
        Runnable runnable;
        if (bVar != null) {
            switch (i) {
                case 0:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.l.a.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onSuccess();
                        }
                    };
                    break;
                case 1:
                default:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.l.a.3
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.onFailed();
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.swan.apps.l.a.4
                        @Override // java.lang.Runnable
                        public void run() {
                            bVar.fy(i2);
                        }
                    };
                    break;
            }
            ak.runOnUiThread(runnable);
        }
    }
}
