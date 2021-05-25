package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: c  reason: collision with root package name */
    public static String f6505c;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.location.c.h f6506a = null;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.location.c.a f6507b = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6509e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6510f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6511g = false;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f6508d = new a();

    /* renamed from: h  reason: collision with root package name */
    public String f6512h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f6513i = null;
    public boolean j = false;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i2 = message.what;
                if (i2 == 21) {
                    i.this.a(message);
                } else if (i2 == 62 || i2 == 63) {
                    i.this.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends com.baidu.location.e.e {

        /* renamed from: a  reason: collision with root package name */
        public String f6515a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f6516b = null;

        /* renamed from: c  reason: collision with root package name */
        public long f6517c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f6518d = 0;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.e.e
        public void a() {
            this.f6707h = com.baidu.location.e.k.e();
            if ((com.baidu.location.e.k.f6726h || com.baidu.location.e.k.j) && i.this.f6512h != null && i.this.f6513i != null) {
                this.f6516b += String.format(Locale.CHINA, "&ki=%s&sn=%s", i.this.f6512h, i.this.f6513i);
            }
            if (j.a().b()) {
                this.f6516b += "&enc=2";
            }
            String encodeTp4 = Jni.encodeTp4(this.f6516b);
            this.f6516b = null;
            if (this.f6515a == null) {
                this.f6515a = w.b();
            }
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            String str = this.f6515a;
            if (str != null) {
                this.k.put("up", str);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str, long j) {
            this.f6516b = str;
            this.f6518d = System.currentTimeMillis();
            this.f6517c = j;
            ExecutorService b2 = v.a().b();
            if (com.baidu.location.e.k.b()) {
                a(b2, false, null);
            } else if (b2 != null) {
                a(b2, com.baidu.location.e.k.f6724f);
            } else {
                b(com.baidu.location.e.k.f6724f);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
            r10 = r9.j;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.e.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            Map<String, Object> map;
            String str;
            BDLocation bDLocation;
            Message obtainMessage;
            if (z && str != null) {
                try {
                    i.f6505c = str;
                    if (str.contains("enc") && j.a().b()) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("enc")) {
                                str = j.a().a(jSONObject.getString("enc"));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            h.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.c.b.a().h());
                        if (n.a().d()) {
                            bDLocation.setDirection(n.a().e());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.f6515a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = i.this.f6508d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                    } else {
                        long currentTimeMillis = (System.currentTimeMillis() - this.f6518d) / 1000;
                        if (currentTimeMillis < 0) {
                            currentTimeMillis = 0;
                        }
                        if (this.f6517c < 0) {
                            this.f6517c = 0L;
                        }
                        bDLocation.setDelayTime(this.f6517c + currentTimeMillis);
                        obtainMessage = i.this.f6508d.obtainMessage(21);
                        obtainMessage.obj = bDLocation;
                    }
                    obtainMessage.sendToTarget();
                } catch (Exception unused) {
                }
                map = this.k;
                if (map == null) {
                    map.clear();
                    return;
                }
                return;
            }
            Message obtainMessage2 = i.this.f6508d.obtainMessage(63);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            map = this.k;
            if (map == null) {
            }
        }
    }

    public String a(String str) {
        com.baidu.location.c.h hVar;
        String l;
        if (this.f6512h == null) {
            this.f6512h = com.baidu.location.a.a.b(com.baidu.location.f.getServiceContext());
        }
        if (this.f6513i == null) {
            this.f6513i = com.baidu.location.a.a.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.c.a aVar = this.f6507b;
        if (aVar == null || !aVar.a()) {
            this.f6507b = com.baidu.location.c.b.a().f();
        }
        com.baidu.location.c.h hVar2 = this.f6506a;
        if (hVar2 == null || !hVar2.j()) {
            this.f6506a = com.baidu.location.c.i.a().o();
        }
        Location g2 = com.baidu.location.c.e.a().i() ? com.baidu.location.c.e.a().g() : null;
        com.baidu.location.c.a aVar2 = this.f6507b;
        if ((aVar2 == null || aVar2.d() || this.f6507b.c()) && (((hVar = this.f6506a) == null || hVar.a() == 0) && g2 == null)) {
            return null;
        }
        String b2 = b();
        if (h.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.e.k.b(com.baidu.location.f.getServiceContext());
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
        com.baidu.location.c.h hVar3 = this.f6506a;
        if ((hVar3 == null || hVar3.a() == 0) && (l = com.baidu.location.c.i.a().l()) != null) {
            b2 = l + b2;
        }
        String str2 = b2;
        if (this.f6510f) {
            this.f6510f = false;
            return com.baidu.location.e.k.a(this.f6507b, this.f6506a, g2, str2, 0, true);
        }
        return com.baidu.location.e.k.a(this.f6507b, this.f6506a, g2, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.b.a.a().c();
        String format = com.baidu.location.c.i.i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.c.b.a().e()));
        if (Build.VERSION.SDK_INT >= 18) {
            String d2 = com.baidu.location.e.k.d();
            if (!TextUtils.isEmpty(d2)) {
                format = format + "&qcip6c=" + d2;
            }
        }
        if (this.f6509e) {
            this.f6509e = false;
            int i2 = Build.VERSION.SDK_INT;
        } else if (!this.f6511g) {
            String e2 = w.e();
            if (e2 != null) {
                format = format + e2;
            }
            this.f6511g = true;
        }
        return format + c2;
    }
}
