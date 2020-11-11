package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int eWN;
    private ThreadForumEnterButton eWO;
    private ThreadForumEnterButton eWP;
    private ThreadForumEnterButton eWQ;
    private View eWR;
    private int eWS;
    private int eWT;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWN = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eWO = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eWP = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eWQ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eWR = findViewById(R.id.bottom_placeholder);
        this.eWS = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.eWN) / 2;
        this.eWT = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.eWN * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eWR.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eWO != null) {
            this.eWO.onChangeSkinType();
        }
        if (this.eWP != null) {
            this.eWP.onChangeSkinType();
        }
        if (this.eWQ != null) {
            this.eWQ.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eWO != null) {
            this.eWO.setAfterClickListener(onClickListener);
        }
        if (this.eWP != null) {
            this.eWP.setAfterClickListener(onClickListener);
        }
        if (this.eWQ != null) {
            this.eWQ.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eWO != null) {
            this.eWO.setFrom(i);
        }
        if (this.eWP != null) {
            this.eWP.setFrom(i);
        }
        if (this.eWQ != null) {
            this.eWQ.setFrom(i);
        }
    }
}
