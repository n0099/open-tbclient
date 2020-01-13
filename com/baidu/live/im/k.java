package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ao;
import com.baidu.live.data.az;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    private List<AlaLiveMarkData> aoA;
    private boolean aoZ;
    private String apa;

    public static k uW() {
        return a.apb;
    }

    public az[] uX() {
        return aQ(false);
    }

    public az[] aQ(boolean z) {
        ArrayList arrayList;
        az[] azVarArr;
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (aoVar == null || aoVar.aaX == null || !aoVar.aaX.acv || aoVar.aaU == null) {
            arrayList = null;
        } else {
            az[] azVarArr2 = aoVar.aaU.abH;
            arrayList = (azVarArr2 == null || azVarArr2.length <= 0) ? null : new ArrayList(Arrays.asList(azVarArr2));
            if (com.baidu.live.s.a.wR().asq != null && com.baidu.live.s.a.wR().asq.Za && ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled()) && (azVarArr = aoVar.aaU.abN) != null && azVarArr.length > 0)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(Arrays.asList(azVarArr));
                } else {
                    arrayList.addAll(z ? 0 : arrayList.size(), Arrays.asList(azVarArr));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (az[]) arrayList.toArray(new az[arrayList.size()]);
    }

    public boolean uY() {
        return this.aoZ;
    }

    public void setSwitchStatus(boolean z) {
        this.aoZ = z;
    }

    public String uZ() {
        return this.apa;
    }

    public void setSelectId(String str) {
        this.apa = str;
    }

    public List<AlaLiveMarkData> va() {
        return this.aoA;
    }

    public void C(List<AlaLiveMarkData> list) {
        if (this.aoA == null) {
            this.aoA = new ArrayList();
        }
        this.aoA.clear();
        if (list != null && !list.isEmpty()) {
            this.aoA.addAll(list);
        }
    }

    public void release() {
        this.aoZ = false;
        this.apa = null;
        if (this.aoA != null) {
            this.aoA.clear();
        }
    }

    private k() {
        this.aoZ = false;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final k apb = new k();
    }
}
