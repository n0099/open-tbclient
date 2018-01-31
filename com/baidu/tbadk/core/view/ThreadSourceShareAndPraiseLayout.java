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
    private bd aYc;
    private View.OnClickListener bbZ;
    public TextView bcH;
    public ThreadCommentAndPraiseInfoNewTypeLayout bcI;
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
            this.bcH = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.bcI = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.bcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aYc != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aYc.yZ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aYc.yZ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.bbZ != null) {
                            ThreadSourceShareAndPraiseLayout.this.bbZ.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        aj.r(this.bcH, d.C0108d.thread_card_forum_source_color);
        aj.s(this.bcH, d.f.bg_forum_source_gray);
        this.bcI.onChangeSkinType();
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.aYc = bdVar;
        if (StringUtils.isNull(this.aYc.yZ())) {
            this.bcH.setVisibility(8);
        } else {
            this.bcH.setText(am.e(this.aYc.yZ(), 10, "...") + getResources().getString(d.j.forum));
            this.bcH.setVisibility(0);
        }
        this.bcI.setData(this.aYc);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.bcI.setForumAfterClickListener(onClickListener);
        this.bbZ = onClickListener;
    }

    public void setFrom(int i) {
        this.bcI.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.bcI.setShareReportFrom(i);
    }

    public void setStType(String str) {
        this.stType = str;
        this.bcI.setStType(str);
    }
}
