package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int cbW;
    private ThreadForumEnterButton cbX;
    private ThreadForumEnterButton cbY;
    private ThreadForumEnterButton cbZ;
    private int cca;
    private int ccb;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbW = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.cbX = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.cbY = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.cbZ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.cca = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.cbW) / 2;
        this.ccb = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.cbW * 2)) / 3;
    }

    public void y(bh bhVar) {
        if (bhVar != null && !aq.isEmpty(bhVar.aeD())) {
            if (this.cbX != null) {
                this.cbX.x(bhVar);
                setVisibility(0);
            }
            if (this.cbY != null) {
                this.cbY.setVisibility(8);
            }
            if (this.cbZ != null) {
                this.cbZ.setVisibility(8);
            }
        }
    }

    public void a(bh bhVar, List<bd> list) {
        if (bhVar != null) {
            if (list == null || list.size() <= 1) {
                y(bhVar);
            } else if (list.size() == 2) {
                if (this.cbX != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar2 = new bh();
                    bhVar2.setId(bhVar.getId());
                    bhVar2.mz(list.get(0).getForumName());
                    bhVar2.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.cbX.a(bhVar2, this.cca);
                }
                if (this.cbY != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar3 = new bh();
                    bhVar3.setId(bhVar.getId());
                    bhVar3.mz(list.get(1).getForumName());
                    bhVar3.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.cbY.a(bhVar3, this.cca);
                }
                if (this.cbZ != null) {
                    this.cbZ.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.cbX != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar4 = new bh();
                    bhVar4.setId(bhVar.getId());
                    bhVar4.mz(list.get(0).getForumName());
                    bhVar4.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.cbX.a(bhVar4, this.ccb);
                }
                if (this.cbY != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar5 = new bh();
                    bhVar5.setId(bhVar.getId());
                    bhVar5.mz(list.get(1).getForumName());
                    bhVar5.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.cbY.a(bhVar5, this.ccb);
                }
                if (this.cbZ != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bh bhVar6 = new bh();
                    bhVar6.setId(bhVar.getId());
                    bhVar6.mz(list.get(2).getForumName());
                    bhVar6.setFid(com.baidu.adp.lib.g.b.c(list.get(2).getForumId(), 0L));
                    this.cbZ.a(bhVar6, this.ccb);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cbX != null) {
            this.cbX.onChangeSkinType();
        }
        if (this.cbY != null) {
            this.cbY.onChangeSkinType();
        }
        if (this.cbZ != null) {
            this.cbZ.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.cbX != null) {
            this.cbX.setAfterClickListener(onClickListener);
        }
        if (this.cbY != null) {
            this.cbY.setAfterClickListener(onClickListener);
        }
        if (this.cbZ != null) {
            this.cbZ.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.cbX != null) {
            this.cbX.setFrom(i);
        }
        if (this.cbY != null) {
            this.cbY.setFrom(i);
        }
        if (this.cbZ != null) {
            this.cbZ.setFrom(i);
        }
    }
}
