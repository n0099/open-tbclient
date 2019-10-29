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
    private final int cre;
    private ThreadForumEnterButton crf;
    private ThreadForumEnterButton crg;
    private ThreadForumEnterButton crh;
    private int cri;
    private int crj;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cre = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.crf = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.crg = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.crh = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.cri = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.cre) / 2;
        this.crj = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.cre * 2)) / 3;
    }

    public void z(bh bhVar) {
        if (bhVar != null && !aq.isEmpty(bhVar.aiL())) {
            if (this.crf != null) {
                this.crf.y(bhVar);
                setVisibility(0);
            }
            if (this.crg != null) {
                this.crg.setVisibility(8);
            }
            if (this.crh != null) {
                this.crh.setVisibility(8);
            }
        }
    }

    public void a(bh bhVar, List<bd> list) {
        if (bhVar != null) {
            if (list == null || list.size() <= 1) {
                z(bhVar);
            } else if (list.size() == 2) {
                if (this.crf != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar2 = new bh();
                    bhVar2.setId(bhVar.getId());
                    bhVar2.mZ(list.get(0).getForumName());
                    bhVar2.setFid(com.baidu.adp.lib.g.b.toLong(list.get(0).getForumId(), 0L));
                    this.crf.a(bhVar2, this.cri);
                }
                if (this.crg != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar3 = new bh();
                    bhVar3.setId(bhVar.getId());
                    bhVar3.mZ(list.get(1).getForumName());
                    bhVar3.setFid(com.baidu.adp.lib.g.b.toLong(list.get(1).getForumId(), 0L));
                    this.crg.a(bhVar3, this.cri);
                }
                if (this.crh != null) {
                    this.crh.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.crf != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar4 = new bh();
                    bhVar4.setId(bhVar.getId());
                    bhVar4.mZ(list.get(0).getForumName());
                    bhVar4.setFid(com.baidu.adp.lib.g.b.toLong(list.get(0).getForumId(), 0L));
                    this.crf.a(bhVar4, this.crj);
                }
                if (this.crg != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar5 = new bh();
                    bhVar5.setId(bhVar.getId());
                    bhVar5.mZ(list.get(1).getForumName());
                    bhVar5.setFid(com.baidu.adp.lib.g.b.toLong(list.get(1).getForumId(), 0L));
                    this.crg.a(bhVar5, this.crj);
                }
                if (this.crh != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bh bhVar6 = new bh();
                    bhVar6.setId(bhVar.getId());
                    bhVar6.mZ(list.get(2).getForumName());
                    bhVar6.setFid(com.baidu.adp.lib.g.b.toLong(list.get(2).getForumId(), 0L));
                    this.crh.a(bhVar6, this.crj);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.crf != null) {
            this.crf.onChangeSkinType();
        }
        if (this.crg != null) {
            this.crg.onChangeSkinType();
        }
        if (this.crh != null) {
            this.crh.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.crf != null) {
            this.crf.setAfterClickListener(onClickListener);
        }
        if (this.crg != null) {
            this.crg.setAfterClickListener(onClickListener);
        }
        if (this.crh != null) {
            this.crh.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.crf != null) {
            this.crf.setFrom(i);
        }
        if (this.crg != null) {
            this.crg.setFrom(i);
        }
        if (this.crh != null) {
            this.crh.setFrom(i);
        }
    }
}
