package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {
    private List<com.baidu.live.im.data.b> aVg;
    private com.baidu.live.im.data.b aVh;

    public static e Gx() {
        return a.aVj;
    }

    public void j(com.baidu.live.im.data.b bVar) {
        if (this.aVg == null) {
            this.aVg = new ArrayList();
        }
        if (k(bVar) || this.aVg.size() < com.baidu.live.ae.a.RB().brA.aOm) {
            this.aVg.add(bVar);
        }
    }

    private boolean k(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aVg == null || this.aVg.isEmpty()) ? false : true;
    }

    public boolean Gt() {
        return this.aVh != null;
    }

    public com.baidu.live.im.data.b Gu() {
        if (hasMsg()) {
            this.aVh = this.aVg.remove(0);
        } else {
            this.aVh = null;
        }
        return this.aVh;
    }

    public com.baidu.live.im.data.b Gv() {
        return this.aVh;
    }

    public void release() {
        this.aVh = null;
        if (this.aVg != null) {
            this.aVg.clear();
        }
    }

    private e() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final e aVj = new e();
    }
}
