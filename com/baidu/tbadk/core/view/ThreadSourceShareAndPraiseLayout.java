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
    private bb aFJ;
    private View.OnClickListener aJb;
    public TextView aKM;
    public ThreadCommentAndPraiseInfoNewTypeLayout aKN;
    private boolean aKO;
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
            this.aKM = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aKN = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aFJ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aFJ.zZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aFJ.zZ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aJb != null) {
                            ThreadSourceShareAndPraiseLayout.this.aJb.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aKO) {
            al.h(this.aKM, e.d.cp_cont_d);
            al.i(this.aKM, e.f.bg_forum_source_gray);
        }
        if (this.aKN.getVisibility() == 0) {
            this.aKN.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aKO = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFJ = bbVar;
        if (StringUtils.isNull(this.aFJ.zZ()) || this.aKO) {
            this.aKM.setVisibility(8);
        } else {
            this.aKM.setText(ao.d(this.aFJ.zZ(), 10, "...") + getResources().getString(e.j.forum));
            this.aKM.setVisibility(0);
        }
        this.aKN.setData(this.aFJ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aKN.setForumAfterClickListener(onClickListener);
        this.aJb = onClickListener;
    }

    public void setFrom(int i) {
        this.aKN.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aKN.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aKN.awp = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aKN.setStType(str);
    }
}
