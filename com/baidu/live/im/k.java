package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.af;
import com.baidu.live.data.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k {
    private int aep;
    private List<AlaLiveMarkData> afL;
    private boolean agn;

    public static k sN() {
        return a.ago;
    }

    public ao[] sO() {
        ao[] aoVarArr;
        boolean z = false;
        af afVar = com.baidu.live.l.a.uB().aku;
        if (afVar == null || afVar.TO == null || !afVar.TO.UR || afVar.TK == null) {
            aoVarArr = null;
        } else {
            aoVarArr = afVar.TK.Uo;
            if (aoVarArr != null && aoVarArr.length > 0) {
                z = true;
            }
        }
        if (z) {
            return aoVarArr;
        }
        return null;
    }

    public boolean sP() {
        return this.agn;
    }

    public void ax(boolean z) {
        if (z && !this.agn) {
            setSelect(0);
        }
        if (!z) {
            setSelect(-1);
        }
        this.agn = z;
    }

    public int getSelect() {
        return this.aep;
    }

    public void setSelect(int i) {
        this.aep = i;
    }

    public List<AlaLiveMarkData> sQ() {
        return this.afL;
    }

    public void F(List<AlaLiveMarkData> list) {
        if (this.afL == null) {
            this.afL = new ArrayList();
        }
        this.afL.clear();
        if (list != null && !list.isEmpty()) {
            this.afL.addAll(list);
        }
    }

    public void release() {
        this.agn = false;
        this.aep = -1;
        if (this.afL != null) {
            this.afL.clear();
        }
    }

    private k() {
        this.agn = false;
        this.aep = -1;
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final k ago = new k();
    }
}
