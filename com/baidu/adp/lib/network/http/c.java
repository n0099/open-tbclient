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
    public static boolean Mt = true;
    private e Jt;
    private b MA;
    private int MC = 0;
    private long Mn = 0;
    private boolean MD = true;

    public c(e eVar) {
        this.Jt = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=21, 240=11, 241=11, 242=11, 244=11, 245=11, 246=11, 247=11, 249=9] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x09ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Throwable th;
        boolean z3;
        a ml;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.MA = new b(this.Jt);
        this.MA.af(Mt);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.Jt.my().mNetErrorCode = -1;
            this.MA.ar(i5);
            try {
                dVar.retry = i5 + 1;
                this.MC = i5;
                at(i5);
                z3 = this.MA.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.Jt.my().Nj) {
                            this.Jt.my().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml2 = a.ml();
                        if (ml2 != null) {
                            ml2.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.Jt.my().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml3 = a.ml();
                        if (ml3 != null) {
                            ml3.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml4 = a.ml();
                        if (ml4 != null) {
                            ml4.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml5 = a.ml();
                        if (ml5 != null) {
                            ml5.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml6 = a.ml();
                        if (ml6 != null) {
                            ml6.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml7 = a.ml();
                        if (ml7 != null) {
                            ml7.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.Jt.mx().mE() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.Jt.my().mNetErrorCode = -20;
                        } else {
                            String bR = com.baidu.adp.lib.network.http.a.d.bR(this.Jt.mx().getUrl());
                            if (!k.isEmpty(bR)) {
                                this.Jt.mx().setUrl(bR);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml8 = a.ml();
                        if (ml8 != null) {
                            ml8.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Jt.my().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        a ml9 = a.ml();
                        if (ml9 != null) {
                            ml9.a(this.Jt);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.Jt.my().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.Jt.a(dVar);
                            a ml10 = a.ml();
                            if (ml10 != null) {
                                ml10.a(this.Jt);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.Jt.a(dVar);
                            ml = a.ml();
                            if (ml != null) {
                                ml.a(this.Jt);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Jt.a(dVar);
                        ml = a.ml();
                        if (ml != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mN();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.Jt.a(dVar);
                a ml11 = a.ml();
                if (ml11 != null) {
                    ml11.a(this.Jt);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [342=7, 343=7, 345=7, 346=14, 347=7, 348=7, 349=7, 350=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.Jt.my().Nj && z && i4 < i; i4++) {
            d dVar = new d();
            this.Jt.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.MC = i4;
                                dVar.retry = i4 + 1;
                                dVar.MT = 1;
                                at(i4);
                                this.MA = new b(this.Jt);
                                this.MA.ar(i4);
                                this.MA.af(Mt);
                                this.MA.a(i2, i3, dVar);
                            } catch (IOException e) {
                                this.Jt.my().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Mn <= 0 && this.MA != null) {
                                    this.Mn = this.MA.mo();
                                }
                                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                                this.Jt.b(dVar);
                                a ml = a.ml();
                                if (ml != null) {
                                    ml.a(this.Jt);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.Jt.my().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Mn <= 0 && this.MA != null) {
                                this.Mn = this.MA.mo();
                            }
                            dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                            this.Jt.b(dVar);
                            a ml2 = a.ml();
                            if (ml2 != null) {
                                ml2.a(this.Jt);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Jt.my().mNetErrorCode = -12;
                        if (this.Mn <= 0 && this.MA != null) {
                            this.Mn = this.MA.mo();
                        }
                        dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        this.Jt.b(dVar);
                        a ml3 = a.ml();
                        if (ml3 != null) {
                            ml3.a(this.Jt);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.Jt.my().mNetErrorCode = -13;
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.b(dVar);
                    a ml4 = a.ml();
                    if (ml4 != null) {
                        ml4.a(this.Jt);
                    }
                    z = true;
                }
                if (this.Jt.my().responseCode == 200) {
                    this.Jt.b(dVar);
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.b(dVar);
                    a ml5 = a.ml();
                    if (ml5 != null) {
                        ml5.a(this.Jt);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.Jt.my().responseCode);
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.b(dVar);
                a ml6 = a.ml();
                if (ml6 != null) {
                    ml6.a(this.Jt);
                }
                z = as;
            } catch (Throwable th) {
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.b(dVar);
                a ml7 = a.ml();
                if (ml7 != null) {
                    ml7.a(this.Jt);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a ml;
        b bVar;
        boolean mr;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.Jt.my().Nj && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.MC = i4;
            at(i4);
            try {
                try {
                    try {
                        this.MA = new b(this.Jt);
                        this.MA.ar(i4);
                        this.MA.af(Mt);
                        this.MA.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.Jt.my().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.Jt.a(dVar);
                        if (this.Mn <= 0 && this.MA != null) {
                            this.Mn = this.MA.mo();
                        }
                        dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        this.Jt.a(dVar);
                        a ml2 = a.ml();
                        if (ml2 != null && this.MA != null && this.MA.mr()) {
                            ml2.a(this.Jt);
                        }
                    }
                } catch (SocketException e2) {
                    this.Jt.my().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.Jt.a(dVar);
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.a(dVar);
                    a ml3 = a.ml();
                    if (ml3 != null && this.MA != null && this.MA.mr()) {
                        ml3.a(this.Jt);
                    }
                } catch (SocketTimeoutException e3) {
                    this.Jt.my().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.Jt.a(dVar);
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.a(dVar);
                    a ml4 = a.ml();
                    if (ml4 != null && this.MA != null && this.MA.mr()) {
                        ml4.a(this.Jt);
                    }
                }
                if (this.Jt.my().responseCode == 200) {
                    if (ml != null) {
                        if (bVar != null) {
                            if (mr) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4;
                z = as(this.Jt.my().responseCode);
                this.Jt.a(dVar);
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.a(dVar);
                a ml5 = a.ml();
                if (ml5 != null && this.MA != null && this.MA.mr()) {
                    ml5.a(this.Jt);
                }
                z2 = z;
            } finally {
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.a(dVar);
                ml = a.ml();
                if (ml != null && this.MA != null && this.MA.mr()) {
                    ml.a(this.Jt);
                }
            }
        }
    }

    private boolean as(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.Jt.mx().mB()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [548=7, 549=7, 551=7, 552=14, 553=7, 554=7, 555=7, 556=7, 558=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lD().lG().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lD().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lD().lE().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.Jt.my().Nj && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.MC = i4;
            dVar.retry = i4 + 1;
            at(i4);
            try {
                try {
                    try {
                        this.MA = new b(this.Jt);
                        this.MA.ar(i4);
                        this.MA.af(Mt);
                        this.MA.ag(this.MD);
                        this.MA.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.Jt.my().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.Jt.a(dVar);
                        if (this.Mn <= 0 && this.MA != null) {
                            this.Mn = this.MA.mo();
                        }
                        dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        this.Jt.a(dVar);
                        a ml = a.ml();
                        if (ml != null) {
                            ml.a(this.Jt);
                        }
                    } catch (Throwable th) {
                        this.Jt.my().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.Jt.a(dVar);
                        if (this.Mn <= 0 && this.MA != null) {
                            this.Mn = this.MA.mo();
                        }
                        dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                        this.Jt.a(dVar);
                        a ml2 = a.ml();
                        if (ml2 != null) {
                            ml2.a(this.Jt);
                        }
                    }
                } catch (SocketException e2) {
                    this.Jt.my().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.Jt.a(dVar);
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.a(dVar);
                    a ml3 = a.ml();
                    if (ml3 != null) {
                        ml3.a(this.Jt);
                    }
                } catch (SocketTimeoutException e3) {
                    this.Jt.my().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.Jt.a(dVar);
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.a(dVar);
                    a ml4 = a.ml();
                    if (ml4 != null) {
                        ml4.a(this.Jt);
                    }
                }
                if (this.Jt.my().responseCode == 200) {
                    if (this.Mn <= 0 && this.MA != null) {
                        this.Mn = this.MA.mo();
                    }
                    dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                    this.Jt.a(dVar);
                    a ml5 = a.ml();
                    if (ml5 != null) {
                        ml5.a(this.Jt);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Jt.my().responseCode) + "|retryCount:" + i4;
                z = as(this.Jt.my().responseCode);
                this.Jt.a(dVar);
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.a(dVar);
                a ml6 = a.ml();
                if (ml6 != null) {
                    ml6.a(this.Jt);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Mn <= 0 && this.MA != null) {
                    this.Mn = this.MA.mo();
                }
                dVar.MG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mc().a(this.Jt.mx().getUrl(), this.Jt.mx().bM("Host"), TextUtils.isEmpty(dVar.exception), dVar.MK != null);
                this.Jt.a(dVar);
                a ml7 = a.ml();
                if (ml7 != null) {
                    ml7.a(this.Jt);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.MA != null) {
            this.MA.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.Jt == null) {
            return false;
        }
        return this.Jt.my().Nj;
    }

    public void setCancel() {
        if (this.Jt != null) {
            this.Jt.my().Nj = true;
        }
    }

    public void ah(boolean z) {
        this.MD = z;
    }

    public long ms() {
        if (this.Mn > 0) {
            return this.Mn;
        }
        if (this.MA == null) {
            return -1L;
        }
        return this.MA.mo();
    }

    public long mt() {
        if (this.MA == null) {
            return -1L;
        }
        return this.MA.mp();
    }

    public long mq() {
        if (this.MA == null) {
            return -1L;
        }
        return this.MA.mq();
    }

    public long mu() {
        if (this.MA == null) {
            return -1L;
        }
        return this.MA.mn();
    }

    public long mv() {
        if (this.MA == null) {
            return -1L;
        }
        return this.MA.mm();
    }

    public int mw() {
        return this.MC;
    }

    private void at(int i) {
        try {
            if (this.Jt != null && i > 0) {
                this.Jt.mx().u("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
