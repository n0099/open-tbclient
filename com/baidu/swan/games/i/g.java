package com.baidu.swan.games.i;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class g {
    private HashMap<String, h> dPd = new HashMap<>();

    public ArrayList<h> A(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.dPd.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.dPd.get(str2));
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
                    this.dPd.put(str, hVar);
                }
            }
        }
    }

    public void b(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.dPd.get(str) == hVar) {
                    this.dPd.remove(str);
                }
            }
        }
    }

    public void atA() {
        this.dPd.clear();
    }
}
