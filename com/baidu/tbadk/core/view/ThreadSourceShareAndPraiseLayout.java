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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bh Fs;
    private View.OnClickListener coV;
    public ThreadCommentAndPraiseInfoNewTypeLayout cqW;
    private boolean cqX;
    public TextView cql;
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
            this.cql = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.cqW = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.cql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.Fs != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.Fs.aiJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.Fs.aiJ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.coV != null) {
                            ThreadSourceShareAndPraiseLayout.this.coV.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.cqX) {
            am.setViewTextColor(this.cql, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.cql, R.drawable.bg_forum_source_gray);
        }
        if (this.cqW.getVisibility() == 0) {
            this.cqW.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.cqX = z;
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.Fs = bhVar;
        if (StringUtils.isNull(this.Fs.aiJ()) || this.cqX) {
            this.cql.setVisibility(8);
        } else {
            this.cql.setText(aq.cutChineseAndEnglishWithSuffix(this.Fs.aiJ(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.cql.setVisibility(0);
        }
        this.cqW.setData(this.Fs);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.cqW.setForumAfterClickListener(onClickListener);
        this.coV = onClickListener;
    }

    public void setFrom(int i) {
        this.cqW.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.cqW.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.cqW.cqc = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.cqW.setStType(str);
    }
}
