package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public abstract class AbsThreadDataSupport extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.a.a.b {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    private com.baidu.tbadk.a.e mABTest;
    public int objType = 1;
    public int floorPosition = -1;
    private SupportType mSupportType = SupportType.FULL;
    public SparseArray<String> feedBackReasonMap = null;

    /* loaded from: classes.dex */
    public enum SupportType {
        FULL,
        TOP,
        CONTENT,
        BOTTOM,
        EXTEND
    }

    public abstract bu aPS();

    public abstract ap aPU();

    public String aPT() {
        if (aPS() == null) {
            return null;
        }
        return aPS().aPT();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.aw.v(aPS());
    }

    public String aPV() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean aPW() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean aPX() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    private boolean B(String... strArr) {
        return com.baidu.tbadk.a.a.c.b(this.mABTest, strArr);
    }

    @Override // com.baidu.tbadk.a.a.b
    public void b(com.baidu.tbadk.a.e eVar) {
        this.mABTest = eVar;
    }

    public boolean aPY() {
        bu aPS = aPS();
        if (aPS == null) {
            return false;
        }
        if (aPS.dOy || aPS.dOz || aPS.dOB) {
            return B("70_2", "70_5", "70_6");
        }
        return false;
    }

    public boolean aPZ() {
        return B("70_3", "70_6");
    }

    public boolean aQa() {
        bu aPS = aPS();
        if (aPS == null) {
            return false;
        }
        if (aPS.dOy || aPS.dOz) {
            return B("70_4", "70_6");
        }
        boolean isSelf = UtilHelper.isSelf(aPS.aSp());
        if (!aPS.dOB || isSelf) {
            return false;
        }
        return B("70_2", "70_5", "70_6");
    }

    public boolean aQb() {
        bu aPS = aPS();
        if (aPS != null && aPS.dOy) {
            return B("70_5", "70_6");
        }
        return false;
    }

    public boolean aQc() {
        bu aPS = aPS();
        if (aPS == null || aPS.aSp() == null || com.baidu.tbadk.core.util.aw.v(aPS)) {
            return false;
        }
        if (aQb()) {
            MetaData aSp = aPS.aSp();
            boolean hadConcerned = aSp.hadConcerned();
            if (aPS.dOy) {
                return !hadConcerned || (hadConcerned && !aSp.isLikeStatusFromNet());
            }
            return false;
        }
        boolean z = aPS.aUk() || aPS.aQX() || aPS.aQY();
        if (aPS.dOy && z) {
            return true;
        }
        return aPS.dOA && z && !aPS.aSp().hadConcerned();
    }
}
