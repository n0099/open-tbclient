package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ax;
import com.baidu.live.data.bj;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class m {
    private boolean aRX;
    private String aRY;
    private List<AlaLiveMarkData> aRb;

    public static m CL() {
        return a.aRZ;
    }

    private List<bj> a(boolean z, int i, List<bj> list, bj[] bjVarArr, bj[] bjVarArr2) {
        boolean z2 = true;
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z3 = com.baidu.live.v.a.Ge().aWF != null && com.baidu.live.v.a.Ge().aWF.ayv && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled());
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        boolean z4 = TbadkCoreApplication.getInst().isMobileBaidu() || !(axVar == null || axVar.aAL == null || axVar.aAL.aCA) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled());
        boolean z5 = bjVarArr != null && bjVarArr.length > 0 && z3;
        boolean z6 = i > 2;
        if (bjVarArr2 == null || bjVarArr2.length <= 0 || z4) {
            z2 = false;
        }
        if (z && z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bjVarArr2));
            }
            if (z5) {
                list.addAll(0, Arrays.asList(bjVarArr));
            }
        } else if (z) {
            if (z5) {
                list.addAll(0, Arrays.asList(bjVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bjVarArr2));
            }
        } else if (z6) {
            if (z2) {
                list.addAll(0, Arrays.asList(bjVarArr2));
            }
            if (z5) {
                list.addAll(Arrays.asList(bjVarArr));
            }
        } else {
            if (z5) {
                list.addAll(Arrays.asList(bjVarArr));
            }
            if (z2) {
                list.addAll(Arrays.asList(bjVarArr2));
            }
        }
        return list;
    }

    public bj[] CM() {
        return e(false, 0);
    }

    public bj[] e(boolean z, int i) {
        List<bj> list;
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (axVar == null || axVar.aAL == null || !axVar.aAL.aCs || axVar.aAI == null) {
            list = null;
        } else {
            bj[] bjVarArr = axVar.aAI.aBC;
            list = a(z, i, (bjVarArr == null || bjVarArr.length <= 0) ? null : new ArrayList(Arrays.asList(bjVarArr)), axVar.aAI.aBI, axVar.aAI.aBJ);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bj[]) list.toArray(new bj[list.size()]);
    }

    public boolean CN() {
        return this.aRX;
    }

    public void setSwitchStatus(boolean z) {
        this.aRX = z;
    }

    public String CO() {
        return this.aRY;
    }

    public void setSelectId(String str) {
        this.aRY = str;
    }

    public List<AlaLiveMarkData> CP() {
        return this.aRb;
    }

    public void H(List<AlaLiveMarkData> list) {
        if (this.aRb == null) {
            this.aRb = new ArrayList();
        }
        this.aRb.clear();
        if (list != null && !list.isEmpty()) {
            this.aRb.addAll(list);
        }
    }

    public void release() {
        this.aRX = false;
        this.aRY = null;
        if (this.aRb != null) {
            this.aRb.clear();
        }
    }

    private m() {
        this.aRX = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final m aRZ = new m();
    }
}
