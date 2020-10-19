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
    private final int eIC;
    private ThreadForumEnterButton eID;
    private ThreadForumEnterButton eIE;
    private ThreadForumEnterButton eIF;
    private View eIG;
    private int eIH;
    private int eII;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eIC = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eID = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eIE = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eIF = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eIG = findViewById(R.id.bottom_placeholder);
        this.eIH = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.eIC) / 2;
        this.eII = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.eIC * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eIG.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eID != null) {
            this.eID.onChangeSkinType();
        }
        if (this.eIE != null) {
            this.eIE.onChangeSkinType();
        }
        if (this.eIF != null) {
            this.eIF.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eID != null) {
            this.eID.setAfterClickListener(onClickListener);
        }
        if (this.eIE != null) {
            this.eIE.setAfterClickListener(onClickListener);
        }
        if (this.eIF != null) {
            this.eIF.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eID != null) {
            this.eID.setFrom(i);
        }
        if (this.eIE != null) {
            this.eIE.setFrom(i);
        }
        if (this.eIF != null) {
            this.eIF.setFrom(i);
        }
    }
}
