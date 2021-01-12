package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bq;
import com.baidu.live.data.ck;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private List<AlaLiveMarkData> biE;
    private boolean bln;
    private String blo;

    public static d Jp() {
        return a.blp;
    }

    private List<ck> a(boolean z, int i, List<ck> list, ck[] ckVarArr, ck[] ckVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean Jv = Jv();
        boolean Jw = Jw();
        boolean z3 = ckVarArr != null && ckVarArr.length > 0 && Jv;
        boolean z4 = i > 2;
        if (ckVarArr2 == null || ckVarArr2.length <= 0 || Jw) {
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

    public ck[] Jq() {
        boolean z = true;
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        ArrayList arrayList = new ArrayList();
        if (bqVar != null && bqVar.aMR != null && bqVar.aMR.aPq && bqVar.aMO != null) {
            ck[] ckVarArr = bqVar.aMO.aOo;
            if (ckVarArr != null && ckVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(ckVarArr));
            }
            ck[] ckVarArr2 = bqVar.aMO.aOu;
            ck[] ckVarArr3 = bqVar.aMO.aOv;
            ck[] ckVarArr4 = bqVar.aMO.aOw;
            boolean Jv = Jv();
            boolean Jw = Jw();
            boolean z2 = ckVarArr2 != null && ckVarArr2.length > 0 && Jv;
            if (ckVarArr3 == null || ckVarArr3.length <= 0 || Jw) {
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
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        List<ck> arrayList = new ArrayList<>();
        if (bqVar != null && bqVar.aMR != null && bqVar.aMR.aPq && bqVar.aMO != null) {
            ck[] ckVarArr = bqVar.aMO.aOo;
            if (ckVarArr != null && ckVarArr.length > 0) {
                arrayList.addAll(Arrays.asList(ckVarArr));
            }
            if (z2) {
                ck[] ckVarArr2 = bqVar.aMO.aOw;
                if (ckVarArr2 != null && ckVarArr2.length > 0) {
                    arrayList.addAll(0, Arrays.asList(ckVarArr2));
                }
            } else {
                arrayList = a(z, i, arrayList, bqVar.aMO.aOu, bqVar.aMO.aOv);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (ck[]) arrayList.toArray(new ck[arrayList.size()]);
    }

    public ck[] Jr() {
        return du(0);
    }

    public ck[] du(int i) {
        List<ck> list;
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar == null || bqVar.aMR == null || !bqVar.aMR.aPq || bqVar.aMO == null) {
            list = null;
        } else {
            ck[] ckVarArr = bqVar.aMO.aOo;
            list = a(false, i, (ckVarArr == null || ckVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ckVarArr)), null, bqVar.aMO.aOv);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ck[]) list.toArray(new ck[list.size()]);
    }

    public boolean Js() {
        return this.bln;
    }

    public void setSwitchStatus(boolean z) {
        this.bln = z;
    }

    public String Jt() {
        return this.blo;
    }

    public void setSelectId(String str) {
        this.blo = str;
    }

    public List<AlaLiveMarkData> Ju() {
        return this.biE;
    }

    public void V(List<AlaLiveMarkData> list) {
        if (this.biE == null) {
            this.biE = new ArrayList();
        }
        this.biE.clear();
        if (list != null && !list.isEmpty()) {
            this.biE.addAll(list);
        }
    }

    public void release() {
        this.bln = false;
        this.blo = null;
        if (this.biE != null) {
            this.biE.clear();
        }
    }

    private d() {
        this.bln = false;
    }

    private boolean Jv() {
        return com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aKm && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
    }

    private boolean Jw() {
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        return TbadkCoreApplication.getInst().isMobileBaidu() || !(bqVar == null || bqVar.aMR == null || bqVar.aMR.aPy) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final d blp = new d();
    }
}
