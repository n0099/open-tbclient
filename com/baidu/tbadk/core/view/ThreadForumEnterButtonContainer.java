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
    private final int ccQ;
    private ThreadForumEnterButton ccR;
    private ThreadForumEnterButton ccS;
    private ThreadForumEnterButton ccT;
    private int ccU;
    private int ccV;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccQ = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.ccR = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.ccS = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.ccT = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.ccU = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.ccQ) / 2;
        this.ccV = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.ccQ * 2)) / 3;
    }

    public void z(bh bhVar) {
        if (bhVar != null && !aq.isEmpty(bhVar.aeH())) {
            if (this.ccR != null) {
                this.ccR.y(bhVar);
                setVisibility(0);
            }
            if (this.ccS != null) {
                this.ccS.setVisibility(8);
            }
            if (this.ccT != null) {
                this.ccT.setVisibility(8);
            }
        }
    }

    public void a(bh bhVar, List<bd> list) {
        if (bhVar != null) {
            if (list == null || list.size() <= 1) {
                z(bhVar);
            } else if (list.size() == 2) {
                if (this.ccR != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar2 = new bh();
                    bhVar2.setId(bhVar.getId());
                    bhVar2.mB(list.get(0).getForumName());
                    bhVar2.setFid(com.baidu.adp.lib.g.b.e(list.get(0).getForumId(), 0L));
                    this.ccR.a(bhVar2, this.ccU);
                }
                if (this.ccS != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar3 = new bh();
                    bhVar3.setId(bhVar.getId());
                    bhVar3.mB(list.get(1).getForumName());
                    bhVar3.setFid(com.baidu.adp.lib.g.b.e(list.get(1).getForumId(), 0L));
                    this.ccS.a(bhVar3, this.ccU);
                }
                if (this.ccT != null) {
                    this.ccT.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.ccR != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bh bhVar4 = new bh();
                    bhVar4.setId(bhVar.getId());
                    bhVar4.mB(list.get(0).getForumName());
                    bhVar4.setFid(com.baidu.adp.lib.g.b.e(list.get(0).getForumId(), 0L));
                    this.ccR.a(bhVar4, this.ccV);
                }
                if (this.ccS != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bh bhVar5 = new bh();
                    bhVar5.setId(bhVar.getId());
                    bhVar5.mB(list.get(1).getForumName());
                    bhVar5.setFid(com.baidu.adp.lib.g.b.e(list.get(1).getForumId(), 0L));
                    this.ccS.a(bhVar5, this.ccV);
                }
                if (this.ccT != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bh bhVar6 = new bh();
                    bhVar6.setId(bhVar.getId());
                    bhVar6.mB(list.get(2).getForumName());
                    bhVar6.setFid(com.baidu.adp.lib.g.b.e(list.get(2).getForumId(), 0L));
                    this.ccT.a(bhVar6, this.ccV);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ccR != null) {
            this.ccR.onChangeSkinType();
        }
        if (this.ccS != null) {
            this.ccS.onChangeSkinType();
        }
        if (this.ccT != null) {
            this.ccT.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.ccR != null) {
            this.ccR.setAfterClickListener(onClickListener);
        }
        if (this.ccS != null) {
            this.ccS.setAfterClickListener(onClickListener);
        }
        if (this.ccT != null) {
            this.ccT.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.ccR != null) {
            this.ccR.setFrom(i);
        }
        if (this.ccS != null) {
            this.ccS.setFrom(i);
        }
        if (this.ccT != null) {
            this.ccT.setFrom(i);
        }
    }
}
