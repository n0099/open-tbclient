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
    private final int dhU;
    private ThreadForumEnterButton dhV;
    private ThreadForumEnterButton dhW;
    private ThreadForumEnterButton dhX;
    private View dhY;
    private int dhZ;
    private int dia;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhU = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.dhV = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.dhW = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.dhX = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.dhY = findViewById(R.id.bottom_placeholder);
        this.dhZ = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dhU) / 2;
        this.dia = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dhU * 2)) / 3;
    }

    public void E(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aCt())) {
            if (this.dhV != null) {
                this.dhV.q(bjVar);
                setVisibility(0);
            }
            if (this.dhW != null) {
                this.dhW.setVisibility(8);
            }
            if (this.dhX != null) {
                this.dhX.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.dhY.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                E(bjVar);
            } else if (list.size() == 2) {
                if (this.dhV != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.sG(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dhV.a(bjVar2, this.dhZ);
                }
                if (this.dhW != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.sG(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dhW.a(bjVar3, this.dhZ);
                }
                if (this.dhX != null) {
                    this.dhX.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.dhV != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.sG(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dhV.a(bjVar4, this.dia);
                }
                if (this.dhW != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.sG(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dhW.a(bjVar5, this.dia);
                }
                if (this.dhX != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.sG(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.dhX.a(bjVar6, this.dia);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dhV != null) {
            this.dhV.onChangeSkinType();
        }
        if (this.dhW != null) {
            this.dhW.onChangeSkinType();
        }
        if (this.dhX != null) {
            this.dhX.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.dhV != null) {
            this.dhV.setAfterClickListener(onClickListener);
        }
        if (this.dhW != null) {
            this.dhW.setAfterClickListener(onClickListener);
        }
        if (this.dhX != null) {
            this.dhX.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.dhV != null) {
            this.dhV.setFrom(i);
        }
        if (this.dhW != null) {
            this.dhW.setFrom(i);
        }
        if (this.dhX != null) {
            this.dhX.setFrom(i);
        }
    }
}
