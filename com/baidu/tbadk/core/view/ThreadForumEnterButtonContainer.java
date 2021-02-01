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
    private final int fkI;
    private ThreadForumEnterButton fkJ;
    private ThreadForumEnterButton fkK;
    private ThreadForumEnterButton fkL;
    private View fkM;
    private int fkN;
    private int fkO;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fkI = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.fkJ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.fkK = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.fkL = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.fkM = findViewById(R.id.bottom_placeholder);
        this.fkN = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.fkI) / 2;
        this.fkO = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.fkI * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.fkM.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.fkJ != null) {
            this.fkJ.onChangeSkinType();
        }
        if (this.fkK != null) {
            this.fkK.onChangeSkinType();
        }
        if (this.fkL != null) {
            this.fkL.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.fkJ != null) {
            this.fkJ.setAfterClickListener(onClickListener);
        }
        if (this.fkK != null) {
            this.fkK.setAfterClickListener(onClickListener);
        }
        if (this.fkL != null) {
            this.fkL.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.fkJ != null) {
            this.fkJ.setFrom(i);
        }
        if (this.fkK != null) {
            this.fkK.setFrom(i);
        }
        if (this.fkL != null) {
            this.fkL.setFrom(i);
        }
    }
}
