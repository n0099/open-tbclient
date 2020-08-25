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
    public static boolean KW = true;
    private e HX;
    private b Lc;
    private int Ld = 0;
    private long KQ = 0;
    private boolean Le = true;

    public c(e eVar) {
        this.HX = eVar;
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
        a mg;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.Lc = new b(this.HX);
        this.Lc.ai(KW);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.HX.mt().mNetErrorCode = -1;
            this.Lc.al(i5);
            try {
                dVar.retry = i5 + 1;
                this.Ld = i5;
                an(i5);
                z3 = this.Lc.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.HX.mt().LJ) {
                            this.HX.mt().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg2 = a.mg();
                        if (mg2 != null) {
                            mg2.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.HX.mt().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg3 = a.mg();
                        if (mg3 != null) {
                            mg3.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg4 = a.mg();
                        if (mg4 != null) {
                            mg4.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg5 = a.mg();
                        if (mg5 != null) {
                            mg5.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg6 = a.mg();
                        if (mg6 != null) {
                            mg6.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg7 = a.mg();
                        if (mg7 != null) {
                            mg7.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.HX.ms().mz() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.HX.mt().mNetErrorCode = -20;
                        } else {
                            String bM = com.baidu.adp.lib.network.http.a.d.bM(this.HX.ms().getUrl());
                            if (!k.isEmpty(bM)) {
                                this.HX.ms().setUrl(bM);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg8 = a.mg();
                        if (mg8 != null) {
                            mg8.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.HX.mt().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        a mg9 = a.mg();
                        if (mg9 != null) {
                            mg9.a(this.HX);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.HX.mt().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.HX.a(dVar);
                            a mg10 = a.mg();
                            if (mg10 != null) {
                                mg10.a(this.HX);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.HX.a(dVar);
                            mg = a.mg();
                            if (mg != null) {
                                mg.a(this.HX);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.HX.a(dVar);
                        mg = a.mg();
                        if (mg != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mH();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.HX.a(dVar);
                a mg11 = a.mg();
                if (mg11 != null) {
                    mg11.a(this.HX);
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.HX.mt().LJ && z && i4 < i; i4++) {
            d dVar = new d();
            this.HX.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ld = i4;
                                dVar.retry = i4 + 1;
                                dVar.Ls = 1;
                                an(i4);
                                this.Lc = new b(this.HX);
                                this.Lc.al(i4);
                                this.Lc.ai(KW);
                                this.Lc.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.HX.mt().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.KQ <= 0 && this.Lc != null) {
                                    this.KQ = this.Lc.mj();
                                }
                                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                                this.HX.b(dVar);
                                a mg = a.mg();
                                if (mg != null) {
                                    mg.a(this.HX);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.HX.mt().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.KQ <= 0 && this.Lc != null) {
                                this.KQ = this.Lc.mj();
                            }
                            dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                            this.HX.b(dVar);
                            a mg2 = a.mg();
                            if (mg2 != null) {
                                mg2.a(this.HX);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.HX.mt().mNetErrorCode = -12;
                        if (this.KQ <= 0 && this.Lc != null) {
                            this.KQ = this.Lc.mj();
                        }
                        dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        this.HX.b(dVar);
                        a mg3 = a.mg();
                        if (mg3 != null) {
                            mg3.a(this.HX);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.HX.mt().mNetErrorCode = -13;
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.b(dVar);
                    a mg4 = a.mg();
                    if (mg4 != null) {
                        mg4.a(this.HX);
                    }
                    z = true;
                }
                if (this.HX.mt().responseCode == 200) {
                    this.HX.b(dVar);
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.b(dVar);
                    a mg5 = a.mg();
                    if (mg5 != null) {
                        mg5.a(this.HX);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4;
                boolean am = am(this.HX.mt().responseCode);
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.b(dVar);
                a mg6 = a.mg();
                if (mg6 != null) {
                    mg6.a(this.HX);
                }
                z = am;
            } catch (Throwable th) {
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.b(dVar);
                a mg7 = a.mg();
                if (mg7 != null) {
                    mg7.a(this.HX);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a mg;
        b bVar;
        boolean mm;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.HX.mt().LJ && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.Ld = i4;
            an(i4);
            try {
                try {
                    try {
                        this.Lc = new b(this.HX);
                        this.Lc.al(i4);
                        this.Lc.ai(KW);
                        this.Lc.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.HX.mt().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.HX.a(dVar);
                        if (this.KQ <= 0 && this.Lc != null) {
                            this.KQ = this.Lc.mj();
                        }
                        dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        this.HX.a(dVar);
                        a mg2 = a.mg();
                        if (mg2 != null && this.Lc != null && this.Lc.mm()) {
                            mg2.a(this.HX);
                        }
                    }
                } catch (SocketException e2) {
                    this.HX.mt().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.HX.a(dVar);
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.a(dVar);
                    a mg3 = a.mg();
                    if (mg3 != null && this.Lc != null && this.Lc.mm()) {
                        mg3.a(this.HX);
                    }
                } catch (SocketTimeoutException e3) {
                    this.HX.mt().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.HX.a(dVar);
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.a(dVar);
                    a mg4 = a.mg();
                    if (mg4 != null && this.Lc != null && this.Lc.mm()) {
                        mg4.a(this.HX);
                    }
                }
                if (this.HX.mt().responseCode == 200) {
                    if (mg != null) {
                        if (bVar != null) {
                            if (mm) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4;
                z = am(this.HX.mt().responseCode);
                this.HX.a(dVar);
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.a(dVar);
                a mg5 = a.mg();
                if (mg5 != null && this.Lc != null && this.Lc.mm()) {
                    mg5.a(this.HX);
                }
                z2 = z;
            } finally {
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.a(dVar);
                mg = a.mg();
                if (mg != null && this.Lc != null && this.Lc.mm()) {
                    mg.a(this.HX);
                }
            }
        }
    }

    private boolean am(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.HX.ms().mw()) {
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
            i2 = com.baidu.adp.framework.d.b.ly().lB().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.ly().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.ly().lz().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.HX.mt().LJ && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.Ld = i4;
            dVar.retry = i4 + 1;
            an(i4);
            try {
                try {
                    try {
                        this.Lc = new b(this.HX);
                        this.Lc.al(i4);
                        this.Lc.ai(KW);
                        this.Lc.aj(this.Le);
                        this.Lc.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.HX.mt().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.HX.a(dVar);
                        if (this.KQ <= 0 && this.Lc != null) {
                            this.KQ = this.Lc.mj();
                        }
                        dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        this.HX.a(dVar);
                        a mg = a.mg();
                        if (mg != null) {
                            mg.a(this.HX);
                        }
                    } catch (Throwable th) {
                        this.HX.mt().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.HX.a(dVar);
                        if (this.KQ <= 0 && this.Lc != null) {
                            this.KQ = this.Lc.mj();
                        }
                        dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                        this.HX.a(dVar);
                        a mg2 = a.mg();
                        if (mg2 != null) {
                            mg2.a(this.HX);
                        }
                    }
                } catch (SocketException e2) {
                    this.HX.mt().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.HX.a(dVar);
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.a(dVar);
                    a mg3 = a.mg();
                    if (mg3 != null) {
                        mg3.a(this.HX);
                    }
                } catch (SocketTimeoutException e3) {
                    this.HX.mt().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.HX.a(dVar);
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.a(dVar);
                    a mg4 = a.mg();
                    if (mg4 != null) {
                        mg4.a(this.HX);
                    }
                }
                if (this.HX.mt().responseCode == 200) {
                    if (this.KQ <= 0 && this.Lc != null) {
                        this.KQ = this.Lc.mj();
                    }
                    dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                    this.HX.a(dVar);
                    a mg5 = a.mg();
                    if (mg5 != null) {
                        mg5.a(this.HX);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.HX.mt().responseCode) + "|retryCount:" + i4;
                z = am(this.HX.mt().responseCode);
                this.HX.a(dVar);
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.a(dVar);
                a mg6 = a.mg();
                if (mg6 != null) {
                    mg6.a(this.HX);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KQ <= 0 && this.Lc != null) {
                    this.KQ = this.Lc.mj();
                }
                dVar.Lh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lX().a(this.HX.ms().getUrl(), this.HX.ms().bH("Host"), TextUtils.isEmpty(dVar.exception), dVar.Ll != null);
                this.HX.a(dVar);
                a mg7 = a.mg();
                if (mg7 != null) {
                    mg7.a(this.HX);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Lc != null) {
            this.Lc.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.HX == null) {
            return false;
        }
        return this.HX.mt().LJ;
    }

    public void setCancel() {
        if (this.HX != null) {
            this.HX.mt().LJ = true;
        }
    }

    public void ak(boolean z) {
        this.Le = z;
    }

    public long mn() {
        if (this.KQ > 0) {
            return this.KQ;
        }
        if (this.Lc == null) {
            return -1L;
        }
        return this.Lc.mj();
    }

    public long mo() {
        if (this.Lc == null) {
            return -1L;
        }
        return this.Lc.mk();
    }

    public long ml() {
        if (this.Lc == null) {
            return -1L;
        }
        return this.Lc.ml();
    }

    public long mp() {
        if (this.Lc == null) {
            return -1L;
        }
        return this.Lc.mi();
    }

    public long mq() {
        if (this.Lc == null) {
            return -1L;
        }
        return this.Lc.mh();
    }

    public int mr() {
        return this.Ld;
    }

    private void an(int i) {
        try {
            if (this.HX != null && i > 0) {
                this.HX.ms().u("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
