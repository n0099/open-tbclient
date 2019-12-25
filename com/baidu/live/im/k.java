package com.baidu.live.im;

import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ak;
import com.baidu.live.data.av;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    private List<AlaLiveMarkData> anN;
    private boolean aon;
    private String aoo;

    public static k uF() {
        return a.aop;
    }

    public av[] uG() {
        return aO(false);
    }

    public av[] aO(boolean z) {
        ArrayList arrayList;
        av[] avVarArr;
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (akVar == null || akVar.aaK == null || !akVar.aaK.ach || akVar.aaH == null) {
            arrayList = null;
        } else {
            av[] avVarArr2 = akVar.aaH.abw;
            arrayList = (avVarArr2 == null || avVarArr2.length <= 0) ? null : new ArrayList(Arrays.asList(avVarArr2));
            if (com.baidu.live.r.a.wA().arE != null && com.baidu.live.r.a.wA().arE.YO && ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardThroneSwitchUnabled()) && (avVarArr = akVar.aaH.abC) != null && avVarArr.length > 0)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(Arrays.asList(avVarArr));
                } else {
                    arrayList.addAll(z ? 0 : arrayList.size(), Arrays.asList(avVarArr));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (av[]) arrayList.toArray(new av[arrayList.size()]);
    }

    public boolean uH() {
        return this.aon;
    }

    public void setSwitchStatus(boolean z) {
        this.aon = z;
    }

    public String uI() {
        return this.aoo;
    }

    public void setSelectId(String str) {
        this.aoo = str;
    }

    public List<AlaLiveMarkData> uJ() {
        return this.anN;
    }

    public void D(List<AlaLiveMarkData> list) {
        if (this.anN == null) {
            this.anN = new ArrayList();
        }
        this.anN.clear();
        if (list != null && !list.isEmpty()) {
            this.anN.addAll(list);
        }
    }

    public void release() {
        this.aon = false;
        this.aoo = null;
        if (this.anN != null) {
            this.anN.clear();
        }
    }

    private k() {
        this.aon = false;
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static final k aop = new k();
    }
}
