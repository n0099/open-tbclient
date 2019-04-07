package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class c {
    private b CC;
    private int CD = 0;
    private long Cs = 0;
    private e vY;

    public c(e eVar) {
        this.vY = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [199=15, 200=8, 201=8, 202=8, 203=8, 205=6] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int ho = i3 <= 0 ? com.baidu.adp.framework.c.b.hk().hn().ho() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        int ho2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hk().hl().ho() : i4;
        boolean z4 = false;
        this.CC = new b(this.vY);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.CH = i5 + 1;
                this.CD = i5;
                aj(i5);
                z3 = this.CC.a(str, hVar, ho, ho2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.vY.js().Dc) {
                            this.vY.js().Dd = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.CK = "responseCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.vY.js().Dd = -100;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb = a.jb();
                        if (jb != null) {
                            jb.a(this.vY);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.CK = "responseCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.vY.js().Dd = -19;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb2 = a.jb();
                        if (jb2 != null) {
                            jb2.a(this.vY);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e3) {
                        e = e3;
                        dVar.CK = "responseCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.vY.js().Dd = -12;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb3 = a.jb();
                        if (jb3 != null) {
                            jb3.a(this.vY);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        dVar.CK = "responseCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.vY.js().Dd = -13;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb4 = a.jb();
                        if (jb4 != null) {
                            jb4.a(this.vY);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e5) {
                        e = e5;
                        dVar.CK = "errorCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.vY.js().Dd = -19;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb5 = a.jb();
                        if (jb5 != null) {
                            jb5.a(this.vY);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e6) {
                        e = e6;
                        try {
                            dVar.CK = "errorCode:" + String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.vY.js().Dd = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                            this.vY.a(dVar);
                            a jb6 = a.jb();
                            if (jb6 != null) {
                                jb6.a(this.vY);
                            }
                            i5++;
                            z4 = z3;
                        } finally {
                            com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                            this.vY.a(dVar);
                            a jb7 = a.jb();
                            if (jb7 != null) {
                                jb7.a(this.vY);
                            }
                        }
                    }
                }
                return z3;
            } catch (FileNotFoundException e7) {
                e = e7;
                z3 = z4;
            } catch (IllegalStateException e8) {
                e = e8;
                z3 = z4;
            } catch (SocketException e9) {
                e = e9;
                z3 = z4;
            } catch (SocketTimeoutException e10) {
                e = e10;
                z3 = z4;
            } catch (IOException e11) {
                e = e11;
                z3 = z4;
            } catch (Exception e12) {
                e = e12;
                z3 = z4;
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=7, 298=7, 300=7, 301=14, 302=7, 303=7, 304=7, 305=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.vY.js().Dc && z && i4 < i; i4++) {
            d dVar = new d();
            this.vY.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.CD = i4;
                            dVar.CH = i4 + 1;
                            dVar.CT = 1;
                            aj(i4);
                            this.CC = new b(this.vY);
                            this.CC.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.vY.js().Dd = -19;
                            dVar.CK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Cs <= 0 && this.CC != null) {
                                this.Cs = this.CC.je();
                            }
                            dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                            this.vY.b(dVar);
                            a jb = a.jb();
                            if (jb != null) {
                                jb.a(this.vY);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.vY.js().Dd = -12;
                        if (this.Cs <= 0 && this.CC != null) {
                            this.Cs = this.CC.je();
                        }
                        dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.b(dVar);
                        a jb2 = a.jb();
                        if (jb2 != null) {
                            jb2.a(this.vY);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.vY.js().Dd = -13;
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.b(dVar);
                    a jb3 = a.jb();
                    if (jb3 != null) {
                        jb3.a(this.vY);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.vY.js().Dd = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.b(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null) {
                        jb4.a(this.vY);
                        return;
                    }
                    return;
                }
                if (this.vY.js().responseCode == 200) {
                    this.vY.b(dVar);
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.b(dVar);
                    a jb5 = a.jb();
                    if (jb5 != null) {
                        jb5.a(this.vY);
                        return;
                    }
                    return;
                }
                dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4;
                boolean ai = ai(this.vY.js().responseCode);
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.b(dVar);
                a jb6 = a.jb();
                if (jb6 != null) {
                    jb6.a(this.vY);
                }
                z = ai;
            } catch (Throwable th) {
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.b(dVar);
                a jb7 = a.jb();
                if (jb7 != null) {
                    jb7.a(this.vY);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=7, 385=7, 387=5, 377=7, 378=7, 380=7, 381=14, 382=7, 383=7] */
    private void f(int i, int i2, int i3) {
        boolean z;
        a jb;
        b bVar;
        boolean jh;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.vY.js().Dc && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.CH = i4 + 1;
            this.CD = i4;
            aj(i4);
            try {
                try {
                    try {
                        try {
                            this.CC = new b(this.vY);
                            this.CC.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.vY.js().Dd = -14;
                            dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.vY.a(dVar);
                            if (this.Cs <= 0 && this.CC != null) {
                                this.Cs = this.CC.je();
                            }
                            dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                            this.vY.a(dVar);
                            a jb2 = a.jb();
                            if (jb2 != null && this.CC != null && this.CC.jh()) {
                                jb2.a(this.vY);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.vY.js().Dd = -13;
                        z = true;
                        dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.vY.a(dVar);
                        if (this.Cs <= 0 && this.CC != null) {
                            this.Cs = this.CC.je();
                        }
                        dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb3 = a.jb();
                        if (jb3 != null && this.CC != null && this.CC.jh()) {
                            jb3.a(this.vY);
                        }
                    }
                } catch (SocketException e3) {
                    this.vY.js().Dd = -12;
                    z = true;
                    dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.vY.a(dVar);
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.a(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null && this.CC != null && this.CC.jh()) {
                        jb4.a(this.vY);
                    }
                }
                if (this.vY.js().responseCode == 200) {
                    if (jb != null) {
                        if (bVar != null) {
                            if (jh) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4;
                z = ai(this.vY.js().responseCode);
                this.vY.a(dVar);
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.a(dVar);
                a jb5 = a.jb();
                if (jb5 != null && this.CC != null && this.CC.jh()) {
                    jb5.a(this.vY);
                }
                z2 = z;
            } finally {
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.a(dVar);
                jb = a.jb();
                if (jb != null && this.CC != null && this.CC.jh()) {
                    jb.a(this.vY);
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

    public void g(int i, int i2, int i3) {
        if (this.vY.jr().jv()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [499=7, 500=7, 502=7, 503=14, 504=7, 505=7, 506=7, 507=7, 509=5] */
    private void h(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hk().hn().ho();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hk().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hk().hl().ho();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.vY.js().Dc && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.CD = i4;
            dVar.CH = i4 + 1;
            aj(i4);
            try {
                try {
                    try {
                        try {
                            this.CC = new b(this.vY);
                            this.CC.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.vY.js().Dd = -14;
                            dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.vY.a(dVar);
                            if (this.Cs <= 0 && this.CC != null) {
                                this.Cs = this.CC.je();
                            }
                            dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                            this.vY.a(dVar);
                            a jb = a.jb();
                            if (jb != null) {
                                jb.a(this.vY);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.vY.js().Dd = -13;
                        z = true;
                        dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.vY.a(dVar);
                        if (this.Cs <= 0 && this.CC != null) {
                            this.Cs = this.CC.je();
                        }
                        dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                        this.vY.a(dVar);
                        a jb2 = a.jb();
                        if (jb2 != null) {
                            jb2.a(this.vY);
                        }
                    }
                } catch (SocketException e3) {
                    this.vY.js().Dd = -12;
                    z = true;
                    dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.vY.a(dVar);
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.a(dVar);
                    a jb3 = a.jb();
                    if (jb3 != null) {
                        jb3.a(this.vY);
                    }
                } catch (Throwable th) {
                    this.vY.js().Dd = -10;
                    z = false;
                    dVar.CK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.vY.a(dVar);
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.a(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null) {
                        jb4.a(this.vY);
                    }
                }
                if (this.vY.js().responseCode == 200) {
                    if (this.Cs <= 0 && this.CC != null) {
                        this.Cs = this.CC.je();
                    }
                    dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                    this.vY.a(dVar);
                    a jb5 = a.jb();
                    if (jb5 != null) {
                        jb5.a(this.vY);
                        return;
                    }
                    return;
                }
                dVar.CK = String.valueOf(this.vY.js().responseCode) + "|retryCount:" + i4;
                z = ai(this.vY.js().responseCode);
                this.vY.a(dVar);
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.a(dVar);
                a jb6 = a.jb();
                if (jb6 != null) {
                    jb6.a(this.vY);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cs <= 0 && this.CC != null) {
                    this.Cs = this.CC.je();
                }
                dVar.CI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.vY.jr().getUrl(), this.vY.jr().aQ(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.CK), dVar.CO != null);
                this.vY.a(dVar);
                a jb7 = a.jb();
                if (jb7 != null) {
                    jb7.a(this.vY);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.CC != null) {
            this.CC.ji();
        }
    }

    public boolean jk() {
        if (this.vY == null) {
            return false;
        }
        return this.vY.js().Dc;
    }

    public void jl() {
        if (this.vY != null) {
            this.vY.js().Dc = true;
        }
    }

    public long jm() {
        if (this.Cs > 0) {
            return this.Cs;
        }
        if (this.CC == null) {
            return -1L;
        }
        return this.CC.je();
    }

    public long jn() {
        if (this.CC == null) {
            return -1L;
        }
        return this.CC.jf();
    }

    public long jg() {
        if (this.CC == null) {
            return -1L;
        }
        return this.CC.jg();
    }

    public long jo() {
        if (this.CC == null) {
            return -1L;
        }
        return this.CC.jd();
    }

    public long jp() {
        if (this.CC == null) {
            return -1L;
        }
        return this.CC.jc();
    }

    public int jq() {
        return this.CD;
    }

    private void aj(int i) {
        try {
            if (this.vY != null && i > 0) {
                this.vY.jr().y("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
