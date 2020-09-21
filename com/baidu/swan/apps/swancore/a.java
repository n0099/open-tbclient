package com.baidu.swan.apps.swancore;

import android.support.annotation.NonNull;
import android.text.TextUtils;
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
/* loaded from: classes3.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0443a {
        private static final a daw = new a();
    }

    public static a aDQ() {
        return C0443a.daw;
    }

    public static String jI(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void g(long j, int i) {
        boolean z;
        List<b> jK = jK(i);
        if (jK.size() >= 10) {
            jK.remove(0);
        }
        Iterator<b> it = jK.iterator();
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
            jK.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : jK) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            h.aDP().putStringSet(jL(i), hashSet);
        }
    }

    private static void ay(List<b> list) {
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
                return String.valueOf(bVar.dax).compareTo(String.valueOf(bVar2.dax));
            }
        });
    }

    public String jJ(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.aDP().getString(jI(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> jK = jK(i);
        int size = jK.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = jK.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.c.a.jV(i)).toString());
        } else {
            SwanCoreVersion ask = f.asJ().ask();
            b bVar2 = jK.get(size - 1);
            if (bVar2 != null && ask != null && ask.swanCoreVersion > bVar2.swanCoreVersion) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), ask.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    private List<b> jK(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.aDP().getStringSet(jL(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b sv = sv(str);
            if (sv != null) {
                arrayList.add(sv);
            }
        }
        ay(arrayList);
        return arrayList;
    }

    private b sv(String str) {
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

    /* loaded from: classes3.dex */
    public static class b {
        long dax;
        long swanCoreVersion;

        b(long j, long j2) {
            this.dax = j;
            this.swanCoreVersion = j2;
        }

        @NonNull
        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.dax));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.bM(this.swanCoreVersion);
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
                jSONObject.put("time", this.dax);
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

    private static String jL(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
