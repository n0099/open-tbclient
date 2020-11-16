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
    private final int eVU;
    private ThreadForumEnterButton eVV;
    private ThreadForumEnterButton eVW;
    private ThreadForumEnterButton eVX;
    private View eVY;
    private int eVZ;
    private int eWa;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eVU = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eVV = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eVW = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eVX = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eVY = findViewById(R.id.bottom_placeholder);
        this.eVZ = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.eVU) / 2;
        this.eWa = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.eVU * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eVY.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eVV != null) {
            this.eVV.onChangeSkinType();
        }
        if (this.eVW != null) {
            this.eVW.onChangeSkinType();
        }
        if (this.eVX != null) {
            this.eVX.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eVV != null) {
            this.eVV.setAfterClickListener(onClickListener);
        }
        if (this.eVW != null) {
            this.eVW.setAfterClickListener(onClickListener);
        }
        if (this.eVX != null) {
            this.eVX.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eVV != null) {
            this.eVV.setFrom(i);
        }
        if (this.eVW != null) {
            this.eVW.setFrom(i);
        }
        if (this.eVX != null) {
            this.eVX.setFrom(i);
        }
    }
}
