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
    private b Al;
    private e tF;
    private int Am = 0;
    private long Aa = 0;

    public c(e eVar) {
        this.tF = eVar;
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
        this.Al = new b(this.tF);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.Aq = i5 + 1;
                this.Am = i5;
                ac(i5);
                z3 = this.Al.a(str, hVar, gi, gi2, z, dVar, z2);
                if (!z3) {
                    try {
                        if (this.tF.il().AJ) {
                            this.tF.il().AK = -14;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        dVar.At = "responseCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tF.il().AK = -100;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT = a.hT();
                        if (hT != null) {
                            hT.a(this.tF);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        dVar.At = "responseCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        this.tF.il().AK = -19;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tF);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketException e3) {
                        e = e3;
                        dVar.At = "responseCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tF.il().AK = -12;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT3 = a.hT();
                        if (hT3 != null) {
                            hT3.a(this.tF);
                        }
                        i5++;
                        z4 = z3;
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        dVar.At = "responseCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tF.il().AK = -13;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT4 = a.hT();
                        if (hT4 != null) {
                            hT4.a(this.tF);
                        }
                        i5++;
                        z4 = z3;
                    } catch (IOException e5) {
                        e = e5;
                        dVar.At = "errorCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.tF.il().AK = -19;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT5 = a.hT();
                        if (hT5 != null) {
                            hT5.a(this.tF);
                        }
                        i5++;
                        z4 = z3;
                    } catch (Exception e6) {
                        e = e6;
                        try {
                            dVar.At = "errorCode:" + String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                            this.tF.il().AK = -10;
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                            this.tF.a(dVar);
                            a hT6 = a.hT();
                            if (hT6 != null) {
                                hT6.a(this.tF);
                            }
                            i5++;
                            z4 = z3;
                        } finally {
                            com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                            this.tF.a(dVar);
                            a hT7 = a.hT();
                            if (hT7 != null) {
                                hT7.a(this.tF);
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
        for (int i4 = 0; !this.tF.il().AJ && z && i4 < i; i4++) {
            d dVar = new d();
            this.tF.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.Am = i4;
                            dVar.Aq = i4 + 1;
                            dVar.AA = 1;
                            ac(i4);
                            this.Al = new b(this.tF);
                            this.Al.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.tF.il().AK = -19;
                            dVar.At = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.Aa <= 0 && this.Al != null) {
                                this.Aa = this.Al.hW();
                            }
                            dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                            this.tF.b(dVar);
                            a hT = a.hT();
                            if (hT != null) {
                                hT.a(this.tF);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.tF.il().AK = -12;
                        if (this.Aa <= 0 && this.Al != null) {
                            this.Aa = this.Al.hW();
                        }
                        dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.b(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tF);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.tF.il().AK = -13;
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.b(dVar);
                    a hT3 = a.hT();
                    if (hT3 != null) {
                        hT3.a(this.tF);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.tF.il().AK = -10;
                    BdLog.e(e4.getMessage());
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.b(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null) {
                        hT4.a(this.tF);
                        return;
                    }
                    return;
                }
                if (this.tF.il().responseCode == 200) {
                    this.tF.b(dVar);
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.b(dVar);
                    a hT5 = a.hT();
                    if (hT5 != null) {
                        hT5.a(this.tF);
                        return;
                    }
                    return;
                }
                dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.tF.il().responseCode);
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.b(dVar);
                a hT6 = a.hT();
                if (hT6 != null) {
                    hT6.a(this.tF);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.b(dVar);
                a hT7 = a.hT();
                if (hT7 != null) {
                    hT7.a(this.tF);
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
        for (int i4 = 0; !this.tF.il().AJ && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.Aq = i4 + 1;
            this.Am = i4;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Al = new b(this.tF);
                            this.Al.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tF.il().AK = -14;
                            dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tF.a(dVar);
                            if (this.Aa <= 0 && this.Al != null) {
                                this.Aa = this.Al.hW();
                            }
                            dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                            this.tF.a(dVar);
                            a hT2 = a.hT();
                            if (hT2 != null && this.Al != null && this.Al.hZ()) {
                                hT2.a(this.tF);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tF.il().AK = -13;
                        z = true;
                        dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tF.a(dVar);
                        if (this.Aa <= 0 && this.Al != null) {
                            this.Aa = this.Al.hW();
                        }
                        dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT3 = a.hT();
                        if (hT3 != null && this.Al != null && this.Al.hZ()) {
                            hT3.a(this.tF);
                        }
                    }
                } catch (SocketException e3) {
                    this.tF.il().AK = -12;
                    z = true;
                    dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tF.a(dVar);
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.a(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null && this.Al != null && this.Al.hZ()) {
                        hT4.a(this.tF);
                    }
                }
                if (this.tF.il().responseCode == 200) {
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
                dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4;
                z = ab(this.tF.il().responseCode);
                this.tF.a(dVar);
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.a(dVar);
                a hT5 = a.hT();
                if (hT5 != null && this.Al != null && this.Al.hZ()) {
                    hT5.a(this.tF);
                }
                z2 = z;
            } finally {
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.a(dVar);
                hT = a.hT();
                if (hT != null && this.Al != null && this.Al.hZ()) {
                    hT.a(this.tF);
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
        if (this.tF.ik().ip()) {
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
        for (int i4 = 0; !this.tF.il().AJ && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.Am = i4;
            dVar.Aq = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.Al = new b(this.tF);
                            this.Al.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.tF.il().AK = -14;
                            dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.tF.a(dVar);
                            if (this.Aa <= 0 && this.Al != null) {
                                this.Aa = this.Al.hW();
                            }
                            dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                            this.tF.a(dVar);
                            a hT = a.hT();
                            if (hT != null) {
                                hT.a(this.tF);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.tF.il().AK = -13;
                        z = true;
                        dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.tF.a(dVar);
                        if (this.Aa <= 0 && this.Al != null) {
                            this.Aa = this.Al.hW();
                        }
                        dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                        this.tF.a(dVar);
                        a hT2 = a.hT();
                        if (hT2 != null) {
                            hT2.a(this.tF);
                        }
                    }
                } catch (SocketException e3) {
                    this.tF.il().AK = -12;
                    z = true;
                    dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.tF.a(dVar);
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.a(dVar);
                    a hT3 = a.hT();
                    if (hT3 != null) {
                        hT3.a(this.tF);
                    }
                } catch (Throwable th) {
                    this.tF.il().AK = -10;
                    z = false;
                    dVar.At = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.tF.a(dVar);
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.a(dVar);
                    a hT4 = a.hT();
                    if (hT4 != null) {
                        hT4.a(this.tF);
                    }
                }
                if (this.tF.il().responseCode == 200) {
                    if (this.Aa <= 0 && this.Al != null) {
                        this.Aa = this.Al.hW();
                    }
                    dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                    this.tF.a(dVar);
                    a hT5 = a.hT();
                    if (hT5 != null) {
                        hT5.a(this.tF);
                        return;
                    }
                    return;
                }
                dVar.At = String.valueOf(this.tF.il().responseCode) + "|retryCount:" + i4;
                z = ab(this.tF.il().responseCode);
                this.tF.a(dVar);
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.a(dVar);
                a hT6 = a.hT();
                if (hT6 != null) {
                    hT6.a(this.tF);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.Aa <= 0 && this.Al != null) {
                    this.Aa = this.Al.hW();
                }
                dVar.Ar = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hx().a(this.tF.ik().getUrl(), this.tF.ik().aA(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.At), dVar.Ax != null);
                this.tF.a(dVar);
                a hT7 = a.hT();
                if (hT7 != null) {
                    hT7.a(this.tF);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.Al != null) {
            this.Al.ia();
        }
    }

    public boolean ic() {
        if (this.tF == null) {
            return false;
        }
        return this.tF.il().AJ;
    }

    public void ie() {
        if (this.tF != null) {
            this.tF.il().AJ = true;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public long m9if() {
        if (this.Aa > 0) {
            return this.Aa;
        }
        if (this.Al == null) {
            return -1L;
        }
        return this.Al.hW();
    }

    public long ig() {
        if (this.Al == null) {
            return -1L;
        }
        return this.Al.hX();
    }

    public long hY() {
        if (this.Al == null) {
            return -1L;
        }
        return this.Al.hY();
    }

    public long ih() {
        if (this.Al == null) {
            return -1L;
        }
        return this.Al.hV();
    }

    public long ii() {
        if (this.Al == null) {
            return -1L;
        }
        return this.Al.hU();
    }

    public int ij() {
        return this.Am;
    }

    private void ac(int i) {
        try {
            if (this.tF != null && i > 0) {
                this.tF.ik().q("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
