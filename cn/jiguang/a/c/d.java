package cn.jiguang.a.c;

import android.content.Context;
import cn.jiguang.a.a.c.i;
import cn.jiguang.d.d.aa;
import java.io.Serializable;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements Runnable {
    private Context a;
    private int b;

    public d(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            aa.c(this.a);
            cn.jiguang.e.c.b("ReportHelper", "periodTasks...");
            if (cn.jiguang.d.a.d.d(this.a)) {
                Context context = this.a;
                cn.jiguang.g.b.a b = cn.jiguang.d.a.d.b(context, new cn.jiguang.g.b.a().a("last_report_device_info", (Serializable) 0L).a("lbs_report_enable", (Serializable) true).a("last_collection_location", (Serializable) 0L).a("location_report_delay", (Serializable) 0L).a("location_collect_frequency", (Serializable) 900000L).a("last_check_userapp_status", (Serializable) 0L).a("nb_upload", (Serializable) false).a("nb_lasttime", (Serializable) 0L).a("app_running_collect_enable", (Serializable) true).a("app_running_collect_interval", (Serializable) 3600000L).a("app_running_last_collect_time", (Serializable) 0L).a("app_running_collect_app_type", (Serializable) 1).a("app_running_collect_process_type", (Serializable) 1).a("battery_last_collect_time", (Serializable) 0L));
                cn.jiguang.g.b.a aVar = new cn.jiguang.g.b.a();
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = currentTimeMillis - ((Long) b.b("last_report_device_info", 0L)).longValue() > 86400000;
                boolean booleanValue = ((Boolean) b.b("lbs_report_enable", true)).booleanValue();
                boolean z2 = false;
                if (booleanValue) {
                    long longValue = ((Long) b.b("last_collection_location", 0L)).longValue();
                    long longValue2 = ((Long) b.b("location_collect_frequency", 900000L)).longValue();
                    if (longValue <= 0) {
                        long longValue3 = ((Long) b.b("location_report_delay", 0L)).longValue();
                        if (longValue3 > 0) {
                            longValue = (currentTimeMillis + longValue3) - longValue2;
                            aVar.a("last_collection_location", Long.valueOf(longValue));
                        }
                    }
                    if (currentTimeMillis - longValue >= longValue2) {
                        aVar.a("last_collection_location", Long.valueOf(currentTimeMillis));
                        z2 = true;
                    }
                }
                boolean z3 = false;
                if (currentTimeMillis - ((Long) b.b("last_check_userapp_status", 0L)).longValue() > 3600000) {
                    aVar.a("last_check_userapp_status", Long.valueOf(currentTimeMillis));
                    z3 = true;
                }
                boolean booleanValue2 = ((Boolean) b.b("nb_upload", false)).booleanValue();
                if (booleanValue2 && (booleanValue2 = cn.jiguang.g.a.e(context).toUpperCase().startsWith("WIFI"))) {
                    booleanValue2 = currentTimeMillis - ((Long) b.b("nb_lasttime", 0L)).longValue() > 3600000;
                }
                boolean booleanValue3 = ((Boolean) b.b("app_running_collect_enable", true)).booleanValue();
                int i = 1;
                int i2 = 1;
                if (booleanValue3) {
                    long longValue4 = ((Long) b.b("app_running_last_collect_time", 0L)).longValue();
                    if (longValue4 <= 0) {
                        booleanValue3 = true;
                        aVar.a("app_running_last_collect_time", Long.valueOf(currentTimeMillis));
                    } else if (currentTimeMillis - longValue4 >= ((Long) b.b("app_running_collect_interval", 3600000L)).longValue()) {
                        i = ((Integer) b.b("app_running_collect_app_type", 1)).intValue();
                        i2 = ((Integer) b.b("app_running_collect_process_type", 1)).intValue();
                        booleanValue3 = (i == 0 && i2 == 0) ? false : true;
                        if (booleanValue3) {
                            aVar.a("app_running_last_collect_time", Long.valueOf(currentTimeMillis));
                        }
                    } else {
                        booleanValue3 = false;
                    }
                }
                boolean z4 = false;
                long longValue5 = ((Long) b.b("battery_last_collect_time", 0L)).longValue();
                if (longValue5 <= 0 || currentTimeMillis - longValue5 >= 3600000) {
                    z4 = true;
                    aVar.a("battery_last_collect_time", Long.valueOf(currentTimeMillis));
                }
                cn.jiguang.d.a.d.a(context, aVar);
                cn.jiguang.a.b.b bVar = new cn.jiguang.a.b.b(z, booleanValue && z2, z3, booleanValue2, booleanValue3, i, i2, z4);
                if (bVar.b) {
                    c.a(this.a, false);
                }
                if (bVar.c) {
                    try {
                        c.a(this.a, (String) null);
                    } catch (Throwable th) {
                    }
                }
                if (bVar.d) {
                    try {
                        i.a(this.a);
                    } catch (Throwable th2) {
                    }
                }
                if (cn.jiguang.g.a.d(this.a) && cn.jiguang.g.a.e(this.a).toUpperCase().startsWith("WIFI")) {
                    try {
                        cn.jiguang.a.a.a.c.a(this.a);
                    } catch (Throwable th3) {
                    }
                }
                if (bVar.e) {
                    try {
                        cn.jiguang.g.d.b(this.a, bVar.f, bVar.g);
                    } catch (Throwable th4) {
                    }
                }
                if (bVar.h) {
                    try {
                        Context context2 = this.a;
                        cn.jiguang.d.h.b am = cn.jiguang.d.h.a.am(context2);
                        if (am != null) {
                            JSONObject a = am.a();
                            aa.a(context2, a, "battery");
                            aa.a(context2, a);
                        }
                    } catch (Throwable th5) {
                    }
                }
                c.b(this.a, this.b);
                if (bVar.a) {
                    cn.jiguang.a.a.c.b.b(this.a);
                }
            }
        } catch (Throwable th6) {
        }
    }
}
