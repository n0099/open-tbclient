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
    private final int eQY;
    private ThreadForumEnterButton eQZ;
    private ThreadForumEnterButton eRa;
    private ThreadForumEnterButton eRb;
    private View eRc;
    private int eRd;
    private int eRe;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eQY = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eQZ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eRa = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eRb = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eRc = findViewById(R.id.bottom_placeholder);
        this.eRd = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.eQY) / 2;
        this.eRe = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.eQY * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eRc.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eQZ != null) {
            this.eQZ.onChangeSkinType();
        }
        if (this.eRa != null) {
            this.eRa.onChangeSkinType();
        }
        if (this.eRb != null) {
            this.eRb.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eQZ != null) {
            this.eQZ.setAfterClickListener(onClickListener);
        }
        if (this.eRa != null) {
            this.eRa.setAfterClickListener(onClickListener);
        }
        if (this.eRb != null) {
            this.eRb.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eQZ != null) {
            this.eQZ.setFrom(i);
        }
        if (this.eRa != null) {
            this.eRa.setFrom(i);
        }
        if (this.eRb != null) {
            this.eRb.setFrom(i);
        }
    }
}
