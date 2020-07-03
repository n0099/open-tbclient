package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b aYI;
    private List<d> avk = new LinkedList();
    private List<e> aYJ = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.avk.contains(dVar)) {
            this.avk.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.aYJ.contains(eVar)) {
            this.aYJ.add(eVar);
        }
    }
}
