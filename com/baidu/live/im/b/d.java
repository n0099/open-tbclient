package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bv;
import com.baidu.live.data.cr;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private List<AlaLiveMarkData> bnx;
    private boolean bqi;
    private String bqj;

    public static d KQ() {
        return a.bqk;
    }

    private List<cr> a(boolean z, int i, List<cr> list, cr[] crVarArr, cr[] crVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean KW = KW();
        boolean KX = KX();
        boolean z3 = crVarArr != null && crVarArr.length > 0 && KW;
        boolean z4 = i > 2;
        if (crVarArr2 == null || crVarArr2.length <= 0 || KX) {
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

    public cr[] KR() {
        boolean z = true;
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        ArrayList arrayList = new ArrayList();
        if (bvVar != null && bvVar.aRp != null && bvVar.aRp.aTS && bvVar.aRm != null) {
            cr[] crVarArr = bvVar.aRm.aSR;
            if (crVarArr != null && crVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(crVarArr));
            }
            cr[] crVarArr2 = bvVar.aRm.aSW;
            cr[] crVarArr3 = bvVar.aRm.aSX;
            cr[] crVarArr4 = bvVar.aRm.aSY;
            boolean KW = KW();
            boolean KX = KX();
            boolean z2 = crVarArr2 != null && crVarArr2.length > 0 && KW;
            if (crVarArr3 == null || crVarArr3.length <= 0 || KX) {
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

    public cr[] a(boolean z, int i, boolean z2) {
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        List<cr> arrayList = new ArrayList<>();
        if (bvVar != null && bvVar.aRp != null && bvVar.aRp.aTS && bvVar.aRm != null) {
            cr[] crVarArr = bvVar.aRm.aSR;
            if (crVarArr != null && crVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(crVarArr));
            }
            if (z2) {
                cr[] crVarArr2 = bvVar.aRm.aSY;
                if (crVarArr2 != null && crVarArr2.length > 0) {
                    arrayList.addAll(0, Arrays.asList(crVarArr2));
                }
            } else {
                arrayList = a(z, i, arrayList, bvVar.aRm.aSW, bvVar.aRm.aSX);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (cr[]) arrayList.toArray(new cr[arrayList.size()]);
    }

    public cr[] KS() {
        return dB(0);
    }

    public cr[] dB(int i) {
        List<cr> list;
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar == null || bvVar.aRp == null || !bvVar.aRp.aTS || bvVar.aRm == null) {
            list = null;
        } else {
            cr[] crVarArr = bvVar.aRm.aSR;
            list = a(false, i, (crVarArr == null || crVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(crVarArr)), null, bvVar.aRm.aSX);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (cr[]) list.toArray(new cr[list.size()]);
    }

    public boolean KT() {
        return this.bqi;
    }

    public void setSwitchStatus(boolean z) {
        this.bqi = z;
    }

    public String KU() {
        return this.bqj;
    }

    public void setSelectId(String str) {
        this.bqj = str;
    }

    public List<AlaLiveMarkData> KV() {
        return this.bnx;
    }

    public void W(List<AlaLiveMarkData> list) {
        if (this.bnx == null) {
            this.bnx = new ArrayList();
        }
        this.bnx.clear();
        if (list != null && !list.isEmpty()) {
            this.bnx.addAll(list);
        }
    }

    public void release() {
        this.bqi = false;
        this.bqj = null;
        if (this.bnx != null) {
            this.bnx.clear();
        }
    }

    private d() {
        this.bqi = false;
    }

    private boolean KW() {
        return com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aOz && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
    }

    private boolean KX() {
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        return TbadkCoreApplication.getInst().isMobileBaidu() || !(bvVar == null || bvVar.aRp == null || bvVar.aRp.aUa) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final d bqk = new d();
    }
}
