package com.baidu.swan.apps.adaptation.implementation;

import android.util.SparseArray;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class m implements com.baidu.swan.menu.b {
    private SparseArray<String> bSF = new SparseArray<>();

    public m() {
        this.bSF.put(38, "favor");
    }

    @Override // com.baidu.swan.menu.b
    public void f(int i, List<com.baidu.swan.menu.i> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void g(int i, List<com.baidu.swan.menu.i> list) {
    }

    @Override // com.baidu.swan.menu.b
    public void h(int i, List<com.baidu.swan.menu.i> list) {
        i(i, list);
    }

    @Override // com.baidu.swan.menu.b
    public boolean a(com.baidu.swan.menu.i iVar) {
        return false;
    }

    private void i(int i, List<com.baidu.swan.menu.i> list) {
        if (!ak.aFn() && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.swan.menu.i iVar : list) {
                if (this.bSF.get(iVar.getItemId()) != null) {
                    arrayList.add(iVar);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
    }
}
