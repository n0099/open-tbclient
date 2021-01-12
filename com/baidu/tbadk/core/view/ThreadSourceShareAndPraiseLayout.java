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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bz ahu;
    private View.OnClickListener fih;
    public TextView fio;
    public ThreadCommentAndPraiseInfoLayout fjb;
    private boolean fjc;
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
            this.fio = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.fjb = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.fio.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.ahu != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.ahu.bnB())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.ahu.bnB(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.fih != null) {
                            ThreadSourceShareAndPraiseLayout.this.fih.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.fjc) {
            ao.setViewTextColor(this.fio, R.color.CAM_X0109);
            ao.setBackgroundResource(this.fio, R.drawable.bg_forum_source_gray);
        }
        if (this.fjb.getVisibility() == 0) {
            this.fjb.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.fjc = z;
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahu = bzVar;
        if (StringUtils.isNull(this.ahu.bnB()) || this.fjc) {
            this.fio.setVisibility(8);
        } else {
            this.fio.setText(at.cutChineseAndEnglishWithSuffix(this.ahu.bnB(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.fio.setVisibility(0);
        }
        this.fjb.setData(this.ahu);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fjb.setForumAfterClickListener(onClickListener);
        this.fih = onClickListener;
    }

    public void setFrom(int i) {
        this.fjb.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.fjb.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.fjb.fie = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.fjb.setStType(str);
    }
}
