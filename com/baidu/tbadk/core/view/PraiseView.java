package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes6.dex */
public class PraiseView extends BasePraiseView<bb> {
    private View.OnClickListener aJb;

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
        return ((bb) this.mData).Bf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bb */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(bb bbVar) {
        if (bbVar != 0) {
            if (bbVar.Bh() != 0) {
                if (bbVar.Bi() == 0 || bbVar.Bi() == 1) {
                    bbVar.cY(2);
                }
                if (bbVar.Bi() == 3 || bbVar.Bi() == 4) {
                    bbVar.cY(5);
                }
            }
            this.mData = bbVar;
            this.mThreadId = bbVar.getTid();
            this.mForumId = String.valueOf(bbVar.getFid());
            this.avK = ((bb) this.mData).Bf();
            this.avL = ((bb) this.mData).Bg();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFV);
        if (num > 0) {
            string = ao.X(num);
        }
        this.aGa.setText(string);
        this.aGa.setContentDescription(context.getString(this.aFV) + num);
        if (this.mData != 0 && ((bb) this.mData).Bh() != 0 && EX()) {
            this.aGb.setImageDrawable(createStateDrawable(this.aFX, this.aFW));
            this.aGa.setTextColor(createColorStateList(this.aFZ, this.aFY));
            return;
        }
        this.aGb.setImageDrawable(createStateDrawable(this.aFW, this.aFX));
        this.aGa.setTextColor(createColorStateList(this.aFY, this.aFZ));
    }

    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).Bh() != 0 && EX()) {
            ((bb) this.mData).cY(2);
            ((bb) this.mData).cW(0);
            ((bb) this.mData).C(((bb) this.mData).Bf() - 1);
            ((bb) this.mData).D(((bb) this.mData).Bg());
            i = 1;
        } else {
            if (((bb) this.mData).Bh() != 0 && ((bb) this.mData).Bi() == 5) {
                ((bb) this.mData).D(((bb) this.mData).Bg() - 1);
            }
            ((bb) this.mData).cW(1);
            ((bb) this.mData).C(((bb) this.mData).Bf() + 1);
            ((bb) this.mData).cY(2);
            com.baidu.tieba.n.a.bvB().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bJ(getContext()) || this.mData == 0) {
            return -1;
        }
        int EW = EW();
        updateUI();
        dZ(EW);
        ea(EW);
        if (this.aFD != null) {
            this.aFD.onClick(view);
        }
        a(EW, (bb) this.mData);
        if (this.aJb != null && ((bb) this.mData).zY()) {
            this.aJb.onClick(view);
        }
        return EW;
    }

    public boolean EX() {
        return this.mData != 0 && (((bb) this.mData).Bi() == 2 || ((bb) this.mData).Bi() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aJb = onClickListener;
    }
}
