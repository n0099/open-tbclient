package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bh> {
    private View.OnClickListener cpN;

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
        return ((bh) this.mData).ajY();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bh */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(bh bhVar) {
        if (bhVar != 0) {
            if (bhVar.aka() != 0) {
                if (bhVar.akb() == 0 || bhVar.akb() == 1) {
                    bhVar.hR(2);
                }
                if (bhVar.akb() == 3 || bhVar.akb() == 4) {
                    bhVar.hR(5);
                }
            }
            this.mData = bhVar;
            this.mThreadId = bhVar.getTid();
            this.mForumId = String.valueOf(bhVar.getFid());
            this.cdQ = ((bh) this.mData).ajY();
            this.cdR = ((bh) this.mData).ajZ();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.textResId);
        if (num > 0) {
            string = aq.numFormatOverWan(num);
        }
        this.cnf.setText(string);
        this.cnf.setContentDescription(context.getString(this.textResId) + num);
        if (this.mData != 0 && ((bh) this.mData).aka() != 0 && anz()) {
            this.cng.setImageDrawable(ad(this.cnc, this.drawableResId));
            this.cnf.setTextColor(createColorStateList(this.cne, this.cnd));
            return;
        }
        this.cng.setImageDrawable(ad(this.drawableResId, this.cnc));
        this.cnf.setTextColor(createColorStateList(this.cnd, this.cne));
    }

    public int any() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).aka() != 0 && anz()) {
            ((bh) this.mData).hR(2);
            ((bh) this.mData).hP(0);
            ((bh) this.mData).aL(((bh) this.mData).ajY() - 1);
            ((bh) this.mData).aM(((bh) this.mData).ajZ());
            i = 1;
        } else {
            if (((bh) this.mData).aka() != 0 && ((bh) this.mData).akb() == 5) {
                ((bh) this.mData).aM(((bh) this.mData).ajZ() - 1);
            }
            ((bh) this.mData).hP(1);
            ((bh) this.mData).aL(((bh) this.mData).ajY() + 1);
            ((bh) this.mData).hR(2);
            com.baidu.tieba.n.a.cfp().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aO(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.checkUpIsLogin(getContext()) || this.mData == 0) {
            return -1;
        }
        int any = any();
        updateUI();
        iz(any);
        iy(any);
        if (this.cmo != null) {
            this.cmo.onClick(view);
        }
        a(any, (bh) this.mData);
        if (this.cpN != null && ((bh) this.mData).aiK()) {
            this.cpN.onClick(view);
        }
        return any;
    }

    public boolean anz() {
        return this.mData != 0 && (((bh) this.mData).akb() == 2 || ((bh) this.mData).akb() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cpN = onClickListener;
    }
}
