package com.baidu.ar.i;

import android.content.ContentResolver;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.resloader.utils.IoUtils;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.i;
import com.baidu.ar.util.o;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class b extends AsyncTask<String, Integer, String> {
    private int b;
    private a<String> c;
    private boolean e;
    private ContentResolver f;
    private String a = "";
    private boolean d = false;

    public b(int i, boolean z, ContentResolver contentResolver, a<String> aVar) {
        this.b = 0;
        this.b = i;
        this.c = aVar;
        this.e = z;
        this.f = contentResolver;
    }

    private boolean a(String str, File file) {
        String[] list;
        return (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0 && i.b(str, ".successUnzip.txt")) ? false : true;
    }

    private int c(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            return openConnection.getContentLength();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String d(String str) {
        ZipFile zipFile;
        ZipFile zipFile2;
        InputStream inputStream;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(i.a(this.a, this.b))) {
            File file = new File(str);
            if (str.length() <= 4) {
                return null;
            }
            String substring = str.substring(0, str.length() - 4);
            File file2 = new File(substring);
            if (file == null || file2 == null) {
                return null;
            }
            String a = o.a(str);
            if (this.e) {
                if (file2.exists()) {
                    File file3 = new File(file2.getAbsolutePath() + System.currentTimeMillis());
                    file2.renameTo(file3);
                    i.a(file3);
                }
            } else if (!a(a, file2)) {
                return substring;
            } else {
                if (file2.exists()) {
                    i.a(file2);
                }
            }
            try {
                zipFile = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile.entries();
                        while (entries.hasMoreElements()) {
                            ZipEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory()) {
                                File file4 = new File(file2, nextElement.getName());
                                if (!file4.getParentFile().exists()) {
                                    com.baidu.ar.util.b.a("file path = " + file4.getAbsolutePath() + ", parent path = " + file4.getParentFile().getAbsolutePath());
                                    file4.getParentFile().mkdirs();
                                }
                                try {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    try {
                                        try {
                                            IoUtils.copyStream(inputStream, file4);
                                            IoUtils.closeQuietly(inputStream);
                                        } catch (IOException e) {
                                            e = e;
                                            e.printStackTrace();
                                            IoUtils.closeQuietly(inputStream);
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        IoUtils.closeQuietly(inputStream);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                }
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (!this.e) {
                            i.a(a, ".successUnzip.txt");
                        }
                        return substring;
                    } catch (Throwable th3) {
                        th = th3;
                        if (zipFile != null) {
                        }
                        throw th;
                    }
                } catch (ZipException e4) {
                    e = e4;
                    zipFile2 = zipFile;
                    try {
                        e.printStackTrace();
                        if (zipFile2 != null) {
                            try {
                                zipFile2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (ZipException e9) {
                e = e9;
                zipFile2 = null;
            } catch (IOException e10) {
                e = e10;
                zipFile = null;
            } catch (Throwable th5) {
                th = th5;
                zipFile = null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:131:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017c, code lost:
        com.baidu.ar.util.b.a("cancelled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0182, code lost:
        if (r3 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0184, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0187, code lost:
        if (r2 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0189, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018e, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x018f, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ce A[Catch: IOException -> 0x01d2, TRY_LEAVE, TryCatch #6 {IOException -> 0x01d2, blocks: (B:81:0x01c9, B:83:0x01ce), top: B:101:0x01c9 }] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(String... strArr) {
        RandomAccessFile randomAccessFile;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        IOException e;
        RandomAccessFile randomAccessFile2;
        int i = 0;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String str = strArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f != null) {
            i.a(this.f);
        }
        String a = i.a(this.b);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        File file = new File(a);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        String str2 = a + File.separator + (o.a(str) + Constants.DOT + Constants.ZIP_SUFFIX);
        File file2 = new File(str2);
        if (file2.exists()) {
            if (a(str2)) {
                return d(str2);
            }
            file2.delete();
        } else if (!com.baidu.ar.util.d.a(file2.getParentFile())) {
            com.baidu.ar.util.b.d("create file error!");
            return null;
        } else {
            try {
                file2.createNewFile();
            } catch (IOException e2) {
                com.baidu.ar.util.b.d("create zip file error!");
                e2.printStackTrace();
                return null;
            }
        }
        int c = c(str);
        com.baidu.ar.util.b.a("download length = " + c);
        if (c == 0) {
            return null;
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setConnectTimeout(10000);
            openConnection.setRequestProperty("Range", "bytes=0-" + c);
            randomAccessFile = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile.seek(0L);
                byte[] bArr = new byte[8192];
                bufferedInputStream = new BufferedInputStream(openConnection.getInputStream(), 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            com.baidu.ar.util.b.a("one while read start n =" + read);
                            randomAccessFile.write(bArr, 0, read);
                            int i2 = read + i;
                            while (this.d) {
                                com.baidu.ar.util.b.a("mIsPause = " + this.d);
                                try {
                                    Thread.currentThread();
                                    Thread.sleep(500L);
                                } catch (InterruptedException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (isCancelled()) {
                                break;
                            }
                            com.baidu.ar.util.b.a("one while read end count = " + i2);
                            i = i2;
                        } else {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return d(str2);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                        }
                    } catch (IOException e5) {
                        e = e5;
                        randomAccessFile2 = randomAccessFile;
                        bufferedInputStream2 = bufferedInputStream;
                        try {
                            e.printStackTrace();
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    return d(str2);
                                }
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            return d(str2);
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = bufferedInputStream2;
                            randomAccessFile = randomAccessFile2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedInputStream != null) {
                        }
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                }
            } catch (IOException e8) {
                randomAccessFile2 = randomAccessFile;
                bufferedInputStream2 = null;
                e = e8;
            } catch (Throwable th4) {
                bufferedInputStream = null;
                th = th4;
            }
        } catch (IOException e9) {
            bufferedInputStream2 = null;
            e = e9;
            randomAccessFile2 = null;
        } catch (Throwable th5) {
            randomAccessFile = null;
            bufferedInputStream = null;
            th = th5;
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a(String str) {
        boolean z = false;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(str);
                z = true;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (0 != 0) {
                    try {
                        zipFile.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    zipFile.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c.b("download error!");
        } else {
            this.c.a(str);
        }
    }
}
