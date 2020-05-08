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
    private boolean aLX;
    private String aLY;
    private List<AlaLiveMarkData> aLf;

    public static m Bo() {
        return a.aLZ;
    }

    public be[] Bp() {
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
        as asVar = com.baidu.live.v.a.En().aRB;
        if (asVar == null || asVar.avD == null || !asVar.avD.axd || asVar.avA == null) {
            list = null;
        } else {
            be[] beVarArr = asVar.avA.awt;
            list = (beVarArr == null || beVarArr.length <= 0) ? null : new ArrayList<>(Arrays.asList(beVarArr));
            if (com.baidu.live.v.a.En().aQu != null && com.baidu.live.v.a.En().aQu.atx && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled())) {
                list = a(z, list, asVar.avA.awz);
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (be[]) list.toArray(new be[list.size()]);
    }

    public boolean Bq() {
        return this.aLX;
    }

    public void setSwitchStatus(boolean z) {
        this.aLX = z;
    }

    public String Br() {
        return this.aLY;
    }

    public void setSelectId(String str) {
        this.aLY = str;
    }

    public List<AlaLiveMarkData> Bs() {
        return this.aLf;
    }

    public void H(List<AlaLiveMarkData> list) {
        if (this.aLf == null) {
            this.aLf = new ArrayList();
        }
        this.aLf.clear();
        if (list != null && !list.isEmpty()) {
            this.aLf.addAll(list);
        }
    }

    public void release() {
        this.aLX = false;
        this.aLY = null;
        if (this.aLf != null) {
            this.aLf.clear();
        }
    }

    private m() {
        this.aLX = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final m aLZ = new m();
    }
}
