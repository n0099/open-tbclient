package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b aYG;
    private List<d> awp = new LinkedList();
    private List<e> aYH = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.awp.contains(dVar)) {
            this.awp.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.aYH.contains(eVar)) {
            this.aYH.add(eVar);
        }
    }
}
