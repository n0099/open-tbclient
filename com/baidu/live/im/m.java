package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bb;
import com.baidu.live.data.bo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class m {
    private List<AlaLiveMarkData> aTH;
    private boolean aUD;
    private String aUE;

    public static m Dm() {
        return a.aUF;
    }

    private List<bo> a(boolean z, int i, List<bo> list, bo[] boVarArr, bo[] boVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.v.a.Hm().aZp != null && com.baidu.live.v.a.Hm().aZp.aAK && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bbVar == null || bbVar.aCW == null || bbVar.aCW.aER) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = boVarArr != null && boVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (boVarArr2 == null || boVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(boVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(boVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(boVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(boVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(boVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(boVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(boVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(boVarArr2));
            }
        }
        return list;
    }

    public bo[] Dn() {
        return e(false, 0);
    }

    public bo[] e(boolean z, int i) {
        List<bo> list;
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (bbVar == null || bbVar.aCW == null || !bbVar.aCW.aEJ || bbVar.aCT == null) {
            list = null;
        } else {
            bo[] boVarArr = bbVar.aCT.aDN;
            list = a(z, i, (boVarArr == null || boVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(boVarArr)), bbVar.aCT.aDT, bbVar.aCT.aDU);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bo[]) list.toArray(new bo[list.size()]);
    }

    public boolean Do() {
        return this.aUD;
    }

    public void setSwitchStatus(boolean z) {
        this.aUD = z;
    }

    public String Dp() {
        return this.aUE;
    }

    public void setSelectId(String str) {
        this.aUE = str;
    }

    public List<AlaLiveMarkData> Dq() {
        return this.aTH;
    }

    public void L(List<AlaLiveMarkData> list) {
        if (this.aTH == null) {
            this.aTH = new ArrayList();
        }
        this.aTH.clear();
        if (list != null && !list.isEmpty()) {
            this.aTH.addAll(list);
        }
    }

    public void release() {
        this.aUD = false;
        this.aUE = null;
        if (this.aTH != null) {
            this.aTH.clear();
        }
    }

    private m() {
        this.aUD = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final m aUF = new m();
    }
}
