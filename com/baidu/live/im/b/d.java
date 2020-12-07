package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bo;
import com.baidu.live.data.ci;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<AlaLiveMarkData> blM;
    private boolean bor;
    private String bos;

    public static d NK() {
        return a.bot;
    }

    private List<ci> a(boolean z, int i, List<ci> list, ci[] ciVarArr, ci[] ciVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aOs && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(boVar == null || boVar.aQP == null || boVar.aQP.aTn) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = ciVarArr != null && ciVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (ciVarArr2 == null || ciVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(ciVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(ciVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(ciVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ciVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(ciVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(ciVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(ciVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(ciVarArr2));
            }
        }
        return list;
    }

    public ci[] NL() {
        return e(false, 0);
    }

    public ci[] e(boolean z, int i) {
        List<ci> list;
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar == null || boVar.aQP == null || !boVar.aQP.aTf || boVar.aQM == null) {
            list = null;
        } else {
            ci[] ciVarArr = boVar.aQM.aSg;
            list = a(z, i, (ciVarArr == null || ciVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ciVarArr)), boVar.aQM.aSm, boVar.aQM.aSn);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ci[]) list.toArray(new ci[list.size()]);
    }

    public ci[] NM() {
        return fc(0);
    }

    public ci[] fc(int i) {
        List<ci> list;
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (boVar == null || boVar.aQP == null || !boVar.aQP.aTf || boVar.aQM == null) {
            list = null;
        } else {
            ci[] ciVarArr = boVar.aQM.aSg;
            list = a(false, i, (ciVarArr == null || ciVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(ciVarArr)), null, boVar.aQM.aSn);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (ci[]) list.toArray(new ci[list.size()]);
    }

    public boolean NN() {
        return this.bor;
    }

    public void setSwitchStatus(boolean z) {
        this.bor = z;
    }

    public String NO() {
        return this.bos;
    }

    public void setSelectId(String str) {
        this.bos = str;
    }

    public List<AlaLiveMarkData> NP() {
        return this.blM;
    }

    public void V(List<AlaLiveMarkData> list) {
        if (this.blM == null) {
            this.blM = new ArrayList();
        }
        this.blM.clear();
        if (list != null && !list.isEmpty()) {
            this.blM.addAll(list);
        }
    }

    public void release() {
        this.bor = false;
        this.bos = null;
        if (this.blM != null) {
            this.blM.clear();
        }
    }

    private d() {
        this.bor = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d bot = new d();
    }
}
