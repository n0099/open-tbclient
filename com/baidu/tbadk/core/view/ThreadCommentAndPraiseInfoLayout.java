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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private ax aab;
    private TextView adf;
    private TextView adg;
    private View adh;
    private TextView adi;
    private TextView adj;
    private TextView adk;
    private String adl;
    private String adm;
    private View.OnClickListener adn;
    private boolean ado;
    private View.OnClickListener adp;
    private View.OnClickListener adq;
    private boolean adr;
    private boolean ads;
    private CustomMessageListener adt;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.adm = str;
    }

    public void setStType(String str) {
        this.adl = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ado = false;
        this.adq = new af(this);
        this.adr = true;
        this.ads = true;
        this.adt = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ado = false;
        this.adq = new af(this);
        this.adr = true;
        this.ads = true;
        this.adt = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.adf = (TextView) inflate.findViewById(t.g.thread_info_bar_name);
        this.adg = (TextView) inflate.findViewById(t.g.thread_info_reply_time);
        this.adh = inflate.findViewById(t.g.frs_item_location_sep);
        this.adi = (TextView) inflate.findViewById(t.g.frs_item_location_address);
        this.adj = (TextView) inflate.findViewById(t.g.thread_info_praise_num);
        this.adk = (TextView) inflate.findViewById(t.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.adr = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ads = z;
        if (this.adf != null) {
            this.adf.setClickable(this.ads);
        }
    }

    public void setData(ax axVar) {
        if (axVar != null) {
            this.aab = axVar;
            if (!StringUtils.isNull(axVar.qP())) {
                this.adf.setVisibility(0);
                String string = getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(axVar.qP(), 5, true));
                this.adf.setText(string);
                this.adf.setContentDescription(string);
                this.adf.setOnClickListener(this.adq);
                this.adf.setClickable(this.ads);
            } else {
                this.adf.setVisibility(8);
            }
            this.adg.setText(ay.y(axVar.getLast_time_int() * 1000));
            if (this.ado && !axVar.rh() && !TextUtils.isEmpty(axVar.getAddress()) && !TextUtils.isEmpty(axVar.getAddress().trim())) {
                this.adi.setVisibility(0);
                this.adh.setVisibility(0);
                this.adi.setText(axVar.getAddress());
            } else {
                this.adi.setVisibility(8);
                this.adh.setVisibility(8);
            }
            a(axVar);
            int reply_num = axVar.getReply_num();
            if (reply_num > 0) {
                this.adk.setVisibility(0);
                String A = ay.A(reply_num);
                this.adk.setText(A);
                this.adk.setContentDescription(String.valueOf(this.mContext.getString(t.j.reply_num)) + A);
                return;
            }
            this.adk.setVisibility(8);
        }
    }

    public void a(ax axVar) {
        if (this.adj != null) {
            if (this.adr && axVar.getPraise() != null && axVar.getPraise().getNum() > 0) {
                this.adj.setVisibility(0);
                String A = ay.A(axVar.getPraise().getNum());
                this.adj.setText(A);
                this.adj.setContentDescription(String.valueOf(this.mContext.getString(t.j.zan_num)) + A);
            } else {
                this.adj.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.aj(this.adj);
        }
    }

    public void sf() {
        com.baidu.tbadk.core.util.at.j((View) this.adf, t.d.home_page_bar_name);
        com.baidu.tbadk.core.util.at.k(this.adf, t.f.label_bg_tie_n);
        com.baidu.tbadk.core.util.at.j((View) this.adg, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.at.l(this.adh, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.at.j((View) this.adi, t.d.cp_cont_e);
        com.baidu.tbadk.core.util.at.j((View) this.adj, t.d.cp_cont_e);
        if (this.adj != null) {
            this.adj.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.aj(this.adj);
        com.baidu.tbadk.core.util.at.j((View) this.adk, t.d.cp_cont_e);
        if (this.adk != null) {
            this.adk.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.adn = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.adf;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.adt != null) {
            this.adt.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.adt);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.ado = z;
    }

    public View getCommentNumView() {
        return this.adk;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.adp = onClickListener;
        this.adk.setOnClickListener(this.adp);
    }
}
