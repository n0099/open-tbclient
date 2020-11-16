package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b blK;
    private List<d> aEr = new LinkedList();
    private List<e> blL = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aEr.contains(dVar)) {
            this.aEr.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.blL.contains(eVar)) {
            this.blL.add(eVar);
        }
    }
}
