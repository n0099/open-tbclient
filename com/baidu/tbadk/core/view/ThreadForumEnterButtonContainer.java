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
    private final int ddF;
    private ThreadForumEnterButton ddG;
    private ThreadForumEnterButton ddH;
    private ThreadForumEnterButton ddI;
    private View ddJ;
    private int ddK;
    private int ddL;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ddF = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.ddG = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.ddH = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.ddI = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.ddJ = findViewById(R.id.bottom_placeholder);
        this.ddK = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.ddF) / 2;
        this.ddL = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.ddF * 2)) / 3;
    }

    public void D(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.azJ())) {
            if (this.ddG != null) {
                this.ddG.q(bjVar);
                setVisibility(0);
            }
            if (this.ddH != null) {
                this.ddH.setVisibility(8);
            }
            if (this.ddI != null) {
                this.ddI.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.ddJ.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                D(bjVar);
            } else if (list.size() == 2) {
                if (this.ddG != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.sm(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.ddG.a(bjVar2, this.ddK);
                }
                if (this.ddH != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.sm(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.ddH.a(bjVar3, this.ddK);
                }
                if (this.ddI != null) {
                    this.ddI.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.ddG != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.sm(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.ddG.a(bjVar4, this.ddL);
                }
                if (this.ddH != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.sm(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.ddH.a(bjVar5, this.ddL);
                }
                if (this.ddI != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.sm(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.ddI.a(bjVar6, this.ddL);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ddG != null) {
            this.ddG.onChangeSkinType();
        }
        if (this.ddH != null) {
            this.ddH.onChangeSkinType();
        }
        if (this.ddI != null) {
            this.ddI.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.ddG != null) {
            this.ddG.setAfterClickListener(onClickListener);
        }
        if (this.ddH != null) {
            this.ddH.setAfterClickListener(onClickListener);
        }
        if (this.ddI != null) {
            this.ddI.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.ddG != null) {
            this.ddG.setFrom(i);
        }
        if (this.ddH != null) {
            this.ddH.setFrom(i);
        }
        if (this.ddI != null) {
            this.ddI.setFrom(i);
        }
    }
}
