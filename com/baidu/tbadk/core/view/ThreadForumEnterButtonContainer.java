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
    private final int ekp;
    private ThreadForumEnterButton ekq;
    private ThreadForumEnterButton ekr;
    private ThreadForumEnterButton eks;
    private View ekt;
    private int eku;
    private int ekv;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ekp = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.ekq = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.ekr = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eks = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.ekt = findViewById(R.id.bottom_placeholder);
        this.eku = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.ekp) / 2;
        this.ekv = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.ekp * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.ekt.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.ekq != null) {
            this.ekq.onChangeSkinType();
        }
        if (this.ekr != null) {
            this.ekr.onChangeSkinType();
        }
        if (this.eks != null) {
            this.eks.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.ekq != null) {
            this.ekq.setAfterClickListener(onClickListener);
        }
        if (this.ekr != null) {
            this.ekr.setAfterClickListener(onClickListener);
        }
        if (this.eks != null) {
            this.eks.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.ekq != null) {
            this.ekq.setFrom(i);
        }
        if (this.ekr != null) {
            this.ekr.setFrom(i);
        }
        if (this.eks != null) {
            this.eks.setFrom(i);
        }
    }
}
