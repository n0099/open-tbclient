package com.baidu.swan.games.i;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class g {
    private HashMap<String, h> dip = new HashMap<>();

    public ArrayList<h> x(String... strArr) {
        ArrayList<h> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.dip.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.dip.get(str2));
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
                    this.dip.put(str, hVar);
                }
            }
        }
    }

    public void b(h hVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.dip.get(str) == hVar) {
                    this.dip.remove(str);
                }
            }
        }
    }

    public void aEB() {
        this.dip.clear();
    }
}
