package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PostDisPraiseView extends PostPraiseView {
    public PostDisPraiseView(Context context) {
        super(context);
        Dw();
    }

    public PostDisPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Dw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Dw() {
        this.agreeType = 5;
        this.aBc = e.j.action_dislike;
        this.aBf = e.d.cp_cont_j;
        this.aBg = e.d.cp_link_tip_a;
        this.aBd = e.f.icon_card_dislike_n;
        this.aBe = e.f.icon_card_dislike_s;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView, com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).zI();
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aBT() && Dz()) {
            ((PostData) this.mData).cw(5);
            ((PostData) this.mData).ni(false);
            ((PostData) this.mData).v(((PostData) this.mData).zH());
            ((PostData) this.mData).w(((PostData) this.mData).zI() - 1);
            i = 1;
        } else {
            int zK = ((PostData) this.mData).zK();
            if ((((PostData) this.mData).aBT() && zK == 2) || zK == 1) {
                ((PostData) this.mData).v(((PostData) this.mData).zH() - 1);
            }
            ((PostData) this.mData).ni(true);
            ((PostData) this.mData).w(((PostData) this.mData).zI() + 1);
            ((PostData) this.mData).cw(5);
            i = 0;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public int L(View view) {
        int L = super.L(view);
        bi(L == 0);
        return L;
    }

    @Override // com.baidu.tbadk.core.view.PostPraiseView
    public boolean Dz() {
        return this.mData != 0 && ((PostData) this.mData).zK() == 5;
    }
}
