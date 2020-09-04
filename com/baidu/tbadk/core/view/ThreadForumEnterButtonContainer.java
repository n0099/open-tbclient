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
    private final int euo;
    private ThreadForumEnterButton eup;
    private ThreadForumEnterButton euq;
    private ThreadForumEnterButton eur;
    private View eus;
    private int eut;
    private int euu;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euo = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eup = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.euq = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eur = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eus = findViewById(R.id.bottom_placeholder);
        this.eut = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.euo) / 2;
        this.euu = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.euo * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eus.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eup != null) {
            this.eup.onChangeSkinType();
        }
        if (this.euq != null) {
            this.euq.onChangeSkinType();
        }
        if (this.eur != null) {
            this.eur.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eup != null) {
            this.eup.setAfterClickListener(onClickListener);
        }
        if (this.euq != null) {
            this.euq.setAfterClickListener(onClickListener);
        }
        if (this.eur != null) {
            this.eur.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eup != null) {
            this.eup.setFrom(i);
        }
        if (this.euq != null) {
            this.euq.setFrom(i);
        }
        if (this.eur != null) {
            this.eur.setFrom(i);
        }
    }
}
