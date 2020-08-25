package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public b bdX;
    private List<d> aBr = new LinkedList();
    private List<e> bdY = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aBr.contains(dVar)) {
            this.aBr.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bdY.contains(eVar)) {
            this.bdY.add(eVar);
        }
    }
}
