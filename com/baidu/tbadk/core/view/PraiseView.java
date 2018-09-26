package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes2.dex */
public class PraiseView extends BasePraiseView<bb> {
    private View.OnClickListener azz;

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
        return ((bb) this.mData).xy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bb */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(bb bbVar) {
        if (bbVar != 0) {
            if (bbVar.xA() != 0) {
                if (bbVar.xB() == 0 || bbVar.xB() == 1) {
                    bbVar.cm(2);
                }
                if (bbVar.xB() == 3 || bbVar.xB() == 4) {
                    bbVar.cm(5);
                }
            }
            this.mData = bbVar;
            this.mThreadId = bbVar.getTid();
            this.mForumId = String.valueOf(bbVar.getFid());
            this.alZ = ((bb) this.mData).xy();
            this.ama = ((bb) this.mData).xz();
            Bp();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bp() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.awr);
        if (num > 0) {
            string = ao.L(num);
        }
        this.aww.setText(string);
        this.aww.setContentDescription(context.getString(this.awr) + num);
        if (this.mData != 0 && ((bb) this.mData).xA() != 0 && Bt()) {
            this.awx.setImageDrawable(createStateDrawable(this.awt, this.aws));
            this.aww.setTextColor(createColorStateList(this.awv, this.awu));
            return;
        }
        this.awx.setImageDrawable(createStateDrawable(this.aws, this.awt));
        this.aww.setTextColor(createColorStateList(this.awu, this.awv));
    }

    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bb) this.mData).xA() != 0 && Bt()) {
            ((bb) this.mData).cm(2);
            ((bb) this.mData).ck(0);
            ((bb) this.mData).t(((bb) this.mData).xy() - 1);
            ((bb) this.mData).u(((bb) this.mData).xz());
            i = 1;
        } else {
            if (((bb) this.mData).xA() != 0 && ((bb) this.mData).xB() == 5) {
                ((bb) this.mData).u(((bb) this.mData).xz() - 1);
            }
            ((bb) this.mData).ck(1);
            ((bb) this.mData).t(((bb) this.mData).xy() + 1);
            ((bb) this.mData).cm(2);
            com.baidu.tieba.n.a.bpD().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bA(getContext()) || this.mData == 0) {
            return -1;
        }
        int Bs = Bs();
        Bp();
        dn(Bs);
        m15do(Bs);
        if (this.avZ != null) {
            this.avZ.onClick(view);
        }
        a(Bs, (bb) this.mData);
        if (this.azz != null && ((bb) this.mData).wr()) {
            this.azz.onClick(view);
        }
        return Bs;
    }

    public boolean Bt() {
        return this.mData != 0 && (((bb) this.mData).xB() == 2 || ((bb) this.mData).xB() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.azz = onClickListener;
    }
}
