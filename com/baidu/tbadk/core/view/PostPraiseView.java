package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awp = 1;
        if (this.awp == 2) {
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
        return ((PostData) this.mData).xy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.tbadkCore.data.PostData */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(PostData postData) {
        if (postData != 0) {
            if (postData.ayA()) {
                if (postData.xB() == 0 || postData.xB() == 1 || postData.xB() == 2) {
                    postData.cm(2);
                }
                if (postData.xB() == 3 || postData.xB() == 4 || postData.xB() == 5) {
                    postData.cm(5);
                }
            }
            this.mData = postData;
            this.mPostId = postData.getId();
            this.alZ = ((PostData) this.mData).xy();
            this.ama = ((PostData) this.mData).xz();
            Bp();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bp() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.awr);
        if (!com.baidu.tbadk.util.a.Mu().CM()) {
            string = "";
        }
        if (num > 0) {
            string = ao.L(num);
        }
        this.aww.setText(string);
        this.aww.setContentDescription(context.getString(this.awr) + num);
        if (this.mData != 0 && ((PostData) this.mData).ayA() && Bt()) {
            this.awx.setImageDrawable(createStateDrawable(this.awt, this.aws));
            this.aww.setTextColor(createColorStateList(this.awv, this.awu));
            return;
        }
        this.awx.setImageDrawable(createStateDrawable(this.aws, this.awt));
        this.aww.setTextColor(createColorStateList(this.awu, this.awv));
    }

    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).ayA() && Bt()) {
            ((PostData) this.mData).cm(2);
            ((PostData) this.mData).mR(false);
            ((PostData) this.mData).t(((PostData) this.mData).xy() - 1);
            ((PostData) this.mData).u(((PostData) this.mData).xz());
            i = 1;
        } else {
            if (((PostData) this.mData).ayA() && ((PostData) this.mData).xB() == 5) {
                ((PostData) this.mData).u(((PostData) this.mData).xz() - 1);
            }
            ((PostData) this.mData).mR(true);
            ((PostData) this.mData).t(((PostData) this.mData).xy() + 1);
            ((PostData) this.mData).cm(2);
            com.baidu.tieba.n.a.bpD().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.g.isFastDoubleClick() && ba.bA(getContext()) && this.mData != 0) {
            i = Bs();
            Bp();
            dn(i);
            m15do(i);
            if (this.avZ != null) {
                this.avZ.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016552, this.mData));
        }
        return i;
    }

    public boolean Bt() {
        return this.mData != 0 && (((PostData) this.mData).xB() == 2 || ((PostData) this.mData).xB() == 1);
    }
}
