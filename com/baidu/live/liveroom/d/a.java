package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b bmb;
    private List<d> aFm = new LinkedList();
    private List<e> bmc = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aFm.contains(dVar)) {
            this.aFm.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bmc.contains(eVar)) {
            this.bmc.add(eVar);
        }
    }
}
