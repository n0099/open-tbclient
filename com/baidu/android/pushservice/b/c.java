package com.baidu.android.pushservice.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.util.l;
import com.baidu.android.pushservice.y;
import com.baidu.zeus.Headers;
import java.util.List;
/* loaded from: classes.dex */
public class c extends d {
    private static c e = null;
    private SQLiteDatabase c;
    private a d;
    private int f;
    private Location g;
    private int h;
    private String i;
    private String j;
    private String k;
    private TelephonyManager l;
    private WifiManager m;
    private LocationManager n;

    private c(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.f = 0;
        this.h = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.l = (TelephonyManager) context.getSystemService("phone");
        this.m = (WifiManager) context.getSystemService("wifi");
        this.k = y.a().c();
        this.n = (LocationManager) context.getSystemService(Headers.LOCATION);
    }

    public static c a(Context context) {
        if (e == null) {
            e = new c(context);
        }
        return e;
    }

    private SQLiteDatabase f() {
        try {
            if (this.c == null) {
                this.c = com.baidu.android.pushservice.util.e.a(this.f595a);
            }
        } catch (Exception e2) {
        }
        return this.c;
    }

    private void g() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = this.l.getDeviceId();
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = y.a().c();
        }
        CellLocation cellLocation = this.l.getCellLocation();
        int phoneType = this.l.getPhoneType();
        int cid = phoneType == 1 ? ((GsmCellLocation) cellLocation).getCid() : phoneType == 2 ? ((CdmaCellLocation) cellLocation).getNetworkId() : 0;
        if (cid <= 0) {
            cid = this.h;
        }
        this.h = cid;
        String macAddress = this.m.getConnectionInfo().getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            macAddress = this.j;
        }
        this.j = macAddress;
        Location lastKnownLocation = this.n.getLastKnownLocation("gps");
        if (lastKnownLocation == null) {
            lastKnownLocation = this.g;
        }
        this.g = lastKnownLocation;
        if (com.baidu.android.pushservice.b.a(this.f595a)) {
            Log.d("AppStatisticsSender", ">>> Completed update client info: ");
            Log.d("AppStatisticsSender", "    imei=" + this.i);
            Log.d("AppStatisticsSender", "    channelid=" + this.k);
            Log.d("AppStatisticsSender", "    cellid=" + this.h);
            Log.d("AppStatisticsSender", "    wifi=" + this.j);
            Log.d("AppStatisticsSender", "    location=" + this.g);
        }
    }

    private void h() {
        if (this.d == null || this.d.f593a.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f595a)) {
                Log.d("AppStatisticsSender", "stat info has no record, cancel sync database mStatInfo=" + this.d);
                return;
            }
            return;
        }
        for (b bVar : this.d.f593a) {
            com.baidu.android.pushservice.util.e.b(f(), bVar.f594a);
        }
        this.d = null;
    }

    @Override // com.baidu.android.pushservice.b.d
    boolean a() {
        return com.baidu.android.pushservice.util.e.c(f()) != 0;
    }

    @Override // com.baidu.android.pushservice.b.d
    protected String b() {
        if (com.baidu.android.pushservice.b.a(this.f595a)) {
            Log.d("AppStatisticsSender", "start productSendData");
        }
        g();
        this.d = new a();
        a aVar = this.d;
        int i = this.f;
        this.f = i + 1;
        aVar.a(i, this.g, this.h, this.j);
        List<l> a2 = com.baidu.android.pushservice.util.e.a(f(), 10);
        if (a2 == null || a2.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f595a)) {
                Log.d("AppStatisticsSender", "feedbackList is null, return null.");
            }
            return null;
        }
        for (l lVar : a2) {
            b bVar = new b();
            com.baidu.android.pushservice.d a3 = com.baidu.android.pushservice.a.a(this.f595a).a(lVar.b);
            if (a3 != null) {
                bVar.b = a3.b;
                bVar.c = a3.c;
                bVar.f594a = lVar.f654a;
                bVar.d = lVar.c;
                bVar.e = lVar.d;
                bVar.f = lVar.e;
                bVar.g = lVar.f;
                bVar.h = lVar.g;
                bVar.i = lVar.h;
                if (com.baidu.android.pushservice.b.a(this.f595a)) {
                    try {
                        Log.d("AppStatisticsSender", ">>> Get one App statistics record: " + bVar.a().toString());
                    } catch (Exception e2) {
                        Log.d("AppStatisticsSender", ">>> Get one App statistics Exception!");
                    }
                }
                this.d.a(bVar);
            }
        }
        if (this.d.f593a.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f595a)) {
                Log.d("AppStatisticsSender", "recordList num is 0.");
            }
            return null;
        }
        return this.d.a();
    }

    @Override // com.baidu.android.pushservice.b.d
    protected void c() {
        h();
    }

    @Override // com.baidu.android.pushservice.b.d
    protected void d() {
        if (com.baidu.android.pushservice.b.a(this.f595a)) {
            Log.d("AppStatisticsSender", "The last send if fail, maybe has network problem now. Abort task, try later.");
        }
        this.d = null;
    }
}
