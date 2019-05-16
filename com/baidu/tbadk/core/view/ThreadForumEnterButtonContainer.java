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
    private final int caM;
    private ThreadForumEnterButton caN;
    private ThreadForumEnterButton caO;
    private ThreadForumEnterButton caP;
    private int caQ;
    private int caR;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.caM = com.baidu.adp.lib.util.l.g(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.caN = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.caO = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.caP = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.caQ = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.caM) / 2;
        this.caR = (((com.baidu.adp.lib.util.l.af(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.caM * 2)) / 3;
    }

    public void x(bg bgVar) {
        if (bgVar != null && !ap.isEmpty(bgVar.adA())) {
            if (this.caN != null) {
                this.caN.w(bgVar);
                setVisibility(0);
            }
            if (this.caO != null) {
                this.caO.setVisibility(8);
            }
            if (this.caP != null) {
                this.caP.setVisibility(8);
            }
        }
    }

    public void a(bg bgVar, List<bc> list) {
        if (bgVar != null) {
            if (list == null || list.size() <= 1) {
                x(bgVar);
            } else if (list.size() == 2) {
                if (this.caN != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar2 = new bg();
                    bgVar2.setId(bgVar.getId());
                    bgVar2.mp(list.get(0).getForumName());
                    bgVar2.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.caN.a(bgVar2, this.caQ);
                }
                if (this.caO != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar3 = new bg();
                    bgVar3.setId(bgVar.getId());
                    bgVar3.mp(list.get(1).getForumName());
                    bgVar3.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.caO.a(bgVar3, this.caQ);
                }
                if (this.caP != null) {
                    this.caP.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.caN != null && list.get(0) != null && !ap.isEmpty(list.get(0).getForumName())) {
                    bg bgVar4 = new bg();
                    bgVar4.setId(bgVar.getId());
                    bgVar4.mp(list.get(0).getForumName());
                    bgVar4.setFid(com.baidu.adp.lib.g.b.c(list.get(0).getForumId(), 0L));
                    this.caN.a(bgVar4, this.caR);
                }
                if (this.caO != null && list.get(1) != null && !ap.isEmpty(list.get(1).getForumName())) {
                    bg bgVar5 = new bg();
                    bgVar5.setId(bgVar.getId());
                    bgVar5.mp(list.get(1).getForumName());
                    bgVar5.setFid(com.baidu.adp.lib.g.b.c(list.get(1).getForumId(), 0L));
                    this.caO.a(bgVar5, this.caR);
                }
                if (this.caP != null && list.get(2) != null && !ap.isEmpty(list.get(2).getForumName())) {
                    bg bgVar6 = new bg();
                    bgVar6.setId(bgVar.getId());
                    bgVar6.mp(list.get(2).getForumName());
                    bgVar6.setFid(com.baidu.adp.lib.g.b.c(list.get(2).getForumId(), 0L));
                    this.caP.a(bgVar6, this.caR);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.caN != null) {
            this.caN.onChangeSkinType();
        }
        if (this.caO != null) {
            this.caO.onChangeSkinType();
        }
        if (this.caP != null) {
            this.caP.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.caN != null) {
            this.caN.setAfterClickListener(onClickListener);
        }
        if (this.caO != null) {
            this.caO.setAfterClickListener(onClickListener);
        }
        if (this.caP != null) {
            this.caP.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.caN != null) {
            this.caN.setFrom(i);
        }
        if (this.caO != null) {
            this.caO.setFrom(i);
        }
        if (this.caP != null) {
            this.caP.setFrom(i);
        }
    }
}
