package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class d {
    private f oo;
    private b vn;
    private int vo = 0;
    private long ve = 0;

    public d(f fVar) {
        this.oo = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=4, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Exception e;
        boolean z3;
        FileNotFoundException e2;
        int ff = i3 <= 0 ? com.baidu.adp.framework.c.b.fa().fe().ff() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fa().getRetryCount();
        }
        int ff2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fa().fb().ff() : i4;
        boolean z4 = false;
        this.vn = new b(this.oo);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.vt = i5 + 1;
                this.vo = i5;
                z3 = this.vn.a(str, iVar, ff, ff2, z, eVar, z2);
                try {
                    b("downloadfile", eVar);
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ = a.gQ();
                    if (gQ != null) {
                        gQ.a(this.oo);
                        return z3;
                    }
                    return z3;
                } catch (FileNotFoundException e3) {
                    e2 = e3;
                    this.oo.hh().responseCode = -100;
                    eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.oo.a(eVar);
                    i5++;
                    z4 = z3;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        this.oo.hh().responseCode = -10;
                        eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oo.a(eVar);
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.a(eVar);
                        a gQ2 = a.gQ();
                        if (gQ2 != null) {
                            gQ2.a(this.oo);
                        }
                        i5++;
                        z4 = z3;
                    } finally {
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.a(eVar);
                        a gQ3 = a.gQ();
                        if (gQ3 != null) {
                            gQ3.a(this.oo);
                        }
                    }
                }
            } catch (FileNotFoundException e5) {
                e2 = e5;
                z3 = z4;
            } catch (Exception e6) {
                e = e6;
                z3 = z4;
            }
        }
        return z4;
    }

    public boolean a(String str, i iVar, int i, int i2, int i3, boolean z) {
        return a(str, iVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, IGET, INVOKE, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IPUT, IGET, INVOKE, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, IGET, INVOKE, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=7, 272=7, 274=7, 275=7, 276=7, 277=7, 278=7, 279=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fa().fe().ff();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fa().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fa().fb().ff();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hh().vK && z && i4 < i; i4++) {
            e eVar = new e();
            this.oo.a(eVar);
            try {
                try {
                    try {
                        this.vo = i4;
                        eVar.vt = i4 + 1;
                        eVar.vB = 1;
                        this.vn = new b(this.oo);
                        this.vn.a(i2, i3, eVar);
                    } catch (SocketTimeoutException e) {
                        eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oo.hh().vL = -13;
                        if (this.ve <= 0 && this.vn != null) {
                            this.ve = this.vn.gT();
                        }
                        eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.b(eVar);
                        a gQ = a.gQ();
                        if (gQ != null) {
                            gQ.a(this.oo);
                            z = true;
                        }
                        z = true;
                    } catch (Exception e2) {
                        eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oo.hh().vL = -10;
                        BdLog.e(e2.getMessage());
                        if (this.ve <= 0 && this.vn != null) {
                            this.ve = this.vn.gT();
                        }
                        eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.b(eVar);
                        a gQ2 = a.gQ();
                        if (gQ2 != null) {
                            gQ2.a(this.oo);
                            return;
                        }
                        return;
                    }
                } catch (IllegalStateException e3) {
                    this.oo.hh().vL = -19;
                    eVar.vw = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.b(eVar);
                    a gQ3 = a.gQ();
                    if (gQ3 != null) {
                        gQ3.a(this.oo);
                    }
                } catch (SocketException e4) {
                    eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.oo.hh().vL = -12;
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.b(eVar);
                    a gQ4 = a.gQ();
                    if (gQ4 != null) {
                        gQ4.a(this.oo);
                        z = true;
                    }
                    z = true;
                }
                if (this.oo.hh().responseCode == 200) {
                    b(null, eVar);
                    this.oo.b(eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.b(eVar);
                    a gQ5 = a.gQ();
                    if (gQ5 != null) {
                        gQ5.a(this.oo);
                        return;
                    }
                    return;
                }
                eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4;
                z = ad(this.oo.hh().responseCode);
                if (this.ve <= 0 && this.vn != null) {
                    this.ve = this.vn.gT();
                }
                eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                this.oo.b(eVar);
                a gQ6 = a.gQ();
                if (gQ6 != null) {
                    gQ6.a(this.oo);
                }
            } catch (Throwable th) {
                if (this.ve <= 0 && this.vn != null) {
                    this.ve = this.vn.gT();
                }
                eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                this.oo.b(eVar);
                a gQ7 = a.gQ();
                if (gQ7 != null) {
                    gQ7.a(this.oo);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=7, 356=7, 357=7, 358=7, 359=7] */
    private void f(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fa().fe().ff();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fa().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fa().fb().ff();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hh().vK && z && i4 < i; i4++) {
            e eVar = new e();
            eVar.vt = i4 + 1;
            this.vo = i4;
            try {
                try {
                    try {
                        try {
                            this.vn = new b(this.oo);
                            this.vn.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.oo.hh().vL = -13;
                            z = true;
                            eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.oo.a(eVar);
                            if (this.ve <= 0 && this.vn != null) {
                                this.ve = this.vn.gT();
                            }
                            eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                            this.oo.a(eVar);
                            a gQ = a.gQ();
                            if (gQ != null && this.vn != null && this.vn.gW()) {
                                gQ.a(this.oo);
                            }
                        }
                    } catch (UnsupportedOperationException e2) {
                        z = false;
                        this.oo.hh().vL = -14;
                        eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oo.a(eVar);
                        if (this.ve <= 0 && this.vn != null) {
                            this.ve = this.vn.gT();
                        }
                        eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.a(eVar);
                        a gQ2 = a.gQ();
                        if (gQ2 != null && this.vn != null && this.vn.gW()) {
                            gQ2.a(this.oo);
                        }
                    }
                } catch (SocketException e3) {
                    this.oo.hh().vL = -12;
                    z = true;
                    eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oo.a(eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ3 = a.gQ();
                    if (gQ3 != null && this.vn != null && this.vn.gW()) {
                        gQ3.a(this.oo);
                    }
                }
                if (this.oo.hh().responseCode == 200) {
                    b(null, eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ4 = a.gQ();
                    if (gQ4 == null || this.vn == null || !this.vn.gW()) {
                        return;
                    }
                    gQ4.a(this.oo);
                    return;
                }
                eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4;
                z = ad(this.oo.hh().responseCode);
                this.oo.a(eVar);
            } finally {
                if (this.ve <= 0 && this.vn != null) {
                    this.ve = this.vn.gT();
                }
                eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                this.oo.a(eVar);
                a gQ5 = a.gQ();
                if (gQ5 != null && this.vn != null && this.vn.gW()) {
                    gQ5.a(this.oo);
                }
            }
        }
    }

    private boolean ad(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.oo.hg().hk()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF, IGET, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=7, 478=7, 479=7, 480=7, 481=7] */
    private void h(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fa().fe().ff();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fa().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fa().fb().ff();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hh().vK && z && i4 < i; i4++) {
            e eVar = new e();
            this.vo = i4;
            eVar.vt = i4 + 1;
            try {
                try {
                    try {
                        this.vn = new b(this.oo);
                        this.vn.c(i2, i3, eVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.oo.hh().vL = -14;
                        eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oo.a(eVar);
                        if (this.ve <= 0 && this.vn != null) {
                            this.ve = this.vn.gT();
                        }
                        eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                        this.oo.a(eVar);
                        a gQ = a.gQ();
                        if (gQ != null) {
                            gQ.a(this.oo);
                        }
                    }
                } catch (SocketException e2) {
                    this.oo.hh().vL = -12;
                    z = true;
                    eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oo.a(eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ2 = a.gQ();
                    if (gQ2 != null) {
                        gQ2.a(this.oo);
                    }
                } catch (SocketTimeoutException e3) {
                    this.oo.hh().vL = -13;
                    z = true;
                    eVar.vw = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oo.a(eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ3 = a.gQ();
                    if (gQ3 != null) {
                        gQ3.a(this.oo);
                    }
                }
                if (this.oo.hh().responseCode == 200) {
                    b(null, eVar);
                    if (this.ve <= 0 && this.vn != null) {
                        this.ve = this.vn.gT();
                    }
                    eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                    this.oo.a(eVar);
                    a gQ4 = a.gQ();
                    if (gQ4 != null) {
                        gQ4.a(this.oo);
                        return;
                    }
                    return;
                }
                eVar.vw = String.valueOf(String.valueOf(this.oo.hh().responseCode)) + "|retryCount:" + i4;
                z = ad(this.oo.hh().responseCode);
                this.oo.a(eVar);
            } finally {
                if (this.ve <= 0 && this.vn != null) {
                    this.ve = this.vn.gT();
                }
                eVar.vu = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().a(this.oo.hg().getUrl(), this.oo.hg().ak("Host"), TextUtils.isEmpty(eVar.vw));
                this.oo.a(eVar);
                a gQ5 = a.gQ();
                if (gQ5 != null) {
                    gQ5.a(this.oo);
                }
            }
        }
    }

    public void cancel() {
        if (this.vn != null) {
            this.vn.gX();
        }
    }

    public boolean gZ() {
        if (this.oo == null) {
            return false;
        }
        return this.oo.hh().vK;
    }

    public void ha() {
        if (this.oo != null) {
            this.oo.hh().vK = true;
        }
    }

    public long hb() {
        if (this.ve > 0) {
            return this.ve;
        }
        if (this.vn == null) {
            return -1L;
        }
        return this.vn.gT();
    }

    public long hc() {
        if (this.vn == null) {
            return -1L;
        }
        return this.vn.gU();
    }

    public long gV() {
        if (this.vn == null) {
            return -1L;
        }
        return this.vn.gV();
    }

    public long hd() {
        if (this.vn == null) {
            return -1L;
        }
        return this.vn.gS();
    }

    public long he() {
        if (this.vn == null) {
            return -1L;
        }
        return this.vn.gR();
    }

    public int hf() {
        return this.vo;
    }

    private void b(String str, e eVar) {
        if (com.baidu.adp.b.a.mg() != null && eVar != null && this.oo.hh() != null) {
            String str2 = str == null ? this.oo.hh().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vp + "; downloadSize = " + eVar.vq + "; url=" + eVar.url);
            com.baidu.adp.b.a.mg().a(str2, eVar.vp + 54, eVar.vq + 54, eVar.url);
        }
    }
}
