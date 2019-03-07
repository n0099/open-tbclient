package com.baidu.swan.games.e.c;

import android.util.Log;
import com.baidu.swan.games.audio.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
class c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private String bac;
    private com.baidu.swan.games.network.b bad;
    private a bbI;
    private String mSrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.baidu.swan.games.network.b bVar, String str, String str2, a aVar) {
        this.mSrc = "";
        this.bac = "";
        this.bad = bVar;
        this.bac = str;
        this.mSrc = str2;
        this.bbI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load() {
        this.bad.a(new Request.Builder().url(this.mSrc).build(), new Callback() { // from class: com.baidu.swan.games.e.c.c.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (c.DEBUG) {
                    Log.e("ImageDownloader", c.this.mSrc + " load failed");
                    iOException.printStackTrace();
                }
                if (c.this.bbI != null) {
                    c.this.bbI.s(-1, c.this.mSrc);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:88:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:98:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // okhttp3.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call call, Response response) {
                InputStream inputStream;
                InputStream inputStream2;
                FileOutputStream fileOutputStream = null;
                byte[] bArr = new byte[2048];
                try {
                    inputStream = response.body().byteStream();
                    try {
                        String hV = e.hV(c.this.mSrc);
                        String str = c.this.bac + hV.substring(0, hV.lastIndexOf("/"));
                        File file = new File(str);
                        if (!file.exists() || !file.isDirectory()) {
                            file.mkdirs();
                        }
                        String substring = hV.substring(hV.lastIndexOf("/") + 1);
                        int indexOf = substring.indexOf("?v=");
                        if (indexOf > 0) {
                            substring = substring.substring(0, indexOf);
                        }
                        File file2 = new File(str, substring + ".bddownload");
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            } catch (Exception e) {
                                e = e;
                                fileOutputStream = fileOutputStream2;
                                inputStream2 = inputStream;
                                try {
                                    if (c.DEBUG) {
                                        Log.e("ImageDownloader", c.this.mSrc + " load failed", e);
                                    }
                                    if (c.this.bbI != null) {
                                        c.this.bbI.s(-1, c.this.mSrc);
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e2) {
                                            Log.e("ImageDownloader", e2.getMessage(), e2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3) {
                                            Log.e("ImageDownloader", e3.getMessage(), e3);
                                        }
                                    }
                                    response.close();
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                            Log.e("ImageDownloader", e4.getMessage(), e4);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            Log.e("ImageDownloader", e5.getMessage(), e5);
                                        }
                                    }
                                    response.close();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                if (inputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                response.close();
                                throw th;
                            }
                        }
                        fileOutputStream2.flush();
                        File file3 = new File(str, substring);
                        if (file3.exists() && !file3.isDirectory()) {
                            file3.delete();
                        }
                        String absolutePath = file3.getAbsolutePath();
                        if (file2.renameTo(file3)) {
                            if (c.DEBUG) {
                                Log.e("ImageDownloader", c.this.mSrc + " load success path = " + absolutePath);
                            }
                            if (c.this.bbI != null) {
                                c.this.bbI.aN(c.this.mSrc, absolutePath);
                            }
                        } else {
                            if (c.DEBUG) {
                                Log.e("ImageDownloader", c.this.mSrc + " load rename error path = " + absolutePath);
                            }
                            if (c.this.bbI != null) {
                                c.this.bbI.s(-1, absolutePath);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                Log.e("ImageDownloader", e6.getMessage(), e6);
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e7) {
                                Log.e("ImageDownloader", e7.getMessage(), e7);
                            }
                        }
                        response.close();
                    } catch (Exception e8) {
                        e = e8;
                        inputStream2 = inputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e9) {
                    e = e9;
                    inputStream2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
        });
    }
}
