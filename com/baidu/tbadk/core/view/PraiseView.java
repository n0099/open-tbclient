package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes6.dex */
public class PraiseView extends BasePraiseView<bb> {
    private View.OnClickListener aIx;

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
        return ((bb) this.mData).AS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bb */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(bb bbVar) {
        if (bbVar != 0) {
            if (bbVar.AU() != 0) {
                if (bbVar.AV() == 0 || bbVar.AV() == 1) {
                    bbVar.cY(2);
                }
                if (bbVar.AV() == 3 || bbVar.AV() == 4) {
                    bbVar.cY(5);
                }
            }
            this.mData = bbVar;
            this.mThreadId = bbVar.getTid();
            this.mForumId = String.valueOf(bbVar.getFid());
            this.avh = ((bb) this.mData).AS();
            this.avi = ((bb) this.mData).AT();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFr);
        if (num > 0) {
            string = ao.W(num);
        }
        this.aFw.setText(string);
        this.aFw.setContentDescription(context.getString(this.aFr) + num);
        if (this.mData != 0 && ((bb) this.mData).AU() != 0 && EK()) {
            this.aFx.setImageDrawable(createStateDrawable(this.aFt, this.aFs));
            this.aFw.setTextColor(createColorStateList(this.aFv, this.aFu));
            return;
        }
        this.aFx.setImageDrawable(createStateDrawable(this.aFs, this.aFt));
        this.aFw.setTextColor(createColorStateList(this.aFu, this.aFv));
    }

    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).AU() != 0 && EK()) {
            ((bb) this.mData).cY(2);
            ((bb) this.mData).cW(0);
            ((bb) this.mData).C(((bb) this.mData).AS() - 1);
            ((bb) this.mData).D(((bb) this.mData).AT());
            i = 1;
        } else {
            if (((bb) this.mData).AU() != 0 && ((bb) this.mData).AV() == 5) {
                ((bb) this.mData).D(((bb) this.mData).AT() - 1);
            }
            ((bb) this.mData).cW(1);
            ((bb) this.mData).C(((bb) this.mData).AS() + 1);
            ((bb) this.mData).cY(2);
            com.baidu.tieba.n.a.buh().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bJ(getContext()) || this.mData == 0) {
            return -1;
        }
        int EJ = EJ();
        updateUI();
        dZ(EJ);
        ea(EJ);
        if (this.aEZ != null) {
            this.aEZ.onClick(view);
        }
        a(EJ, (bb) this.mData);
        if (this.aIx != null && ((bb) this.mData).zL()) {
            this.aIx.onClick(view);
        }
        return EJ;
    }

    public boolean EK() {
        return this.mData != 0 && (((bb) this.mData).AV() == 2 || ((bb) this.mData).AV() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aIx = onClickListener;
    }
}
