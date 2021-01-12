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
    private final int fiq;
    private ThreadForumEnterButton fir;
    private ThreadForumEnterButton fis;
    private ThreadForumEnterButton fit;
    private View fiu;
    private int fiv;
    private int fiw;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fiq = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.fir = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.fis = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.fit = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.fiu = findViewById(R.id.bottom_placeholder);
        this.fiv = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.fiq) / 2;
        this.fiw = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.fiq * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.fiu.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.fir != null) {
            this.fir.onChangeSkinType();
        }
        if (this.fis != null) {
            this.fis.onChangeSkinType();
        }
        if (this.fit != null) {
            this.fit.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.fir != null) {
            this.fir.setAfterClickListener(onClickListener);
        }
        if (this.fis != null) {
            this.fis.setAfterClickListener(onClickListener);
        }
        if (this.fit != null) {
            this.fit.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.fir != null) {
            this.fir.setFrom(i);
        }
        if (this.fis != null) {
            this.fis.setFrom(i);
        }
        if (this.fit != null) {
            this.fit.setFrom(i);
        }
    }
}
