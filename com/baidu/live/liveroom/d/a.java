package com.baidu.live.liveroom.d;

import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public b bnv;
    private List<d> aGc = new LinkedList();
    private List<e> bnw = new LinkedList();

    public void a(d dVar) {
        if (dVar != null && !this.aGc.contains(dVar)) {
            this.aGc.add(dVar);
        }
    }

    public void a(e eVar) {
        if (eVar != null && !this.bnw.contains(eVar)) {
            this.bnw.add(eVar);
        }
    }
}
