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
    public static boolean Ks = true;
    private e Hs;
    private b Ky;
    private int Kz = 0;
    private long Km = 0;
    private boolean KA = true;

    public c(e eVar) {
        this.Hs = eVar;
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
        a kH;
        int timeOutAuto = i3 <= 0 ? com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        int timeOutAuto2 = i4 <= 0 ? com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto() : i4;
        boolean z4 = false;
        this.Ky = new b(this.Hs);
        this.Ky.ah(Ks);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            this.Hs.kU().mNetErrorCode = -1;
            this.Ky.ah(i5);
            try {
                dVar.retry = i5 + 1;
                this.Kz = i5;
                aj(i5);
                z3 = this.Ky.a(str, hVar, timeOutAuto, timeOutAuto2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.Hs.kU().Le) {
                            this.Hs.kU().mNetErrorCode = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.exception = "responseCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -100;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH2 = a.kH();
                        if (kH2 != null) {
                            kH2.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.exception = "responseCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.Hs.kU().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH3 = a.kH();
                        if (kH3 != null) {
                            kH3.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (ConnectException e3) {
                        e = e3;
                        dVar.exception = "responseCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -22;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH4 = a.kH();
                        if (kH4 != null) {
                            kH4.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e4) {
                        e = e4;
                        dVar.exception = "responseCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -12;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH5 = a.kH();
                        if (kH5 != null) {
                            kH5.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        dVar.exception = "responseCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -13;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH6 = a.kH();
                        if (kH6 != null) {
                            kH6.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (UnknownHostException e6) {
                        e = e6;
                        dVar.exception = "errorCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -21;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH7 = a.kH();
                        if (kH7 != null) {
                            kH7.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SSLException e7) {
                        e = e7;
                        if (!this.Hs.kT().la() || i5 >= i - 1) {
                            dVar.exception = "errorCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.Hs.kU().mNetErrorCode = -20;
                        } else {
                            String bJ = com.baidu.adp.lib.network.http.a.d.bJ(this.Hs.kT().getUrl());
                            if (!k.isEmpty(bJ)) {
                                this.Hs.kT().setUrl(bJ);
                            }
                            BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                        }
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH8 = a.kH();
                        if (kH8 != null) {
                            kH8.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e8) {
                        e = e8;
                        dVar.exception = "errorCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.Hs.kU().mNetErrorCode = -19;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        if (!z3 && i5 == i - 1) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        a kH9 = a.kH();
                        if (kH9 != null) {
                            kH9.a(this.Hs);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e9) {
                        e = e9;
                        try {
                            dVar.exception = "errorCode:" + String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.Hs.kU().mNetErrorCode = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                            if (!z3 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.Hs.a(dVar);
                            a kH10 = a.kH();
                            if (kH10 != null) {
                                kH10.a(this.Hs);
                            }
                            i5++;
                            z4 = z3;
                        } catch (Throwable th2) {
                            z4 = z3;
                            th = th2;
                            com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI == null);
                            if (!z4 && i5 == i - 1) {
                                dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                                dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                            }
                            this.Hs.a(dVar);
                            kH = a.kH();
                            if (kH != null) {
                                kH.a(this.Hs);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        z4 = z3;
                        th = th3;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI == null);
                        if (!z4) {
                            dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                            dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                        }
                        this.Hs.a(dVar);
                        kH = a.kH();
                        if (kH != null) {
                        }
                        throw th;
                    }
                }
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                if (!z3 && i5 == i - 1) {
                    dVar.exception += "|" + com.baidu.adp.lib.network.http.a.d.li();
                    dVar.exception += "|netAvailable:" + j.isNetworkAvailableForImmediately();
                }
                this.Hs.a(dVar);
                a kH11 = a.kH();
                if (kH11 != null) {
                    kH11.a(this.Hs);
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.Hs.kU().Le && z && i4 < i; i4++) {
            d dVar = new d();
            this.Hs.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.Kz = i4;
                                dVar.retry = i4 + 1;
                                dVar.KP = 1;
                                aj(i4);
                                this.Ky = new b(this.Hs);
                                this.Ky.ah(i4);
                                this.Ky.ah(Ks);
                                this.Ky.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.Hs.kU().mNetErrorCode = -19;
                                dVar.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.Km <= 0 && this.Ky != null) {
                                    this.Km = this.Ky.kK();
                                }
                                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                                this.Hs.b(dVar);
                                a kH = a.kH();
                                if (kH != null) {
                                    kH.a(this.Hs);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.Hs.kU().mNetErrorCode = -10;
                            BdLog.e(e2.getMessage());
                            if (this.Km <= 0 && this.Ky != null) {
                                this.Km = this.Ky.kK();
                            }
                            dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                            this.Hs.b(dVar);
                            a kH2 = a.kH();
                            if (kH2 != null) {
                                kH2.a(this.Hs);
                                return;
                            }
                            return;
                        }
                    } catch (SocketException e3) {
                        dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.Hs.kU().mNetErrorCode = -12;
                        if (this.Km <= 0 && this.Ky != null) {
                            this.Km = this.Ky.kK();
                        }
                        dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        this.Hs.b(dVar);
                        a kH3 = a.kH();
                        if (kH3 != null) {
                            kH3.a(this.Hs);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e4) {
                    dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.Hs.kU().mNetErrorCode = -13;
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.b(dVar);
                    a kH4 = a.kH();
                    if (kH4 != null) {
                        kH4.a(this.Hs);
                    }
                    z = true;
                }
                if (this.Hs.kU().responseCode == 200) {
                    this.Hs.b(dVar);
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.b(dVar);
                    a kH5 = a.kH();
                    if (kH5 != null) {
                        kH5.a(this.Hs);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4;
                boolean ai = ai(this.Hs.kU().responseCode);
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.b(dVar);
                a kH6 = a.kH();
                if (kH6 != null) {
                    kH6.a(this.Hs);
                }
                z = ai;
            } catch (Throwable th) {
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.b(dVar);
                a kH7 = a.kH();
                if (kH7 != null) {
                    kH7.a(this.Hs);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [423=7, 424=7, 426=7, 427=14, 428=7, 429=7, 430=7, 431=7, 433=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a kH;
        b bVar;
        boolean kN;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.Hs.kU().Le && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.Kz = i4;
            aj(i4);
            try {
                try {
                    try {
                        this.Ky = new b(this.Hs);
                        this.Ky.ah(i4);
                        this.Ky.ah(Ks);
                        this.Ky.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.Hs.kU().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.Hs.a(dVar);
                        if (this.Km <= 0 && this.Ky != null) {
                            this.Km = this.Ky.kK();
                        }
                        dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        this.Hs.a(dVar);
                        a kH2 = a.kH();
                        if (kH2 != null && this.Ky != null && this.Ky.kN()) {
                            kH2.a(this.Hs);
                        }
                    }
                } catch (SocketException e2) {
                    this.Hs.kU().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.Hs.a(dVar);
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.a(dVar);
                    a kH3 = a.kH();
                    if (kH3 != null && this.Ky != null && this.Ky.kN()) {
                        kH3.a(this.Hs);
                    }
                } catch (SocketTimeoutException e3) {
                    this.Hs.kU().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.Hs.a(dVar);
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.a(dVar);
                    a kH4 = a.kH();
                    if (kH4 != null && this.Ky != null && this.Ky.kN()) {
                        kH4.a(this.Hs);
                    }
                }
                if (this.Hs.kU().responseCode == 200) {
                    if (kH != null) {
                        if (bVar != null) {
                            if (kN) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4;
                z = ai(this.Hs.kU().responseCode);
                this.Hs.a(dVar);
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.a(dVar);
                a kH5 = a.kH();
                if (kH5 != null && this.Ky != null && this.Ky.kN()) {
                    kH5.a(this.Hs);
                }
                z2 = z;
            } finally {
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.a(dVar);
                kH = a.kH();
                if (kH != null && this.Ky != null && this.Ky.kN()) {
                    kH.a(this.Hs);
                }
            }
        }
    }

    private boolean ai(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.Hs.kT().kX()) {
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
            i2 = com.baidu.adp.framework.d.b.jZ().kc().getTimeOutAuto();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.d.b.jZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.d.b.jZ().ka().getTimeOutAuto();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.Hs.kU().Le && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.Kz = i4;
            dVar.retry = i4 + 1;
            aj(i4);
            try {
                try {
                    try {
                        this.Ky = new b(this.Hs);
                        this.Ky.ah(i4);
                        this.Ky.ah(Ks);
                        this.Ky.ai(this.KA);
                        this.Ky.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.Hs.kU().mNetErrorCode = -14;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.Hs.a(dVar);
                        if (this.Km <= 0 && this.Ky != null) {
                            this.Km = this.Ky.kK();
                        }
                        dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        this.Hs.a(dVar);
                        a kH = a.kH();
                        if (kH != null) {
                            kH.a(this.Hs);
                        }
                    } catch (Throwable th) {
                        this.Hs.kU().mNetErrorCode = -10;
                        z = false;
                        dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.Hs.a(dVar);
                        if (this.Km <= 0 && this.Ky != null) {
                            this.Km = this.Ky.kK();
                        }
                        dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                        this.Hs.a(dVar);
                        a kH2 = a.kH();
                        if (kH2 != null) {
                            kH2.a(this.Hs);
                        }
                    }
                } catch (SocketException e2) {
                    this.Hs.kU().mNetErrorCode = -12;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.Hs.a(dVar);
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.a(dVar);
                    a kH3 = a.kH();
                    if (kH3 != null) {
                        kH3.a(this.Hs);
                    }
                } catch (SocketTimeoutException e3) {
                    this.Hs.kU().mNetErrorCode = -13;
                    z = true;
                    dVar.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.Hs.a(dVar);
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.a(dVar);
                    a kH4 = a.kH();
                    if (kH4 != null) {
                        kH4.a(this.Hs);
                    }
                }
                if (this.Hs.kU().responseCode == 200) {
                    if (this.Km <= 0 && this.Ky != null) {
                        this.Km = this.Ky.kK();
                    }
                    dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                    this.Hs.a(dVar);
                    a kH5 = a.kH();
                    if (kH5 != null) {
                        kH5.a(this.Hs);
                        return;
                    }
                    return;
                }
                dVar.exception = String.valueOf(this.Hs.kU().responseCode) + "|retryCount:" + i4;
                z = ai(this.Hs.kU().responseCode);
                this.Hs.a(dVar);
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.a(dVar);
                a kH6 = a.kH();
                if (kH6 != null) {
                    kH6.a(this.Hs);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Km <= 0 && this.Ky != null) {
                    this.Km = this.Ky.kK();
                }
                dVar.KE = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.ky().a(this.Hs.kT().getUrl(), this.Hs.kT().bC("Host"), TextUtils.isEmpty(dVar.exception), dVar.KI != null);
                this.Hs.a(dVar);
                a kH7 = a.kH();
                if (kH7 != null) {
                    kH7.a(this.Hs);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Ky != null) {
            this.Ky.cancelNetConnect();
        }
    }

    public boolean isCancel() {
        if (this.Hs == null) {
            return false;
        }
        return this.Hs.kU().Le;
    }

    public void setCancel() {
        if (this.Hs != null) {
            this.Hs.kU().Le = true;
        }
    }

    public void aj(boolean z) {
        this.KA = z;
    }

    public long kO() {
        if (this.Km > 0) {
            return this.Km;
        }
        if (this.Ky == null) {
            return -1L;
        }
        return this.Ky.kK();
    }

    public long kP() {
        if (this.Ky == null) {
            return -1L;
        }
        return this.Ky.kL();
    }

    public long kM() {
        if (this.Ky == null) {
            return -1L;
        }
        return this.Ky.kM();
    }

    public long kQ() {
        if (this.Ky == null) {
            return -1L;
        }
        return this.Ky.kJ();
    }

    public long kR() {
        if (this.Ky == null) {
            return -1L;
        }
        return this.Ky.kI();
    }

    public int kS() {
        return this.Kz;
    }

    private void aj(int i) {
        try {
            if (this.Hs != null && i > 0) {
                this.Hs.kT().s("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
