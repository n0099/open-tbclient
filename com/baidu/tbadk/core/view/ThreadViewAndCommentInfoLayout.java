package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView eGx;
    public int fie;
    private TextView fjq;
    private boolean fjr;
    private boolean fjs;
    private boolean fjt;
    private boolean fju;
    private boolean fjv;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.fjr = false;
        this.fjs = false;
        this.fjt = false;
        this.fju = false;
        this.fjv = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fjr = false;
        this.fjs = false;
        this.fjt = false;
        this.fju = false;
        this.fjv = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.fjq = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eGx = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bz bzVar) {
        if (bzVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        M(bzVar);
        N(bzVar);
        O(bzVar);
        P(bzVar);
        B(bzVar);
    }

    private void M(bz bzVar) {
        if (this.fjq != null && bzVar != null && this.fjt && bzVar.bnQ() != null && bzVar.boU()) {
            this.fjq.setVisibility(0);
            this.fjq.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bzVar.bnQ().audience_count)));
        }
    }

    private void N(bz bzVar) {
        if (this.fjq != null && bzVar != null && this.fjr) {
            if (bzVar.bnp() >= 0) {
                this.fjq.setVisibility(0);
                this.fjq.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bzVar.bnp())));
                return;
            }
            this.fjq.setVisibility(8);
        }
    }

    private void O(bz bzVar) {
        if (this.eGx != null && bzVar != null && this.fjs) {
            if (bzVar.bno() >= 0) {
                this.eGx.setVisibility(0);
                this.eGx.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bzVar.bno())));
                return;
            }
            this.eGx.setVisibility(8);
        }
    }

    private void P(bz bzVar) {
        if (this.eGx != null && bzVar != null && this.fju && bzVar.boU()) {
            this.eGx.setVisibility(0);
            this.eGx.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bzVar.boY())));
        }
    }

    private void B(bz bzVar) {
        if (this.eGx != null && bzVar != null && this.fjv && bzVar.boU()) {
            this.eGx.setVisibility(0);
            this.eGx.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bzVar.bnQ() == null || bzVar.bnQ().share_info == null) ? 0 : bzVar.bnQ().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.fjr = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.fjs = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.fjt = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.fju = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.fjv = z;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.fjq, R.color.CAM_X0109);
        ao.setViewTextColor(this.eGx, R.color.CAM_X0109);
    }
}
