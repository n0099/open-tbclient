package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private com.baidu.live.im.data.a aMA;
    private List<com.baidu.live.im.data.a> aMz;

    public static d Do() {
        return a.aMB;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aMz == null) {
            this.aMz = new ArrayList();
        }
        if (k(aVar) || this.aMz.size() < com.baidu.live.w.a.Nk().beJ.aHe) {
            this.aMz.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aMz == null || this.aMz.isEmpty()) ? false : true;
    }

    public boolean Dp() {
        return this.aMA != null;
    }

    public com.baidu.live.im.data.a Dq() {
        if (hasMsg()) {
            this.aMA = this.aMz.remove(0);
        } else {
            this.aMA = null;
        }
        return this.aMA;
    }

    public com.baidu.live.im.data.a Dr() {
        return this.aMA;
    }

    public void release() {
        this.aMA = null;
        if (this.aMz != null) {
            this.aMz.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d aMB = new d();
    }
}
