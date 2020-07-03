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
    private com.baidu.ar.ihttp.a pK;
    private volatile boolean pM;
    private g pP;
    private HttpURLConnection pQ;
    private i pR;
    private IProgressCallback pS;

    public c(g gVar) {
        this(gVar, null);
    }

    public c(g gVar, com.baidu.ar.ihttp.a aVar) {
        this.mLock = new Object();
        this.pM = false;
        this.pP = gVar;
        this.pK = aVar;
        this.pQ = null;
        this.pR = null;
    }

    @Override // com.baidu.ar.http.l
    public void cancel() {
        if (this.pM) {
            return;
        }
        this.pK = null;
        this.pS = null;
        synchronized (this.mLock) {
            this.pM = true;
        }
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
    public i dA() {
        OutputStream outputStream;
        InputStream[] inputStreamArr = null;
        ?? r1 = this.mLock;
        synchronized (r1) {
            if (this.pM) {
                return null;
            }
            try {
                try {
                    this.pQ = (HttpURLConnection) this.pP.url.openConnection();
                    this.pQ.setConnectTimeout(this.pP.qh.ql);
                    this.pQ.setReadTimeout(this.pP.qh.qm);
                    this.pQ.setUseCaches(this.pP.qh.qn);
                    this.pQ.setRequestMethod(this.pP.method);
                    if (this.pP.qi != null) {
                        for (Map.Entry<String, String> entry : this.pP.qi.entrySet()) {
                            this.pQ.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.pP.method) || this.pP.qj == null) {
                        outputStream = null;
                    } else {
                        int size = this.pP.qj.getSize();
                        InputStream[] dz = this.pP.qj.dz();
                        if (dz != null) {
                            try {
                                if (dz.length > 0) {
                                    this.pQ.setDoOutput(true);
                                    OutputStream outputStream2 = this.pQ.getOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        for (InputStream inputStream : dz) {
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read != -1) {
                                                    outputStream2.write(bArr, 0, read);
                                                    if (this.pS != null) {
                                                        i += read;
                                                        this.pS.onProgress(i, size);
                                                    }
                                                }
                                            }
                                        }
                                        outputStream2.flush();
                                        outputStream = outputStream2;
                                        inputStreamArr = dz;
                                    } catch (IOException e) {
                                        e = e;
                                        if (this.pQ != null) {
                                        }
                                        throw new HttpException(e);
                                    } catch (Throwable th) {
                                        th = th;
                                        r1 = outputStream2;
                                        inputStreamArr = dz;
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
                                inputStreamArr = dz;
                            }
                        }
                        outputStream = null;
                        inputStreamArr = dz;
                    }
                    try {
                        this.pR = new i(this.pQ, this.pP.qg);
                        i iVar = this.pR;
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
                        if (this.pQ != null) {
                            this.pQ.disconnect();
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

    @Override // com.baidu.ar.http.l
    public i dy() {
        return this.pR;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, INVOKE, IF] complete} */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                i dA = dA();
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                boolean z = this.pM;
                                if (!z && this.pK != null) {
                                    this.pK.a(dA);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (HttpException e) {
                        e = e;
                        if (0 == 0 && 0 == 0 && this.pK != null) {
                            this.pK.a(e);
                        }
                        if (this.pQ != null) {
                            this.pQ.disconnect();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (HttpException e2) {
                e = e2;
            }
        } finally {
            if (this.pQ != null) {
                this.pQ.disconnect();
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.pS = iProgressCallback;
    }
}
