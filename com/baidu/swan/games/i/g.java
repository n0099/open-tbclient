package com.baidu.swan.games.i;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g {
    private HashMap<String, h> duF = new HashMap<>();

    public ArrayList<h> y(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.duF.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.duF.get(str2));
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
                    this.duF.put(str, hVar);
                }
            }
        }
    }

    public void b(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.duF.get(str) == hVar) {
                    this.duF.remove(str);
                }
            }
        }
    }

    public void aoT() {
        this.duF.clear();
    }
}
