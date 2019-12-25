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
/* loaded from: classes5.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bj Ki;
    public TextView ddE;
    private View.OnClickListener ddt;
    public ThreadCommentAndPraiseInfoLayout dep;
    private boolean deq;
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
            this.ddE = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.dep = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.ddE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.Ki != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.Ki.azJ())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.Ki.azJ(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.ddt != null) {
                            ThreadSourceShareAndPraiseLayout.this.ddt.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.deq) {
            am.setViewTextColor(this.ddE, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ddE, R.drawable.bg_forum_source_gray);
        }
        if (this.dep.getVisibility() == 0) {
            this.dep.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.deq = z;
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.Ki = bjVar;
        if (StringUtils.isNull(this.Ki.azJ()) || this.deq) {
            this.ddE.setVisibility(8);
        } else {
            this.ddE.setText(aq.cutChineseAndEnglishWithSuffix(this.Ki.azJ(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.ddE.setVisibility(0);
        }
        this.dep.setData(this.Ki);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.dep.setForumAfterClickListener(onClickListener);
        this.ddt = onClickListener;
    }

    public void setFrom(int i) {
        this.dep.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.dep.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.dep.ddq = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.dep.setStType(str);
    }
}
