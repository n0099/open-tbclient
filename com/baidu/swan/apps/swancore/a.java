package com.baidu.swan.apps.swancore;

import android.text.TextUtils;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.y.f;
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
/* loaded from: classes10.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0288a {
        private static final a bRT = new a();
    }

    public static a adc() {
        return C0288a.bRT;
    }

    public static String gc(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void c(long j, int i) {
        boolean z;
        List<b> ge = ge(i);
        if (ge.size() >= 10) {
            ge.remove(0);
        }
        Iterator<b> it = ge.iterator();
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
            ge.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : ge) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            h.adb().putStringSet(gf(i), hashSet);
        }
    }

    private static void aa(List<b> list) {
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
                return String.valueOf(bVar.bRU).compareTo(String.valueOf(bVar2.bRU));
            }
        });
    }

    public String gd(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.adb().getString(gc(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> ge = ge(i);
        int size = ge.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = ge.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.d.a.gp(i)).toString());
        } else {
            SwanCoreVersion Uf = f.UC().Uf();
            b bVar2 = ge.get(size - 1);
            if (bVar2 != null && Uf != null && Uf.swanCoreVersion > bVar2.swanCoreVersion) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), Uf.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    private List<b> ge(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.adb().getStringSet(gf(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b lZ = lZ(str);
            if (lZ != null) {
                arrayList.add(lZ);
            }
        }
        aa(arrayList);
        return arrayList;
    }

    private b lZ(String str) {
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

    /* loaded from: classes10.dex */
    public class b {
        long bRU;
        long swanCoreVersion;

        b(long j, long j2) {
            this.bRU = j;
            this.swanCoreVersion = j2;
        }

        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat(DateTimeUtil.TIME_FORMAT, Locale.getDefault()).format(new Date(this.bRU));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.aB(this.swanCoreVersion);
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
                jSONObject.put("time", this.bRU);
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

    private static String gf(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
