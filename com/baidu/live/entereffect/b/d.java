package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aOr;
    private com.baidu.live.im.data.a aOs;

    public static d DF() {
        return a.aOt;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aOr == null) {
            this.aOr = new ArrayList();
        }
        if (k(aVar) || this.aOr.size() < com.baidu.live.x.a.NN().bhy.aIu) {
            this.aOr.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aOr == null || this.aOr.isEmpty()) ? false : true;
    }

    public boolean DG() {
        return this.aOs != null;
    }

    public com.baidu.live.im.data.a DH() {
        if (hasMsg()) {
            this.aOs = this.aOr.remove(0);
        } else {
            this.aOs = null;
        }
        return this.aOs;
    }

    public com.baidu.live.im.data.a DI() {
        return this.aOs;
    }

    public void release() {
        this.aOs = null;
        if (this.aOr != null) {
            this.aOr.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aOt = new d();
    }
}
