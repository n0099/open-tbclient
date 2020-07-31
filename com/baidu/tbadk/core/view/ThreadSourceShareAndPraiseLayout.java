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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bv aeA;
    public ThreadCommentAndPraiseInfoLayout ekZ;
    private View.OnClickListener eke;
    public TextView eko;
    private boolean ela;
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
            this.eko = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.ekZ = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aeA != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aeA.aWp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aeA.aWp(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eke != null) {
                            ThreadSourceShareAndPraiseLayout.this.eke.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ela) {
            ao.setViewTextColor(this.eko, R.color.cp_cont_d);
            ao.setBackgroundResource(this.eko, R.drawable.bg_forum_source_gray);
        }
        if (this.ekZ.getVisibility() == 0) {
            this.ekZ.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ela = z;
    }

    public boolean setData(bv bvVar) {
        if (bvVar == null) {
            setVisibility(8);
            return false;
        }
        this.aeA = bvVar;
        if (StringUtils.isNull(this.aeA.aWp()) || this.ela) {
            this.eko.setVisibility(8);
        } else {
            this.eko.setText(as.cutChineseAndEnglishWithSuffix(this.aeA.aWp(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eko.setVisibility(0);
        }
        this.ekZ.setData(this.aeA);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ekZ.setForumAfterClickListener(onClickListener);
        this.eke = onClickListener;
    }

    public void setFrom(int i) {
        this.ekZ.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ekZ.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ekZ.ekb = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ekZ.setStType(str);
    }
}
