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
    private final int ews;
    private ThreadForumEnterButton ewt;
    private ThreadForumEnterButton ewu;
    private ThreadForumEnterButton ewv;
    private View eww;
    private int ewx;
    private int ewy;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ews = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.ewt = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.ewu = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.ewv = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eww = findViewById(R.id.bottom_placeholder);
        this.ewx = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.ews) / 2;
        this.ewy = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.ews * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eww.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.ewt != null) {
            this.ewt.onChangeSkinType();
        }
        if (this.ewu != null) {
            this.ewu.onChangeSkinType();
        }
        if (this.ewv != null) {
            this.ewv.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.ewt != null) {
            this.ewt.setAfterClickListener(onClickListener);
        }
        if (this.ewu != null) {
            this.ewu.setAfterClickListener(onClickListener);
        }
        if (this.ewv != null) {
            this.ewv.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.ewt != null) {
            this.ewt.setFrom(i);
        }
        if (this.ewu != null) {
            this.ewu.setFrom(i);
        }
        if (this.ewv != null) {
            this.ewv.setFrom(i);
        }
    }
}
