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
    public int dhF;
    private TextView dhg;
    private TextView diV;
    private boolean diW;
    private boolean diX;
    private boolean diY;
    private boolean diZ;
    private boolean dja;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.diW = false;
        this.diX = false;
        this.diY = false;
        this.diZ = false;
        this.dja = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diW = false;
        this.diX = false;
        this.diY = false;
        this.diZ = false;
        this.dja = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.diV = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dhg = (TextView) inflate.findViewById(R.id.thread_comment_num);
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
        if (this.diV != null && bjVar != null && this.diY && bjVar.aCF() != null && bjVar.aDB()) {
            this.diV.setVisibility(0);
            this.diV.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aCF().audience_count)));
        }
    }

    private void L(bj bjVar) {
        if (this.diV != null && bjVar != null && this.diW) {
            if (bjVar.aCe() >= 0) {
                this.diV.setVisibility(0);
                this.diV.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aCe())));
                return;
            }
            this.diV.setVisibility(8);
        }
    }

    private void M(bj bjVar) {
        if (this.dhg != null && bjVar != null && this.diX) {
            if (bjVar.aCd() >= 0) {
                this.dhg.setVisibility(0);
                this.dhg.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aCd())));
                return;
            }
            this.dhg.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dhg != null && bjVar != null && this.diZ && bjVar.aDB()) {
            this.dhg.setVisibility(0);
            this.dhg.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aDF())));
        }
    }

    private void v(bj bjVar) {
        if (this.dhg != null && bjVar != null && this.dja && bjVar.aDB()) {
            this.dhg.setVisibility(0);
            this.dhg.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aCF() == null || bjVar.aCF().share_info == null) ? 0 : bjVar.aCF().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.diW = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.diX = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.diY = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.diZ = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.dja = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.diV, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dhg, (int) R.color.cp_cont_d);
    }
}
