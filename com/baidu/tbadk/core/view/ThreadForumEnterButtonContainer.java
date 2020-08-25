package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int euk;
    private ThreadForumEnterButton eul;
    private ThreadForumEnterButton eum;
    private ThreadForumEnterButton eun;
    private View euo;
    private int eup;
    private int euq;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.euk = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eul = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eum = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eun = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.euo = findViewById(R.id.bottom_placeholder);
        this.eup = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.euk) / 2;
        this.euq = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.euk * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.euo.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.eul != null) {
            this.eul.onChangeSkinType();
        }
        if (this.eum != null) {
            this.eum.onChangeSkinType();
        }
        if (this.eun != null) {
            this.eun.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eul != null) {
            this.eul.setAfterClickListener(onClickListener);
        }
        if (this.eum != null) {
            this.eum.setAfterClickListener(onClickListener);
        }
        if (this.eun != null) {
            this.eun.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eul != null) {
            this.eul.setFrom(i);
        }
        if (this.eum != null) {
            this.eum.setFrom(i);
        }
        if (this.eun != null) {
            this.eun.setFrom(i);
        }
    }
}
