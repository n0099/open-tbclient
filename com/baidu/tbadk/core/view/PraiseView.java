package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bh> {
    private View.OnClickListener cbv;

    public PraiseView(Context context) {
        this(context, null);
    }

    public PraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((bh) this.mData).afV();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bh */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(bh bhVar) {
        if (bhVar != 0) {
            if (bhVar.afX() != 0) {
                if (bhVar.afY() == 0 || bhVar.afY() == 1) {
                    bhVar.hs(2);
                }
                if (bhVar.afY() == 3 || bhVar.afY() == 4) {
                    bhVar.hs(5);
                }
            }
            this.mData = bhVar;
            this.mThreadId = bhVar.getTid();
            this.mForumId = String.valueOf(bhVar.getFid());
            this.bMh = ((bh) this.mData).afV();
            this.bMi = ((bh) this.mData).afW();
            JW();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JW() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bXX);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bYc.setText(string);
        this.bYc.setContentDescription(context.getString(this.bXX) + num);
        if (this.mData != 0 && ((bh) this.mData).afX() != 0 && akx()) {
            this.bYd.setImageDrawable(Z(this.bXZ, this.bXY));
            this.bYc.setTextColor(createColorStateList(this.bYb, this.bYa));
            return;
        }
        this.bYd.setImageDrawable(Z(this.bXY, this.bXZ));
        this.bYc.setTextColor(createColorStateList(this.bYa, this.bYb));
    }

    public int akw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).afX() != 0 && akx()) {
            ((bh) this.mData).hs(2);
            ((bh) this.mData).hq(0);
            ((bh) this.mData).as(((bh) this.mData).afV() - 1);
            ((bh) this.mData).at(((bh) this.mData).afW());
            i = 1;
        } else {
            if (((bh) this.mData).afX() != 0 && ((bh) this.mData).afY() == 5) {
                ((bh) this.mData).at(((bh) this.mData).afW() - 1);
            }
            ((bh) this.mData).hq(1);
            ((bh) this.mData).as(((bh) this.mData).afV() + 1);
            ((bh) this.mData).hs(2);
            com.baidu.tieba.n.a.cir().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aN(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.cF(getContext()) || this.mData == 0) {
            return -1;
        }
        int akw = akw();
        JW();
        iA(akw);
        iz(akw);
        if (this.bXj != null) {
            this.bXj.onClick(view);
        }
        a(akw, (bh) this.mData);
        if (this.cbv != null && ((bh) this.mData).aeG()) {
            this.cbv.onClick(view);
        }
        return akw;
    }

    public boolean akx() {
        return this.mData != 0 && (((bh) this.mData).afY() == 2 || ((bh) this.mData).afY() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbv = onClickListener;
    }
}
