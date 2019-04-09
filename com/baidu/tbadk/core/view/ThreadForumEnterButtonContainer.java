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
    private final int bSU;
    private ThreadForumEnterButton bSV;
    private ThreadForumEnterButton bSW;
    private ThreadForumEnterButton bSX;
    private int bSY;
    private int bSZ;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bSU = com.baidu.adp.lib.util.l.h(TbadkApplication.getInst(), d.e.tbds22);
        LayoutInflater.from(context).inflate(d.h.thread_forum_enter_button_container_layout, this);
        this.bSV = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_one);
        this.bSW = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_two);
        this.bSX = (ThreadForumEnterButton) findViewById(d.g.forum_enter_button_three);
        this.bSY = (((com.baidu.adp.lib.util.l.aO(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.bSU) / 2;
        this.bSZ = (((com.baidu.adp.lib.util.l.aO(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.bSU * 2)) / 3;
    }

    public void x(bg bgVar) {
        if (bgVar != null && !ap.isEmpty(bgVar.YT())) {
            if (this.bSV != null) {
                this.bSV.w(bgVar);
                setVisibility(0);
            }
            if (this.bSW != null) {
                this.bSW.setVisibility(8);
            }
            if (this.bSX != null) {
                this.bSX.setVisibility(8);
            }
        }
    }

    public void a(bg bgVar, List<bc> list) {
        if (bgVar != null) {
            if (list == null || list.size() <= 1) {
                x(bgVar);
            } else if (list.size() == 2) {
                if (this.bSV != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar2 = new bg();
                    bgVar2.setId(bgVar.getId());
                    bgVar2.lk(list.get(0).getForumName());
                    bgVar2.setFid(com.baidu.adp.lib.g.b.d(list.get(0).getForumId(), 0L));
                    this.bSV.a(bgVar2, this.bSY);
                }
                if (this.bSW != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar3 = new bg();
                    bgVar3.setId(bgVar.getId());
                    bgVar3.lk(list.get(1).getForumName());
                    bgVar3.setFid(com.baidu.adp.lib.g.b.d(list.get(1).getForumId(), 0L));
                    this.bSW.a(bgVar3, this.bSY);
                }
                if (this.bSX != null) {
                    this.bSX.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.bSV != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar4 = new bg();
                    bgVar4.setId(bgVar.getId());
                    bgVar4.lk(list.get(0).getForumName());
                    bgVar4.setFid(com.baidu.adp.lib.g.b.d(list.get(0).getForumId(), 0L));
                    this.bSV.a(bgVar4, this.bSZ);
                }
                if (this.bSW != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar5 = new bg();
                    bgVar5.setId(bgVar.getId());
                    bgVar5.lk(list.get(1).getForumName());
                    bgVar5.setFid(com.baidu.adp.lib.g.b.d(list.get(1).getForumId(), 0L));
                    this.bSW.a(bgVar5, this.bSZ);
                }
                if (this.bSX != null && list.get(2) != null && !ap.isEmpty(list.get(2).getForumName())) {
                    bg bgVar6 = new bg();
                    bgVar6.setId(bgVar.getId());
                    bgVar6.lk(list.get(2).getForumName());
                    bgVar6.setFid(com.baidu.adp.lib.g.b.d(list.get(2).getForumId(), 0L));
                    this.bSX.a(bgVar6, this.bSZ);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bSV != null) {
            this.bSV.onChangeSkinType();
        }
        if (this.bSW != null) {
            this.bSW.onChangeSkinType();
        }
        if (this.bSX != null) {
            this.bSX.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.bSV != null) {
            this.bSV.setAfterClickListener(onClickListener);
        }
        if (this.bSW != null) {
            this.bSW.setAfterClickListener(onClickListener);
        }
        if (this.bSX != null) {
            this.bSX.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.bSV != null) {
            this.bSV.setFrom(i);
        }
        if (this.bSW != null) {
            this.bSW.setFrom(i);
        }
        if (this.bSX != null) {
            this.bSX.setFrom(i);
        }
    }
}
