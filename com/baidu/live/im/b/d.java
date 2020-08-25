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
    private List<AlaLiveMarkData> bao;
    private boolean bbZ;
    private String bca;

    public static d JD() {
        return a.bcb;
    }

    private List<br> a(boolean z, int i, List<br> list, br[] brVarArr, br[] brVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.w.a.Nk().beH != null && com.baidu.live.w.a.Nk().beH.aHh && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        be beVar = com.baidu.live.w.a.Nk().bka;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(beVar == null || beVar.aJB == null || beVar.aJB.aLv) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
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
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar == null || beVar.aJB == null || !beVar.aJB.aLn || beVar.aJy == null) {
            list = null;
        } else {
            br[] brVarArr = beVar.aJy.aKr;
            list = a(z, i, (brVarArr == null || brVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(brVarArr)), beVar.aJy.aKx, beVar.aJy.aKy);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (br[]) list.toArray(new br[list.size()]);
    }

    public boolean JF() {
        return this.bbZ;
    }

    public void setSwitchStatus(boolean z) {
        this.bbZ = z;
    }

    public String JG() {
        return this.bca;
    }

    public void setSelectId(String str) {
        this.bca = str;
    }

    public List<AlaLiveMarkData> JH() {
        return this.bao;
    }

    public void O(List<AlaLiveMarkData> list) {
        if (this.bao == null) {
            this.bao = new ArrayList();
        }
        this.bao.clear();
        if (list != null && !list.isEmpty()) {
            this.bao.addAll(list);
        }
    }

    public void release() {
        this.bbZ = false;
        this.bca = null;
        if (this.bao != null) {
            this.bao.clear();
        }
    }

    private d() {
        this.bbZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final d bcb = new d();
    }
}
