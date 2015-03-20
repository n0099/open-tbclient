package com.baidu.location;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.au;
import com.baidu.location.u;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class aj implements a0, n {
    public static String er = null;
    public au.b ex = null;
    public u.a eu = null;
    private boolean es = true;
    private boolean ew = false;
    private boolean ev = false;
    private boolean eq = false;
    final Handler et = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t {
        String dH = null;
        String dG = null;

        public a() {
            this.cZ = new ArrayList();
        }

        @Override // com.baidu.location.t
        void X() {
            this.cX = c.m265for();
            String j = Jni.j(this.dG);
            if (ad.gX) {
                Log.i(a0.i, j);
            }
            an.a().a(j);
            this.dG = null;
            if (this.dH == null) {
                this.dH = q.C();
            }
            this.cZ.add(new BasicNameValuePair("bloc", j));
            if (this.dH != null) {
                this.cZ.add(new BasicNameValuePair("up", this.dH));
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", w.a(f.getServiceContext()), w.m362if(f.getServiceContext())));
            if (stringBuffer.length() > 0) {
                this.cZ.add(new BasicNameValuePair("ext", Jni.j(stringBuffer.toString())));
            }
            this.cZ.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis()))));
            g.h().i();
        }

        @Override // com.baidu.location.t
        /* renamed from: do */
        void mo112do(boolean z) {
            BDLocation bDLocation;
            if (!z || this.cY == null) {
                an.a().m184if("network exception");
                Message obtainMessage = aj.this.et.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String entityUtils = EntityUtils.toString(this.cY, "utf-8");
                    aj.er = entityUtils;
                    an.a().m184if(entityUtils);
                    try {
                        bDLocation = new BDLocation(entityUtils);
                        if (bDLocation.getLocType() == 161) {
                            g.h().m290try(bDLocation.getTime());
                            bDLocation.m8byte(u.au().az());
                            if (ah.bG().bI()) {
                                bDLocation.setDirection(ah.bG().bE());
                            }
                        }
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    Message obtainMessage2 = aj.this.et.obtainMessage(21);
                    obtainMessage2.obj = bDLocation;
                    obtainMessage2.sendToTarget();
                    this.dH = null;
                } catch (Exception e2) {
                    Message obtainMessage3 = aj.this.et.obtainMessage(63);
                    obtainMessage3.obj = "HttpStatus error";
                    obtainMessage3.sendToTarget();
                }
            }
            if (this.cZ != null) {
                this.cZ.clear();
            }
        }

        public void e(String str) {
            this.dG = str;
            R();
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ad.gO) {
                switch (message.what) {
                    case 21:
                        aj.this.mo113byte(message);
                        return;
                    case 62:
                    case 63:
                        aj.this.aA();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    abstract void aA();

    /* renamed from: byte */
    abstract void mo113byte(Message message);

    public String h(String str) {
        if (this.eu == null || !this.eu.m356if()) {
            this.eu = u.au().at();
        }
        if (this.eu != null) {
            c.m273if(a0.i, this.eu.m359try());
        } else {
            c.m273if(a0.i, "cellInfo null...");
        }
        if (this.ex == null || !this.ex.m221for()) {
            this.ex = au.cc().ch();
        }
        if (this.ex != null) {
            c.m273if(a0.i, this.ex.m220else());
        } else {
            c.m273if(a0.i, "wifi list null");
        }
        Location a0 = z.bc().aZ() ? z.bc().a0() : null;
        if ((this.eu == null || this.eu.m354do()) && ((this.ex == null || this.ex.m227try() == 0) && a0 == null)) {
            return null;
        }
        String p = k.q().p();
        String format = au.ca() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(u.au().aq()));
        if (this.es) {
            this.es = false;
            String cg = au.cc().cg();
            if (!TextUtils.isEmpty(cg)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, cg.replace(":", ""));
            }
            if (Build.VERSION.SDK_INT > 17) {
                format = au.cc().b9() ? String.format(Locale.CHINA, "%s&wfal=1", format) : String.format(Locale.CHINA, "%s&wfal=0", format);
            }
        } else if (!this.eq) {
            String z = q.z();
            if (z != null) {
                format = format + z;
            }
            this.eq = true;
        }
        String str2 = format + p;
        if (str != null) {
            str2 = str + str2;
        }
        return c.m270if(this.eu, this.ex, a0, str2, 0);
    }
}
