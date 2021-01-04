package com.baidu.ar.http;

import android.app.blob.BlobStoreManager;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.live.adp.lib.util.Base64;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes6.dex */
class c implements l {
    private Object mLock;
    private com.baidu.ar.ihttp.a qF;
    private volatile boolean qH;
    private g qK;
    private HttpURLConnection qL;
    private i qM;
    private IProgressCallback qN;

    public c(g gVar) {
        this(gVar, null);
    }

    public c(g gVar, com.baidu.ar.ihttp.a aVar) {
        this.mLock = new Object();
        this.qH = false;
        this.qK = gVar;
        this.qF = aVar;
        this.qL = null;
        this.qM = null;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.qH) {
            return;
        }
        this.qF = null;
        this.qN = null;
        synchronized (this.mLock) {
            this.qH = true;
        }
    }

    @Override // com.baidu.ar.http.l
    public i eH() {
        return this.qM;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0085 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: android.app.blob.BlobStoreManager$Session */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.baidu.live.adp.lib.util.Base64$InputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: all -> 0x0085, TryCatch #2 {all -> 0x0085, blocks: (B:57:0x00fb, B:19:0x0076, B:21:0x007a, B:22:0x007f, B:23:0x0084), top: B:77:0x000c }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.InputStream[]] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i eJ() {
        OutputStream outputStream;
        Closeable[] closeableArr;
        OutputStream outputStream2;
        Object[] objArr = this.mLock;
        synchronized (objArr) {
            if (this.qH) {
                return null;
            }
            try {
                try {
                    this.qL = (HttpURLConnection) this.qK.url.openConnection();
                    this.qL.setConnectTimeout(this.qK.rc.rg);
                    this.qL.setReadTimeout(this.qK.rc.rh);
                    this.qL.setUseCaches(this.qK.rc.ri);
                    this.qL.setRequestMethod(this.qK.method);
                    if (this.qK.rd != null) {
                        for (Map.Entry<String, String> entry : this.qK.rd.entrySet()) {
                            this.qL.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.qK.method) || this.qK.re == null) {
                        closeableArr = null;
                        outputStream2 = null;
                    } else {
                        int size = this.qK.re.getSize();
                        objArr = this.qK.re.eI();
                        if (objArr != 0) {
                            try {
                                if (objArr.length > 0) {
                                    this.qL.setDoOutput(true);
                                    OutputStream outputStream3 = this.qL.getOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        for (Base64.InputStream inputStream : objArr) {
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read != -1) {
                                                    outputStream3.write(bArr, 0, read);
                                                    if (this.qN != null) {
                                                        i += read;
                                                        this.qN.onProgress(i, size);
                                                    }
                                                }
                                            }
                                        }
                                        outputStream3.flush();
                                        outputStream2 = outputStream3;
                                        closeableArr = objArr;
                                    } catch (IOException e) {
                                        e = e;
                                        if (this.qL != null) {
                                        }
                                        throw new HttpException(e);
                                    } catch (Throwable th) {
                                        th = th;
                                        outputStream = outputStream3;
                                        if (outputStream != null) {
                                            j.closeQuietly(outputStream);
                                        }
                                        if (objArr != 0) {
                                            for (BlobStoreManager.Session session : objArr) {
                                                j.closeQuietly(session);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream = null;
                            }
                        }
                        outputStream2 = null;
                        closeableArr = objArr;
                    }
                    try {
                        this.qM = new i(this.qL, this.qK.rb);
                        i iVar = this.qM;
                        if (outputStream2 != null) {
                            j.closeQuietly(outputStream2);
                        }
                        if (closeableArr != null) {
                            for (Closeable closeable : closeableArr) {
                                j.closeQuietly(closeable);
                            }
                            return iVar;
                        }
                        return iVar;
                    } catch (IOException e3) {
                        e = e3;
                        if (this.qL != null) {
                            this.qL.disconnect();
                        }
                        throw new HttpException(e);
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                    objArr = 0;
                    outputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        try {
            try {
                i eJ = eJ();
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                boolean z2 = this.qH;
                                if (!z2 && this.qF != null) {
                                    this.qF.a(eJ);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (HttpException e) {
                        e = e;
                        z = false;
                        if (0 == 0 && !z && this.qF != null) {
                            this.qF.a(e);
                        }
                        if (this.qL != null) {
                            this.qL.disconnect();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (HttpException e2) {
                e = e2;
                z = false;
            }
        } finally {
            if (this.qL != null) {
                this.qL.disconnect();
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.qN = iProgressCallback;
    }
}
