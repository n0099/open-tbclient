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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bg XS;
    private View.OnClickListener bRz;
    public TextView bSQ;
    private boolean bTA;
    public ThreadCommentAndPraiseInfoNewTypeLayout bTz;
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
            this.bSQ = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bTz = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.XS != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.XS.YW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.XS.YW(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bRz != null) {
                            ThreadSourceShareAndPraiseLayout.this.bRz.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.bTA) {
            al.j(this.bSQ, d.C0277d.cp_cont_d);
            al.k(this.bSQ, d.f.bg_forum_source_gray);
        }
        if (this.bTz.getVisibility() == 0) {
            this.bTz.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.bTA = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XS = bgVar;
        if (StringUtils.isNull(this.XS.YW()) || this.bTA) {
            this.bSQ.setVisibility(8);
        } else {
            this.bSQ.setText(ap.g(this.XS.YW(), 10, "...") + getResources().getString(d.j.forum));
            this.bSQ.setVisibility(0);
        }
        this.bTz.setData(this.XS);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bTz.setForumAfterClickListener(onClickListener);
        this.bRz = onClickListener;
    }

    public void setFrom(int i) {
        this.bTz.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bTz.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bTz.bSH = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bTz.setStType(str);
    }
}
