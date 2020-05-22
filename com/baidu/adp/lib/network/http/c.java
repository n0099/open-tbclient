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
    public static boolean JS = true;
    private e GQ;
    private b JY;
    private int JZ = 0;
    private long JM = 0;
    private boolean Ka = true;

    public c(e eVar) {
        this.GQ = eVar;
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
        a kr;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.JY = new b(this.GQ);
        this.JY.ag(JS);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.GQ.kE().mNetErrorCode = -1;
            this.JY.ab(i5);
            try {
                dVar.retry = i5 + 1;
                this.JZ = i5;
                ad(i5);
                z3 = this.JY.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.GQ.kE().KE) {
                            this.GQ.kE().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr2 = a.kr();
                        if (kr2 != null) {
                            kr2.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.GQ.kE().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr3 = a.kr();
                        if (kr3 != null) {
                            kr3.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr4 = a.kr();
                        if (kr4 != null) {
                            kr4.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr5 = a.kr();
                        if (kr5 != null) {
                            kr5.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr6 = a.kr();
                        if (kr6 != null) {
                            kr6.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr7 = a.kr();
                        if (kr7 != null) {
                            kr7.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.GQ.kD().kK() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.GQ.kE().mNetErrorCode = -20;
                        } else {
                            String bI = com.baidu.adp.lib.network.http.a.d.bI(this.GQ.kD().getUrl());
                            if (!k.isEmpty(bI)) {
                                this.GQ.kD().setUrl(bI);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr8 = a.kr();
                        if (kr8 != null) {
                            kr8.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.GQ.kE().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        a kr9 = a.kr();
                        if (kr9 != null) {
                            kr9.a(this.GQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.GQ.kE().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.GQ.a(dVar);
                            a kr10 = a.kr();
                            if (kr10 != null) {
                                kr10.a(this.GQ);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.GQ.a(dVar);
                            kr = a.kr();
                            if (kr != null) {
                                kr.a(this.GQ);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.GQ.a(dVar);
                        kr = a.kr();
                        if (kr != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.kS();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.GQ.a(dVar);
                a kr11 = a.kr();
                if (kr11 != null) {
                    kr11.a(this.GQ);
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
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.GQ.kE().KE && z && i4 < i; i4++) {
            d dVar = new d();
            this.GQ.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.JZ = i4;
                                dVar.retry = i4 + 1;
                                dVar.Ko = 1;
                                ad(i4);
                                this.JY = new b(this.GQ);
                                this.JY.ab(i4);
                                this.JY.ag(JS);
                                this.JY.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.GQ.kE().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.JM <= 0 && this.JY != null) {
                                    this.JM = this.JY.ku();
                                }
                                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                                this.GQ.b(dVar);
                                a kr = a.kr();
                                if (kr != null) {
                                    kr.a(this.GQ);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.GQ.kE().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.JM <= 0 && this.JY != null) {
                                this.JM = this.JY.ku();
                            }
                            dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                            this.GQ.b(dVar);
                            a kr2 = a.kr();
                            if (kr2 != null) {
                                kr2.a(this.GQ);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.GQ.kE().mNetErrorCode = -12;
                        if (this.JM <= 0 && this.JY != null) {
                            this.JM = this.JY.ku();
                        }
                        dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        this.GQ.b(dVar);
                        a kr3 = a.kr();
                        if (kr3 != null) {
                            kr3.a(this.GQ);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.GQ.kE().mNetErrorCode = -13;
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.b(dVar);
                    a kr4 = a.kr();
                    if (kr4 != null) {
                        kr4.a(this.GQ);
                    }
                    z = true;
                }
                if (this.GQ.kE().responseCode == 200) {
                    this.GQ.b(dVar);
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.b(dVar);
                    a kr5 = a.kr();
                    if (kr5 != null) {
                        kr5.a(this.GQ);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4;
                boolean ac = ac(this.GQ.kE().responseCode);
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.b(dVar);
                a kr6 = a.kr();
                if (kr6 != null) {
                    kr6.a(this.GQ);
                }
                z = ac;
            } catch (Throwable th) {
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.b(dVar);
                a kr7 = a.kr();
                if (kr7 != null) {
                    kr7.a(this.GQ);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a kr;
        b bVar;
        boolean kx;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.GQ.kE().KE && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.JZ = i4;
            ad(i4);
            try {
                try {
                    try {
                        this.JY = new b(this.GQ);
                        this.JY.ab(i4);
                        this.JY.ag(JS);
                        this.JY.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.GQ.kE().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.GQ.a(dVar);
                        if (this.JM <= 0 && this.JY != null) {
                            this.JM = this.JY.ku();
                        }
                        dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        this.GQ.a(dVar);
                        a kr2 = a.kr();
                        if (kr2 != null && this.JY != null && this.JY.kx()) {
                            kr2.a(this.GQ);
                        }
                    }
                } catch (SocketException e2) {
                    this.GQ.kE().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.GQ.a(dVar);
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.a(dVar);
                    a kr3 = a.kr();
                    if (kr3 != null && this.JY != null && this.JY.kx()) {
                        kr3.a(this.GQ);
                    }
                } catch (SocketTimeoutException e3) {
                    this.GQ.kE().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.GQ.a(dVar);
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.a(dVar);
                    a kr4 = a.kr();
                    if (kr4 != null && this.JY != null && this.JY.kx()) {
                        kr4.a(this.GQ);
                    }
                }
                if (this.GQ.kE().responseCode == 200) {
                    if (kr != null) {
                        if (bVar != null) {
                            if (kx) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4;
                z = ac(this.GQ.kE().responseCode);
                this.GQ.a(dVar);
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.a(dVar);
                a kr5 = a.kr();
                if (kr5 != null && this.JY != null && this.JY.kx()) {
                    kr5.a(this.GQ);
                }
                z2 = z;
            } finally {
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.a(dVar);
                kr = a.kr();
                if (kr != null && this.JY != null && this.JY.kx()) {
                    kr.a(this.GQ);
                }
            }
        }
    }

    private boolean ac(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.GQ.kD().kH()) {
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
            i2 = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jJ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.GQ.kE().KE && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.JZ = i4;
            dVar.retry = i4 + 1;
            ad(i4);
            try {
                try {
                    try {
                        this.JY = new b(this.GQ);
                        this.JY.ab(i4);
                        this.JY.ag(JS);
                        this.JY.ah(this.Ka);
                        this.JY.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.GQ.kE().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.GQ.a(dVar);
                        if (this.JM <= 0 && this.JY != null) {
                            this.JM = this.JY.ku();
                        }
                        dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        this.GQ.a(dVar);
                        a kr = a.kr();
                        if (kr != null) {
                            kr.a(this.GQ);
                        }
                    } catch (Throwable th) {
                        this.GQ.kE().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.GQ.a(dVar);
                        if (this.JM <= 0 && this.JY != null) {
                            this.JM = this.JY.ku();
                        }
                        dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                        this.GQ.a(dVar);
                        a kr2 = a.kr();
                        if (kr2 != null) {
                            kr2.a(this.GQ);
                        }
                    }
                } catch (SocketException e2) {
                    this.GQ.kE().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.GQ.a(dVar);
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.a(dVar);
                    a kr3 = a.kr();
                    if (kr3 != null) {
                        kr3.a(this.GQ);
                    }
                } catch (SocketTimeoutException e3) {
                    this.GQ.kE().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.GQ.a(dVar);
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.a(dVar);
                    a kr4 = a.kr();
                    if (kr4 != null) {
                        kr4.a(this.GQ);
                    }
                }
                if (this.GQ.kE().responseCode == 200) {
                    if (this.JM <= 0 && this.JY != null) {
                        this.JM = this.JY.ku();
                    }
                    dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                    this.GQ.a(dVar);
                    a kr5 = a.kr();
                    if (kr5 != null) {
                        kr5.a(this.GQ);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.GQ.kE().responseCode) + "|retryCount:" + i4;
                z = ac(this.GQ.kE().responseCode);
                this.GQ.a(dVar);
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.a(dVar);
                a kr6 = a.kr();
                if (kr6 != null) {
                    kr6.a(this.GQ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.JM <= 0 && this.JY != null) {
                    this.JM = this.JY.ku();
                }
                dVar.Kd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ki().a(this.GQ.kD().getUrl(), this.GQ.kD().bB("Host"), TextUtils.isEmpty(dVar.exception), dVar.Kh != null);
                this.GQ.a(dVar);
                a kr7 = a.kr();
                if (kr7 != null) {
                    kr7.a(this.GQ);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.JY != null) {
            this.JY.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.GQ == null) {
            return false;
        }
        return this.GQ.kE().KE;
    }

    public void setCancel() {
        if (this.GQ != null) {
            this.GQ.kE().KE = true;
        }
    }

    public void ai(boolean z) {
        this.Ka = z;
    }

    public long ky() {
        if (this.JM > 0) {
            return this.JM;
        }
        if (this.JY == null) {
            return -1L;
        }
        return this.JY.ku();
    }

    public long kz() {
        if (this.JY == null) {
            return -1L;
        }
        return this.JY.kv();
    }

    public long kw() {
        if (this.JY == null) {
            return -1L;
        }
        return this.JY.kw();
    }

    public long kA() {
        if (this.JY == null) {
            return -1L;
        }
        return this.JY.kt();
    }

    public long kB() {
        if (this.JY == null) {
            return -1L;
        }
        return this.JY.ks();
    }

    public int kC() {
        return this.JZ;
    }

    private void ad(int i) {
        try {
            if (this.GQ != null && i > 0) {
                this.GQ.kD().s("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
