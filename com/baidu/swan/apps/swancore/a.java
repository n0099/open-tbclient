package com.baidu.swan.apps.swancore;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private a() {
    }

    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0225a {
        private static final a bqg = new a();
    }

    public static a SS() {
        return C0225a.bqg;
    }

    public static String eM(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void c(long j, int i) {
        boolean z;
        List<b> eO = eO(i);
        if (eO.size() >= 10) {
            eO.remove(0);
        }
        Iterator<b> it = eO.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            if (next != null && next.bqi == j) {
                z = true;
                break;
            }
        }
        if (!z) {
            eO.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : eO) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            f.SR().b(eP(i), hashSet);
        }
    }

    private static void ac(List<b> list) {
        Collections.sort(list, new Comparator<b>() { // from class: com.baidu.swan.apps.swancore.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                if (bVar == null) {
                    return -1;
                }
                if (bVar2 == null) {
                    return 1;
                }
                return String.valueOf(bVar.bqh).compareTo(String.valueOf(bVar2.bqh));
            }
        });
    }

    public String eN(int i) {
        StringBuilder sb = new StringBuilder();
        String string = f.SR().getString(eM(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> eO = eO(i);
        int size = eO.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = eO.get(i2);
            if (bVar != null) {
                z = true;
                sb.append(bVar.toString());
                if (i2 < size - 1) {
                    sb.append("\n");
                }
            }
            i2++;
            z = z;
        }
        if (!z) {
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.d.a.eZ(i)).toString());
        } else {
            SwanCoreVersion Li = e.LD().Li();
            b bVar2 = eO.get(size - 1);
            if (bVar2 != null && Li != null && Li.bqi > bVar2.bqi) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), Li.bqi).toString());
            }
        }
        return sb.toString();
    }

    private List<b> eO(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = f.SR().getStringSet(eP(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b it = it(str);
            if (it != null) {
                arrayList.add(it);
            }
        }
        ac(arrayList);
        return arrayList;
    }

    private b it(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar = new b(jSONObject.optLong("time"), jSONObject.optLong("version"));
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            bVar = null;
        }
        return bVar;
    }

    /* loaded from: classes2.dex */
    public class b {
        long bqh;
        long bqi;

        b(long j, long j2) {
            this.bqh = j;
            this.bqi = j2;
        }

        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.bqh));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.ap(this.bqi);
            } catch (Exception e3) {
                e = e3;
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
                return str + " ---> " + str2;
            }
            return str + " ---> " + str2;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.bqh);
                jSONObject.put("version", this.bqi);
                return jSONObject.toString();
            } catch (JSONException e) {
                if (!com.baidu.swan.apps.b.DEBUG) {
                    return null;
                }
                e.printStackTrace();
                return null;
            }
        }
    }

    private static String eP(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
