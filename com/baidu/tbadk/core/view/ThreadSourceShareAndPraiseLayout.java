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
    private View.OnClickListener eWC;
    public TextView eWM;
    public ThreadCommentAndPraiseInfoLayout eXx;
    private boolean eXy;
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
            this.eWM = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.eXx = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eWM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.agx != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.agx.bmE())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.agx.bmE(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eWC != null) {
                            ThreadSourceShareAndPraiseLayout.this.eWC.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.eXy) {
            ap.setViewTextColor(this.eWM, R.color.cp_cont_d);
            ap.setBackgroundResource(this.eWM, R.drawable.bg_forum_source_gray);
        }
        if (this.eXx.getVisibility() == 0) {
            this.eXx.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.eXy = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agx = bwVar;
        if (StringUtils.isNull(this.agx.bmE()) || this.eXy) {
            this.eWM.setVisibility(8);
        } else {
            this.eWM.setText(at.cutChineseAndEnglishWithSuffix(this.agx.bmE(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eWM.setVisibility(0);
        }
        this.eXx.setData(this.agx);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eXx.setForumAfterClickListener(onClickListener);
        this.eWC = onClickListener;
    }

    public void setFrom(int i) {
        this.eXx.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.eXx.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.eXx.eWz = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.eXx.setStType(str);
    }
}
