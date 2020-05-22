package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int dWJ;
    private ThreadForumEnterButton dWK;
    private ThreadForumEnterButton dWL;
    private ThreadForumEnterButton dWM;
    private View dWN;
    private int dWO;
    private int dWP;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWJ = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.dWK = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.dWL = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.dWM = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.dWN = findViewById(R.id.bottom_placeholder);
        this.dWO = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dWJ) / 2;
        this.dWP = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dWJ * 2)) / 3;
    }

    public void G(bk bkVar) {
        if (bkVar != null && !aq.isEmpty(bkVar.aQC())) {
            if (this.dWK != null) {
                this.dWK.r(bkVar);
                setVisibility(0);
            }
            if (this.dWL != null) {
                this.dWL.setVisibility(8);
            }
            if (this.dWM != null) {
                this.dWM.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.dWN.setVisibility(z ? 0 : 8);
    }

    public void a(bk bkVar, List<bg> list) {
        if (bkVar != null) {
            if (list == null || list.size() <= 1) {
                G(bkVar);
            } else if (list.size() == 2) {
                if (this.dWK != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bk bkVar2 = new bk();
                    bkVar2.setId(bkVar.getId());
                    bkVar2.vC(list.get(0).getForumName());
                    bkVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dWK.a(bkVar2, this.dWO);
                }
                if (this.dWL != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bk bkVar3 = new bk();
                    bkVar3.setId(bkVar.getId());
                    bkVar3.vC(list.get(1).getForumName());
                    bkVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dWL.a(bkVar3, this.dWO);
                }
                if (this.dWM != null) {
                    this.dWM.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.dWK != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bk bkVar4 = new bk();
                    bkVar4.setId(bkVar.getId());
                    bkVar4.vC(list.get(0).getForumName());
                    bkVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dWK.a(bkVar4, this.dWP);
                }
                if (this.dWL != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bk bkVar5 = new bk();
                    bkVar5.setId(bkVar.getId());
                    bkVar5.vC(list.get(1).getForumName());
                    bkVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dWL.a(bkVar5, this.dWP);
                }
                if (this.dWM != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bk bkVar6 = new bk();
                    bkVar6.setId(bkVar.getId());
                    bkVar6.vC(list.get(2).getForumName());
                    bkVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.dWM.a(bkVar6, this.dWP);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dWK != null) {
            this.dWK.onChangeSkinType();
        }
        if (this.dWL != null) {
            this.dWL.onChangeSkinType();
        }
        if (this.dWM != null) {
            this.dWM.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.dWK != null) {
            this.dWK.setAfterClickListener(onClickListener);
        }
        if (this.dWL != null) {
            this.dWL.setAfterClickListener(onClickListener);
        }
        if (this.dWM != null) {
            this.dWM.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.dWK != null) {
            this.dWK.setFrom(i);
        }
        if (this.dWL != null) {
            this.dWL.setFrom(i);
        }
        if (this.dWM != null) {
            this.dWM.setFrom(i);
        }
    }
}
