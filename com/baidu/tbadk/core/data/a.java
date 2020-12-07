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

    public abstract by bmn();

    public abstract at bmp();

    public String bmo() {
        if (bmn() == null) {
            return null;
        }
        return bmn().bmo();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.az.x(bmn());
    }

    public String bmq() {
        return null;
    }

    @Override // com.baidu.tbadk.a.a.g
    public void a(BdUniqueId bdUniqueId, com.baidu.tbadk.a.e eVar) {
        if (bdUniqueId != null) {
            this.mABTestMap.put(bdUniqueId, eVar);
        }
    }

    public boolean bmr() {
        by bmn = bmn();
        if (bmn == null) {
            return false;
        }
        return bmn.eMj || bmn.eMl;
    }

    public boolean bms() {
        by bmn = bmn();
        if (bmn == null) {
            return false;
        }
        return bmn.eMj || bmn.eMl || bmn.eMi;
    }

    public boolean bmt() {
        by bmn = bmn();
        if (bmn == null) {
            return false;
        }
        return bmn.eMi || bmn.eMj || bmn.eMl || bmn.eMk || bmn.eMm;
    }

    public boolean bmu() {
        by bmn = bmn();
        if (bmn == null) {
            return false;
        }
        return bmn.bmu();
    }

    public boolean bmv() {
        return false;
    }

    public boolean bmw() {
        return true;
    }

    public boolean bmx() {
        by bmn = bmn();
        if (bmn == null || bmn.boP() == null || com.baidu.tbadk.core.util.az.x(bmn)) {
            return false;
        }
        boolean z = bmn.bqL() || bmn.bnx() || bmn.bny();
        if (bmn.eMi && z) {
            return true;
        }
        return bmn.eMk && z && !bmn.boP().hadConcerned();
    }
}
