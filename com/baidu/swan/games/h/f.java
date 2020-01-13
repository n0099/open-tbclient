package com.baidu.swan.games.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f {
    private HashMap<String, g> cjG = new HashMap<>();

    public ArrayList<g> t(String... strArr) {
        ArrayList<g> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.cjG.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.cjG.get(str2));
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
                    this.cjG.put(str, gVar);
                }
            }
        }
    }

    public void b(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.cjG.get(str) == gVar) {
                    this.cjG.remove(str);
                }
            }
        }
    }

    public void alu() {
        this.cjG.clear();
    }
}
