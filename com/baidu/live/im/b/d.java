package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bm;
import com.baidu.live.data.ce;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<AlaLiveMarkData> bhP;
    private boolean bjT;
    private String bjU;

    public static d LG() {
        return a.bjV;
    }

    private List<ce> a(boolean z, int i, List<ce> list, ce[] ceVarArr, ce[] ceVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.z.a.Pq().bmJ != null && com.baidu.live.z.a.Pq().bmJ.aMi && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bmVar == null || bmVar.aOD == null || bmVar.aOD.aQU) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = ceVarArr != null && ceVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (ceVarArr2 == null || ceVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(ceVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(ceVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(ceVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ceVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(ceVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(ceVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(ceVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ceVarArr2));
            }
        }
        return list;
    }

    public ce[] LH() {
        return e(false, 0);
    }

    public ce[] e(boolean z, int i) {
        List<ce> list;
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar == null || bmVar.aOD == null || !bmVar.aOD.aQM || bmVar.aOA == null) {
            list = null;
        } else {
            ce[] ceVarArr = bmVar.aOA.aPN;
            list = a(z, i, (ceVarArr == null || ceVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ceVarArr)), bmVar.aOA.aPT, bmVar.aOA.aPU);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ce[]) list.toArray(new ce[list.size()]);
    }

    public ce[] LI() {
        return eK(0);
    }

    public ce[] eK(int i) {
        List<ce> list;
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (bmVar == null || bmVar.aOD == null || !bmVar.aOD.aQM || bmVar.aOA == null) {
            list = null;
        } else {
            ce[] ceVarArr = bmVar.aOA.aPN;
            list = a(false, i, (ceVarArr == null || ceVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ceVarArr)), null, bmVar.aOA.aPU);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ce[]) list.toArray(new ce[list.size()]);
    }

    public boolean LJ() {
        return this.bjT;
    }

    public void setSwitchStatus(boolean z) {
        this.bjT = z;
    }

    public String LK() {
        return this.bjU;
    }

    public void setSelectId(String str) {
        this.bjU = str;
    }

    public List<AlaLiveMarkData> LL() {
        return this.bhP;
    }

    public void U(List<AlaLiveMarkData> list) {
        if (this.bhP == null) {
            this.bhP = new ArrayList();
        }
        this.bhP.clear();
        if (list != null && !list.isEmpty()) {
            this.bhP.addAll(list);
        }
    }

    public void release() {
        this.bjT = false;
        this.bjU = null;
        if (this.bhP != null) {
            this.bhP.clear();
        }
    }

    private d() {
        this.bjT = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d bjV = new d();
    }
}
