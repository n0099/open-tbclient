package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes11.dex */
class c implements l {
    private Object mLock;
    private com.baidu.ar.ihttp.a qp;
    private volatile boolean qr;
    private g qu;
    private HttpURLConnection qv;
    private i qw;
    private IProgressCallback qx;

    public c(g gVar) {
        this(gVar, null);
    }

    public c(g gVar, com.baidu.ar.ihttp.a aVar) {
        this.mLock = new Object();
        this.qr = false;
        this.qu = gVar;
        this.qp = aVar;
        this.qv = null;
        this.qw = null;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.qr) {
            return;
        }
        this.qp = null;
        this.qx = null;
        synchronized (this.mLock) {
            this.qr = true;
        }
    }

    @Override // com.baidu.ar.http.l
    public i eI() {
        return this.qw;
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
    public i eK() {
        OutputStream outputStream;
        InputStream[] inputStreamArr = null;
        ?? r1 = this.mLock;
        synchronized (r1) {
            if (this.qr) {
                return null;
            }
            try {
                try {
                    this.qv = (HttpURLConnection) this.qu.url.openConnection();
                    this.qv.setConnectTimeout(this.qu.qM.qQ);
                    this.qv.setReadTimeout(this.qu.qM.qR);
                    this.qv.setUseCaches(this.qu.qM.qS);
                    this.qv.setRequestMethod(this.qu.method);
                    if (this.qu.qN != null) {
                        for (Map.Entry<String, String> entry : this.qu.qN.entrySet()) {
                            this.qv.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.qu.method) || this.qu.qO == null) {
                        outputStream = null;
                    } else {
                        int size = this.qu.qO.getSize();
                        InputStream[] eJ = this.qu.qO.eJ();
                        if (eJ != null) {
                            try {
                                if (eJ.length > 0) {
                                    this.qv.setDoOutput(true);
                                    OutputStream outputStream2 = this.qv.getOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        for (InputStream inputStream : eJ) {
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read != -1) {
                                                    outputStream2.write(bArr, 0, read);
                                                    if (this.qx != null) {
                                                        i += read;
                                                        this.qx.onProgress(i, size);
                                                    }
                                                }
                                            }
                                        }
                                        outputStream2.flush();
                                        outputStream = outputStream2;
                                        inputStreamArr = eJ;
                                    } catch (IOException e) {
                                        e = e;
                                        if (this.qv != null) {
                                        }
                                        throw new HttpException(e);
                                    } catch (Throwable th) {
                                        th = th;
                                        r1 = outputStream2;
                                        inputStreamArr = eJ;
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
                                inputStreamArr = eJ;
                            }
                        }
                        outputStream = null;
                        inputStreamArr = eJ;
                    }
                    try {
                        this.qw = new i(this.qv, this.qu.qL);
                        i iVar = this.qw;
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
                        if (this.qv != null) {
                            this.qv.disconnect();
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
                i eK = eK();
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                boolean z = this.qr;
                                if (!z && this.qp != null) {
                                    this.qp.a(eK);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (HttpException e) {
                        e = e;
                        if (0 == 0 && 0 == 0 && this.qp != null) {
                            this.qp.a(e);
                        }
                        if (this.qv != null) {
                            this.qv.disconnect();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (HttpException e2) {
                e = e2;
            }
        } finally {
            if (this.qv != null) {
                this.qv.disconnect();
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.qx = iProgressCallback;
    }
}
