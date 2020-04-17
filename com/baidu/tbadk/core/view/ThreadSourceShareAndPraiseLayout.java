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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bj adG;
    private View.OnClickListener dIf;
    public TextView dIp;
    public ThreadCommentAndPraiseInfoLayout dJa;
    private boolean dJb;
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
            this.dIp = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.dJa = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.dIp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.adG != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.adG.aKJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.adG.aKJ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.dIf != null) {
                            ThreadSourceShareAndPraiseLayout.this.dIf.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.dJb) {
            am.setViewTextColor(this.dIp, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.dIp, R.drawable.bg_forum_source_gray);
        }
        if (this.dJa.getVisibility() == 0) {
            this.dJa.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.dJb = z;
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.adG = bjVar;
        if (StringUtils.isNull(this.adG.aKJ()) || this.dJb) {
            this.dIp.setVisibility(8);
        } else {
            this.dIp.setText(aq.cutChineseAndEnglishWithSuffix(this.adG.aKJ(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.dIp.setVisibility(0);
        }
        this.dJa.setData(this.adG);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dJa.setForumAfterClickListener(onClickListener);
        this.dIf = onClickListener;
    }

    public void setFrom(int i) {
        this.dJa.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.dJa.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.dJa.dIc = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.dJa.setStType(str);
    }
}
