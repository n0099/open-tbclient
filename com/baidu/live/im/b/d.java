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
    private List<AlaLiveMarkData> bgB;
    private boolean biy;
    private String biz;

    public static d Lm() {
        return a.biA;
    }

    private List<bz> a(boolean z, int i, List<bz> list, bz[] bzVarArr, bz[] bzVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.x.a.OS().blo != null && com.baidu.live.x.a.OS().blo.aLE && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(bjVar == null || bjVar.aNY == null || bjVar.aNY.aQk) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
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

    public bz[] Ln() {
        return e(false, 0);
    }

    public bz[] e(boolean z, int i) {
        List<bz> list;
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar == null || bjVar.aNY == null || !bjVar.aNY.aQc || bjVar.aNV == null) {
            list = null;
        } else {
            bz[] bzVarArr = bjVar.aNV.aPd;
            list = a(z, i, (bzVarArr == null || bzVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(bzVarArr)), bjVar.aNV.aPj, bjVar.aNV.aPk);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bz[]) list.toArray(new bz[list.size()]);
    }

    public boolean Lo() {
        return this.biy;
    }

    public void setSwitchStatus(boolean z) {
        this.biy = z;
    }

    public String Lp() {
        return this.biz;
    }

    public void setSelectId(String str) {
        this.biz = str;
    }

    public List<AlaLiveMarkData> Lq() {
        return this.bgB;
    }

    public void T(List<AlaLiveMarkData> list) {
        if (this.bgB == null) {
            this.bgB = new ArrayList();
        }
        this.bgB.clear();
        if (list != null && !list.isEmpty()) {
            this.bgB.addAll(list);
        }
    }

    public void release() {
        this.biy = false;
        this.biz = null;
        if (this.bgB != null) {
            this.bgB.clear();
        }
    }

    private d() {
        this.biy = false;
    }

    /* loaded from: classes4.dex */
    private static class a {
        private static final d biA = new d();
    }
}
