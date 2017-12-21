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
    private e nI;
    private b uO;
    private int uP = 0;
    private long uF = 0;

    public c(e eVar) {
        this.nI = eVar;
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
        this.uO = new b(this.nI);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uT = i5 + 1;
                this.uP = i5;
                z3 = this.uO.a(str, hVar, dw, dw2, z, dVar, z2);
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
                this.nI.fz().responseCode = -100;
                dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.nI.a(dVar);
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.a(dVar);
                a fh = a.fh();
                if (fh != null) {
                    fh.a(this.nI);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.nI.fz().responseCode = -10;
                    dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.nI.a(dVar);
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh2 = a.fh();
                    if (fh2 != null) {
                        fh2.a(this.nI);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nI);
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
        for (int i4 = 0; !this.nI.fz().vm && z && i4 < i; i4++) {
            d dVar = new d();
            this.nI.a(dVar);
            try {
                try {
                    try {
                        this.uP = i4;
                        dVar.uT = i4 + 1;
                        dVar.vd = 1;
                        this.uO = new b(this.nI);
                        this.uO.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.nI.fz().vn = -12;
                        if (this.uF <= 0 && this.uO != null) {
                            this.uF = this.uO.fk();
                        }
                        dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                        this.nI.b(dVar);
                        a fh = a.fh();
                        if (fh != null) {
                            fh.a(this.nI);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.nI.fz().vn = -13;
                        if (this.uF <= 0 && this.uO != null) {
                            this.uF = this.uO.fk();
                        }
                        dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                        this.nI.b(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null) {
                            fh2.a(this.nI);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.nI.fz().vn = -19;
                    dVar.uW = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.b(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nI);
                    }
                } catch (Exception e4) {
                    dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.nI.fz().vn = -10;
                    BdLog.e(e4.getMessage());
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.b(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null) {
                        fh4.a(this.nI);
                        return;
                    }
                    return;
                }
                if (this.nI.fz().responseCode == 200) {
                    b(null, dVar);
                    this.nI.b(dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.b(dVar);
                    a fh5 = a.fh();
                    if (fh5 != null) {
                        fh5.a(this.nI);
                        return;
                    }
                    return;
                }
                dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4;
                boolean ag = ag(this.nI.fz().responseCode);
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.b(dVar);
                a fh6 = a.fh();
                if (fh6 != null) {
                    fh6.a(this.nI);
                }
                z = ag;
            } catch (Throwable th) {
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.b(dVar);
                a fh7 = a.fh();
                if (fh7 != null) {
                    fh7.a(this.nI);
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
        for (int i4 = 0; !this.nI.fz().vm && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.uT = i4 + 1;
            this.uP = i4;
            try {
                try {
                    try {
                        try {
                            this.uO = new b(this.nI);
                            this.uO.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.nI.fz().vn = -14;
                            dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.nI.a(dVar);
                            if (this.uF <= 0 && this.uO != null) {
                                this.uF = this.uO.fk();
                            }
                            dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                            this.nI.a(dVar);
                            a fh = a.fh();
                            if (fh != null && this.uO != null && this.uO.fn()) {
                                fh.a(this.nI);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.nI.fz().vn = -13;
                        z = true;
                        dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.nI.a(dVar);
                        if (this.uF <= 0 && this.uO != null) {
                            this.uF = this.uO.fk();
                        }
                        dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                        this.nI.a(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null && this.uO != null && this.uO.fn()) {
                            fh2.a(this.nI);
                        }
                    }
                } catch (SocketException e3) {
                    this.nI.fz().vn = -12;
                    z = true;
                    dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nI.a(dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null && this.uO != null && this.uO.fn()) {
                        fh3.a(this.nI);
                    }
                } catch (Throwable th) {
                    this.nI.fz().vn = -10;
                    z = false;
                    dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.nI.a(dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null && this.uO != null && this.uO.fn()) {
                        fh4.a(this.nI);
                    }
                }
                if (this.nI.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh5 = a.fh();
                    if (fh5 == null || this.uO == null || !this.uO.fn()) {
                        return;
                    }
                    fh5.a(this.nI);
                    return;
                }
                dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4;
                z = ag(this.nI.fz().responseCode);
                this.nI.a(dVar);
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.a(dVar);
                a fh6 = a.fh();
                if (fh6 != null && this.uO != null && this.uO.fn()) {
                    fh6.a(this.nI);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.a(dVar);
                a fh7 = a.fh();
                if (fh7 != null && this.uO != null && this.uO.fn()) {
                    fh7.a(this.nI);
                }
                throw th2;
            }
        }
    }

    private boolean ag(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.nI.fy().fC()) {
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
        for (int i4 = 0; !this.nI.fz().vm && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.uP = i4;
            dVar.uT = i4 + 1;
            try {
                try {
                    try {
                        this.uO = new b(this.nI);
                        this.uO.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.nI.fz().vn = -14;
                        dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.nI.a(dVar);
                        if (this.uF <= 0 && this.uO != null) {
                            this.uF = this.uO.fk();
                        }
                        dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                        this.nI.a(dVar);
                        a fh = a.fh();
                        if (fh != null) {
                            fh.a(this.nI);
                        }
                    } catch (Throwable th) {
                        this.nI.fz().vn = -10;
                        z = false;
                        dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.nI.a(dVar);
                        if (this.uF <= 0 && this.uO != null) {
                            this.uF = this.uO.fk();
                        }
                        dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                        this.nI.a(dVar);
                        a fh2 = a.fh();
                        if (fh2 != null) {
                            fh2.a(this.nI);
                        }
                    }
                } catch (SocketException e2) {
                    this.nI.fz().vn = -12;
                    z = true;
                    dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.nI.a(dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh3 = a.fh();
                    if (fh3 != null) {
                        fh3.a(this.nI);
                    }
                } catch (SocketTimeoutException e3) {
                    this.nI.fz().vn = -13;
                    z = true;
                    dVar.uW = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nI.a(dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh4 = a.fh();
                    if (fh4 != null) {
                        fh4.a(this.nI);
                    }
                }
                if (this.nI.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.uF <= 0 && this.uO != null) {
                        this.uF = this.uO.fk();
                    }
                    dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                    this.nI.a(dVar);
                    a fh5 = a.fh();
                    if (fh5 != null) {
                        fh5.a(this.nI);
                        return;
                    }
                    return;
                }
                dVar.uW = String.valueOf(this.nI.fz().responseCode) + "|retryCount:" + i4;
                z = ag(this.nI.fz().responseCode);
                this.nI.a(dVar);
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.a(dVar);
                a fh6 = a.fh();
                if (fh6 != null) {
                    fh6.a(this.nI);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uF <= 0 && this.uO != null) {
                    this.uF = this.uO.fk();
                }
                dVar.uU = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eL().b(this.nI.fy().getUrl(), this.nI.fy().ah("Host"), TextUtils.isEmpty(dVar.uW), dVar.va != null);
                this.nI.a(dVar);
                a fh7 = a.fh();
                if (fh7 != null) {
                    fh7.a(this.nI);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.uO != null) {
            this.uO.fo();
        }
    }

    public boolean fq() {
        if (this.nI == null) {
            return false;
        }
        return this.nI.fz().vm;
    }

    public void fs() {
        if (this.nI != null) {
            this.nI.fz().vm = true;
        }
    }

    public long ft() {
        if (this.uF > 0) {
            return this.uF;
        }
        if (this.uO == null) {
            return -1L;
        }
        return this.uO.fk();
    }

    public long fu() {
        if (this.uO == null) {
            return -1L;
        }
        return this.uO.fl();
    }

    public long fm() {
        if (this.uO == null) {
            return -1L;
        }
        return this.uO.fm();
    }

    public long fv() {
        if (this.uO == null) {
            return -1L;
        }
        return this.uO.fj();
    }

    public long fw() {
        if (this.uO == null) {
            return -1L;
        }
        return this.uO.fi();
    }

    public int fx() {
        return this.uP;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.kh() != null && dVar != null && this.nI.fz() != null) {
            String str2 = str == null ? this.nI.fz().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.uQ + "; downloadSize = " + dVar.uR + "; url=" + dVar.url);
            ITrafficStatsNativeManager.kh().a(str2, dVar.uQ + 54, 54 + dVar.uR, dVar.url);
        }
    }
}
