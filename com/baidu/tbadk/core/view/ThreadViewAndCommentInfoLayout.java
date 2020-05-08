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
    private TextView dHG;
    public int dIg;
    private TextView dJt;
    private boolean dJu;
    private boolean dJv;
    private boolean dJw;
    private boolean dJx;
    private boolean dJy;
    private Context mContext;

    public ThreadViewAndCommentInfoLayout(Context context) {
        super(context);
        this.dJu = false;
        this.dJv = false;
        this.dJw = false;
        this.dJx = false;
        this.dJy = false;
        init(context);
    }

    public ThreadViewAndCommentInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJu = false;
        this.dJv = false;
        this.dJw = false;
        this.dJx = false;
        this.dJy = false;
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_comment_and_view_info_layout, (ViewGroup) this, true);
        this.dJt = (TextView) inflate.findViewById(R.id.thread_view_num);
        this.dHG = (TextView) inflate.findViewById(R.id.thread_comment_num);
        this.mContext = context;
    }

    public void setData(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        L(bjVar);
        M(bjVar);
        N(bjVar);
        O(bjVar);
        w(bjVar);
    }

    private void L(bj bjVar) {
        if (this.dJt != null && bjVar != null && this.dJw && bjVar.aKV() != null && bjVar.aLT()) {
            this.dJt.setVisibility(0);
            this.dJt.setText(String.format(this.mContext.getString(R.string.person_view_item_live_watch_num), aq.numberUniformFormat(bjVar.aKV().audience_count)));
        }
    }

    private void M(bj bjVar) {
        if (this.dJt != null && bjVar != null && this.dJu) {
            if (bjVar.aKu() >= 0) {
                this.dJt.setVisibility(0);
                this.dJt.setText(String.format(this.mContext.getString(R.string.person_view_num), aq.numberUniformFormat(bjVar.aKu())));
                return;
            }
            this.dJt.setVisibility(8);
        }
    }

    private void N(bj bjVar) {
        if (this.dHG != null && bjVar != null && this.dJv) {
            if (bjVar.aKt() >= 0) {
                this.dHG.setVisibility(0);
                this.dHG.setText(String.format(this.mContext.getString(R.string.comment_num_tip), aq.numberUniformFormat(bjVar.aKt())));
                return;
            }
            this.dHG.setVisibility(8);
        }
    }

    private void O(bj bjVar) {
        if (this.dHG != null && bjVar != null && this.dJx && bjVar.aLT()) {
            this.dHG.setVisibility(0);
            this.dHG.setText(String.format(this.mContext.getString(R.string.person_view_item_live_zan_num), aq.numberUniformFormat(bjVar.aLX())));
        }
    }

    private void w(bj bjVar) {
        if (this.dHG != null && bjVar != null && this.dJy && bjVar.aLT()) {
            this.dHG.setVisibility(0);
            this.dHG.setText(String.format(this.mContext.getString(R.string.person_view_item_live_share_num), aq.numberUniformFormat((bjVar.aKV() == null || bjVar.aKV().share_info == null) ? 0 : bjVar.aKV().share_info.share_count)));
        }
    }

    public void setIsShowReadNum(boolean z) {
        this.dJu = z;
    }

    public void setIsShowReplayNum(boolean z) {
        this.dJv = z;
    }

    public void setIsShowAudienceNum(boolean z) {
        this.dJw = z;
    }

    public void setIsShowZanNum(boolean z) {
        this.dJx = z;
    }

    public void setIsShowShareNum(boolean z) {
        this.dJy = z;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dJt, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.dHG, (int) R.color.cp_cont_d);
    }
}
