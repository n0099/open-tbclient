package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBP = 1;
        if (this.aBP == 2) {
            setDisPraiseFrom(9);
        } else {
            setDisPraiseFrom(8);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((PostData) this.mData).zO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.tbadkCore.data.PostData */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(PostData postData) {
        if (postData != 0) {
            if (postData.aBr()) {
                if (postData.zR() == 0 || postData.zR() == 1 || postData.zR() == 2) {
                    postData.cK(2);
                }
                if (postData.zR() == 3 || postData.zR() == 4 || postData.zR() == 5) {
                    postData.cK(5);
                }
            }
            this.mData = postData;
            this.mPostId = postData.getId();
            this.arH = ((PostData) this.mData).zO();
            this.arI = ((PostData) this.mData).zP();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBR);
        if (!com.baidu.tbadk.util.a.OB().Fb()) {
            string = "";
        }
        if (num > 0) {
            string = ao.P(num);
        }
        this.aBW.setText(string);
        this.aBW.setContentDescription(context.getString(this.aBR) + num);
        if (this.mData != 0 && ((PostData) this.mData).aBr() && DG()) {
            this.aBX.setImageDrawable(createStateDrawable(this.aBT, this.aBS));
            this.aBW.setTextColor(createColorStateList(this.aBV, this.aBU));
            return;
        }
        this.aBX.setImageDrawable(createStateDrawable(this.aBS, this.aBT));
        this.aBW.setTextColor(createColorStateList(this.aBU, this.aBV));
    }

    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aBr() && DG()) {
            ((PostData) this.mData).cK(2);
            ((PostData) this.mData).nt(false);
            ((PostData) this.mData).x(((PostData) this.mData).zO() - 1);
            ((PostData) this.mData).y(((PostData) this.mData).zP());
            i = 1;
        } else {
            if (((PostData) this.mData).aBr() && ((PostData) this.mData).zR() == 5) {
                ((PostData) this.mData).y(((PostData) this.mData).zP() - 1);
            }
            ((PostData) this.mData).nt(true);
            ((PostData) this.mData).x(((PostData) this.mData).zO() + 1);
            ((PostData) this.mData).cK(2);
            com.baidu.tieba.n.a.bso().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.g.isFastDoubleClick() && ba.bG(getContext()) && this.mData != 0) {
            i = DF();
            updateUI();
            dL(i);
            dM(i);
            if (this.aBz != null) {
                this.aBz.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean DG() {
        return this.mData != 0 && (((PostData) this.mData).zR() == 2 || ((PostData) this.mData).zR() == 1);
    }
}
