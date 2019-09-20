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
    private static class C0193a {
        private static final a aXc = new a();
    }

    public static a Oc() {
        return C0193a.aXc;
    }

    public static String dR(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void b(long j, int i) {
        boolean z;
        List<b> dT = dT(i);
        if (dT.size() >= 10) {
            dT.remove(0);
        }
        Iterator<b> it = dT.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            if (next != null && next.aXe == j) {
                z = true;
                break;
            }
        }
        if (!z) {
            dT.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : dT) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            f.Ob().b(dU(i), hashSet);
        }
    }

    private static void D(List<b> list) {
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
                return String.valueOf(bVar.aXd).compareTo(String.valueOf(bVar2.aXd));
            }
        });
    }

    public String dS(int i) {
        StringBuilder sb = new StringBuilder();
        String string = f.Ob().getString(dR(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> dT = dT(i);
        int size = dT.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = dT.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.d.a.ee(i)).toString());
        } else {
            SwanCoreVersion Go = e.GJ().Go();
            b bVar2 = dT.get(size - 1);
            if (bVar2 != null && Go != null && Go.aXe > bVar2.aXe) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), Go.aXe).toString());
            }
        }
        return sb.toString();
    }

    private List<b> dT(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = f.Ob().getStringSet(dU(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b hP = hP(str);
            if (hP != null) {
                arrayList.add(hP);
            }
        }
        D(arrayList);
        return arrayList;
    }

    private b hP(String str) {
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
        long aXd;
        long aXe;

        b(long j, long j2) {
            this.aXd = j;
            this.aXe = j2;
        }

        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.aXd));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.W(this.aXe);
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
                jSONObject.put("time", this.aXd);
                jSONObject.put("version", this.aXe);
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

    private static String dU(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
