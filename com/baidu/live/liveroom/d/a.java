package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {
    public b bnZ;
    private List<d> aCB = new LinkedList();
    private List<e> boa = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aCB.contains(dVar)) {
            this.aCB.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.boa.contains(eVar)) {
            this.boa.add(eVar);
        }
    }
}
