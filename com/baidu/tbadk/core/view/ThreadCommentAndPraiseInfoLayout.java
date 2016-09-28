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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bi adW;
    private TextView agV;
    private TextView agW;
    private View agX;
    private TextView agY;
    private TextView agZ;
    private TextView aha;
    private String ahb;
    private String ahc;
    private View.OnClickListener ahd;
    private boolean ahe;
    private View.OnClickListener ahf;
    private boolean ahg;
    private boolean ahh;
    private CustomMessageListener ahi;
    private int from;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.ahc = str;
    }

    public void setStType(String str) {
        this.ahb = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ahe = false;
        this.from = 1;
        this.ahf = new ae(this);
        this.ahg = true;
        this.ahh = true;
        this.ahi = new af(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahe = false;
        this.from = 1;
        this.ahf = new ae(this);
        this.ahg = true;
        this.ahh = true;
        this.ahi = new af(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.agV = (TextView) inflate.findViewById(r.g.thread_info_bar_name);
        this.agW = (TextView) inflate.findViewById(r.g.thread_info_reply_time);
        this.agX = inflate.findViewById(r.g.frs_item_location_sep);
        this.agY = (TextView) inflate.findViewById(r.g.frs_item_location_address);
        this.agZ = (TextView) inflate.findViewById(r.g.thread_info_praise_num);
        this.aha = (TextView) inflate.findViewById(r.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ahg = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahh = z;
        if (this.agV != null) {
            this.agV.setClickable(this.ahh);
        }
    }

    public void setData(bi biVar) {
        if (biVar != null) {
            this.adW = biVar;
            if (!StringUtils.isNull(biVar.getForum_name())) {
                this.agV.setVisibility(0);
                String string = getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(biVar.getForum_name(), 5, true));
                this.agV.setText(string);
                this.agV.setContentDescription(string);
                this.agV.setOnClickListener(this.ahf);
                this.agV.setClickable(this.ahh);
            } else {
                this.agV.setVisibility(8);
            }
            String u = az.u(biVar.rI() * 1000);
            if (this.from == 2) {
                u = az.s(biVar.rI());
            }
            this.agW.setText(u);
            if (this.ahe && !biVar.sr() && !StringUtils.isNull(biVar.getAddress())) {
                this.agY.setVisibility(0);
                this.agX.setVisibility(0);
                this.agY.setText(biVar.getAddress());
            } else {
                this.agY.setVisibility(8);
                this.agX.setVisibility(8);
            }
            a(biVar);
            int rH = biVar.rH();
            if (rH > 0) {
                this.aha.setVisibility(0);
                this.aha.setText(String.valueOf(this.mContext.getString(r.j.comment)) + " " + az.w(rH));
                return;
            }
            this.aha.setVisibility(8);
        }
    }

    public void a(bi biVar) {
        if (this.agZ != null && biVar != null) {
            if (this.ahg && biVar.rF() != null && biVar.rF().getNum() > 0) {
                this.agZ.setVisibility(0);
                String w = az.w(biVar.rF().getNum());
                this.agZ.setText(w);
                this.agZ.setContentDescription(String.valueOf(this.mContext.getString(r.j.zan_num)) + w);
            } else {
                this.agZ.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(this.agZ);
        }
    }

    public void tx() {
        av.j((View) this.agV, r.d.cp_cont_e);
        av.j((View) this.agW, r.d.cp_cont_e);
        av.l(this.agX, r.d.cp_cont_e);
        av.j((View) this.agY, r.d.cp_cont_e);
        av.j((View) this.agZ, r.d.cp_cont_e);
        if (this.agZ != null) {
            this.agZ.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.ak(this.agZ);
        av.j((View) this.aha, r.d.cp_cont_e);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahd = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.agV;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahi != null) {
            this.ahi.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahi);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.ahe = z;
    }

    public View getCommentNumView() {
        return this.aha;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.aha.setOnClickListener(onClickListener);
    }
}
