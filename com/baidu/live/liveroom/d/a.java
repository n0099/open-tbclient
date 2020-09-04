package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public b bdZ;
    private List<d> aBt = new LinkedList();
    private List<e> bea = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aBt.contains(dVar)) {
            this.aBt.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bea.contains(eVar)) {
            this.bea.add(eVar);
        }
    }
}
