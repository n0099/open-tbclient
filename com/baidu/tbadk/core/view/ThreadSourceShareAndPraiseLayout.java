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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bw agx;
    private View.OnClickListener eQN;
    public TextView eQX;
    public ThreadCommentAndPraiseInfoLayout eRI;
    private boolean eRJ;
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
            this.eQX = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.eRI = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eQX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.agx != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.agx.bke())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.agx.bke(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eQN != null) {
                            ThreadSourceShareAndPraiseLayout.this.eQN.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.eRJ) {
            ap.setViewTextColor(this.eQX, R.color.cp_cont_d);
            ap.setBackgroundResource(this.eQX, R.drawable.bg_forum_source_gray);
        }
        if (this.eRI.getVisibility() == 0) {
            this.eRI.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.eRJ = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agx = bwVar;
        if (StringUtils.isNull(this.agx.bke()) || this.eRJ) {
            this.eQX.setVisibility(8);
        } else {
            this.eQX.setText(at.cutChineseAndEnglishWithSuffix(this.agx.bke(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eQX.setVisibility(0);
        }
        this.eRI.setData(this.agx);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eRI.setForumAfterClickListener(onClickListener);
        this.eQN = onClickListener;
    }

    public void setFrom(int i) {
        this.eRI.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.eRI.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.eRI.eQK = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.eRI.setStType(str);
    }
}
