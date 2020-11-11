package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aTP;
    private com.baidu.live.im.data.a aTQ;

    public static d Fq() {
        return a.aTR;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aTP == null) {
            this.aTP = new ArrayList();
        }
        if (k(aVar) || this.aTP.size() < com.baidu.live.aa.a.PQ().bod.aNc) {
            this.aTP.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aTP == null || this.aTP.isEmpty()) ? false : true;
    }

    public boolean Fr() {
        return this.aTQ != null;
    }

    public com.baidu.live.im.data.a Fs() {
        if (hasMsg()) {
            this.aTQ = this.aTP.remove(0);
        } else {
            this.aTQ = null;
        }
        return this.aTQ;
    }

    public com.baidu.live.im.data.a Ft() {
        return this.aTQ;
    }

    public void release() {
        this.aTQ = null;
        if (this.aTP != null) {
            this.aTP.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aTR = new d();
    }
}
