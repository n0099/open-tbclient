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
        ajc();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ajc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void ajc() {
        this.agreeType = 5;
        this.bVW = R.string.action_dislike;
        this.bVZ = R.color.cp_cont_j;
        this.bWa = R.color.cp_link_tip_a;
        this.bVX = R.drawable.icon_card_dislike_n;
        this.bVY = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).aeP();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aje() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmp() && ajf()) {
            ((PostData) this.mData).hl(5);
            ((PostData) this.mData).qP(false);
            ((PostData) this.mData).ar(((PostData) this.mData).aeO());
            ((PostData) this.mData).as(((PostData) this.mData).aeP() - 1);
            i = 1;
        } else {
            int aeR = ((PostData) this.mData).aeR();
            if ((((PostData) this.mData).bmp() && aeR == 2) || aeR == 1) {
                ((PostData) this.mData).ar(((PostData) this.mData).aeO() - 1);
            }
            ((PostData) this.mData).qP(true);
            ((PostData) this.mData).as(((PostData) this.mData).aeP() + 1);
            ((PostData) this.mData).hl(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int aL(View view) {
        int aL = super.aL(view);
        ee(aL == 0);
        return aL;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean ajf() {
        return this.mData != 0 && ((PostData) this.mData).aeR() == 5;
    }
}
