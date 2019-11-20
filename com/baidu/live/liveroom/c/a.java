package com.baidu.live.liveroom.c;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public b ajm;
    private List<d> Na = new LinkedList();
    private List<e> ajn = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.Na.contains(dVar)) {
            this.Na.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.ajn.contains(eVar)) {
            this.ajn.add(eVar);
        }
    }
}
