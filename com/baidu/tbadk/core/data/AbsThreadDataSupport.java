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

    public abstract bw bjZ();

    public abstract ar bkb();

    public String bka() {
        if (bjZ() == null) {
            return null;
        }
        return bjZ().bka();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(bjZ());
    }

    public String bkc() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean bkd() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean bke() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bkf() {
        bw bjZ = bjZ();
        if (bjZ == null) {
            return false;
        }
        return bjZ.eGP || bjZ.eGR;
    }

    public boolean bkg() {
        bw bjZ = bjZ();
        if (bjZ == null) {
            return false;
        }
        return bjZ.eGP || bjZ.eGR || bjZ.eGO;
    }

    public boolean bkh() {
        bw bjZ = bjZ();
        if (bjZ == null) {
            return false;
        }
        return bjZ.eGO || bjZ.eGP || bjZ.eGR || bjZ.eGQ || bjZ.eGS;
    }

    public boolean bki() {
        bw bjZ = bjZ();
        if (bjZ == null) {
            return false;
        }
        return bjZ.bki();
    }

    public boolean bkj() {
        return false;
    }

    public boolean bkk() {
        return true;
    }

    public boolean bkl() {
        bw bjZ = bjZ();
        if (bjZ == null || bjZ.bmA() == null || com.baidu.tbadk.core.util.ay.x(bjZ)) {
            return false;
        }
        boolean z = bjZ.bou() || bjZ.bli() || bjZ.blj();
        if (bjZ.eGO && z) {
            return true;
        }
        return bjZ.eGQ && z && !bjZ.bmA().hadConcerned();
    }
}
