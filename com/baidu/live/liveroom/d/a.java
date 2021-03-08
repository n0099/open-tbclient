package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public b bta;
    private List<d> aFO = new LinkedList();
    private List<e> btb = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aFO.contains(dVar)) {
            this.aFO.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.btb.contains(eVar)) {
            this.btb.add(eVar);
        }
    }
}
