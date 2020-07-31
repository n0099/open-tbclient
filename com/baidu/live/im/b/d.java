package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bc;
import com.baidu.live.data.bp;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<AlaLiveMarkData> aVa;
    private boolean aWK;
    private String aWL;

    public static d Ea() {
        return a.aWM;
    }

    private List<bp> a(boolean z, int i, List<bp> list, bp[] bpVarArr, bp[] bpVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.v.a.Hs().aZn != null && com.baidu.live.v.a.Hs().aZn.aBX && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bcVar == null || bcVar.aEr == null || bcVar.aEr.aGl) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = bpVarArr != null && bpVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (bpVarArr2 == null || bpVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bpVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(bpVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(bpVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bpVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bpVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(bpVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(bpVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bpVarArr2));
            }
        }
        return list;
    }

    public bp[] Eb() {
        return e(false, 0);
    }

    public bp[] e(boolean z, int i) {
        List<bp> list;
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar == null || bcVar.aEr == null || !bcVar.aEr.aGd || bcVar.aEo == null) {
            list = null;
        } else {
            bp[] bpVarArr = bcVar.aEo.aFh;
            list = a(z, i, (bpVarArr == null || bpVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(bpVarArr)), bcVar.aEo.aFn, bcVar.aEo.aFo);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bp[]) list.toArray(new bp[list.size()]);
    }

    public boolean Ec() {
        return this.aWK;
    }

    public void setSwitchStatus(boolean z) {
        this.aWK = z;
    }

    public String Ed() {
        return this.aWL;
    }

    public void setSelectId(String str) {
        this.aWL = str;
    }

    public List<AlaLiveMarkData> Ee() {
        return this.aVa;
    }

    public void N(List<AlaLiveMarkData> list) {
        if (this.aVa == null) {
            this.aVa = new ArrayList();
        }
        this.aVa.clear();
        if (list != null && !list.isEmpty()) {
            this.aVa.addAll(list);
        }
    }

    public void release() {
        this.aWK = false;
        this.aWL = null;
        if (this.aVa != null) {
            this.aVa.clear();
        }
    }

    private d() {
        this.aWK = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d aWM = new d();
    }
}
