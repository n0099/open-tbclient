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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private cb aiB;
    private View.OnClickListener flY;
    public ThreadCommentAndPraiseInfoLayout fmS;
    private boolean fmT;
    public TextView fmg;
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
            this.fmg = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.fmS = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.fmg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aiB != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aiB.bnW())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aiB.bnW(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.flY != null) {
                            ThreadSourceShareAndPraiseLayout.this.flY.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.fmT) {
            ap.setViewTextColor(this.fmg, R.color.CAM_X0109);
            ap.setBackgroundResource(this.fmg, R.drawable.bg_forum_source_gray);
        }
        if (this.fmS.getVisibility() == 0) {
            this.fmS.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.fmT = z;
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiB = cbVar;
        if (StringUtils.isNull(this.aiB.bnW()) || this.fmT) {
            this.fmg.setVisibility(8);
        } else {
            this.fmg.setText(au.cutChineseAndEnglishWithSuffix(this.aiB.bnW(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.fmg.setVisibility(0);
        }
        this.fmS.setData(this.aiB);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fmS.setForumAfterClickListener(onClickListener);
        this.flY = onClickListener;
    }

    public void setFrom(int i) {
        this.fmS.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.fmS.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.fmS.flV = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.fmS.setStType(str);
    }
}
