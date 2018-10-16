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
    private int CA = 0;
    private long Cq = 0;
    private b Cz;
    private e wa;

    public c(e eVar) {
        this.wa = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=7, 172=4, 173=4, 174=4, 175=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int hs = i3 <= 0 ? com.baidu.adp.framework.c.b.ho().hr().hs() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        int hs2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ho().hp().hs() : i4;
        this.Cz = new b(this.wa);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                try {
                    dVar.CE = i5 + 1;
                    this.CA = i5;
                    ak(i5);
                    boolean a = this.Cz.a(str, hVar, hs, hs2, z, dVar, z2);
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb = a.jb();
                    if (jb != null) {
                        jb.a(this.wa);
                    }
                    return a;
                } catch (Exception e) {
                    this.wa.js().responseCode = -10;
                    dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.wa.a(dVar);
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb2 = a.jb();
                    if (jb2 != null) {
                        jb2.a(this.wa);
                    }
                }
            } catch (FileNotFoundException e2) {
                try {
                    this.wa.js().responseCode = -100;
                    dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.wa.a(dVar);
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb3 = a.jb();
                    if (jb3 != null) {
                        jb3.a(this.wa);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null) {
                        jb4.a(this.wa);
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
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.wa.js().CZ && z && i4 < i; i4++) {
            d dVar = new d();
            this.wa.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.CA = i4;
                            dVar.CE = i4 + 1;
                            dVar.CO = 1;
                            ak(i4);
                            this.Cz = new b(this.wa);
                            this.Cz.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.wa.js().Da = -19;
                            dVar.CH = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Cq <= 0 && this.Cz != null) {
                                this.Cq = this.Cz.je();
                            }
                            dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                            this.wa.b(dVar);
                            a jb = a.jb();
                            if (jb != null) {
                                jb.a(this.wa);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.wa.js().Da = -12;
                        if (this.Cq <= 0 && this.Cz != null) {
                            this.Cq = this.Cz.je();
                        }
                        dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                        this.wa.b(dVar);
                        a jb2 = a.jb();
                        if (jb2 != null) {
                            jb2.a(this.wa);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.wa.js().Da = -13;
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.b(dVar);
                    a jb3 = a.jb();
                    if (jb3 != null) {
                        jb3.a(this.wa);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.wa.js().Da = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.b(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null) {
                        jb4.a(this.wa);
                        return;
                    }
                    return;
                }
                if (this.wa.js().responseCode == 200) {
                    this.wa.b(dVar);
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.b(dVar);
                    a jb5 = a.jb();
                    if (jb5 != null) {
                        jb5.a(this.wa);
                        return;
                    }
                    return;
                }
                dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.wa.js().responseCode);
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.b(dVar);
                a jb6 = a.jb();
                if (jb6 != null) {
                    jb6.a(this.wa);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.b(dVar);
                a jb7 = a.jb();
                if (jb7 != null) {
                    jb7.a(this.wa);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [349=7, 350=7, 352=7, 353=14, 354=7, 355=7, 356=7, 357=7, 359=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        a jb;
        b bVar;
        boolean jh;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.wa.js().CZ && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.CE = i4 + 1;
            this.CA = i4;
            ak(i4);
            try {
                try {
                    try {
                        try {
                            this.Cz = new b(this.wa);
                            this.Cz.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.wa.js().Da = -14;
                            dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.wa.a(dVar);
                            if (this.Cq <= 0 && this.Cz != null) {
                                this.Cq = this.Cz.je();
                            }
                            dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                            this.wa.a(dVar);
                            a jb2 = a.jb();
                            if (jb2 != null && this.Cz != null && this.Cz.jh()) {
                                jb2.a(this.wa);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.wa.js().Da = -13;
                        z = true;
                        dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.wa.a(dVar);
                        if (this.Cq <= 0 && this.Cz != null) {
                            this.Cq = this.Cz.je();
                        }
                        dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                        this.wa.a(dVar);
                        a jb3 = a.jb();
                        if (jb3 != null && this.Cz != null && this.Cz.jh()) {
                            jb3.a(this.wa);
                        }
                    }
                } catch (SocketException e3) {
                    this.wa.js().Da = -12;
                    z = true;
                    dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.wa.a(dVar);
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null && this.Cz != null && this.Cz.jh()) {
                        jb4.a(this.wa);
                    }
                }
                if (this.wa.js().responseCode == 200) {
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
                dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4;
                z = aj(this.wa.js().responseCode);
                this.wa.a(dVar);
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.a(dVar);
                a jb5 = a.jb();
                if (jb5 != null && this.Cz != null && this.Cz.jh()) {
                    jb5.a(this.wa);
                }
                z2 = z;
            } finally {
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.a(dVar);
                jb = a.jb();
                if (jb != null && this.Cz != null && this.Cz.jh()) {
                    jb.a(this.wa);
                }
            }
        }
    }

    private boolean aj(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.wa.jr().jv()) {
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
            i2 = com.baidu.adp.framework.c.b.ho().hr().hs();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ho().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ho().hp().hs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.wa.js().CZ && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.CA = i4;
            dVar.CE = i4 + 1;
            ak(i4);
            try {
                try {
                    try {
                        try {
                            this.Cz = new b(this.wa);
                            this.Cz.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.wa.js().Da = -14;
                            dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.wa.a(dVar);
                            if (this.Cq <= 0 && this.Cz != null) {
                                this.Cq = this.Cz.je();
                            }
                            dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                            this.wa.a(dVar);
                            a jb = a.jb();
                            if (jb != null) {
                                jb.a(this.wa);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.wa.js().Da = -13;
                        z = true;
                        dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.wa.a(dVar);
                        if (this.Cq <= 0 && this.Cz != null) {
                            this.Cq = this.Cz.je();
                        }
                        dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                        this.wa.a(dVar);
                        a jb2 = a.jb();
                        if (jb2 != null) {
                            jb2.a(this.wa);
                        }
                    }
                } catch (SocketException e3) {
                    this.wa.js().Da = -12;
                    z = true;
                    dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.wa.a(dVar);
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb3 = a.jb();
                    if (jb3 != null) {
                        jb3.a(this.wa);
                    }
                } catch (Throwable th) {
                    this.wa.js().Da = -10;
                    z = false;
                    dVar.CH = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.wa.a(dVar);
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb4 = a.jb();
                    if (jb4 != null) {
                        jb4.a(this.wa);
                    }
                }
                if (this.wa.js().responseCode == 200) {
                    if (this.Cq <= 0 && this.Cz != null) {
                        this.Cq = this.Cz.je();
                    }
                    dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                    this.wa.a(dVar);
                    a jb5 = a.jb();
                    if (jb5 != null) {
                        jb5.a(this.wa);
                        return;
                    }
                    return;
                }
                dVar.CH = String.valueOf(this.wa.js().responseCode) + "|retryCount:" + i4;
                z = aj(this.wa.js().responseCode);
                this.wa.a(dVar);
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.a(dVar);
                a jb6 = a.jb();
                if (jb6 != null) {
                    jb6.a(this.wa);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Cq <= 0 && this.Cz != null) {
                    this.Cq = this.Cz.je();
                }
                dVar.CF = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iG().a(this.wa.jr().getUrl(), this.wa.jr().aQ("Host"), TextUtils.isEmpty(dVar.CH), dVar.CL != null);
                this.wa.a(dVar);
                a jb7 = a.jb();
                if (jb7 != null) {
                    jb7.a(this.wa);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Cz != null) {
            this.Cz.ji();
        }
    }

    public boolean jk() {
        if (this.wa == null) {
            return false;
        }
        return this.wa.js().CZ;
    }

    public void jl() {
        if (this.wa != null) {
            this.wa.js().CZ = true;
        }
    }

    public long jm() {
        if (this.Cq > 0) {
            return this.Cq;
        }
        if (this.Cz == null) {
            return -1L;
        }
        return this.Cz.je();
    }

    public long jn() {
        if (this.Cz == null) {
            return -1L;
        }
        return this.Cz.jf();
    }

    public long jg() {
        if (this.Cz == null) {
            return -1L;
        }
        return this.Cz.jg();
    }

    public long jo() {
        if (this.Cz == null) {
            return -1L;
        }
        return this.Cz.jd();
    }

    public long jp() {
        if (this.Cz == null) {
            return -1L;
        }
        return this.Cz.jc();
    }

    public int jq() {
        return this.CA;
    }

    private void ak(int i) {
        try {
            if (this.wa != null && i > 0) {
                this.wa.jr().y("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
