package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private List<com.baidu.live.im.data.b> aUQ;
    private com.baidu.live.im.data.b aUR;

    public static d Df() {
        return a.aUS;
    }

    public void j(com.baidu.live.im.data.b bVar) {
        if (this.aUQ == null) {
            this.aUQ = new ArrayList();
        }
        if (k(bVar) || this.aUQ.size() < com.baidu.live.ae.a.Qj().buX.aMT) {
            this.aUQ.add(bVar);
        }
    }

    private boolean k(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aUQ == null || this.aUQ.isEmpty()) ? false : true;
    }

    public boolean Dg() {
        return this.aUR != null;
    }

    public com.baidu.live.im.data.b Dh() {
        if (hasMsg()) {
            this.aUR = this.aUQ.remove(0);
        } else {
            this.aUR = null;
        }
        return this.aUR;
    }

    public com.baidu.live.im.data.b Di() {
        return this.aUR;
    }

    public void release() {
        this.aUR = null;
        if (this.aUQ != null) {
            this.aUQ.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d aUS = new d();
    }
}
