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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private be abb;
    private boolean aeA;
    private View.OnClickListener aeB;
    private View.OnClickListener aeC;
    private boolean aeD;
    private boolean aeE;
    private CustomMessageListener aeF;
    private TextView aer;
    private TextView aes;
    private View aet;
    private TextView aeu;
    private TextView aev;
    private TextView aew;
    private String aex;
    private String aey;
    private View.OnClickListener aez;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.aey = str;
    }

    public void setStType(String str) {
        this.aex = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.aeA = false;
        this.aeC = new af(this);
        this.aeD = true;
        this.aeE = true;
        this.aeF = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeA = false;
        this.aeC = new af(this);
        this.aeD = true;
        this.aeE = true;
        this.aeF = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.aer = (TextView) inflate.findViewById(u.g.thread_info_bar_name);
        this.aes = (TextView) inflate.findViewById(u.g.thread_info_reply_time);
        this.aet = inflate.findViewById(u.g.frs_item_location_sep);
        this.aeu = (TextView) inflate.findViewById(u.g.frs_item_location_address);
        this.aev = (TextView) inflate.findViewById(u.g.thread_info_praise_num);
        this.aew = (TextView) inflate.findViewById(u.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.aeD = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aeE = z;
        if (this.aer != null) {
            this.aer.setClickable(this.aeE);
        }
    }

    public void setData(be beVar) {
        if (beVar != null) {
            this.abb = beVar;
            if (!StringUtils.isNull(beVar.getForum_name())) {
                this.aer.setVisibility(0);
                String string = getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(beVar.getForum_name(), 5, true));
                this.aer.setText(string);
                this.aer.setContentDescription(string);
                this.aer.setOnClickListener(this.aeC);
                this.aer.setClickable(this.aeE);
            } else {
                this.aer.setVisibility(8);
            }
            this.aes.setText(ba.u(beVar.qs() * 1000));
            if (this.aeA && !beVar.ra() && !TextUtils.isEmpty(beVar.getAddress()) && !TextUtils.isEmpty(beVar.getAddress().trim())) {
                this.aeu.setVisibility(0);
                this.aet.setVisibility(0);
                this.aeu.setText(beVar.getAddress());
            } else {
                this.aeu.setVisibility(8);
                this.aet.setVisibility(8);
            }
            a(beVar);
            int qr = beVar.qr();
            if (qr > 0) {
                this.aew.setVisibility(0);
                String w = ba.w(qr);
                this.aew.setText(w);
                this.aew.setContentDescription(String.valueOf(this.mContext.getString(u.j.reply_num)) + w);
                return;
            }
            this.aew.setVisibility(8);
        }
    }

    public void a(be beVar) {
        if (this.aev != null) {
            if (this.aeD && beVar.qp() != null && beVar.qp().getNum() > 0) {
                this.aev.setVisibility(0);
                String w = ba.w(beVar.qp().getNum());
                this.aev.setText(w);
                this.aev.setContentDescription(String.valueOf(this.mContext.getString(u.j.zan_num)) + w);
            } else {
                this.aev.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.al(this.aev);
        }
    }

    public void sd() {
        av.j((View) this.aer, u.d.cp_cont_g);
        av.k(this.aer, u.f.label_bg_tie_n);
        av.j((View) this.aes, u.d.cp_cont_e);
        av.l(this.aet, u.d.cp_cont_e);
        av.j((View) this.aeu, u.d.cp_cont_e);
        av.j((View) this.aev, u.d.cp_cont_e);
        if (this.aev != null) {
            this.aev.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.al(this.aev);
        av.j((View) this.aew, u.d.cp_cont_e);
        if (this.aew != null) {
            this.aew.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aez = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.aer;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aeF != null) {
            this.aeF.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aeF);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.aeA = z;
    }

    public View getCommentNumView() {
        return this.aew;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aeB = onClickListener;
        this.aew.setOnClickListener(this.aeB);
    }
}
