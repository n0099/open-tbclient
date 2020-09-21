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
/* loaded from: classes20.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bw agf;
    private View.OnClickListener ewh;
    public TextView ewr;
    public ThreadCommentAndPraiseInfoLayout exc;
    private boolean exd;
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
            this.ewr = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.exc = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.ewr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.agf != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.agf.bfC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.agf.bfC(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.ewh != null) {
                            ThreadSourceShareAndPraiseLayout.this.ewh.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.exd) {
            ap.setViewTextColor(this.ewr, R.color.cp_cont_d);
            ap.setBackgroundResource(this.ewr, R.drawable.bg_forum_source_gray);
        }
        if (this.exc.getVisibility() == 0) {
            this.exc.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.exd = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.agf = bwVar;
        if (StringUtils.isNull(this.agf.bfC()) || this.exd) {
            this.ewr.setVisibility(8);
        } else {
            this.ewr.setText(at.cutChineseAndEnglishWithSuffix(this.agf.bfC(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.ewr.setVisibility(0);
        }
        this.exc.setData(this.agf);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.exc.setForumAfterClickListener(onClickListener);
        this.ewh = onClickListener;
    }

    public void setFrom(int i) {
        this.exc.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.exc.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.exc.ewe = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.exc.setStType(str);
    }
}
