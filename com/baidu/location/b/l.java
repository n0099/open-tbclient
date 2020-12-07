package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public abstract class l {
    public static String c = null;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.location.c.h f1893a = null;
    public com.baidu.location.c.a b = null;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    final Handler d = new a();
    private String h = null;
    private String i = null;
    private boolean j = false;

    /* loaded from: classes26.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        l.this.a(message);
                        return;
                    case 62:
                    case 63:
                        l.this.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b extends com.baidu.location.e.f {

        /* renamed from: a  reason: collision with root package name */
        String f1895a = null;
        String b = null;
        long c = 0;
        long d = 0;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.h = com.baidu.location.e.l.e();
            if ((com.baidu.location.e.l.h || com.baidu.location.e.l.j) && l.this.h != null && l.this.i != null) {
                this.b += String.format(Locale.CHINA, "&ki=%s&sn=%s", l.this.h, l.this.i);
            }
            if (m.a().b()) {
                this.b += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.f1895a == null) {
                this.f1895a = ab.b();
            }
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            if (this.f1895a != null) {
                this.k.put(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, this.f1895a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str, long j) {
            this.b = str;
            this.d = System.currentTimeMillis();
            this.c = j;
            ExecutorService b = z.a().b();
            if (com.baidu.location.e.l.b()) {
                a(b, false, null);
            } else if (b != null) {
                a(b, com.baidu.location.e.l.f);
            } else {
                b(com.baidu.location.e.l.f);
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            BDLocation bDLocation;
            if (!z || this.j == null) {
                Message obtainMessage = l.this.d.obtainMessage(63);
                obtainMessage.obj = "HttpStatus error";
                obtainMessage.sendToTarget();
            } else {
                try {
                    String str = this.j;
                    l.c = str;
                    if (str.contains("enc") && m.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = m.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        BDLocation bDLocation2 = new BDLocation(str);
                        if (bDLocation2.getLocType() == 161) {
                            k.a().a(str);
                        }
                        bDLocation2.setOperators(com.baidu.location.c.b.a().h());
                        if (r.a().d()) {
                            bDLocation2.setDirection(r.a().e());
                        }
                        bDLocation = bDLocation2;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        BDLocation bDLocation3 = new BDLocation();
                        bDLocation3.setLocType(0);
                        bDLocation = bDLocation3;
                    }
                    this.f1895a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        Message obtainMessage2 = l.this.d.obtainMessage(63);
                        obtainMessage2.obj = "HttpStatus error";
                        obtainMessage2.sendToTarget();
                    } else {
                        long currentTimeMillis = (System.currentTimeMillis() - this.d) / 1000;
                        if (currentTimeMillis < 0) {
                            currentTimeMillis = 0;
                        }
                        if (this.c < 0) {
                            this.c = 0L;
                        }
                        bDLocation.setDelayTime(currentTimeMillis + this.c);
                        Message obtainMessage3 = l.this.d.obtainMessage(21);
                        obtainMessage3.obj = bDLocation;
                        obtainMessage3.sendToTarget();
                    }
                } catch (Exception e3) {
                    Message obtainMessage4 = l.this.d.obtainMessage(63);
                    obtainMessage4.obj = "HttpStatus error";
                    obtainMessage4.sendToTarget();
                }
            }
            if (this.k != null) {
                this.k.clear();
            }
        }
    }

    public String a(String str) {
        String l;
        if (this.h == null) {
            this.h = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.i == null) {
            this.i = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        if (this.b == null || !this.b.a()) {
            this.b = com.baidu.location.c.b.a().f();
        }
        if (this.f1893a == null || !this.f1893a.j()) {
            this.f1893a = com.baidu.location.c.i.a().o();
        }
        Location g = com.baidu.location.c.f.a().j() ? com.baidu.location.c.f.a().g() : null;
        if ((this.b == null || this.b.d() || this.b.c()) && ((this.f1893a == null || this.f1893a.a() == 0) && g == null)) {
            return null;
        }
        String b2 = b();
        if (k.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.e.l.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            b2 = b2 + "&lmd=" + b3;
            if (Build.VERSION.SDK_INT >= 28 && !this.j) {
                this.j = true;
                try {
                    if (com.baidu.location.f.getServiceContext().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        b2 = b2 + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        String str2 = ((this.f1893a == null || this.f1893a.a() == 0) && (l = com.baidu.location.c.i.a().l()) != null) ? l + b2 : b2;
        if (this.f) {
            this.f = false;
            return com.baidu.location.e.l.a(this.b, this.f1893a, g, str2, 0, true);
        }
        return com.baidu.location.e.l.a(this.b, this.f1893a, g, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.b.b.a().c();
        String format = com.baidu.location.c.i.a().i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.b.a().e()));
        if (Build.VERSION.SDK_INT >= 18) {
            String d = com.baidu.location.e.l.d();
            if (!TextUtils.isEmpty(d)) {
                format = format + "&qcip6c=" + d;
            }
        }
        if (this.e) {
            this.e = false;
            if (Build.VERSION.SDK_INT > 17) {
            }
        } else if (!this.g) {
            String e = ab.e();
            if (e != null) {
                format = format + e;
            }
            this.g = true;
        }
        return format + c2;
    }
}
