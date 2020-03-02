package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadViewAndCommentInfoLayout extends LinearLayout {
    public int dhG;
    private TextView dhh;
    private TextView diW;
    private boolean diX;
    private boolean diY;
    private boolean diZ;
    private boolean dja;
    private boolean djb;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.diX = false;
        this.diY = false;
        this.diZ = false;
        this.dja = false;
        this.djb = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diX = false;
        this.diY = false;
        this.diZ = false;
        this.dja = false;
        this.djb = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.diW = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dhh = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        K(bjVar);
        L(bjVar);
        M(bjVar);
        N(bjVar);
        v(bjVar);
    }

    private void K(bj bjVar) {
        if (this.diW != null && bjVar != null && this.diZ && bjVar.aCH() != null && bjVar.aDD()) {
            this.diW.setVisibility(0);
            this.diW.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aCH().audience_count)));
        }
    }

    private void L(bj bjVar) {
        if (this.diW != null && bjVar != null && this.diX) {
            if (bjVar.aCg() >= 0) {
                this.diW.setVisibility(0);
                this.diW.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aCg())));
                return;
            }
            this.diW.setVisibility(8);
        }
    }

    private void M(bj bjVar) {
        if (this.dhh != null && bjVar != null && this.diY) {
            if (bjVar.aCf() >= 0) {
                this.dhh.setVisibility(0);
                this.dhh.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aCf())));
                return;
            }
            this.dhh.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dhh != null && bjVar != null && this.dja && bjVar.aDD()) {
            this.dhh.setVisibility(0);
            this.dhh.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aDH())));
        }
    }

    private void v(bj bjVar) {
        if (this.dhh != null && bjVar != null && this.djb && bjVar.aDD()) {
            this.dhh.setVisibility(0);
            this.dhh.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aCH() == null || bjVar.aCH().share_info == null) ? 0 : bjVar.aCH().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.diX = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.diY = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.diZ = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.dja = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.djb = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.diW, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dhh, (int) R.color.cp_cont_d);
    }
}
