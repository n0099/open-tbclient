package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes3.dex */
public class PraiseView extends BasePraiseView<bg> {
    private View.OnClickListener bRB;

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
            this.bDm = ((bg) this.mData).aah();
            this.bDn = ((bg) this.mData).aai();
            GP();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GP() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.bOg);
        if (num > 0) {
            string = ap.az(num);
        }
        this.bOl.setText(string);
        this.bOl.setContentDescription(context.getString(this.bOg) + num);
        if (this.mData != 0 && ((bg) this.mData).aaj() != 0 && aeg()) {
            this.bOm.setImageDrawable(W(this.bOi, this.bOh));
            this.bOl.setTextColor(createColorStateList(this.bOk, this.bOj));
            return;
        }
        this.bOm.setImageDrawable(W(this.bOh, this.bOi));
        this.bOl.setTextColor(createColorStateList(this.bOj, this.bOk));
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
        if (this.bNw != null) {
            this.bNw.onClick(view);
        }
        a(aef, (bg) this.mData);
        if (this.bRB != null && ((bg) this.mData).YS()) {
            this.bRB.onClick(view);
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
        this.bRB = onClickListener;
    }
}
