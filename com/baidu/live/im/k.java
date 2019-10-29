package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.af;
import com.baidu.live.data.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k {
    private int aeH;
    private boolean agF;
    private List<AlaLiveMarkData> agd;

    public static k sM() {
        return a.agG;
    }

    public ao[] sN() {
        ao[] aoVarArr;
        boolean z = false;
        af afVar = com.baidu.live.l.a.uA().akM;
        if (afVar == null || afVar.Uh == null || !afVar.Uh.Vk || afVar.Ue == null) {
            aoVarArr = null;
        } else {
            aoVarArr = afVar.Ue.UJ;
            if (aoVarArr != null && aoVarArr.length > 0) {
                z = true;
            }
        }
        if (z) {
            return aoVarArr;
        }
        return null;
    }

    public boolean sO() {
        return this.agF;
    }

    public void ax(boolean z) {
        if (z && !this.agF) {
            setSelect(0);
        }
        if (!z) {
            setSelect(-1);
        }
        this.agF = z;
    }

    public int getSelect() {
        return this.aeH;
    }

    public void setSelect(int i) {
        this.aeH = i;
    }

    public List<AlaLiveMarkData> sP() {
        return this.agd;
    }

    public void E(List<AlaLiveMarkData> list) {
        if (this.agd == null) {
            this.agd = new ArrayList();
        }
        this.agd.clear();
        if (list != null && !list.isEmpty()) {
            this.agd.addAll(list);
        }
    }

    public void release() {
        this.agF = false;
        this.aeH = -1;
        if (this.agd != null) {
            this.agd.clear();
        }
    }

    private k() {
        this.agF = false;
        this.aeH = -1;
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final k agG = new k();
    }
}
