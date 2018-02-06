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
    private bd aZM;
    private View.OnClickListener bdQ;
    private boolean beA;
    public TextView bey;
    public ThreadCommentAndPraiseInfoNewTypeLayout bez;
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
            this.bey = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bez = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bey.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aZM != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aZM.zt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aZM.zt(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bdQ != null) {
                            ThreadSourceShareAndPraiseLayout.this.bdQ.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.beA) {
            aj.r(this.bey, d.C0140d.cp_cont_d);
            aj.s(this.bey, d.f.bg_forum_source_gray);
        }
        if (this.bez.getVisibility() == 0) {
            this.bez.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.beA = z;
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aZM = bdVar;
        if (StringUtils.isNull(this.aZM.zt()) || this.beA) {
            this.bey.setVisibility(8);
        } else {
            this.bey.setText(am.e(this.aZM.zt(), 10, "...") + getResources().getString(d.j.forum));
            this.bey.setVisibility(0);
        }
        this.bez.setData(this.aZM);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bez.setForumAfterClickListener(onClickListener);
        this.bdQ = onClickListener;
    }

    public void setFrom(int i) {
        this.bez.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bez.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bez.aQE = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bez.setStType(str);
    }
}
