package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dVT;
    public int ewe;
    private TextView exr;
    private boolean exs;
    private boolean exu;
    private boolean exv;
    private boolean exw;
    private boolean exx;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.exs = false;
        this.exu = false;
        this.exv = false;
        this.exw = false;
        this.exx = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.exs = false;
        this.exu = false;
        this.exv = false;
        this.exw = false;
        this.exx = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.exr = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dVT = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        K(bwVar);
        L(bwVar);
        M(bwVar);
        N(bwVar);
        z(bwVar);
    }

    private void K(bw bwVar) {
        if (this.exr != null && bwVar != null && this.exv && bwVar.bfS() != null && bwVar.bgS()) {
            this.exr.setVisibility(0);
            this.exr.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.bfS().audience_count)));
        }
    }

    private void L(bw bwVar) {
        if (this.exr != null && bwVar != null && this.exs) {
            if (bwVar.bfq() >= 0) {
                this.exr.setVisibility(0);
                this.exr.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bfq())));
                return;
            }
            this.exr.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.dVT != null && bwVar != null && this.exu) {
            if (bwVar.bfp() >= 0) {
                this.dVT.setVisibility(0);
                this.dVT.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bfp())));
                return;
            }
            this.dVT.setVisibility(8);
        }
    }

    private void N(bw bwVar) {
        if (this.dVT != null && bwVar != null && this.exw && bwVar.bgS()) {
            this.dVT.setVisibility(0);
            this.dVT.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bgW())));
        }
    }

    private void z(bw bwVar) {
        if (this.dVT != null && bwVar != null && this.exx && bwVar.bgS()) {
            this.dVT.setVisibility(0);
            this.dVT.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.bfS() == null || bwVar.bfS().share_info == null) ? 0 : bwVar.bfS().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.exs = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.exu = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.exv = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.exw = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.exx = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.exr, R.color.cp_cont_d);
        ap.setViewTextColor(this.dVT, R.color.cp_cont_d);
    }
}
