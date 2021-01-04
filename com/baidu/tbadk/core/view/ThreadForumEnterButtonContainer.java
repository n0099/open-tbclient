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
    private final int fna;
    private ThreadForumEnterButton fnb;
    private ThreadForumEnterButton fnc;
    private ThreadForumEnterButton fnd;
    private View fne;
    private int fnf;
    private int fng;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fna = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.fnb = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.fnc = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.fnd = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.fne = findViewById(R.id.bottom_placeholder);
        this.fnf = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.fna) / 2;
        this.fng = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.fna * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.fne.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.fnb != null) {
            this.fnb.onChangeSkinType();
        }
        if (this.fnc != null) {
            this.fnc.onChangeSkinType();
        }
        if (this.fnd != null) {
            this.fnd.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.fnb != null) {
            this.fnb.setAfterClickListener(onClickListener);
        }
        if (this.fnc != null) {
            this.fnc.setAfterClickListener(onClickListener);
        }
        if (this.fnd != null) {
            this.fnd.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.fnb != null) {
            this.fnb.setFrom(i);
        }
        if (this.fnc != null) {
            this.fnc.setFrom(i);
        }
        if (this.fnd != null) {
            this.fnd.setFrom(i);
        }
    }
}
