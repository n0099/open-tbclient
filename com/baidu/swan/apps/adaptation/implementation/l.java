package com.baidu.swan.apps.adaptation.implementation;

import android.util.SparseArray;
import com.baidu.swan.apps.aq.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class l implements com.baidu.swan.menu.b {
    private SparseArray<String> bNh = new SparseArray<>();

    public l() {
        this.bNh.put(38, "favor");
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
        if (!al.axe() && list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.swan.menu.i iVar : list) {
                if (this.bNh.get(iVar.getItemId()) != null) {
                    arrayList.add(iVar);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
    }
}
