package a.a.a.a.a;

import a.a.a.a.a.c;
import a.a.a.a.a.d;
import a.a.a.a.a.e;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f953a;
    public int b;
    public int c;
    public final Set<e> d = new HashSet();
    public final Set<d> e = new HashSet();
    public final Set<c> f = new HashSet();

    public static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
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

    public static long b(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    @VisibleForTesting
    public boolean a() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (e eVar : this.d) {
            if (hashSet.contains(eVar.c)) {
                a.a.a.a.v.d.b("Duplicate ssp:type(%s) found.", eVar.c);
                return false;
            }
            hashSet.add(eVar.c);
            for (e.a aVar : eVar.d) {
                if (hashSet2.contains(Long.valueOf(aVar.b))) {
                    a.a.a.a.v.d.b("Duplicate pid(%d) found.", Long.valueOf(aVar.b));
                    return false;
                }
                hashSet2.add(Long.valueOf(aVar.b));
            }
        }
        HashSet hashSet3 = new HashSet();
        for (d dVar : this.e) {
            if (hashSet3.contains(dVar.b)) {
                a.a.a.a.v.d.b("Duplicate sid(%s) found in SlotId", dVar.b);
                return false;
            }
            hashSet3.add(dVar.b);
            for (d.b bVar : dVar.e) {
                HashSet hashSet4 = new HashSet();
                for (d.a aVar2 : bVar.c) {
                    if (!hashSet2.contains(Long.valueOf(aVar2.b))) {
                        a.a.a.a.v.d.b("Unregistered adId:(%d) in SlotId", Long.valueOf(aVar2.b));
                        return false;
                    } else if (hashSet4.contains(Long.valueOf(aVar2.b))) {
                        a.a.a.a.v.d.b("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(aVar2.b), dVar.b);
                        return false;
                    } else {
                        hashSet4.add(Long.valueOf(aVar2.b));
                    }
                }
            }
        }
        if (this.c == 2) {
            for (c cVar : this.f) {
                if (hashSet3.contains(cVar.b)) {
                    a.a.a.a.v.d.b("Duplicate sid(%s) found in SerialSlotId.", cVar.b);
                    return false;
                }
                hashSet3.add(cVar.b);
                for (c.b bVar2 : cVar.c) {
                    for (c.a aVar3 : bVar2.c) {
                        if (!hashSet2.contains(Long.valueOf(aVar3.b))) {
                            a.a.a.a.v.d.b("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar3.b));
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @VisibleForTesting
    public void b(String str) {
        JSONArray optJSONArray;
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("config");
        this.f953a = a(jSONObject2.getLong("ver"), 0L);
        int i = jSONObject2.getInt("interval");
        int i2 = 1440;
        if (i < 1) {
            i2 = 1;
        } else if (i <= 1440) {
            i2 = i;
        }
        this.b = i2;
        this.c = a(jSONObject2.optInt(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 1), 1);
        JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
        JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
        HashMap hashMap = new HashMap();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            e eVar = new e(jSONArray.getJSONObject(i3));
            for (e.a aVar : eVar.d) {
                hashMap.put(Long.valueOf(aVar.b), aVar);
            }
            this.d.add(eVar);
        }
        JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
            this.e.add(new d(jSONArray2.getJSONObject(i4), hashMap));
        }
        if (this.c != 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
            return;
        }
        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
            this.f.add(new c(optJSONArray.getJSONObject(i5), hashMap));
        }
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            b(str);
            a.a.a.a.v.d.c("Config parsed over.", new Object[0]);
            if (a()) {
                a.a.a.a.v.b.a(this.f953a, this.b, this.c, new a(this.d, this.e, this.f));
                a.a.a.a.v.d.c("Config persisted over.", new Object[0]);
                return true;
            }
        } catch (JSONException e) {
            a.a.a.a.v.d.a(e);
        }
        this.d.clear();
        this.e.clear();
        this.f.clear();
        return false;
    }
}
