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

    public abstract bz bkV();

    public abstract at bkX();

    public String bkW() {
        if (bkV() == null) {
            return null;
        }
        return bkV().bkW();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.x(bkV());
    }

    public String bkY() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.i
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bkZ() {
        bz bkV = bkV();
        if (bkV == null) {
            return false;
        }
        return bkV.eRt || bkV.eRv;
    }

    public boolean bla() {
        bz bkV = bkV();
        if (bkV == null) {
            return false;
        }
        return bkV.eRt || bkV.eRv || bkV.eRs;
    }

    public boolean blb() {
        bz bkV = bkV();
        if (bkV == null) {
            return false;
        }
        return bkV.eRs || bkV.eRt || bkV.eRv || bkV.eRu || bkV.eRw;
    }

    public boolean blc() {
        bz bkV = bkV();
        if (bkV == null) {
            return false;
        }
        return bkV.blc();
    }

    public boolean bld() {
        return false;
    }

    public boolean ble() {
        return true;
    }

    public boolean blf() {
        bz bkV = bkV();
        if (bkV == null || bkV.bnx() == null || com.baidu.tbadk.core.util.ay.x(bkV)) {
            return false;
        }
        boolean z = bkV.bpu() || bkV.bme() || bkV.bmf();
        if (bkV.eRs && z) {
            return true;
        }
        return bkV.eRu && z && !bkV.bnx().hadConcerned();
    }
}
