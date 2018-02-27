package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bd aZA;
    private View.OnClickListener bdE;
    public TextView bel;
    public ThreadCommentAndPraiseInfoNewTypeLayout bem;
    private boolean ben;
    private Context mContext;
    private String stType;

    public ThreadSourceShareAndPraiseLayout(Context context) {
        super(context);
        init(context);
    }

    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreadSourceShareAndPraiseLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(d.h.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.bel = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bem = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aZA != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aZA.zt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aZA.zt(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bdE != null) {
                            ThreadSourceShareAndPraiseLayout.this.bdE.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ben) {
            aj.r(this.bel, d.C0141d.cp_cont_d);
            aj.s(this.bel, d.f.bg_forum_source_gray);
        }
        if (this.bem.getVisibility() == 0) {
            this.bem.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ben = z;
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZA = bdVar;
        if (StringUtils.isNull(this.aZA.zt()) || this.ben) {
            this.bel.setVisibility(8);
        } else {
            this.bel.setText(am.e(this.aZA.zt(), 10, "...") + getResources().getString(d.j.forum));
            this.bel.setVisibility(0);
        }
        this.bem.setData(this.aZA);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bem.setForumAfterClickListener(onClickListener);
        this.bdE = onClickListener;
    }

    public void setFrom(int i) {
        this.bem.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bem.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bem.aQt = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bem.setStType(str);
    }
}
