package com.baidu.swan.games.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private HashMap<String, g> cnL = new HashMap<>();

    public ArrayList<g> x(String... strArr) {
        ArrayList<g> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.cnL.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.cnL.get(str2));
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
                    this.cnL.put(str, gVar);
                }
            }
        }
    }

    public void b(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.cnL.get(str) == gVar) {
                    this.cnL.remove(str);
                }
            }
        }
    }

    public void anJ() {
        this.cnL.clear();
    }
}
