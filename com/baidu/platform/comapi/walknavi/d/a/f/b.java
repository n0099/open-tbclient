package com.baidu.platform.comapi.walknavi.d.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.platform.comapi.walknavi.d.a.g.k;
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
/* loaded from: classes2.dex */
public class b extends AsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    public String f9553a;

    /* renamed from: b  reason: collision with root package name */
    public int f9554b;

    /* renamed from: c  reason: collision with root package name */
    public a<String> f9555c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9556d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9557e;

    /* renamed from: f  reason: collision with root package name */
    public String f9558f;

    public b(String str, int i, boolean z, a<String> aVar) {
        this.f9553a = "";
        this.f9554b = 0;
        this.f9553a = str;
        this.f9554b = i;
        this.f9555c = aVar;
        this.f9557e = z;
    }

    private int b(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            return openConnection.getContentLength();
        } catch (MalformedURLException | IOException unused) {
            return 0;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:113:0x00e3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x00e5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:153:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:155:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0105 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v4, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(String str) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream2;
        BufferedOutputStream bufferedOutputStream3;
        ZipFile zipFile2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (str.length() <= 4) {
            return null;
        }
        String substring = str.substring(0, str.length() - 4);
        File file2 = new File(substring);
        String a2 = k.a(str);
        if (this.f9557e) {
            if (file2.exists()) {
                com.baidu.platform.comapi.walknavi.d.a.g.f.a(file2);
            }
        } else if (!a(a2, file2)) {
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
                bufferedInputStream = null;
                bufferedOutputStream = null;
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
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement), 8192);
                            try {
                                BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(file3), 8192);
                                while (true) {
                                    try {
                                        int read = bufferedInputStream2.read(bArr, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream4.write(bArr, 0, read);
                                    } catch (ZipException unused) {
                                        bufferedOutputStream = bufferedOutputStream4;
                                        bufferedInputStream = bufferedInputStream2;
                                        bufferedOutputStream3 = bufferedOutputStream;
                                        if (zipFile != null) {
                                        }
                                        if (bufferedInputStream != null) {
                                        }
                                        if (bufferedOutputStream3 != 0) {
                                        }
                                        return null;
                                    } catch (IOException unused2) {
                                        bufferedOutputStream = bufferedOutputStream4;
                                        bufferedInputStream = bufferedInputStream2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        if (zipFile != null) {
                                        }
                                        if (bufferedInputStream != null) {
                                        }
                                        if (bufferedOutputStream2 != 0) {
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        zipFile2 = zipFile;
                                        bufferedOutputStream = bufferedOutputStream4;
                                        bufferedInputStream = bufferedInputStream2;
                                        if (zipFile2 != null) {
                                        }
                                        if (bufferedInputStream != null) {
                                        }
                                        if (bufferedOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                bufferedOutputStream4.flush();
                                bufferedOutputStream = bufferedOutputStream4;
                                bufferedInputStream = bufferedInputStream2;
                            } catch (ZipException unused3) {
                            } catch (IOException unused4) {
                            } catch (Throwable th2) {
                                th = th2;
                                zipFile2 = zipFile;
                                bufferedOutputStream = bufferedOutputStream;
                            }
                        }
                    } catch (ZipException unused5) {
                        bufferedOutputStream3 = bufferedOutputStream;
                    } catch (IOException unused6) {
                        bufferedOutputStream2 = bufferedOutputStream;
                    } catch (Throwable th3) {
                        th = th3;
                        zipFile2 = zipFile;
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused9) {
                            }
                        }
                        throw th;
                    }
                }
                try {
                    zipFile.close();
                } catch (IOException unused10) {
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused11) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused12) {
                    }
                }
                if (!this.f9557e) {
                    com.baidu.platform.comapi.walknavi.d.a.g.f.a(a2, ".successUnzip.txt");
                }
                return substring;
            } catch (ZipException unused13) {
                bufferedInputStream = null;
                bufferedOutputStream3 = bufferedInputStream;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused14) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused15) {
                    }
                }
                if (bufferedOutputStream3 != 0) {
                    try {
                        bufferedOutputStream3.close();
                    } catch (IOException unused16) {
                    }
                }
                return null;
            } catch (IOException unused17) {
                bufferedInputStream = null;
                bufferedOutputStream2 = bufferedInputStream;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused18) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused19) {
                    }
                }
                if (bufferedOutputStream2 != 0) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused20) {
                    }
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (ZipException unused21) {
            zipFile = null;
            bufferedInputStream = null;
        } catch (IOException unused22) {
            zipFile = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        a<String> aVar = this.f9555c;
        if (aVar != null) {
            aVar.a(numArr[0].intValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x018d, code lost:
        com.baidu.platform.comapi.walknavi.d.a.g.a.a("cancelled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0192, code lost:
        r8.close();
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b2, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d0, code lost:
        if (r4 != null) goto L66;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(String... strArr) {
        String str;
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream = null;
        if (strArr != null && strArr.length > 0) {
            String str2 = strArr[0];
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            this.f9558f = str2;
            String a2 = com.baidu.platform.comapi.walknavi.d.a.g.f.a(this.f9553a, this.f9554b);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            str = a2 + File.separator + (k.a(str2) + ".zip");
            File file2 = new File(str);
            if (file2.exists()) {
                try {
                    new ZipFile(str);
                    if (!com.baidu.platform.comapi.walknavi.d.a.b.f9503a) {
                        if (this.f9555c != null) {
                            this.f9555c.a(false, b(str2));
                            return "false";
                        }
                        return "false";
                    }
                    return c(str);
                } catch (Exception unused) {
                    file2.delete();
                    if (!com.baidu.platform.comapi.walknavi.d.a.b.f9503a) {
                        a<String> aVar = this.f9555c;
                        if (aVar != null) {
                            aVar.a(true, b(str2));
                        }
                        return "true";
                    }
                }
            } else if (!com.baidu.platform.comapi.walknavi.d.a.b.f9503a) {
                a<String> aVar2 = this.f9555c;
                if (aVar2 != null) {
                    aVar2.a(true, b(str2));
                }
                return "true";
            } else if (com.baidu.platform.comapi.walknavi.d.a.g.c.a(file2.getParentFile())) {
                try {
                    file2.createNewFile();
                } catch (IOException unused2) {
                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("create zip file error!");
                    return null;
                }
            } else {
                com.baidu.platform.comapi.walknavi.d.a.g.a.a("create file error!");
            }
            int b2 = b(str2);
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("download length = " + b2);
            try {
                if (b2 == 0) {
                    return null;
                }
                try {
                    URLConnection openConnection = new URL(str2).openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setRequestProperty("Range", "bytes=0-" + b2);
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(0L);
                        byte[] bArr = new byte[8192];
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(openConnection.getInputStream(), 8192);
                        int i = 0;
                        while (true) {
                            try {
                                int read = bufferedInputStream2.read(bArr, 0, 8192);
                                if (read != -1) {
                                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("one while read start n =" + read);
                                    randomAccessFile.write(bArr, 0, read);
                                    i += read;
                                    int i2 = (int) ((((float) i) * 100.0f) / ((float) b2));
                                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("percentProgress = " + i2);
                                    publishProgress(Integer.valueOf(i2));
                                    while (this.f9556d) {
                                        com.baidu.platform.comapi.walknavi.d.a.g.a.a("mIsPause = " + this.f9556d);
                                        try {
                                            Thread.currentThread();
                                            Thread.sleep(500L);
                                        } catch (InterruptedException unused3) {
                                        }
                                    }
                                    if (isCancelled()) {
                                        break;
                                    }
                                    com.baidu.platform.comapi.walknavi.d.a.g.a.a("one while read end count = " + i);
                                } else {
                                    bufferedInputStream2.close();
                                    break;
                                }
                            } catch (IOException unused4) {
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException unused5) {
                                        throw th;
                                    }
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                throw th;
                            }
                        }
                    } catch (IOException unused6) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException unused7) {
                    randomAccessFile = null;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                }
            } catch (IOException unused8) {
            }
        }
        return null;
        return c(str);
        return null;
    }

    private boolean a(String str, File file) {
        String[] list;
        return (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0 && com.baidu.platform.comapi.walknavi.d.a.g.f.b(str, ".successUnzip.txt")) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        a<String> aVar;
        if (TextUtils.isEmpty(str)) {
            a<String> aVar2 = this.f9555c;
            if (aVar2 != null) {
                aVar2.b("download error!");
            }
        } else if ("true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str) || (aVar = this.f9555c) == null) {
        } else {
            aVar.a(100);
            this.f9555c.a((a<String>) str);
        }
    }
}
