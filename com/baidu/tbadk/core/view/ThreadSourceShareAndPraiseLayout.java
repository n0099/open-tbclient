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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bk aee;
    public TextView dWI;
    private View.OnClickListener dWy;
    public ThreadCommentAndPraiseInfoLayout dXt;
    private boolean dXu;
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
            this.dWI = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.dXt = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.dWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aee != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aee.aQC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aee.aQC(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.dWy != null) {
                            ThreadSourceShareAndPraiseLayout.this.dWy.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.dXu) {
            am.setViewTextColor(this.dWI, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.dWI, R.drawable.bg_forum_source_gray);
        }
        if (this.dXt.getVisibility() == 0) {
            this.dXt.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.dXu = z;
    }

    public boolean setData(bk bkVar) {
        if (bkVar == null) {
            setVisibility(8);
            return false;
        }
        this.aee = bkVar;
        if (StringUtils.isNull(this.aee.aQC()) || this.dXu) {
            this.dWI.setVisibility(8);
        } else {
            this.dWI.setText(aq.cutChineseAndEnglishWithSuffix(this.aee.aQC(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.dWI.setVisibility(0);
        }
        this.dXt.setData(this.aee);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dXt.setForumAfterClickListener(onClickListener);
        this.dWy = onClickListener;
    }

    public void setFrom(int i) {
        this.dXt.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.dXt.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.dXt.dWv = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.dXt.setStType(str);
    }
}
