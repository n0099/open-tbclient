package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private List<com.baidu.live.im.data.a> adk;
    private com.baidu.live.im.data.a adl;

    public static d qi() {
        return a.adm;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.adk == null) {
            this.adk = new ArrayList();
        }
        if (d(aVar) || this.adk.size() < com.baidu.live.r.a.wA().arE.YJ) {
            this.adk.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.adk == null || this.adk.isEmpty()) ? false : true;
    }

    public boolean qj() {
        return this.adl != null;
    }

    public com.baidu.live.im.data.a qk() {
        if (hasMsg()) {
            this.adl = this.adk.remove(0);
        } else {
            this.adl = null;
        }
        return this.adl;
    }

    public com.baidu.live.im.data.a ql() {
        return this.adl;
    }

    public void release() {
        this.adl = null;
        if (this.adk != null) {
            this.adk.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final d adm = new d();
    }
}
