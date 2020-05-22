package com.baidu.tbadk.core.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public abstract class AbsThreadDataSupport extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.a.a.b {
    private com.baidu.tbadk.a.e dzN;
    public int objType = 1;
    private SupportType dzM = SupportType.FULL;
    public SparseArray<String> feedBackReasonMap = null;

    /* loaded from: classes.dex */
    public enum SupportType {
        FULL,
        TOP,
        CONTENT,
        BOTTOM,
        EXTEND
    }

    public abstract bk aOi();

    public abstract ak aOk();

    public String aOj() {
        if (aOi() == null) {
            return null;
        }
        return aOi().aOj();
    }

    public boolean isSelf() {
        return com.baidu.tbadk.core.util.au.v(aOi());
    }

    public String aOl() {
        return null;
    }

    public void a(SupportType supportType) {
        this.dzM = supportType;
    }

    public boolean aOm() {
        return this.dzM == SupportType.TOP;
    }

    public boolean aOn() {
        return this.dzM == SupportType.BOTTOM;
    }

    private boolean C(String... strArr) {
        return com.baidu.tbadk.a.a.c.b(this.dzN, strArr);
    }

    @Override // com.baidu.tbadk.a.a.b
    public void b(com.baidu.tbadk.a.e eVar) {
        this.dzN = eVar;
    }

    public boolean aOo() {
        bk aOi = aOi();
        if (aOi == null) {
            return false;
        }
        if (aOi.dHM || aOi.dHN || aOi.dHP) {
            return C("70_2", "70_5", "70_6");
        }
        return false;
    }

    public boolean aOp() {
        return C("70_3", "70_6");
    }

    public boolean aOq() {
        bk aOi = aOi();
        if (aOi == null) {
            return false;
        }
        if (aOi.dHM || aOi.dHN) {
            return C("70_4", "70_6");
        }
        boolean isSelf = UtilHelper.isSelf(aOi.aQx());
        if (!aOi.dHP || isSelf) {
            return false;
        }
        return C("70_2", "70_5", "70_6");
    }

    public boolean aOr() {
        bk aOi = aOi();
        if (aOi != null && aOi.dHM) {
            return C("70_5", "70_6");
        }
        return false;
    }

    public boolean aOs() {
        bk aOi = aOi();
        if (aOi == null || aOi.aQx() == null || com.baidu.tbadk.core.util.au.v(aOi)) {
            return false;
        }
        if (aOr()) {
            MetaData aQx = aOi.aQx();
            boolean hadConcerned = aQx.hadConcerned();
            if (aOi.dHM) {
                return !hadConcerned || (hadConcerned && !aQx.isLikeStatusFromNet());
            }
            return false;
        }
        boolean z = aOi.aSu() || aOi.aPm() || aOi.aPn();
        if (aOi.dHM && z) {
            return true;
        }
        return aOi.dHO && z && !aOi.aQx().hadConcerned();
    }
}
