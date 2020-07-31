package com.baidu.swan.apps.swancore;

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
/* loaded from: classes7.dex */
public class a {
    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.swancore.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0402a {
        private static final a cPo = new a();
    }

    public static a auX() {
        return C0402a.cPo;
    }

    public static String hq(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void c(long j, int i) {
        boolean z;
        List<b> hs = hs(i);
        if (hs.size() >= 10) {
            hs.remove(0);
        }
        Iterator<b> it = hs.iterator();
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
            hs.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : hs) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            h.auW().putStringSet(ht(i), hashSet);
        }
    }

    private static void at(List<b> list) {
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
                return String.valueOf(bVar.cPp).compareTo(String.valueOf(bVar2.cPp));
            }
        });
    }

    public String hr(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.auW().getString(hq(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> hs = hs(i);
        int size = hs.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = hs.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.c.a.hD(i)).toString());
        } else {
            SwanCoreVersion ajT = f.akr().ajT();
            b bVar2 = hs.get(size - 1);
            if (bVar2 != null && ajT != null && ajT.swanCoreVersion > bVar2.swanCoreVersion) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), ajT.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    private List<b> hs(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.auW().getStringSet(ht(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b qa = qa(str);
            if (qa != null) {
                arrayList.add(qa);
            }
        }
        at(arrayList);
        return arrayList;
    }

    private b qa(String str) {
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

    /* loaded from: classes7.dex */
    public class b {
        long cPp;
        long swanCoreVersion;

        b(long j, long j2) {
            this.cPp = j;
            this.swanCoreVersion = j2;
        }

        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.cPp));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.bE(this.swanCoreVersion);
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
                jSONObject.put("time", this.cPp);
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

    private static String ht(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
