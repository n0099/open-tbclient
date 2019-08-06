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
        aki();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aki();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void aki() {
        this.agreeType = 5;
        this.bXe = R.string.action_dislike;
        this.bXh = R.color.cp_cont_j;
        this.bXi = R.color.cp_link_tip_a;
        this.bXf = R.drawable.icon_card_dislike_n;
        this.bXg = R.drawable.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).afS();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int akk() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).boD() && akl()) {
            ((PostData) this.mData).hr(5);
            ((PostData) this.mData).rf(false);
            ((PostData) this.mData).as(((PostData) this.mData).afR());
            ((PostData) this.mData).at(((PostData) this.mData).afS() - 1);
            i = 1;
        } else {
            int afU = ((PostData) this.mData).afU();
            if ((((PostData) this.mData).boD() && afU == 2) || afU == 1) {
                ((PostData) this.mData).as(((PostData) this.mData).afR() - 1);
            }
            ((PostData) this.mData).rf(true);
            ((PostData) this.mData).at(((PostData) this.mData).afS() + 1);
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
    public boolean akl() {
        return this.mData != 0 && ((PostData) this.mData).afU() == 5;
    }
}
