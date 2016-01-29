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
    private e oo;
    private a va;

    public c(e eVar) {
        this.oo = eVar;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Exception e;
        boolean z3;
        int fe = i3 <= 0 ? com.baidu.adp.framework.c.b.eZ().fc().fe() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eZ().getRetryCount();
        }
        int fe2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eZ().fa().fe() : i4;
        boolean z4 = false;
        this.va = new a(this.oo);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.vf = i5 + 1;
                z3 = this.va.a(str, hVar, fe, fe2, z, dVar, z2);
                try {
                    a("downloadfile", dVar);
                    return z3;
                } catch (FileNotFoundException e2) {
                    this.oo.hb().responseCode = -100;
                    i5++;
                    z4 = z3;
                } catch (Exception e3) {
                    e = e3;
                    this.oo.hb().responseCode = -10;
                    BdLog.e(e.getMessage());
                    i5++;
                    z4 = z3;
                }
            } catch (FileNotFoundException e4) {
                z3 = z4;
            } catch (Exception e5) {
                e = e5;
                z3 = z4;
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [244=6, 245=6, 246=6] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eZ().fc().fe();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eZ().fa().fe();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hb().vu && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        try {
                            dVar.vf = i4 + 1;
                            this.va = new a(this.oo);
                            this.va.a(i2, i3, dVar);
                        } catch (SocketException e) {
                            dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                            this.oo.hb().responseCode = -12;
                            this.oo.a(dVar);
                            dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                            this.oo.a(dVar);
                            z = true;
                        }
                    } catch (SocketTimeoutException e2) {
                        dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oo.hb().responseCode = -13;
                        this.oo.a(dVar);
                        dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                        this.oo.a(dVar);
                        z = true;
                    }
                    if (this.oo.hb().responseCode == 200) {
                        a(null, dVar);
                        dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                        this.oo.a(dVar);
                        return;
                    }
                    dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4;
                    z = ae(this.oo.hb().responseCode);
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                } catch (Exception e3) {
                    dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oo.hb().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                    return;
                }
            } catch (Throwable th) {
                dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                this.oo.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [316=7, 317=7, 318=7] */
    private void f(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eZ().fc().fe();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eZ().fa().fe();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hb().vu && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.vf = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.va = new a(this.oo);
                            this.va.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            this.oo.hb().responseCode = -14;
                            dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oo.a(dVar);
                            dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                            this.oo.a(dVar);
                            z = false;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oo.hb().responseCode = -13;
                        dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oo.a(dVar);
                        dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                        this.oo.a(dVar);
                        z = true;
                    }
                } catch (SocketException e3) {
                    this.oo.hb().responseCode = -12;
                    dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                    z = true;
                } catch (Throwable th) {
                    this.oo.hb().responseCode = -10;
                    dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                    z = false;
                }
                if (this.oo.hb().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4;
                z = ae(this.oo.hb().responseCode);
                this.oo.a(dVar);
            } finally {
                dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                this.oo.a(dVar);
            }
        }
    }

    private boolean ae(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.oo.ha().he()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [430=7, 431=7, 432=7] */
    private void h(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eZ().fc().fe();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eZ().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eZ().fa().fe();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oo.hb().vu && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.vf = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.va = new a(this.oo);
                            this.va.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            this.oo.hb().responseCode = -14;
                            dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oo.a(dVar);
                            dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                            this.oo.a(dVar);
                            z = false;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oo.hb().responseCode = -13;
                        dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oo.a(dVar);
                        dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                        this.oo.a(dVar);
                        z = true;
                    }
                } catch (SocketException e3) {
                    this.oo.hb().responseCode = -12;
                    dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                    z = true;
                } catch (Throwable th) {
                    this.oo.hb().responseCode = -10;
                    dVar.vi = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oo.a(dVar);
                    dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                    this.oo.a(dVar);
                    z = false;
                }
                if (this.oo.hb().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.vi = String.valueOf(String.valueOf(this.oo.hb().responseCode)) + "|retryCount:" + i4;
                z = ae(this.oo.hb().responseCode);
                this.oo.a(dVar);
            } finally {
                dVar.vg = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gz().d(this.oo.ha().getUrl(), TextUtils.isEmpty(dVar.vi));
                this.oo.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.va != null) {
            this.va.gT();
        }
    }

    public boolean gV() {
        if (this.oo == null) {
            return false;
        }
        return this.oo.hb().vu;
    }

    public void gW() {
        if (this.oo != null) {
            this.oo.hb().vu = true;
        }
    }

    public long gX() {
        if (this.va == null) {
            return -1L;
        }
        return this.va.gS();
    }

    public long gY() {
        if (this.va == null) {
            return -1L;
        }
        return this.va.gR();
    }

    public long gZ() {
        if (this.va == null) {
            return -1L;
        }
        return this.va.gQ();
    }

    private void a(String str, d dVar) {
        if (com.baidu.adp.b.a.mo() != null && dVar != null && this.oo.hb() != null) {
            String str2 = str == null ? this.oo.hb().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.vb + "; downloadSize = " + dVar.vc + "; url=" + dVar.url);
            com.baidu.adp.b.a.mo().a(str2, dVar.vb + 54, dVar.vc + 54, dVar.url);
        }
    }
}
