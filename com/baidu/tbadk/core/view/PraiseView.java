package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener bRz;

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
        return ((bg) this.mData).aak();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bg */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(bg bgVar) {
        if (bgVar != 0) {
            if (bgVar.aam() != 0) {
                if (bgVar.aan() == 0 || bgVar.aan() == 1) {
                    bgVar.gA(2);
                }
                if (bgVar.aan() == 3 || bgVar.aan() == 4) {
                    bgVar.gA(5);
                }
            }
            this.mData = bgVar;
            this.mThreadId = bgVar.getTid();
            this.mForumId = String.valueOf(bgVar.getFid());
            this.bDj = ((bg) this.mData).aak();
            this.bDk = ((bg) this.mData).aal();
            GR();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GR() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOe);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOj.setText(string);
        this.bOj.setContentDescription(context.getString(this.bOe) + num);
        if (this.mData != 0 && ((bg) this.mData).aam() != 0 && aej()) {
            this.bOk.setImageDrawable(W(this.bOg, this.bOf));
            this.bOj.setTextColor(createColorStateList(this.bOi, this.bOh));
            return;
        }
        this.bOk.setImageDrawable(W(this.bOf, this.bOg));
        this.bOj.setTextColor(createColorStateList(this.bOh, this.bOi));
    }

    public int aei() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aam() != 0 && aej()) {
            ((bg) this.mData).gA(2);
            ((bg) this.mData).gy(0);
            ((bg) this.mData).af(((bg) this.mData).aak() - 1);
            ((bg) this.mData).ag(((bg) this.mData).aal());
            i = 1;
        } else {
            if (((bg) this.mData).aam() != 0 && ((bg) this.mData).aan() == 5) {
                ((bg) this.mData).ag(((bg) this.mData).aal() - 1);
            }
            ((bg) this.mData).gy(1);
            ((bg) this.mData).af(((bg) this.mData).aak() + 1);
            ((bg) this.mData).gA(2);
            com.baidu.tieba.n.a.bWr().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aF(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.cZ(getContext()) || this.mData == 0) {
            return -1;
        }
        int aei = aei();
        GR();
        hE(aei);
        hD(aei);
        if (this.bNu != null) {
            this.bNu.onClick(view);
        }
        a(aei, (bg) this.mData);
        if (this.bRz != null && ((bg) this.mData).YV()) {
            this.bRz.onClick(view);
        }
        return aei;
    }

    public boolean aej() {
        return this.mData != 0 && (((bg) this.mData).aan() == 2 || ((bg) this.mData).aan() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRz = onClickListener;
    }
}
