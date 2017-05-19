package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import com.baidu.android.pushservice.h.o;
import com.baidu.android.pushservice.richmedia.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes2.dex */
public class a extends Thread implements Comparable<a> {
    protected f a;
    public WeakReference<Context> b;
    public c d;
    private static HashSet<c> g = new HashSet<>();
    public static int e = 1;
    public static int f = 2;
    private boolean h = false;
    protected long c = System.currentTimeMillis();

    public a(Context context, f fVar, c cVar) {
        this.a = fVar;
        this.b = new WeakReference<>(context);
        this.d = cVar;
    }

    private int a(String str) {
        try {
            return ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
        } catch (MalformedURLException e2) {
            com.baidu.android.pushservice.e.a.e("HttpTaskThread", "error " + e2.getMessage());
            return 0;
        } catch (IOException e3) {
            com.baidu.android.pushservice.e.a.e("HttpTaskThread", "error " + e3.getMessage());
            return 0;
        }
    }

    private o.h a(Context context, String str) {
        List<o.h> b = o.b(context);
        if (b != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.size()) {
                    break;
                } else if (b.get(i2).b.equalsIgnoreCase(str)) {
                    return b.get(i2);
                } else {
                    i = i2 + 1;
                }
            }
        }
        return null;
    }

    private void a(e eVar) {
        try {
            if (this.a == null || eVar == null) {
                return;
            }
            if (eVar.c == 0) {
                String str = eVar.e;
                if (eVar.a == c.a.REQ_TYPE_GET_ZIP && str != null) {
                    String substring = str.substring(0, str.lastIndexOf("."));
                    File file = new File(str);
                    a(file, substring);
                    file.delete();
                    eVar.e = substring;
                }
                this.a.a(this, eVar);
            } else if (eVar.c == 1) {
                this.a.a(this, new Throwable("error: response http error errorCode=" + eVar.b));
            } else if (eVar.c == 3) {
                this.a.a(this, new Throwable("error: request error,request is null or fileName is null."));
            } else if (eVar.c == 2) {
                this.a.b(this);
            } else if (eVar.c == -1) {
                this.a.a(this, new Throwable("IOException"));
            }
        } finally {
            b(this.d);
        }
    }

    private static void a(File file, String str) {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        ZipInputStream zipInputStream2;
        FileOutputStream fileOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                    bufferedOutputStream = null;
                    fileOutputStream = null;
                    while (true) {
                        try {
                            try {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    com.baidu.android.pushservice.d.b.a(fileInputStream, zipInputStream, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                    return;
                                }
                                try {
                                    com.baidu.android.pushservice.e.a.b("DownloadCompleteReceiver: ", "unzip----=" + nextEntry);
                                    byte[] bArr = new byte[4096];
                                    String name = nextEntry.getName();
                                    String[] split = name.length() > 0 ? name.split("/") : null;
                                    File file2 = new File(str + "/" + split[split.length - 1]);
                                    if (!nextEntry.isDirectory()) {
                                        File file3 = new File(file2.getParent());
                                        if (!file3.exists()) {
                                            file3.mkdirs();
                                        }
                                        if (!file2.exists()) {
                                            file2.createNewFile();
                                        }
                                        FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                                        try {
                                            BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream3, 4096);
                                            while (true) {
                                                try {
                                                    int read = zipInputStream.read(bArr, 0, 4096);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream3.write(bArr, 0, read);
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    bufferedOutputStream = bufferedOutputStream3;
                                                    fileOutputStream = fileOutputStream3;
                                                    com.baidu.android.pushservice.e.a.a("HttpTaskThread", e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    bufferedOutputStream = bufferedOutputStream3;
                                                    fileOutputStream = fileOutputStream3;
                                                    com.baidu.android.pushservice.d.b.a(fileInputStream, zipInputStream, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                                    throw th;
                                                }
                                            }
                                            bufferedOutputStream3.flush();
                                            bufferedOutputStream = bufferedOutputStream3;
                                            fileOutputStream = fileOutputStream3;
                                        } catch (Exception e3) {
                                            e = e3;
                                            fileOutputStream = fileOutputStream3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream = fileOutputStream3;
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                fileOutputStream2 = fileOutputStream;
                                bufferedOutputStream2 = bufferedOutputStream;
                                bufferedInputStream2 = bufferedInputStream;
                                zipInputStream2 = zipInputStream;
                                fileInputStream2 = fileInputStream;
                                try {
                                    com.baidu.android.pushservice.e.a.e("HttpTaskThread", "error " + e.getMessage());
                                    com.baidu.android.pushservice.d.b.a(fileInputStream2, zipInputStream2, fileOutputStream2, bufferedOutputStream2, bufferedInputStream2);
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileInputStream = fileInputStream2;
                                    zipInputStream = zipInputStream2;
                                    bufferedInputStream = bufferedInputStream2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileOutputStream = fileOutputStream2;
                                    com.baidu.android.pushservice.d.b.a(fileInputStream, zipInputStream, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    bufferedInputStream2 = bufferedInputStream;
                    fileInputStream2 = fileInputStream;
                    zipInputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    zipInputStream = null;
                    fileOutputStream = null;
                }
            } catch (Exception e7) {
                e = e7;
                zipInputStream2 = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = null;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream2 = null;
            zipInputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipInputStream = null;
            fileInputStream = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }

    private static synchronized boolean a(c cVar) {
        boolean add;
        synchronized (a.class) {
            add = g.add(cVar);
        }
        return add;
    }

    private e b() {
        o.h hVar;
        int read;
        e eVar = new e();
        eVar.d = this.d;
        if (this.d != null) {
            eVar.a = this.d.a();
            if (this.d.b == null) {
                com.baidu.android.pushservice.e.a.c("HttpTaskThread", "download file Request error: " + this.d);
                eVar.c = 3;
            } else if (!a(this.d)) {
                com.baidu.android.pushservice.e.a.d("HttpTaskThread", "Request url: " + this.d.c() + " failed, already in queue");
                this.a = null;
                this.d = null;
                return null;
            } else {
                o.h a = a(this.b.get(), this.d.c());
                if (a == null) {
                    hVar = new o.h();
                    hVar.b = this.d.c();
                    hVar.a = this.d.a;
                    hVar.c = this.d.c;
                    hVar.d = this.d.d;
                    hVar.g = 0;
                    hVar.h = a(hVar.b);
                    hVar.i = e;
                    hVar.f = hVar.b.substring(hVar.b.lastIndexOf(47) + 1);
                    hVar.e = this.d.b;
                    try {
                        o.a(this.b.get(), hVar);
                    } catch (Exception e2) {
                        com.baidu.android.pushservice.e.a.c("HttpTaskThread", "HttpTask insertFileDownloadingInfo");
                    }
                } else {
                    a.h = a(a.b);
                    hVar = a;
                }
                if (hVar.i == f) {
                    eVar.c = 0;
                    eVar.d = this.d;
                    eVar.e = hVar.e + "/" + hVar.f;
                    return eVar;
                }
                com.baidu.android.pushservice.e.a.c("HttpTaskThread", "Request url: " + this.d.c() + " success");
                if (this.a != null) {
                    this.a.a(this);
                }
                try {
                    com.baidu.android.pushservice.d.a a2 = com.baidu.android.pushservice.d.b.a(this.d.c(), this.d.b(), this.d.f);
                    if (a2.b() == 200) {
                        InputStream a3 = a2.a();
                        File file = new File(hVar.e);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(hVar.e + "/" + hVar.f);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                        randomAccessFile.seek(hVar.g);
                        byte[] bArr = new byte[102400];
                        int i = hVar.g;
                        b bVar = new b();
                        bVar.b = hVar.h;
                        bVar.a = i;
                        a(bVar);
                        do {
                            try {
                                if (this.h || (read = a3.read(bArr)) == -1) {
                                    break;
                                }
                                randomAccessFile.write(bArr, 0, read);
                                i += read;
                                b bVar2 = new b();
                                bVar2.b = hVar.h;
                                bVar2.a = i;
                                a(bVar2);
                            } catch (IOException e3) {
                                com.baidu.android.pushservice.e.a.a("HttpTaskThread", e3);
                                com.baidu.android.pushservice.d.b.a(a3, randomAccessFile);
                            }
                        } while (i != hVar.h);
                        com.baidu.android.pushservice.d.b.a(a3, randomAccessFile);
                        if (this.h) {
                            o.b(this.b.get(), hVar.b);
                            eVar.c = 2;
                            file2.delete();
                        } else {
                            hVar.g = i;
                            hVar.i = f;
                            o.a(this.b.get(), hVar.b, hVar);
                            eVar.c = 0;
                            eVar.e = file2.getAbsolutePath();
                        }
                    } else {
                        eVar.c = 1;
                        eVar.b = a2.b();
                    }
                } catch (Exception e4) {
                    com.baidu.android.pushservice.e.a.e("HttpTaskThread", "download file Exception:" + e4.getMessage());
                    eVar.c = -1;
                }
            }
        }
        return eVar;
    }

    private static synchronized boolean b(c cVar) {
        boolean remove;
        synchronized (a.class) {
            remove = g.remove(cVar);
        }
        return remove;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return -1;
        }
        long a = aVar.a();
        if (this.c <= a) {
            return this.c < a ? 1 : 0;
        }
        return -1;
    }

    public long a() {
        return this.c;
    }

    protected void a(b bVar) {
        if (this.a != null) {
            this.a.a(this, bVar);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a(b());
    }
}
