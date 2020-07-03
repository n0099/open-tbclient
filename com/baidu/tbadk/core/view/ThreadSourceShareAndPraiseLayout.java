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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bu aeK;
    private View.OnClickListener edU;
    public ThreadCommentAndPraiseInfoLayout eeP;
    private boolean eeQ;
    public TextView eee;
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
            this.eee = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.eeP = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eee.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aeK != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aeK.aSt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aeK.aSt(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.edU != null) {
                            ThreadSourceShareAndPraiseLayout.this.edU.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.eeQ) {
            an.setViewTextColor(this.eee, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.eee, R.drawable.bg_forum_source_gray);
        }
        if (this.eeP.getVisibility() == 0) {
            this.eeP.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.eeQ = z;
    }

    public boolean setData(bu buVar) {
        if (buVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeK = buVar;
        if (StringUtils.isNull(this.aeK.aSt()) || this.eeQ) {
            this.eee.setVisibility(8);
        } else {
            this.eee.setText(ar.cutChineseAndEnglishWithSuffix(this.aeK.aSt(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eee.setVisibility(0);
        }
        this.eeP.setData(this.aeK);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eeP.setForumAfterClickListener(onClickListener);
        this.edU = onClickListener;
    }

    public void setFrom(int i) {
        this.eeP.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.eeP.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.eeP.edR = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.eeP.setStType(str);
    }
}
