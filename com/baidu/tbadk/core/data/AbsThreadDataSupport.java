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

    public abstract bw bfG();

    public abstract ar bfI();

    public String bfH() {
        if (bfG() == null) {
            return null;
        }
        return bfG().bfH();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(bfG());
    }

    public String bfJ() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean bfK() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean bfL() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bfM() {
        bw bfG = bfG();
        if (bfG == null) {
            return false;
        }
        return bfG.esA || bfG.esC;
    }

    public boolean bfN() {
        bw bfG = bfG();
        if (bfG == null) {
            return false;
        }
        return bfG.esA || bfG.esC || bfG.esz;
    }

    public boolean bfO() {
        bw bfG = bfG();
        if (bfG == null) {
            return false;
        }
        return bfG.esz || bfG.esA || bfG.esC || bfG.esB || bfG.esD;
    }

    public boolean bfP() {
        bw bfG = bfG();
        if (bfG == null) {
            return false;
        }
        return bfG.bfP();
    }

    public boolean bfQ() {
        return false;
    }

    public boolean bfR() {
        return true;
    }

    public boolean bfS() {
        bw bfG = bfG();
        if (bfG == null || bfG.bih() == null || com.baidu.tbadk.core.util.ay.x(bfG)) {
            return false;
        }
        boolean z = bfG.bkb() || bfG.bgP() || bfG.bgQ();
        if (bfG.esz && z) {
            return true;
        }
        return bfG.esB && z && !bfG.bih().hadConcerned();
    }
}
