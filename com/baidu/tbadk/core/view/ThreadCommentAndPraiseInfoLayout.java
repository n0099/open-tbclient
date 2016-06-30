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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private az aas;
    private TextView adD;
    private TextView adE;
    private View adF;
    private TextView adG;
    private TextView adH;
    private TextView adI;
    private String adJ;
    private String adK;
    private View.OnClickListener adL;
    private boolean adM;
    private View.OnClickListener adN;
    private View.OnClickListener adO;
    private boolean adP;
    private boolean adQ;
    private CustomMessageListener adR;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.adK = str;
    }

    public void setStType(String str) {
        this.adJ = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.adM = false;
        this.adO = new af(this);
        this.adP = true;
        this.adQ = true;
        this.adR = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adM = false;
        this.adO = new af(this);
        this.adP = true;
        this.adQ = true;
        this.adR = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(u.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.adD = (TextView) inflate.findViewById(u.g.thread_info_bar_name);
        this.adE = (TextView) inflate.findViewById(u.g.thread_info_reply_time);
        this.adF = inflate.findViewById(u.g.frs_item_location_sep);
        this.adG = (TextView) inflate.findViewById(u.g.frs_item_location_address);
        this.adH = (TextView) inflate.findViewById(u.g.thread_info_praise_num);
        this.adI = (TextView) inflate.findViewById(u.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.adP = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.adQ = z;
        if (this.adD != null) {
            this.adD.setClickable(this.adQ);
        }
    }

    public void setData(az azVar) {
        if (azVar != null) {
            this.aas = azVar;
            if (!StringUtils.isNull(azVar.getForum_name())) {
                this.adD.setVisibility(0);
                String string = getContext().getString(u.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(azVar.getForum_name(), 5, true));
                this.adD.setText(string);
                this.adD.setContentDescription(string);
                this.adD.setOnClickListener(this.adO);
                this.adD.setClickable(this.adQ);
            } else {
                this.adD.setVisibility(8);
            }
            this.adE.setText(ba.z(azVar.getLast_time_int() * 1000));
            if (this.adM && !azVar.re() && !TextUtils.isEmpty(azVar.getAddress()) && !TextUtils.isEmpty(azVar.getAddress().trim())) {
                this.adG.setVisibility(0);
                this.adF.setVisibility(0);
                this.adG.setText(azVar.getAddress());
            } else {
                this.adG.setVisibility(8);
                this.adF.setVisibility(8);
            }
            a(azVar);
            int reply_num = azVar.getReply_num();
            if (reply_num > 0) {
                this.adI.setVisibility(0);
                String B = ba.B(reply_num);
                this.adI.setText(B);
                this.adI.setContentDescription(String.valueOf(this.mContext.getString(u.j.reply_num)) + B);
                return;
            }
            this.adI.setVisibility(8);
        }
    }

    public void a(az azVar) {
        if (this.adH != null) {
            if (this.adP && azVar.getPraise() != null && azVar.getPraise().getNum() > 0) {
                this.adH.setVisibility(0);
                String B = ba.B(azVar.getPraise().getNum());
                this.adH.setText(B);
                this.adH.setContentDescription(String.valueOf(this.mContext.getString(u.j.zan_num)) + B);
            } else {
                this.adH.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.an(this.adH);
        }
    }

    public void se() {
        av.j((View) this.adD, u.d.cp_cont_g);
        av.k(this.adD, u.f.label_bg_tie_n);
        av.j((View) this.adE, u.d.cp_cont_e);
        av.l(this.adF, u.d.cp_cont_e);
        av.j((View) this.adG, u.d.cp_cont_e);
        av.j((View) this.adH, u.d.cp_cont_e);
        if (this.adH != null) {
            this.adH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.an(this.adH);
        av.j((View) this.adI, u.d.cp_cont_e);
        if (this.adI != null) {
            this.adI.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.adL = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.adD;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.adR != null) {
            this.adR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.adR);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.adM = z;
    }

    public View getCommentNumView() {
        return this.adI;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.adN = onClickListener;
        this.adI.setOnClickListener(this.adN);
    }
}
