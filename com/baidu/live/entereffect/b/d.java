package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private List<com.baidu.live.im.data.a> aMx;
    private com.baidu.live.im.data.a aMy;

    public static d Do() {
        return a.aMz;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aMx == null) {
            this.aMx = new ArrayList();
        }
        if (k(aVar) || this.aMx.size() < com.baidu.live.w.a.Nk().beH.aHc) {
            this.aMx.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aMx == null || this.aMx.isEmpty()) ? false : true;
    }

    public boolean Dp() {
        return this.aMy != null;
    }

    public com.baidu.live.im.data.a Dq() {
        if (hasMsg()) {
            this.aMy = this.aMx.remove(0);
        } else {
            this.aMy = null;
        }
        return this.aMy;
    }

    public com.baidu.live.im.data.a Dr() {
        return this.aMy;
    }

    public void release() {
        this.aMy = null;
        if (this.aMx != null) {
            this.aMx.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d aMz = new d();
    }
}
