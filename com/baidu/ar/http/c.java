package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes3.dex */
class c implements l {
    private Object mLock;

    /* renamed from: pl  reason: collision with root package name */
    private com.baidu.ar.ihttp.a f977pl;
    private volatile boolean pn;
    private g pq;
    private HttpURLConnection pr;
    private i ps;
    private IProgressCallback pt;

    public c(g gVar) {
        this(gVar, null);
    }

    public c(g gVar, com.baidu.ar.ihttp.a aVar) {
        this.mLock = new Object();
        this.pn = false;
        this.pq = gVar;
        this.f977pl = aVar;
        this.pr = null;
        this.ps = null;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.pn) {
            return;
        }
        this.f977pl = null;
        this.pt = null;
        synchronized (this.mLock) {
            this.pn = true;
        }
    }

    @Override // com.baidu.ar.http.l
    public i di() {
        return this.ps;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0084 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:57:0x00fe, B:19:0x0075, B:21:0x0079, B:22:0x007e, B:23:0x0083), top: B:77:0x000c }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i dk() {
        OutputStream outputStream;
        InputStream[] inputStreamArr = null;
        ?? r1 = this.mLock;
        synchronized (r1) {
            if (this.pn) {
                return null;
            }
            try {
                try {
                    this.pr = (HttpURLConnection) this.pq.url.openConnection();
                    this.pr.setConnectTimeout(this.pq.pI.pM);
                    this.pr.setReadTimeout(this.pq.pI.pN);
                    this.pr.setUseCaches(this.pq.pI.pO);
                    this.pr.setRequestMethod(this.pq.method);
                    if (this.pq.pJ != null) {
                        for (Map.Entry<String, String> entry : this.pq.pJ.entrySet()) {
                            this.pr.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.pq.method) || this.pq.pK == null) {
                        outputStream = null;
                    } else {
                        int size = this.pq.pK.getSize();
                        InputStream[] dj = this.pq.pK.dj();
                        if (dj != null) {
                            try {
                                if (dj.length > 0) {
                                    this.pr.setDoOutput(true);
                                    OutputStream outputStream2 = this.pr.getOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        for (InputStream inputStream : dj) {
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read != -1) {
                                                    outputStream2.write(bArr, 0, read);
                                                    if (this.pt != null) {
                                                        i += read;
                                                        this.pt.onProgress(i, size);
                                                    }
                                                }
                                            }
                                        }
                                        outputStream2.flush();
                                        outputStream = outputStream2;
                                        inputStreamArr = dj;
                                    } catch (IOException e) {
                                        e = e;
                                        if (this.pr != null) {
                                        }
                                        throw new HttpException(e);
                                    } catch (Throwable th) {
                                        th = th;
                                        r1 = outputStream2;
                                        inputStreamArr = dj;
                                        if (r1 != 0) {
                                            j.closeQuietly(r1);
                                        }
                                        if (inputStreamArr != null) {
                                            for (InputStream inputStream2 : inputStreamArr) {
                                                j.closeQuietly(inputStream2);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } catch (IOException e2) {
                                e = e2;
                            } catch (Throwable th2) {
                                th = th2;
                                r1 = 0;
                                inputStreamArr = dj;
                            }
                        }
                        outputStream = null;
                        inputStreamArr = dj;
                    }
                    try {
                        this.ps = new i(this.pr, this.pq.pH);
                        i iVar = this.ps;
                        if (outputStream != null) {
                            j.closeQuietly(outputStream);
                        }
                        if (inputStreamArr != null) {
                            for (InputStream inputStream3 : inputStreamArr) {
                                j.closeQuietly(inputStream3);
                            }
                            return iVar;
                        }
                        return iVar;
                    } catch (IOException e3) {
                        e = e3;
                        if (this.pr != null) {
                            this.pr.disconnect();
                        }
                        throw new HttpException(e);
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                    r1 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                i dk = dk();
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                boolean z = this.pn;
                                if (!z && this.f977pl != null) {
                                    this.f977pl.a(dk);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (HttpException e) {
                        e = e;
                        if (0 == 0 && 0 == 0 && this.f977pl != null) {
                            this.f977pl.a(e);
                        }
                        if (this.pr != null) {
                            this.pr.disconnect();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (HttpException e2) {
                e = e2;
            }
        } finally {
            if (this.pr != null) {
                this.pr.disconnect();
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.pt = iProgressCallback;
    }
}
