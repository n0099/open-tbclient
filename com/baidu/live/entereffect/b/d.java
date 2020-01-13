package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private com.baidu.live.im.data.a adA;
    private List<com.baidu.live.im.data.a> adz;

    public static d qp() {
        return a.adB;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.adz == null) {
            this.adz = new ArrayList();
        }
        if (d(aVar) || this.adz.size() < com.baidu.live.s.a.wR().asq.YV) {
            this.adz.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.adz == null || this.adz.isEmpty()) ? false : true;
    }

    public boolean qq() {
        return this.adA != null;
    }

    public com.baidu.live.im.data.a qr() {
        if (hasMsg()) {
            this.adA = this.adz.remove(0);
        } else {
            this.adA = null;
        }
        return this.adA;
    }

    public com.baidu.live.im.data.a qs() {
        return this.adA;
    }

    public void release() {
        this.adA = null;
        if (this.adz != null) {
            this.adz.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final d adB = new d();
    }
}
