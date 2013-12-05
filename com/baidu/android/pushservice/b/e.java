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
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.util.PushDatabase;
import com.baidu.android.pushservice.w;
import com.baidu.android.pushservice.y;
import com.baidu.zeus.Headers;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class e extends k {
    private static e e = null;
    private SQLiteDatabase c;
    private c d;
    private int f;
    private Location g;
    private int h;
    private String i;
    private String j;
    private String k;
    private TelephonyManager l;
    private WifiManager m;
    private LocationManager n;

    private e(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.f = 0;
        this.h = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        this.b = w.f;
        this.l = (TelephonyManager) context.getSystemService("phone");
        this.m = (WifiManager) context.getSystemService("wifi");
        this.k = y.a().c();
        this.n = (LocationManager) context.getSystemService(Headers.LOCATION);
    }

    public static e a(Context context) {
        if (e == null) {
            e = new e(context);
        }
        return e;
    }

    private SQLiteDatabase f() {
        try {
            if (this.c == null) {
                this.c = PushDatabase.getDb(this.f703a);
            }
        } catch (Exception e2) {
        }
        return this.c;
    }

    private void h() {
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
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.d("AppStatisticsSender", ">>> Completed update client info: ");
            Log.d("AppStatisticsSender", "    imei=" + this.i);
            Log.d("AppStatisticsSender", "    channelid=" + this.k);
            Log.d("AppStatisticsSender", "    cellid=" + this.h);
            Log.d("AppStatisticsSender", "    wifi=" + this.j);
            Log.d("AppStatisticsSender", "    location=" + this.g);
        }
    }

    private void i() {
        if (this.d == null || this.d.f700a.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f703a)) {
                Log.d("AppStatisticsSender", "stat info has no record, cancel sync database mStatInfo=" + this.d);
                return;
            }
            return;
        }
        for (d dVar : this.d.f700a) {
            PushDatabase.deleteStatisticsInfo(f(), dVar.f701a);
        }
        this.d = null;
    }

    @Override // com.baidu.android.pushservice.b.k
    protected void a(String str, List list) {
        com.baidu.android.pushservice.a.b.a(list);
        list.add(new BasicNameValuePair(PushConstants.EXTRA_METHOD, "appusestat"));
        list.add(new BasicNameValuePair("channel_token", y.a().d()));
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.d("AppStatisticsSender", "Sending statistics data: " + str);
        }
        list.add(new BasicNameValuePair("data", str));
    }

    @Override // com.baidu.android.pushservice.b.k
    boolean a() {
        return PushDatabase.getStatisticsInfoCounts(f()) != 0;
    }

    @Override // com.baidu.android.pushservice.b.k
    protected String b() {
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.d("AppStatisticsSender", "start productSendData");
        }
        h();
        this.d = new c();
        c cVar = this.d;
        int i = this.f;
        this.f = i + 1;
        cVar.a(i, this.g, this.h, this.j);
        List<com.baidu.android.pushservice.util.k> selectStatisticsInfo = PushDatabase.selectStatisticsInfo(f(), 10);
        if (selectStatisticsInfo == null || selectStatisticsInfo.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f703a)) {
                Log.d("AppStatisticsSender", "feedbackList is null, return null.");
            }
            return null;
        }
        for (com.baidu.android.pushservice.util.k kVar : selectStatisticsInfo) {
            d dVar = new d();
            com.baidu.android.pushservice.d a2 = com.baidu.android.pushservice.a.a(this.f703a).a(kVar.b);
            if (a2 != null) {
                dVar.b = a2.b;
                dVar.c = a2.c;
                dVar.f701a = kVar.f765a;
                dVar.d = kVar.c;
                dVar.e = kVar.d;
                dVar.f = kVar.e;
                dVar.g = kVar.f;
                dVar.h = kVar.g;
                dVar.i = kVar.h;
                if (com.baidu.android.pushservice.b.a(this.f703a)) {
                    try {
                        Log.d("AppStatisticsSender", ">>> Get one App statistics record: " + dVar.a().toString());
                    } catch (Exception e2) {
                        Log.d("AppStatisticsSender", ">>> Get one App statistics Exception!");
                    }
                }
                this.d.a(dVar);
            }
        }
        if (this.d.f700a.size() == 0) {
            if (com.baidu.android.pushservice.b.a(this.f703a)) {
                Log.d("AppStatisticsSender", "recordList num is 0.");
            }
            return null;
        }
        return this.d.a();
    }

    @Override // com.baidu.android.pushservice.b.k
    protected void c() {
        i();
    }

    @Override // com.baidu.android.pushservice.b.k
    protected void d() {
        if (com.baidu.android.pushservice.b.a(this.f703a)) {
            Log.d("AppStatisticsSender", "The last send if fail, maybe has network problem now. Abort task, try later.");
        }
        this.d = null;
    }

    @Override // com.baidu.android.pushservice.b.k
    boolean e() {
        return false;
    }
}
