package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class AbsThreadDataSupport extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.a.a.g {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    private SupportType mSupportType = SupportType.FULL;
    private Map<BdUniqueId, com.baidu.tbadk.a.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    /* loaded from: classes.dex */
    public enum SupportType {
        FULL,
        TOP,
        CONTENT,
        BOTTOM,
        EXTEND
    }

    public abstract ar bhB();

    public abstract bw bhz();

    public String bhA() {
        if (bhz() == null) {
            return null;
        }
        return bhz().bhA();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(bhz());
    }

    public String bhC() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean bhD() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean bhE() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bhF() {
        bw bhz = bhz();
        if (bhz == null) {
            return false;
        }
        return bhz.eBa || bhz.eBc;
    }

    public boolean bhG() {
        bw bhz = bhz();
        if (bhz == null) {
            return false;
        }
        return bhz.eBa || bhz.eBc || bhz.eAZ;
    }

    public boolean bhH() {
        bw bhz = bhz();
        if (bhz == null) {
            return false;
        }
        return bhz.eAZ || bhz.eBa || bhz.eBc || bhz.eBb || bhz.eBd;
    }

    public boolean bhI() {
        bw bhz = bhz();
        if (bhz == null) {
            return false;
        }
        return bhz.bhI();
    }

    public boolean bhJ() {
        return false;
    }

    public boolean bhK() {
        return true;
    }

    public boolean bhL() {
        bw bhz = bhz();
        if (bhz == null || bhz.bka() == null || com.baidu.tbadk.core.util.ay.x(bhz)) {
            return false;
        }
        boolean z = bhz.blU() || bhz.biI() || bhz.biJ();
        if (bhz.eAZ && z) {
            return true;
        }
        return bhz.eBb && z && !bhz.bka().hadConcerned();
    }
}
