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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes3.dex */
public class PostPraiseView extends BasePraiseView<PostData> {
    private CustomMessageListener bRA;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRA = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).af(postData.aah());
                    ((PostData) PostPraiseView.this.mData).ag(postData.aai());
                    ((PostData) PostPraiseView.this.mData).pZ(postData.beU());
                    ((PostData) PostPraiseView.this.mData).gz(postData.aak());
                    PostPraiseView.this.GP();
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
        return ((PostData) this.mData).aah();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GP() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.bOh);
        if (!com.baidu.tbadk.util.a.apJ().afK()) {
        }
        if (num > 0) {
            string = ap.az(num);
        } else {
            string = getContext().getString(d.j.action_praise_default);
        }
        this.bOm.setText(string);
        this.bOm.setContentDescription(context.getString(this.bOh) + num);
        if (this.mData != 0 && ((PostData) this.mData).beU() && aeg()) {
            this.bOn.setImageDrawable(W(this.bOj, this.bOi));
            this.bOm.setTextColor(createColorStateList(this.bOl, this.bOk));
            return;
        }
        this.bOn.setImageDrawable(W(this.bOi, this.bOj));
        this.bOm.setTextColor(createColorStateList(this.bOk, this.bOl));
    }

    public int aef() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).beU() && aeg()) {
            ((PostData) this.mData).gz(2);
            ((PostData) this.mData).pZ(false);
            ((PostData) this.mData).af(((PostData) this.mData).aah() - 1);
            ((PostData) this.mData).ag(((PostData) this.mData).aai());
            i = 1;
        } else {
            if (((PostData) this.mData).beU() && ((PostData) this.mData).aak() == 5) {
                ((PostData) this.mData).ag(((PostData) this.mData).aai() - 1);
            }
            ((PostData) this.mData).pZ(true);
            ((PostData) this.mData).af(((PostData) this.mData).aah() + 1);
            ((PostData) this.mData).gz(2);
            com.baidu.tieba.n.a.bWn().x(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aF(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.cZ(getContext()) && this.mData != 0) {
            i = aef();
            GP();
            hD(i);
            hC(i);
            if (this.bNx != null) {
                this.bNx.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean aeg() {
        return this.mData != 0 && (((PostData) this.mData).aak() == 2 || ((PostData) this.mData).aak() == 1);
    }
}
