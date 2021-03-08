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
    private final int fmh;
    private ThreadForumEnterButton fmi;
    private ThreadForumEnterButton fmj;
    private ThreadForumEnterButton fmk;
    private View fml;
    private int fmm;
    private int fmn;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmh = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.fmi = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.fmj = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.fmk = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.fml = findViewById(R.id.bottom_placeholder);
        this.fmm = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.fmh) / 2;
        this.fmn = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.fmh * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.fml.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.fmi != null) {
            this.fmi.onChangeSkinType();
        }
        if (this.fmj != null) {
            this.fmj.onChangeSkinType();
        }
        if (this.fmk != null) {
            this.fmk.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.fmi != null) {
            this.fmi.setAfterClickListener(onClickListener);
        }
        if (this.fmj != null) {
            this.fmj.setAfterClickListener(onClickListener);
        }
        if (this.fmk != null) {
            this.fmk.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.fmi != null) {
            this.fmi.setFrom(i);
        }
        if (this.fmj != null) {
            this.fmj.setFrom(i);
        }
        if (this.fmk != null) {
            this.fmk.setFrom(i);
        }
    }
}
