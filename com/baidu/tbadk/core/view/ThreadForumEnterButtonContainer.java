package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int bSQ;
    private ThreadForumEnterButton bSR;
    private ThreadForumEnterButton bSS;
    private ThreadForumEnterButton bST;
    private int bSU;
    private int bSV;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSQ = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds22);
        LayoutInflater.from(context).inflate(d.h.thread_forum_enter_button_container_layout, this);
        this.bSR = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_one);
        this.bSS = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_two);
        this.bST = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_three);
        this.bSU = (((com.baidu.adp.lib.util.l.aO(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.bSQ) / 2;
        this.bSV = (((com.baidu.adp.lib.util.l.aO(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.bSQ * 2)) / 3;
    }

    public void x(bg bgVar) {
        if (bgVar != null && !ap.isEmpty(bgVar.YW())) {
            if (this.bSR != null) {
                this.bSR.w(bgVar);
                setVisibility(0);
            }
            if (this.bSS != null) {
                this.bSS.setVisibility(8);
            }
            if (this.bST != null) {
                this.bST.setVisibility(8);
            }
        }
    }

    public void a(bg bgVar, List<bc> list) {
        if (bgVar != null) {
            if (list == null || list.size() <= 1) {
                x(bgVar);
            } else if (list.size() == 2) {
                if (this.bSR != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar2 = new bg();
                    bgVar2.setId(bgVar.getId());
                    bgVar2.lj(list.get(0).getForumName());
                    bgVar2.setFid(com.baidu.adp.lib.g.b.d(list.get(0).getForumId(), 0L));
                    this.bSR.a(bgVar2, this.bSU);
                }
                if (this.bSS != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar3 = new bg();
                    bgVar3.setId(bgVar.getId());
                    bgVar3.lj(list.get(1).getForumName());
                    bgVar3.setFid(com.baidu.adp.lib.g.b.d(list.get(1).getForumId(), 0L));
                    this.bSS.a(bgVar3, this.bSU);
                }
                if (this.bST != null) {
                    this.bST.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.bSR != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar4 = new bg();
                    bgVar4.setId(bgVar.getId());
                    bgVar4.lj(list.get(0).getForumName());
                    bgVar4.setFid(com.baidu.adp.lib.g.b.d(list.get(0).getForumId(), 0L));
                    this.bSR.a(bgVar4, this.bSV);
                }
                if (this.bSS != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar5 = new bg();
                    bgVar5.setId(bgVar.getId());
                    bgVar5.lj(list.get(1).getForumName());
                    bgVar5.setFid(com.baidu.adp.lib.g.b.d(list.get(1).getForumId(), 0L));
                    this.bSS.a(bgVar5, this.bSV);
                }
                if (this.bST != null && list.get(2) != null && !ap.isEmpty(list.get(2).getForumName())) {
                    bg bgVar6 = new bg();
                    bgVar6.setId(bgVar.getId());
                    bgVar6.lj(list.get(2).getForumName());
                    bgVar6.setFid(com.baidu.adp.lib.g.b.d(list.get(2).getForumId(), 0L));
                    this.bST.a(bgVar6, this.bSV);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bSR != null) {
            this.bSR.onChangeSkinType();
        }
        if (this.bSS != null) {
            this.bSS.onChangeSkinType();
        }
        if (this.bST != null) {
            this.bST.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.bSR != null) {
            this.bSR.setAfterClickListener(onClickListener);
        }
        if (this.bSS != null) {
            this.bSS.setAfterClickListener(onClickListener);
        }
        if (this.bST != null) {
            this.bST.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.bSR != null) {
            this.bSR.setFrom(i);
        }
        if (this.bSS != null) {
            this.bSS.setFrom(i);
        }
        if (this.bST != null) {
            this.bST.setFrom(i);
        }
    }
}
