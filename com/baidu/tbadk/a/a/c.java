package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId dCj = BdUniqueId.gen();
    public final ArrayList<String> dCk = new ArrayList<>();
    public e dCl;

    public c() {
        this.dCk.add("70_2");
        this.dCk.add("70_3");
        this.dCk.add("70_4");
        this.dCk.add("70_5");
        this.dCk.add("70_6");
        this.dCk.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId aNX() {
        return dCj;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> aNY() {
        return this.dCk;
    }

    @Override // com.baidu.tbadk.a.a.a
    public e aNZ() {
        return this.dCl;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(e eVar) {
        this.dCl = eVar;
    }

    public static void a(e eVar, List<q> list) {
        if (list != null) {
            for (q qVar : list) {
                if (qVar instanceof AbsThreadDataSupport) {
                    ((AbsThreadDataSupport) qVar).b(eVar);
                }
            }
        }
    }

    public static void a(e eVar, b... bVarArr) {
        if (bVarArr != null) {
            for (b bVar : bVarArr) {
                if (bVar != null) {
                    bVar.b(eVar);
                }
            }
        }
    }

    public static e aOa() {
        return d.j(dCj);
    }

    public static boolean A(String... strArr) {
        return b(aOa(), strArr);
    }

    public static boolean b(e eVar, String... strArr) {
        return d.a(eVar, strArr);
    }
}
