package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b bgQ;
    private List<d> aBZ = new LinkedList();
    private List<e> bgR = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aBZ.contains(dVar)) {
            this.aBZ.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bgR.contains(eVar)) {
            this.bgR.add(eVar);
        }
    }
}
