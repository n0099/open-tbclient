package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b aVZ;
    private List<d> ati = new LinkedList();
    private List<e> aWa = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.ati.contains(dVar)) {
            this.ati.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.aWa.contains(eVar)) {
            this.aWa.add(eVar);
        }
    }
}
