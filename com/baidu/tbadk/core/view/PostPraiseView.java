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
    private CustomMessageListener bRw;
    private Context mContext;

    public PostPraiseView(Context context) {
        this(context, null);
    }

    public PostPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRw = new CustomMessageListener(2016529) { // from class: com.baidu.tbadk.core.view.PostPraiseView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                PostData postData;
                if ((customResponsedMessage.getData() instanceof PostData) && PostPraiseView.this.mData != 0 && !TextUtils.isEmpty(((PostData) PostPraiseView.this.mData).getId()) && (postData = (PostData) customResponsedMessage.getData()) != null && ((PostData) PostPraiseView.this.mData).getId().equals(postData.getId())) {
                    ((PostData) PostPraiseView.this.mData).af(postData.aak());
                    ((PostData) PostPraiseView.this.mData).ag(postData.aal());
                    ((PostData) PostPraiseView.this.mData).pZ(postData.beX());
                    ((PostData) PostPraiseView.this.mData).gA(postData.aan());
                    PostPraiseView.this.GR();
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
        return ((PostData) this.mData).aak();
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void GR() {
        String string;
        Context context = getContext();
        long num = getNum();
        context.getString(this.bOd);
        if (!com.baidu.tbadk.util.a.apN().afN()) {
        }
        if (num > 0) {
            string = ap.az(num);
        } else {
            string = getContext().getString(d.j.action_praise_default);
        }
        this.bOi.setText(string);
        this.bOi.setContentDescription(context.getString(this.bOd) + num);
        if (this.mData != 0 && ((PostData) this.mData).beX() && aej()) {
            this.bOj.setImageDrawable(W(this.bOf, this.bOe));
            this.bOi.setTextColor(createColorStateList(this.bOh, this.bOg));
            return;
        }
        this.bOj.setImageDrawable(W(this.bOe, this.bOf));
        this.bOi.setTextColor(createColorStateList(this.bOg, this.bOh));
    }

    public int aei() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((PostData) this.mData).beX() && aej()) {
            ((PostData) this.mData).gA(2);
            ((PostData) this.mData).pZ(false);
            ((PostData) this.mData).af(((PostData) this.mData).aak() - 1);
            ((PostData) this.mData).ag(((PostData) this.mData).aal());
            i = 1;
        } else {
            if (((PostData) this.mData).beX() && ((PostData) this.mData).aan() == 5) {
                ((PostData) this.mData).ag(((PostData) this.mData).aal() - 1);
            }
            ((PostData) this.mData).pZ(true);
            ((PostData) this.mData).af(((PostData) this.mData).aak() + 1);
            ((PostData) this.mData).gA(2);
            com.baidu.tieba.n.a.bWp().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int aF(View view) {
        int i = -1;
        if (!com.baidu.tbadk.util.i.isFastDoubleClick() && bc.cZ(getContext()) && this.mData != 0) {
            i = aei();
            GR();
            hE(i);
            hD(i);
            if (this.bNt != null) {
                this.bNt.onClick(view);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016529, this.mData));
        }
        return i;
    }

    public boolean aej() {
        return this.mData != 0 && (((PostData) this.mData).aan() == 2 || ((PostData) this.mData).aan() == 1);
    }
}
