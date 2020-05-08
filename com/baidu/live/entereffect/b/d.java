package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> ayi;
    private com.baidu.live.im.data.a ayj;

    public static d vw() {
        return a.ayk;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.ayi == null) {
            this.ayi = new ArrayList();
        }
        if (d(aVar) || this.ayi.size() < com.baidu.live.v.a.En().aQu.ats) {
            this.ayi.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.ayi == null || this.ayi.isEmpty()) ? false : true;
    }

    public boolean vx() {
        return this.ayj != null;
    }

    public com.baidu.live.im.data.a vy() {
        if (hasMsg()) {
            this.ayj = this.ayi.remove(0);
        } else {
            this.ayj = null;
        }
        return this.ayj;
    }

    public com.baidu.live.im.data.a vz() {
        return this.ayj;
    }

    public void release() {
        this.ayj = null;
        if (this.ayi != null) {
            this.ayi.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d ayk = new d();
    }
}
