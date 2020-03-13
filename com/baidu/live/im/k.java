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
    private List<AlaLiveMarkData> arT;
    private boolean ast;
    private String asu;

    public static k wA() {
        return a.asv;
    }

    public bb[] wB() {
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
        ap apVar = com.baidu.live.v.a.zl().axD;
        if (apVar == null || apVar.acV == null || !apVar.acV.aex || apVar.acS == null) {
            list = null;
        } else {
            bb[] bbVarArr = apVar.acS.adM;
            list = (bbVarArr == null || bbVarArr.length <= 0) ? null : new ArrayList<>(Arrays.asList(bbVarArr));
            if (com.baidu.live.v.a.zl().awC != null && com.baidu.live.v.a.zl().awC.aaS && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled())) {
                list = a(z, list, apVar.acS.adS);
            }
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (bb[]) list.toArray(new bb[list.size()]);
    }

    public boolean wC() {
        return this.ast;
    }

    public void setSwitchStatus(boolean z) {
        this.ast = z;
    }

    public String wD() {
        return this.asu;
    }

    public void setSelectId(String str) {
        this.asu = str;
    }

    public List<AlaLiveMarkData> wE() {
        return this.arT;
    }

    public void C(List<AlaLiveMarkData> list) {
        if (this.arT == null) {
            this.arT = new ArrayList();
        }
        this.arT.clear();
        if (list != null && !list.isEmpty()) {
            this.arT.addAll(list);
        }
    }

    public void release() {
        this.ast = false;
        this.asu = null;
        if (this.arT != null) {
            this.arT.clear();
        }
    }

    private k() {
        this.ast = false;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final k asv = new k();
    }
}
