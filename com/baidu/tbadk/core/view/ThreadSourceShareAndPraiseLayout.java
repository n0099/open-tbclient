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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bd atn;
    public TextView axM;
    public ThreadCommentAndPraiseInfoNewTypeLayout axN;
    private boolean axO;
    private View.OnClickListener axg;
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
            View inflate = LayoutInflater.from(context).inflate(d.i.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.axM = (TextView) inflate.findViewById(d.g.view_forum_source);
            this.axN = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(d.g.layout_share_and_praise);
            this.axM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.atn != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.atn.vr())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.atn.vr(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.axg != null) {
                            ThreadSourceShareAndPraiseLayout.this.axg.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.axO) {
            al.h(this.axM, d.C0141d.cp_cont_d);
            al.i(this.axM, d.f.bg_forum_source_gray);
        }
        if (this.axN.getVisibility() == 0) {
            this.axN.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.axO = z;
    }

    public boolean setData(bd bdVar) {
        if (bdVar == null) {
            setVisibility(8);
            return false;
        }
        this.atn = bdVar;
        if (StringUtils.isNull(this.atn.vr()) || this.axO) {
            this.axM.setVisibility(8);
        } else {
            this.axM.setText(ao.e(this.atn.vr(), 10, "...") + getResources().getString(d.k.forum));
            this.axM.setVisibility(0);
        }
        this.axN.setData(this.atn);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.axN.setForumAfterClickListener(onClickListener);
        this.axg = onClickListener;
    }

    public void setFrom(int i) {
        this.axN.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.axN.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.axN.aka = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.axN.setStType(str);
    }
}
