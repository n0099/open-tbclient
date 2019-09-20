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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bh Wd;
    private View.OnClickListener cbv;
    public TextView ccP;
    public ThreadCommentAndPraiseInfoNewTypeLayout cdA;
    private boolean cdB;
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
            this.ccP = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.cdA = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.ccP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.Wd != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.Wd.aeH())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.Wd.aeH(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.cbv != null) {
                            ThreadSourceShareAndPraiseLayout.this.cbv.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.cdB) {
            am.j(this.ccP, R.color.cp_cont_d);
            am.k(this.ccP, R.drawable.bg_forum_source_gray);
        }
        if (this.cdA.getVisibility() == 0) {
            this.cdA.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.cdB = z;
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Wd = bhVar;
        if (StringUtils.isNull(this.Wd.aeH()) || this.cdB) {
            this.ccP.setVisibility(8);
        } else {
            this.ccP.setText(aq.j(this.Wd.aeH(), 10, "...") + getResources().getString(R.string.forum));
            this.ccP.setVisibility(0);
        }
        this.cdA.setData(this.Wd);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cdA.setForumAfterClickListener(onClickListener);
        this.cbv = onClickListener;
    }

    public void setFrom(int i) {
        this.cdA.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.cdA.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.cdA.ccG = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.cdA.setStType(str);
    }
}
