package com.baidu.apollon.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.statistics.StatService;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public final class PayStatisticsUtil {

    /* renamed from: d  reason: collision with root package name */
    public static Context f3928d;

    /* renamed from: a  reason: collision with root package name */
    public StatisticsSettings f3929a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3930b;

    /* renamed from: c  reason: collision with root package name */
    public SyncHttpImpl f3931c;

    /* loaded from: classes.dex */
    public enum CallerId {
        Passport(1),
        BaiduWallet(2),
        Host(3);
        
        public int id;
        public String version;

        CallerId(int i2) {
            this.id = i2;
        }

        public int getId() {
            return this.id;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static PayStatisticsUtil f3932a = new PayStatisticsUtil();
    }

    public static Context c() {
        return f3928d;
    }

    private boolean d() {
        if (f3928d == null) {
            return true;
        }
        StatisticsSettings statisticsSettings = this.f3929a;
        if (statisticsSettings != null) {
            return !statisticsSettings.isEnabled();
        }
        return false;
    }

    public static PayStatisticsUtil getInstance() {
        return a.f3932a;
    }

    public static void initData(Context context) {
        a(context);
        d.a().b();
    }

    public static void initStatisticsModule(Context context, StatisticsSettings statisticsSettings) {
        getInstance();
        if (!a(context) || statisticsSettings == null) {
            return;
        }
        PayStatisticsUtil payStatisticsUtil = getInstance();
        payStatisticsUtil.f3929a = statisticsSettings;
        try {
            if (payStatisticsUtil.f3930b) {
                return;
            }
            payStatisticsUtil.f3930b = true;
            d.a().b();
        } catch (Exception unused) {
        }
    }

    public static void onBack(String str) {
        if (getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.back, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onEvent(String str) {
        if (getInstance().d()) {
            return;
        }
        onEventWithValues(str, null, null);
    }

    public static void onEventEnd(String str, int i2) {
        onEventEndWithValue(str, i2, null, null);
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        onEventEndWithValue(str, i2, str2, null);
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        onEventEndWithValues(str, i2, collection, null);
    }

    public static void onEventStart(String str) {
        if (getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2) {
        onEventWithValue(str, str2, null);
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        onEventWithValues(str, collection, null);
    }

    public static void onIn(String str, long j) {
        if (getInstance().d()) {
            return;
        }
        try {
            if (0 < j) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.toString(j));
                StatService.a(str, StatService.ETag.in, arrayList);
            } else {
                StatService.a(str, StatService.ETag.in, (Collection<String>) null);
            }
        } catch (Exception unused) {
        }
    }

    public static void onOut(String str) {
        if (getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.out, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onPush(String str) {
        if (getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.push, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void setHttpImpl(SyncHttpImpl syncHttpImpl) {
        getInstance().f3931c = syncHttpImpl;
    }

    public StatisticsSettings a() {
        return this.f3929a;
    }

    public SyncHttpImpl b() {
        return this.f3931c;
    }

    public PayStatisticsUtil() {
    }

    public static boolean a(Context context) {
        if (f3928d == null && context != null) {
            f3928d = context.getApplicationContext();
        }
        return f3928d != null;
    }

    public static void onEventEnd(String str, int i2, String str2) {
        onEventEndWithValue(str, i2, null, str2);
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        if (getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, Integer.toString(i2), str2, str3);
        } catch (Exception unused) {
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        if (getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i2), collection, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        if (getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, str2, str3);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        if (getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, (String) null, collection, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEvent(String str, String str2) {
        if (getInstance().d()) {
            return;
        }
        onEventWithValues(str, null, str2);
    }
}
