package com.baidu.ar.http;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements l {
    public Object mLock;
    public com.baidu.ar.ihttp.a qF;
    public volatile boolean qH;
    public g qK;
    public HttpURLConnection qL;
    public i qM;
    public IProgressCallback qN;

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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i eJ() {
        InputStream[] inputStreamArr;
        synchronized (this.mLock) {
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            if (this.qH) {
                return null;
            }
            int i = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) this.qK.url.openConnection();
                    this.qL = httpURLConnection;
                    httpURLConnection.setConnectTimeout(this.qK.rc.rg);
                    this.qL.setReadTimeout(this.qK.rc.rh);
                    this.qL.setUseCaches(this.qK.rc.ri);
                    this.qL.setRequestMethod(this.qK.method);
                    if (this.qK.rd != null) {
                        for (Map.Entry<String, String> entry : this.qK.rd.entrySet()) {
                            this.qL.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    if (!"POST".equals(this.qK.method) || this.qK.re == null) {
                        inputStreamArr = null;
                    } else {
                        int size = this.qK.re.getSize();
                        inputStreamArr = this.qK.re.eI();
                        if (inputStreamArr != null) {
                            try {
                                if (inputStreamArr.length > 0) {
                                    this.qL.setDoOutput(true);
                                    OutputStream outputStream = this.qL.getOutputStream();
                                    byte[] bArr = new byte[1024];
                                    int i2 = 0;
                                    for (InputStream inputStream : inputStreamArr) {
                                        while (true) {
                                            int read = inputStream.read(bArr);
                                            if (read != -1) {
                                                outputStream.write(bArr, 0, read);
                                                if (this.qN != null) {
                                                    i2 += read;
                                                    this.qN.onProgress(i2, size);
                                                }
                                            }
                                        }
                                    }
                                    outputStream.flush();
                                    r2 = outputStream;
                                }
                            } catch (IOException e) {
                                e = e;
                                if (this.qL != null) {
                                    this.qL.disconnect();
                                }
                                throw new HttpException(e);
                            }
                        }
                    }
                    i iVar = new i(this.qL, this.qK.rb);
                    this.qM = iVar;
                    if (r2 != 0) {
                        j.closeQuietly(r2);
                    }
                    if (inputStreamArr != null) {
                        int length = inputStreamArr.length;
                        while (i < length) {
                            j.closeQuietly(inputStreamArr[i]);
                            i++;
                        }
                    }
                    return iVar;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        j.closeQuietly(null);
                    }
                    if (0 != 0) {
                        int length2 = r2.length;
                        while (i < length2) {
                            j.closeQuietly(r2[i]);
                            i++;
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x002a: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:25:0x0029 */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        HttpException httpException;
        HttpURLConnection httpURLConnection;
        boolean z;
        i eJ;
        boolean z2;
        boolean z3 = false;
        try {
            try {
                eJ = eJ();
                try {
                    try {
                    } catch (HttpException e) {
                        httpException = e;
                        z3 = z2;
                        z = false;
                        if (!z3) {
                            this.qF.a(httpException);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } finally {
                httpURLConnection = this.qL;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        } catch (HttpException e2) {
            httpException = e2;
        }
        synchronized (this.mLock) {
            try {
                boolean z4 = this.qH;
                if (!z4 && this.qF != null) {
                    try {
                        this.qF.a(eJ);
                    } catch (HttpException e3) {
                        httpException = e3;
                        z3 = z4;
                        z = true;
                        if (!z3 && !z && this.qF != null) {
                            this.qF.a(httpException);
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                    }
                }
                HttpURLConnection httpURLConnection2 = this.qL;
                if (httpURLConnection2 == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void setProgressCallback(IProgressCallback iProgressCallback) {
        this.qN = iProgressCallback;
    }
}
