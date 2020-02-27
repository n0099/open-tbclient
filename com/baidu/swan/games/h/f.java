package com.baidu.swan.games.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class f {
    private HashMap<String, g> cnK = new HashMap<>();

    public ArrayList<g> x(String... strArr) {
        ArrayList<g> arrayList = null;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : this.cnK.keySet()) {
                        if (str2.startsWith(str) || str.startsWith(str2)) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(this.cnK.get(str2));
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
                    this.cnK.put(str, gVar);
                }
            }
        }
    }

    public void b(g gVar, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && this.cnK.get(str) == gVar) {
                    this.cnK.remove(str);
                }
            }
        }
    }

    public void anH() {
        this.cnK.clear();
    }
}
