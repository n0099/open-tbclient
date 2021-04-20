package a.a.a.a.s;

import a.a.a.a.s.c;
import a.a.a.a.s.d;
import a.a.a.a.s.e;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f1293a;

    /* renamed from: b  reason: collision with root package name */
    public int f1294b;

    /* renamed from: c  reason: collision with root package name */
    public int f1295c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<e> f1296d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f1297e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final Set<c> f1298f = new HashSet();

    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return i2;
        }
        if (i > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    public static long a(long j, long j2) {
        if (j < j2) {
            return j2;
        }
        if (j > Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public static long a(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    @VisibleForTesting
    public boolean a() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (e eVar : this.f1296d) {
            if (hashSet.contains(eVar.f1317c)) {
                a.a.a.a.v.d.b("Duplicate ssp:type(%s) found.", eVar.f1317c);
                return false;
            }
            hashSet.add(eVar.f1317c);
            for (e.a aVar : eVar.f1318d) {
                if (hashSet2.contains(Long.valueOf(aVar.f1319b))) {
                    a.a.a.a.v.d.b("Duplicate pid(%d) found.", Long.valueOf(aVar.f1319b));
                    return false;
                }
                hashSet2.add(Long.valueOf(aVar.f1319b));
            }
        }
        HashSet hashSet3 = new HashSet();
        for (d dVar : this.f1297e) {
            if (hashSet3.contains(dVar.f1306b)) {
                a.a.a.a.v.d.b("Duplicate sid(%s) found in SlotId", dVar.f1306b);
                return false;
            }
            hashSet3.add(dVar.f1306b);
            for (d.b bVar : dVar.f1309e) {
                HashSet hashSet4 = new HashSet();
                for (d.a aVar2 : bVar.f1315c) {
                    if (!hashSet2.contains(Long.valueOf(aVar2.f1310b))) {
                        a.a.a.a.v.d.b("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar2.f1310b));
                        return false;
                    } else if (hashSet4.contains(Long.valueOf(aVar2.f1310b))) {
                        a.a.a.a.v.d.b("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar2.f1310b), dVar.f1306b);
                        return false;
                    } else {
                        hashSet4.add(Long.valueOf(aVar2.f1310b));
                    }
                }
            }
        }
        if (this.f1295c == 2) {
            for (c cVar : this.f1298f) {
                if (hashSet3.contains(cVar.f1299b)) {
                    a.a.a.a.v.d.b("Duplicate sid(%s) found in SerialSlotId.", cVar.f1299b);
                    return false;
                }
                hashSet3.add(cVar.f1299b);
                for (c.b bVar2 : cVar.f1300c) {
                    for (c.a aVar3 : bVar2.f1305c) {
                        if (!hashSet2.contains(Long.valueOf(aVar3.f1301b))) {
                            a.a.a.a.v.d.b("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar3.f1301b));
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            b(str);
            a.a.a.a.v.d.c("Config parsed over.", new Object[0]);
            if (a()) {
                a.a.a.a.v.b.a(this.f1293a, this.f1294b, this.f1295c, new a(this.f1296d, this.f1297e, this.f1298f));
                a.a.a.a.v.d.c("Config persisted over.", new Object[0]);
                return true;
            }
        } catch (JSONException e2) {
            a.a.a.a.v.d.a(e2);
        }
        this.f1296d.clear();
        this.f1297e.clear();
        this.f1298f.clear();
        return false;
    }

    @VisibleForTesting
    public void b(String str) {
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("config");
        this.f1293a = a(jSONObject2.getLong("ver"), 0L);
        int i = jSONObject2.getInt("interval");
        if (i < 1) {
            i = 1;
        } else if (i > 1440) {
            i = 1440;
        }
        this.f1294b = i;
        this.f1295c = a(jSONObject2.optInt(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 1), 1);
        JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
        JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            e eVar = new e(jSONArray.getJSONObject(i2));
            for (e.a aVar : eVar.f1318d) {
                hashMap.put(Long.valueOf(aVar.f1319b), aVar);
            }
            this.f1296d.add(eVar);
        }
        JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
            this.f1297e.add(new d(jSONArray2.getJSONObject(i3), hashMap));
        }
        if (this.f1295c != 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
            return;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            this.f1298f.add(new c(optJSONArray.getJSONObject(i4), hashMap));
        }
    }
}
