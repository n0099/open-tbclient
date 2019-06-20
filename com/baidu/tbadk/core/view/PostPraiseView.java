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
    private CustomMessageListener bZs;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZs = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).ar(postData.aeO());
                    ((PostData) PostPraiseView.this.mData).as(postData.aeP());
                    ((PostData) PostPraiseView.this.mData).qP(postData.bmp());
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
        context.getString(this.bVW);
        if (!com.baidu.tbadk.util.a.auN().akJ()) {
        }
        if (num > 0) {
            string = ap.aN(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.bWb.setText(string);
        this.bWb.setContentDescription(context.getString(this.bVW) + num);
        if (this.mData != 0 && ((PostData) this.mData).bmp() && ajf()) {
            this.bWc.setImageDrawable(W(this.bVY, this.bVX));
            this.bWb.setTextColor(createColorStateList(this.bWa, this.bVZ));
            return;
        }
        this.bWc.setImageDrawable(W(this.bVX, this.bVY));
        this.bWb.setTextColor(createColorStateList(this.bVZ, this.bWa));
    }

    public int aje() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmp() && ajf()) {
            ((PostData) this.mData).hl(2);
            ((PostData) this.mData).qP(false);
            ((PostData) this.mData).ar(((PostData) this.mData).aeO() - 1);
            ((PostData) this.mData).as(((PostData) this.mData).aeP());
            i = 1;
        } else {
            if (((PostData) this.mData).bmp() && ((PostData) this.mData).aeR() == 5) {
                ((PostData) this.mData).as(((PostData) this.mData).aeP() - 1);
            }
            ((PostData) this.mData).qP(true);
            ((PostData) this.mData).ar(((PostData) this.mData).aeO() + 1);
            ((PostData) this.mData).hl(2);
            com.baidu.tieba.n.a.ceu().x(getTbPageContext());
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
            if (this.bVj != null) {
                this.bVj.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean ajf() {
        return this.mData != 0 && (((PostData) this.mData).aeR() == 2 || ((PostData) this.mData).aeR() == 1);
    }
}
