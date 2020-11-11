package com.baidu.swan.games.i;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class g {
    private HashMap<String, h> dUV = new HashMap<>();

    public ArrayList<h> A(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.dUV.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.dUV.get(str2));
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
                    this.dUV.put(str, hVar);
                }
            }
        }
    }

    public void b(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.dUV.get(str) == hVar) {
                    this.dUV.remove(str);
                }
            }
        }
    }

    public void awa() {
        this.dUV.clear();
    }
}
