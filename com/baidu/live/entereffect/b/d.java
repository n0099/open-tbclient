package com.baidu.live.entereffect.b;

import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private List<com.baidu.live.im.data.a> VJ;
    private com.baidu.live.im.data.a VK;

    public static d oO() {
        return a.VL;
    }

    public void c(com.baidu.live.im.data.a aVar) {
        if (this.VJ == null) {
            this.VJ = new ArrayList();
        }
        if (d(aVar) || this.VJ.size() < com.baidu.live.l.a.uB().ajF.RX) {
            this.VJ.add(aVar);
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean hasMsg() {
        return (this.VJ == null || this.VJ.isEmpty()) ? false : true;
    }

    public boolean oP() {
        return this.VK != null;
    }

    public com.baidu.live.im.data.a oQ() {
        if (hasMsg()) {
            this.VK = this.VJ.remove(0);
        } else {
            this.VK = null;
        }
        return this.VK;
    }

    public com.baidu.live.im.data.a oR() {
        return this.VK;
    }

    public void release() {
        this.VK = null;
        if (this.VJ != null) {
            this.VJ.clear();
        }
    }

    private d() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final d VL = new d();
    }
}
