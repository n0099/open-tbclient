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
    private b CD;
    private int CE = 0;
    private long Ct = 0;
    private e wc;

    public c(e eVar) {
        this.wc = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=7, 172=4, 173=4, 174=4, 175=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int hr = i3 <= 0 ? com.baidu.adp.framework.c.b.hn().hq().hr() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        int hr2 = i4 <= 0 ? com.baidu.adp.framework.c.b.hn().ho().hr() : i4;
        this.CD = new b(this.wc);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                try {
                    dVar.CI = i5 + 1;
                    this.CE = i5;
                    aB(i5);
                    boolean a = this.CD.a(str, hVar, hr, hr2, z, dVar, z2);
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ = a.iZ();
                    if (iZ != null) {
                        iZ.a(this.wc);
                    }
                    return a;
                } catch (Exception e) {
                    this.wc.jq().responseCode = -10;
                    dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.wc.a(dVar);
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ2 = a.iZ();
                    if (iZ2 != null) {
                        iZ2.a(this.wc);
                    }
                }
            } catch (FileNotFoundException e2) {
                try {
                    this.wc.jq().responseCode = -100;
                    dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.wc.a(dVar);
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ3 = a.iZ();
                    if (iZ3 != null) {
                        iZ3.a(this.wc);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ4 = a.iZ();
                    if (iZ4 != null) {
                        iZ4.a(this.wc);
                    }
                    throw th;
                }
            }
        }
        return false;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [269=7, 270=7, 272=7, 273=14, 274=7, 275=7, 276=7, 277=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.wc.jq().Dd && z && i4 < i; i4++) {
            d dVar = new d();
            this.wc.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.CE = i4;
                            dVar.CI = i4 + 1;
                            dVar.CU = 1;
                            aB(i4);
                            this.CD = new b(this.wc);
                            this.CD.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.wc.jq().De = -19;
                            dVar.CL = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Ct <= 0 && this.CD != null) {
                                this.Ct = this.CD.jc();
                            }
                            dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                            this.wc.b(dVar);
                            a iZ = a.iZ();
                            if (iZ != null) {
                                iZ.a(this.wc);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.wc.jq().De = -12;
                        if (this.Ct <= 0 && this.CD != null) {
                            this.Ct = this.CD.jc();
                        }
                        dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                        this.wc.b(dVar);
                        a iZ2 = a.iZ();
                        if (iZ2 != null) {
                            iZ2.a(this.wc);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.wc.jq().De = -13;
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.b(dVar);
                    a iZ3 = a.iZ();
                    if (iZ3 != null) {
                        iZ3.a(this.wc);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.wc.jq().De = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.b(dVar);
                    a iZ4 = a.iZ();
                    if (iZ4 != null) {
                        iZ4.a(this.wc);
                        return;
                    }
                    return;
                }
                if (this.wc.jq().responseCode == 200) {
                    this.wc.b(dVar);
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.b(dVar);
                    a iZ5 = a.iZ();
                    if (iZ5 != null) {
                        iZ5.a(this.wc);
                        return;
                    }
                    return;
                }
                dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4;
                boolean aA = aA(this.wc.jq().responseCode);
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.b(dVar);
                a iZ6 = a.iZ();
                if (iZ6 != null) {
                    iZ6.a(this.wc);
                }
                z = aA;
            } catch (Throwable th) {
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.b(dVar);
                a iZ7 = a.iZ();
                if (iZ7 != null) {
                    iZ7.a(this.wc);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [349=7, 350=7, 352=7, 353=14, 354=7, 355=7, 356=7, 357=7, 359=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        a iZ;
        b bVar;
        boolean jf;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.wc.jq().Dd && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.CI = i4 + 1;
            this.CE = i4;
            aB(i4);
            try {
                try {
                    try {
                        try {
                            this.CD = new b(this.wc);
                            this.CD.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.wc.jq().De = -14;
                            dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.wc.a(dVar);
                            if (this.Ct <= 0 && this.CD != null) {
                                this.Ct = this.CD.jc();
                            }
                            dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                            this.wc.a(dVar);
                            a iZ2 = a.iZ();
                            if (iZ2 != null && this.CD != null && this.CD.jf()) {
                                iZ2.a(this.wc);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.wc.jq().De = -13;
                        z = true;
                        dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.wc.a(dVar);
                        if (this.Ct <= 0 && this.CD != null) {
                            this.Ct = this.CD.jc();
                        }
                        dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                        this.wc.a(dVar);
                        a iZ3 = a.iZ();
                        if (iZ3 != null && this.CD != null && this.CD.jf()) {
                            iZ3.a(this.wc);
                        }
                    }
                } catch (SocketException e3) {
                    this.wc.jq().De = -12;
                    z = true;
                    dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.wc.a(dVar);
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ4 = a.iZ();
                    if (iZ4 != null && this.CD != null && this.CD.jf()) {
                        iZ4.a(this.wc);
                    }
                }
                if (this.wc.jq().responseCode == 200) {
                    if (iZ != null) {
                        if (bVar != null) {
                            if (jf) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4;
                z = aA(this.wc.jq().responseCode);
                this.wc.a(dVar);
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.a(dVar);
                a iZ5 = a.iZ();
                if (iZ5 != null && this.CD != null && this.CD.jf()) {
                    iZ5.a(this.wc);
                }
                z2 = z;
            } finally {
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.a(dVar);
                iZ = a.iZ();
                if (iZ != null && this.CD != null && this.CD.jf()) {
                    iZ.a(this.wc);
                }
            }
        }
    }

    private boolean aA(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.wc.jp().jt()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [471=7, 472=7, 474=7, 475=14, 476=7, 477=7, 478=7, 479=7, 481=5] */
    private void h(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.hn().hq().hr();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.hn().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.hn().ho().hr();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.wc.jq().Dd && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.CE = i4;
            dVar.CI = i4 + 1;
            aB(i4);
            try {
                try {
                    try {
                        try {
                            this.CD = new b(this.wc);
                            this.CD.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.wc.jq().De = -14;
                            dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.wc.a(dVar);
                            if (this.Ct <= 0 && this.CD != null) {
                                this.Ct = this.CD.jc();
                            }
                            dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                            this.wc.a(dVar);
                            a iZ = a.iZ();
                            if (iZ != null) {
                                iZ.a(this.wc);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.wc.jq().De = -13;
                        z = true;
                        dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.wc.a(dVar);
                        if (this.Ct <= 0 && this.CD != null) {
                            this.Ct = this.CD.jc();
                        }
                        dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                        this.wc.a(dVar);
                        a iZ2 = a.iZ();
                        if (iZ2 != null) {
                            iZ2.a(this.wc);
                        }
                    }
                } catch (SocketException e3) {
                    this.wc.jq().De = -12;
                    z = true;
                    dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.wc.a(dVar);
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ3 = a.iZ();
                    if (iZ3 != null) {
                        iZ3.a(this.wc);
                    }
                } catch (Throwable th) {
                    this.wc.jq().De = -10;
                    z = false;
                    dVar.CL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.wc.a(dVar);
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ4 = a.iZ();
                    if (iZ4 != null) {
                        iZ4.a(this.wc);
                    }
                }
                if (this.wc.jq().responseCode == 200) {
                    if (this.Ct <= 0 && this.CD != null) {
                        this.Ct = this.CD.jc();
                    }
                    dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                    this.wc.a(dVar);
                    a iZ5 = a.iZ();
                    if (iZ5 != null) {
                        iZ5.a(this.wc);
                        return;
                    }
                    return;
                }
                dVar.CL = String.valueOf(this.wc.jq().responseCode) + "|retryCount:" + i4;
                z = aA(this.wc.jq().responseCode);
                this.wc.a(dVar);
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.a(dVar);
                a iZ6 = a.iZ();
                if (iZ6 != null) {
                    iZ6.a(this.wc);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ct <= 0 && this.CD != null) {
                    this.Ct = this.CD.jc();
                }
                dVar.CJ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iF().a(this.wc.jp().getUrl(), this.wc.jp().aQ("Host"), TextUtils.isEmpty(dVar.CL), dVar.CP != null);
                this.wc.a(dVar);
                a iZ7 = a.iZ();
                if (iZ7 != null) {
                    iZ7.a(this.wc);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.CD != null) {
            this.CD.jg();
        }
    }

    public boolean ji() {
        if (this.wc == null) {
            return false;
        }
        return this.wc.jq().Dd;
    }

    public void jj() {
        if (this.wc != null) {
            this.wc.jq().Dd = true;
        }
    }

    public long jk() {
        if (this.Ct > 0) {
            return this.Ct;
        }
        if (this.CD == null) {
            return -1L;
        }
        return this.CD.jc();
    }

    public long jl() {
        if (this.CD == null) {
            return -1L;
        }
        return this.CD.jd();
    }

    public long je() {
        if (this.CD == null) {
            return -1L;
        }
        return this.CD.je();
    }

    public long jm() {
        if (this.CD == null) {
            return -1L;
        }
        return this.CD.jb();
    }

    public long jn() {
        if (this.CD == null) {
            return -1L;
        }
        return this.CD.ja();
    }

    public int jo() {
        return this.CE;
    }

    private void aB(int i) {
        try {
            if (this.wc != null && i > 0) {
                this.wc.jp().y("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
