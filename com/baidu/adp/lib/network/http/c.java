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
    public static boolean JF = true;
    private e GM;
    private b JK;
    private int JL = 0;
    private long Jz = 0;

    public c(e eVar) {
        this.GM = eVar;
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
        a kp;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.JK = new b(this.GM);
        this.JK.ag(JF);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.GM.kC().mNetErrorCode = -1;
            this.JK.aa(i5);
            try {
                dVar.retry = i5 + 1;
                this.JL = i5;
                ac(i5);
                z3 = this.JK.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.GM.kC().Kp) {
                            this.GM.kC().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp2 = a.kp();
                        if (kp2 != null) {
                            kp2.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.GM.kC().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp3 = a.kp();
                        if (kp3 != null) {
                            kp3.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp4 = a.kp();
                        if (kp4 != null) {
                            kp4.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp5 = a.kp();
                        if (kp5 != null) {
                            kp5.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp6 = a.kp();
                        if (kp6 != null) {
                            kp6.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp7 = a.kp();
                        if (kp7 != null) {
                            kp7.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.GM.kB().kI() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.GM.kC().mNetErrorCode = -20;
                        } else {
                            String bI = com.baidu.adp.lib.network.http.a.d.bI(this.GM.kB().getUrl());
                            if (!k.isEmpty(bI)) {
                                this.GM.kB().setUrl(bI);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp8 = a.kp();
                        if (kp8 != null) {
                            kp8.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GM.kC().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        a kp9 = a.kp();
                        if (kp9 != null) {
                            kp9.a(this.GM);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.GM.kC().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.GM.a(dVar);
                            a kp10 = a.kp();
                            if (kp10 != null) {
                                kp10.a(this.GM);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.GM.a(dVar);
                            kp = a.kp();
                            if (kp != null) {
                                kp.a(this.GM);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GM.a(dVar);
                        kp = a.kp();
                        if (kp != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kQ();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.GM.a(dVar);
                a kp11 = a.kp();
                if (kp11 != null) {
                    kp11.a(this.GM);
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
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.GM.kC().Kp && z && i4 < i; i4++) {
            d dVar = new d();
            this.GM.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JL = i4;
                                dVar.retry = i4 + 1;
                                dVar.JZ = 1;
                                ac(i4);
                                this.JK = new b(this.GM);
                                this.JK.aa(i4);
                                this.JK.ag(JF);
                                this.JK.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.GM.kC().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Jz <= 0 && this.JK != null) {
                                    this.Jz = this.JK.ks();
                                }
                                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                                this.GM.b(dVar);
                                a kp = a.kp();
                                if (kp != null) {
                                    kp.a(this.GM);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.GM.kC().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Jz <= 0 && this.JK != null) {
                                this.Jz = this.JK.ks();
                            }
                            dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                            this.GM.b(dVar);
                            a kp2 = a.kp();
                            if (kp2 != null) {
                                kp2.a(this.GM);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.GM.kC().mNetErrorCode = -12;
                        if (this.Jz <= 0 && this.JK != null) {
                            this.Jz = this.JK.ks();
                        }
                        dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        this.GM.b(dVar);
                        a kp3 = a.kp();
                        if (kp3 != null) {
                            kp3.a(this.GM);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.GM.kC().mNetErrorCode = -13;
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.b(dVar);
                    a kp4 = a.kp();
                    if (kp4 != null) {
                        kp4.a(this.GM);
                    }
                    z = true;
                }
                if (this.GM.kC().responseCode == 200) {
                    this.GM.b(dVar);
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.b(dVar);
                    a kp5 = a.kp();
                    if (kp5 != null) {
                        kp5.a(this.GM);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.GM.kC().responseCode);
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.b(dVar);
                a kp6 = a.kp();
                if (kp6 != null) {
                    kp6.a(this.GM);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.b(dVar);
                a kp7 = a.kp();
                if (kp7 != null) {
                    kp7.a(this.GM);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [422=7, 423=7, 425=7, 426=14, 427=7, 428=7, 429=7, 430=7, 432=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a kp;
        b bVar;
        boolean kv;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.GM.kC().Kp && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.JL = i4;
            ac(i4);
            try {
                try {
                    try {
                        this.JK = new b(this.GM);
                        this.JK.aa(i4);
                        this.JK.ag(JF);
                        this.JK.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.GM.kC().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.GM.a(dVar);
                        if (this.Jz <= 0 && this.JK != null) {
                            this.Jz = this.JK.ks();
                        }
                        dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        this.GM.a(dVar);
                        a kp2 = a.kp();
                        if (kp2 != null && this.JK != null && this.JK.kv()) {
                            kp2.a(this.GM);
                        }
                    }
                } catch (SocketException e2) {
                    this.GM.kC().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.GM.a(dVar);
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.a(dVar);
                    a kp3 = a.kp();
                    if (kp3 != null && this.JK != null && this.JK.kv()) {
                        kp3.a(this.GM);
                    }
                } catch (SocketTimeoutException e3) {
                    this.GM.kC().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.GM.a(dVar);
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.a(dVar);
                    a kp4 = a.kp();
                    if (kp4 != null && this.JK != null && this.JK.kv()) {
                        kp4.a(this.GM);
                    }
                }
                if (this.GM.kC().responseCode == 200) {
                    if (kp != null) {
                        if (bVar != null) {
                            if (kv) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4;
                z = ab(this.GM.kC().responseCode);
                this.GM.a(dVar);
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.a(dVar);
                a kp5 = a.kp();
                if (kp5 != null && this.JK != null && this.JK.kv()) {
                    kp5.a(this.GM);
                }
                z2 = z;
            } finally {
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.a(dVar);
                kp = a.kp();
                if (kp != null && this.JK != null && this.JK.kv()) {
                    kp.a(this.GM);
                }
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.GM.kB().kF()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [546=7, 547=7, 549=7, 550=14, 551=7, 552=7, 553=7, 554=7, 556=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.jH().jK().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.jH().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.jH().jI().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.GM.kC().Kp && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.JL = i4;
            dVar.retry = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.JK = new b(this.GM);
                            this.JK.aa(i4);
                            this.JK.ag(JF);
                            this.JK.c(i2, i3, dVar);
                        } catch (SocketTimeoutException e) {
                            this.GM.kC().mNetErrorCode = -13;
                            z = true;
                            dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.GM.a(dVar);
                            if (this.Jz <= 0 && this.JK != null) {
                                this.Jz = this.JK.ks();
                            }
                            dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                            this.GM.a(dVar);
                            a kp = a.kp();
                            if (kp != null) {
                                kp.a(this.GM);
                            }
                        }
                    } catch (UnsupportedOperationException e2) {
                        z = false;
                        this.GM.kC().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.GM.a(dVar);
                        if (this.Jz <= 0 && this.JK != null) {
                            this.Jz = this.JK.ks();
                        }
                        dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                        this.GM.a(dVar);
                        a kp2 = a.kp();
                        if (kp2 != null) {
                            kp2.a(this.GM);
                        }
                    }
                } catch (SocketException e3) {
                    this.GM.kC().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.GM.a(dVar);
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.a(dVar);
                    a kp3 = a.kp();
                    if (kp3 != null) {
                        kp3.a(this.GM);
                    }
                } catch (Throwable th) {
                    this.GM.kC().mNetErrorCode = -10;
                    z = false;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.GM.a(dVar);
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.a(dVar);
                    a kp4 = a.kp();
                    if (kp4 != null) {
                        kp4.a(this.GM);
                    }
                }
                if (this.GM.kC().responseCode == 200) {
                    if (this.Jz <= 0 && this.JK != null) {
                        this.Jz = this.JK.ks();
                    }
                    dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                    this.GM.a(dVar);
                    a kp5 = a.kp();
                    if (kp5 != null) {
                        kp5.a(this.GM);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GM.kC().responseCode) + "|retryCount:" + i4;
                z = ab(this.GM.kC().responseCode);
                this.GM.a(dVar);
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.a(dVar);
                a kp6 = a.kp();
                if (kp6 != null) {
                    kp6.a(this.GM);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Jz <= 0 && this.JK != null) {
                    this.Jz = this.JK.ks();
                }
                dVar.JO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.kg().a(this.GM.kB().getUrl(), this.GM.kB().bA("Host"), TextUtils.isEmpty(dVar.exception), dVar.JS != null);
                this.GM.a(dVar);
                a kp7 = a.kp();
                if (kp7 != null) {
                    kp7.a(this.GM);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.JK != null) {
            this.JK.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.GM == null) {
            return false;
        }
        return this.GM.kC().Kp;
    }

    public void setCancel() {
        if (this.GM != null) {
            this.GM.kC().Kp = true;
        }
    }

    public long kw() {
        if (this.Jz > 0) {
            return this.Jz;
        }
        if (this.JK == null) {
            return -1L;
        }
        return this.JK.ks();
    }

    public long kx() {
        if (this.JK == null) {
            return -1L;
        }
        return this.JK.kt();
    }

    public long ku() {
        if (this.JK == null) {
            return -1L;
        }
        return this.JK.ku();
    }

    public long ky() {
        if (this.JK == null) {
            return -1L;
        }
        return this.JK.kr();
    }

    public long kz() {
        if (this.JK == null) {
            return -1L;
        }
        return this.JK.kq();
    }

    public int kA() {
        return this.JL;
    }

    private void ac(int i) {
        try {
            if (this.GM != null && i > 0) {
                this.GM.kB().s("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
