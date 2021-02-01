package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public b brA;
    private List<d> aEo = new LinkedList();
    private List<e> brB = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aEo.contains(dVar)) {
            this.aEo.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.brB.contains(eVar)) {
            this.brB.add(eVar);
        }
    }
}
