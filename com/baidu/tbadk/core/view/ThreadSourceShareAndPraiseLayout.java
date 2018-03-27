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
    private bd aZC;
    private View.OnClickListener bdG;
    public TextView beo;
    public ThreadCommentAndPraiseInfoNewTypeLayout bep;
    private boolean beq;
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
            this.beo = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bep = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.beo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aZC != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aZC.zt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aZC.zt(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bdG != null) {
                            ThreadSourceShareAndPraiseLayout.this.bdG.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.beq) {
            aj.r(this.beo, d.C0141d.cp_cont_d);
            aj.s(this.beo, d.f.bg_forum_source_gray);
        }
        if (this.bep.getVisibility() == 0) {
            this.bep.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.beq = z;
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZC = bdVar;
        if (StringUtils.isNull(this.aZC.zt()) || this.beq) {
            this.beo.setVisibility(8);
        } else {
            this.beo.setText(am.e(this.aZC.zt(), 10, "...") + getResources().getString(d.j.forum));
            this.beo.setVisibility(0);
        }
        this.bep.setData(this.aZC);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bep.setForumAfterClickListener(onClickListener);
        this.bdG = onClickListener;
    }

    public void setFrom(int i) {
        this.bep.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bep.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bep.aQv = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bep.setStType(str);
    }
}
