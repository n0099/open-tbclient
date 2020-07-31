package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aHn;
    private com.baidu.live.im.data.a aHo;

    public static d xL() {
        return a.aHp;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aHn == null) {
            this.aHn = new ArrayList();
        }
        if (k(aVar) || this.aHn.size() < com.baidu.live.v.a.Hs().aZn.aBS) {
            this.aHn.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aHn == null || this.aHn.isEmpty()) ? false : true;
    }

    public boolean xM() {
        return this.aHo != null;
    }

    public com.baidu.live.im.data.a xN() {
        if (hasMsg()) {
            this.aHo = this.aHn.remove(0);
        } else {
            this.aHo = null;
        }
        return this.aHo;
    }

    public com.baidu.live.im.data.a xO() {
        return this.aHo;
    }

    public void release() {
        this.aHo = null;
        if (this.aHn != null) {
            this.aHn.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aHp = new d();
    }
}
