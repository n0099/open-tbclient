package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends t {
    public static final int dj = 1;
    static o dl = null;
    private a dk;
    private Handler ds;
    ArrayList dr = null;
    boolean dm = false;
    long dp = 0;
    long dq = 0;
    int dn = 0;
    private int di = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        String dh = null;
        int df = 0;
        boolean dg = false;

        a() {
        }

        @Override // com.baidu.location.t
        void X() {
            this.c4 = this.dh;
            this.cX = c.m260do() + "?&qt=state&trtm=" + System.currentTimeMillis();
            this.c8 = 2;
        }

        public boolean af() {
            if (this.dg) {
                return true;
            }
            this.dh = af.c0().cU();
            if (this.dh == null) {
                return false;
            }
            this.dg = true;
            V();
            return true;
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            if (z) {
                try {
                    new File(this.dh).delete();
                    this.df = 0;
                } catch (Exception e) {
                }
            } else {
                this.df += 2;
            }
            this.dh = null;
            this.dg = false;
            o.this.ds.sendEmptyMessageDelayed(1, 1500L);
        }
    }

    public o() {
        this.ds = null;
        this.dk = null;
        this.cZ = new ArrayList();
        this.dk = new a();
        this.c8 = 2;
        this.ds = new Handler() { // from class: com.baidu.location.o.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (ad.gO) {
                    switch (message.what) {
                        case 1:
                            o.this.ai();
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public static o ah() {
        if (dl == null) {
            dl = new o();
        }
        return dl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        if (c6 >= 6 || this.di >= 10 || !az.m252do().m255int()) {
            this.di = 0;
            return;
        }
        this.di++;
        if (ag()) {
            return;
        }
        this.di = 0;
    }

    @Override // com.baidu.location.t
    void X() {
        this.cZ.add(new BasicNameValuePair("qt", "cltr"));
        try {
            this.cZ.add(new BasicNameValuePair(LoginActivityConfig.INFO, Jni.j(a2.cC().cD())));
        } catch (Exception e) {
        }
        for (int i = 0; i < this.dr.size(); i++) {
            this.cZ.add(new BasicNameValuePair("cltr[" + i + "]", (String) this.dr.get(i)));
        }
        this.cZ.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis()))));
    }

    public boolean ag() {
        if (au.ca()) {
            if (this.dk.df > 2) {
                a aVar = this.dk;
                aVar.df--;
                return m315for(true);
            } else if (this.dk.af()) {
                return true;
            } else {
                return m315for(true);
            }
        }
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    public void m314do(int i) {
        this.ds.sendEmptyMessageDelayed(i, 500L);
    }

    @Override // com.baidu.location.t
    /* renamed from: do */
    void mo112do(boolean z) {
        if (!z || this.cY == null) {
            this.dp = 0L;
        } else if (this.dr != null) {
            this.dr.clear();
        }
        if (this.cZ != null) {
            this.cZ.clear();
        }
        this.dm = false;
        this.ds.sendEmptyMessageDelayed(1, 1500L);
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m315for(boolean z) {
        if (this.dm) {
            return true;
        }
        if (System.currentTimeMillis() - this.dp < 7200000) {
            return false;
        }
        if (System.currentTimeMillis() - this.dq > 3600000) {
            this.dn = 0;
        }
        if ((this.dn <= 5 || !z) && au.ca()) {
            if (az.m252do().m255int() || !z) {
                if (this.dr == null || this.dr.size() < 1) {
                    String m257case = c.m257case();
                    if (m257case == null) {
                        return false;
                    }
                    int i = 0;
                    while (true) {
                        if (i < 2) {
                            String l = Jni.l(m257case);
                            if (l == null) {
                                this.dp = System.currentTimeMillis();
                                break;
                            }
                            if (this.dr == null) {
                                this.dr = new ArrayList();
                            }
                            this.dr.add(l);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                if (this.dr == null || this.dr.size() <= 0) {
                    return false;
                }
                this.dn++;
                this.dq = System.currentTimeMillis();
                this.dm = true;
                R();
                return true;
            }
            return false;
        }
        return false;
    }
}
