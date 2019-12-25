package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes.dex */
public class c {
    public static boolean qH = true;
    private f nE;
    private b qL;
    private int qM = 0;
    private long qB = 0;

    public c(f fVar) {
        this.nE = fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=21, 240=11, 241=11, 242=11, 244=11, 245=11, 246=11, 247=11, 248=11] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0a6c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        Throwable th;
        a fL;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.qL = new b(this.nE);
        this.qL.H(qH);
        String url = this.nE.fY().getUrl();
        int i5 = 0;
        String str2 = null;
        while (i5 < i) {
            d dVar = new d();
            this.nE.fZ().mNetErrorCode = -1;
            try {
                dVar.retry = i5 + 1;
                this.qM = i5;
                M(i5);
                z3 = this.qL.a(str, iVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.nE.fZ().ro) {
                            this.nE.fZ().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null) {
                            fL2.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.nE.fZ().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL3 = a.fL();
                        if (fL3 != null) {
                            fL3.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL4 = a.fL();
                        if (fL4 != null) {
                            fL4.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL5 = a.fL();
                        if (fL5 != null) {
                            fL5.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL6 = a.fL();
                        if (fL6 != null) {
                            fL6.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL7 = a.fL();
                        if (fL7 != null) {
                            fL7.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.nE.fY().gg() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.nE.fZ().mNetErrorCode = -20;
                        } else {
                            String at = com.baidu.adp.lib.network.http.a.d.at(this.nE.fY().getUrl());
                            if (!k.isEmpty(at)) {
                                this.nE.fY().setUrl(at);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL8 = a.fL();
                        if (fL8 != null) {
                            fL8.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nE.fZ().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        str2 = dVar.qT;
                        this.nE.a(dVar);
                        a fL9 = a.fL();
                        if (fL9 != null) {
                            fL9.a(this.nE);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.nE.fZ().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                                dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                            }
                            str2 = dVar.qT;
                            this.nE.a(dVar);
                            a fL10 = a.fL();
                            if (fL10 != null) {
                                fL10.a(this.nE);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                                dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                            }
                            String str3 = dVar.qT;
                            this.nE.a(dVar);
                            fL = a.fL();
                            if (fL != null) {
                                fL.a(this.nE);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                            dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                        }
                        String str32 = dVar.qT;
                        this.nE.a(dVar);
                        fL = a.fL();
                        if (fL != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.go();
                    dVar.exception += "|netAvailable:" + com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately();
                }
                str2 = dVar.qT;
                this.nE.a(dVar);
                a fL11 = a.fL();
                if (fL11 != null) {
                    fL11.a(this.nE);
                }
                if (!z3) {
                    e.fX().l(url, str2);
                }
                return z3;
            } catch (FileNotFoundException e10) {
                e = e10;
                z3 = z4;
            } catch (IllegalStateException e11) {
                e = e11;
                z3 = z4;
            } catch (ConnectException e12) {
                e = e12;
                z3 = z4;
            } catch (SocketException e13) {
                e = e13;
                z3 = z4;
            } catch (SocketTimeoutException e14) {
                e = e14;
                z3 = z4;
            } catch (UnknownHostException e15) {
                e = e15;
                z3 = z4;
            } catch (SSLException e16) {
                e = e16;
                z3 = z4;
            } catch (IOException e17) {
                e = e17;
                z3 = z4;
            } catch (Exception e18) {
                e = e18;
                z3 = z4;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        z3 = z4;
        if (!z3) {
        }
        return z3;
    }

    public boolean a(String str, i iVar, int i, int i2, int i3, boolean z) {
        return a(str, iVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [348=7, 349=7, 351=7, 352=14, 353=7, 354=7, 355=7, 356=7] */
    public void c(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        String url = this.nE.fY().getUrl();
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = 0;
        while (true) {
            if (this.nE.fZ().ro || !z || i4 >= i) {
                break;
            }
            d dVar = new d();
            this.nE.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.qM = i4;
                            dVar.retry = i4 + 1;
                            dVar.qY = 1;
                            M(i4);
                            this.qL = new b(this.nE);
                            this.qL.H(qH);
                            this.qL.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.nE.fZ().mNetErrorCode = -19;
                            dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.qB <= 0 && this.qL != null) {
                                this.qB = this.qL.fO();
                            }
                            dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                            this.nE.b(dVar);
                            a fL = a.fL();
                            if (fL != null) {
                                fL.a(this.nE);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.nE.fZ().mNetErrorCode = -12;
                        if (this.qB <= 0 && this.qL != null) {
                            this.qB = this.qL.fO();
                        }
                        dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        this.nE.b(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null) {
                            fL2.a(this.nE);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.nE.fZ().mNetErrorCode = -13;
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.b(dVar);
                    a fL3 = a.fL();
                    if (fL3 != null) {
                        fL3.a(this.nE);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.nE.fZ().mNetErrorCode = -10;
                    BdLog.e(e4.getMessage());
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.b(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null) {
                        fL4.a(this.nE);
                    }
                }
                if (this.nE.fZ().responseCode != 200) {
                    dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4;
                    boolean L = L(this.nE.fZ().responseCode);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.b(dVar);
                    a fL5 = a.fL();
                    if (fL5 != null) {
                        fL5.a(this.nE);
                    }
                    z = L;
                    i4++;
                } else {
                    this.nE.b(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.b(dVar);
                    a fL6 = a.fL();
                    if (fL6 != null) {
                        fL6.a(this.nE);
                    }
                }
            } catch (Throwable th) {
                if (this.qB <= 0 && this.qL != null) {
                    this.qB = this.qL.fO();
                }
                dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                this.nE.b(dVar);
                a fL7 = a.fL();
                if (fL7 != null) {
                    fL7.a(this.nE);
                }
                throw th;
            }
        }
        if (this.nE.fZ().mNetErrorCode == -1 && this.nE.fZ().responseCode == 200) {
            return;
        }
        e.fX().l(url, null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [434=7, 435=7, 437=7, 438=14, 439=7, 440=7, 441=7, 442=7, 444=5] */
    private void d(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        String url = this.nE.fY().getUrl();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        int i4 = 0;
        while (true) {
            if (this.nE.fZ().ro || !z2 || i4 >= i) {
                break;
            }
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.qM = i4;
            M(i4);
            try {
                try {
                    try {
                        try {
                            this.qL = new b(this.nE);
                            this.qL.H(qH);
                            this.qL.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.nE.fZ().mNetErrorCode = -14;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.nE.a(dVar);
                            if (this.qB <= 0 && this.qL != null) {
                                this.qB = this.qL.fO();
                            }
                            dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                            this.nE.a(dVar);
                            a fL = a.fL();
                            if (fL != null && this.qL != null && this.qL.fR()) {
                                fL.a(this.nE);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.nE.fZ().mNetErrorCode = -13;
                        z = true;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.nE.a(dVar);
                        if (this.qB <= 0 && this.qL != null) {
                            this.qB = this.qL.fO();
                        }
                        dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        this.nE.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null && this.qL != null && this.qL.fR()) {
                            fL2.a(this.nE);
                        }
                    }
                } catch (SocketException e3) {
                    this.nE.fZ().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nE.a(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL3 = a.fL();
                    if (fL3 != null && this.qL != null && this.qL.fR()) {
                        fL3.a(this.nE);
                    }
                }
                if (this.nE.fZ().responseCode != 200) {
                    dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4;
                    z = L(this.nE.fZ().responseCode);
                    this.nE.a(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null && this.qL != null && this.qL.fR()) {
                        fL4.a(this.nE);
                    }
                    z2 = z;
                    i4++;
                }
            } finally {
                if (this.qB <= 0 && this.qL != null) {
                    this.qB = this.qL.fO();
                }
                dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                this.nE.a(dVar);
                a fL5 = a.fL();
                if (fL5 != null && this.qL != null && this.qL.fR()) {
                    fL5.a(this.nE);
                }
            }
        }
        if (this.nE.fZ().mNetErrorCode == -1 && this.nE.fZ().responseCode == 200) {
            return;
        }
        e.fX().l(url, null);
    }

    private boolean L(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.nE.fY().gd()) {
            d(i, i2, i3);
        } else {
            f(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [562=7, 563=7, 565=7, 566=14, 567=7, 568=7, 569=7, 570=7, 572=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        String url = this.nE.fY().getUrl();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        int i4 = 0;
        while (true) {
            if (this.nE.fZ().ro || !z2 || i4 >= i) {
                break;
            }
            d dVar = new d();
            this.qM = i4;
            dVar.retry = i4 + 1;
            M(i4);
            try {
                try {
                    try {
                        try {
                            this.qL = new b(this.nE);
                            this.qL.H(qH);
                            this.qL.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.nE.fZ().mNetErrorCode = -14;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.nE.a(dVar);
                            if (this.qB <= 0 && this.qL != null) {
                                this.qB = this.qL.fO();
                            }
                            dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                            this.nE.a(dVar);
                            a fL = a.fL();
                            if (fL != null) {
                                fL.a(this.nE);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.nE.fZ().mNetErrorCode = -13;
                        z = true;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.nE.a(dVar);
                        if (this.qB <= 0 && this.qL != null) {
                            this.qB = this.qL.fO();
                        }
                        dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                        this.nE.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null) {
                            fL2.a(this.nE);
                        }
                    }
                } catch (SocketException e3) {
                    this.nE.fZ().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nE.a(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL3 = a.fL();
                    if (fL3 != null) {
                        fL3.a(this.nE);
                    }
                } catch (Throwable th) {
                    this.nE.fZ().mNetErrorCode = -10;
                    z = false;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.nE.a(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null) {
                        fL4.a(this.nE);
                    }
                }
                if (this.nE.fZ().responseCode != 200) {
                    dVar.exception = String.valueOf(this.nE.fZ().responseCode) + "|retryCount:" + i4;
                    z = L(this.nE.fZ().responseCode);
                    this.nE.a(dVar);
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL5 = a.fL();
                    if (fL5 != null) {
                        fL5.a(this.nE);
                    }
                    z2 = z;
                    i4++;
                } else {
                    if (this.qB <= 0 && this.qL != null) {
                        this.qB = this.qL.fO();
                    }
                    dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                    this.nE.a(dVar);
                    a fL6 = a.fL();
                    if (fL6 != null) {
                        fL6.a(this.nE);
                    }
                }
            } catch (Throwable th2) {
                if (this.qB <= 0 && this.qL != null) {
                    this.qB = this.qL.fO();
                }
                dVar.qP = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nE.fY().getUrl(), this.nE.fY().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qT != null);
                this.nE.a(dVar);
                a fL7 = a.fL();
                if (fL7 != null) {
                    fL7.a(this.nE);
                }
                throw th2;
            }
        }
        if (this.nE.fZ().mNetErrorCode == -1 && this.nE.fZ().responseCode == 200) {
            return;
        }
        e.fX().l(url, null);
    }

    public void cancel() {
        if (this.qL != null) {
            this.qL.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.nE == null) {
            return false;
        }
        return this.nE.fZ().ro;
    }

    public void setCancel() {
        if (this.nE != null) {
            this.nE.fZ().ro = true;
        }
    }

    public long fS() {
        if (this.qB > 0) {
            return this.qB;
        }
        if (this.qL == null) {
            return -1L;
        }
        return this.qL.fO();
    }

    public long fT() {
        if (this.qL == null) {
            return -1L;
        }
        return this.qL.fP();
    }

    public long fQ() {
        if (this.qL == null) {
            return -1L;
        }
        return this.qL.fQ();
    }

    public long fU() {
        if (this.qL == null) {
            return -1L;
        }
        return this.qL.fN();
    }

    public long fV() {
        if (this.qL == null) {
            return -1L;
        }
        return this.qL.fM();
    }

    public int fW() {
        return this.qM;
    }

    private void M(int i) {
        try {
            if (this.nE != null && i > 0) {
                this.nE.fY().m("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
