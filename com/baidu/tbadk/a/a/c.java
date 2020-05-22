package com.baidu.tbadk.a.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a {
    public static final BdUniqueId dxd = BdUniqueId.gen();
    public final ArrayList<String> dxe = new ArrayList<>();
    public e dxf;

    public c() {
        this.dxe.add("70_2");
        this.dxe.add("70_3");
        this.dxe.add("70_4");
        this.dxe.add("70_5");
        this.dxe.add("70_6");
        this.dxe.add("71_2");
    }

    @Override // com.baidu.tbadk.a.a.a
    public BdUniqueId aMu() {
        return dxd;
    }

    @Override // com.baidu.tbadk.a.a.a
    public ArrayList<String> aMv() {
        return this.dxe;
    }

    @Override // com.baidu.tbadk.a.a.a
    public e aMw() {
        return this.dxf;
    }

    @Override // com.baidu.tbadk.a.a.a
    public void a(e eVar) {
        this.dxf = eVar;
    }

    public static void a(e eVar, List<o> list) {
        if (list != null) {
            for (o oVar : list) {
                if (oVar instanceof AbsThreadDataSupport) {
                    ((AbsThreadDataSupport) oVar).b(eVar);
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

    public static e aMx() {
        return d.j(dxd);
    }

    public static boolean B(String... strArr) {
        return b(aMx(), strArr);
    }

    public static boolean b(e eVar, String... strArr) {
        return d.a(eVar, strArr);
    }
}
