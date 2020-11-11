package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bn;
import com.baidu.live.data.cg;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<AlaLiveMarkData> bjl;
    private boolean bln;
    private String blo;

    public static d Mg() {
        return a.blp;
    }

    private List<cg> a(boolean z, int i, List<cg> list, cg[] cgVarArr, cg[] cgVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.aa.a.PQ().bod != null && com.baidu.live.aa.a.PQ().bod.aNi && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bnVar == null || bnVar.aPA == null || bnVar.aPA.aRW) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = cgVarArr != null && cgVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (cgVarArr2 == null || cgVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(cgVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(cgVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(cgVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(cgVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(cgVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(cgVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(cgVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(cgVarArr2));
            }
        }
        return list;
    }

    public cg[] Mh() {
        return e(false, 0);
    }

    public cg[] e(boolean z, int i) {
        List<cg> list;
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar == null || bnVar.aPA == null || !bnVar.aPA.aRO || bnVar.aPx == null) {
            list = null;
        } else {
            cg[] cgVarArr = bnVar.aPx.aQP;
            list = a(z, i, (cgVarArr == null || cgVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(cgVarArr)), bnVar.aPx.aQV, bnVar.aPx.aQW);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cg[]) list.toArray(new cg[list.size()]);
    }

    public cg[] Mi() {
        return eK(0);
    }

    public cg[] eK(int i) {
        List<cg> list;
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (bnVar == null || bnVar.aPA == null || !bnVar.aPA.aRO || bnVar.aPx == null) {
            list = null;
        } else {
            cg[] cgVarArr = bnVar.aPx.aQP;
            list = a(false, i, (cgVarArr == null || cgVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(cgVarArr)), null, bnVar.aPx.aQW);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cg[]) list.toArray(new cg[list.size()]);
    }

    public boolean Mj() {
        return this.bln;
    }

    public void setSwitchStatus(boolean z) {
        this.bln = z;
    }

    public String Mk() {
        return this.blo;
    }

    public void setSelectId(String str) {
        this.blo = str;
    }

    public List<AlaLiveMarkData> Ml() {
        return this.bjl;
    }

    public void U(List<AlaLiveMarkData> list) {
        if (this.bjl == null) {
            this.bjl = new ArrayList();
        }
        this.bjl.clear();
        if (list != null && !list.isEmpty()) {
            this.bjl.addAll(list);
        }
    }

    public void release() {
        this.bln = false;
        this.blo = null;
        if (this.bjl != null) {
            this.bjl.clear();
        }
    }

    private d() {
        this.bln = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d blp = new d();
    }
}
