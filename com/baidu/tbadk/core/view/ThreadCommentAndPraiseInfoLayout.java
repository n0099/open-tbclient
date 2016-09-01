package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bg adL;
    private CustomMessageListener ahA;
    private TextView ahm;
    private TextView ahn;
    private View aho;
    private TextView ahp;
    private TextView ahq;
    private TextView ahr;
    private String ahs;
    private String aht;
    private View.OnClickListener ahu;
    private boolean ahv;
    private View.OnClickListener ahw;
    private View.OnClickListener ahx;
    private boolean ahy;
    private boolean ahz;
    private int from;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.aht = str;
    }

    public void setStType(String str) {
        this.ahs = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ahv = false;
        this.from = 1;
        this.ahx = new ag(this);
        this.ahy = true;
        this.ahz = true;
        this.ahA = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahv = false;
        this.from = 1;
        this.ahx = new ag(this);
        this.ahy = true;
        this.ahz = true;
        this.ahA = new ah(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.ahm = (TextView) inflate.findViewById(t.g.thread_info_bar_name);
        this.ahn = (TextView) inflate.findViewById(t.g.thread_info_reply_time);
        this.aho = inflate.findViewById(t.g.frs_item_location_sep);
        this.ahp = (TextView) inflate.findViewById(t.g.frs_item_location_address);
        this.ahq = (TextView) inflate.findViewById(t.g.thread_info_praise_num);
        this.ahr = (TextView) inflate.findViewById(t.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ahy = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahz = z;
        if (this.ahm != null) {
            this.ahm.setClickable(this.ahz);
        }
    }

    public void setData(bg bgVar) {
        if (bgVar != null) {
            this.adL = bgVar;
            if (!StringUtils.isNull(bgVar.getForum_name())) {
                this.ahm.setVisibility(0);
                String string = getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bgVar.getForum_name(), 5, true));
                this.ahm.setText(string);
                this.ahm.setContentDescription(string);
                this.ahm.setOnClickListener(this.ahx);
                this.ahm.setClickable(this.ahz);
            } else {
                this.ahm.setVisibility(8);
            }
            String u = ba.u(bgVar.rw() * 1000);
            if (this.from == 2) {
                u = ba.s(bgVar.rw());
            }
            this.ahn.setText(u);
            if (this.ahv && !bgVar.sf() && !TextUtils.isEmpty(bgVar.getAddress()) && !TextUtils.isEmpty(bgVar.getAddress().trim())) {
                this.ahp.setVisibility(0);
                this.aho.setVisibility(0);
                this.ahp.setText(bgVar.getAddress());
            } else {
                this.ahp.setVisibility(8);
                this.aho.setVisibility(8);
            }
            a(bgVar);
            int rv = bgVar.rv();
            if (rv > 0) {
                this.ahr.setVisibility(0);
                String w = ba.w(rv);
                this.ahr.setText(w);
                this.ahr.setContentDescription(String.valueOf(this.mContext.getString(t.j.reply_num)) + w);
                return;
            }
            this.ahr.setVisibility(8);
        }
    }

    public void a(bg bgVar) {
        if (this.ahq != null) {
            if (this.ahy && bgVar.rt() != null && bgVar.rt().getNum() > 0) {
                this.ahq.setVisibility(0);
                String w = ba.w(bgVar.rt().getNum());
                this.ahq.setText(w);
                this.ahq.setContentDescription(String.valueOf(this.mContext.getString(t.j.zan_num)) + w);
            } else {
                this.ahq.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(this.ahq);
        }
    }

    public void ti() {
        com.baidu.tbadk.core.util.av.j((View) this.ahm, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.av.k(this.ahm, t.f.label_bg_tie_n);
        com.baidu.tbadk.core.util.av.j((View) this.ahn, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.av.l(this.aho, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.av.j((View) this.ahp, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.av.j((View) this.ahq, t.d.cp_cont_e);
        if (this.ahq != null) {
            this.ahq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.al(this.ahq);
        com.baidu.tbadk.core.util.av.j((View) this.ahr, t.d.cp_cont_e);
        if (this.ahr != null) {
            this.ahr.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahu = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ahm;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahA != null) {
            this.ahA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahA);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.ahv = z;
    }

    public View getCommentNumView() {
        return this.ahr;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
        this.ahr.setOnClickListener(this.ahw);
    }
}
