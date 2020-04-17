package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b aPK;
    private List<d> aoi = new LinkedList();
    private List<e> aPL = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aoi.contains(dVar)) {
            this.aoi.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.aPL.contains(eVar)) {
            this.aPL.add(eVar);
        }
    }
}
