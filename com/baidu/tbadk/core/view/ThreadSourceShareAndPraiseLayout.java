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
    private bb aBF;
    private View.OnClickListener aEX;
    public TextView aGH;
    public ThreadCommentAndPraiseInfoNewTypeLayout aGI;
    private boolean aGJ;
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
            this.aGH = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aGI = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aGH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aBF != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aBF.yI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aBF.yI(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aEX != null) {
                            ThreadSourceShareAndPraiseLayout.this.aEX.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aGJ) {
            al.h(this.aGH, e.d.cp_cont_d);
            al.i(this.aGH, e.f.bg_forum_source_gray);
        }
        if (this.aGI.getVisibility() == 0) {
            this.aGI.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aGJ = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aBF = bbVar;
        if (StringUtils.isNull(this.aBF.yI()) || this.aGJ) {
            this.aGH.setVisibility(8);
        } else {
            this.aGH.setText(ao.d(this.aBF.yI(), 10, "...") + getResources().getString(e.j.forum));
            this.aGH.setVisibility(0);
        }
        this.aGI.setData(this.aBF);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aGI.setForumAfterClickListener(onClickListener);
        this.aEX = onClickListener;
    }

    public void setFrom(int i) {
        this.aGI.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aGI.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aGI.asl = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aGI.setStType(str);
    }
}
