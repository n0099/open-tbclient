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
    public static boolean Lf = true;
    private e If;
    private b Lm;
    private int Ln = 0;
    private long KZ = 0;
    private boolean Lo = true;

    public c(e eVar) {
        this.If = eVar;
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
        a mk;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.Lm = new b(this.If);
        this.Lm.ah(Lf);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.If.mx().mNetErrorCode = -1;
            this.Lm.ao(i5);
            try {
                dVar.retry = i5 + 1;
                this.Ln = i5;
                aq(i5);
                z3 = this.Lm.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.If.mx().LX) {
                            this.If.mx().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk2 = a.mk();
                        if (mk2 != null) {
                            mk2.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.If.mx().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk3 = a.mk();
                        if (mk3 != null) {
                            mk3.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk4 = a.mk();
                        if (mk4 != null) {
                            mk4.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk5 = a.mk();
                        if (mk5 != null) {
                            mk5.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk6 = a.mk();
                        if (mk6 != null) {
                            mk6.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk7 = a.mk();
                        if (mk7 != null) {
                            mk7.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.If.mw().mD() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.If.mx().mNetErrorCode = -20;
                        } else {
                            String bO = com.baidu.adp.lib.network.http.a.d.bO(this.If.mw().getUrl());
                            if (!k.isEmpty(bO)) {
                                this.If.mw().setUrl(bO);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk8 = a.mk();
                        if (mk8 != null) {
                            mk8.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.If.mx().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        a mk9 = a.mk();
                        if (mk9 != null) {
                            mk9.a(this.If);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.If.mx().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.If.a(dVar);
                            a mk10 = a.mk();
                            if (mk10 != null) {
                                mk10.a(this.If);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.If.a(dVar);
                            mk = a.mk();
                            if (mk != null) {
                                mk.a(this.If);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.If.a(dVar);
                        mk = a.mk();
                        if (mk != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mM();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.If.a(dVar);
                a mk11 = a.mk();
                if (mk11 != null) {
                    mk11.a(this.If);
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
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.If.mx().LX && z && i4 < i; i4++) {
            d dVar = new d();
            this.If.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Ln = i4;
                                dVar.retry = i4 + 1;
                                dVar.LC = 1;
                                aq(i4);
                                this.Lm = new b(this.If);
                                this.Lm.ao(i4);
                                this.Lm.ah(Lf);
                                this.Lm.a(i2, i3, dVar);
                            } catch (IOException e) {
                                this.If.mx().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.KZ <= 0 && this.Lm != null) {
                                    this.KZ = this.Lm.mn();
                                }
                                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                                this.If.b(dVar);
                                a mk = a.mk();
                                if (mk != null) {
                                    mk.a(this.If);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.If.mx().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.KZ <= 0 && this.Lm != null) {
                                this.KZ = this.Lm.mn();
                            }
                            dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                            this.If.b(dVar);
                            a mk2 = a.mk();
                            if (mk2 != null) {
                                mk2.a(this.If);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.If.mx().mNetErrorCode = -12;
                        if (this.KZ <= 0 && this.Lm != null) {
                            this.KZ = this.Lm.mn();
                        }
                        dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        this.If.b(dVar);
                        a mk3 = a.mk();
                        if (mk3 != null) {
                            mk3.a(this.If);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.If.mx().mNetErrorCode = -13;
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.b(dVar);
                    a mk4 = a.mk();
                    if (mk4 != null) {
                        mk4.a(this.If);
                    }
                    z = true;
                }
                if (this.If.mx().responseCode == 200) {
                    this.If.b(dVar);
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.b(dVar);
                    a mk5 = a.mk();
                    if (mk5 != null) {
                        mk5.a(this.If);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4;
                boolean ap = ap(this.If.mx().responseCode);
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.b(dVar);
                a mk6 = a.mk();
                if (mk6 != null) {
                    mk6.a(this.If);
                }
                z = ap;
            } catch (Throwable th) {
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.b(dVar);
                a mk7 = a.mk();
                if (mk7 != null) {
                    mk7.a(this.If);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a mk;
        b bVar;
        boolean mq;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.If.mx().LX && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.Ln = i4;
            aq(i4);
            try {
                try {
                    try {
                        this.Lm = new b(this.If);
                        this.Lm.ao(i4);
                        this.Lm.ah(Lf);
                        this.Lm.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.If.mx().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.If.a(dVar);
                        if (this.KZ <= 0 && this.Lm != null) {
                            this.KZ = this.Lm.mn();
                        }
                        dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        this.If.a(dVar);
                        a mk2 = a.mk();
                        if (mk2 != null && this.Lm != null && this.Lm.mq()) {
                            mk2.a(this.If);
                        }
                    }
                } catch (SocketException e2) {
                    this.If.mx().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.If.a(dVar);
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.a(dVar);
                    a mk3 = a.mk();
                    if (mk3 != null && this.Lm != null && this.Lm.mq()) {
                        mk3.a(this.If);
                    }
                } catch (SocketTimeoutException e3) {
                    this.If.mx().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.If.a(dVar);
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.a(dVar);
                    a mk4 = a.mk();
                    if (mk4 != null && this.Lm != null && this.Lm.mq()) {
                        mk4.a(this.If);
                    }
                }
                if (this.If.mx().responseCode == 200) {
                    if (mk != null) {
                        if (bVar != null) {
                            if (mq) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4;
                z = ap(this.If.mx().responseCode);
                this.If.a(dVar);
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.a(dVar);
                a mk5 = a.mk();
                if (mk5 != null && this.Lm != null && this.Lm.mq()) {
                    mk5.a(this.If);
                }
                z2 = z;
            } finally {
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.a(dVar);
                mk = a.mk();
                if (mk != null && this.Lm != null && this.Lm.mq()) {
                    mk.a(this.If);
                }
            }
        }
    }

    private boolean ap(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.If.mw().mA()) {
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
            i2 = com.baidu.adp.framework.d.b.lC().lF().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.lC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.lC().lD().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.If.mx().LX && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.Ln = i4;
            dVar.retry = i4 + 1;
            aq(i4);
            try {
                try {
                    try {
                        this.Lm = new b(this.If);
                        this.Lm.ao(i4);
                        this.Lm.ah(Lf);
                        this.Lm.ai(this.Lo);
                        this.Lm.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.If.mx().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.If.a(dVar);
                        if (this.KZ <= 0 && this.Lm != null) {
                            this.KZ = this.Lm.mn();
                        }
                        dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        this.If.a(dVar);
                        a mk = a.mk();
                        if (mk != null) {
                            mk.a(this.If);
                        }
                    } catch (Throwable th) {
                        this.If.mx().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.If.a(dVar);
                        if (this.KZ <= 0 && this.Lm != null) {
                            this.KZ = this.Lm.mn();
                        }
                        dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                        this.If.a(dVar);
                        a mk2 = a.mk();
                        if (mk2 != null) {
                            mk2.a(this.If);
                        }
                    }
                } catch (SocketException e2) {
                    this.If.mx().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.If.a(dVar);
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.a(dVar);
                    a mk3 = a.mk();
                    if (mk3 != null) {
                        mk3.a(this.If);
                    }
                } catch (SocketTimeoutException e3) {
                    this.If.mx().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.If.a(dVar);
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.a(dVar);
                    a mk4 = a.mk();
                    if (mk4 != null) {
                        mk4.a(this.If);
                    }
                }
                if (this.If.mx().responseCode == 200) {
                    if (this.KZ <= 0 && this.Lm != null) {
                        this.KZ = this.Lm.mn();
                    }
                    dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                    this.If.a(dVar);
                    a mk5 = a.mk();
                    if (mk5 != null) {
                        mk5.a(this.If);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.If.mx().responseCode) + "|retryCount:" + i4;
                z = ap(this.If.mx().responseCode);
                this.If.a(dVar);
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.a(dVar);
                a mk6 = a.mk();
                if (mk6 != null) {
                    mk6.a(this.If);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.KZ <= 0 && this.Lm != null) {
                    this.KZ = this.Lm.mn();
                }
                dVar.Lr = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mb().a(this.If.mw().getUrl(), this.If.mw().bJ("Host"), TextUtils.isEmpty(dVar.exception), dVar.Lv != null);
                this.If.a(dVar);
                a mk7 = a.mk();
                if (mk7 != null) {
                    mk7.a(this.If);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Lm != null) {
            this.Lm.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.If == null) {
            return false;
        }
        return this.If.mx().LX;
    }

    public void setCancel() {
        if (this.If != null) {
            this.If.mx().LX = true;
        }
    }

    public void aj(boolean z) {
        this.Lo = z;
    }

    public long mr() {
        if (this.KZ > 0) {
            return this.KZ;
        }
        if (this.Lm == null) {
            return -1L;
        }
        return this.Lm.mn();
    }

    public long ms() {
        if (this.Lm == null) {
            return -1L;
        }
        return this.Lm.mo();
    }

    public long mp() {
        if (this.Lm == null) {
            return -1L;
        }
        return this.Lm.mp();
    }

    public long mt() {
        if (this.Lm == null) {
            return -1L;
        }
        return this.Lm.mm();
    }

    public long mu() {
        if (this.Lm == null) {
            return -1L;
        }
        return this.Lm.ml();
    }

    public int mv() {
        return this.Ln;
    }

    private void aq(int i) {
        try {
            if (this.If != null && i > 0) {
                this.If.mw().u("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
