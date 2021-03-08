package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private List<com.baidu.live.im.data.b> aWq;
    private com.baidu.live.im.data.b aWr;

    public static e Dn() {
        return a.aWt;
    }

    public void j(com.baidu.live.im.data.b bVar) {
        if (this.aWq == null) {
            this.aWq = new ArrayList();
        }
        if (k(bVar) || this.aWq.size() < com.baidu.live.ae.a.Qm().bwx.aOt) {
            this.aWq.add(bVar);
        }
    }

    private boolean k(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aWq == null || this.aWq.isEmpty()) ? false : true;
    }

    public boolean Dj() {
        return this.aWr != null;
    }

    public com.baidu.live.im.data.b Dk() {
        if (hasMsg()) {
            this.aWr = this.aWq.remove(0);
        } else {
            this.aWr = null;
        }
        return this.aWr;
    }

    public com.baidu.live.im.data.b Dl() {
        return this.aWr;
    }

    public void release() {
        this.aWr = null;
        if (this.aWq != null) {
            this.aWq.clear();
        }
    }

    private e() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final e aWt = new e();
    }
}
