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

    public abstract cb blp();

    public abstract av blr();

    public String blq() {
        if (blp() == null) {
            return null;
        }
        return blp().blq();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.az.x(blp());
    }

    public String bls() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.i
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean blt() {
        cb blp = blp();
        if (blp == null) {
            return false;
        }
        return blp.eVg || blp.eVi;
    }

    public boolean blu() {
        cb blp = blp();
        if (blp == null) {
            return false;
        }
        return blp.eVg || blp.eVi || blp.eVf;
    }

    public boolean blv() {
        cb blp = blp();
        if (blp == null) {
            return false;
        }
        return blp.eVf || blp.eVg || blp.eVi || blp.eVh || blp.eVj;
    }

    public boolean blw() {
        cb blp = blp();
        if (blp == null) {
            return false;
        }
        return blp.blw();
    }

    public boolean blx() {
        return false;
    }

    public boolean bly() {
        return true;
    }

    public boolean blz() {
        cb blp = blp();
        if (blp == null || blp.bnS() == null || com.baidu.tbadk.core.util.az.x(blp)) {
            return false;
        }
        boolean z = blp.bpO() || blp.bmz() || blp.bmA();
        if (blp.eVf && z) {
            return true;
        }
        return blp.eVh && z && !blp.bnS().hadConcerned();
    }
}
