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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bd aXU;
    private View.OnClickListener bbR;
    public ThreadCommentAndPraiseInfoNewTypeLayout bcA;
    public TextView bcz;
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
            this.bcz = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bcA = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bcz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aXU != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aXU.yY())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aXU.yY(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bbR != null) {
                            ThreadSourceShareAndPraiseLayout.this.bbR.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bcz, d.C0107d.thread_card_forum_source_color);
        aj.s(this.bcz, d.f.bg_forum_source_gray);
        this.bcA.onChangeSkinType();
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aXU = bdVar;
        if (StringUtils.isNull(this.aXU.yY())) {
            this.bcz.setVisibility(8);
        } else {
            this.bcz.setText(am.e(this.aXU.yY(), 10, "...") + getResources().getString(d.j.forum));
            this.bcz.setVisibility(0);
        }
        this.bcA.setData(this.aXU);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bcA.setForumAfterClickListener(onClickListener);
        this.bbR = onClickListener;
    }

    public void setFrom(int i) {
        this.bcA.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bcA.setShareReportFrom(i);
    }

    public void setStType(String str) {
        this.stType = str;
        this.bcA.setStType(str);
    }
}
