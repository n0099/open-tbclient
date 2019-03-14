package com.baidu.swan.apps.swancore;

import android.text.TextUtils;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
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
    private static class C0175a {
        private static final a aTb = new a();
    }

    public static a KM() {
        return C0175a.aTb;
    }

    public static String dD(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public void d(long j, int i) {
        boolean z;
        List<b> dF = dF(i);
        if (dF.size() >= 10) {
            dF.remove(0);
        }
        Iterator<b> it = dF.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            b next = it.next();
            if (next != null && next.aTd == j) {
                z = true;
                break;
            }
        }
        if (!z) {
            dF.add(new b(Calendar.getInstance().getTimeInMillis(), j));
            HashSet hashSet = new HashSet();
            for (b bVar : dF) {
                if (bVar != null) {
                    hashSet.add(bVar.toJson());
                }
            }
            f.KL().putStringSet(dG(i), hashSet);
        }
    }

    private static void C(List<b> list) {
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
                return String.valueOf(bVar.aTc).compareTo(String.valueOf(bVar2.aTc));
            }
        });
    }

    public String dE(int i) {
        StringBuilder sb = new StringBuilder();
        String string = f.KL().getString(dD(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ").append(string).append("\n").append("\n");
        }
        List<b> dF = dF(i);
        int size = dF.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            b bVar = dF.get(i2);
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
            sb.append(new b(System.currentTimeMillis(), com.baidu.swan.apps.swancore.d.a.dQ(i)).toString());
        } else {
            SwanCoreVersion DH = e.Ec().DH();
            b bVar2 = dF.get(size - 1);
            if (bVar2 != null && DH != null && DH.aTd > bVar2.aTd) {
                sb.append("\n");
                sb.append(new b(System.currentTimeMillis(), DH.aTd).toString());
            }
        }
        return sb.toString();
    }

    private List<b> dF(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = f.KL().getStringSet(dG(i), null);
        if (stringSet == null || stringSet.size() == 0) {
            return arrayList;
        }
        for (String str : stringSet) {
            b hf = hf(str);
            if (hf != null) {
                arrayList.add(hf);
            }
        }
        C(arrayList);
        return arrayList;
    }

    private b hf(String str) {
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar = new b(jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME), jSONObject.optLong("version"));
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
        long aTc;
        long aTd;

        b(long j, long j2) {
            this.aTc = j;
            this.aTd = j2;
        }

        public String toString() {
            Exception e;
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.aTc));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = com.baidu.swan.apps.swancore.b.J(this.aTd);
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
                jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, this.aTc);
                jSONObject.put("version", this.aTd);
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

    private static String dG(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }
}
