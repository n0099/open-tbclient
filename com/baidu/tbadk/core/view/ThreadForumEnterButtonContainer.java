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
    private final int fdr;
    private ThreadForumEnterButton fds;
    private ThreadForumEnterButton fdt;
    private ThreadForumEnterButton fdu;
    private View fdv;
    private int fdw;
    private int fdx;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fdr = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.fds = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.fdt = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.fdu = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.fdv = findViewById(R.id.bottom_placeholder);
        this.fdw = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.fdr) / 2;
        this.fdx = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.fdr * 2)) / 3;
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.fdv.setVisibility(z ? 0 : 8);
    }

    public void onChangeSkinType() {
        if (this.fds != null) {
            this.fds.onChangeSkinType();
        }
        if (this.fdt != null) {
            this.fdt.onChangeSkinType();
        }
        if (this.fdu != null) {
            this.fdu.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.fds != null) {
            this.fds.setAfterClickListener(onClickListener);
        }
        if (this.fdt != null) {
            this.fdt.setAfterClickListener(onClickListener);
        }
        if (this.fdu != null) {
            this.fdu.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.fds != null) {
            this.fds.setFrom(i);
        }
        if (this.fdt != null) {
            this.fdt.setFrom(i);
        }
        if (this.fdu != null) {
            this.fdu.setFrom(i);
        }
    }
}
