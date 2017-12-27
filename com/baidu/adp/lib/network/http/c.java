package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class c {
    private e act;
    private b ajb;
    private int ajc = 0;
    private long aiS = 0;

    public c(e eVar) {
        this.act = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        boolean z4 = false;
        this.ajb = new b(this.act);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.ajg = i5 + 1;
                this.ajc = i5;
                z3 = this.ajb.a(str, hVar, la, la2, z, dVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", dVar);
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.act.nb().responseCode = -100;
                dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.act.a(dVar);
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.a(dVar);
                a mK = a.mK();
                if (mK != null) {
                    mK.a(this.act);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.act.nb().responseCode = -10;
                    dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.act.a(dVar);
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK2 = a.mK();
                    if (mK2 != null) {
                        mK2.a(this.act);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK3 = a.mK();
                    if (mK3 != null) {
                        mK3.a(this.act);
                    }
                }
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=7, 272=7, 274=7, 275=14, 276=7, 277=7, 278=7, 279=7] */
    public void m(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.act.nb().ajz && z && i4 < i; i4++) {
            d dVar = new d();
            this.act.a(dVar);
            try {
                try {
                    try {
                        this.ajc = i4;
                        dVar.ajg = i4 + 1;
                        dVar.ajq = 1;
                        this.ajb = new b(this.act);
                        this.ajb.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.act.nb().ajA = -12;
                        if (this.aiS <= 0 && this.ajb != null) {
                            this.aiS = this.ajb.mN();
                        }
                        dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                        this.act.b(dVar);
                        a mK = a.mK();
                        if (mK != null) {
                            mK.a(this.act);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.act.nb().ajA = -13;
                        if (this.aiS <= 0 && this.ajb != null) {
                            this.aiS = this.ajb.mN();
                        }
                        dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                        this.act.b(dVar);
                        a mK2 = a.mK();
                        if (mK2 != null) {
                            mK2.a(this.act);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.act.nb().ajA = -19;
                    dVar.ajj = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.b(dVar);
                    a mK3 = a.mK();
                    if (mK3 != null) {
                        mK3.a(this.act);
                    }
                } catch (Exception e4) {
                    dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.act.nb().ajA = -10;
                    BdLog.e(e4.getMessage());
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.b(dVar);
                    a mK4 = a.mK();
                    if (mK4 != null) {
                        mK4.a(this.act);
                        return;
                    }
                    return;
                }
                if (this.act.nb().responseCode == 200) {
                    b(null, dVar);
                    this.act.b(dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.b(dVar);
                    a mK5 = a.mK();
                    if (mK5 != null) {
                        mK5.a(this.act);
                        return;
                    }
                    return;
                }
                dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.act.nb().responseCode);
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.b(dVar);
                a mK6 = a.mK();
                if (mK6 != null) {
                    mK6.a(this.act);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.b(dVar);
                a mK7 = a.mK();
                if (mK7 != null) {
                    mK7.a(this.act);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7, 361=5] */
    private void n(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.act.nb().ajz && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.ajg = i4 + 1;
            this.ajc = i4;
            try {
                try {
                    try {
                        try {
                            this.ajb = new b(this.act);
                            this.ajb.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.act.nb().ajA = -14;
                            dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.act.a(dVar);
                            if (this.aiS <= 0 && this.ajb != null) {
                                this.aiS = this.ajb.mN();
                            }
                            dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                            this.act.a(dVar);
                            a mK = a.mK();
                            if (mK != null && this.ajb != null && this.ajb.mQ()) {
                                mK.a(this.act);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.act.nb().ajA = -13;
                        z = true;
                        dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.act.a(dVar);
                        if (this.aiS <= 0 && this.ajb != null) {
                            this.aiS = this.ajb.mN();
                        }
                        dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                        this.act.a(dVar);
                        a mK2 = a.mK();
                        if (mK2 != null && this.ajb != null && this.ajb.mQ()) {
                            mK2.a(this.act);
                        }
                    }
                } catch (SocketException e3) {
                    this.act.nb().ajA = -12;
                    z = true;
                    dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.act.a(dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK3 = a.mK();
                    if (mK3 != null && this.ajb != null && this.ajb.mQ()) {
                        mK3.a(this.act);
                    }
                } catch (Throwable th) {
                    this.act.nb().ajA = -10;
                    z = false;
                    dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.act.a(dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK4 = a.mK();
                    if (mK4 != null && this.ajb != null && this.ajb.mQ()) {
                        mK4.a(this.act);
                    }
                }
                if (this.act.nb().responseCode == 200) {
                    b(null, dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK5 = a.mK();
                    if (mK5 == null || this.ajb == null || !this.ajb.mQ()) {
                        return;
                    }
                    mK5.a(this.act);
                    return;
                }
                dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4;
                z = da(this.act.nb().responseCode);
                this.act.a(dVar);
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.a(dVar);
                a mK6 = a.mK();
                if (mK6 != null && this.ajb != null && this.ajb.mQ()) {
                    mK6.a(this.act);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.a(dVar);
                a mK7 = a.mK();
                if (mK7 != null && this.ajb != null && this.ajb.mQ()) {
                    mK7.a(this.act);
                }
                throw th2;
            }
        }
    }

    private boolean da(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void o(int i, int i2, int i3) {
        if (this.act.na().ne()) {
            n(i, i2, i3);
        } else {
            p(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7, 483=5] */
    private void p(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.act.nb().ajz && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.ajc = i4;
            dVar.ajg = i4 + 1;
            try {
                try {
                    try {
                        this.ajb = new b(this.act);
                        this.ajb.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.act.nb().ajA = -14;
                        dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.act.a(dVar);
                        if (this.aiS <= 0 && this.ajb != null) {
                            this.aiS = this.ajb.mN();
                        }
                        dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                        this.act.a(dVar);
                        a mK = a.mK();
                        if (mK != null) {
                            mK.a(this.act);
                        }
                    } catch (Throwable th) {
                        this.act.nb().ajA = -10;
                        z = false;
                        dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.act.a(dVar);
                        if (this.aiS <= 0 && this.ajb != null) {
                            this.aiS = this.ajb.mN();
                        }
                        dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                        this.act.a(dVar);
                        a mK2 = a.mK();
                        if (mK2 != null) {
                            mK2.a(this.act);
                        }
                    }
                } catch (SocketException e2) {
                    this.act.nb().ajA = -12;
                    z = true;
                    dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.act.a(dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK3 = a.mK();
                    if (mK3 != null) {
                        mK3.a(this.act);
                    }
                } catch (SocketTimeoutException e3) {
                    this.act.nb().ajA = -13;
                    z = true;
                    dVar.ajj = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.act.a(dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK4 = a.mK();
                    if (mK4 != null) {
                        mK4.a(this.act);
                    }
                }
                if (this.act.nb().responseCode == 200) {
                    b(null, dVar);
                    if (this.aiS <= 0 && this.ajb != null) {
                        this.aiS = this.ajb.mN();
                    }
                    dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                    this.act.a(dVar);
                    a mK5 = a.mK();
                    if (mK5 != null) {
                        mK5.a(this.act);
                        return;
                    }
                    return;
                }
                dVar.ajj = String.valueOf(this.act.nb().responseCode) + "|retryCount:" + i4;
                z = da(this.act.nb().responseCode);
                this.act.a(dVar);
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.a(dVar);
                a mK6 = a.mK();
                if (mK6 != null) {
                    mK6.a(this.act);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiS <= 0 && this.ajb != null) {
                    this.aiS = this.ajb.mN();
                }
                dVar.ajh = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mp().b(this.act.na().getUrl(), this.act.na().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajj), dVar.ajn != null);
                this.act.a(dVar);
                a mK7 = a.mK();
                if (mK7 != null) {
                    mK7.a(this.act);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ajb != null) {
            this.ajb.mR();
        }
    }

    public boolean mT() {
        if (this.act == null) {
            return false;
        }
        return this.act.nb().ajz;
    }

    public void mU() {
        if (this.act != null) {
            this.act.nb().ajz = true;
        }
    }

    public long mV() {
        if (this.aiS > 0) {
            return this.aiS;
        }
        if (this.ajb == null) {
            return -1L;
        }
        return this.ajb.mN();
    }

    public long mW() {
        if (this.ajb == null) {
            return -1L;
        }
        return this.ajb.mO();
    }

    public long mP() {
        if (this.ajb == null) {
            return -1L;
        }
        return this.ajb.mP();
    }

    public long mX() {
        if (this.ajb == null) {
            return -1L;
        }
        return this.ajb.mM();
    }

    public long mY() {
        if (this.ajb == null) {
            return -1L;
        }
        return this.ajb.mL();
    }

    public int mZ() {
        return this.ajc;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.rG() != null && dVar != null && this.act.nb() != null) {
            String str2 = str == null ? this.act.nb().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.ajd + "; downloadSize = " + dVar.aje + "; url=" + dVar.url);
            ITrafficStatsNativeManager.rG().a(str2, dVar.ajd + 54, 54 + dVar.aje, dVar.url);
        }
    }
}
