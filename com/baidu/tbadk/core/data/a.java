package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a extends BaseCardInfo implements com.baidu.tbadk.a.a.i {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    private Map<BdUniqueId, com.baidu.tbadk.a.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    public abstract bz boP();

    public abstract at boR();

    public String boQ() {
        if (boP() == null) {
            return null;
        }
        return boP().boQ();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(boP());
    }

    public String boS() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.i
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean boT() {
        bz boP = boP();
        if (boP == null) {
            return false;
        }
        return boP.eWe || boP.eWg;
    }

    public boolean boU() {
        bz boP = boP();
        if (boP == null) {
            return false;
        }
        return boP.eWe || boP.eWg || boP.eWd;
    }

    public boolean boV() {
        bz boP = boP();
        if (boP == null) {
            return false;
        }
        return boP.eWd || boP.eWe || boP.eWg || boP.eWf || boP.eWh;
    }

    public boolean boW() {
        bz boP = boP();
        if (boP == null) {
            return false;
        }
        return boP.boW();
    }

    public boolean boX() {
        return false;
    }

    public boolean boY() {
        return true;
    }

    public boolean boZ() {
        bz boP = boP();
        if (boP == null || boP.brr() == null || com.baidu.tbadk.core.util.ay.x(boP)) {
            return false;
        }
        boolean z = boP.bto() || boP.bpY() || boP.bpZ();
        if (boP.eWd && z) {
            return true;
        }
        return boP.eWf && z && !boP.brr().hadConcerned();
    }
}
