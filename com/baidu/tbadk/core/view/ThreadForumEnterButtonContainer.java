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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int caN;
    private ThreadForumEnterButton caO;
    private ThreadForumEnterButton caP;
    private ThreadForumEnterButton caQ;
    private int caR;
    private int caS;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caN = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.caO = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.caP = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.caQ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.caR = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.caN) / 2;
        this.caS = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.caN * 2)) / 3;
    }

    public void x(bg bgVar) {
        if (bgVar != null && !ap.isEmpty(bgVar.adA())) {
            if (this.caO != null) {
                this.caO.w(bgVar);
                setVisibility(0);
            }
            if (this.caP != null) {
                this.caP.setVisibility(8);
            }
            if (this.caQ != null) {
                this.caQ.setVisibility(8);
            }
        }
    }

    public void a(bg bgVar, List<bc> list) {
        if (bgVar != null) {
            if (list == null || list.size() <= 1) {
                x(bgVar);
            } else if (list.size() == 2) {
                if (this.caO != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar2 = new bg();
                    bgVar2.setId(bgVar.getId());
                    bgVar2.mo(list.get(0).getForumName());
                    bgVar2.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.caO.a(bgVar2, this.caR);
                }
                if (this.caP != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar3 = new bg();
                    bgVar3.setId(bgVar.getId());
                    bgVar3.mo(list.get(1).getForumName());
                    bgVar3.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.caP.a(bgVar3, this.caR);
                }
                if (this.caQ != null) {
                    this.caQ.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.caO != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar4 = new bg();
                    bgVar4.setId(bgVar.getId());
                    bgVar4.mo(list.get(0).getForumName());
                    bgVar4.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.caO.a(bgVar4, this.caS);
                }
                if (this.caP != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar5 = new bg();
                    bgVar5.setId(bgVar.getId());
                    bgVar5.mo(list.get(1).getForumName());
                    bgVar5.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.caP.a(bgVar5, this.caS);
                }
                if (this.caQ != null && list.get(2) != null && !ap.isEmpty(list.get(2).getForumName())) {
                    bg bgVar6 = new bg();
                    bgVar6.setId(bgVar.getId());
                    bgVar6.mo(list.get(2).getForumName());
                    bgVar6.setFid(com.baidu.adp.lib.g.b.c(list.get(2).getForumId(), 0L));
                    this.caQ.a(bgVar6, this.caS);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.caO != null) {
            this.caO.onChangeSkinType();
        }
        if (this.caP != null) {
            this.caP.onChangeSkinType();
        }
        if (this.caQ != null) {
            this.caQ.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.caO != null) {
            this.caO.setAfterClickListener(onClickListener);
        }
        if (this.caP != null) {
            this.caP.setAfterClickListener(onClickListener);
        }
        if (this.caQ != null) {
            this.caQ.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.caO != null) {
            this.caO.setFrom(i);
        }
        if (this.caP != null) {
            this.caP.setFrom(i);
        }
        if (this.caQ != null) {
            this.caQ.setFrom(i);
        }
    }
}
