package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.be;
import com.baidu.live.data.br;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private List<AlaLiveMarkData> baq;
    private boolean bcb;
    private String bcc;

    public static d JD() {
        return a.bcd;
    }

    private List<br> a(boolean z, int i, List<br> list, br[] brVarArr, br[] brVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.w.a.Nk().beJ != null && com.baidu.live.w.a.Nk().beJ.aHj && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        be beVar = com.baidu.live.w.a.Nk().bkd;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(beVar == null || beVar.aJD == null || beVar.aJD.aLx) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = brVarArr != null && brVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (brVarArr2 == null || brVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(brVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(brVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(brVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(brVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(brVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(brVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(brVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(brVarArr2));
            }
        }
        return list;
    }

    public br[] JE() {
        return e(false, 0);
    }

    public br[] e(boolean z, int i) {
        List<br> list;
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar == null || beVar.aJD == null || !beVar.aJD.aLp || beVar.aJA == null) {
            list = null;
        } else {
            br[] brVarArr = beVar.aJA.aKt;
            list = a(z, i, (brVarArr == null || brVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(brVarArr)), beVar.aJA.aKz, beVar.aJA.aKA);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (br[]) list.toArray(new br[list.size()]);
    }

    public boolean JF() {
        return this.bcb;
    }

    public void setSwitchStatus(boolean z) {
        this.bcb = z;
    }

    public String JG() {
        return this.bcc;
    }

    public void setSelectId(String str) {
        this.bcc = str;
    }

    public List<AlaLiveMarkData> JH() {
        return this.baq;
    }

    public void O(List<AlaLiveMarkData> list) {
        if (this.baq == null) {
            this.baq = new ArrayList();
        }
        this.baq.clear();
        if (list != null && !list.isEmpty()) {
            this.baq.addAll(list);
        }
    }

    public void release() {
        this.bcb = false;
        this.bcc = null;
        if (this.baq != null) {
            this.baq.clear();
        }
    }

    private d() {
        this.bcb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final d bcd = new d();
    }
}
