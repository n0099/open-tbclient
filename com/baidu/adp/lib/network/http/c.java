package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
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
    public static boolean qE = true;
    private e nB;
    private b qJ;
    private int qK = 0;
    private long qy = 0;

    public c(e eVar) {
        this.nB = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [237=21, 239=11, 240=11, 241=11, 243=11, 244=11, 245=11, 246=11, 248=9] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x09ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Throwable th;
        boolean z3;
        a fL;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.qJ = new b(this.nB);
        this.qJ.H(qE);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.nB.fY().mNetErrorCode = -1;
            this.qJ.L(i5);
            try {
                dVar.retry = i5 + 1;
                this.qK = i5;
                N(i5);
                z3 = this.qJ.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.nB.fY().ro) {
                            this.nB.fY().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null) {
                            fL2.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.nB.fY().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL3 = a.fL();
                        if (fL3 != null) {
                            fL3.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL4 = a.fL();
                        if (fL4 != null) {
                            fL4.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL5 = a.fL();
                        if (fL5 != null) {
                            fL5.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL6 = a.fL();
                        if (fL6 != null) {
                            fL6.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL7 = a.fL();
                        if (fL7 != null) {
                            fL7.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.nB.fX().gf() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.nB.fY().mNetErrorCode = -20;
                        } else {
                            String at = com.baidu.adp.lib.network.http.a.d.at(this.nB.fX().getUrl());
                            if (!k.isEmpty(at)) {
                                this.nB.fX().setUrl(at);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL8 = a.fL();
                        if (fL8 != null) {
                            fL8.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.nB.fY().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        a fL9 = a.fL();
                        if (fL9 != null) {
                            fL9.a(this.nB);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.nB.fY().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.nB.a(dVar);
                            a fL10 = a.fL();
                            if (fL10 != null) {
                                fL10.a(this.nB);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.nB.a(dVar);
                            fL = a.fL();
                            if (fL != null) {
                                fL.a(this.nB);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.nB.a(dVar);
                        fL = a.fL();
                        if (fL != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.gn();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.nB.a(dVar);
                a fL11 = a.fL();
                if (fL11 != null) {
                    fL11.a(this.nB);
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
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=7, 342=7, 344=7, 345=14, 346=7, 347=7, 348=7, 349=7] */
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
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.nB.fY().ro && z && i4 < i; i4++) {
            d dVar = new d();
            this.nB.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.qK = i4;
                                dVar.retry = i4 + 1;
                                dVar.qX = 1;
                                N(i4);
                                this.qJ = new b(this.nB);
                                this.qJ.L(i4);
                                this.qJ.H(qE);
                                this.qJ.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.nB.fY().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.qy <= 0 && this.qJ != null) {
                                    this.qy = this.qJ.fO();
                                }
                                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                                this.nB.b(dVar);
                                a fL = a.fL();
                                if (fL != null) {
                                    fL.a(this.nB);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.nB.fY().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.qy <= 0 && this.qJ != null) {
                                this.qy = this.qJ.fO();
                            }
                            dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                            this.nB.b(dVar);
                            a fL2 = a.fL();
                            if (fL2 != null) {
                                fL2.a(this.nB);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.nB.fY().mNetErrorCode = -12;
                        if (this.qy <= 0 && this.qJ != null) {
                            this.qy = this.qJ.fO();
                        }
                        dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        this.nB.b(dVar);
                        a fL3 = a.fL();
                        if (fL3 != null) {
                            fL3.a(this.nB);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.nB.fY().mNetErrorCode = -13;
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.b(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null) {
                        fL4.a(this.nB);
                    }
                    z = true;
                }
                if (this.nB.fY().responseCode == 200) {
                    this.nB.b(dVar);
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.b(dVar);
                    a fL5 = a.fL();
                    if (fL5 != null) {
                        fL5.a(this.nB);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4;
                boolean M = M(this.nB.fY().responseCode);
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.b(dVar);
                a fL6 = a.fL();
                if (fL6 != null) {
                    fL6.a(this.nB);
                }
                z = M;
            } catch (Throwable th) {
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.b(dVar);
                a fL7 = a.fL();
                if (fL7 != null) {
                    fL7.a(this.nB);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [422=7, 423=7, 425=7, 426=14, 427=7, 428=7, 429=7, 430=7, 432=5] */
    private void d(int i, int i2, int i3) {
        boolean z;
        a fL;
        b bVar;
        boolean fR;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fb().fe().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fb().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fb().fc().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nB.fY().ro && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.qK = i4;
            N(i4);
            try {
                try {
                    try {
                        this.qJ = new b(this.nB);
                        this.qJ.L(i4);
                        this.qJ.H(qE);
                        this.qJ.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.nB.fY().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.nB.a(dVar);
                        if (this.qy <= 0 && this.qJ != null) {
                            this.qy = this.qJ.fO();
                        }
                        dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        this.nB.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null && this.qJ != null && this.qJ.fR()) {
                            fL2.a(this.nB);
                        }
                    }
                } catch (SocketException e2) {
                    this.nB.fY().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.nB.a(dVar);
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.a(dVar);
                    a fL3 = a.fL();
                    if (fL3 != null && this.qJ != null && this.qJ.fR()) {
                        fL3.a(this.nB);
                    }
                } catch (SocketTimeoutException e3) {
                    this.nB.fY().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nB.a(dVar);
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.a(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null && this.qJ != null && this.qJ.fR()) {
                        fL4.a(this.nB);
                    }
                }
                if (this.nB.fY().responseCode == 200) {
                    if (fL != null) {
                        if (bVar != null) {
                            if (fR) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4;
                z = M(this.nB.fY().responseCode);
                this.nB.a(dVar);
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.a(dVar);
                a fL5 = a.fL();
                if (fL5 != null && this.qJ != null && this.qJ.fR()) {
                    fL5.a(this.nB);
                }
                z2 = z;
            } finally {
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.a(dVar);
                fL = a.fL();
                if (fL != null && this.qJ != null && this.qJ.fR()) {
                    fL.a(this.nB);
                }
            }
        }
    }

    private boolean M(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void e(int i, int i2, int i3) {
        if (this.nB.fX().gb()) {
            d(i, i2, i3);
        } else {
            f(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [546=7, 547=7, 549=7, 550=14, 551=7, 552=7, 553=7, 554=7, 556=5] */
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
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nB.fY().ro && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.qK = i4;
            dVar.retry = i4 + 1;
            N(i4);
            try {
                try {
                    try {
                        try {
                            this.qJ = new b(this.nB);
                            this.qJ.L(i4);
                            this.qJ.H(qE);
                            this.qJ.c(i2, i3, dVar);
                        } catch (SocketTimeoutException e) {
                            this.nB.fY().mNetErrorCode = -13;
                            z = true;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.nB.a(dVar);
                            if (this.qy <= 0 && this.qJ != null) {
                                this.qy = this.qJ.fO();
                            }
                            dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                            this.nB.a(dVar);
                            a fL = a.fL();
                            if (fL != null) {
                                fL.a(this.nB);
                            }
                        }
                    } catch (UnsupportedOperationException e2) {
                        z = false;
                        this.nB.fY().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.nB.a(dVar);
                        if (this.qy <= 0 && this.qJ != null) {
                            this.qy = this.qJ.fO();
                        }
                        dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                        this.nB.a(dVar);
                        a fL2 = a.fL();
                        if (fL2 != null) {
                            fL2.a(this.nB);
                        }
                    }
                } catch (SocketException e3) {
                    this.nB.fY().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nB.a(dVar);
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.a(dVar);
                    a fL3 = a.fL();
                    if (fL3 != null) {
                        fL3.a(this.nB);
                    }
                } catch (Throwable th) {
                    this.nB.fY().mNetErrorCode = -10;
                    z = false;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.nB.a(dVar);
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.a(dVar);
                    a fL4 = a.fL();
                    if (fL4 != null) {
                        fL4.a(this.nB);
                    }
                }
                if (this.nB.fY().responseCode == 200) {
                    if (this.qy <= 0 && this.qJ != null) {
                        this.qy = this.qJ.fO();
                    }
                    dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                    this.nB.a(dVar);
                    a fL5 = a.fL();
                    if (fL5 != null) {
                        fL5.a(this.nB);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.nB.fY().responseCode) + "|retryCount:" + i4;
                z = M(this.nB.fY().responseCode);
                this.nB.a(dVar);
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.a(dVar);
                a fL6 = a.fL();
                if (fL6 != null) {
                    fL6.a(this.nB);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.qy <= 0 && this.qJ != null) {
                    this.qy = this.qJ.fO();
                }
                dVar.qN = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.fC().a(this.nB.fX().getUrl(), this.nB.fX().al("Host"), TextUtils.isEmpty(dVar.exception), dVar.qR != null);
                this.nB.a(dVar);
                a fL7 = a.fL();
                if (fL7 != null) {
                    fL7.a(this.nB);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.qJ != null) {
            this.qJ.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.nB == null) {
            return false;
        }
        return this.nB.fY().ro;
    }

    public void setCancel() {
        if (this.nB != null) {
            this.nB.fY().ro = true;
        }
    }

    public long fS() {
        if (this.qy > 0) {
            return this.qy;
        }
        if (this.qJ == null) {
            return -1L;
        }
        return this.qJ.fO();
    }

    public long fT() {
        if (this.qJ == null) {
            return -1L;
        }
        return this.qJ.fP();
    }

    public long fQ() {
        if (this.qJ == null) {
            return -1L;
        }
        return this.qJ.fQ();
    }

    public long fU() {
        if (this.qJ == null) {
            return -1L;
        }
        return this.qJ.fN();
    }

    public long fV() {
        if (this.qJ == null) {
            return -1L;
        }
        return this.qJ.fM();
    }

    public int fW() {
        return this.qK;
    }

    private void N(int i) {
        try {
            if (this.nB != null && i > 0) {
                this.nB.fX().l("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
