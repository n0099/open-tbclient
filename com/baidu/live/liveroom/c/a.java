package com.baidu.live.liveroom.c;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    public b ajE;
    private List<d> NB = new LinkedList();
    private List<e> ajF = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.NB.contains(dVar)) {
            this.NB.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.ajF.contains(eVar)) {
            this.ajF.add(eVar);
        }
    }
}
