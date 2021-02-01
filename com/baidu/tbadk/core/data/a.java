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

    public abstract cb bln();

    public abstract av blp();

    public String blo() {
        if (bln() == null) {
            return null;
        }
        return bln().blo();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.az.x(bln());
    }

    public String blq() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.i
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean blr() {
        cb bln = bln();
        if (bln == null) {
            return false;
        }
        return bln.eTF || bln.eTH;
    }

    public boolean bls() {
        cb bln = bln();
        if (bln == null) {
            return false;
        }
        return bln.eTF || bln.eTH || bln.eTE;
    }

    public boolean blt() {
        cb bln = bln();
        if (bln == null) {
            return false;
        }
        return bln.eTE || bln.eTF || bln.eTH || bln.eTG || bln.eTI;
    }

    public boolean blu() {
        cb bln = bln();
        if (bln == null) {
            return false;
        }
        return bln.blu();
    }

    public boolean blv() {
        return false;
    }

    public boolean blw() {
        return true;
    }

    public boolean blx() {
        cb bln = bln();
        if (bln == null || bln.bnQ() == null || com.baidu.tbadk.core.util.az.x(bln)) {
            return false;
        }
        boolean z = bln.bpM() || bln.bmx() || bln.bmy();
        if (bln.eTE && z) {
            return true;
        }
        return bln.eTG && z && !bln.bnQ().hadConcerned();
    }
}
