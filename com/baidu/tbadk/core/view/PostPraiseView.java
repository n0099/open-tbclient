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
        this.aFT = 1;
        if (this.aFT == 2) {
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
        return ((PostData) this.mData).Bf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.tbadkCore.data.PostData */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(PostData postData) {
        if (postData != 0) {
            if (postData.aEn()) {
                if (postData.Bi() == 0 || postData.Bi() == 1 || postData.Bi() == 2) {
                    postData.cY(2);
                }
                if (postData.Bi() == 3 || postData.Bi() == 4 || postData.Bi() == 5) {
                    postData.cY(5);
                }
            }
            this.mData = postData;
            this.mPostId = postData.getId();
            this.avK = ((PostData) this.mData).Bf();
            this.avL = ((PostData) this.mData).Bg();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFV);
        if (!com.baidu.tbadk.util.a.Qb().Gt()) {
            string = "";
        }
        if (num > 0) {
            string = ao.X(num);
        }
        this.aGa.setText(string);
        this.aGa.setContentDescription(context.getString(this.aFV) + num);
        if (this.mData != 0 && ((PostData) this.mData).aEn() && EX()) {
            this.aGb.setImageDrawable(createStateDrawable(this.aFX, this.aFW));
            this.aGa.setTextColor(createColorStateList(this.aFZ, this.aFY));
            return;
        }
        this.aGb.setImageDrawable(createStateDrawable(this.aFW, this.aFX));
        this.aGa.setTextColor(createColorStateList(this.aFY, this.aFZ));
    }

    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aEn() && EX()) {
            ((PostData) this.mData).cY(2);
            ((PostData) this.mData).nz(false);
            ((PostData) this.mData).C(((PostData) this.mData).Bf() - 1);
            ((PostData) this.mData).D(((PostData) this.mData).Bg());
            i = 1;
        } else {
            if (((PostData) this.mData).aEn() && ((PostData) this.mData).Bi() == 5) {
                ((PostData) this.mData).D(((PostData) this.mData).Bg() - 1);
            }
            ((PostData) this.mData).nz(true);
            ((PostData) this.mData).C(((PostData) this.mData).Bf() + 1);
            ((PostData) this.mData).cY(2);
            com.baidu.tieba.n.a.bvB().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.g.isFastDoubleClick() && ba.bJ(getContext()) && this.mData != 0) {
            i = EW();
            updateUI();
            dZ(i);
            ea(i);
            if (this.aFD != null) {
                this.aFD.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean EX() {
        return this.mData != 0 && (((PostData) this.mData).Bi() == 2 || ((PostData) this.mData).Bi() == 1);
    }
}
