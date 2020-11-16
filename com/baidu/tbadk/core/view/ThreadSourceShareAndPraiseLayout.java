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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bx agB;
    private View.OnClickListener eVM;
    public TextView eVT;
    public ThreadCommentAndPraiseInfoLayout eWE;
    private boolean eWF;
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
            this.eVT = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.eWE = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eVT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.agB != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.agB.blG())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.agB.blG(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eVM != null) {
                            ThreadSourceShareAndPraiseLayout.this.eVM.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.eWF) {
            ap.setViewTextColor(this.eVT, R.color.CAM_X0109);
            ap.setBackgroundResource(this.eVT, R.drawable.bg_forum_source_gray);
        }
        if (this.eWE.getVisibility() == 0) {
            this.eWE.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.eWF = z;
    }

    public boolean setData(bx bxVar) {
        if (bxVar == null) {
            setVisibility(8);
            return false;
        }
        this.agB = bxVar;
        if (StringUtils.isNull(this.agB.blG()) || this.eWF) {
            this.eVT.setVisibility(8);
        } else {
            this.eVT.setText(au.cutChineseAndEnglishWithSuffix(this.agB.blG(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eVT.setVisibility(0);
        }
        this.eWE.setData(this.agB);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eWE.setForumAfterClickListener(onClickListener);
        this.eVM = onClickListener;
    }

    public void setFrom(int i) {
        this.eWE.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.eWE.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.eWE.eVJ = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.eWE.setStType(str);
    }
}
