package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int ddP;
    private ThreadForumEnterButton ddQ;
    private ThreadForumEnterButton ddR;
    private ThreadForumEnterButton ddS;
    private View ddT;
    private int ddU;
    private int ddV;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ddP = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.ddQ = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.ddR = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.ddS = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.ddT = findViewById(R.id.bottom_placeholder);
        this.ddU = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.ddP) / 2;
        this.ddV = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.ddP * 2)) / 3;
    }

    public void D(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aAc())) {
            if (this.ddQ != null) {
                this.ddQ.q(bjVar);
                setVisibility(0);
            }
            if (this.ddR != null) {
                this.ddR.setVisibility(8);
            }
            if (this.ddS != null) {
                this.ddS.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.ddT.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                D(bjVar);
            } else if (list.size() == 2) {
                if (this.ddQ != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.sp(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.ddQ.a(bjVar2, this.ddU);
                }
                if (this.ddR != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.sp(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.ddR.a(bjVar3, this.ddU);
                }
                if (this.ddS != null) {
                    this.ddS.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.ddQ != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.sp(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.ddQ.a(bjVar4, this.ddV);
                }
                if (this.ddR != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.sp(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.ddR.a(bjVar5, this.ddV);
                }
                if (this.ddS != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.sp(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.ddS.a(bjVar6, this.ddV);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ddQ != null) {
            this.ddQ.onChangeSkinType();
        }
        if (this.ddR != null) {
            this.ddR.onChangeSkinType();
        }
        if (this.ddS != null) {
            this.ddS.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.ddQ != null) {
            this.ddQ.setAfterClickListener(onClickListener);
        }
        if (this.ddR != null) {
            this.ddR.setAfterClickListener(onClickListener);
        }
        if (this.ddS != null) {
            this.ddS.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.ddQ != null) {
            this.ddQ.setFrom(i);
        }
        if (this.ddR != null) {
            this.ddR.setFrom(i);
        }
        if (this.ddS != null) {
            this.ddS.setFrom(i);
        }
    }
}
