package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener bRy;

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
            this.bDh = ((bg) this.mData).aak();
            this.bDi = ((bg) this.mData).aal();
            GR();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GR() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOd);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOi.setText(string);
        this.bOi.setContentDescription(context.getString(this.bOd) + num);
        if (this.mData != 0 && ((bg) this.mData).aam() != 0 && aej()) {
            this.bOj.setImageDrawable(W(this.bOf, this.bOe));
            this.bOi.setTextColor(createColorStateList(this.bOh, this.bOg));
            return;
        }
        this.bOj.setImageDrawable(W(this.bOe, this.bOf));
        this.bOi.setTextColor(createColorStateList(this.bOg, this.bOh));
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
            com.baidu.tieba.n.a.bWo().y(getTbPageContext());
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
        if (this.bNt != null) {
            this.bNt.onClick(view);
        }
        a(aei, (bg) this.mData);
        if (this.bRy != null && ((bg) this.mData).YV()) {
            this.bRy.onClick(view);
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
        this.bRy = onClickListener;
    }
}
