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
    private final int dIq;
    private ThreadForumEnterButton dIr;
    private ThreadForumEnterButton dIs;
    private ThreadForumEnterButton dIt;
    private View dIu;
    private int dIv;
    private int dIw;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIq = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.dIr = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.dIs = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.dIt = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.dIu = findViewById(R.id.bottom_placeholder);
        this.dIv = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dIq) / 2;
        this.dIw = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dIq * 2)) / 3;
    }

    public void F(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aKJ())) {
            if (this.dIr != null) {
                this.dIr.q(bjVar);
                setVisibility(0);
            }
            if (this.dIs != null) {
                this.dIs.setVisibility(8);
            }
            if (this.dIt != null) {
                this.dIt.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.dIu.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                F(bjVar);
            } else if (list.size() == 2) {
                if (this.dIr != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.tT(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dIr.a(bjVar2, this.dIv);
                }
                if (this.dIs != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.tT(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dIs.a(bjVar3, this.dIv);
                }
                if (this.dIt != null) {
                    this.dIt.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.dIr != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.tT(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dIr.a(bjVar4, this.dIw);
                }
                if (this.dIs != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.tT(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dIs.a(bjVar5, this.dIw);
                }
                if (this.dIt != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.tT(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.dIt.a(bjVar6, this.dIw);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dIr != null) {
            this.dIr.onChangeSkinType();
        }
        if (this.dIs != null) {
            this.dIs.onChangeSkinType();
        }
        if (this.dIt != null) {
            this.dIt.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.dIr != null) {
            this.dIr.setAfterClickListener(onClickListener);
        }
        if (this.dIs != null) {
            this.dIs.setAfterClickListener(onClickListener);
        }
        if (this.dIt != null) {
            this.dIt.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.dIr != null) {
            this.dIr.setFrom(i);
        }
        if (this.dIs != null) {
            this.dIs.setFrom(i);
        }
        if (this.dIt != null) {
            this.dIt.setFrom(i);
        }
    }
}
