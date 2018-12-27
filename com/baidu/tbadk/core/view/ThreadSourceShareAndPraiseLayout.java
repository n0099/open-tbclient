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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bb aFg;
    private View.OnClickListener aIy;
    public TextView aKj;
    public ThreadCommentAndPraiseInfoNewTypeLayout aKk;
    private boolean aKl;
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
            View inflate = LayoutInflater.from(context).inflate(e.h.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.aKj = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aKk = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aFg != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aFg.zM())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aFg.zM(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aIy != null) {
                            ThreadSourceShareAndPraiseLayout.this.aIy.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aKl) {
            al.h(this.aKj, e.d.cp_cont_d);
            al.i(this.aKj, e.f.bg_forum_source_gray);
        }
        if (this.aKk.getVisibility() == 0) {
            this.aKk.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aKl = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFg = bbVar;
        if (StringUtils.isNull(this.aFg.zM()) || this.aKl) {
            this.aKj.setVisibility(8);
        } else {
            this.aKj.setText(ao.d(this.aFg.zM(), 10, "...") + getResources().getString(e.j.forum));
            this.aKj.setVisibility(0);
        }
        this.aKk.setData(this.aFg);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aKk.setForumAfterClickListener(onClickListener);
        this.aIy = onClickListener;
    }

    public void setFrom(int i) {
        this.aKk.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aKk.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aKk.avM = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aKk.setStType(str);
    }
}
