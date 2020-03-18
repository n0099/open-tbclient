package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public b awh;
    private List<d> Wh = new LinkedList();
    private List<e> awi = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.Wh.contains(dVar)) {
            this.Wh.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.awi.contains(eVar)) {
            this.awi.add(eVar);
        }
    }
}
