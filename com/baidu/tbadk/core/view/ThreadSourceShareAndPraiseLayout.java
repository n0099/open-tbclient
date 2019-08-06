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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bh We;
    private View.OnClickListener caC;
    public TextView cbV;
    public ThreadCommentAndPraiseInfoNewTypeLayout ccH;
    private boolean ccI;
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
            this.cbV = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.ccH = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.cbV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.We != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.We.aeD())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.We.aeD(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.caC != null) {
                            ThreadSourceShareAndPraiseLayout.this.caC.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ccI) {
            am.j(this.cbV, R.color.cp_cont_d);
            am.k(this.cbV, R.drawable.bg_forum_source_gray);
        }
        if (this.ccH.getVisibility() == 0) {
            this.ccH.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ccI = z;
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bhVar;
        if (StringUtils.isNull(this.We.aeD()) || this.ccI) {
            this.cbV.setVisibility(8);
        } else {
            this.cbV.setText(aq.j(this.We.aeD(), 10, "...") + getResources().getString(R.string.forum));
            this.cbV.setVisibility(0);
        }
        this.ccH.setData(this.We);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ccH.setForumAfterClickListener(onClickListener);
        this.caC = onClickListener;
    }

    public void setFrom(int i) {
        this.ccH.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ccH.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ccH.cbM = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ccH.setStType(str);
    }
}
