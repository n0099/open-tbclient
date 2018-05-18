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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bd alf;
    private View.OnClickListener aoY;
    public TextView apF;
    public ThreadCommentAndPraiseInfoNewTypeLayout apG;
    private boolean apH;
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
            View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.apF = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.apG = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.apF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (ThreadSourceShareAndPraiseLayout.this.alf != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.alf.rU())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.alf.rU(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.aoY != null) {
                            ThreadSourceShareAndPraiseLayout.this.aoY.onClick(view2);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.apH) {
            ak.h(this.apF, d.C0126d.cp_cont_d);
            ak.i(this.apF, d.f.bg_forum_source_gray);
        }
        if (this.apG.getVisibility() == 0) {
            this.apG.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.apH = z;
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.alf = bdVar;
        if (StringUtils.isNull(this.alf.rU()) || this.apH) {
            this.apF.setVisibility(8);
        } else {
            this.apF.setText(an.e(this.alf.rU(), 10, "...") + getResources().getString(d.k.forum));
            this.apF.setVisibility(0);
        }
        this.apG.setData(this.alf);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.apG.setForumAfterClickListener(onClickListener);
        this.aoY = onClickListener;
    }

    public void setFrom(int i) {
        this.apG.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.apG.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.apG.abW = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.apG.setStType(str);
    }
}
