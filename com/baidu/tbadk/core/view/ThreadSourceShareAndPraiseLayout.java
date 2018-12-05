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
    private bb aFf;
    private View.OnClickListener aIx;
    public TextView aKh;
    public ThreadCommentAndPraiseInfoNewTypeLayout aKi;
    private boolean aKj;
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
            this.aKh = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aKi = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aFf != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aFf.zM())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aFf.zM(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aIx != null) {
                            ThreadSourceShareAndPraiseLayout.this.aIx.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aKj) {
            al.h(this.aKh, e.d.cp_cont_d);
            al.i(this.aKh, e.f.bg_forum_source_gray);
        }
        if (this.aKi.getVisibility() == 0) {
            this.aKi.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aKj = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFf = bbVar;
        if (StringUtils.isNull(this.aFf.zM()) || this.aKj) {
            this.aKh.setVisibility(8);
        } else {
            this.aKh.setText(ao.d(this.aFf.zM(), 10, "...") + getResources().getString(e.j.forum));
            this.aKh.setVisibility(0);
        }
        this.aKi.setData(this.aFf);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aKi.setForumAfterClickListener(onClickListener);
        this.aIx = onClickListener;
    }

    public void setFrom(int i) {
        this.aKi.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aKi.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aKi.avL = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aKi.setStType(str);
    }
}
