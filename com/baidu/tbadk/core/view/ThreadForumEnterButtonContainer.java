package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadForumEnterButtonContainer extends RelativeLayout {
    private final int eef;
    private ThreadForumEnterButton eeg;
    private ThreadForumEnterButton eeh;
    private ThreadForumEnterButton eei;
    private View eej;
    private int eek;
    private int eel;

    public ThreadForumEnterButtonContainer(Context context) {
        this(context, null);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadForumEnterButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eef = com.baidu.adp.lib.util.l.getDimens(TbadkApplication.getInst(), R.dimen.tbds22);
        LayoutInflater.from(context).inflate(R.layout.thread_forum_enter_button_container_layout, this);
        this.eeg = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_one);
        this.eeh = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_two);
        this.eei = (ThreadForumEnterButton) findViewById(R.id.forum_enter_button_three);
        this.eej = findViewById(R.id.bottom_placeholder);
        this.eek = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - this.eef) / 2;
        this.eel = (((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) - getPaddingLeft()) - getPaddingRight()) - (this.eef * 2)) / 3;
    }

    public void G(bu buVar) {
        if (buVar != null && !ar.isEmpty(buVar.aSt())) {
            if (this.eeg != null) {
                this.eeg.q(buVar);
                setVisibility(0);
            }
            if (this.eeh != null) {
                this.eeh.setVisibility(8);
            }
            if (this.eei != null) {
                this.eei.setVisibility(8);
            }
        }
    }

    public void setBottomPlaceHolderVisibility(boolean z) {
        this.eej.setVisibility(z ? 0 : 8);
    }

    public void a(bu buVar, List<bq> list) {
        if (buVar != null) {
            if (list == null || list.size() <= 1) {
                G(buVar);
            } else if (list.size() == 2) {
                if (this.eeg != null && list.get(0) != null && !ar.isEmpty(list.get(0).getForumName())) {
                    bu buVar2 = new bu();
                    buVar2.setId(buVar.getId());
                    buVar2.vS(list.get(0).getForumName());
                    buVar2.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.eeg.a(buVar2, this.eek);
                }
                if (this.eeh != null && list.get(1) != null && !ar.isEmpty(list.get(1).getForumName())) {
                    bu buVar3 = new bu();
                    buVar3.setId(buVar.getId());
                    buVar3.vS(list.get(1).getForumName());
                    buVar3.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.eeh.a(buVar3, this.eek);
                }
                if (this.eei != null) {
                    this.eei.setVisibility(8);
                }
                setVisibility(0);
            } else {
                if (this.eeg != null && list.get(0) != null && !ar.isEmpty(list.get(0).getForumName())) {
                    bu buVar4 = new bu();
                    buVar4.setId(buVar.getId());
                    buVar4.vS(list.get(0).getForumName());
                    buVar4.setFid(com.baidu.adp.lib.f.b.toLong(list.get(0).getForumId(), 0L));
                    this.eeg.a(buVar4, this.eel);
                }
                if (this.eeh != null && list.get(1) != null && !ar.isEmpty(list.get(1).getForumName())) {
                    bu buVar5 = new bu();
                    buVar5.setId(buVar.getId());
                    buVar5.vS(list.get(1).getForumName());
                    buVar5.setFid(com.baidu.adp.lib.f.b.toLong(list.get(1).getForumId(), 0L));
                    this.eeh.a(buVar5, this.eel);
                }
                if (this.eei != null && list.get(2) != null && !ar.isEmpty(list.get(2).getForumName())) {
                    bu buVar6 = new bu();
                    buVar6.setId(buVar.getId());
                    buVar6.vS(list.get(2).getForumName());
                    buVar6.setFid(com.baidu.adp.lib.f.b.toLong(list.get(2).getForumId(), 0L));
                    this.eei.a(buVar6, this.eel);
                }
                setVisibility(0);
            }
        }
    }

    public void onChangeSkinType() {
        if (this.eeg != null) {
            this.eeg.onChangeSkinType();
        }
        if (this.eeh != null) {
            this.eeh.onChangeSkinType();
        }
        if (this.eei != null) {
            this.eei.onChangeSkinType();
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        if (this.eeg != null) {
            this.eeg.setAfterClickListener(onClickListener);
        }
        if (this.eeh != null) {
            this.eeh.setAfterClickListener(onClickListener);
        }
        if (this.eei != null) {
            this.eei.setAfterClickListener(onClickListener);
        }
    }

    public void setFrom(int i) {
        if (this.eeg != null) {
            this.eeg.setFrom(i);
        }
        if (this.eeh != null) {
            this.eeh.setFrom(i);
        }
        if (this.eei != null) {
            this.eei.setFrom(i);
        }
    }
}
