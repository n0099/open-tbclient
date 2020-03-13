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
    private final int dii;
    private ThreadForumEnterButton dij;
    private ThreadForumEnterButton dik;
    private ThreadForumEnterButton dil;
    private View dim;
    private int din;
    private int dio;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dii = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.dij = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.dik = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.dil = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.dim = findViewById(R.id.bottom_placeholder);
        this.din = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dii) / 2;
        this.dio = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dii * 2)) / 3;
    }

    public void E(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aCt())) {
            if (this.dij != null) {
                this.dij.q(bjVar);
                setVisibility(0);
            }
            if (this.dik != null) {
                this.dik.setVisibility(8);
            }
            if (this.dil != null) {
                this.dil.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.dim.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                E(bjVar);
            } else if (list.size() == 2) {
                if (this.dij != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.sG(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dij.a(bjVar2, this.din);
                }
                if (this.dik != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.sG(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dik.a(bjVar3, this.din);
                }
                if (this.dil != null) {
                    this.dil.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.dij != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.sG(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dij.a(bjVar4, this.dio);
                }
                if (this.dik != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.sG(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dik.a(bjVar5, this.dio);
                }
                if (this.dil != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.sG(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.dil.a(bjVar6, this.dio);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dij != null) {
            this.dij.onChangeSkinType();
        }
        if (this.dik != null) {
            this.dik.onChangeSkinType();
        }
        if (this.dil != null) {
            this.dil.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.dij != null) {
            this.dij.setAfterClickListener(onClickListener);
        }
        if (this.dik != null) {
            this.dik.setAfterClickListener(onClickListener);
        }
        if (this.dil != null) {
            this.dil.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.dij != null) {
            this.dij.setFrom(i);
        }
        if (this.dik != null) {
            this.dik.setFrom(i);
        }
        if (this.dil != null) {
            this.dil.setFrom(i);
        }
    }
}
