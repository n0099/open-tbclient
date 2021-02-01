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
    public static boolean LO = true;
    private e IP;
    private b LW;
    private int LX = 0;
    private long LH = 0;
    private boolean LY = true;

    public c(e eVar) {
        this.IP = eVar;
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
        a lI;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.LW = new b(this.IP);
        this.LW.ae(LO);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.IP.lV().mNetErrorCode = -1;
            this.LW.ar(i5);
            try {
                dVar.retry = i5 + 1;
                this.LX = i5;
                at(i5);
                z3 = this.LW.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.IP.lV().MD) {
                            this.IP.lV().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI2 = a.lI();
                        if (lI2 != null) {
                            lI2.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.IP.lV().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI3 = a.lI();
                        if (lI3 != null) {
                            lI3.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI4 = a.lI();
                        if (lI4 != null) {
                            lI4.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI5 = a.lI();
                        if (lI5 != null) {
                            lI5.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI6 = a.lI();
                        if (lI6 != null) {
                            lI6.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI7 = a.lI();
                        if (lI7 != null) {
                            lI7.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.IP.lU().mb() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.IP.lV().mNetErrorCode = -20;
                        } else {
                            String bL = com.baidu.adp.lib.network.http.a.d.bL(this.IP.lU().getUrl());
                            if (!k.isEmpty(bL)) {
                                this.IP.lU().setUrl(bL);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI8 = a.lI();
                        if (lI8 != null) {
                            lI8.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.IP.lV().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.IP.a(dVar);
                        a lI9 = a.lI();
                        if (lI9 != null) {
                            lI9.a(this.IP);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.IP.lV().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.IP.a(dVar);
                            a lI10 = a.lI();
                            if (lI10 != null) {
                                lI10.a(this.IP);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf == null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.IP.a(dVar);
                            lI = a.lI();
                            if (lI != null) {
                                lI.a(this.IP);
                            }
                            throw th;
                        }
                    }
                }
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.IP.a(dVar);
                a lI11 = a.lI();
                if (lI11 != null) {
                    lI11.a(this.IP);
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
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf == null);
                if (!z3) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.mk();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.IP.a(dVar);
                lI = a.lI();
                if (lI != null) {
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
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.IP.lV().MD && z && i4 < i; i4++) {
            d dVar = new d();
            this.IP.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.LX = i4;
                                dVar.retry = i4 + 1;
                                dVar.Mm = 1;
                                at(i4);
                                this.LW = new b(this.IP);
                                this.LW.ar(i4);
                                this.LW.ae(LO);
                                this.LW.a(i2, i3, dVar);
                            } catch (IOException e) {
                                this.IP.lV().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.LH <= 0 && this.LW != null) {
                                    this.LH = this.LW.lL();
                                }
                                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                                this.IP.b(dVar);
                                a lI = a.lI();
                                if (lI != null) {
                                    lI.a(this.IP);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.IP.lV().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.LH <= 0 && this.LW != null) {
                                this.LH = this.LW.lL();
                            }
                            dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                            this.IP.b(dVar);
                            a lI2 = a.lI();
                            if (lI2 != null) {
                                lI2.a(this.IP);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.IP.lV().mNetErrorCode = -12;
                        if (this.LH <= 0 && this.LW != null) {
                            this.LH = this.LW.lL();
                        }
                        dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        this.IP.b(dVar);
                        a lI3 = a.lI();
                        if (lI3 != null) {
                            lI3.a(this.IP);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.IP.lV().mNetErrorCode = -13;
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.b(dVar);
                    a lI4 = a.lI();
                    if (lI4 != null) {
                        lI4.a(this.IP);
                    }
                    z = true;
                }
                if (this.IP.lV().responseCode == 200) {
                    this.IP.b(dVar);
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.b(dVar);
                    a lI5 = a.lI();
                    if (lI5 != null) {
                        lI5.a(this.IP);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4;
                boolean as = as(this.IP.lV().responseCode);
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.b(dVar);
                a lI6 = a.lI();
                if (lI6 != null) {
                    lI6.a(this.IP);
                }
                z = as;
            } catch (Throwable th) {
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.b(dVar);
                a lI7 = a.lI();
                if (lI7 != null) {
                    lI7.a(this.IP);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a lI;
        b bVar;
        boolean lO;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.IP.lV().MD && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.LX = i4;
            at(i4);
            try {
                try {
                    try {
                        this.LW = new b(this.IP);
                        this.LW.ar(i4);
                        this.LW.ae(LO);
                        this.LW.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.IP.lV().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.IP.a(dVar);
                        if (this.LH <= 0 && this.LW != null) {
                            this.LH = this.LW.lL();
                        }
                        dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        this.IP.a(dVar);
                        a lI2 = a.lI();
                        if (lI2 != null && this.LW != null && this.LW.lO()) {
                            lI2.a(this.IP);
                        }
                    }
                } catch (SocketException e2) {
                    this.IP.lV().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.IP.a(dVar);
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.a(dVar);
                    a lI3 = a.lI();
                    if (lI3 != null && this.LW != null && this.LW.lO()) {
                        lI3.a(this.IP);
                    }
                } catch (SocketTimeoutException e3) {
                    this.IP.lV().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.IP.a(dVar);
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.a(dVar);
                    a lI4 = a.lI();
                    if (lI4 != null && this.LW != null && this.LW.lO()) {
                        lI4.a(this.IP);
                    }
                }
                if (this.IP.lV().responseCode == 200) {
                    if (lI != null) {
                        if (bVar != null) {
                            if (lO) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4;
                z = as(this.IP.lV().responseCode);
                this.IP.a(dVar);
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.a(dVar);
                a lI5 = a.lI();
                if (lI5 != null && this.LW != null && this.LW.lO()) {
                    lI5.a(this.IP);
                }
                z2 = z;
            } finally {
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.a(dVar);
                lI = a.lI();
                if (lI != null && this.LW != null && this.LW.lO()) {
                    lI.a(this.IP);
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
        if (this.IP.lU().lY()) {
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
            i2 = com.baidu.adp.framework.d.b.kY().lb().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.kY().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.kY().kZ().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.IP.lV().MD && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.LX = i4;
            dVar.retry = i4 + 1;
            at(i4);
            try {
                try {
                    try {
                        this.LW = new b(this.IP);
                        this.LW.ar(i4);
                        this.LW.ae(LO);
                        this.LW.af(this.LY);
                        this.LW.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.IP.lV().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.IP.a(dVar);
                        if (this.LH <= 0 && this.LW != null) {
                            this.LH = this.LW.lL();
                        }
                        dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        this.IP.a(dVar);
                        a lI = a.lI();
                        if (lI != null) {
                            lI.a(this.IP);
                        }
                    } catch (Throwable th) {
                        this.IP.lV().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.IP.a(dVar);
                        if (this.LH <= 0 && this.LW != null) {
                            this.LH = this.LW.lL();
                        }
                        dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                        this.IP.a(dVar);
                        a lI2 = a.lI();
                        if (lI2 != null) {
                            lI2.a(this.IP);
                        }
                    }
                } catch (SocketException e2) {
                    this.IP.lV().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.IP.a(dVar);
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.a(dVar);
                    a lI3 = a.lI();
                    if (lI3 != null) {
                        lI3.a(this.IP);
                    }
                } catch (SocketTimeoutException e3) {
                    this.IP.lV().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.IP.a(dVar);
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.a(dVar);
                    a lI4 = a.lI();
                    if (lI4 != null) {
                        lI4.a(this.IP);
                    }
                }
                if (this.IP.lV().responseCode == 200) {
                    if (this.LH <= 0 && this.LW != null) {
                        this.LH = this.LW.lL();
                    }
                    dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                    this.IP.a(dVar);
                    a lI5 = a.lI();
                    if (lI5 != null) {
                        lI5.a(this.IP);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.IP.lV().responseCode) + "|retryCount:" + i4;
                z = as(this.IP.lV().responseCode);
                this.IP.a(dVar);
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.a(dVar);
                a lI6 = a.lI();
                if (lI6 != null) {
                    lI6.a(this.IP);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.LH <= 0 && this.LW != null) {
                    this.LH = this.LW.lL();
                }
                dVar.Mb = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.lz().a(this.IP.lU().getUrl(), this.IP.lU().bG("Host"), TextUtils.isEmpty(dVar.exception), dVar.Mf != null);
                this.IP.a(dVar);
                a lI7 = a.lI();
                if (lI7 != null) {
                    lI7.a(this.IP);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.LW != null) {
            this.LW.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.IP == null) {
            return false;
        }
        return this.IP.lV().MD;
    }

    public void setCancel() {
        if (this.IP != null) {
            this.IP.lV().MD = true;
        }
    }

    public void ag(boolean z) {
        this.LY = z;
    }

    public long lP() {
        if (this.LH > 0) {
            return this.LH;
        }
        if (this.LW == null) {
            return -1L;
        }
        return this.LW.lL();
    }

    public long lQ() {
        if (this.LW == null) {
            return -1L;
        }
        return this.LW.lM();
    }

    public long lN() {
        if (this.LW == null) {
            return -1L;
        }
        return this.LW.lN();
    }

    public long lR() {
        if (this.LW == null) {
            return -1L;
        }
        return this.LW.lK();
    }

    public long lS() {
        if (this.LW == null) {
            return -1L;
        }
        return this.LW.lJ();
    }

    public int lT() {
        return this.LX;
    }

    private void at(int i) {
        try {
            if (this.IP != null && i > 0) {
                this.IP.lU().s("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
