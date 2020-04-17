package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.as;
import com.baidu.live.data.be;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class m {
    private List<AlaLiveMarkData> aKZ;
    private boolean aLR;
    private String aLS;

    public static m Bp() {
        return a.aLT;
    }

    public be[] Bq() {
        return bw(false);
    }

    private List<be> a(boolean z, List<be> list, be[] beVarArr) {
        if (beVarArr != null && beVarArr.length > 0) {
            if (list == null) {
                return new ArrayList(Arrays.asList(beVarArr));
            }
            list.addAll(z ? 0 : list.size(), Arrays.asList(beVarArr));
            return list;
        }
        return list;
    }

    public be[] bw(boolean z) {
        List<be> list;
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (asVar == null || asVar.avx == null || !asVar.avx.awX || asVar.avu == null) {
            list = null;
        } else {
            be[] beVarArr = asVar.avu.awn;
            list = (beVarArr == null || beVarArr.length <= 0) ? null : new ArrayList<>(Arrays.asList(beVarArr));
            if (com.baidu.live.v.a.Eo().aQp != null && com.baidu.live.v.a.Eo().aQp.atr && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled())) {
                list = a(z, list, asVar.avu.awt);
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (be[]) list.toArray(new be[list.size()]);
    }

    public boolean Br() {
        return this.aLR;
    }

    public void setSwitchStatus(boolean z) {
        this.aLR = z;
    }

    public String Bs() {
        return this.aLS;
    }

    public void setSelectId(String str) {
        this.aLS = str;
    }

    public List<AlaLiveMarkData> Bt() {
        return this.aKZ;
    }

    public void H(List<AlaLiveMarkData> list) {
        if (this.aKZ == null) {
            this.aKZ = new ArrayList();
        }
        this.aKZ.clear();
        if (list != null && !list.isEmpty()) {
            this.aKZ.addAll(list);
        }
    }

    public void release() {
        this.aLR = false;
        this.aLS = null;
        if (this.aKZ != null) {
            this.aKZ.clear();
        }
    }

    private m() {
        this.aLR = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final m aLT = new m();
    }
}
