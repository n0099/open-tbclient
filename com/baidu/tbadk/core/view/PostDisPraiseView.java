package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostDisPraiseView extends PostPraiseView {
    public PostDisPraiseView(Context context) {
        super(context);
        anw();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void anw() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cnd = R.color.cp_cont_j;
        this.cne = R.color.cp_link_tip_a;
        this.drawableResId = R.drawable.icon_card_dislike_n;
        this.cnc = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).ajZ();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int any() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmt() && anz()) {
            ((PostData) this.mData).hR(5);
            ((PostData) this.mData).qR(false);
            ((PostData) this.mData).aL(((PostData) this.mData).ajY());
            ((PostData) this.mData).aM(((PostData) this.mData).ajZ() - 1);
            i = 1;
        } else {
            int akb = ((PostData) this.mData).akb();
            if ((((PostData) this.mData).bmt() && akb == 2) || akb == 1) {
                ((PostData) this.mData).aL(((PostData) this.mData).ajY() - 1);
            }
            ((PostData) this.mData).qR(true);
            ((PostData) this.mData).aM(((PostData) this.mData).ajZ() + 1);
            ((PostData) this.mData).hR(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aO(View view) {
        int aO = super.aO(view);
        eq(aO == 0);
        return aO;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean anz() {
        return this.mData != 0 && ((PostData) this.mData).akb() == 5;
    }
}
