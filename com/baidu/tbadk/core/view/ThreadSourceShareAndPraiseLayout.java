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
    private bb aFI;
    private View.OnClickListener aJa;
    public TextView aKL;
    public ThreadCommentAndPraiseInfoNewTypeLayout aKM;
    private boolean aKN;
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
            this.aKL = (TextView) inflate.findViewById(e.g.view_forum_source);
            this.aKM = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(e.g.layout_share_and_praise);
            this.aKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aFI != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aFI.zZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aFI.zZ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aJa != null) {
                            ThreadSourceShareAndPraiseLayout.this.aJa.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.aKN) {
            al.h(this.aKL, e.d.cp_cont_d);
            al.i(this.aKL, e.f.bg_forum_source_gray);
        }
        if (this.aKM.getVisibility() == 0) {
            this.aKM.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.aKN = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aFI = bbVar;
        if (StringUtils.isNull(this.aFI.zZ()) || this.aKN) {
            this.aKL.setVisibility(8);
        } else {
            this.aKL.setText(ao.d(this.aFI.zZ(), 10, "...") + getResources().getString(e.j.forum));
            this.aKL.setVisibility(0);
        }
        this.aKM.setData(this.aFI);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aKM.setForumAfterClickListener(onClickListener);
        this.aJa = onClickListener;
    }

    public void setFrom(int i) {
        this.aKM.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.aKM.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.aKM.awo = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.aKM.setStType(str);
    }
}
