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
    private View.OnClickListener dhW;
    public ThreadCommentAndPraiseInfoLayout diU;
    private boolean diV;
    public TextView dih;
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
            this.dih = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.diU = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.dih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.KJ != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.KJ.aCt())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.KJ.aCt(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.dhW != null) {
                            ThreadSourceShareAndPraiseLayout.this.dhW.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.diV) {
            am.setViewTextColor(this.dih, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.dih, R.drawable.bg_forum_source_gray);
        }
        if (this.diU.getVisibility() == 0) {
            this.diU.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.diV = z;
    }

    public boolean setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.KJ = bjVar;
        if (StringUtils.isNull(this.KJ.aCt()) || this.diV) {
            this.dih.setVisibility(8);
        } else {
            this.dih.setText(aq.cutChineseAndEnglishWithSuffix(this.KJ.aCt(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.dih.setVisibility(0);
        }
        this.diU.setData(this.KJ);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.diU.setForumAfterClickListener(onClickListener);
        this.dhW = onClickListener;
    }

    public void setFrom(int i) {
        this.diU.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.diU.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.diU.dhT = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.diU.setStType(str);
    }
}
