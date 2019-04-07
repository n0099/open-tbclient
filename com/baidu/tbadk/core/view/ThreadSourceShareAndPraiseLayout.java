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
    private View.OnClickListener bRB;
    public TextView bSS;
    public ThreadCommentAndPraiseInfoNewTypeLayout bTB;
    private boolean bTC;
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
            this.bSS = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bTB = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.XS != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.XS.YT())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.XS.YT(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bRB != null) {
                            ThreadSourceShareAndPraiseLayout.this.bRB.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.bTC) {
            al.j(this.bSS, d.C0277d.cp_cont_d);
            al.k(this.bSS, d.f.bg_forum_source_gray);
        }
        if (this.bTB.getVisibility() == 0) {
            this.bTB.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.bTC = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XS = bgVar;
        if (StringUtils.isNull(this.XS.YT()) || this.bTC) {
            this.bSS.setVisibility(8);
        } else {
            this.bSS.setText(ap.g(this.XS.YT(), 10, "...") + getResources().getString(d.j.forum));
            this.bSS.setVisibility(0);
        }
        this.bTB.setData(this.XS);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bTB.setForumAfterClickListener(onClickListener);
        this.bRB = onClickListener;
    }

    public void setFrom(int i) {
        this.bTB.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bTB.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bTB.bSJ = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bTB.setStType(str);
    }
}
