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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bc atZ;
    private View.OnClickListener axT;
    public TextView ayD;
    public ThreadCommentAndPraiseInfoNewTypeLayout ayE;
    private boolean ayF;
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
            this.ayD = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.ayE = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.ayD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.atZ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.atZ.vB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.atZ.vB(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.axT != null) {
                            ThreadSourceShareAndPraiseLayout.this.axT.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ayF) {
            am.h(this.ayD, d.C0142d.cp_cont_d);
            am.i(this.ayD, d.f.bg_forum_source_gray);
        }
        if (this.ayE.getVisibility() == 0) {
            this.ayE.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ayF = z;
    }

    public boolean setData(bc bcVar) {
        if (bcVar == null) {
            setVisibility(8);
            return false;
        }
        this.atZ = bcVar;
        if (StringUtils.isNull(this.atZ.vB()) || this.ayF) {
            this.ayD.setVisibility(8);
        } else {
            this.ayD.setText(ap.e(this.atZ.vB(), 10, "...") + getResources().getString(d.k.forum));
            this.ayD.setVisibility(0);
        }
        this.ayE.setData(this.atZ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ayE.setForumAfterClickListener(onClickListener);
        this.axT = onClickListener;
    }

    public void setFrom(int i) {
        this.ayE.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ayE.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ayE.akz = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ayE.setStType(str);
    }
}
