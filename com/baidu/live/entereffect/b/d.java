package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private List<com.baidu.live.im.data.b> aRM;
    private com.baidu.live.im.data.b aRN;

    public static d BQ() {
        return a.aRO;
    }

    public void j(com.baidu.live.im.data.b bVar) {
        if (this.aRM == null) {
            this.aRM = new ArrayList();
        }
        if (k(bVar) || this.aRM.size() < com.baidu.live.af.a.OJ().bru.aKg) {
            this.aRM.add(bVar);
        }
    }

    private boolean k(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aRM == null || this.aRM.isEmpty()) ? false : true;
    }

    public boolean BR() {
        return this.aRN != null;
    }

    public com.baidu.live.im.data.b BS() {
        if (hasMsg()) {
            this.aRN = this.aRM.remove(0);
        } else {
            this.aRN = null;
        }
        return this.aRN;
    }

    public com.baidu.live.im.data.b BT() {
        return this.aRN;
    }

    public void release() {
        this.aRN = null;
        if (this.aRM != null) {
            this.aRM.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d aRO = new d();
    }
}
