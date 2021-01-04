package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    public b bsL;
    private List<d> aHo = new LinkedList();
    private List<e> bsM = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aHo.contains(dVar)) {
            this.aHo.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bsM.contains(eVar)) {
            this.bsM.add(eVar);
        }
    }
}
