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
/* loaded from: classes15.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bw afJ;
    private View.OnClickListener etZ;
    public ThreadCommentAndPraiseInfoLayout euU;
    private boolean euV;
    public TextView euj;
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
            this.euj = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.euU = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.euj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.afJ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.afJ.beI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.afJ.beI(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.etZ != null) {
                            ThreadSourceShareAndPraiseLayout.this.etZ.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.euV) {
            ap.setViewTextColor(this.euj, R.color.cp_cont_d);
            ap.setBackgroundResource(this.euj, R.drawable.bg_forum_source_gray);
        }
        if (this.euU.getVisibility() == 0) {
            this.euU.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.euV = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.afJ = bwVar;
        if (StringUtils.isNull(this.afJ.beI()) || this.euV) {
            this.euj.setVisibility(8);
        } else {
            this.euj.setText(at.cutChineseAndEnglishWithSuffix(this.afJ.beI(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.euj.setVisibility(0);
        }
        this.euU.setData(this.afJ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.euU.setForumAfterClickListener(onClickListener);
        this.etZ = onClickListener;
    }

    public void setFrom(int i) {
        this.euU.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.euU.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.euU.etW = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.euU.setStType(str);
    }
}
