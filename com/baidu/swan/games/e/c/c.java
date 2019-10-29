package com.baidu.swan.games.e.c;

import android.util.Log;
import com.baidu.swan.games.audio.f;
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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String byr;
    private com.baidu.swan.games.network.b bys;
    private a bzR;
    private String mSrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.baidu.swan.games.network.b bVar, String str, String str2, a aVar) {
        this.mSrc = "";
        this.byr = "";
        this.bys = bVar;
        this.byr = str;
        this.mSrc = str2;
        this.bzR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void load() {
        this.bys.a(new Request.Builder().url(this.mSrc).build(), new Callback() { // from class: com.baidu.swan.games.e.c.c.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (c.DEBUG) {
                    Log.e("ImageDownloader", c.this.mSrc + " load failed");
                    iOException.printStackTrace();
                }
                if (c.this.bzR != null) {
                    c.this.bzR.x(-1, c.this.mSrc);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:89:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:99:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // okhttp3.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
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
                            String jt = f.jt(c.this.mSrc);
                            String str = c.this.byr + jt.substring(0, jt.lastIndexOf("/"));
                            File file2 = new File(str);
                            if (!file2.exists() || !file2.isDirectory()) {
                                file2.mkdirs();
                            }
                            String substring = jt.substring(jt.lastIndexOf("/") + 1);
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
                                                Log.e("ImageDownloader", c.this.mSrc + " load failed", e);
                                            }
                                            if (file != null) {
                                                file.delete();
                                            }
                                            if (c.this.bzR != null) {
                                                c.this.bzR.x(-1, c.this.mSrc);
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (IOException e2) {
                                                    Log.e("ImageDownloader", e2.getMessage(), e2);
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (IOException e3) {
                                                    Log.e("ImageDownloader", e3.getMessage(), e3);
                                                }
                                            }
                                            response.close();
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = inputStream2;
                                            fileOutputStream = fileOutputStream2;
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
                                        if (inputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        response.close();
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
                                        Log.e("ImageDownloader", c.this.mSrc + " load rename success path = " + absolutePath);
                                    }
                                    if (c.this.bzR != null) {
                                        c.this.bzR.aX(c.this.mSrc, absolutePath);
                                    }
                                } else {
                                    if (c.DEBUG) {
                                        Log.e("ImageDownloader", c.this.mSrc + " load rename error path = " + absolutePath);
                                    }
                                    file3.delete();
                                    if (c.this.bzR != null) {
                                        c.this.bzR.x(-1, absolutePath);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e6) {
                                        Log.e("ImageDownloader", e6.getMessage(), e6);
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        Log.e("ImageDownloader", e7.getMessage(), e7);
                                    }
                                }
                                response.close();
                            } catch (Exception e8) {
                                e = e8;
                                inputStream2 = inputStream;
                                file = file3;
                                fileOutputStream2 = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        fileOutputStream2 = null;
                        inputStream2 = inputStream;
                    }
                } catch (Exception e10) {
                    e = e10;
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
