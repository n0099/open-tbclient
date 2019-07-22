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
        akg();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        akg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void akg() {
        this.agreeType = 5;
        this.bWY = R.string.action_dislike;
        this.bXb = R.color.cp_cont_j;
        this.bXc = R.color.cp_link_tip_a;
        this.bWZ = R.drawable.icon_card_dislike_n;
        this.bXa = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).afR();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aki() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).boq() && akj()) {
            ((PostData) this.mData).hr(5);
            ((PostData) this.mData).re(false);
            ((PostData) this.mData).as(((PostData) this.mData).afQ());
            ((PostData) this.mData).at(((PostData) this.mData).afR() - 1);
            i = 1;
        } else {
            int afT = ((PostData) this.mData).afT();
            if ((((PostData) this.mData).boq() && afT == 2) || afT == 1) {
                ((PostData) this.mData).as(((PostData) this.mData).afQ() - 1);
            }
            ((PostData) this.mData).re(true);
            ((PostData) this.mData).at(((PostData) this.mData).afR() + 1);
            ((PostData) this.mData).hr(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aN(View view) {
        int aN = super.aN(view);
        ei(aN == 0);
        return aN;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean akj() {
        return this.mData != 0 && ((PostData) this.mData).afT() == 5;
    }
}
