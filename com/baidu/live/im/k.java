package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ap;
import com.baidu.live.data.bb;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class k {
    private boolean asD;
    private String asE;
    private List<AlaLiveMarkData> asd;

    public static k wF() {
        return a.asF;
    }

    public bb[] wG() {
        return aT(false);
    }

    private List<bb> a(boolean z, List<bb> list, bb[] bbVarArr) {
        if (bbVarArr != null && bbVarArr.length > 0) {
            if (list == null) {
                return new ArrayList(Arrays.asList(bbVarArr));
            }
            list.addAll(z ? 0 : list.size(), Arrays.asList(bbVarArr));
            return list;
        }
        return list;
    }

    public bb[] aT(boolean z) {
        List<bb> list;
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (apVar == null || apVar.adg == null || !apVar.adg.aeH || apVar.adc == null) {
            list = null;
        } else {
            bb[] bbVarArr = apVar.adc.adW;
            list = (bbVarArr == null || bbVarArr.length <= 0) ? null : new ArrayList<>(Arrays.asList(bbVarArr));
            if (com.baidu.live.v.a.zs().awM != null && com.baidu.live.v.a.zs().awM.abd && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled())) {
                list = a(z, list, apVar.adc.aec);
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bb[]) list.toArray(new bb[list.size()]);
    }

    public boolean wH() {
        return this.asD;
    }

    public void setSwitchStatus(boolean z) {
        this.asD = z;
    }

    public String wI() {
        return this.asE;
    }

    public void setSelectId(String str) {
        this.asE = str;
    }

    public List<AlaLiveMarkData> wJ() {
        return this.asd;
    }

    public void C(List<AlaLiveMarkData> list) {
        if (this.asd == null) {
            this.asd = new ArrayList();
        }
        this.asd.clear();
        if (list != null && !list.isEmpty()) {
            this.asd.addAll(list);
        }
    }

    public void release() {
        this.asD = false;
        this.asE = null;
        if (this.asd != null) {
            this.asd.clear();
        }
    }

    private k() {
        this.asD = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final k asF = new k();
    }
}
