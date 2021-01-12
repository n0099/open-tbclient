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
    public static boolean LR = true;
    private e IQ;
    private b LY;
    private int LZ = 0;
    private long LJ = 0;
    private boolean Ma = true;

    public c(e eVar) {
        this.IQ = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=21, 240=11, 241=11, 242=11, 244=11, 245=11, 246=11, 247=11, 249=9] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x09b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Throwable th;
        boolean z3;
        a lJ;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.LY = new b(this.IQ);
        this.LY.ae(LR);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.IQ.lW().mNetErrorCode = -1;
            this.LY.ar(i5);
            try {
                dVar.retry = i5 + 1;
                this.LZ = i5;
                at(i5);
                z3 = this.LY.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.IQ.lW().MF) {
                            this.IQ.lW().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ2 = a.lJ();
                        if (lJ2 != null) {
                            lJ2.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.IQ.lW().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ3 = a.lJ();
                        if (lJ3 != null) {
                            lJ3.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ4 = a.lJ();
                        if (lJ4 != null) {
                            lJ4.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ5 = a.lJ();
                        if (lJ5 != null) {
                            lJ5.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ6 = a.lJ();
                        if (lJ6 != null) {
                            lJ6.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ7 = a.lJ();
                        if (lJ7 != null) {
                            lJ7.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.IQ.lV().mc() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.IQ.lW().mNetErrorCode = -20;
                        } else {
                            String bL = com.baidu.adp.lib.network.http.a.d.bL(this.IQ.lV().getUrl());
                            if (!k.isEmpty(bL)) {
                                this.IQ.lV().setUrl(bL);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ8 = a.lJ();
                        if (lJ8 != null) {
                            lJ8.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IQ.lW().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IQ.a(dVar);
                        a lJ9 = a.lJ();
                        if (lJ9 != null) {
                            lJ9.a(this.IQ);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.IQ.lW().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.IQ.a(dVar);
                            a lJ10 = a.lJ();
                            if (lJ10 != null) {
                                lJ10.a(this.IQ);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh == null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.IQ.a(dVar);
                            lJ = a.lJ();
                            if (lJ != null) {
                                lJ.a(this.IQ);
                            }
                            throw th;
                        }
                    }
                }
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.IQ.a(dVar);
                a lJ11 = a.lJ();
                if (lJ11 != null) {
                    lJ11.a(this.IQ);
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
            } catch (Throwable th3) {
                th = th3;
                z3 = z4;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh == null);
                if (!z3) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.ml();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.IQ.a(dVar);
                lJ = a.lJ();
                if (lJ != null) {
                }
                throw th;
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.IQ.lW().MF && z && i4 < i; i4++) {
            d dVar = new d();
            this.IQ.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LZ = i4;
                                dVar.retry = i4 + 1;
                                dVar.Mo = 1;
                                at(i4);
                                this.LY = new b(this.IQ);
                                this.LY.ar(i4);
                                this.LY.ae(LR);
                                this.LY.a(i2, i3, dVar);
                            } catch (IOException e) {
                                this.IQ.lW().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LJ <= 0 && this.LY != null) {
                                    this.LJ = this.LY.lM();
                                }
                                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                                this.IQ.b(dVar);
                                a lJ = a.lJ();
                                if (lJ != null) {
                                    lJ.a(this.IQ);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.IQ.lW().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LJ <= 0 && this.LY != null) {
                                this.LJ = this.LY.lM();
                            }
                            dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                            this.IQ.b(dVar);
                            a lJ2 = a.lJ();
                            if (lJ2 != null) {
                                lJ2.a(this.IQ);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.IQ.lW().mNetErrorCode = -12;
                        if (this.LJ <= 0 && this.LY != null) {
                            this.LJ = this.LY.lM();
                        }
                        dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        this.IQ.b(dVar);
                        a lJ3 = a.lJ();
                        if (lJ3 != null) {
                            lJ3.a(this.IQ);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.IQ.lW().mNetErrorCode = -13;
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.b(dVar);
                    a lJ4 = a.lJ();
                    if (lJ4 != null) {
                        lJ4.a(this.IQ);
                    }
                    z = true;
                }
                if (this.IQ.lW().responseCode == 200) {
                    this.IQ.b(dVar);
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.b(dVar);
                    a lJ5 = a.lJ();
                    if (lJ5 != null) {
                        lJ5.a(this.IQ);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.IQ.lW().responseCode);
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.b(dVar);
                a lJ6 = a.lJ();
                if (lJ6 != null) {
                    lJ6.a(this.IQ);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.b(dVar);
                a lJ7 = a.lJ();
                if (lJ7 != null) {
                    lJ7.a(this.IQ);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a lJ;
        b bVar;
        boolean lP;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.IQ.lW().MF && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.LZ = i4;
            at(i4);
            try {
                try {
                    try {
                        this.LY = new b(this.IQ);
                        this.LY.ar(i4);
                        this.LY.ae(LR);
                        this.LY.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.IQ.lW().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.IQ.a(dVar);
                        if (this.LJ <= 0 && this.LY != null) {
                            this.LJ = this.LY.lM();
                        }
                        dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        this.IQ.a(dVar);
                        a lJ2 = a.lJ();
                        if (lJ2 != null && this.LY != null && this.LY.lP()) {
                            lJ2.a(this.IQ);
                        }
                    }
                } catch (SocketException e2) {
                    this.IQ.lW().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.IQ.a(dVar);
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.a(dVar);
                    a lJ3 = a.lJ();
                    if (lJ3 != null && this.LY != null && this.LY.lP()) {
                        lJ3.a(this.IQ);
                    }
                } catch (SocketTimeoutException e3) {
                    this.IQ.lW().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.IQ.a(dVar);
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.a(dVar);
                    a lJ4 = a.lJ();
                    if (lJ4 != null && this.LY != null && this.LY.lP()) {
                        lJ4.a(this.IQ);
                    }
                }
                if (this.IQ.lW().responseCode == 200) {
                    if (lJ != null) {
                        if (bVar != null) {
                            if (lP) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4;
                z = as(this.IQ.lW().responseCode);
                this.IQ.a(dVar);
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.a(dVar);
                a lJ5 = a.lJ();
                if (lJ5 != null && this.LY != null && this.LY.lP()) {
                    lJ5.a(this.IQ);
                }
                z2 = z;
            } finally {
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.a(dVar);
                lJ = a.lJ();
                if (lJ != null && this.LY != null && this.LY.lP()) {
                    lJ.a(this.IQ);
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
        if (this.IQ.lV().lZ()) {
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
            i2 = com.baidu.adp.framework.d.b.kZ().lc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kZ().la().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.IQ.lW().MF && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.LZ = i4;
            dVar.retry = i4 + 1;
            at(i4);
            try {
                try {
                    try {
                        this.LY = new b(this.IQ);
                        this.LY.ar(i4);
                        this.LY.ae(LR);
                        this.LY.af(this.Ma);
                        this.LY.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.IQ.lW().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.IQ.a(dVar);
                        if (this.LJ <= 0 && this.LY != null) {
                            this.LJ = this.LY.lM();
                        }
                        dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        this.IQ.a(dVar);
                        a lJ = a.lJ();
                        if (lJ != null) {
                            lJ.a(this.IQ);
                        }
                    } catch (Throwable th) {
                        this.IQ.lW().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.IQ.a(dVar);
                        if (this.LJ <= 0 && this.LY != null) {
                            this.LJ = this.LY.lM();
                        }
                        dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                        this.IQ.a(dVar);
                        a lJ2 = a.lJ();
                        if (lJ2 != null) {
                            lJ2.a(this.IQ);
                        }
                    }
                } catch (SocketException e2) {
                    this.IQ.lW().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.IQ.a(dVar);
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.a(dVar);
                    a lJ3 = a.lJ();
                    if (lJ3 != null) {
                        lJ3.a(this.IQ);
                    }
                } catch (SocketTimeoutException e3) {
                    this.IQ.lW().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.IQ.a(dVar);
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.a(dVar);
                    a lJ4 = a.lJ();
                    if (lJ4 != null) {
                        lJ4.a(this.IQ);
                    }
                }
                if (this.IQ.lW().responseCode == 200) {
                    if (this.LJ <= 0 && this.LY != null) {
                        this.LJ = this.LY.lM();
                    }
                    dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                    this.IQ.a(dVar);
                    a lJ5 = a.lJ();
                    if (lJ5 != null) {
                        lJ5.a(this.IQ);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IQ.lW().responseCode) + "|retryCount:" + i4;
                z = as(this.IQ.lW().responseCode);
                this.IQ.a(dVar);
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.a(dVar);
                a lJ6 = a.lJ();
                if (lJ6 != null) {
                    lJ6.a(this.IQ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LJ <= 0 && this.LY != null) {
                    this.LJ = this.LY.lM();
                }
                dVar.Md = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lA().a(this.IQ.lV().getUrl(), this.IQ.lV().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mh != null);
                this.IQ.a(dVar);
                a lJ7 = a.lJ();
                if (lJ7 != null) {
                    lJ7.a(this.IQ);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.LY != null) {
            this.LY.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.IQ == null) {
            return false;
        }
        return this.IQ.lW().MF;
    }

    public void setCancel() {
        if (this.IQ != null) {
            this.IQ.lW().MF = true;
        }
    }

    public void ag(boolean z) {
        this.Ma = z;
    }

    public long lQ() {
        if (this.LJ > 0) {
            return this.LJ;
        }
        if (this.LY == null) {
            return -1L;
        }
        return this.LY.lM();
    }

    public long lR() {
        if (this.LY == null) {
            return -1L;
        }
        return this.LY.lN();
    }

    public long lO() {
        if (this.LY == null) {
            return -1L;
        }
        return this.LY.lO();
    }

    public long lS() {
        if (this.LY == null) {
            return -1L;
        }
        return this.LY.lL();
    }

    public long lT() {
        if (this.LY == null) {
            return -1L;
        }
        return this.LY.lK();
    }

    public int lU() {
        return this.LZ;
    }

    private void at(int i) {
        try {
            if (this.IQ != null && i > 0) {
                this.IQ.lV().u("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
