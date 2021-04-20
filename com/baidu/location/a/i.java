package com.baidu.location.a;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.mobstat.Config;
import com.googlecode.mp4parser.boxes.ultraviolet.BaseLocationBox;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class i {

    /* renamed from: c  reason: collision with root package name */
    public static String f6550c;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.location.b.h f6551a = null;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.location.b.a f6552b = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6554e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6555f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6556g = false;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f6553d = new a();

    /* renamed from: h  reason: collision with root package name */
    public String f6557h = null;
    public String i = null;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    i.this.a(message);
                } else if (i == 62 || i == 63) {
                    i.this.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends com.baidu.location.d.e {

        /* renamed from: a  reason: collision with root package name */
        public String f6559a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f6560b = null;

        public b() {
            this.k = new HashMap();
        }

        @Override // com.baidu.location.d.e
        public void a() {
            this.f6741h = com.baidu.location.d.j.c();
            if ((com.baidu.location.d.j.f6757h || com.baidu.location.d.j.j) && i.this.f6557h != null && i.this.i != null) {
                this.f6560b += String.format(Locale.CHINA, "&ki=%s&sn=%s", i.this.f6557h, i.this.i);
            }
            String encodeTp4 = Jni.encodeTp4(this.f6560b);
            this.f6560b = null;
            if (this.f6559a == null) {
                this.f6559a = w.b();
            }
            this.k.put(BaseLocationBox.TYPE, encodeTp4);
            String str = this.f6559a;
            if (str != null) {
                this.k.put("up", str);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.f6560b = str;
            b(com.baidu.location.d.j.f6755f);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.location.d.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            Map<String, Object> map;
            String str;
            BDLocation bDLocation;
            Message obtainMessage;
            if (z && (str = this.j) != null) {
                try {
                    i.f6550c = str;
                    try {
                        bDLocation = new BDLocation(str);
                        if (bDLocation.getLocType() == 161) {
                            h.a().a(str);
                        }
                        bDLocation.setOperators(com.baidu.location.b.b.a().h());
                        if (o.a().d()) {
                            bDLocation.setDirection(o.a().e());
                        }
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(0);
                    }
                    this.f6559a = null;
                    if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                        obtainMessage = i.this.f6553d.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                    } else {
                        obtainMessage = i.this.f6553d.obtainMessage(21);
                        obtainMessage.obj = bDLocation;
                    }
                    obtainMessage.sendToTarget();
                } catch (Exception unused2) {
                }
                map = this.k;
                if (map == null) {
                    map.clear();
                    return;
                }
                return;
            }
            Message obtainMessage2 = i.this.f6553d.obtainMessage(63);
            obtainMessage2.obj = "HttpStatus error";
            obtainMessage2.sendToTarget();
            map = this.k;
            if (map == null) {
            }
        }
    }

    public String a(String str) {
        com.baidu.location.b.h hVar;
        String l;
        if (this.f6557h == null) {
            this.f6557h = j.b(com.baidu.location.f.getServiceContext());
        }
        if (this.i == null) {
            this.i = j.c(com.baidu.location.f.getServiceContext());
        }
        com.baidu.location.b.a aVar = this.f6552b;
        if (aVar == null || !aVar.a()) {
            this.f6552b = com.baidu.location.b.b.a().f();
        }
        com.baidu.location.b.h hVar2 = this.f6551a;
        if (hVar2 == null || !hVar2.i()) {
            this.f6551a = com.baidu.location.b.i.a().o();
        }
        Location g2 = com.baidu.location.b.e.a().i() ? com.baidu.location.b.e.a().g() : null;
        com.baidu.location.b.a aVar2 = this.f6552b;
        if ((aVar2 == null || aVar2.d() || this.f6552b.c()) && (((hVar = this.f6551a) == null || hVar.a() == 0) && g2 == null)) {
            return null;
        }
        String b2 = b();
        if (h.a().d() == -2) {
            b2 = b2 + "&imo=1";
        }
        int b3 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
        if (b3 >= 0) {
            b2 = b2 + "&lmd=" + b3;
        }
        com.baidu.location.b.h hVar3 = this.f6551a;
        if ((hVar3 == null || hVar3.a() == 0) && (l = com.baidu.location.b.i.a().l()) != null) {
            b2 = l + b2;
        }
        String str2 = b2;
        if (this.f6555f) {
            this.f6555f = false;
            return com.baidu.location.d.j.a(this.f6552b, this.f6551a, g2, str2, 0, true);
        }
        return com.baidu.location.d.j.a(this.f6552b, this.f6551a, g2, str2, 0);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String c2 = com.baidu.location.a.a.a().c();
        String format = com.baidu.location.b.i.i() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(com.baidu.location.b.b.a().e()));
        if (this.f6554e) {
            this.f6554e = false;
            String q = com.baidu.location.b.i.a().q();
            if (!TextUtils.isEmpty(q) && !q.equals(Config.DEF_MAC_ID)) {
                format = String.format(Locale.CHINA, "%s&mac=%s", format, q.replace(":", ""));
            }
        } else if (!this.f6556g) {
            String e2 = w.e();
            if (e2 != null) {
                format = format + e2;
            }
            this.f6556g = true;
        }
        return format + c2;
    }
}
