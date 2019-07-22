package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener caw;

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
        return ((bg) this.mData).afQ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bg */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(bg bgVar) {
        if (bgVar != 0) {
            if (bgVar.afS() != 0) {
                if (bgVar.afT() == 0 || bgVar.afT() == 1) {
                    bgVar.hr(2);
                }
                if (bgVar.afT() == 3 || bgVar.afT() == 4) {
                    bgVar.hr(5);
                }
            }
            this.mData = bgVar;
            this.mThreadId = bgVar.getTid();
            this.mForumId = String.valueOf(bgVar.getFid());
            this.bLE = ((bg) this.mData).afQ();
            this.bLF = ((bg) this.mData).afR();
            JS();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JS() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bWY);
        if (num > 0) {
            string = aq.aO(num);
        }
        this.bXd.setText(string);
        this.bXd.setContentDescription(context.getString(this.bWY) + num);
        if (this.mData != 0 && ((bg) this.mData).afS() != 0 && akj()) {
            this.bXe.setImageDrawable(Z(this.bXa, this.bWZ));
            this.bXd.setTextColor(createColorStateList(this.bXc, this.bXb));
            return;
        }
        this.bXe.setImageDrawable(Z(this.bWZ, this.bXa));
        this.bXd.setTextColor(createColorStateList(this.bXb, this.bXc));
    }

    public int aki() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).afS() != 0 && akj()) {
            ((bg) this.mData).hr(2);
            ((bg) this.mData).hp(0);
            ((bg) this.mData).as(((bg) this.mData).afQ() - 1);
            ((bg) this.mData).at(((bg) this.mData).afR());
            i = 1;
        } else {
            if (((bg) this.mData).afS() != 0 && ((bg) this.mData).afT() == 5) {
                ((bg) this.mData).at(((bg) this.mData).afR() - 1);
            }
            ((bg) this.mData).hp(1);
            ((bg) this.mData).as(((bg) this.mData).afQ() + 1);
            ((bg) this.mData).hr(2);
            com.baidu.tieba.n.a.chl().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aN(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bd.cF(getContext()) || this.mData == 0) {
            return -1;
        }
        int aki = aki();
        JS();
        ix(aki);
        iw(aki);
        if (this.bWk != null) {
            this.bWk.onClick(view);
        }
        a(aki, (bg) this.mData);
        if (this.caw != null && ((bg) this.mData).aeB()) {
            this.caw.onClick(view);
        }
        return aki;
    }

    public boolean akj() {
        return this.mData != 0 && (((bg) this.mData).afT() == 2 || ((bg) this.mData).afT() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.caw = onClickListener;
    }
}
