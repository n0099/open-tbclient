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
    private e mA;

    /* renamed from: tv  reason: collision with root package name */
    private b f4tv;
    private int tw = 0;
    private long tk = 0;

    public c(e eVar) {
        this.mA = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int de = i3 <= 0 ? com.baidu.adp.framework.c.b.da().dd().de() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        int de2 = i4 <= 0 ? com.baidu.adp.framework.c.b.da().db().de() : i4;
        this.f4tv = new b(this.mA);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                dVar.tC = i5 + 1;
                this.tw = i5;
                boolean a = this.f4tv.a(str, hVar, de, de2, z, dVar, z2);
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP = a.eP();
                if (eP != null) {
                    eP.a(this.mA);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.mA.ff().responseCode = -100;
                    dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.mA.a(dVar);
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP2 = a.eP();
                    if (eP2 != null) {
                        eP2.a(this.mA);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP3 = a.eP();
                    if (eP3 != null) {
                        eP3.a(this.mA);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.mA.ff().responseCode = -10;
                dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.mA.a(dVar);
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP4 = a.eP();
                if (eP4 != null) {
                    eP4.a(this.mA);
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
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.mA.ff().tV && z && i4 < i; i4++) {
            d dVar = new d();
            this.mA.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.tw = i4;
                                dVar.tC = i4 + 1;
                                dVar.tM = 1;
                                this.f4tv = new b(this.mA);
                                this.f4tv.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.mA.ff().tW = -19;
                                dVar.tF = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.tk <= 0 && this.f4tv != null) {
                                    this.tk = this.f4tv.eS();
                                }
                                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                                this.mA.b(dVar);
                                a eP = a.eP();
                                if (eP != null) {
                                    eP.a(this.mA);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.mA.ff().tW = -10;
                            BdLog.e(e2.getMessage());
                            if (this.tk <= 0 && this.f4tv != null) {
                                this.tk = this.f4tv.eS();
                            }
                            dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                            this.mA.b(dVar);
                            a eP2 = a.eP();
                            if (eP2 != null) {
                                eP2.a(this.mA);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.mA.ff().tW = -13;
                        if (this.tk <= 0 && this.f4tv != null) {
                            this.tk = this.f4tv.eS();
                        }
                        dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                        this.mA.b(dVar);
                        a eP3 = a.eP();
                        if (eP3 != null) {
                            eP3.a(this.mA);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.mA.ff().tW = -12;
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.b(dVar);
                    a eP4 = a.eP();
                    if (eP4 != null) {
                        eP4.a(this.mA);
                    }
                    z = true;
                }
                if (this.mA.ff().responseCode == 200) {
                    this.mA.b(dVar);
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.b(dVar);
                    a eP5 = a.eP();
                    if (eP5 != null) {
                        eP5.a(this.mA);
                        return;
                    }
                    return;
                }
                dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4;
                boolean aa = aa(this.mA.ff().responseCode);
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.b(dVar);
                a eP6 = a.eP();
                if (eP6 != null) {
                    eP6.a(this.mA);
                }
                z = aa;
            } catch (Throwable th) {
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.b(dVar);
                a eP7 = a.eP();
                if (eP7 != null) {
                    eP7.a(this.mA);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mA.ff().tV && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.tC = i4 + 1;
            this.tw = i4;
            try {
                try {
                    try {
                        this.f4tv = new b(this.mA);
                        this.f4tv.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.mA.ff().tW = -14;
                        dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.mA.a(dVar);
                        if (this.tk <= 0 && this.f4tv != null) {
                            this.tk = this.f4tv.eS();
                        }
                        dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                        this.mA.a(dVar);
                        a eP = a.eP();
                        if (eP != null && this.f4tv != null && this.f4tv.eV()) {
                            eP.a(this.mA);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.mA.ff().tW = -13;
                        z = true;
                        dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.mA.a(dVar);
                        if (this.tk <= 0 && this.f4tv != null) {
                            this.tk = this.f4tv.eS();
                        }
                        dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                        this.mA.a(dVar);
                        a eP2 = a.eP();
                        if (eP2 != null && this.f4tv != null && this.f4tv.eV()) {
                            eP2.a(this.mA);
                        }
                    }
                } catch (SocketException e3) {
                    this.mA.ff().tW = -12;
                    z = true;
                    dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mA.a(dVar);
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP3 = a.eP();
                    if (eP3 != null && this.f4tv != null && this.f4tv.eV()) {
                        eP3.a(this.mA);
                    }
                } catch (Throwable th) {
                    this.mA.ff().tW = -10;
                    z = false;
                    dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.mA.a(dVar);
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP4 = a.eP();
                    if (eP4 != null && this.f4tv != null && this.f4tv.eV()) {
                        eP4.a(this.mA);
                    }
                }
                if (this.mA.ff().responseCode == 200) {
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP5 = a.eP();
                    if (eP5 == null || this.f4tv == null || !this.f4tv.eV()) {
                        return;
                    }
                    eP5.a(this.mA);
                    return;
                }
                dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4;
                z = aa(this.mA.ff().responseCode);
                this.mA.a(dVar);
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP6 = a.eP();
                if (eP6 != null && this.f4tv != null && this.f4tv.eV()) {
                    eP6.a(this.mA);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP7 = a.eP();
                if (eP7 != null && this.f4tv != null && this.f4tv.eV()) {
                    eP7.a(this.mA);
                }
                throw th2;
            }
        }
    }

    private boolean aa(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.mA.fe().fi()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.da().dd().de();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.da().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.da().db().de();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.mA.ff().tV && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.tw = i4;
            dVar.tC = i4 + 1;
            try {
                try {
                    try {
                        this.f4tv = new b(this.mA);
                        this.f4tv.c(i2, i3, dVar);
                    } catch (SocketTimeoutException e) {
                        this.mA.ff().tW = -13;
                        z = true;
                        dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.mA.a(dVar);
                        if (this.tk <= 0 && this.f4tv != null) {
                            this.tk = this.f4tv.eS();
                        }
                        dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                        this.mA.a(dVar);
                        a eP = a.eP();
                        if (eP != null) {
                            eP.a(this.mA);
                        }
                    } catch (Throwable th) {
                        this.mA.ff().tW = -10;
                        z = false;
                        dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.mA.a(dVar);
                        if (this.tk <= 0 && this.f4tv != null) {
                            this.tk = this.f4tv.eS();
                        }
                        dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                        this.mA.a(dVar);
                        a eP2 = a.eP();
                        if (eP2 != null) {
                            eP2.a(this.mA);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.mA.ff().tW = -14;
                    dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.mA.a(dVar);
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP3 = a.eP();
                    if (eP3 != null) {
                        eP3.a(this.mA);
                    }
                } catch (SocketException e3) {
                    this.mA.ff().tW = -12;
                    z = true;
                    dVar.tF = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.mA.a(dVar);
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP4 = a.eP();
                    if (eP4 != null) {
                        eP4.a(this.mA);
                    }
                }
                if (this.mA.ff().responseCode == 200) {
                    if (this.tk <= 0 && this.f4tv != null) {
                        this.tk = this.f4tv.eS();
                    }
                    dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                    this.mA.a(dVar);
                    a eP5 = a.eP();
                    if (eP5 != null) {
                        eP5.a(this.mA);
                        return;
                    }
                    return;
                }
                dVar.tF = String.valueOf(this.mA.ff().responseCode) + "|retryCount:" + i4;
                z = aa(this.mA.ff().responseCode);
                this.mA.a(dVar);
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP6 = a.eP();
                if (eP6 != null) {
                    eP6.a(this.mA);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.tk <= 0 && this.f4tv != null) {
                    this.tk = this.f4tv.eS();
                }
                dVar.tD = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eu().a(this.mA.fe().getUrl(), this.mA.fe().am("Host"), TextUtils.isEmpty(dVar.tF), dVar.tJ != null);
                this.mA.a(dVar);
                a eP7 = a.eP();
                if (eP7 != null) {
                    eP7.a(this.mA);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.f4tv != null) {
            this.f4tv.eW();
        }
    }

    public boolean isCancel() {
        if (this.mA == null) {
            return false;
        }
        return this.mA.ff().tV;
    }

    public void eY() {
        if (this.mA != null) {
            this.mA.ff().tV = true;
        }
    }

    public long eZ() {
        if (this.tk > 0) {
            return this.tk;
        }
        if (this.f4tv == null) {
            return -1L;
        }
        return this.f4tv.eS();
    }

    public long fa() {
        if (this.f4tv == null) {
            return -1L;
        }
        return this.f4tv.eT();
    }

    public long eU() {
        if (this.f4tv == null) {
            return -1L;
        }
        return this.f4tv.eU();
    }

    public long fb() {
        if (this.f4tv == null) {
            return -1L;
        }
        return this.f4tv.eR();
    }

    public long fc() {
        if (this.f4tv == null) {
            return -1L;
        }
        return this.f4tv.eQ();
    }

    public int fd() {
        return this.tw;
    }
}
