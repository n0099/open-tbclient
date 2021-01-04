package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bq;
import com.baidu.live.data.ck;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private List<AlaLiveMarkData> bnr;
    private boolean bqa;
    private String bqb;

    public static d Nk() {
        return a.bqc;
    }

    private List<ck> a(boolean z, int i, List<ck> list, ck[] ckVarArr, ck[] ckVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean Nq = Nq();
        boolean Nr = Nr();
        boolean z3 = ckVarArr != null && ckVarArr.length > 0 && Nq;
        boolean z4 = i > 2;
        if (ckVarArr2 == null || ckVarArr2.length <= 0 || Nr) {
            z2 = false;
        }
        if (z && z4) {
            if (z2) {
                list.addAll(0, Arrays.asList(ckVarArr2));
            }
            if (z3) {
                list.addAll(0, Arrays.asList(ckVarArr));
            }
        } else if (z) {
            if (z3) {
                list.addAll(0, Arrays.asList(ckVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ckVarArr2));
            }
        } else if (z4) {
            if (z2) {
                list.addAll(0, Arrays.asList(ckVarArr2));
            }
            if (z3) {
                list.addAll(Arrays.asList(ckVarArr));
            }
        } else {
            if (z3) {
                list.addAll(Arrays.asList(ckVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ckVarArr2));
            }
        }
        return list;
    }

    public ck[] Nl() {
        boolean z = true;
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        ArrayList arrayList = new ArrayList();
        if (bqVar != null && bqVar.aRE != null && bqVar.aRE.aUd && bqVar.aRB != null) {
            ck[] ckVarArr = bqVar.aRB.aTb;
            if (ckVarArr != null && ckVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(ckVarArr));
            }
            ck[] ckVarArr2 = bqVar.aRB.aTh;
            ck[] ckVarArr3 = bqVar.aRB.aTi;
            ck[] ckVarArr4 = bqVar.aRB.aTj;
            boolean Nq = Nq();
            boolean Nr = Nr();
            boolean z2 = ckVarArr2 != null && ckVarArr2.length > 0 && Nq;
            if (ckVarArr3 == null || ckVarArr3.length <= 0 || Nr) {
                z = false;
            }
            if (z2) {
                arrayList.addAll(Arrays.asList(ckVarArr2));
            }
            if (z) {
                arrayList.addAll(Arrays.asList(ckVarArr3));
            }
            if (ckVarArr4 != null && ckVarArr4.length > 0) {
                arrayList.addAll(Arrays.asList(ckVarArr4));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (ck[]) arrayList.toArray(new ck[arrayList.size()]);
    }

    public ck[] b(boolean z, int i, boolean z2) {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        List<ck> arrayList = new ArrayList<>();
        if (bqVar != null && bqVar.aRE != null && bqVar.aRE.aUd && bqVar.aRB != null) {
            ck[] ckVarArr = bqVar.aRB.aTb;
            if (ckVarArr != null && ckVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(ckVarArr));
            }
            if (z2) {
                ck[] ckVarArr2 = bqVar.aRB.aTj;
                if (ckVarArr2 != null && ckVarArr2.length > 0) {
                    arrayList.addAll(0, Arrays.asList(ckVarArr2));
                }
            } else {
                arrayList = a(z, i, arrayList, bqVar.aRB.aTh, bqVar.aRB.aTi);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (ck[]) arrayList.toArray(new ck[arrayList.size()]);
    }

    public ck[] Nm() {
        return fa(0);
    }

    public ck[] fa(int i) {
        List<ck> list;
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar == null || bqVar.aRE == null || !bqVar.aRE.aUd || bqVar.aRB == null) {
            list = null;
        } else {
            ck[] ckVarArr = bqVar.aRB.aTb;
            list = a(false, i, (ckVarArr == null || ckVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ckVarArr)), null, bqVar.aRB.aTi);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ck[]) list.toArray(new ck[list.size()]);
    }

    public boolean Nn() {
        return this.bqa;
    }

    public void setSwitchStatus(boolean z) {
        this.bqa = z;
    }

    public String No() {
        return this.bqb;
    }

    public void setSelectId(String str) {
        this.bqb = str;
    }

    public List<AlaLiveMarkData> Np() {
        return this.bnr;
    }

    public void V(List<AlaLiveMarkData> list) {
        if (this.bnr == null) {
            this.bnr = new ArrayList();
        }
        this.bnr.clear();
        if (list != null && !list.isEmpty()) {
            this.bnr.addAll(list);
        }
    }

    public void release() {
        this.bqa = false;
        this.bqb = null;
        if (this.bnr != null) {
            this.bnr.clear();
        }
    }

    private d() {
        this.bqa = false;
    }

    private boolean Nq() {
        return com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aOZ && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
    }

    private boolean Nr() {
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        return TbadkCoreApplication.getInst().isMobileBaidu() || !(bqVar == null || bqVar.aRE == null || bqVar.aRE.aUl) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final d bqc = new d();
    }
}
