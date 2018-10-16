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
    private bb aAQ;
    private View.OnClickListener aEh;
    public TextView aFR;
    public ThreadCommentAndPraiseInfoNewTypeLayout aFS;
    private boolean aFT;
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
            this.aFR = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aFS = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aAQ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aAQ.yB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aAQ.yB(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aEh != null) {
                            ThreadSourceShareAndPraiseLayout.this.aEh.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aFT) {
            al.h(this.aFR, e.d.cp_cont_d);
            al.i(this.aFR, e.f.bg_forum_source_gray);
        }
        if (this.aFS.getVisibility() == 0) {
            this.aFS.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aFT = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aAQ = bbVar;
        if (StringUtils.isNull(this.aAQ.yB()) || this.aFT) {
            this.aFR.setVisibility(8);
        } else {
            this.aFR.setText(ao.d(this.aAQ.yB(), 10, "...") + getResources().getString(e.j.forum));
            this.aFR.setVisibility(0);
        }
        this.aFS.setData(this.aAQ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aFS.setForumAfterClickListener(onClickListener);
        this.aEh = onClickListener;
    }

    public void setFrom(int i) {
        this.aFS.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aFS.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aFS.ary = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aFS.setStType(str);
    }
}
