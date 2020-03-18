package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> afL;
    private com.baidu.live.im.data.a afM;

    public static d rf() {
        return a.afN;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.afL == null) {
            this.afL = new ArrayList();
        }
        if (d(aVar) || this.afL.size() < com.baidu.live.v.a.zs().awM.aaX) {
            this.afL.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.afL == null || this.afL.isEmpty()) ? false : true;
    }

    public boolean rg() {
        return this.afM != null;
    }

    public com.baidu.live.im.data.a rh() {
        if (hasMsg()) {
            this.afM = this.afL.remove(0);
        } else {
            this.afM = null;
        }
        return this.afM;
    }

    public com.baidu.live.im.data.a ri() {
        return this.afM;
    }

    public void release() {
        this.afM = null;
        if (this.afL != null) {
            this.afL.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d afN = new d();
    }
}
