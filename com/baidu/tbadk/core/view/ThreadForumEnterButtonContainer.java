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
    private int dIA;
    private final int dIu;
    private ThreadForumEnterButton dIv;
    private ThreadForumEnterButton dIw;
    private ThreadForumEnterButton dIx;
    private View dIy;
    private int dIz;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIu = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.dIv = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.dIw = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.dIx = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.dIy = findViewById(R.id.bottom_placeholder);
        this.dIz = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.dIu) / 2;
        this.dIA = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.dIu * 2)) / 3;
    }

    public void F(bj bjVar) {
        if (bjVar != null && !aq.isEmpty(bjVar.aKH())) {
            if (this.dIv != null) {
                this.dIv.q(bjVar);
                setVisibility(0);
            }
            if (this.dIw != null) {
                this.dIw.setVisibility(8);
            }
            if (this.dIx != null) {
                this.dIx.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.dIy.setVisibility(z ? 0 : 8);
    }

    public void a(bj bjVar, List<bf> list) {
        if (bjVar != null) {
            if (list == null || list.size() <= 1) {
                F(bjVar);
            } else if (list.size() == 2) {
                if (this.dIv != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar2 = new bj();
                    bjVar2.setId(bjVar.getId());
                    bjVar2.tW(list.get(0).getForumName());
                    bjVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dIv.a(bjVar2, this.dIz);
                }
                if (this.dIw != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar3 = new bj();
                    bjVar3.setId(bjVar.getId());
                    bjVar3.tW(list.get(1).getForumName());
                    bjVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dIw.a(bjVar3, this.dIz);
                }
                if (this.dIx != null) {
                    this.dIx.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.dIv != null && list.get(0) != null && !aq.isEmpty(list.get(0).getForumName())) {
                    bj bjVar4 = new bj();
                    bjVar4.setId(bjVar.getId());
                    bjVar4.tW(list.get(0).getForumName());
                    bjVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.dIv.a(bjVar4, this.dIA);
                }
                if (this.dIw != null && list.get(1) != null && !aq.isEmpty(list.get(1).getForumName())) {
                    bj bjVar5 = new bj();
                    bjVar5.setId(bjVar.getId());
                    bjVar5.tW(list.get(1).getForumName());
                    bjVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.dIw.a(bjVar5, this.dIA);
                }
                if (this.dIx != null && list.get(2) != null && !aq.isEmpty(list.get(2).getForumName())) {
                    bj bjVar6 = new bj();
                    bjVar6.setId(bjVar.getId());
                    bjVar6.tW(list.get(2).getForumName());
                    bjVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.dIx.a(bjVar6, this.dIA);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dIv != null) {
            this.dIv.onChangeSkinType();
        }
        if (this.dIw != null) {
            this.dIw.onChangeSkinType();
        }
        if (this.dIx != null) {
            this.dIx.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.dIv != null) {
            this.dIv.setAfterClickListener(onClickListener);
        }
        if (this.dIw != null) {
            this.dIw.setAfterClickListener(onClickListener);
        }
        if (this.dIx != null) {
            this.dIx.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.dIv != null) {
            this.dIv.setFrom(i);
        }
        if (this.dIw != null) {
            this.dIw.setFrom(i);
        }
        if (this.dIx != null) {
            this.dIx.setFrom(i);
        }
    }
}
