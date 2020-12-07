package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b bqR;
    private List<d> aGX = new LinkedList();
    private List<e> bqS = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aGX.contains(dVar)) {
            this.aGX.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bqS.contains(eVar)) {
            this.bqS.add(eVar);
        }
    }
}
