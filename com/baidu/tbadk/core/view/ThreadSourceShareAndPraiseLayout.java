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
    private bg VJ;
    private View.OnClickListener bZu;
    public TextView caM;
    public ThreadCommentAndPraiseInfoNewTypeLayout cbx;
    private boolean cby;
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
            this.caM = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.cbx = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.caM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.VJ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.VJ.adA())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.VJ.adA(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bZu != null) {
                            ThreadSourceShareAndPraiseLayout.this.bZu.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.cby) {
            al.j(this.caM, R.color.cp_cont_d);
            al.k(this.caM, R.drawable.bg_forum_source_gray);
        }
        if (this.cbx.getVisibility() == 0) {
            this.cbx.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.cby = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.VJ = bgVar;
        if (StringUtils.isNull(this.VJ.adA()) || this.cby) {
            this.caM.setVisibility(8);
        } else {
            this.caM.setText(ap.j(this.VJ.adA(), 10, "...") + getResources().getString(R.string.forum));
            this.caM.setVisibility(0);
        }
        this.cbx.setData(this.VJ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cbx.setForumAfterClickListener(onClickListener);
        this.bZu = onClickListener;
    }

    public void setFrom(int i) {
        this.cbx.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.cbx.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.cbx.caD = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.cbx.setStType(str);
    }
}
