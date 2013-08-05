package com.baidu.android.pushservice.richmedia;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.mm.sdk.platformtools.LVBuffer;
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
import org.apache.http.HttpResponse;
/* loaded from: classes.dex */
public class b extends AsyncTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    protected s f605a;
    public WeakReference b;
    public n d;
    private static HashSet h = new HashSet();
    public static int e = 1;
    public static int f = 2;
    private l g = l.a(b.class.getName());
    private boolean i = false;
    private boolean j = false;
    protected long c = System.currentTimeMillis();

    public b(Context context, s sVar) {
        this.f605a = sVar;
        this.b = new WeakReference(context);
    }

    private int a(String str) {
        try {
            return ((HttpURLConnection) new URL(str).openConnection()).getContentLength();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IOException e3) {
            e3.printStackTrace();
            return 0;
        }
    }

    private com.baidu.android.pushservice.util.i a(Context context, String str) {
        List b = com.baidu.android.pushservice.util.e.b(com.baidu.android.pushservice.util.e.a(context));
        if (b != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= b.size()) {
                    break;
                } else if (((com.baidu.android.pushservice.util.i) b.get(i2)).b.equalsIgnoreCase(str)) {
                    return (com.baidu.android.pushservice.util.i) b.get(i2);
                } else {
                    i = i2 + 1;
                }
            }
        }
        return null;
    }

    private static void a(File file, String str) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
        } catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                fileInputStream.close();
                zipInputStream.close();
                return;
            }
            try {
                Log.i("DownloadCompleteReceiver: ", "unzip----=" + nextEntry);
                byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
                String[] split = nextEntry.getName().split("/");
                File file2 = new File(str + "/" + split[split.length - 1]);
                if (!nextEntry.isDirectory()) {
                    File file3 = new File(file2.getParent());
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), LVBuffer.LENGTH_ALLOC_PER_NEW);
                    while (true) {
                        int read = zipInputStream.read(bArr, 0, LVBuffer.LENGTH_ALLOC_PER_NEW);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            e2.printStackTrace();
            return;
        }
    }

    private static synchronized boolean a(n nVar) {
        boolean add;
        synchronized (b.class) {
            add = h.add(nVar);
        }
        return add;
    }

    private static synchronized boolean b(n nVar) {
        boolean remove;
        synchronized (b.class) {
            remove = h.remove(nVar);
        }
        return remove;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(b bVar) {
        if (bVar == null) {
            return -1;
        }
        long a2 = bVar.a();
        if (this.c <= a2) {
            return this.c < a2 ? 1 : 0;
        }
        return -1;
    }

    public long a() {
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public r doInBackground(n... nVarArr) {
        com.baidu.android.pushservice.util.i iVar;
        r rVar = new r();
        this.d = nVarArr[0];
        rVar.d = this.d;
        if (this.d != null) {
            rVar.f620a = this.d.b();
            if (this.d.b == null) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.d("HttpTask", "download file Request error: " + this.d);
                }
                rVar.c = 3;
            } else if (!a(this.d)) {
                this.g.c("Request url: " + this.d.d() + " failed, already in queue");
                this.f605a = null;
                this.d = null;
                return null;
            } else {
                com.baidu.android.pushservice.util.i a2 = a((Context) this.b.get(), this.d.d());
                if (a2 == null) {
                    iVar = new com.baidu.android.pushservice.util.i();
                    iVar.b = this.d.d();
                    iVar.f630a = this.d.f617a;
                    iVar.c = this.d.c;
                    iVar.d = this.d.d;
                    iVar.g = 0;
                    iVar.h = a(iVar.b);
                    iVar.i = e;
                    iVar.f = iVar.b.substring(iVar.b.lastIndexOf(47) + 1);
                    iVar.e = this.d.b;
                    com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a((Context) this.b.get()), iVar);
                } else {
                    a2.h = a(a2.b);
                    iVar = a2;
                }
                if (iVar.i == f) {
                    rVar.c = 0;
                    rVar.d = this.d;
                    rVar.e = iVar.e + "/" + iVar.f;
                    return rVar;
                }
                this.g.b("Request url: " + this.d.d() + " success");
                if (this.f605a != null) {
                    this.f605a.a(this);
                }
                try {
                    HttpResponse a3 = new a().a(this.d.c(), this.d.d(), this.d.a(), this.d.f);
                    if (a3.getStatusLine().getStatusCode() == 200) {
                        InputStream content = a3.getEntity().getContent();
                        File file = new File(iVar.e);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        File file2 = new File(iVar.e + "/" + iVar.f);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                        randomAccessFile.seek(iVar.g);
                        byte[] bArr = new byte[102400];
                        int i = iVar.g;
                        m mVar = new m();
                        mVar.b = iVar.h;
                        mVar.f616a = i;
                        publishProgress(mVar);
                        while (true) {
                            if (this.i) {
                                break;
                            }
                            while (true == this.j) {
                                Thread.sleep(500L);
                            }
                            int read = content.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            randomAccessFile.write(bArr, 0, read);
                            int i2 = read + i;
                            m mVar2 = new m();
                            mVar2.b = iVar.h;
                            mVar2.f616a = i2;
                            publishProgress(mVar2);
                            if (i2 == iVar.h) {
                                i = i2;
                                break;
                            }
                            Thread.sleep(500L);
                            iVar.g = i2;
                            com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a((Context) this.b.get()), iVar.b, iVar);
                            i = i2;
                        }
                        content.close();
                        randomAccessFile.close();
                        if (this.i) {
                            com.baidu.android.pushservice.util.e.b(com.baidu.android.pushservice.util.e.a((Context) this.b.get()), iVar.b);
                            rVar.c = 2;
                            file2.delete();
                        } else {
                            iVar.g = i;
                            iVar.i = f;
                            com.baidu.android.pushservice.util.e.a(com.baidu.android.pushservice.util.e.a((Context) this.b.get()), iVar.b, iVar);
                            rVar.c = 0;
                            rVar.e = file2.getAbsolutePath();
                        }
                    } else {
                        rVar.c = 1;
                        rVar.b = a3.getStatusLine().getStatusCode();
                    }
                } catch (Exception e2) {
                    if (com.baidu.android.pushservice.b.a()) {
                        Log.d("HttpTask", "download file Exception:" + e2.getMessage());
                    }
                    rVar.c = -1;
                }
            }
        }
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(r rVar) {
        try {
            if (this.f605a == null || rVar == null) {
                return;
            }
            if (rVar.c == 0) {
                String str = rVar.e;
                if (rVar.f620a == o.REQ_TYPE_GET_ZIP && str != null) {
                    String substring = str.substring(0, str.lastIndexOf("."));
                    File file = new File(str);
                    a(file, substring);
                    file.delete();
                    rVar.e = substring;
                }
                this.f605a.a(this, rVar);
            } else if (rVar.c == 1) {
                this.f605a.a(this, new Throwable("error: response http error errorCode=" + rVar.b));
            } else if (rVar.c == 3) {
                this.f605a.a(this, new Throwable("error: request error,request is null or fileName is null."));
            } else if (rVar.c == 2) {
                this.f605a.b(this);
            } else if (rVar.c == -1) {
                this.f605a.a(this, new Throwable("IOException"));
            }
        } finally {
            b(this.d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(m... mVarArr) {
        if (this.f605a != null) {
            this.f605a.a(this, mVarArr[0]);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.f605a != null) {
            this.f605a.b(this);
        }
        b(this.d);
        this.i = true;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
    }
}
