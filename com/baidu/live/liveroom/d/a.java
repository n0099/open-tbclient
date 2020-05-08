package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b aPQ;
    private List<d> aoo = new LinkedList();
    private List<e> aPR = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aoo.contains(dVar)) {
            this.aoo.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.aPR.contains(eVar)) {
            this.aPR.add(eVar);
        }
    }
}
