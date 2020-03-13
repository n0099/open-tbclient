package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b avX;
    private List<d> VW = new LinkedList();
    private List<e> avY = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.VW.contains(dVar)) {
            this.VW.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.avY.contains(eVar)) {
            this.avY.add(eVar);
        }
    }
}
