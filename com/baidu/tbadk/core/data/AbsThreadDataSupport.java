package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class AbsThreadDataSupport extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.a.a.c {
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

    public abstract bv aTN();

    public abstract aq aTP();

    public String aTO() {
        if (aTN() == null) {
            return null;
        }
        return aTN().aTO();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ax.w(aTN());
    }

    public String aTQ() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean aTR() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean aTS() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.c
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    private com.baidu.tbadk.a.e k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return null;
        }
        return this.mABTestMap.get(bdUniqueId);
    }

    public boolean aTT() {
        bv aTN = aTN();
        if (aTN == null) {
            return false;
        }
        return aTN.dUK || aTN.dUM;
    }

    public boolean aTU() {
        bv aTN = aTN();
        if (aTN == null) {
            return false;
        }
        return aTN.dUJ || aTN.dUK || aTN.dUM || aTN.dUL || aTN.dUN;
    }

    public boolean aTV() {
        bv aTN = aTN();
        if (aTN == null) {
            return false;
        }
        return aTN.aTV();
    }

    public boolean aTW() {
        bv aTN = aTN();
        if (aTN != null && aTN.dUJ) {
            return com.baidu.tbadk.a.d.a(k(com.baidu.tbadk.a.a.b.dIg), "11_7_index_c");
        }
        return false;
    }

    public boolean aTX() {
        bv aTN = aTN();
        if (aTN != null && aTN.dUJ) {
            return com.baidu.tbadk.a.d.a(k(com.baidu.tbadk.a.a.b.dIg), "11_7_index_d");
        }
        return false;
    }

    public boolean aTY() {
        bv aTN = aTN();
        if (aTN == null || aTN.aWl() == null || com.baidu.tbadk.core.util.ax.w(aTN)) {
            return false;
        }
        boolean z = aTN.aYf() || aTN.aUT() || aTN.aUU();
        if (aTN.dUJ && z) {
            return true;
        }
        return aTN.dUL && z && !aTN.aWl().hadConcerned();
    }
}
