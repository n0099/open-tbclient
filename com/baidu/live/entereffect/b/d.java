package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> afB;
    private com.baidu.live.im.data.a afC;

    public static d ra() {
        return a.afD;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.afB == null) {
            this.afB = new ArrayList();
        }
        if (d(aVar) || this.afB.size() < com.baidu.live.v.a.zl().awB.aaN) {
            this.afB.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.afB == null || this.afB.isEmpty()) ? false : true;
    }

    public boolean rb() {
        return this.afC != null;
    }

    public com.baidu.live.im.data.a rc() {
        if (hasMsg()) {
            this.afC = this.afB.remove(0);
        } else {
            this.afC = null;
        }
        return this.afC;
    }

    public com.baidu.live.im.data.a rd() {
        return this.afC;
    }

    public void release() {
        this.afC = null;
        if (this.afB != null) {
            this.afB.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d afD = new d();
    }
}
