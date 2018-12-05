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
        this.aFp = 1;
        if (this.aFp == 2) {
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
        return ((PostData) this.mData).AS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.tbadkCore.data.PostData */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(PostData postData) {
        if (postData != 0) {
            if (postData.aDb()) {
                if (postData.AV() == 0 || postData.AV() == 1 || postData.AV() == 2) {
                    postData.cY(2);
                }
                if (postData.AV() == 3 || postData.AV() == 4 || postData.AV() == 5) {
                    postData.cY(5);
                }
            }
            this.mData = postData;
            this.mPostId = postData.getId();
            this.avh = ((PostData) this.mData).AS();
            this.avi = ((PostData) this.mData).AT();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFr);
        if (!com.baidu.tbadk.util.a.PH().Gf()) {
            string = "";
        }
        if (num > 0) {
            string = ao.W(num);
        }
        this.aFw.setText(string);
        this.aFw.setContentDescription(context.getString(this.aFr) + num);
        if (this.mData != 0 && ((PostData) this.mData).aDb() && EK()) {
            this.aFx.setImageDrawable(createStateDrawable(this.aFt, this.aFs));
            this.aFw.setTextColor(createColorStateList(this.aFv, this.aFu));
            return;
        }
        this.aFx.setImageDrawable(createStateDrawable(this.aFs, this.aFt));
        this.aFw.setTextColor(createColorStateList(this.aFu, this.aFv));
    }

    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aDb() && EK()) {
            ((PostData) this.mData).cY(2);
            ((PostData) this.mData).nv(false);
            ((PostData) this.mData).C(((PostData) this.mData).AS() - 1);
            ((PostData) this.mData).D(((PostData) this.mData).AT());
            i = 1;
        } else {
            if (((PostData) this.mData).aDb() && ((PostData) this.mData).AV() == 5) {
                ((PostData) this.mData).D(((PostData) this.mData).AT() - 1);
            }
            ((PostData) this.mData).nv(true);
            ((PostData) this.mData).C(((PostData) this.mData).AS() + 1);
            ((PostData) this.mData).cY(2);
            com.baidu.tieba.n.a.buh().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.g.isFastDoubleClick() && ba.bJ(getContext()) && this.mData != 0) {
            i = EJ();
            updateUI();
            dZ(i);
            ea(i);
            if (this.aEZ != null) {
                this.aEZ.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean EK() {
        return this.mData != 0 && (((PostData) this.mData).AV() == 2 || ((PostData) this.mData).AV() == 1);
    }
}
