package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private List<com.baidu.live.im.data.a> aFS;
    private com.baidu.live.im.data.a aFT;

    public static d xi() {
        return a.aFU;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.aFS == null) {
            this.aFS = new ArrayList();
        }
        if (d(aVar) || this.aFS.size() < com.baidu.live.v.a.Hm().aZp.aAF) {
            this.aFS.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aFS == null || this.aFS.isEmpty()) ? false : true;
    }

    public boolean xj() {
        return this.aFT != null;
    }

    public com.baidu.live.im.data.a xk() {
        if (hasMsg()) {
            this.aFT = this.aFS.remove(0);
        } else {
            this.aFT = null;
        }
        return this.aFT;
    }

    public com.baidu.live.im.data.a xl() {
        return this.aFT;
    }

    public void release() {
        this.aFT = null;
        if (this.aFS != null) {
            this.aFS.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d aFU = new d();
    }
}
