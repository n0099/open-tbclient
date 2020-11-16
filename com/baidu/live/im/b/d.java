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
    private List<AlaLiveMarkData> bhx;
    private boolean bjC;
    private String bjD;

    public static d Lx() {
        return a.bjE;
    }

    private List<cg> a(boolean z, int i, List<cg> list, cg[] cgVarArr, cg[] cgVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aLx && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bnVar == null || bnVar.aNP == null || bnVar.aNP.aQl) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
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

    public cg[] Ly() {
        return e(false, 0);
    }

    public cg[] e(boolean z, int i) {
        List<cg> list;
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar == null || bnVar.aNP == null || !bnVar.aNP.aQd || bnVar.aNM == null) {
            list = null;
        } else {
            cg[] cgVarArr = bnVar.aNM.aPe;
            list = a(z, i, (cgVarArr == null || cgVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(cgVarArr)), bnVar.aNM.aPk, bnVar.aNM.aPl);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cg[]) list.toArray(new cg[list.size()]);
    }

    public cg[] Lz() {
        return eG(0);
    }

    public cg[] eG(int i) {
        List<cg> list;
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar == null || bnVar.aNP == null || !bnVar.aNP.aQd || bnVar.aNM == null) {
            list = null;
        } else {
            cg[] cgVarArr = bnVar.aNM.aPe;
            list = a(false, i, (cgVarArr == null || cgVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(cgVarArr)), null, bnVar.aNM.aPl);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cg[]) list.toArray(new cg[list.size()]);
    }

    public boolean LA() {
        return this.bjC;
    }

    public void setSwitchStatus(boolean z) {
        this.bjC = z;
    }

    public String LB() {
        return this.bjD;
    }

    public void setSelectId(String str) {
        this.bjD = str;
    }

    public List<AlaLiveMarkData> LC() {
        return this.bhx;
    }

    public void U(List<AlaLiveMarkData> list) {
        if (this.bhx == null) {
            this.bhx = new ArrayList();
        }
        this.bhx.clear();
        if (list != null && !list.isEmpty()) {
            this.bhx.addAll(list);
        }
    }

    public void release() {
        this.bjC = false;
        this.bjD = null;
        if (this.bhx != null) {
            this.bhx.clear();
        }
    }

    private d() {
        this.bjC = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d bjE = new d();
    }
}
