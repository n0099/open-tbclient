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
    private bh FT;
    private View.OnClickListener cpN;
    public ThreadCommentAndPraiseInfoNewTypeLayout crO;
    private boolean crP;
    public TextView crd;
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
            this.crd = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.crO = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.crd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.FT != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.FT.aiL())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.FT.aiL(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.cpN != null) {
                            ThreadSourceShareAndPraiseLayout.this.cpN.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.crP) {
            am.setViewTextColor(this.crd, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.crd, R.drawable.bg_forum_source_gray);
        }
        if (this.crO.getVisibility() == 0) {
            this.crO.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.crP = z;
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.FT = bhVar;
        if (StringUtils.isNull(this.FT.aiL()) || this.crP) {
            this.crd.setVisibility(8);
        } else {
            this.crd.setText(aq.cutChineseAndEnglishWithSuffix(this.FT.aiL(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.crd.setVisibility(0);
        }
        this.crO.setData(this.FT);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.crO.setForumAfterClickListener(onClickListener);
        this.cpN = onClickListener;
    }

    public void setFrom(int i) {
        this.crO.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.crO.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.crO.cqT = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.crO.setStType(str);
    }
}
