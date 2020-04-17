package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> ayc;
    private com.baidu.live.im.data.a ayd;

    public static d vx() {
        return a.aye;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.ayc == null) {
            this.ayc = new ArrayList();
        }
        if (d(aVar) || this.ayc.size() < com.baidu.live.v.a.Eo().aQp.atm) {
            this.ayc.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.ayc == null || this.ayc.isEmpty()) ? false : true;
    }

    public boolean vy() {
        return this.ayd != null;
    }

    public com.baidu.live.im.data.a vz() {
        if (hasMsg()) {
            this.ayd = this.ayc.remove(0);
        } else {
            this.ayd = null;
        }
        return this.ayd;
    }

    public com.baidu.live.im.data.a vA() {
        return this.ayd;
    }

    public void release() {
        this.ayd = null;
        if (this.ayc != null) {
            this.ayc.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aye = new d();
    }
}
