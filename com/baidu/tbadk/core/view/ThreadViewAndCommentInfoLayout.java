package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int caD;
    private TextView caa;
    private TextView cbK;
    private boolean cbL;
    private boolean cbM;
    private boolean cbN;
    private boolean cbO;
    private boolean cbP;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.cbL = false;
        this.cbM = false;
        this.cbN = false;
        this.cbO = false;
        this.cbP = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbL = false;
        this.cbM = false;
        this.cbN = false;
        this.cbO = false;
        this.cbP = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.cbK = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.caa = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bg bgVar) {
        if (bgVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        C(bgVar);
        D(bgVar);
        E(bgVar);
        F(bgVar);
        o(bgVar);
    }

    private void C(bg bgVar) {
        if (this.cbK != null && bgVar != null && this.cbN && bgVar.adO() != null && bgVar.aeJ()) {
            this.cbK.setVisibility(0);
            this.cbK.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), ap.aG(bgVar.adO().audience_count)));
        }
    }

    private void D(bg bgVar) {
        if (this.cbK != null && bgVar != null && this.cbL) {
            if (bgVar.adn() >= 0) {
                this.cbK.setVisibility(0);
                this.cbK.setText(String.format(this.mContext.getString(R.string.person_view_num), ap.aG(bgVar.adn())));
                return;
            }
            this.cbK.setVisibility(8);
        }
    }

    private void E(bg bgVar) {
        if (this.caa != null && bgVar != null && this.cbM) {
            if (bgVar.adm() >= 0) {
                this.caa.setVisibility(0);
                this.caa.setText(String.format(this.mContext.getString(R.string.comment_num_tip), ap.aG(bgVar.adm())));
                return;
            }
            this.caa.setVisibility(8);
        }
    }

    private void F(bg bgVar) {
        if (this.caa != null && bgVar != null && this.cbO && bgVar.aeJ()) {
            this.caa.setVisibility(0);
            this.caa.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), ap.aG(bgVar.aeO())));
        }
    }

    private void o(bg bgVar) {
        if (this.caa != null && bgVar != null && this.cbP && bgVar.aeJ()) {
            this.caa.setVisibility(0);
            this.caa.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), ap.aG((bgVar.adO() == null || bgVar.adO().share_info == null) ? 0 : bgVar.adO().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.cbL = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.cbM = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.cbN = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.cbO = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.cbP = z;
    }

    public void onChangeSkinType() {
        al.j(this.cbK, R.color.cp_cont_d);
        al.j(this.caa, R.color.cp_cont_d);
    }
}
