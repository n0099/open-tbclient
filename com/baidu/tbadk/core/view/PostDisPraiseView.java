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
        anu();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        anu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void anu() {
        this.agreeType = 5;
        this.textResId = R.string.action_dislike;
        this.cmm = R.color.cp_cont_j;
        this.cmn = R.color.cp_link_tip_a;
        this.drawableResId = R.drawable.icon_card_dislike_n;
        this.cml = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).ajX();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int anw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmr() && anx()) {
            ((PostData) this.mData).hQ(5);
            ((PostData) this.mData).qR(false);
            ((PostData) this.mData).aK(((PostData) this.mData).ajW());
            ((PostData) this.mData).aL(((PostData) this.mData).ajX() - 1);
            i = 1;
        } else {
            int ajZ = ((PostData) this.mData).ajZ();
            if ((((PostData) this.mData).bmr() && ajZ == 2) || ajZ == 1) {
                ((PostData) this.mData).aK(((PostData) this.mData).ajW() - 1);
            }
            ((PostData) this.mData).qR(true);
            ((PostData) this.mData).aL(((PostData) this.mData).ajX() + 1);
            ((PostData) this.mData).hQ(5);
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
    public boolean anx() {
        return this.mData != 0 && ((PostData) this.mData).ajZ() == 5;
    }
}
