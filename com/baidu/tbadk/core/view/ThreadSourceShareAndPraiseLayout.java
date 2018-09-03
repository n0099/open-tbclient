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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bb atE;
    private View.OnClickListener axw;
    public TextView ayn;
    public ThreadCommentAndPraiseInfoNewTypeLayout ayo;
    private boolean ayp;
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
            View inflate = LayoutInflater.from(context).inflate(f.h.thread_comment_praise_read_info_layout, (ViewGroup) this, true);
            this.ayn = (TextView) inflate.findViewById(f.g.view_forum_source);
            this.ayo = (ThreadCommentAndPraiseInfoNewTypeLayout) inflate.findViewById(f.g.layout_share_and_praise);
            this.ayn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.atE != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.atE.vp())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.atE.vp(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.axw != null) {
                            ThreadSourceShareAndPraiseLayout.this.axw.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.ayp) {
            am.h(this.ayn, f.d.cp_cont_d);
            am.i(this.ayn, f.C0146f.bg_forum_source_gray);
        }
        if (this.ayo.getVisibility() == 0) {
            this.ayo.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.ayp = z;
    }

    public boolean setData(bb bbVar) {
        if (bbVar == null) {
            setVisibility(8);
            return false;
        }
        this.atE = bbVar;
        if (StringUtils.isNull(this.atE.vp()) || this.ayp) {
            this.ayn.setVisibility(8);
        } else {
            this.ayn.setText(ap.d(this.atE.vp(), 10, "...") + getResources().getString(f.j.forum));
            this.ayn.setVisibility(0);
        }
        this.ayo.setData(this.atE);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ayo.setForumAfterClickListener(onClickListener);
        this.axw = onClickListener;
    }

    public void setFrom(int i) {
        this.ayo.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.ayo.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.ayo.ajY = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.ayo.setStType(str);
    }
}
