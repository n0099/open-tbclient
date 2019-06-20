package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener bZu;

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
        return ((bg) this.mData).aeO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bg */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(bg bgVar) {
        if (bgVar != 0) {
            if (bgVar.aeQ() != 0) {
                if (bgVar.aeR() == 0 || bgVar.aeR() == 1) {
                    bgVar.hl(2);
                }
                if (bgVar.aeR() == 3 || bgVar.aeR() == 4) {
                    bgVar.hl(5);
                }
            }
            this.mData = bgVar;
            this.mThreadId = bgVar.getTid();
            this.mForumId = String.valueOf(bgVar.getFid());
            this.bKE = ((bg) this.mData).aeO();
            this.bKF = ((bg) this.mData).aeP();
            Jf();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Jf() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bVW);
        if (num > 0) {
            string = ap.aN(num);
        }
        this.bWb.setText(string);
        this.bWb.setContentDescription(context.getString(this.bVW) + num);
        if (this.mData != 0 && ((bg) this.mData).aeQ() != 0 && ajf()) {
            this.bWc.setImageDrawable(W(this.bVY, this.bVX));
            this.bWb.setTextColor(createColorStateList(this.bWa, this.bVZ));
            return;
        }
        this.bWc.setImageDrawable(W(this.bVX, this.bVY));
        this.bWb.setTextColor(createColorStateList(this.bVZ, this.bWa));
    }

    public int aje() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aeQ() != 0 && ajf()) {
            ((bg) this.mData).hl(2);
            ((bg) this.mData).hj(0);
            ((bg) this.mData).ar(((bg) this.mData).aeO() - 1);
            ((bg) this.mData).as(((bg) this.mData).aeP());
            i = 1;
        } else {
            if (((bg) this.mData).aeQ() != 0 && ((bg) this.mData).aeR() == 5) {
                ((bg) this.mData).as(((bg) this.mData).aeP() - 1);
            }
            ((bg) this.mData).hj(1);
            ((bg) this.mData).ar(((bg) this.mData).aeO() + 1);
            ((bg) this.mData).hl(2);
            com.baidu.tieba.n.a.ceu().x(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aL(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.cE(getContext()) || this.mData == 0) {
            return -1;
        }
        int aje = aje();
        Jf();
        ir(aje);
        iq(aje);
        if (this.bVj != null) {
            this.bVj.onClick(view);
        }
        a(aje, (bg) this.mData);
        if (this.bZu != null && ((bg) this.mData).adz()) {
            this.bZu.onClick(view);
        }
        return aje;
    }

    public boolean ajf() {
        return this.mData != 0 && (((bg) this.mData).aeR() == 2 || ((bg) this.mData).aeR() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bZu = onClickListener;
    }
}
