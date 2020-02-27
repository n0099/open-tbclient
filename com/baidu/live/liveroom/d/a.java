package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b avW;
    private List<d> VW = new LinkedList();
    private List<e> avX = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.VW.contains(dVar)) {
            this.VW.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.avX.contains(eVar)) {
            this.avX.add(eVar);
        }
    }
}
