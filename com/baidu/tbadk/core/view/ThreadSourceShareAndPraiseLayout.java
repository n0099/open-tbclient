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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private cb ahi;
    public TextView fkH;
    private View.OnClickListener fkz;
    public ThreadCommentAndPraiseInfoLayout fls;
    private boolean flt;
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
            this.fkH = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.fls = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.fkH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.ahi != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.ahi.bnU())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.ahi.bnU(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.fkz != null) {
                            ThreadSourceShareAndPraiseLayout.this.fkz.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.flt) {
            ap.setViewTextColor(this.fkH, R.color.CAM_X0109);
            ap.setBackgroundResource(this.fkH, R.drawable.bg_forum_source_gray);
        }
        if (this.fls.getVisibility() == 0) {
            this.fls.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.flt = z;
    }

    public boolean setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return false;
        }
        this.ahi = cbVar;
        if (StringUtils.isNull(this.ahi.bnU()) || this.flt) {
            this.fkH.setVisibility(8);
        } else {
            this.fkH.setText(au.cutChineseAndEnglishWithSuffix(this.ahi.bnU(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.fkH.setVisibility(0);
        }
        this.fls.setData(this.ahi);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.fls.setForumAfterClickListener(onClickListener);
        this.fkz = onClickListener;
    }

    public void setFrom(int i) {
        this.fls.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.fls.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.fls.fkw = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.fls.setStType(str);
    }
}
