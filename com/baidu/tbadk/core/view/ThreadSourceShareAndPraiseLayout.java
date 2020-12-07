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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private by ahA;
    private View.OnClickListener fdj;
    public TextView fdq;
    public ThreadCommentAndPraiseInfoLayout feb;
    private boolean fec;
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
            this.fdq = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.feb = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.fdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.ahA != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.ahA.boT())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.ahA.boT(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.fdj != null) {
                            ThreadSourceShareAndPraiseLayout.this.fdj.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.fec) {
            ap.setViewTextColor(this.fdq, R.color.CAM_X0109);
            ap.setBackgroundResource(this.fdq, R.drawable.bg_forum_source_gray);
        }
        if (this.feb.getVisibility() == 0) {
            this.feb.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.fec = z;
    }

    public boolean setData(by byVar) {
        if (byVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahA = byVar;
        if (StringUtils.isNull(this.ahA.boT()) || this.fec) {
            this.fdq.setVisibility(8);
        } else {
            this.fdq.setText(au.cutChineseAndEnglishWithSuffix(this.ahA.boT(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.fdq.setVisibility(0);
        }
        this.feb.setData(this.ahA);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.feb.setForumAfterClickListener(onClickListener);
        this.fdj = onClickListener;
    }

    public void setFrom(int i) {
        this.feb.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.feb.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.feb.fdg = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.feb.setStType(str);
    }
}
