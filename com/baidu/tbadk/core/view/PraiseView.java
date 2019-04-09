package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener bRC;

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
        return ((bg) this.mData).aah();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.core.data.bg */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(bg bgVar) {
        if (bgVar != 0) {
            if (bgVar.aaj() != 0) {
                if (bgVar.aak() == 0 || bgVar.aak() == 1) {
                    bgVar.gz(2);
                }
                if (bgVar.aak() == 3 || bgVar.aak() == 4) {
                    bgVar.gz(5);
                }
            }
            this.mData = bgVar;
            this.mThreadId = bgVar.getTid();
            this.mForumId = String.valueOf(bgVar.getFid());
            this.bDn = ((bg) this.mData).aah();
            this.bDo = ((bg) this.mData).aai();
            GP();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GP() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOh);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOm.setText(string);
        this.bOm.setContentDescription(context.getString(this.bOh) + num);
        if (this.mData != 0 && ((bg) this.mData).aaj() != 0 && aeg()) {
            this.bOn.setImageDrawable(W(this.bOj, this.bOi));
            this.bOm.setTextColor(createColorStateList(this.bOl, this.bOk));
            return;
        }
        this.bOn.setImageDrawable(W(this.bOi, this.bOj));
        this.bOm.setTextColor(createColorStateList(this.bOk, this.bOl));
    }

    public int aef() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((bg) this.mData).aaj() != 0 && aeg()) {
            ((bg) this.mData).gz(2);
            ((bg) this.mData).gx(0);
            ((bg) this.mData).af(((bg) this.mData).aah() - 1);
            ((bg) this.mData).ag(((bg) this.mData).aai());
            i = 1;
        } else {
            if (((bg) this.mData).aaj() != 0 && ((bg) this.mData).aak() == 5) {
                ((bg) this.mData).ag(((bg) this.mData).aai() - 1);
            }
            ((bg) this.mData).gx(1);
            ((bg) this.mData).af(((bg) this.mData).aah() + 1);
            ((bg) this.mData).gz(2);
            com.baidu.tieba.n.a.bWn().x(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aF(View view) {
        if (com.baidu.tbadk.util.i.isFastDoubleClick() || !bc.cZ(getContext()) || this.mData == 0) {
            return -1;
        }
        int aef = aef();
        GP();
        hD(aef);
        hC(aef);
        if (this.bNx != null) {
            this.bNx.onClick(view);
        }
        a(aef, (bg) this.mData);
        if (this.bRC != null && ((bg) this.mData).YS()) {
            this.bRC.onClick(view);
        }
        return aef;
    }

    public boolean aeg() {
        return this.mData != 0 && (((bg) this.mData).aak() == 2 || ((bg) this.mData).aak() == 1);
    }

    public void setShowPraiseNum(boolean z) {
    }

    public void setNeedAddPraiseIcon(boolean z) {
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bRC = onClickListener;
    }
}
