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
    private b Am;
    private e tG;
    private int An = 0;
    private long Ab = 0;

    public c(e eVar) {
        this.tG = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [199=15, 200=8, 201=8, 202=8, 203=8, 205=6] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int gi = i3 <= 0 ? com.baidu.adp.framework.c.b.ge().gh().gi() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        int gi2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ge().gf().gi() : i4;
        boolean z4 = false;
        this.Am = new b(this.tG);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.Ar = i5 + 1;
                this.An = i5;
                ac(i5);
                z3 = this.Am.a(str, hVar, gi, gi2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.tG.il().AK) {
                            this.tG.il().AM = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.Au = "responseCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tG.il().AM = -100;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT = a.hT();
                        if (hT != null) {
                            hT.a(this.tG);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.Au = "responseCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.tG.il().AM = -19;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tG);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e3) {
                        e = e3;
                        dVar.Au = "responseCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tG.il().AM = -12;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT3 = a.hT();
                        if (hT3 != null) {
                            hT3.a(this.tG);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        dVar.Au = "responseCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tG.il().AM = -13;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT4 = a.hT();
                        if (hT4 != null) {
                            hT4.a(this.tG);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e5) {
                        e = e5;
                        dVar.Au = "errorCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tG.il().AM = -19;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT5 = a.hT();
                        if (hT5 != null) {
                            hT5.a(this.tG);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e6) {
                        e = e6;
                        try {
                            dVar.Au = "errorCode:" + String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.tG.il().AM = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                            this.tG.a(dVar);
                            a hT6 = a.hT();
                            if (hT6 != null) {
                                hT6.a(this.tG);
                            }
                            i5++;
                            z4 = z3;
                        } finally {
                            com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                            this.tG.a(dVar);
                            a hT7 = a.hT();
                            if (hT7 != null) {
                                hT7.a(this.tG);
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
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.tG.il().AK && z && i4 < i; i4++) {
            d dVar = new d();
            this.tG.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.An = i4;
                            dVar.Ar = i4 + 1;
                            dVar.AB = 1;
                            ac(i4);
                            this.Am = new b(this.tG);
                            this.Am.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.tG.il().AM = -19;
                            dVar.Au = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Ab <= 0 && this.Am != null) {
                                this.Ab = this.Am.hW();
                            }
                            dVar.As = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                            this.tG.b(dVar);
                            a hT = a.hT();
                            if (hT != null) {
                                hT.a(this.tG);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.tG.il().AM = -12;
                        if (this.Ab <= 0 && this.Am != null) {
                            this.Ab = this.Am.hW();
                        }
                        dVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.b(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tG);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.tG.il().AM = -13;
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.b(dVar);
                    a hT3 = a.hT();
                    if (hT3 != null) {
                        hT3.a(this.tG);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.tG.il().AM = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.b(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null) {
                        hT4.a(this.tG);
                        return;
                    }
                    return;
                }
                if (this.tG.il().responseCode == 200) {
                    this.tG.b(dVar);
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.b(dVar);
                    a hT5 = a.hT();
                    if (hT5 != null) {
                        hT5.a(this.tG);
                        return;
                    }
                    return;
                }
                dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.tG.il().responseCode);
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.b(dVar);
                a hT6 = a.hT();
                if (hT6 != null) {
                    hT6.a(this.tG);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.b(dVar);
                a hT7 = a.hT();
                if (hT7 != null) {
                    hT7.a(this.tG);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=7, 385=7, 387=5, 377=7, 378=7, 380=7, 381=14, 382=7, 383=7] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a hT;
        b bVar;
        boolean hZ;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.tG.il().AK && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.Ar = i4 + 1;
            this.An = i4;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Am = new b(this.tG);
                            this.Am.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tG.il().AM = -14;
                            dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tG.a(dVar);
                            if (this.Ab <= 0 && this.Am != null) {
                                this.Ab = this.Am.hW();
                            }
                            dVar.As = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                            this.tG.a(dVar);
                            a hT2 = a.hT();
                            if (hT2 != null && this.Am != null && this.Am.hZ()) {
                                hT2.a(this.tG);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tG.il().AM = -13;
                        z = true;
                        dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tG.a(dVar);
                        if (this.Ab <= 0 && this.Am != null) {
                            this.Ab = this.Am.hW();
                        }
                        dVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT3 = a.hT();
                        if (hT3 != null && this.Am != null && this.Am.hZ()) {
                            hT3.a(this.tG);
                        }
                    }
                } catch (SocketException e3) {
                    this.tG.il().AM = -12;
                    z = true;
                    dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tG.a(dVar);
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.a(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null && this.Am != null && this.Am.hZ()) {
                        hT4.a(this.tG);
                    }
                }
                if (this.tG.il().responseCode == 200) {
                    if (hT != null) {
                        if (bVar != null) {
                            if (hZ) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4;
                z = ab(this.tG.il().responseCode);
                this.tG.a(dVar);
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.a(dVar);
                a hT5 = a.hT();
                if (hT5 != null && this.Am != null && this.Am.hZ()) {
                    hT5.a(this.tG);
                }
                z2 = z;
            } finally {
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.a(dVar);
                hT = a.hT();
                if (hT != null && this.Am != null && this.Am.hZ()) {
                    hT.a(this.tG);
                }
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.tG.ik().ip()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [499=7, 500=7, 502=7, 503=14, 504=7, 505=7, 506=7, 507=7, 509=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ge().gh().gi();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ge().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ge().gf().gi();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.tG.il().AK && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.An = i4;
            dVar.Ar = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Am = new b(this.tG);
                            this.Am.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tG.il().AM = -14;
                            dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tG.a(dVar);
                            if (this.Ab <= 0 && this.Am != null) {
                                this.Ab = this.Am.hW();
                            }
                            dVar.As = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                            this.tG.a(dVar);
                            a hT = a.hT();
                            if (hT != null) {
                                hT.a(this.tG);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tG.il().AM = -13;
                        z = true;
                        dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tG.a(dVar);
                        if (this.Ab <= 0 && this.Am != null) {
                            this.Ab = this.Am.hW();
                        }
                        dVar.As = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                        this.tG.a(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tG);
                        }
                    }
                } catch (SocketException e3) {
                    this.tG.il().AM = -12;
                    z = true;
                    dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tG.a(dVar);
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.a(dVar);
                    a hT3 = a.hT();
                    if (hT3 != null) {
                        hT3.a(this.tG);
                    }
                } catch (Throwable th) {
                    this.tG.il().AM = -10;
                    z = false;
                    dVar.Au = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.tG.a(dVar);
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.a(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null) {
                        hT4.a(this.tG);
                    }
                }
                if (this.tG.il().responseCode == 200) {
                    if (this.Ab <= 0 && this.Am != null) {
                        this.Ab = this.Am.hW();
                    }
                    dVar.As = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                    this.tG.a(dVar);
                    a hT5 = a.hT();
                    if (hT5 != null) {
                        hT5.a(this.tG);
                        return;
                    }
                    return;
                }
                dVar.Au = String.valueOf(this.tG.il().responseCode) + "|retryCount:" + i4;
                z = ab(this.tG.il().responseCode);
                this.tG.a(dVar);
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.a(dVar);
                a hT6 = a.hT();
                if (hT6 != null) {
                    hT6.a(this.tG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Ab <= 0 && this.Am != null) {
                    this.Ab = this.Am.hW();
                }
                dVar.As = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tG.ik().getUrl(), this.tG.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.Au), dVar.Ay != null);
                this.tG.a(dVar);
                a hT7 = a.hT();
                if (hT7 != null) {
                    hT7.a(this.tG);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Am != null) {
            this.Am.ia();
        }
    }

    public boolean ic() {
        if (this.tG == null) {
            return false;
        }
        return this.tG.il().AK;
    }

    public void ie() {
        if (this.tG != null) {
            this.tG.il().AK = true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public long m9if() {
        if (this.Ab > 0) {
            return this.Ab;
        }
        if (this.Am == null) {
            return -1L;
        }
        return this.Am.hW();
    }

    public long ig() {
        if (this.Am == null) {
            return -1L;
        }
        return this.Am.hX();
    }

    public long hY() {
        if (this.Am == null) {
            return -1L;
        }
        return this.Am.hY();
    }

    public long ih() {
        if (this.Am == null) {
            return -1L;
        }
        return this.Am.hV();
    }

    public long ii() {
        if (this.Am == null) {
            return -1L;
        }
        return this.Am.hU();
    }

    public int ij() {
        return this.An;
    }

    private void ac(int i) {
        try {
            if (this.tG != null && i > 0) {
                this.tG.ik().q("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
