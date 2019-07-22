package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    private CustomMessageListener cau;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cau = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).as(postData.afQ());
                    ((PostData) PostPraiseView.this.mData).at(postData.afR());
                    ((PostData) PostPraiseView.this.mData).re(postData.boq());
                    ((PostData) PostPraiseView.this.mData).hr(postData.afT());
                    PostPraiseView.this.JS();
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
        return ((PostData) this.mData).afQ();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JS() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.bWY);
        if (!com.baidu.tbadk.util.a.avW().alO()) {
        }
        if (num > 0) {
            string = aq.aO(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.bXd.setText(string);
        this.bXd.setContentDescription(context.getString(this.bWY) + num);
        if (this.mData != 0 && ((PostData) this.mData).boq() && akj()) {
            this.bXe.setImageDrawable(Z(this.bXa, this.bWZ));
            this.bXd.setTextColor(createColorStateList(this.bXc, this.bXb));
            return;
        }
        this.bXe.setImageDrawable(Z(this.bWZ, this.bXa));
        this.bXd.setTextColor(createColorStateList(this.bXb, this.bXc));
    }

    public int aki() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).boq() && akj()) {
            ((PostData) this.mData).hr(2);
            ((PostData) this.mData).re(false);
            ((PostData) this.mData).as(((PostData) this.mData).afQ() - 1);
            ((PostData) this.mData).at(((PostData) this.mData).afR());
            i = 1;
        } else {
            if (((PostData) this.mData).boq() && ((PostData) this.mData).afT() == 5) {
                ((PostData) this.mData).at(((PostData) this.mData).afR() - 1);
            }
            ((PostData) this.mData).re(true);
            ((PostData) this.mData).as(((PostData) this.mData).afQ() + 1);
            ((PostData) this.mData).hr(2);
            com.baidu.tieba.n.a.chl().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aN(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bd.cF(getContext()) && this.mData != 0) {
            i = aki();
            JS();
            ix(i);
            iw(i);
            if (this.bWk != null) {
                this.bWk.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean akj() {
        return this.mData != 0 && (((PostData) this.mData).afT() == 2 || ((PostData) this.mData).afT() == 1);
    }
}
