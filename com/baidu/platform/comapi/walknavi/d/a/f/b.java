package com.baidu.platform.comapi.walknavi.d.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.g.k;
import com.baidubce.http.Headers;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
public class b extends AsyncTask<String, Integer, String> {
    private String a;
    private int b;
    private a<String> c;
    private boolean d = false;
    private boolean e;
    private String f;

    public b(String str, int i, boolean z, a<String> aVar) {
        this.a = "";
        this.b = 0;
        this.a = str;
        this.b = i;
        this.c = aVar;
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.c != null) {
            this.c.a(numArr[0].intValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4, 213=4, 215=4, 216=4, 218=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:140:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01cc, code lost:
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("cancelled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01d2, code lost:
        if (r2 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01d4, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01d7, code lost:
        if (r1 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d9, code lost:
        r1.close();
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(String... strArr) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream2;
        int i = 0;
        RandomAccessFile randomAccessFile2 = null;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.f = str;
        String a = com.baidu.platform.comapi.walknavi.d.a.g.f.a(this.a, this.b);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        File file = new File(a);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        String str2 = a + File.separator + (k.a(str) + ".zip");
        File file2 = new File(str2);
        if (file2.exists()) {
            try {
                new ZipFile(str2);
                if (com.baidu.platform.comapi.walknavi.d.a.b.a) {
                    return c(str2);
                }
                if (this.c != null) {
                    this.c.a(false, b(str));
                }
                return "false";
            } catch (Exception e) {
                file2.delete();
                if (!com.baidu.platform.comapi.walknavi.d.a.b.a) {
                    if (this.c != null) {
                        this.c.a(true, b(str));
                    }
                    return "true";
                }
            }
        } else if (!com.baidu.platform.comapi.walknavi.d.a.b.a) {
            if (this.c != null) {
                this.c.a(true, b(str));
            }
            return "true";
        } else if (!com.baidu.platform.comapi.walknavi.d.a.g.c.a(file2.getParentFile())) {
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("create file error!");
            return null;
        } else {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("create zip file error!");
                return null;
            }
        }
        int b = b(str);
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("download length = " + b);
        if (b == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setRequestProperty(Headers.RANGE, "bytes=0-" + b);
            randomAccessFile = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile.seek(0L);
                byte[] bArr = new byte[8192];
                bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            com.baidu.platform.comapi.walknavi.d.a.g.a.a("one while read start n =" + read);
                            randomAccessFile.write(bArr, 0, read);
                            i += read;
                            int i2 = (int) ((100.0f * i) / b);
                            com.baidu.platform.comapi.walknavi.d.a.g.a.a("percentProgress = " + i2);
                            publishProgress(Integer.valueOf(i2));
                            while (this.d) {
                                com.baidu.platform.comapi.walknavi.d.a.g.a.a("mIsPause = " + this.d);
                                try {
                                    Thread.currentThread();
                                    Thread.sleep(500L);
                                } catch (InterruptedException e3) {
                                }
                            }
                            if (isCancelled()) {
                                break;
                            }
                            com.baidu.platform.comapi.walknavi.d.a.g.a.a("one while read end count = " + i);
                        } else {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    return c(str2);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                        }
                    } catch (IOException e5) {
                        randomAccessFile2 = randomAccessFile;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e6) {
                                return c(str2);
                            }
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        return c(str2);
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                                throw th;
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException e8) {
                bufferedInputStream2 = null;
                randomAccessFile2 = randomAccessFile;
            } catch (Throwable th3) {
                bufferedInputStream = null;
                th = th3;
            }
        } catch (IOException e9) {
            bufferedInputStream2 = null;
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            randomAccessFile = null;
        }
    }

    private int b(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            return openConnection.getContentLength();
        } catch (MalformedURLException e) {
            return 0;
        } catch (IOException e2) {
            return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=5, 350=4, 351=4, 356=4, 358=4, 359=4, 364=4, 366=4, 367=4] */
    private String c(String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        ZipFile zipFile2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (str.length() <= 4) {
            return null;
        }
        String substring = str.substring(0, str.length() - 4);
        File file2 = new File(substring);
        String a = k.a(str);
        if (this.e) {
            if (file2.exists()) {
                com.baidu.platform.comapi.walknavi.d.a.g.f.a(file2);
            }
        } else if (!a(a, file2)) {
            return substring;
        } else {
            if (file2.exists()) {
                com.baidu.platform.comapi.walknavi.d.a.g.f.a(file2);
            }
        }
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                bufferedOutputStream = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory()) {
                            File file3 = new File(file2, nextElement.getName());
                            if (!file3.getParentFile().exists()) {
                                com.baidu.platform.comapi.walknavi.d.a.g.a.a("file path = " + file3.getAbsolutePath() + ", parent path = " + file3.getParentFile().getAbsolutePath());
                                file3.getParentFile().mkdirs();
                            }
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                            byte[] bArr = new byte[8192];
                            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(nextElement), 8192);
                            try {
                                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file3), 8192);
                                int i = 0;
                                while (true) {
                                    try {
                                        int read = bufferedInputStream3.read(bArr, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                        i += read;
                                    } catch (ZipException e) {
                                        bufferedInputStream2 = bufferedInputStream3;
                                        zipFile2 = zipFile;
                                        if (zipFile2 != null) {
                                            try {
                                                zipFile2.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        if (bufferedOutputStream2 != null) {
                                            try {
                                                bufferedOutputStream2.close();
                                            } catch (IOException e4) {
                                            }
                                        }
                                        return null;
                                    } catch (IOException e5) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                        bufferedInputStream = bufferedInputStream3;
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e6) {
                                            }
                                        }
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e7) {
                                            }
                                        }
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e8) {
                                            }
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        bufferedOutputStream = bufferedOutputStream2;
                                        bufferedInputStream = bufferedInputStream3;
                                        th = th;
                                        if (zipFile != null) {
                                            try {
                                                zipFile.close();
                                            } catch (IOException e9) {
                                            }
                                        }
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e10) {
                                            }
                                        }
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e11) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                bufferedOutputStream2.flush();
                                bufferedOutputStream = bufferedOutputStream2;
                                bufferedInputStream = bufferedInputStream3;
                            } catch (ZipException e12) {
                                bufferedOutputStream2 = bufferedOutputStream;
                                bufferedInputStream2 = bufferedInputStream3;
                                zipFile2 = zipFile;
                            } catch (IOException e13) {
                                bufferedInputStream = bufferedInputStream3;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream3;
                            }
                        }
                    } catch (ZipException e14) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                        zipFile2 = zipFile;
                    } catch (IOException e15) {
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e16) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e18) {
                    }
                }
                if (!this.e) {
                    com.baidu.platform.comapi.walknavi.d.a.g.f.a(a, ".successUnzip.txt");
                }
                return substring;
            } catch (ZipException e19) {
                bufferedOutputStream2 = null;
                bufferedInputStream2 = null;
                zipFile2 = zipFile;
            } catch (IOException e20) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (ZipException e21) {
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
            zipFile2 = null;
        } catch (IOException e22) {
            bufferedOutputStream = null;
            bufferedInputStream = null;
            zipFile = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            zipFile = null;
        }
    }

    private boolean a(String str, File file) {
        String[] list;
        return (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0 && com.baidu.platform.comapi.walknavi.d.a.g.f.b(str, ".successUnzip.txt")) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.c != null) {
                this.c.b("download error!");
            }
        } else if (!"true".equalsIgnoreCase(str) && !"false".equalsIgnoreCase(str) && this.c != null) {
            this.c.a(100);
            this.c.a((a<String>) str);
        }
    }
}
