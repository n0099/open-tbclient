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
        aku();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aku();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aku() {
        this.agreeType = 5;
        this.bXX = R.string.action_dislike;
        this.bYa = R.color.cp_cont_j;
        this.bYb = R.color.cp_link_tip_a;
        this.bXY = R.drawable.icon_card_dislike_n;
        this.bXZ = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).afW();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int akw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bpo() && akx()) {
            ((PostData) this.mData).hs(5);
            ((PostData) this.mData).ri(false);
            ((PostData) this.mData).as(((PostData) this.mData).afV());
            ((PostData) this.mData).at(((PostData) this.mData).afW() - 1);
            i = 1;
        } else {
            int afY = ((PostData) this.mData).afY();
            if ((((PostData) this.mData).bpo() && afY == 2) || afY == 1) {
                ((PostData) this.mData).as(((PostData) this.mData).afV() - 1);
            }
            ((PostData) this.mData).ri(true);
            ((PostData) this.mData).at(((PostData) this.mData).afW() + 1);
            ((PostData) this.mData).hs(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aN(View view) {
        int aN = super.aN(view);
        el(aN == 0);
        return aN;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean akx() {
        return this.mData != 0 && ((PostData) this.mData).afY() == 5;
    }
}
