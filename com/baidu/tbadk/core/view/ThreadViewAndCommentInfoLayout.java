package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView eKe;
    public int flV;
    private TextView fnh;
    private boolean fni;
    private boolean fnj;
    private boolean fnk;
    private boolean fnl;
    private boolean fnm;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.fni = false;
        this.fnj = false;
        this.fnk = false;
        this.fnl = false;
        this.fnm = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fni = false;
        this.fnj = false;
        this.fnk = false;
        this.fnl = false;
        this.fnm = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.fnh = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eKe = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(cb cbVar) {
        if (cbVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        N(cbVar);
        O(cbVar);
        P(cbVar);
        Q(cbVar);
        B(cbVar);
    }

    private void N(cb cbVar) {
        if (this.fnh != null && cbVar != null && this.fnk && cbVar.bol() != null && cbVar.bpo()) {
            this.fnh.setVisibility(0);
            this.fnh.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), au.numberUniformFormat(cbVar.bol().audience_count)));
        }
    }

    private void O(cb cbVar) {
        if (this.fnh != null && cbVar != null && this.fni) {
            if (cbVar.bnK() >= 0) {
                this.fnh.setVisibility(0);
                this.fnh.setText(String.format(this.mContext.getString(R.string.person_view_num), au.numberUniformFormat(cbVar.bnK())));
                return;
            }
            this.fnh.setVisibility(8);
        }
    }

    private void P(cb cbVar) {
        if (this.eKe != null && cbVar != null && this.fnj) {
            if (cbVar.bnJ() >= 0) {
                this.eKe.setVisibility(0);
                this.eKe.setText(String.format(this.mContext.getString(R.string.comment_num_tip), au.numberUniformFormat(cbVar.bnJ())));
                return;
            }
            this.eKe.setVisibility(8);
        }
    }

    private void Q(cb cbVar) {
        if (this.eKe != null && cbVar != null && this.fnl && cbVar.bpo()) {
            this.eKe.setVisibility(0);
            this.eKe.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), au.numberUniformFormat(cbVar.bps())));
        }
    }

    private void B(cb cbVar) {
        if (this.eKe != null && cbVar != null && this.fnm && cbVar.bpo()) {
            this.eKe.setVisibility(0);
            this.eKe.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), au.numberUniformFormat((cbVar.bol() == null || cbVar.bol().share_info == null) ? 0 : cbVar.bol().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.fni = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.fnj = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.fnk = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.fnl = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.fnm = z;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fnh, R.color.CAM_X0109);
        ap.setViewTextColor(this.eKe, R.color.CAM_X0109);
    }
}
