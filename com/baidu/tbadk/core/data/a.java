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

    public abstract bz boO();

    public abstract at boQ();

    public String boP() {
        if (boO() == null) {
            return null;
        }
        return boO().boP();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(boO());
    }

    public String boR() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.i
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean boS() {
        bz boO = boO();
        if (boO == null) {
            return false;
        }
        return boO.eWe || boO.eWg;
    }

    public boolean boT() {
        bz boO = boO();
        if (boO == null) {
            return false;
        }
        return boO.eWe || boO.eWg || boO.eWd;
    }

    public boolean boU() {
        bz boO = boO();
        if (boO == null) {
            return false;
        }
        return boO.eWd || boO.eWe || boO.eWg || boO.eWf || boO.eWh;
    }

    public boolean boV() {
        bz boO = boO();
        if (boO == null) {
            return false;
        }
        return boO.boV();
    }

    public boolean boW() {
        return false;
    }

    public boolean boX() {
        return true;
    }

    public boolean boY() {
        bz boO = boO();
        if (boO == null || boO.brq() == null || com.baidu.tbadk.core.util.ay.x(boO)) {
            return false;
        }
        boolean z = boO.btn() || boO.bpX() || boO.bpY();
        if (boO.eWd && z) {
            return true;
        }
        return boO.eWf && z && !boO.brq().hadConcerned();
    }
}
