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
    private CustomMessageListener cbt;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbt = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).as(postData.afV());
                    ((PostData) PostPraiseView.this.mData).at(postData.afW());
                    ((PostData) PostPraiseView.this.mData).ri(postData.bpo());
                    ((PostData) PostPraiseView.this.mData).hs(postData.afY());
                    PostPraiseView.this.JW();
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
        return ((PostData) this.mData).afV();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void JW() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.bXX);
        if (!com.baidu.tbadk.util.a.awk().amc()) {
        }
        if (num > 0) {
            string = aq.aO(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.bYc.setText(string);
        this.bYc.setContentDescription(context.getString(this.bXX) + num);
        if (this.mData != 0 && ((PostData) this.mData).bpo() && akx()) {
            this.bYd.setImageDrawable(Z(this.bXZ, this.bXY));
            this.bYc.setTextColor(createColorStateList(this.bYb, this.bYa));
            return;
        }
        this.bYd.setImageDrawable(Z(this.bXY, this.bXZ));
        this.bYc.setTextColor(createColorStateList(this.bYa, this.bYb));
    }

    public int akw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bpo() && akx()) {
            ((PostData) this.mData).hs(2);
            ((PostData) this.mData).ri(false);
            ((PostData) this.mData).as(((PostData) this.mData).afV() - 1);
            ((PostData) this.mData).at(((PostData) this.mData).afW());
            i = 1;
        } else {
            if (((PostData) this.mData).bpo() && ((PostData) this.mData).afY() == 5) {
                ((PostData) this.mData).at(((PostData) this.mData).afW() - 1);
            }
            ((PostData) this.mData).ri(true);
            ((PostData) this.mData).as(((PostData) this.mData).afV() + 1);
            ((PostData) this.mData).hs(2);
            com.baidu.tieba.n.a.cir().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aN(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.cF(getContext()) && this.mData != 0) {
            i = akw();
            JW();
            iA(i);
            iz(i);
            if (this.bXj != null) {
                this.bXj.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean akx() {
        return this.mData != 0 && (((PostData) this.mData).afY() == 2 || ((PostData) this.mData).afY() == 1);
    }
}
