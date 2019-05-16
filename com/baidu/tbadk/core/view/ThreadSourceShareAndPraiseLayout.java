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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bg VK;
    private View.OnClickListener bZt;
    public TextView caL;
    public ThreadCommentAndPraiseInfoNewTypeLayout cbw;
    private boolean cbx;
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.caL = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.cbw = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.caL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.VK != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.VK.adA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.VK.adA(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bZt != null) {
                            ThreadSourceShareAndPraiseLayout.this.bZt.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.cbx) {
            al.j(this.caL, R.color.cp_cont_d);
            al.k(this.caL, R.drawable.bg_forum_source_gray);
        }
        if (this.cbw.getVisibility() == 0) {
            this.cbw.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.cbx = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VK = bgVar;
        if (StringUtils.isNull(this.VK.adA()) || this.cbx) {
            this.caL.setVisibility(8);
        } else {
            this.caL.setText(ap.j(this.VK.adA(), 10, "...") + getResources().getString(R.string.forum));
            this.caL.setVisibility(0);
        }
        this.cbw.setData(this.VK);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbw.setForumAfterClickListener(onClickListener);
        this.bZt = onClickListener;
    }

    public void setFrom(int i) {
        this.cbw.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.cbw.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.cbw.caC = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.cbw.setStType(str);
    }
}
