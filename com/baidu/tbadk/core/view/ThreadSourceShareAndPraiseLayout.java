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
    private bz aim;
    private View.OnClickListener fmS;
    public TextView fmZ;
    public ThreadCommentAndPraiseInfoLayout fnK;
    private boolean fnL;
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
            this.fmZ = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.fnK = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.fmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.aim != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.aim.brv())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.aim.brv(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.fmS != null) {
                            ThreadSourceShareAndPraiseLayout.this.fmS.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.fnL) {
            ao.setViewTextColor(this.fmZ, R.color.CAM_X0109);
            ao.setBackgroundResource(this.fmZ, R.drawable.bg_forum_source_gray);
        }
        if (this.fnK.getVisibility() == 0) {
            this.fnK.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.fnL = z;
    }

    public boolean setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return false;
        }
        this.aim = bzVar;
        if (StringUtils.isNull(this.aim.brv()) || this.fnL) {
            this.fmZ.setVisibility(8);
        } else {
            this.fmZ.setText(at.cutChineseAndEnglishWithSuffix(this.aim.brv(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.fmZ.setVisibility(0);
        }
        this.fnK.setData(this.aim);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fnK.setForumAfterClickListener(onClickListener);
        this.fmS = onClickListener;
    }

    public void setFrom(int i) {
        this.fnK.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.fnK.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.fnK.fmP = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.fnK.setStType(str);
    }
}
