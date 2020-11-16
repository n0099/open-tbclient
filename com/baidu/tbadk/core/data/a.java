package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a extends BaseCardInfo implements com.baidu.tbadk.a.a.g {
    public static final int BIG_IMG = 2;
    public static final int CONTENT = 1;
    public static final int HEAD_IMG = 4;
    public static final int HEAD_VIDEO = 5;
    public static final int USER_NAME = 3;
    public int objType = 1;
    public int floorPosition = -1;
    private Map<BdUniqueId, com.baidu.tbadk.a.e> mABTestMap = new HashMap();
    public SparseArray<String> feedBackReasonMap = null;

    public abstract bx bjd();

    public abstract as bjf();

    public String bje() {
        if (bjd() == null) {
            return null;
        }
        return bjd().bje();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.az.x(bjd());
    }

    public String bjg() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bjh() {
        bx bjd = bjd();
        if (bjd == null) {
            return false;
        }
        return bjd.eFh || bjd.eFj;
    }

    public boolean bji() {
        bx bjd = bjd();
        if (bjd == null) {
            return false;
        }
        return bjd.eFh || bjd.eFj || bjd.eFg;
    }

    public boolean bjj() {
        bx bjd = bjd();
        if (bjd == null) {
            return false;
        }
        return bjd.eFg || bjd.eFh || bjd.eFj || bjd.eFi || bjd.eFk;
    }

    public boolean bjk() {
        bx bjd = bjd();
        if (bjd == null) {
            return false;
        }
        return bjd.bjk();
    }

    public boolean bjl() {
        return false;
    }

    public boolean bjm() {
        return true;
    }

    public boolean bjn() {
        bx bjd = bjd();
        if (bjd == null || bjd.blC() == null || com.baidu.tbadk.core.util.az.x(bjd)) {
            return false;
        }
        boolean z = bjd.bny() || bjd.bkk() || bjd.bkl();
        if (bjd.eFg && z) {
            return true;
        }
        return bjd.eFi && z && !bjd.blC().hadConcerned();
    }
}
