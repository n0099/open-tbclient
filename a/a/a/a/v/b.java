package a.a.a.a.v;

import a.a.a.a.v.c;
import a.a.a.a.v.d;
import a.a.a.a.v.e;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f1315a;

    /* renamed from: b  reason: collision with root package name */
    public int f1316b;

    /* renamed from: c  reason: collision with root package name */
    public int f1317c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<e> f1318d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public final Set<d> f1319e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public final Set<c> f1320f = new HashSet();

    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return i3;
        }
        if (i2 > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i2;
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
        for (e eVar : this.f1318d) {
            if (hashSet.contains(eVar.f1339c)) {
                a.a.a.a.y.d.b("Duplicate ssp:type(%s) found.", eVar.f1339c);
                return false;
            }
            hashSet.add(eVar.f1339c);
            for (e.a aVar : eVar.f1340d) {
                if (hashSet2.contains(Long.valueOf(aVar.f1341b))) {
                    a.a.a.a.y.d.b("Duplicate pid(%d) found.", Long.valueOf(aVar.f1341b));
                    return false;
                }
                hashSet2.add(Long.valueOf(aVar.f1341b));
            }
        }
        HashSet hashSet3 = new HashSet();
        for (d dVar : this.f1319e) {
            if (hashSet3.contains(dVar.f1328b)) {
                a.a.a.a.y.d.b("Duplicate sid(%s) found in SlotId", dVar.f1328b);
                return false;
            }
            hashSet3.add(dVar.f1328b);
            for (d.b bVar : dVar.f1331e) {
                HashSet hashSet4 = new HashSet();
                for (d.a aVar2 : bVar.f1337c) {
                    if (!hashSet2.contains(Long.valueOf(aVar2.f1332b))) {
                        a.a.a.a.y.d.b("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar2.f1332b));
                        return false;
                    } else if (hashSet4.contains(Long.valueOf(aVar2.f1332b))) {
                        a.a.a.a.y.d.b("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar2.f1332b), dVar.f1328b);
                        return false;
                    } else {
                        hashSet4.add(Long.valueOf(aVar2.f1332b));
                    }
                }
            }
        }
        if (this.f1317c == 2) {
            for (c cVar : this.f1320f) {
                if (hashSet3.contains(cVar.f1321b)) {
                    a.a.a.a.y.d.b("Duplicate sid(%s) found in SerialSlotId.", cVar.f1321b);
                    return false;
                }
                hashSet3.add(cVar.f1321b);
                for (c.b bVar2 : cVar.f1322c) {
                    for (c.a aVar3 : bVar2.f1327c) {
                        if (!hashSet2.contains(Long.valueOf(aVar3.f1323b))) {
                            a.a.a.a.y.d.b("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar3.f1323b));
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
            a.a.a.a.y.d.c("Config parsed over.", new Object[0]);
            if (a()) {
                a.a.a.a.y.b.a(this.f1315a, this.f1316b, this.f1317c, new a(this.f1318d, this.f1319e, this.f1320f));
                a.a.a.a.y.d.c("Config persisted over.", new Object[0]);
                return true;
            }
        } catch (JSONException e2) {
            a.a.a.a.y.d.a(e2);
        }
        this.f1318d.clear();
        this.f1319e.clear();
        this.f1320f.clear();
        return false;
    }

    @VisibleForTesting
    public void b(String str) {
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("config");
        this.f1315a = a(jSONObject2.getLong("ver"), 0L);
        int i2 = jSONObject2.getInt("interval");
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 1440) {
            i2 = 1440;
        }
        this.f1316b = i2;
        this.f1317c = a(jSONObject2.optInt("V", 1), 1);
        JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
        JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            e eVar = new e(jSONArray.getJSONObject(i3));
            for (e.a aVar : eVar.f1340d) {
                hashMap.put(Long.valueOf(aVar.f1341b), aVar);
            }
            this.f1318d.add(eVar);
        }
        JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            this.f1319e.add(new d(jSONArray2.getJSONObject(i4), hashMap));
        }
        if (this.f1317c != 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
            return;
        }
        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
            this.f1320f.add(new c(optJSONArray.getJSONObject(i5), hashMap));
        }
    }
}
