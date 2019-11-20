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
    private CustomMessageListener coT;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coT = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).aK(postData.ajW());
                    ((PostData) PostPraiseView.this.mData).aL(postData.ajX());
                    ((PostData) PostPraiseView.this.mData).qR(postData.bmr());
                    ((PostData) PostPraiseView.this.mData).hQ(postData.ajZ());
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
        return ((PostData) this.mData).ajW();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.textResId);
        if (!com.baidu.tbadk.util.a.axn().aoN()) {
        }
        if (num > 0) {
            string = aq.numFormatOverWan(num);
        } else {
            string = getContext().getString(R.string.action_praise_default);
        }
        this.cmo.setText(string);
        this.cmo.setContentDescription(context.getString(this.textResId) + num);
        if (this.mData != 0 && ((PostData) this.mData).bmr() && anx()) {
            this.cmp.setImageDrawable(ab(this.cml, this.drawableResId));
            this.cmo.setTextColor(createColorStateList(this.cmn, this.cmm));
            return;
        }
        this.cmp.setImageDrawable(ab(this.drawableResId, this.cml));
        this.cmo.setTextColor(createColorStateList(this.cmm, this.cmn));
    }

    public int anw() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).bmr() && anx()) {
            ((PostData) this.mData).hQ(2);
            ((PostData) this.mData).qR(false);
            ((PostData) this.mData).aK(((PostData) this.mData).ajW() - 1);
            ((PostData) this.mData).aL(((PostData) this.mData).ajX());
            i = 1;
        } else {
            if (((PostData) this.mData).bmr() && ((PostData) this.mData).ajZ() == 5) {
                ((PostData) this.mData).aL(((PostData) this.mData).ajX() - 1);
            }
            ((PostData) this.mData).qR(true);
            ((PostData) this.mData).aK(((PostData) this.mData).ajW() + 1);
            ((PostData) this.mData).hQ(2);
            com.baidu.tieba.n.a.cfn().z(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aO(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.checkUpIsLogin(getContext()) && this.mData != 0) {
            i = anw();
            updateUI();
            iy(i);
            ix(i);
            if (this.clw != null) {
                this.clw.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean anx() {
        return this.mData != 0 && (((PostData) this.mData).ajZ() == 2 || ((PostData) this.mData).ajZ() == 1);
    }
}
