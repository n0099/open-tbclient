package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import com.baidu.android.pushservice.d.a;
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
        } catch (MalformedURLException | IOException e2) {
            return 0;
        }
    }

    private a.g a(Context context, String str) {
        List<a.g> b = com.baidu.android.pushservice.d.a.b(context);
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
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream2;
        ZipInputStream zipInputStream2;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    zipInputStream = new ZipInputStream(bufferedInputStream);
                    BufferedOutputStream bufferedOutputStream2 = null;
                    FileOutputStream fileOutputStream2 = null;
                    while (true) {
                        try {
                            try {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    com.baidu.android.pushservice.f.b.a(fileInputStream, zipInputStream, fileOutputStream2, bufferedOutputStream2, bufferedInputStream);
                                    return;
                                }
                                try {
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
                                        fileOutputStream = new FileOutputStream(file2);
                                        try {
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 4096);
                                            while (true) {
                                                try {
                                                    int read = zipInputStream.read(bArr, 0, 4096);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                } catch (Exception e2) {
                                                    bufferedOutputStream2 = bufferedOutputStream;
                                                    fileOutputStream2 = fileOutputStream;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    com.baidu.android.pushservice.f.b.a(fileInputStream, zipInputStream, fileOutputStream, bufferedOutputStream, bufferedInputStream);
                                                    throw th;
                                                }
                                            }
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (Exception e3) {
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (Throwable th3) {
                                            bufferedOutputStream = bufferedOutputStream2;
                                            th = th3;
                                        }
                                    }
                                } catch (Exception e4) {
                                }
                            } catch (Throwable th4) {
                                fileOutputStream = fileOutputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                th = th4;
                            }
                        } catch (Exception e5) {
                            fileOutputStream = fileOutputStream2;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream2 = bufferedInputStream;
                            zipInputStream2 = zipInputStream;
                            fileInputStream2 = fileInputStream;
                            com.baidu.android.pushservice.f.b.a(fileInputStream2, zipInputStream2, fileOutputStream, bufferedOutputStream, bufferedInputStream2);
                            return;
                        }
                    }
                } catch (Exception e6) {
                    bufferedInputStream2 = bufferedInputStream;
                    fileInputStream2 = fileInputStream;
                    zipInputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = null;
                }
            } catch (Exception e7) {
                zipInputStream2 = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th6) {
                zipInputStream = null;
                th = th6;
                bufferedInputStream = null;
            }
        } catch (Exception e8) {
            fileInputStream2 = null;
            zipInputStream2 = null;
        } catch (Throwable th7) {
            fileInputStream = null;
            bufferedInputStream = null;
            th = th7;
            zipInputStream = null;
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
        a.g gVar;
        int read;
        e eVar = new e();
        eVar.d = this.d;
        if (this.d != null) {
            eVar.a = this.d.a();
            if (this.d.b == null) {
                eVar.c = 3;
            } else if (!a(this.d)) {
                this.a = null;
                this.d = null;
                return null;
            } else {
                a.g a = a(this.b.get(), this.d.c());
                if (a == null) {
                    gVar = new a.g();
                    gVar.b = this.d.c();
                    gVar.a = this.d.a;
                    gVar.c = this.d.c;
                    gVar.d = this.d.d;
                    gVar.g = 0;
                    gVar.h = a(gVar.b);
                    gVar.i = e;
                    gVar.f = gVar.b.substring(gVar.b.lastIndexOf(47) + 1);
                    gVar.e = this.d.b;
                    try {
                        com.baidu.android.pushservice.d.a.a(this.b.get(), gVar);
                    } catch (Exception e2) {
                    }
                } else {
                    a.h = a(a.b);
                    gVar = a;
                }
                if (gVar.i == f) {
                    eVar.c = 0;
                    eVar.d = this.d;
                    eVar.e = gVar.e + "/" + gVar.f;
                    return eVar;
                }
                if (this.a != null) {
                    this.a.a(this);
                }
                try {
                    com.baidu.android.pushservice.f.a a2 = com.baidu.android.pushservice.f.b.a(this.d.c(), this.d.b(), this.d.f);
                    if (a2.b() == 200) {
                        InputStream a3 = a2.a();
                        File file = new File(gVar.e);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(gVar.e + "/" + gVar.f);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                        randomAccessFile.seek(gVar.g);
                        byte[] bArr = new byte[102400];
                        int i = gVar.g;
                        b bVar = new b();
                        bVar.b = gVar.h;
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
                                bVar2.b = gVar.h;
                                bVar2.a = i;
                                a(bVar2);
                            } catch (IOException e3) {
                                com.baidu.android.pushservice.f.b.a(a3, randomAccessFile);
                            }
                        } while (i != gVar.h);
                        com.baidu.android.pushservice.f.b.a(a3, randomAccessFile);
                        if (this.h) {
                            com.baidu.android.pushservice.d.a.b(this.b.get(), gVar.b);
                            eVar.c = 2;
                            file2.delete();
                        } else {
                            gVar.g = i;
                            gVar.i = f;
                            com.baidu.android.pushservice.d.a.a(this.b.get(), gVar.b, gVar);
                            eVar.c = 0;
                            eVar.e = file2.getAbsolutePath();
                        }
                    } else {
                        eVar.c = 1;
                        eVar.b = a2.b();
                    }
                } catch (Exception e4) {
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
