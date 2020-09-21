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

    public abstract bw bcY();

    public abstract ar bda();

    public String bcZ() {
        if (bcY() == null) {
            return null;
        }
        return bcY().bcZ();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(bcY());
    }

    public String bdb() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean bdc() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean bdd() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bde() {
        bw bcY = bcY();
        if (bcY == null) {
            return false;
        }
        return bcY.egu || bcY.egw;
    }

    public boolean bdf() {
        bw bcY = bcY();
        if (bcY == null) {
            return false;
        }
        return bcY.egt || bcY.egu || bcY.egw || bcY.egv || bcY.egx;
    }

    public boolean bdg() {
        bw bcY = bcY();
        if (bcY == null) {
            return false;
        }
        return bcY.bdg();
    }

    public boolean bdh() {
        return false;
    }

    public boolean bdi() {
        return true;
    }

    public boolean bdj() {
        bw bcY = bcY();
        if (bcY == null || bcY.bfy() == null || com.baidu.tbadk.core.util.ay.x(bcY)) {
            return false;
        }
        boolean z = bcY.bhs() || bcY.beg() || bcY.beh();
        if (bcY.egt && z) {
            return true;
        }
        return bcY.egv && z && !bcY.bfy().hadConcerned();
    }
}
