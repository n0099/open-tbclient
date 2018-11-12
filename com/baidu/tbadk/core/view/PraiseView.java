package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes6.dex */
public class PraiseView extends BasePraiseView<bb> {
    private View.OnClickListener aEX;

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
        return ((bb) this.mData).zO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bb */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(bb bbVar) {
        if (bbVar != 0) {
            if (bbVar.zQ() != 0) {
                if (bbVar.zR() == 0 || bbVar.zR() == 1) {
                    bbVar.cK(2);
                }
                if (bbVar.zR() == 3 || bbVar.zR() == 4) {
                    bbVar.cK(5);
                }
            }
            this.mData = bbVar;
            this.mThreadId = bbVar.getTid();
            this.mForumId = String.valueOf(bbVar.getFid());
            this.arH = ((bb) this.mData).zO();
            this.arI = ((bb) this.mData).zP();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBR);
        if (num > 0) {
            string = ao.P(num);
        }
        this.aBW.setText(string);
        this.aBW.setContentDescription(context.getString(this.aBR) + num);
        if (this.mData != 0 && ((bb) this.mData).zQ() != 0 && DG()) {
            this.aBX.setImageDrawable(createStateDrawable(this.aBT, this.aBS));
            this.aBW.setTextColor(createColorStateList(this.aBV, this.aBU));
            return;
        }
        this.aBX.setImageDrawable(createStateDrawable(this.aBS, this.aBT));
        this.aBW.setTextColor(createColorStateList(this.aBU, this.aBV));
    }

    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).zQ() != 0 && DG()) {
            ((bb) this.mData).cK(2);
            ((bb) this.mData).cI(0);
            ((bb) this.mData).x(((bb) this.mData).zO() - 1);
            ((bb) this.mData).y(((bb) this.mData).zP());
            i = 1;
        } else {
            if (((bb) this.mData).zQ() != 0 && ((bb) this.mData).zR() == 5) {
                ((bb) this.mData).y(((bb) this.mData).zP() - 1);
            }
            ((bb) this.mData).cI(1);
            ((bb) this.mData).x(((bb) this.mData).zO() + 1);
            ((bb) this.mData).cK(2);
            com.baidu.tieba.n.a.bso().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bG(getContext()) || this.mData == 0) {
            return -1;
        }
        int DF = DF();
        updateUI();
        dL(DF);
        dM(DF);
        if (this.aBz != null) {
            this.aBz.onClick(view);
        }
        a(DF, (bb) this.mData);
        if (this.aEX != null && ((bb) this.mData).yH()) {
            this.aEX.onClick(view);
        }
        return DF;
    }

    public boolean DG() {
        return this.mData != 0 && (((bb) this.mData).zR() == 2 || ((bb) this.mData).zR() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEX = onClickListener;
    }
}
