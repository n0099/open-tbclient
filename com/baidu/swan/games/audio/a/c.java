package com.baidu.swan.games.audio.a;

import android.util.Log;
import com.baidu.swan.e.d;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cUa;
    private com.baidu.swan.games.network.b cUb;
    private a cUc;
    private String mSrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.baidu.swan.games.network.b bVar, String str, String str2, a aVar) {
        this.mSrc = "";
        this.cUa = "";
        this.cUb = bVar;
        this.cUa = str;
        this.mSrc = str2;
        this.cUc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load() {
        this.cUb.a(new Request.Builder().url(this.mSrc).build(), new Callback() { // from class: com.baidu.swan.games.audio.a.c.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (c.DEBUG) {
                    Log.e("AudioDownloader", c.this.mSrc + " load failed");
                    iOException.printStackTrace();
                }
                if (c.this.cUc != null) {
                    c.this.cUc.ab(-1, c.this.mSrc);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [142=4] */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                FileOutputStream fileOutputStream;
                InputStream inputStream;
                FileOutputStream fileOutputStream2;
                InputStream inputStream2;
                File file = null;
                byte[] bArr = new byte[2048];
                try {
                    inputStream = response.body().byteStream();
                    try {
                        try {
                            String qZ = f.qZ(c.this.mSrc);
                            String str = c.this.cUa + qZ.substring(0, qZ.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = qZ.substring(qZ.lastIndexOf("/") + 1);
                            File file3 = new File(str, substring + ".bddownload");
                            try {
                                fileOutputStream = new FileOutputStream(file3);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    } catch (Exception e) {
                                        e = e;
                                        file = file3;
                                        fileOutputStream2 = fileOutputStream;
                                        inputStream2 = inputStream;
                                        try {
                                            if (c.DEBUG) {
                                                Log.e("AudioDownloader", c.this.mSrc + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (c.this.cUc != null) {
                                                c.this.cUc.ab(-1, c.this.mSrc);
                                            }
                                            d.closeSafely(inputStream2);
                                            d.closeSafely(fileOutputStream2);
                                            d.closeSafely(response);
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = inputStream2;
                                            fileOutputStream = fileOutputStream2;
                                            d.closeSafely(inputStream);
                                            d.closeSafely(fileOutputStream);
                                            d.closeSafely(response);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        d.closeSafely(inputStream);
                                        d.closeSafely(fileOutputStream);
                                        d.closeSafely(response);
                                        throw th;
                                    }
                                }
                                fileOutputStream.flush();
                                File file4 = new File(str, substring);
                                if (file4.exists() && !file4.isDirectory()) {
                                    file4.delete();
                                }
                                String absolutePath = file4.getAbsolutePath();
                                if (file3.renameTo(file4)) {
                                    if (c.DEBUG) {
                                        Log.e("AudioDownloader", c.this.mSrc + " load rename success path = " + absolutePath);
                                    }
                                    if (c.this.cUc != null) {
                                        c.this.cUc.ce(c.this.mSrc, absolutePath);
                                    }
                                } else {
                                    if (c.DEBUG) {
                                        Log.e("AudioDownloader", c.this.mSrc + " load rename error path = " + absolutePath);
                                    }
                                    file3.delete();
                                    if (c.this.cUc != null) {
                                        c.this.cUc.ab(-1, absolutePath);
                                    }
                                }
                                d.closeSafely(inputStream);
                                d.closeSafely(fileOutputStream);
                                d.closeSafely(response);
                            } catch (Exception e2) {
                                e = e2;
                                inputStream2 = inputStream;
                                file = file3;
                                fileOutputStream2 = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream2 = null;
                        inputStream2 = inputStream;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream2 = null;
                    inputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    inputStream = null;
                }
            }
        });
    }
}
