package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e pW;
    private b wV;
    private int wW = 0;
    private long wM = 0;

    public c(e eVar) {
        this.pW = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dG = i3 <= 0 ? com.baidu.adp.framework.c.b.dC().dF().dG() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dC().getRetryCount();
        }
        int dG2 = i4 <= 0 ? com.baidu.adp.framework.c.b.dC().dD().dG() : i4;
        boolean z4 = false;
        this.wV = new b(this.pW);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.retry = i5 + 1;
                this.wW = i5;
                z3 = this.wV.a(str, hVar, dG, dG2, z, dVar, z2);
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
                this.pW.fK().responseCode = -100;
                dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.pW.a(dVar);
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.a(dVar);
                a ft = a.ft();
                if (ft != null) {
                    ft.a(this.pW);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.pW.fK().responseCode = -10;
                    dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.pW.a(dVar);
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft2 = a.ft();
                    if (ft2 != null) {
                        ft2.a(this.pW);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft3 = a.ft();
                    if (ft3 != null) {
                        ft3.a(this.pW);
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
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.dC().dF().dG();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dC().dD().dG();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.pW.fK().xs && z && i4 < i; i4++) {
            d dVar = new d();
            this.pW.a(dVar);
            try {
                try {
                    try {
                        this.wW = i4;
                        dVar.retry = i4 + 1;
                        dVar.xj = 1;
                        this.wV = new b(this.pW);
                        this.wV.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.pW.fK().xt = -12;
                        if (this.wM <= 0 && this.wV != null) {
                            this.wM = this.wV.fw();
                        }
                        dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                        this.pW.b(dVar);
                        a ft = a.ft();
                        if (ft != null) {
                            ft.a(this.pW);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.pW.fK().xt = -13;
                        if (this.wM <= 0 && this.wV != null) {
                            this.wM = this.wV.fw();
                        }
                        dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                        this.pW.b(dVar);
                        a ft2 = a.ft();
                        if (ft2 != null) {
                            ft2.a(this.pW);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.pW.fK().xt = -19;
                    dVar.xc = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.b(dVar);
                    a ft3 = a.ft();
                    if (ft3 != null) {
                        ft3.a(this.pW);
                    }
                } catch (Exception e4) {
                    dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.pW.fK().xt = -10;
                    BdLog.e(e4.getMessage());
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.b(dVar);
                    a ft4 = a.ft();
                    if (ft4 != null) {
                        ft4.a(this.pW);
                        return;
                    }
                    return;
                }
                if (this.pW.fK().responseCode == 200) {
                    b(null, dVar);
                    this.pW.b(dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.b(dVar);
                    a ft5 = a.ft();
                    if (ft5 != null) {
                        ft5.a(this.pW);
                        return;
                    }
                    return;
                }
                dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4;
                boolean ak = ak(this.pW.fK().responseCode);
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.b(dVar);
                a ft6 = a.ft();
                if (ft6 != null) {
                    ft6.a(this.pW);
                }
                z = ak;
            } catch (Throwable th) {
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.b(dVar);
                a ft7 = a.ft();
                if (ft7 != null) {
                    ft7.a(this.pW);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7, 361=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.dC().dF().dG();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dC().dD().dG();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.pW.fK().xs && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            this.wW = i4;
            try {
                try {
                    try {
                        try {
                            this.wV = new b(this.pW);
                            this.wV.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.pW.fK().xt = -14;
                            dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.pW.a(dVar);
                            if (this.wM <= 0 && this.wV != null) {
                                this.wM = this.wV.fw();
                            }
                            dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                            this.pW.a(dVar);
                            a ft = a.ft();
                            if (ft != null && this.wV != null && this.wV.fz()) {
                                ft.a(this.pW);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.pW.fK().xt = -13;
                        z = true;
                        dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.pW.a(dVar);
                        if (this.wM <= 0 && this.wV != null) {
                            this.wM = this.wV.fw();
                        }
                        dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                        this.pW.a(dVar);
                        a ft2 = a.ft();
                        if (ft2 != null && this.wV != null && this.wV.fz()) {
                            ft2.a(this.pW);
                        }
                    }
                } catch (SocketException e3) {
                    this.pW.fK().xt = -12;
                    z = true;
                    dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.pW.a(dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft3 = a.ft();
                    if (ft3 != null && this.wV != null && this.wV.fz()) {
                        ft3.a(this.pW);
                    }
                } catch (Throwable th) {
                    this.pW.fK().xt = -10;
                    z = false;
                    dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.pW.a(dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft4 = a.ft();
                    if (ft4 != null && this.wV != null && this.wV.fz()) {
                        ft4.a(this.pW);
                    }
                }
                if (this.pW.fK().responseCode == 200) {
                    b(null, dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft5 = a.ft();
                    if (ft5 == null || this.wV == null || !this.wV.fz()) {
                        return;
                    }
                    ft5.a(this.pW);
                    return;
                }
                dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4;
                z = ak(this.pW.fK().responseCode);
                this.pW.a(dVar);
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.a(dVar);
                a ft6 = a.ft();
                if (ft6 != null && this.wV != null && this.wV.fz()) {
                    ft6.a(this.pW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.a(dVar);
                a ft7 = a.ft();
                if (ft7 != null && this.wV != null && this.wV.fz()) {
                    ft7.a(this.pW);
                }
                throw th2;
            }
        }
    }

    private boolean ak(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.pW.fJ().fN()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7, 483=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.dC().dF().dG();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dC().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dC().dD().dG();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.pW.fK().xs && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.wW = i4;
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.wV = new b(this.pW);
                        this.wV.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.pW.fK().xt = -14;
                        dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.pW.a(dVar);
                        if (this.wM <= 0 && this.wV != null) {
                            this.wM = this.wV.fw();
                        }
                        dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                        this.pW.a(dVar);
                        a ft = a.ft();
                        if (ft != null) {
                            ft.a(this.pW);
                        }
                    } catch (Throwable th) {
                        this.pW.fK().xt = -10;
                        z = false;
                        dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.pW.a(dVar);
                        if (this.wM <= 0 && this.wV != null) {
                            this.wM = this.wV.fw();
                        }
                        dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                        this.pW.a(dVar);
                        a ft2 = a.ft();
                        if (ft2 != null) {
                            ft2.a(this.pW);
                        }
                    }
                } catch (SocketException e2) {
                    this.pW.fK().xt = -12;
                    z = true;
                    dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.pW.a(dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft3 = a.ft();
                    if (ft3 != null) {
                        ft3.a(this.pW);
                    }
                } catch (SocketTimeoutException e3) {
                    this.pW.fK().xt = -13;
                    z = true;
                    dVar.xc = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.pW.a(dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft4 = a.ft();
                    if (ft4 != null) {
                        ft4.a(this.pW);
                    }
                }
                if (this.pW.fK().responseCode == 200) {
                    b(null, dVar);
                    if (this.wM <= 0 && this.wV != null) {
                        this.wM = this.wV.fw();
                    }
                    dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                    this.pW.a(dVar);
                    a ft5 = a.ft();
                    if (ft5 != null) {
                        ft5.a(this.pW);
                        return;
                    }
                    return;
                }
                dVar.xc = String.valueOf(this.pW.fK().responseCode) + "|retryCount:" + i4;
                z = ak(this.pW.fK().responseCode);
                this.pW.a(dVar);
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.a(dVar);
                a ft6 = a.ft();
                if (ft6 != null) {
                    ft6.a(this.pW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.wM <= 0 && this.wV != null) {
                    this.wM = this.wV.fw();
                }
                dVar.xa = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eX().b(this.pW.fJ().getUrl(), this.pW.fJ().an("Host"), TextUtils.isEmpty(dVar.xc), dVar.xg != null);
                this.pW.a(dVar);
                a ft7 = a.ft();
                if (ft7 != null) {
                    ft7.a(this.pW);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.wV != null) {
            this.wV.fA();
        }
    }

    public boolean fC() {
        if (this.pW == null) {
            return false;
        }
        return this.pW.fK().xs;
    }

    public void fD() {
        if (this.pW != null) {
            this.pW.fK().xs = true;
        }
    }

    public long fE() {
        if (this.wM > 0) {
            return this.wM;
        }
        if (this.wV == null) {
            return -1L;
        }
        return this.wV.fw();
    }

    public long fF() {
        if (this.wV == null) {
            return -1L;
        }
        return this.wV.fx();
    }

    public long fy() {
        if (this.wV == null) {
            return -1L;
        }
        return this.wV.fy();
    }

    public long fG() {
        if (this.wV == null) {
            return -1L;
        }
        return this.wV.fv();
    }

    public long fH() {
        if (this.wV == null) {
            return -1L;
        }
        return this.wV.fu();
    }

    public int fI() {
        return this.wW;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.ku() != null && dVar != null && this.pW.fK() != null) {
            String str2 = str == null ? this.pW.fK().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.wX + "; downloadSize = " + dVar.wY + "; url=" + dVar.url);
            ITrafficStatsNativeManager.ku().a(str2, dVar.wX + 54, 54 + dVar.wY, dVar.url);
        }
    }
}
