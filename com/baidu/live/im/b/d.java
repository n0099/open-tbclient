package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bv;
import com.baidu.live.data.cr;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private List<AlaLiveMarkData> blW;
    private boolean boI;
    private String boJ;

    public static d KN() {
        return a.boK;
    }

    private List<cr> a(boolean z, int i, List<cr> list, cr[] crVarArr, cr[] crVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean KT = KT();
        boolean KU = KU();
        boolean z3 = crVarArr != null && crVarArr.length > 0 && KT;
        boolean z4 = i > 2;
        if (crVarArr2 == null || crVarArr2.length <= 0 || KU) {
            z2 = false;
        }
        if (z && z4) {
            if (z2) {
                list.addAll(0, Arrays.asList(crVarArr2));
            }
            if (z3) {
                list.addAll(0, Arrays.asList(crVarArr));
            }
        } else if (z) {
            if (z3) {
                list.addAll(0, Arrays.asList(crVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(crVarArr2));
            }
        } else if (z4) {
            if (z2) {
                list.addAll(0, Arrays.asList(crVarArr2));
            }
            if (z3) {
                list.addAll(Arrays.asList(crVarArr));
            }
        } else {
            if (z3) {
                list.addAll(Arrays.asList(crVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(crVarArr2));
            }
        }
        return list;
    }

    public cr[] KO() {
        boolean z = true;
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        ArrayList arrayList = new ArrayList();
        if (bvVar != null && bvVar.aPP != null && bvVar.aPP.aSs && bvVar.aPM != null) {
            cr[] crVarArr = bvVar.aPM.aRr;
            if (crVarArr != null && crVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(crVarArr));
            }
            cr[] crVarArr2 = bvVar.aPM.aRw;
            cr[] crVarArr3 = bvVar.aPM.aRx;
            cr[] crVarArr4 = bvVar.aPM.aRy;
            boolean KT = KT();
            boolean KU = KU();
            boolean z2 = crVarArr2 != null && crVarArr2.length > 0 && KT;
            if (crVarArr3 == null || crVarArr3.length <= 0 || KU) {
                z = false;
            }
            if (z2) {
                arrayList.addAll(Arrays.asList(crVarArr2));
            }
            if (z) {
                arrayList.addAll(Arrays.asList(crVarArr3));
            }
            if (crVarArr4 != null && crVarArr4.length > 0) {
                arrayList.addAll(Arrays.asList(crVarArr4));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (cr[]) arrayList.toArray(new cr[arrayList.size()]);
    }

    public cr[] b(boolean z, int i, boolean z2) {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        List<cr> arrayList = new ArrayList<>();
        if (bvVar != null && bvVar.aPP != null && bvVar.aPP.aSs && bvVar.aPM != null) {
            cr[] crVarArr = bvVar.aPM.aRr;
            if (crVarArr != null && crVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(crVarArr));
            }
            if (z2) {
                cr[] crVarArr2 = bvVar.aPM.aRy;
                if (crVarArr2 != null && crVarArr2.length > 0) {
                    arrayList.addAll(0, Arrays.asList(crVarArr2));
                }
            } else {
                arrayList = a(z, i, arrayList, bvVar.aPM.aRw, bvVar.aPM.aRx);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (cr[]) arrayList.toArray(new cr[arrayList.size()]);
    }

    public cr[] KP() {
        return dA(0);
    }

    public cr[] dA(int i) {
        List<cr> list;
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar == null || bvVar.aPP == null || !bvVar.aPP.aSs || bvVar.aPM == null) {
            list = null;
        } else {
            cr[] crVarArr = bvVar.aPM.aRr;
            list = a(false, i, (crVarArr == null || crVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(crVarArr)), null, bvVar.aPM.aRx);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cr[]) list.toArray(new cr[list.size()]);
    }

    public boolean KQ() {
        return this.boI;
    }

    public void setSwitchStatus(boolean z) {
        this.boI = z;
    }

    public String KR() {
        return this.boJ;
    }

    public void setSelectId(String str) {
        this.boJ = str;
    }

    public List<AlaLiveMarkData> KS() {
        return this.blW;
    }

    public void W(List<AlaLiveMarkData> list) {
        if (this.blW == null) {
            this.blW = new ArrayList();
        }
        this.blW.clear();
        if (list != null && !list.isEmpty()) {
            this.blW.addAll(list);
        }
    }

    public void release() {
        this.boI = false;
        this.boJ = null;
        if (this.blW != null) {
            this.blW.clear();
        }
    }

    private d() {
        this.boI = false;
    }

    private boolean KT() {
        return com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMZ && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
    }

    private boolean KU() {
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        return TbadkCoreApplication.getInst().isMobileBaidu() || !(bvVar == null || bvVar.aPP == null || bvVar.aPP.aSA) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final d boK = new d();
    }
}
