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
    private TextView eLi;
    public int fmP;
    private TextView fnZ;
    private boolean foa;
    private boolean fob;
    private boolean foc;
    private boolean fod;
    private boolean foe;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.foa = false;
        this.fob = false;
        this.foc = false;
        this.fod = false;
        this.foe = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.foa = false;
        this.fob = false;
        this.foc = false;
        this.fod = false;
        this.foe = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.fnZ = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.eLi = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.fnZ != null && bzVar != null && this.foc && bzVar.brK() != null && bzVar.bsO()) {
            this.fnZ.setVisibility(0);
            this.fnZ.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), at.numberUniformFormat(bzVar.brK().audience_count)));
        }
    }

    private void N(bz bzVar) {
        if (this.fnZ != null && bzVar != null && this.foa) {
            if (bzVar.brj() >= 0) {
                this.fnZ.setVisibility(0);
                this.fnZ.setText(String.format(this.mContext.getString(R.string.person_view_num), at.numberUniformFormat(bzVar.brj())));
                return;
            }
            this.fnZ.setVisibility(8);
        }
    }

    private void O(bz bzVar) {
        if (this.eLi != null && bzVar != null && this.fob) {
            if (bzVar.bri() >= 0) {
                this.eLi.setVisibility(0);
                this.eLi.setText(String.format(this.mContext.getString(R.string.comment_num_tip), at.numberUniformFormat(bzVar.bri())));
                return;
            }
            this.eLi.setVisibility(8);
        }
    }

    private void P(bz bzVar) {
        if (this.eLi != null && bzVar != null && this.fod && bzVar.bsO()) {
            this.eLi.setVisibility(0);
            this.eLi.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), at.numberUniformFormat(bzVar.bsS())));
        }
    }

    private void B(bz bzVar) {
        if (this.eLi != null && bzVar != null && this.foe && bzVar.bsO()) {
            this.eLi.setVisibility(0);
            this.eLi.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), at.numberUniformFormat((bzVar.brK() == null || bzVar.brK().share_info == null) ? 0 : bzVar.brK().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.foa = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.fob = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.foc = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.fod = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.foe = z;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.fnZ, R.color.CAM_X0109);
        ao.setViewTextColor(this.eLi, R.color.CAM_X0109);
    }
}
