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
/* loaded from: classes2.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dTF;
    public int etW;
    private TextView evj;
    private boolean evk;
    private boolean evl;
    private boolean evm;
    private boolean evn;
    private boolean evo;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.evk = false;
        this.evl = false;
        this.evm = false;
        this.evn = false;
        this.evo = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evk = false;
        this.evl = false;
        this.evm = false;
        this.evn = false;
        this.evo = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.evj = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dTF = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bw bwVar) {
        if (bwVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        J(bwVar);
        K(bwVar);
        L(bwVar);
        M(bwVar);
        y(bwVar);
    }

    private void J(bw bwVar) {
        if (this.evj != null && bwVar != null && this.evm && bwVar.beY() != null && bwVar.bfY()) {
            this.evj.setVisibility(0);
            this.evj.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bwVar.beY().audience_count)));
        }
    }

    private void K(bw bwVar) {
        if (this.evj != null && bwVar != null && this.evk) {
            if (bwVar.bew() >= 0) {
                this.evj.setVisibility(0);
                this.evj.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bwVar.bew())));
                return;
            }
            this.evj.setVisibility(8);
        }
    }

    private void L(bw bwVar) {
        if (this.dTF != null && bwVar != null && this.evl) {
            if (bwVar.bev() >= 0) {
                this.dTF.setVisibility(0);
                this.dTF.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bwVar.bev())));
                return;
            }
            this.dTF.setVisibility(8);
        }
    }

    private void M(bw bwVar) {
        if (this.dTF != null && bwVar != null && this.evn && bwVar.bfY()) {
            this.dTF.setVisibility(0);
            this.dTF.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bwVar.bgc())));
        }
    }

    private void y(bw bwVar) {
        if (this.dTF != null && bwVar != null && this.evo && bwVar.bfY()) {
            this.dTF.setVisibility(0);
            this.dTF.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bwVar.beY() == null || bwVar.beY().share_info == null) ? 0 : bwVar.beY().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.evk = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.evl = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.evm = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.evn = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.evo = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.evj, R.color.cp_cont_d);
        ap.setViewTextColor(this.dTF, R.color.cp_cont_d);
    }
}
