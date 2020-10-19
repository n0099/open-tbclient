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
    private bw agw;
    public TextView eIB;
    private View.OnClickListener eIr;
    public ThreadCommentAndPraiseInfoLayout eJm;
    private boolean eJn;
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
            this.eIB = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.eJm = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eIB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.agw != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.agw.bil())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.agw.bil(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eIr != null) {
                            ThreadSourceShareAndPraiseLayout.this.eIr.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.eJn) {
            ap.setViewTextColor(this.eIB, R.color.cp_cont_d);
            ap.setBackgroundResource(this.eIB, R.drawable.bg_forum_source_gray);
        }
        if (this.eJm.getVisibility() == 0) {
            this.eJm.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.eJn = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agw = bwVar;
        if (StringUtils.isNull(this.agw.bil()) || this.eJn) {
            this.eIB.setVisibility(8);
        } else {
            this.eIB.setText(at.cutChineseAndEnglishWithSuffix(this.agw.bil(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eIB.setVisibility(0);
        }
        this.eJm.setData(this.agw);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.eJm.setForumAfterClickListener(onClickListener);
        this.eIr = onClickListener;
    }

    public void setFrom(int i) {
        this.eJm.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.eJm.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.eJm.eIo = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.eJm.setStType(str);
    }
}
