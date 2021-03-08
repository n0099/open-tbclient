package com.baidu.swan.apps.swancore;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
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
/* loaded from: classes8.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0475a {
        private static final a dNO = new a();
    }

    public static a aMl() {
        return C0475a.dNO;
    }

    public static String jx(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void m(long j, int i) {
        boolean z;
        List<b> jz = jz(i);
        if (jz.size() >= 10) {
            jz.remove(0);
        }
        Iterator<b> it = jz.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            if (next != null && next.swanCoreVersion == j) {
                z = true;
                break;
            }
        }
        if (!z) {
            jz.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : jz) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            h.aMk().putStringSet(jA(i), hashSet);
        }
    }

    private static void aX(List<b> list) {
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
                return String.valueOf(bVar.dNP).compareTo(String.valueOf(bVar2.dNP));
            }
        });
    }

    public String jy(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.aMk().getString(jx(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> jz = jz(i);
        int size = jz.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = jz.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.c.a.jK(i)).toString());
        } else {
            SwanCoreVersion azQ = f.aAo().azQ();
            b bVar2 = jz.get(size - 1);
            if (bVar2 != null && azQ != null && azQ.swanCoreVersion > bVar2.swanCoreVersion) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), azQ.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    private List<b> jz(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.aMk().getStringSet(jA(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b tC = tC(str);
            if (tC != null) {
                arrayList.add(tC);
            }
        }
        aX(arrayList);
        return arrayList;
    }

    private b tC(String str) {
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

    /* loaded from: classes8.dex */
    public static class b {
        long dNP;
        long swanCoreVersion;

        b(long j, long j2) {
            this.dNP = j;
            this.swanCoreVersion = j2;
        }

        @NonNull
        public String toString() {
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.dNP));
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.cY(this.swanCoreVersion);
            } catch (Exception e2) {
                e = e2;
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
                jSONObject.put("time", this.dNP);
                jSONObject.put("version", this.swanCoreVersion);
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

    private static String jA(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
