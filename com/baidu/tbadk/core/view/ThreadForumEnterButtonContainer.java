package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int cbP;
    private ThreadForumEnterButton cbQ;
    private ThreadForumEnterButton cbR;
    private ThreadForumEnterButton cbS;
    private int cbT;
    private int cbU;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbP = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.cbQ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.cbR = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.cbS = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.cbT = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.cbP) / 2;
        this.cbU = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.cbP * 2)) / 3;
    }

    public void x(bg bgVar) {
        if (bgVar != null && !aq.isEmpty(bgVar.aeC())) {
            if (this.cbQ != null) {
                this.cbQ.w(bgVar);
                setVisibility(0);
            }
            if (this.cbR != null) {
                this.cbR.setVisibility(8);
            }
            if (this.cbS != null) {
                this.cbS.setVisibility(8);
            }
        }
    }

    public void a(bg bgVar, List<bc> list) {
        if (bgVar != null) {
            if (list == null || list.size() <= 1) {
                x(bgVar);
            } else if (list.size() == 2) {
                if (this.cbQ != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bg bgVar2 = new bg();
                    bgVar2.setId(bgVar.getId());
                    bgVar2.mz(list.get(0).getForumName());
                    bgVar2.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.cbQ.a(bgVar2, this.cbT);
                }
                if (this.cbR != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bg bgVar3 = new bg();
                    bgVar3.setId(bgVar.getId());
                    bgVar3.mz(list.get(1).getForumName());
                    bgVar3.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.cbR.a(bgVar3, this.cbT);
                }
                if (this.cbS != null) {
                    this.cbS.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.cbQ != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bg bgVar4 = new bg();
                    bgVar4.setId(bgVar.getId());
                    bgVar4.mz(list.get(0).getForumName());
                    bgVar4.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.cbQ.a(bgVar4, this.cbU);
                }
                if (this.cbR != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bg bgVar5 = new bg();
                    bgVar5.setId(bgVar.getId());
                    bgVar5.mz(list.get(1).getForumName());
                    bgVar5.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.cbR.a(bgVar5, this.cbU);
                }
                if (this.cbS != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bg bgVar6 = new bg();
                    bgVar6.setId(bgVar.getId());
                    bgVar6.mz(list.get(2).getForumName());
                    bgVar6.setFid(com.baidu.adp.lib.g.b.c(list.get(2).getForumId(), 0L));
                    this.cbS.a(bgVar6, this.cbU);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cbQ != null) {
            this.cbQ.onChangeSkinType();
        }
        if (this.cbR != null) {
            this.cbR.onChangeSkinType();
        }
        if (this.cbS != null) {
            this.cbS.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.cbQ != null) {
            this.cbQ.setAfterClickListener(onClickListener);
        }
        if (this.cbR != null) {
            this.cbR.setAfterClickListener(onClickListener);
        }
        if (this.cbS != null) {
            this.cbS.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.cbQ != null) {
            this.cbQ.setFrom(i);
        }
        if (this.cbR != null) {
            this.cbR.setFrom(i);
        }
        if (this.cbS != null) {
            this.cbS.setFrom(i);
        }
    }
}
