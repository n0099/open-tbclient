package com.baidu.live.liveroom.c;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public b arj;
    private List<d> TW = new LinkedList();
    private List<e> ark = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.TW.contains(dVar)) {
            this.TW.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.ark.contains(eVar)) {
            this.ark.add(eVar);
        }
    }
}
