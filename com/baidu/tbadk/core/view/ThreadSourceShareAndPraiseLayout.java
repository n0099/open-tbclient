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
/* loaded from: classes6.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bj Kn;
    private View.OnClickListener ddE;
    public TextView ddO;
    public ThreadCommentAndPraiseInfoLayout deA;
    private boolean deB;
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
            this.ddO = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.deA = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.ddO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.Kn != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.Kn.aAc())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.Kn.aAc(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.ddE != null) {
                            ThreadSourceShareAndPraiseLayout.this.ddE.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.deB) {
            am.setViewTextColor(this.ddO, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ddO, R.drawable.bg_forum_source_gray);
        }
        if (this.deA.getVisibility() == 0) {
            this.deA.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.deB = z;
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.Kn = bjVar;
        if (StringUtils.isNull(this.Kn.aAc()) || this.deB) {
            this.ddO.setVisibility(8);
        } else {
            this.ddO.setText(aq.cutChineseAndEnglishWithSuffix(this.Kn.aAc(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.ddO.setVisibility(0);
        }
        this.deA.setData(this.Kn);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.deA.setForumAfterClickListener(onClickListener);
        this.ddE = onClickListener;
    }

    public void setFrom(int i) {
        this.deA.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.deA.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.deA.ddB = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.deA.setStType(str);
    }
}
