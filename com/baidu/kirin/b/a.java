package com.baidu.kirin.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.kirin.KirinConfig;
import com.baidu.kirin.d.d;
import java.lang.ref.SoftReference;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static SoftReference<a> a = null;
    private final Context b;
    private final SharedPreferences c = f().getSharedPreferences(f().getPackageName() + ".kirin_strategy_control_pref", 0);

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            aVar = a == null ? null : a.get();
            if (aVar == null) {
                synchronized (a.class) {
                    aVar = a == null ? null : a.get();
                    if (aVar == null) {
                        aVar = new a(context);
                        a = new SoftReference<>(aVar);
                    }
                }
            }
        }
        return aVar;
    }

    private boolean a(String str, String str2) {
        return c(str) > c(str2);
    }

    private int c(String str) {
        return (Integer.parseInt(str.split(":")[0]) * 60 * 60) + (Integer.parseInt(str.split(":")[1]) * 60) + Integer.parseInt(str.split(":")[2]);
    }

    private Context f() {
        return this.b;
    }

    private boolean g() {
        long time = new Date().getTime();
        int i = this.c.getInt("kirin_update_freqency", -1);
        long j = this.c.getLong("kirin_strategy_record_time", -1L);
        if (j == -1) {
            return true;
        }
        if ((time - j) / 1000 >= i) {
            d.a(time + " --> exceed interval : " + i);
            return true;
        }
        d.a(time + " --> don't exceed interval : " + i);
        return false;
    }

    private boolean h() {
        long time = new Date().getTime();
        long j = this.c.getLong("kirin_strategy_record_time", -1L);
        if (j == -1) {
            return true;
        }
        if ((time - j) / 1000 > KirinConfig.DEFAULT_UPDATE_INTERVAL) {
            d.a(time + " --> exceed interval : " + KirinConfig.DEFAULT_UPDATE_INTERVAL);
            return true;
        }
        d.a(time + " --> don't exceed interval : " + KirinConfig.DEFAULT_UPDATE_INTERVAL);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean i() {
        Date date;
        ParseException e;
        Date date2;
        boolean z = true;
        String e2 = e();
        String str = e2.split("\\|")[0];
        String str2 = e2.split("\\|")[1];
        System.out.println(str);
        System.out.println(str2);
        long time = new Date().getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(time));
        String str3 = format + " " + str;
        String str4 = format + " " + str2;
        System.out.println(str3);
        System.out.println(str4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = simpleDateFormat.parse(str3);
            try {
                date2 = simpleDateFormat.parse(str4);
            } catch (ParseException e3) {
                date2 = null;
                e = e3;
            }
        } catch (ParseException e4) {
            date = null;
            e = e4;
            date2 = null;
        }
        try {
            System.out.println(date.getTime() + " - " + date2.getTime());
        } catch (ParseException e5) {
            e = e5;
            e.printStackTrace();
            long time2 = date.getTime();
            long time3 = date2.getTime();
            if (!a(str2, str)) {
            }
        }
        long time22 = date.getTime();
        long time32 = date2.getTime();
        if (!a(str2, str)) {
            return time >= time22 && time <= time32;
        }
        if (time < time22 - 86400000 || time > time32) {
            z = false;
        }
        return z;
    }

    public void a(boolean z, JSONObject jSONObject) {
        long time = new Date().getTime();
        SharedPreferences.Editor edit = this.c.edit();
        if (z) {
            try {
                int i = jSONObject.getInt("updateSwitch");
                int i2 = jSONObject.getInt("updateFrequency");
                int i3 = jSONObject.getInt("popFrequency");
                String string = jSONObject.getString("openPeriod");
                d.a("write to strategy controller data is  :  success : " + z + "; updateSwith : " + i + "; updateFrequency : " + i2 + "; popFrequency : " + i3);
                edit.putLong("kirin_strategy_record_time", time);
                edit.putInt("kirin_update_switcher", i);
                edit.putInt("kirin_update_freqency", i2 * 86400);
                edit.putInt("kirin_update_remind_freqency", i3 * 86400);
                edit.putString("kirin_open_peroid", string);
            } catch (JSONException e) {
                e.printStackTrace();
                edit.putLong("kirin_strategy_record_time", time);
                edit.putInt("kirin_update_switcher", 0);
                edit.putInt("kirin_update_freqency", KirinConfig.DEFAULT_UPDATE_INTERVAL);
                edit.putInt("kirin_update_remind_freqency", KirinConfig.DEFAULT_POP_INTERVAL);
                edit.putString("kirin_open_peroid", KirinConfig.DEFAULT_OPEN_PEROID);
            }
        } else {
            edit.putLong("kirin_strategy_record_time", time);
            edit.putInt("kirin_update_switcher", 0);
            edit.putInt("kirin_update_freqency", KirinConfig.DEFAULT_UPDATE_INTERVAL);
            edit.putInt("kirin_update_remind_freqency", KirinConfig.DEFAULT_POP_INTERVAL);
            edit.putString("kirin_open_peroid", KirinConfig.DEFAULT_OPEN_PEROID);
        }
        edit.commit();
    }

    public boolean a() {
        if (i()) {
            int i = this.c.getInt("kirin_update_switcher", -1);
            if (!g() && i == 1) {
                d.a("!isExceedServerUpdateInterval() && switcher == 1");
                return false;
            } else if (i == 0) {
                d.a("else if(switcher == 0)");
                return h();
            } else {
                d.a("else!");
                return true;
            }
        }
        return false;
    }

    public boolean a(String str) {
        if (i()) {
            if (str.equals(KirinConfig.ATSTART)) {
                return a();
            }
            if (str.equals(KirinConfig.ATSETTING)) {
                return b();
            }
            return false;
        }
        return false;
    }

    public void b(String str) {
        SharedPreferences.Editor edit = this.c.edit();
        edit.putString("kirin_log_id", str);
        edit.commit();
    }

    public boolean b() {
        return i();
    }

    public boolean c() {
        if (i()) {
            int i = this.c.getInt("kirin_update_switcher", -1);
            return i == -1 || i == 1;
        }
        return false;
    }

    public String d() {
        return this.c.getString("kirin_log_id", "0");
    }

    public String e() {
        return this.c.getString("kirin_open_peroid", KirinConfig.DEFAULT_OPEN_PEROID);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == this.c) {
            d.a(str + " : has changed");
        }
    }
}
