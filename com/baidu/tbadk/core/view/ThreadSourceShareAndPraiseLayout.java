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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bb atD;
    private View.OnClickListener axz;
    public TextView ayq;
    public ThreadCommentAndPraiseInfoNewTypeLayout ayr;
    private boolean ays;
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
            this.ayq = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.ayr = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.ayq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.atD != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.atD.vq())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.atD.vq(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.axz != null) {
                            ThreadSourceShareAndPraiseLayout.this.axz.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ays) {
            am.h(this.ayq, d.C0140d.cp_cont_d);
            am.i(this.ayq, d.f.bg_forum_source_gray);
        }
        if (this.ayr.getVisibility() == 0) {
            this.ayr.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ays = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atD = bbVar;
        if (StringUtils.isNull(this.atD.vq()) || this.ays) {
            this.ayq.setVisibility(8);
        } else {
            this.ayq.setText(ap.e(this.atD.vq(), 10, "...") + getResources().getString(d.j.forum));
            this.ayq.setVisibility(0);
        }
        this.ayr.setData(this.atD);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ayr.setForumAfterClickListener(onClickListener);
        this.axz = onClickListener;
    }

    public void setFrom(int i) {
        this.ayr.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ayr.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ayr.ajY = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ayr.setStType(str);
    }
}
