package com.baidu.swan.games.i;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class g {
    private HashMap<String, h> eal = new HashMap<>();

    public ArrayList<h> A(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.eal.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.eal.get(str2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.eal.put(str, hVar);
                }
            }
        }
    }

    public void b(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.eal.get(str) == hVar) {
                    this.eal.remove(str);
                }
            }
        }
    }

    public void ayA() {
        this.eal.clear();
    }
}
