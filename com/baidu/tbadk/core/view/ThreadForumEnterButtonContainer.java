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
    private ThreadForumEnterButton diA;
    private View diB;
    private int diC;
    private int diD;
    private final int dix;
    private ThreadForumEnterButton diy;
    private ThreadForumEnterButton diz;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dix = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.diy = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.diz = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.diA = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.diB = findViewById(R.id.bottom_placeholder);
        this.diC = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dix) / 2;
        this.diD = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dix * 2)) / 3;
    }

    public void F(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aCw())) {
            if (this.diy != null) {
                this.diy.q(bjVar);
                setVisibility(0);
            }
            if (this.diz != null) {
                this.diz.setVisibility(8);
            }
            if (this.diA != null) {
                this.diA.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.diB.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                F(bjVar);
            } else if (list.size() == 2) {
                if (this.diy != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.sF(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.diy.a(bjVar2, this.diC);
                }
                if (this.diz != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.sF(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.diz.a(bjVar3, this.diC);
                }
                if (this.diA != null) {
                    this.diA.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.diy != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.sF(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.diy.a(bjVar4, this.diD);
                }
                if (this.diz != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.sF(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.diz.a(bjVar5, this.diD);
                }
                if (this.diA != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.sF(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.diA.a(bjVar6, this.diD);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.diy != null) {
            this.diy.onChangeSkinType();
        }
        if (this.diz != null) {
            this.diz.onChangeSkinType();
        }
        if (this.diA != null) {
            this.diA.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.diy != null) {
            this.diy.setAfterClickListener(onClickListener);
        }
        if (this.diz != null) {
            this.diz.setAfterClickListener(onClickListener);
        }
        if (this.diA != null) {
            this.diA.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.diy != null) {
            this.diy.setFrom(i);
        }
        if (this.diz != null) {
            this.diz.setFrom(i);
        }
        if (this.diA != null) {
            this.diA.setFrom(i);
        }
    }
}
