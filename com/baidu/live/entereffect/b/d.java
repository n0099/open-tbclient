package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aRC;
    private com.baidu.live.im.data.a aRD;

    public static d EC() {
        return a.aRE;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aRC == null) {
            this.aRC = new ArrayList();
        }
        if (k(aVar) || this.aRC.size() < com.baidu.live.x.a.OS().blo.aLy) {
            this.aRC.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aRC == null || this.aRC.isEmpty()) ? false : true;
    }

    public boolean ED() {
        return this.aRD != null;
    }

    public com.baidu.live.im.data.a EE() {
        if (hasMsg()) {
            this.aRD = this.aRC.remove(0);
        } else {
            this.aRD = null;
        }
        return this.aRD;
    }

    public com.baidu.live.im.data.a EF() {
        return this.aRD;
    }

    public void release() {
        this.aRD = null;
        if (this.aRC != null) {
            this.aRC.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aRE = new d();
    }
}
