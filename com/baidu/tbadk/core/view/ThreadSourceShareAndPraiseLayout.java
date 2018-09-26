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
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    public TextView aBk;
    public ThreadCommentAndPraiseInfoNewTypeLayout aBl;
    private boolean aBm;
    private bb awf;
    private View.OnClickListener azz;
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
            this.aBk = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aBl = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aBk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.awf != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.awf.ws())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.awf.ws(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.azz != null) {
                            ThreadSourceShareAndPraiseLayout.this.azz.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aBm) {
            al.h(this.aBk, e.d.cp_cont_d);
            al.i(this.aBk, e.f.bg_forum_source_gray);
        }
        if (this.aBl.getVisibility() == 0) {
            this.aBl.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aBm = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.awf = bbVar;
        if (StringUtils.isNull(this.awf.ws()) || this.aBm) {
            this.aBk.setVisibility(8);
        } else {
            this.aBk.setText(ao.d(this.awf.ws(), 10, "...") + getResources().getString(e.j.forum));
            this.aBk.setVisibility(0);
        }
        this.aBl.setData(this.awf);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aBl.setForumAfterClickListener(onClickListener);
        this.azz = onClickListener;
    }

    public void setFrom(int i) {
        this.aBl.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aBl.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aBl.amD = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aBl.setStType(str);
    }
}
