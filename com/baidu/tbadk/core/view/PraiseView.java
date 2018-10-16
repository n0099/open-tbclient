package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes6.dex */
public class PraiseView extends BasePraiseView<bb> {
    private View.OnClickListener aEh;

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
        return ((bb) this.mData).zH();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bb */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(bb bbVar) {
        if (bbVar != 0) {
            if (bbVar.zJ() != 0) {
                if (bbVar.zK() == 0 || bbVar.zK() == 1) {
                    bbVar.cw(2);
                }
                if (bbVar.zK() == 3 || bbVar.zK() == 4) {
                    bbVar.cw(5);
                }
            }
            this.mData = bbVar;
            this.mThreadId = bbVar.getTid();
            this.mForumId = String.valueOf(bbVar.getFid());
            this.aqU = ((bb) this.mData).zH();
            this.aqV = ((bb) this.mData).zI();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBc);
        if (num > 0) {
            string = ao.N(num);
        }
        this.aBh.setText(string);
        this.aBh.setContentDescription(context.getString(this.aBc) + num);
        if (this.mData != 0 && ((bb) this.mData).zJ() != 0 && Dz()) {
            this.aBi.setImageDrawable(createStateDrawable(this.aBe, this.aBd));
            this.aBh.setTextColor(createColorStateList(this.aBg, this.aBf));
            return;
        }
        this.aBi.setImageDrawable(createStateDrawable(this.aBd, this.aBe));
        this.aBh.setTextColor(createColorStateList(this.aBf, this.aBg));
    }

    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).zJ() != 0 && Dz()) {
            ((bb) this.mData).cw(2);
            ((bb) this.mData).cu(0);
            ((bb) this.mData).v(((bb) this.mData).zH() - 1);
            ((bb) this.mData).w(((bb) this.mData).zI());
            i = 1;
        } else {
            if (((bb) this.mData).zJ() != 0 && ((bb) this.mData).zK() == 5) {
                ((bb) this.mData).w(((bb) this.mData).zI() - 1);
            }
            ((bb) this.mData).cu(1);
            ((bb) this.mData).v(((bb) this.mData).zH() + 1);
            ((bb) this.mData).cw(2);
            com.baidu.tieba.n.a.bsS().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bI(getContext()) || this.mData == 0) {
            return -1;
        }
        int Dy = Dy();
        updateUI();
        dx(Dy);
        dy(Dy);
        if (this.aAK != null) {
            this.aAK.onClick(view);
        }
        a(Dy, (bb) this.mData);
        if (this.aEh != null && ((bb) this.mData).yA()) {
            this.aEh.onClick(view);
        }
        return Dy;
    }

    public boolean Dz() {
        return this.mData != 0 && (((bb) this.mData).zK() == 2 || ((bb) this.mData).zK() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aEh = onClickListener;
    }
}
