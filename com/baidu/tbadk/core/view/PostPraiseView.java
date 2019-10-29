package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    private CustomMessageListener cpL;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpL = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).aL(postData.ajY());
                    ((PostData) PostPraiseView.this.mData).aM(postData.ajZ());
                    ((PostData) PostPraiseView.this.mData).qR(postData.bmt());
                    ((PostData) PostPraiseView.this.mData).hR(postData.akb());
                    PostPraiseView.this.updateUI();
                }
            }
        };
        this.objType = 1;
        this.mContext = context;
        if (this.objType == 2) {
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
        return ((PostData) this.mData).ajY();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.textResId);
        if (!com.baidu.tbadk.util.a.axp().aoP()) {
        }
        if (num > 0) {
            string = aq.numFormatOverWan(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.cnf.setText(string);
        this.cnf.setContentDescription(context.getString(this.textResId) + num);
        if (this.mData != 0 && ((PostData) this.mData).bmt() && anz()) {
            this.cng.setImageDrawable(ad(this.cnc, this.drawableResId));
            this.cnf.setTextColor(createColorStateList(this.cne, this.cnd));
            return;
        }
        this.cng.setImageDrawable(ad(this.drawableResId, this.cnc));
        this.cnf.setTextColor(createColorStateList(this.cnd, this.cne));
    }

    public int any() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmt() && anz()) {
            ((PostData) this.mData).hR(2);
            ((PostData) this.mData).qR(false);
            ((PostData) this.mData).aL(((PostData) this.mData).ajY() - 1);
            ((PostData) this.mData).aM(((PostData) this.mData).ajZ());
            i = 1;
        } else {
            if (((PostData) this.mData).bmt() && ((PostData) this.mData).akb() == 5) {
                ((PostData) this.mData).aM(((PostData) this.mData).ajZ() - 1);
            }
            ((PostData) this.mData).qR(true);
            ((PostData) this.mData).aL(((PostData) this.mData).ajY() + 1);
            ((PostData) this.mData).hR(2);
            com.baidu.tieba.n.a.cfp().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aO(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.checkUpIsLogin(getContext()) && this.mData != 0) {
            i = any();
            updateUI();
            iz(i);
            iy(i);
            if (this.cmo != null) {
                this.cmo.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean anz() {
        return this.mData != 0 && (((PostData) this.mData).akb() == 2 || ((PostData) this.mData).akb() == 1);
    }
}
