package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e acl;
    private b aiX;
    private int aiY = 0;
    private long aiO = 0;

    public c(e eVar) {
        this.acl = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        this.aiX = new b(this.acl);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                dVar.ajc = i5 + 1;
                this.aiY = i5;
                boolean a = this.aiX.a(str, hVar, la, la2, z, dVar, z2);
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL = a.mL();
                if (mL != null) {
                    mL.a(this.acl);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.acl.nc().responseCode = -100;
                    dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.acl.a(dVar);
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL2 = a.mL();
                    if (mL2 != null) {
                        mL2.a(this.acl);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.acl);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.acl.nc().responseCode = -10;
                dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.acl.a(dVar);
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL4 = a.mL();
                if (mL4 != null) {
                    mL4.a(this.acl);
                }
            }
        }
        return false;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
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
        for (int i4 = 0; !this.acl.nc().ajv && z && i4 < i; i4++) {
            d dVar = new d();
            this.acl.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.aiY = i4;
                                dVar.ajc = i4 + 1;
                                dVar.ajm = 1;
                                this.aiX = new b(this.acl);
                                this.aiX.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.acl.nc().ajw = -19;
                                dVar.ajf = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.aiO <= 0 && this.aiX != null) {
                                    this.aiO = this.aiX.mO();
                                }
                                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                                this.acl.b(dVar);
                                a mL = a.mL();
                                if (mL != null) {
                                    mL.a(this.acl);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.acl.nc().ajw = -10;
                            BdLog.e(e2.getMessage());
                            if (this.aiO <= 0 && this.aiX != null) {
                                this.aiO = this.aiX.mO();
                            }
                            dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                            this.acl.b(dVar);
                            a mL2 = a.mL();
                            if (mL2 != null) {
                                mL2.a(this.acl);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.acl.nc().ajw = -13;
                        if (this.aiO <= 0 && this.aiX != null) {
                            this.aiO = this.aiX.mO();
                        }
                        dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                        this.acl.b(dVar);
                        a mL3 = a.mL();
                        if (mL3 != null) {
                            mL3.a(this.acl);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.acl.nc().ajw = -12;
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.b(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.acl);
                    }
                    z = true;
                }
                if (this.acl.nc().responseCode == 200) {
                    this.acl.b(dVar);
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.b(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.acl);
                        return;
                    }
                    return;
                }
                dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.acl.nc().responseCode);
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.b(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.acl);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.b(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.acl);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
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
        for (int i4 = 0; !this.acl.nc().ajv && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.ajc = i4 + 1;
            this.aiY = i4;
            try {
                try {
                    try {
                        this.aiX = new b(this.acl);
                        this.aiX.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.acl.nc().ajw = -14;
                        dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.acl.a(dVar);
                        if (this.aiO <= 0 && this.aiX != null) {
                            this.aiO = this.aiX.mO();
                        }
                        dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                        this.acl.a(dVar);
                        a mL = a.mL();
                        if (mL != null && this.aiX != null && this.aiX.mR()) {
                            mL.a(this.acl);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.acl.nc().ajw = -13;
                        z = true;
                        dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.acl.a(dVar);
                        if (this.aiO <= 0 && this.aiX != null) {
                            this.aiO = this.aiX.mO();
                        }
                        dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                        this.acl.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null && this.aiX != null && this.aiX.mR()) {
                            mL2.a(this.acl);
                        }
                    }
                } catch (SocketException e3) {
                    this.acl.nc().ajw = -12;
                    z = true;
                    dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.acl.a(dVar);
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null && this.aiX != null && this.aiX.mR()) {
                        mL3.a(this.acl);
                    }
                } catch (Throwable th) {
                    this.acl.nc().ajw = -10;
                    z = false;
                    dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.acl.a(dVar);
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null && this.aiX != null && this.aiX.mR()) {
                        mL4.a(this.acl);
                    }
                }
                if (this.acl.nc().responseCode == 200) {
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 == null || this.aiX == null || !this.aiX.mR()) {
                        return;
                    }
                    mL5.a(this.acl);
                    return;
                }
                dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.acl.nc().responseCode);
                this.acl.a(dVar);
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null && this.aiX != null && this.aiX.mR()) {
                    mL6.a(this.acl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null && this.aiX != null && this.aiX.mR()) {
                    mL7.a(this.acl);
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
        if (this.acl.nb().nf()) {
            n(i, i2, i3);
        } else {
            p(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
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
        for (int i4 = 0; !this.acl.nc().ajv && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.aiY = i4;
            dVar.ajc = i4 + 1;
            try {
                try {
                    try {
                        this.aiX = new b(this.acl);
                        this.aiX.c(i2, i3, dVar);
                    } catch (SocketTimeoutException e) {
                        this.acl.nc().ajw = -13;
                        z = true;
                        dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.acl.a(dVar);
                        if (this.aiO <= 0 && this.aiX != null) {
                            this.aiO = this.aiX.mO();
                        }
                        dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                        this.acl.a(dVar);
                        a mL = a.mL();
                        if (mL != null) {
                            mL.a(this.acl);
                        }
                    } catch (Throwable th) {
                        this.acl.nc().ajw = -10;
                        z = false;
                        dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.acl.a(dVar);
                        if (this.aiO <= 0 && this.aiX != null) {
                            this.aiO = this.aiX.mO();
                        }
                        dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                        this.acl.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null) {
                            mL2.a(this.acl);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.acl.nc().ajw = -14;
                    dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.acl.a(dVar);
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.acl);
                    }
                } catch (SocketException e3) {
                    this.acl.nc().ajw = -12;
                    z = true;
                    dVar.ajf = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.acl.a(dVar);
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.acl);
                    }
                }
                if (this.acl.nc().responseCode == 200) {
                    if (this.aiO <= 0 && this.aiX != null) {
                        this.aiO = this.aiX.mO();
                    }
                    dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                    this.acl.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.acl);
                        return;
                    }
                    return;
                }
                dVar.ajf = String.valueOf(this.acl.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.acl.nc().responseCode);
                this.acl.a(dVar);
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.acl);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiO <= 0 && this.aiX != null) {
                    this.aiO = this.aiX.mO();
                }
                dVar.ajd = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acl.nb().getUrl(), this.acl.nb().ap("Host"), TextUtils.isEmpty(dVar.ajf), dVar.ajj != null);
                this.acl.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.acl);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.aiX != null) {
            this.aiX.mS();
        }
    }

    public boolean mU() {
        if (this.acl == null) {
            return false;
        }
        return this.acl.nc().ajv;
    }

    public void mV() {
        if (this.acl != null) {
            this.acl.nc().ajv = true;
        }
    }

    public long mW() {
        if (this.aiO > 0) {
            return this.aiO;
        }
        if (this.aiX == null) {
            return -1L;
        }
        return this.aiX.mO();
    }

    public long mX() {
        if (this.aiX == null) {
            return -1L;
        }
        return this.aiX.mP();
    }

    public long mQ() {
        if (this.aiX == null) {
            return -1L;
        }
        return this.aiX.mQ();
    }

    public long mY() {
        if (this.aiX == null) {
            return -1L;
        }
        return this.aiX.mN();
    }

    public long mZ() {
        if (this.aiX == null) {
            return -1L;
        }
        return this.aiX.mM();
    }

    public int na() {
        return this.aiY;
    }
}
