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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ThreadSourceShareAndPraiseLayout extends RelativeLayout {
    private bw afL;
    public ThreadCommentAndPraiseInfoLayout euY;
    private boolean euZ;
    private View.OnClickListener eud;
    public TextView eun;
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
            this.eun = (TextView) inflate.findViewById(R.id.view_forum_source);
            this.euY = (ThreadCommentAndPraiseInfoLayout) inflate.findViewById(R.id.layout_share_and_praise);
            this.eun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadSourceShareAndPraiseLayout.this.afL != null && !StringUtils.isNull(ThreadSourceShareAndPraiseLayout.this.afL.beI())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadSourceShareAndPraiseLayout.this.mContext).createNormalCfg(ThreadSourceShareAndPraiseLayout.this.afL.beI(), ThreadSourceShareAndPraiseLayout.this.stType)));
                        if (ThreadSourceShareAndPraiseLayout.this.eud != null) {
                            ThreadSourceShareAndPraiseLayout.this.eud.onClick(view);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        if (!this.euZ) {
            ap.setViewTextColor(this.eun, R.color.cp_cont_d);
            ap.setBackgroundResource(this.eun, R.drawable.bg_forum_source_gray);
        }
        if (this.euY.getVisibility() == 0) {
            this.euY.onChangeSkinType();
        }
    }

    public void setHideBarName(boolean z) {
        this.euZ = z;
    }

    public boolean setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return false;
        }
        this.afL = bwVar;
        if (StringUtils.isNull(this.afL.beI()) || this.euZ) {
            this.eun.setVisibility(8);
        } else {
            this.eun.setText(at.cutChineseAndEnglishWithSuffix(this.afL.beI(), 10, StringHelper.STRING_MORE) + getResources().getString(R.string.forum));
            this.eun.setVisibility(0);
        }
        this.euY.setData(this.afL);
        setVisibility(0);
        return true;
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.euY.setForumAfterClickListener(onClickListener);
        this.eud = onClickListener;
    }

    public void setFrom(int i) {
        this.euY.setFrom(i);
    }

    public void setShareReportFrom(int i) {
        this.euY.setShareReportFrom(i);
    }

    public void setSourceFromForPb(int i) {
        this.euY.eua = i;
    }

    public void setStType(String str) {
        this.stType = str;
        this.euY.setStType(str);
    }
}
