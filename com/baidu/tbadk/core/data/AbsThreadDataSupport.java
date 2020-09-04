package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class AbsThreadDataSupport extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.a.a.d {
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

    public abstract bw bce();

    public abstract ar bcg();

    public String bcf() {
        if (bce() == null) {
            return null;
        }
        return bce().bcf();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.ay.w(bce());
    }

    public String bch() {
        return null;
    }

    public void a(SupportType supportType) {
        this.mSupportType = supportType;
    }

    public boolean bci() {
        return this.mSupportType == SupportType.TOP;
    }

    public boolean bcj() {
        return this.mSupportType == SupportType.BOTTOM;
    }

    @Override // com.baidu.tbadk.a.a.d
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

    public boolean bck() {
        bw bce = bce();
        if (bce == null) {
            return false;
        }
        return bce.eek || bce.eem;
    }

    public boolean bcl() {
        bw bce = bce();
        if (bce == null) {
            return false;
        }
        return bce.eej || bce.eek || bce.eem || bce.eel || bce.een;
    }

    public boolean bcm() {
        bw bce = bce();
        if (bce == null) {
            return false;
        }
        return bce.bcm();
    }

    public boolean bcn() {
        bw bce = bce();
        if (bce != null && bce.eej) {
            return com.baidu.tbadk.a.d.a(k(com.baidu.tbadk.a.a.b.dRr), "11_7_index_c");
        }
        return false;
    }

    public boolean bco() {
        bw bce = bce();
        if (bce != null && bce.eej) {
            return com.baidu.tbadk.a.d.a(k(com.baidu.tbadk.a.a.b.dRr), "11_7_index_d");
        }
        return false;
    }

    public boolean bcp() {
        bw bce = bce();
        if (bce == null || bce.beE() == null || com.baidu.tbadk.core.util.ay.w(bce)) {
            return false;
        }
        boolean z = bce.bgy() || bce.bdm() || bce.bdn();
        if (bce.eej && z) {
            return true;
        }
        return bce.eel && z && !bce.beE().hadConcerned();
    }
}
