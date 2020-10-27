package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aSw;
    private com.baidu.live.im.data.a aSx;

    public static d EP() {
        return a.aSy;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aSw == null) {
            this.aSw = new ArrayList();
        }
        if (k(aVar) || this.aSw.size() < com.baidu.live.z.a.Pq().bmJ.aMc) {
            this.aSw.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aSw == null || this.aSw.isEmpty()) ? false : true;
    }

    public boolean EQ() {
        return this.aSx != null;
    }

    public com.baidu.live.im.data.a ER() {
        if (hasMsg()) {
            this.aSx = this.aSw.remove(0);
        } else {
            this.aSx = null;
        }
        return this.aSx;
    }

    public com.baidu.live.im.data.a ES() {
        return this.aSx;
    }

    public void release() {
        this.aSx = null;
        if (this.aSw != null) {
            this.aSw.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aSy = new d();
    }
}
