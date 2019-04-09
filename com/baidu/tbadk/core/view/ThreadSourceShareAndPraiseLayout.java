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
    private bg XT;
    private View.OnClickListener bRC;
    public TextView bST;
    public ThreadCommentAndPraiseInfoNewTypeLayout bTC;
    private boolean bTD;
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
            this.bST = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bTC = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bST.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.XT != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.XT.YT())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.XT.YT(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bRC != null) {
                            ThreadSourceShareAndPraiseLayout.this.bRC.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.bTD) {
            al.j(this.bST, d.C0277d.cp_cont_d);
            al.k(this.bST, d.f.bg_forum_source_gray);
        }
        if (this.bTC.getVisibility() == 0) {
            this.bTC.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.bTD = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XT = bgVar;
        if (StringUtils.isNull(this.XT.YT()) || this.bTD) {
            this.bST.setVisibility(8);
        } else {
            this.bST.setText(ap.g(this.XT.YT(), 10, "...") + getResources().getString(d.j.forum));
            this.bST.setVisibility(0);
        }
        this.bTC.setData(this.XT);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bTC.setForumAfterClickListener(onClickListener);
        this.bRC = onClickListener;
    }

    public void setFrom(int i) {
        this.bTC.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bTC.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bTC.bSK = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bTC.setStType(str);
    }
}
