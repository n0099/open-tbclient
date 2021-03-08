package com.baidu.swan.games.audio.a;

import android.util.Log;
import com.baidu.swan.c.d;
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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String eek;
    private com.baidu.swan.games.network.b eel;
    private a eem;
    private String mSrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.baidu.swan.games.network.b bVar, String str, String str2, a aVar) {
        this.mSrc = "";
        this.eek = "";
        this.eel = bVar;
        this.eek = str;
        this.mSrc = str2;
        this.eem = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load() {
        this.eel.a(new Request.Builder().url(this.mSrc).build(), new Callback() { // from class: com.baidu.swan.games.audio.a.c.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (c.DEBUG) {
                    Log.e("AudioDownloader", c.this.mSrc + " load failed");
                    iOException.printStackTrace();
                }
                if (c.this.eem != null) {
                    c.this.eem.aB(-1, c.this.mSrc);
                }
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [142=4] */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                FileOutputStream fileOutputStream;
                InputStream inputStream;
                File file;
                byte[] bArr = new byte[2048];
                try {
                    inputStream = response.body().byteStream();
                    try {
                        try {
                            String wa = f.wa(c.this.mSrc);
                            String str = c.this.eek + wa.substring(0, wa.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = wa.substring(wa.lastIndexOf("/") + 1);
                            file = new File(str, substring + ".bddownload");
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        try {
                                            int read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Exception e) {
                                            e = e;
                                            if (c.DEBUG) {
                                                Log.e("AudioDownloader", c.this.mSrc + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (c.this.eem != null) {
                                                c.this.eem.aB(-1, c.this.mSrc);
                                            }
                                            d.closeSafely(inputStream);
                                            d.closeSafely(fileOutputStream);
                                            d.closeSafely(response);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        d.closeSafely(inputStream);
                                        d.closeSafely(fileOutputStream);
                                        d.closeSafely(response);
                                        throw th;
                                    }
                                }
                                fileOutputStream.flush();
                                File file3 = new File(str, substring);
                                if (file3.exists() && !file3.isDirectory()) {
                                    file3.delete();
                                }
                                String absolutePath = file3.getAbsolutePath();
                                if (file.renameTo(file3)) {
                                    if (c.DEBUG) {
                                        Log.e("AudioDownloader", c.this.mSrc + " load rename success path = " + absolutePath);
                                    }
                                    if (c.this.eem != null) {
                                        c.this.eem.cK(c.this.mSrc, absolutePath);
                                    }
                                } else {
                                    if (c.DEBUG) {
                                        Log.e("AudioDownloader", c.this.mSrc + " load rename error path = " + absolutePath);
                                    }
                                    file.delete();
                                    if (c.this.eem != null) {
                                        c.this.eem.aB(-1, absolutePath);
                                    }
                                }
                                d.closeSafely(inputStream);
                                d.closeSafely(fileOutputStream);
                                d.closeSafely(response);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            file = null;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    file = null;
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    inputStream = null;
                }
            }
        });
    }
}
