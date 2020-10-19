package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b bkG;
    private List<d> aFe = new LinkedList();
    private List<e> bkH = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aFe.contains(dVar)) {
            this.aFe.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bkH.contains(eVar)) {
            this.bkH.add(eVar);
        }
    }
}
