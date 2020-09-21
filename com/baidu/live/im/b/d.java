package com.baidu.live.im.b;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.bj;
import com.baidu.live.data.bz;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    private List<AlaLiveMarkData> bcO;
    private boolean beL;
    private String beM;

    public static d Kh() {
        return a.beN;
    }

    private List<bz> a(boolean z, int i, List<bz> list, bz[] bzVarArr, bz[] bzVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.x.a.NN().bhy != null && com.baidu.live.x.a.NN().bhy.aIA && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bjVar == null || bjVar.aKT == null || bjVar.aKT.aNf) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = bzVarArr != null && bzVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (bzVarArr2 == null || bzVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bzVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(bzVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(bzVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bzVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bzVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(bzVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(bzVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bzVarArr2));
            }
        }
        return list;
    }

    public bz[] Ki() {
        return e(false, 0);
    }

    public bz[] e(boolean z, int i) {
        List<bz> list;
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar == null || bjVar.aKT == null || !bjVar.aKT.aMX || bjVar.aKQ == null) {
            list = null;
        } else {
            bz[] bzVarArr = bjVar.aKQ.aLY;
            list = a(z, i, (bzVarArr == null || bzVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(bzVarArr)), bjVar.aKQ.aMe, bjVar.aKQ.aMf);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bz[]) list.toArray(new bz[list.size()]);
    }

    public boolean Kj() {
        return this.beL;
    }

    public void setSwitchStatus(boolean z) {
        this.beL = z;
    }

    public String Kk() {
        return this.beM;
    }

    public void setSelectId(String str) {
        this.beM = str;
    }

    public List<AlaLiveMarkData> Kl() {
        return this.bcO;
    }

    public void R(List<AlaLiveMarkData> list) {
        if (this.bcO == null) {
            this.bcO = new ArrayList();
        }
        this.bcO.clear();
        if (list != null && !list.isEmpty()) {
            this.bcO.addAll(list);
        }
    }

    public void release() {
        this.beL = false;
        this.beM = null;
        if (this.bcO != null) {
            this.bcO.clear();
        }
    }

    private d() {
        this.beL = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d beN = new d();
    }
}
