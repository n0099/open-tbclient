package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.ah afg;
    private TextView ahl;
    private TextView ahm;
    private TextView ahn;
    private TextView aho;
    private String ahp;
    private String ahq;
    private View.OnClickListener ahr;
    private View.OnClickListener ahs;
    private boolean aht;
    private boolean ahu;
    private CustomMessageListener ahv;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.ahq = str;
    }

    public void setStType(String str) {
        this.ahp = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ahs = new w(this);
        this.aht = true;
        this.ahu = true;
        this.ahv = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahs = new w(this);
        this.aht = true;
        this.ahu = true;
        this.ahv = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.ahl = (TextView) inflate.findViewById(t.g.thread_info_bar_name);
        this.ahm = (TextView) inflate.findViewById(t.g.thread_info_reply_time);
        this.ahn = (TextView) inflate.findViewById(t.g.thread_info_praise_num);
        this.aho = (TextView) inflate.findViewById(t.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.aht = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahu = z;
        if (this.ahl != null) {
            this.ahl.setClickable(this.ahu);
        }
    }

    public void setData(com.baidu.tbadk.core.data.ah ahVar) {
        if (ahVar != null) {
            this.afg = ahVar;
            if (!StringUtils.isNull(ahVar.tn())) {
                this.ahl.setVisibility(0);
                this.ahl.setText(getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(ahVar.tn(), 5, true)));
                this.ahl.setOnClickListener(this.ahs);
                this.ahl.setClickable(this.ahu);
            } else {
                this.ahl.setVisibility(8);
            }
            this.ahm.setText(aw.v(ahVar.getLast_time_int() * 1000));
            a(ahVar);
            int reply_num = ahVar.getReply_num();
            if (reply_num > 0) {
                this.aho.setVisibility(0);
                this.aho.setText(aw.x(reply_num));
                return;
            }
            this.aho.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.core.data.ah ahVar) {
        if (this.ahn != null) {
            if (this.aht && ahVar.getPraise() != null && ahVar.getPraise().getNum() > 0) {
                this.ahn.setVisibility(0);
                this.ahn.setText(aw.x(ahVar.getPraise().getNum()));
                return;
            }
            this.ahn.setVisibility(8);
        }
    }

    public void uv() {
        ar.j((View) this.ahl, t.d.cp_cont_n);
        ar.k(this.ahl, t.f.label_bg_tie);
        ar.j((View) this.ahm, t.d.cp_cont_d);
        ar.j((View) this.ahn, t.d.cp_cont_d);
        if (this.ahn != null) {
            this.ahn.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ar.j((View) this.aho, t.d.cp_cont_d);
        if (this.aho != null) {
            this.aho.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahr = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ahl;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahv != null) {
            this.ahv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahv);
        }
    }
}
