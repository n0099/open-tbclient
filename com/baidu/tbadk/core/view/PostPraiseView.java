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
        this.aBa = 1;
        if (this.aBa == 2) {
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
        return ((PostData) this.mData).zH();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.tbadkCore.data.PostData */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(PostData postData) {
        if (postData != 0) {
            if (postData.aBU()) {
                if (postData.zK() == 0 || postData.zK() == 1 || postData.zK() == 2) {
                    postData.cw(2);
                }
                if (postData.zK() == 3 || postData.zK() == 4 || postData.zK() == 5) {
                    postData.cw(5);
                }
            }
            this.mData = postData;
            this.mPostId = postData.getId();
            this.aqU = ((PostData) this.mData).zH();
            this.aqV = ((PostData) this.mData).zI();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBc);
        if (!com.baidu.tbadk.util.a.Os().EQ()) {
            string = "";
        }
        if (num > 0) {
            string = ao.N(num);
        }
        this.aBh.setText(string);
        this.aBh.setContentDescription(context.getString(this.aBc) + num);
        if (this.mData != 0 && ((PostData) this.mData).aBU() && Dz()) {
            this.aBi.setImageDrawable(createStateDrawable(this.aBe, this.aBd));
            this.aBh.setTextColor(createColorStateList(this.aBg, this.aBf));
            return;
        }
        this.aBi.setImageDrawable(createStateDrawable(this.aBd, this.aBe));
        this.aBh.setTextColor(createColorStateList(this.aBf, this.aBg));
    }

    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).aBU() && Dz()) {
            ((PostData) this.mData).cw(2);
            ((PostData) this.mData).ni(false);
            ((PostData) this.mData).v(((PostData) this.mData).zH() - 1);
            ((PostData) this.mData).w(((PostData) this.mData).zI());
            i = 1;
        } else {
            if (((PostData) this.mData).aBU() && ((PostData) this.mData).zK() == 5) {
                ((PostData) this.mData).w(((PostData) this.mData).zI() - 1);
            }
            ((PostData) this.mData).ni(true);
            ((PostData) this.mData).v(((PostData) this.mData).zH() + 1);
            ((PostData) this.mData).cw(2);
            com.baidu.tieba.n.a.bsS().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.g.isFastDoubleClick() && ba.bI(getContext()) && this.mData != 0) {
            i = Dy();
            updateUI();
            dx(i);
            dy(i);
            if (this.aAK != null) {
                this.aAK.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean Dz() {
        return this.mData != 0 && (((PostData) this.mData).zK() == 2 || ((PostData) this.mData).zK() == 1);
    }
}
