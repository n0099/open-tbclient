package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    private TextView dEA;
    public int edR;
    private TextView efe;
    private boolean eff;
    private boolean efg;
    private boolean efh;
    private boolean efi;
    private boolean efj;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.eff = false;
        this.efg = false;
        this.efh = false;
        this.efi = false;
        this.efj = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eff = false;
        this.efg = false;
        this.efh = false;
        this.efi = false;
        this.efj = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.efe = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dEA = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bu buVar) {
        if (buVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        M(buVar);
        N(buVar);
        O(buVar);
        P(buVar);
        x(buVar);
    }

    private void M(bu buVar) {
        if (this.efe != null && buVar != null && this.efh && buVar.aSJ() != null && buVar.aTJ()) {
            this.efe.setVisibility(0);
            this.efe.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), ar.numberUniformFormat(buVar.aSJ().audience_count)));
        }
    }

    private void N(bu buVar) {
        if (this.efe != null && buVar != null && this.eff) {
            if (buVar.aSh() >= 0) {
                this.efe.setVisibility(0);
                this.efe.setText(String.format(this.mContext.getString(R.string.person_view_num), ar.numberUniformFormat(buVar.aSh())));
                return;
            }
            this.efe.setVisibility(8);
        }
    }

    private void O(bu buVar) {
        if (this.dEA != null && buVar != null && this.efg) {
            if (buVar.aSg() >= 0) {
                this.dEA.setVisibility(0);
                this.dEA.setText(String.format(this.mContext.getString(R.string.comment_num_tip), ar.numberUniformFormat(buVar.aSg())));
                return;
            }
            this.dEA.setVisibility(8);
        }
    }

    private void P(bu buVar) {
        if (this.dEA != null && buVar != null && this.efi && buVar.aTJ()) {
            this.dEA.setVisibility(0);
            this.dEA.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), ar.numberUniformFormat(buVar.aTN())));
        }
    }

    private void x(bu buVar) {
        if (this.dEA != null && buVar != null && this.efj && buVar.aTJ()) {
            this.dEA.setVisibility(0);
            this.dEA.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), ar.numberUniformFormat((buVar.aSJ() == null || buVar.aSJ().share_info == null) ? 0 : buVar.aSJ().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.eff = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.efg = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.efh = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.efi = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.efj = z;
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.efe, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.dEA, (int) R.color.cp_cont_d);
    }
}
