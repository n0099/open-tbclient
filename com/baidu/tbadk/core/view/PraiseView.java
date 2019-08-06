package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bh> {
    private View.OnClickListener caC;

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
        return ((bh) this.mData).afR();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bh */
    /* JADX WARN: Multi-variable type inference failed */
    public void o(bh bhVar) {
        if (bhVar != 0) {
            if (bhVar.afT() != 0) {
                if (bhVar.afU() == 0 || bhVar.afU() == 1) {
                    bhVar.hr(2);
                }
                if (bhVar.afU() == 3 || bhVar.afU() == 4) {
                    bhVar.hr(5);
                }
            }
            this.mData = bhVar;
            this.mThreadId = bhVar.getTid();
            this.mForumId = String.valueOf(bhVar.getFid());
            this.bLJ = ((bh) this.mData).afR();
            this.bLK = ((bh) this.mData).afS();
            JS();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JS() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bXe);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bXj.setText(string);
        this.bXj.setContentDescription(context.getString(this.bXe) + num);
        if (this.mData != 0 && ((bh) this.mData).afT() != 0 && akl()) {
            this.bXk.setImageDrawable(Z(this.bXg, this.bXf));
            this.bXj.setTextColor(createColorStateList(this.bXi, this.bXh));
            return;
        }
        this.bXk.setImageDrawable(Z(this.bXf, this.bXg));
        this.bXj.setTextColor(createColorStateList(this.bXh, this.bXi));
    }

    public int akk() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).afT() != 0 && akl()) {
            ((bh) this.mData).hr(2);
            ((bh) this.mData).hp(0);
            ((bh) this.mData).as(((bh) this.mData).afR() - 1);
            ((bh) this.mData).at(((bh) this.mData).afS());
            i = 1;
        } else {
            if (((bh) this.mData).afT() != 0 && ((bh) this.mData).afU() == 5) {
                ((bh) this.mData).at(((bh) this.mData).afS() - 1);
            }
            ((bh) this.mData).hp(1);
            ((bh) this.mData).as(((bh) this.mData).afR() + 1);
            ((bh) this.mData).hr(2);
            com.baidu.tieba.n.a.chD().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aN(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bd.cF(getContext()) || this.mData == 0) {
            return -1;
        }
        int akk = akk();
        JS();
        ix(akk);
        iw(akk);
        if (this.bWq != null) {
            this.bWq.onClick(view);
        }
        a(akk, (bh) this.mData);
        if (this.caC != null && ((bh) this.mData).aeC()) {
            this.caC.onClick(view);
        }
        return akk;
    }

    public boolean akl() {
        return this.mData != 0 && (((bh) this.mData).afU() == 2 || ((bh) this.mData).afU() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caC = onClickListener;
    }
}
