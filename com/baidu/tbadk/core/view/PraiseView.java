package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bh> {
    private View.OnClickListener coV;

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
        return ((bh) this.mData).ajW();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bh */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(bh bhVar) {
        if (bhVar != 0) {
            if (bhVar.ajY() != 0) {
                if (bhVar.ajZ() == 0 || bhVar.ajZ() == 1) {
                    bhVar.hQ(2);
                }
                if (bhVar.ajZ() == 3 || bhVar.ajZ() == 4) {
                    bhVar.hQ(5);
                }
            }
            this.mData = bhVar;
            this.mThreadId = bhVar.getTid();
            this.mForumId = String.valueOf(bhVar.getFid());
            this.ccZ = ((bh) this.mData).ajW();
            this.cda = ((bh) this.mData).ajX();
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
        this.cmo.setText(string);
        this.cmo.setContentDescription(context.getString(this.textResId) + num);
        if (this.mData != 0 && ((bh) this.mData).ajY() != 0 && anx()) {
            this.cmp.setImageDrawable(ab(this.cml, this.drawableResId));
            this.cmo.setTextColor(createColorStateList(this.cmn, this.cmm));
            return;
        }
        this.cmp.setImageDrawable(ab(this.drawableResId, this.cml));
        this.cmo.setTextColor(createColorStateList(this.cmm, this.cmn));
    }

    public int anw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bh) this.mData).ajY() != 0 && anx()) {
            ((bh) this.mData).hQ(2);
            ((bh) this.mData).hO(0);
            ((bh) this.mData).aK(((bh) this.mData).ajW() - 1);
            ((bh) this.mData).aL(((bh) this.mData).ajX());
            i = 1;
        } else {
            if (((bh) this.mData).ajY() != 0 && ((bh) this.mData).ajZ() == 5) {
                ((bh) this.mData).aL(((bh) this.mData).ajX() - 1);
            }
            ((bh) this.mData).hO(1);
            ((bh) this.mData).aK(((bh) this.mData).ajW() + 1);
            ((bh) this.mData).hQ(2);
            com.baidu.tieba.n.a.cfn().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aO(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.checkUpIsLogin(getContext()) || this.mData == 0) {
            return -1;
        }
        int anw = anw();
        updateUI();
        iy(anw);
        ix(anw);
        if (this.clw != null) {
            this.clw.onClick(view);
        }
        a(anw, (bh) this.mData);
        if (this.coV != null && ((bh) this.mData).aiI()) {
            this.coV.onClick(view);
        }
        return anw;
    }

    public boolean anx() {
        return this.mData != 0 && (((bh) this.mData).ajZ() == 2 || ((bh) this.mData).ajZ() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.coV = onClickListener;
    }
}
