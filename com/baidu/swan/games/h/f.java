package com.baidu.swan.games.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private HashMap<String, g> cMZ = new HashMap<>();

    public ArrayList<g> x(String... strArr) {
        ArrayList<g> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.cMZ.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.cMZ.get(str2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.cMZ.put(str, gVar);
                }
            }
        }
    }

    public void b(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.cMZ.get(str) == gVar) {
                    this.cMZ.remove(str);
                }
            }
        }
    }

    public void avZ() {
        this.cMZ.clear();
    }
}
