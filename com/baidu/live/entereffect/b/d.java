package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> aDA;
    private com.baidu.live.im.data.a aDB;

    public static d wL() {
        return a.aDC;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.aDA == null) {
            this.aDA = new ArrayList();
        }
        if (d(aVar) || this.aDA.size() < com.baidu.live.v.a.Ge().aWF.ayq) {
            this.aDA.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aDA == null || this.aDA.isEmpty()) ? false : true;
    }

    public boolean wM() {
        return this.aDB != null;
    }

    public com.baidu.live.im.data.a wN() {
        if (hasMsg()) {
            this.aDB = this.aDA.remove(0);
        } else {
            this.aDB = null;
        }
        return this.aDB;
    }

    public com.baidu.live.im.data.a wO() {
        return this.aDB;
    }

    public void release() {
        this.aDB = null;
        if (this.aDA != null) {
            this.aDA.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aDC = new d();
    }
}
