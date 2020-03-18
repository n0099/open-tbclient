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
/* loaded from: classes8.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bj KJ;
    private View.OnClickListener dik;
    public TextView diw;
    public ThreadCommentAndPraiseInfoLayout djh;
    private boolean dji;
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
            this.diw = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.djh = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.diw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.KJ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.KJ.aCw())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.KJ.aCw(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.dik != null) {
                            ThreadSourceShareAndPraiseLayout.this.dik.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.dji) {
            am.setViewTextColor(this.diw, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.diw, R.drawable.bg_forum_source_gray);
        }
        if (this.djh.getVisibility() == 0) {
            this.djh.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.dji = z;
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.KJ = bjVar;
        if (StringUtils.isNull(this.KJ.aCw()) || this.dji) {
            this.diw.setVisibility(8);
        } else {
            this.diw.setText(aq.cutChineseAndEnglishWithSuffix(this.KJ.aCw(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.diw.setVisibility(0);
        }
        this.djh.setData(this.KJ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.djh.setForumAfterClickListener(onClickListener);
        this.dik = onClickListener;
    }

    public void setFrom(int i) {
        this.djh.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.djh.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.djh.dih = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.djh.setStType(str);
    }
}
