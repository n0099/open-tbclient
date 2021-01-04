package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private com.baidu.live.im.data.b aWA;
    private List<com.baidu.live.im.data.b> aWz;

    public static e FQ() {
        return a.aWC;
    }

    public void j(com.baidu.live.im.data.b bVar) {
        if (this.aWz == null) {
            this.aWz = new ArrayList();
        }
        if (k(bVar) || this.aWz.size() < com.baidu.live.af.a.SE().bwi.aOT) {
            this.aWz.add(bVar);
        }
    }

    private boolean k(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aWz == null || this.aWz.isEmpty()) ? false : true;
    }

    public boolean FM() {
        return this.aWA != null;
    }

    public com.baidu.live.im.data.b FN() {
        if (hasMsg()) {
            this.aWA = this.aWz.remove(0);
        } else {
            this.aWA = null;
        }
        return this.aWA;
    }

    public com.baidu.live.im.data.b FO() {
        return this.aWA;
    }

    public void release() {
        this.aWA = null;
        if (this.aWz != null) {
            this.aWz.clear();
        }
    }

    private e() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final e aWC = new e();
    }
}
