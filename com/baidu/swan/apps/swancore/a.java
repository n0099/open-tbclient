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
/* loaded from: classes9.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0489a {
        private static final a dOV = new a();
    }

    public static a aPJ() {
        return C0489a.dOV;
    }

    public static String kZ(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void m(long j, int i) {
        boolean z;
        List<b> lb = lb(i);
        if (lb.size() >= 10) {
            lb.remove(0);
        }
        Iterator<b> it = lb.iterator();
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
            lb.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : lb) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            h.aPI().putStringSet(lc(i), hashSet);
        }
    }

    private static void bc(List<b> list) {
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
                return String.valueOf(bVar.dOW).compareTo(String.valueOf(bVar2.dOW));
            }
        });
    }

    public String la(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.aPI().getString(kZ(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> lb = lb(i);
        int size = lb.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = lb.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.c.a.lm(i)).toString());
        } else {
            SwanCoreVersion aDj = f.aDH().aDj();
            b bVar2 = lb.get(size - 1);
            if (bVar2 != null && aDj != null && aDj.swanCoreVersion > bVar2.swanCoreVersion) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), aDj.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    private List<b> lb(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.aPI().getStringSet(lc(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b un = un(str);
            if (un != null) {
                arrayList.add(un);
            }
        }
        bc(arrayList);
        return arrayList;
    }

    private b un(String str) {
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

    /* loaded from: classes9.dex */
    public static class b {
        long dOW;
        long swanCoreVersion;

        b(long j, long j2) {
            this.dOW = j;
            this.swanCoreVersion = j2;
        }

        @NonNull
        public String toString() {
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.dOW));
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.cS(this.swanCoreVersion);
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
                jSONObject.put("time", this.dOW);
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

    private static String lc(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
