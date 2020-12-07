package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes10.dex */
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
    public i eJ() {
        OutputStream outputStream;
        InputStream[] inputStreamArr = null;
        ?? r1 = this.mLock;
        synchronized (r1) {
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
                        outputStream = null;
                    } else {
                        int size = this.qK.re.getSize();
                        InputStream[] eI = this.qK.re.eI();
                        if (eI != null) {
                            try {
                                if (eI.length > 0) {
                                    this.qL.setDoOutput(true);
                                    OutputStream outputStream2 = this.qL.getOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        for (InputStream inputStream : eI) {
                                            while (true) {
                                                int read = inputStream.read(bArr);
                                                if (read != -1) {
                                                    outputStream2.write(bArr, 0, read);
                                                    if (this.qN != null) {
                                                        i += read;
                                                        this.qN.onProgress(i, size);
                                                    }
                                                }
                                            }
                                        }
                                        outputStream2.flush();
                                        outputStream = outputStream2;
                                        inputStreamArr = eI;
                                    } catch (IOException e) {
                                        e = e;
                                        if (this.qL != null) {
                                        }
                                        throw new HttpException(e);
                                    } catch (Throwable th) {
                                        th = th;
                                        r1 = outputStream2;
                                        inputStreamArr = eI;
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
                                inputStreamArr = eI;
                            }
                        }
                        outputStream = null;
                        inputStreamArr = eI;
                    }
                    try {
                        this.qM = new i(this.qL, this.qK.rb);
                        i iVar = this.qM;
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
                        if (this.qL != null) {
                            this.qL.disconnect();
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
                i eJ = eJ();
                try {
                    try {
                        synchronized (this.mLock) {
                            try {
                                boolean z = this.qH;
                                if (!z && this.qF != null) {
                                    this.qF.a(eJ);
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (HttpException e) {
                        e = e;
                        if (0 == 0 && 0 == 0 && this.qF != null) {
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
