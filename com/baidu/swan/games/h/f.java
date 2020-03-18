package com.baidu.swan.games.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private HashMap<String, g> cnX = new HashMap<>();

    public ArrayList<g> x(String... strArr) {
        ArrayList<g> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.cnX.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.cnX.get(str2));
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
                    this.cnX.put(str, gVar);
                }
            }
        }
    }

    public void b(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.cnX.get(str) == gVar) {
                    this.cnX.remove(str);
                }
            }
        }
    }

    public void anM() {
        this.cnX.clear();
    }
}
