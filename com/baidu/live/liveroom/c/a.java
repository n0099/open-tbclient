package com.baidu.live.liveroom.c;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public b arV;
    private List<d> Un = new LinkedList();
    private List<e> arW = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.Un.contains(dVar)) {
            this.Un.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.arW.contains(eVar)) {
            this.arW.add(eVar);
        }
    }
}
