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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.as aeC;
    private CustomMessageListener ahA;
    private TextView ahq;
    private TextView ahr;
    private TextView ahs;
    private TextView aht;
    private String ahu;
    private String ahv;
    private View.OnClickListener ahw;
    private View.OnClickListener ahx;
    private boolean ahy;
    private boolean ahz;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.ahv = str;
    }

    public void setStType(String str) {
        this.ahu = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ahx = new ad(this);
        this.ahy = true;
        this.ahz = true;
        this.ahA = new ae(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahx = new ad(this);
        this.ahy = true;
        this.ahz = true;
        this.ahA = new ae(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.ahq = (TextView) inflate.findViewById(t.g.thread_info_bar_name);
        this.ahr = (TextView) inflate.findViewById(t.g.thread_info_reply_time);
        this.ahs = (TextView) inflate.findViewById(t.g.thread_info_praise_num);
        this.aht = (TextView) inflate.findViewById(t.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ahy = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahz = z;
        if (this.ahq != null) {
            this.ahq.setClickable(this.ahz);
        }
    }

    public void setData(com.baidu.tbadk.core.data.as asVar) {
        if (asVar != null) {
            this.aeC = asVar;
            if (!StringUtils.isNull(asVar.tr())) {
                this.ahq.setVisibility(0);
                String string = getContext().getString(t.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(asVar.tr(), 5, true));
                this.ahq.setText(string);
                this.ahq.setContentDescription(string);
                this.ahq.setOnClickListener(this.ahx);
                this.ahq.setClickable(this.ahz);
            } else {
                this.ahq.setVisibility(8);
            }
            this.ahr.setText(ay.x(asVar.getLast_time_int() * 1000));
            a(asVar);
            int reply_num = asVar.getReply_num();
            if (reply_num > 0) {
                this.aht.setVisibility(0);
                String z = ay.z(reply_num);
                this.aht.setText(z);
                this.aht.setContentDescription(String.valueOf(this.mContext.getString(t.j.reply_num)) + z);
                return;
            }
            this.aht.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.core.data.as asVar) {
        if (this.ahs != null) {
            if (this.ahy && asVar.getPraise() != null && asVar.getPraise().getNum() > 0) {
                this.ahs.setVisibility(0);
                String z = ay.z(asVar.getPraise().getNum());
                this.ahs.setText(z);
                this.ahs.setContentDescription(String.valueOf(this.mContext.getString(t.j.zan_num)) + z);
            } else {
                this.ahs.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.af(this.ahs);
        }
    }

    public void uA() {
        at.j((View) this.ahq, t.d.home_page_bar_name);
        at.k(this.ahq, t.f.label_bg_tie_n);
        at.j((View) this.ahr, t.d.cp_cont_e);
        at.j((View) this.ahs, t.d.cp_cont_e);
        if (this.ahs != null) {
            this.ahs.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.af(this.ahs);
        at.j((View) this.aht, t.d.cp_cont_e);
        if (this.aht != null) {
            this.aht.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ahq;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahA != null) {
            this.ahA.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahA);
        }
    }
}
