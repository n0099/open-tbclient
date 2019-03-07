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
    private bg XR;
    private View.OnClickListener bRy;
    public TextView bSP;
    public ThreadCommentAndPraiseInfoNewTypeLayout bTy;
    private boolean bTz;
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
            this.bSP = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bTy = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.XR != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.XR.YW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.XR.YW(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bRy != null) {
                            ThreadSourceShareAndPraiseLayout.this.bRy.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.bTz) {
            al.j(this.bSP, d.C0236d.cp_cont_d);
            al.k(this.bSP, d.f.bg_forum_source_gray);
        }
        if (this.bTy.getVisibility() == 0) {
            this.bTy.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.bTz = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.XR = bgVar;
        if (StringUtils.isNull(this.XR.YW()) || this.bTz) {
            this.bSP.setVisibility(8);
        } else {
            this.bSP.setText(ap.g(this.XR.YW(), 10, "...") + getResources().getString(d.j.forum));
            this.bSP.setVisibility(0);
        }
        this.bTy.setData(this.XR);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bTy.setForumAfterClickListener(onClickListener);
        this.bRy = onClickListener;
    }

    public void setFrom(int i) {
        this.bTy.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bTy.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.bTy.bSG = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.bTy.setStType(str);
    }
}
