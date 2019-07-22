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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bg We;
    private View.OnClickListener caw;
    public TextView cbO;
    public ThreadCommentAndPraiseInfoNewTypeLayout ccA;
    private boolean ccB;
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
            this.cbO = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.ccA = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.cbO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.We != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.We.aeC())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.We.aeC(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.caw != null) {
                            ThreadSourceShareAndPraiseLayout.this.caw.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ccB) {
            am.j(this.cbO, R.color.cp_cont_d);
            am.k(this.cbO, R.drawable.bg_forum_source_gray);
        }
        if (this.ccA.getVisibility() == 0) {
            this.ccA.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ccB = z;
    }

    public boolean setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return false;
        }
        this.We = bgVar;
        if (StringUtils.isNull(this.We.aeC()) || this.ccB) {
            this.cbO.setVisibility(8);
        } else {
            this.cbO.setText(aq.j(this.We.aeC(), 10, "...") + getResources().getString(R.string.forum));
            this.cbO.setVisibility(0);
        }
        this.ccA.setData(this.We);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ccA.setForumAfterClickListener(onClickListener);
        this.caw = onClickListener;
    }

    public void setFrom(int i) {
        this.ccA.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ccA.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ccA.cbF = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ccA.setStType(str);
    }
}
