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
    private final int cqm;
    private ThreadForumEnterButton cqn;
    private ThreadForumEnterButton cqo;
    private ThreadForumEnterButton cqp;
    private int cqq;
    private int cqr;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqm = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.cqn = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.cqo = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.cqp = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.cqq = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.cqm) / 2;
        this.cqr = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.cqm * 2)) / 3;
    }

    public void z(bh bhVar) {
        if (bhVar != null && !aq.isEmpty(bhVar.aiJ())) {
            if (this.cqn != null) {
                this.cqn.y(bhVar);
                setVisibility(0);
            }
            if (this.cqo != null) {
                this.cqo.setVisibility(8);
            }
            if (this.cqp != null) {
                this.cqp.setVisibility(8);
            }
        }
    }

    public void a(bh bhVar, List<bd> list) {
        if (bhVar != null) {
            if (list == null || list.size() <= 1) {
                z(bhVar);
            } else if (list.size() == 2) {
                if (this.cqn != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar2 = new bh();
                    bhVar2.setId(bhVar.getId());
                    bhVar2.mZ(list.get(0).getForumName());
                    bhVar2.setFid(com.baidu.adp.lib.g.b.toLong(list.get(0).getForumId(), 0L));
                    this.cqn.a(bhVar2, this.cqq);
                }
                if (this.cqo != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar3 = new bh();
                    bhVar3.setId(bhVar.getId());
                    bhVar3.mZ(list.get(1).getForumName());
                    bhVar3.setFid(com.baidu.adp.lib.g.b.toLong(list.get(1).getForumId(), 0L));
                    this.cqo.a(bhVar3, this.cqq);
                }
                if (this.cqp != null) {
                    this.cqp.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.cqn != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar4 = new bh();
                    bhVar4.setId(bhVar.getId());
                    bhVar4.mZ(list.get(0).getForumName());
                    bhVar4.setFid(com.baidu.adp.lib.g.b.toLong(list.get(0).getForumId(), 0L));
                    this.cqn.a(bhVar4, this.cqr);
                }
                if (this.cqo != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar5 = new bh();
                    bhVar5.setId(bhVar.getId());
                    bhVar5.mZ(list.get(1).getForumName());
                    bhVar5.setFid(com.baidu.adp.lib.g.b.toLong(list.get(1).getForumId(), 0L));
                    this.cqo.a(bhVar5, this.cqr);
                }
                if (this.cqp != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bh bhVar6 = new bh();
                    bhVar6.setId(bhVar.getId());
                    bhVar6.mZ(list.get(2).getForumName());
                    bhVar6.setFid(com.baidu.adp.lib.g.b.toLong(list.get(2).getForumId(), 0L));
                    this.cqp.a(bhVar6, this.cqr);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cqn != null) {
            this.cqn.onChangeSkinType();
        }
        if (this.cqo != null) {
            this.cqo.onChangeSkinType();
        }
        if (this.cqp != null) {
            this.cqp.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.cqn != null) {
            this.cqn.setAfterClickListener(onClickListener);
        }
        if (this.cqo != null) {
            this.cqo.setAfterClickListener(onClickListener);
        }
        if (this.cqp != null) {
            this.cqp.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.cqn != null) {
            this.cqn.setFrom(i);
        }
        if (this.cqo != null) {
            this.cqo.setFrom(i);
        }
        if (this.cqp != null) {
            this.cqp.setFrom(i);
        }
    }
}
