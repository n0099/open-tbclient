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
    private e nH;
    private b uP;
    private int uQ = 0;
    private long uG = 0;

    public c(e eVar) {
        this.nH = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dw = i3 <= 0 ? com.baidu.adp.framework.c.b.ds().dv().dw() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        int dw2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ds().dt().dw() : i4;
        boolean z4 = false;
        this.uP = new b(this.nH);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uU = i5 + 1;
                this.uQ = i5;
                z3 = this.uP.a(str, hVar, dw, dw2, z, dVar, z2);
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
                this.nH.fz().responseCode = -100;
                dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.nH.a(dVar);
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.a(dVar);
                a fh = a.fh();
                if (fh != null) {
                    fh.a(this.nH);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.nH.fz().responseCode = -10;
                    dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.nH.a(dVar);
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh2 = a.fh();
                    if (fh2 != null) {
                        fh2.a(this.nH);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nH);
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
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.nH.fz().vn && z && i4 < i; i4++) {
            d dVar = new d();
            this.nH.a(dVar);
            try {
                try {
                    try {
                        this.uQ = i4;
                        dVar.uU = i4 + 1;
                        dVar.ve = 1;
                        this.uP = new b(this.nH);
                        this.uP.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.nH.fz().vo = -12;
                        if (this.uG <= 0 && this.uP != null) {
                            this.uG = this.uP.fk();
                        }
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                        this.nH.b(dVar);
                        a fh = a.fh();
                        if (fh != null) {
                            fh.a(this.nH);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.nH.fz().vo = -13;
                        if (this.uG <= 0 && this.uP != null) {
                            this.uG = this.uP.fk();
                        }
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                        this.nH.b(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null) {
                            fh2.a(this.nH);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.nH.fz().vo = -19;
                    dVar.uX = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.b(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nH);
                    }
                } catch (Exception e4) {
                    dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.nH.fz().vo = -10;
                    BdLog.e(e4.getMessage());
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.b(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null) {
                        fh4.a(this.nH);
                        return;
                    }
                    return;
                }
                if (this.nH.fz().responseCode == 200) {
                    b(null, dVar);
                    this.nH.b(dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.b(dVar);
                    a fh5 = a.fh();
                    if (fh5 != null) {
                        fh5.a(this.nH);
                        return;
                    }
                    return;
                }
                dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4;
                boolean ah = ah(this.nH.fz().responseCode);
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.b(dVar);
                a fh6 = a.fh();
                if (fh6 != null) {
                    fh6.a(this.nH);
                }
                z = ah;
            } catch (Throwable th) {
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.b(dVar);
                a fh7 = a.fh();
                if (fh7 != null) {
                    fh7.a(this.nH);
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
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nH.fz().vn && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.uU = i4 + 1;
            this.uQ = i4;
            try {
                try {
                    try {
                        try {
                            this.uP = new b(this.nH);
                            this.uP.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.nH.fz().vo = -14;
                            dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.nH.a(dVar);
                            if (this.uG <= 0 && this.uP != null) {
                                this.uG = this.uP.fk();
                            }
                            dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                            this.nH.a(dVar);
                            a fh = a.fh();
                            if (fh != null && this.uP != null && this.uP.fn()) {
                                fh.a(this.nH);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.nH.fz().vo = -13;
                        z = true;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.nH.a(dVar);
                        if (this.uG <= 0 && this.uP != null) {
                            this.uG = this.uP.fk();
                        }
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                        this.nH.a(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null && this.uP != null && this.uP.fn()) {
                            fh2.a(this.nH);
                        }
                    }
                } catch (SocketException e3) {
                    this.nH.fz().vo = -12;
                    z = true;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nH.a(dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null && this.uP != null && this.uP.fn()) {
                        fh3.a(this.nH);
                    }
                } catch (Throwable th) {
                    this.nH.fz().vo = -10;
                    z = false;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.nH.a(dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null && this.uP != null && this.uP.fn()) {
                        fh4.a(this.nH);
                    }
                }
                if (this.nH.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh5 = a.fh();
                    if (fh5 == null || this.uP == null || !this.uP.fn()) {
                        return;
                    }
                    fh5.a(this.nH);
                    return;
                }
                dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4;
                z = ah(this.nH.fz().responseCode);
                this.nH.a(dVar);
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.a(dVar);
                a fh6 = a.fh();
                if (fh6 != null && this.uP != null && this.uP.fn()) {
                    fh6.a(this.nH);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.a(dVar);
                a fh7 = a.fh();
                if (fh7 != null && this.uP != null && this.uP.fn()) {
                    fh7.a(this.nH);
                }
                throw th2;
            }
        }
    }

    private boolean ah(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.nH.fy().fC()) {
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
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nH.fz().vn && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.uQ = i4;
            dVar.uU = i4 + 1;
            try {
                try {
                    try {
                        this.uP = new b(this.nH);
                        this.uP.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.nH.fz().vo = -14;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.nH.a(dVar);
                        if (this.uG <= 0 && this.uP != null) {
                            this.uG = this.uP.fk();
                        }
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                        this.nH.a(dVar);
                        a fh = a.fh();
                        if (fh != null) {
                            fh.a(this.nH);
                        }
                    } catch (Throwable th) {
                        this.nH.fz().vo = -10;
                        z = false;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.nH.a(dVar);
                        if (this.uG <= 0 && this.uP != null) {
                            this.uG = this.uP.fk();
                        }
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                        this.nH.a(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null) {
                            fh2.a(this.nH);
                        }
                    }
                } catch (SocketException e2) {
                    this.nH.fz().vo = -12;
                    z = true;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.nH.a(dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nH);
                    }
                } catch (SocketTimeoutException e3) {
                    this.nH.fz().vo = -13;
                    z = true;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nH.a(dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null) {
                        fh4.a(this.nH);
                    }
                }
                if (this.nH.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.uG <= 0 && this.uP != null) {
                        this.uG = this.uP.fk();
                    }
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                    this.nH.a(dVar);
                    a fh5 = a.fh();
                    if (fh5 != null) {
                        fh5.a(this.nH);
                        return;
                    }
                    return;
                }
                dVar.uX = String.valueOf(this.nH.fz().responseCode) + "|retryCount:" + i4;
                z = ah(this.nH.fz().responseCode);
                this.nH.a(dVar);
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.a(dVar);
                a fh6 = a.fh();
                if (fh6 != null) {
                    fh6.a(this.nH);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uG <= 0 && this.uP != null) {
                    this.uG = this.uP.fk();
                }
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nH.fy().getUrl(), this.nH.fy().ah("Host"), TextUtils.isEmpty(dVar.uX), dVar.vb != null);
                this.nH.a(dVar);
                a fh7 = a.fh();
                if (fh7 != null) {
                    fh7.a(this.nH);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.uP != null) {
            this.uP.fo();
        }
    }

    public boolean fq() {
        if (this.nH == null) {
            return false;
        }
        return this.nH.fz().vn;
    }

    public void fs() {
        if (this.nH != null) {
            this.nH.fz().vn = true;
        }
    }

    public long ft() {
        if (this.uG > 0) {
            return this.uG;
        }
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.fk();
    }

    public long fu() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.fl();
    }

    public long fm() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.fm();
    }

    public long fv() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.fj();
    }

    public long fw() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.fi();
    }

    public int fx() {
        return this.uQ;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.kk() != null && dVar != null && this.nH.fz() != null) {
            String str2 = str == null ? this.nH.fz().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.uR + "; downloadSize = " + dVar.uS + "; url=" + dVar.url);
            ITrafficStatsNativeManager.kk().a(str2, dVar.uR + 54, 54 + dVar.uS, dVar.url);
        }
    }
}
