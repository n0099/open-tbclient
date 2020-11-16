package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<com.baidu.live.im.data.a> aSe;
    private com.baidu.live.im.data.a aSf;

    public static d EH() {
        return a.aSg;
    }

    public void j(com.baidu.live.im.data.a aVar) {
        if (this.aSe == null) {
            this.aSe = new ArrayList();
        }
        if (k(aVar) || this.aSe.size() < com.baidu.live.aa.a.Ph().bms.aLr) {
            this.aSe.add(aVar);
        }
    }

    private boolean k(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.aSe == null || this.aSe.isEmpty()) ? false : true;
    }

    public boolean EI() {
        return this.aSf != null;
    }

    public com.baidu.live.im.data.a EJ() {
        if (hasMsg()) {
            this.aSf = this.aSe.remove(0);
        } else {
            this.aSf = null;
        }
        return this.aSf;
    }

    public com.baidu.live.im.data.a EK() {
        return this.aSf;
    }

    public void release() {
        this.aSf = null;
        if (this.aSe != null) {
            this.aSe.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aSg = new d();
    }
}
