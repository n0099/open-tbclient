package com.baidu.swan.apps.adaptation.implementation;

import android.util.SparseArray;
import com.baidu.swan.apps.ao.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class m implements com.baidu.swan.menu.b {
    private SparseArray<String> cFu = new SparseArray<>();

    public m() {
        this.cFu.put(38, "favor");
    }

    @Override // com.baidu.swan.menu.b
    public void f(int i, List<com.baidu.swan.menu.h> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void g(int i, List<com.baidu.swan.menu.h> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void h(int i, List<com.baidu.swan.menu.h> list) {
        i(i, list);
    }

    @Override // com.baidu.swan.menu.b
    public boolean a(com.baidu.swan.menu.h hVar) {
        return false;
    }

    private void i(int i, List<com.baidu.swan.menu.h> list) {
        if (!ak.aRP() && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.swan.menu.h hVar : list) {
                if (this.cFu.get(hVar.getItemId()) != null) {
                    arrayList.add(hVar);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
    }
}
