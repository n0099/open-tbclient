package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    private CustomMessageListener bZr;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZr = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).ar(postData.aeO());
                    ((PostData) PostPraiseView.this.mData).as(postData.aeP());
                    ((PostData) PostPraiseView.this.mData).qO(postData.bmm());
                    ((PostData) PostPraiseView.this.mData).hl(postData.aeR());
                    PostPraiseView.this.Jf();
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
        return ((PostData) this.mData).aeO();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Jf() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.bVV);
        if (!com.baidu.tbadk.util.a.auN().akJ()) {
        }
        if (num > 0) {
            string = ap.aN(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.bWa.setText(string);
        this.bWa.setContentDescription(context.getString(this.bVV) + num);
        if (this.mData != 0 && ((PostData) this.mData).bmm() && ajf()) {
            this.bWb.setImageDrawable(W(this.bVX, this.bVW));
            this.bWa.setTextColor(createColorStateList(this.bVZ, this.bVY));
            return;
        }
        this.bWb.setImageDrawable(W(this.bVW, this.bVX));
        this.bWa.setTextColor(createColorStateList(this.bVY, this.bVZ));
    }

    public int aje() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmm() && ajf()) {
            ((PostData) this.mData).hl(2);
            ((PostData) this.mData).qO(false);
            ((PostData) this.mData).ar(((PostData) this.mData).aeO() - 1);
            ((PostData) this.mData).as(((PostData) this.mData).aeP());
            i = 1;
        } else {
            if (((PostData) this.mData).bmm() && ((PostData) this.mData).aeR() == 5) {
                ((PostData) this.mData).as(((PostData) this.mData).aeP() - 1);
            }
            ((PostData) this.mData).qO(true);
            ((PostData) this.mData).ar(((PostData) this.mData).aeO() + 1);
            ((PostData) this.mData).hl(2);
            com.baidu.tieba.n.a.cer().x(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aL(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.cE(getContext()) && this.mData != 0) {
            i = aje();
            Jf();
            ir(i);
            iq(i);
            if (this.bVi != null) {
                this.bVi.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean ajf() {
        return this.mData != 0 && (((PostData) this.mData).aeR() == 2 || ((PostData) this.mData).aeR() == 1);
    }
}
