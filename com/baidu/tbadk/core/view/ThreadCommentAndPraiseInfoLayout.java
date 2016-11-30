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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private bk aeu;
    private TextView ahA;
    private String ahB;
    private String ahC;
    private View.OnClickListener ahD;
    private boolean ahE;
    private View.OnClickListener ahF;
    private boolean ahG;
    private boolean ahH;
    private CustomMessageListener ahI;
    private TextView ahv;
    private TextView ahw;
    private View ahx;
    private TextView ahy;
    private TextView ahz;
    private int from;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.ahC = str;
    }

    public void setStType(String str) {
        this.ahB = str;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.ahE = false;
        this.from = 1;
        this.ahF = new af(this);
        this.ahG = true;
        this.ahH = true;
        this.ahI = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahE = false;
        this.from = 1;
        this.ahF = new af(this);
        this.ahG = true;
        this.ahH = true;
        this.ahI = new ag(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(r.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.ahv = (TextView) inflate.findViewById(r.g.thread_info_bar_name);
        this.ahw = (TextView) inflate.findViewById(r.g.thread_info_reply_time);
        this.ahx = inflate.findViewById(r.g.frs_item_location_sep);
        this.ahy = (TextView) inflate.findViewById(r.g.frs_item_location_address);
        this.ahz = (TextView) inflate.findViewById(r.g.thread_info_praise_num);
        this.ahA = (TextView) inflate.findViewById(r.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.ahG = z;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ahH = z;
        if (this.ahv != null) {
            this.ahv.setClickable(this.ahH);
        }
    }

    public boolean a(bk bkVar) {
        boolean z;
        if (bkVar == null) {
            return false;
        }
        this.aeu = bkVar;
        if (!StringUtils.isNull(bkVar.getForum_name())) {
            this.ahv.setVisibility(0);
            String string = getContext().getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bkVar.getForum_name(), 5, true));
            this.ahv.setText(string);
            this.ahv.setContentDescription(string);
            this.ahv.setOnClickListener(this.ahF);
            this.ahv.setClickable(this.ahH);
            z = true;
        } else {
            this.ahv.setVisibility(8);
            z = false;
        }
        if (bkVar.rK() <= 0) {
            this.ahw.setVisibility(8);
        } else {
            this.ahw.setVisibility(0);
            String t = ax.t(bkVar.rK() * 1000);
            if (this.from == 2) {
                t = ax.r(bkVar.rK());
            }
            this.ahw.setText(t);
            z = true;
        }
        if (this.ahE && !bkVar.st() && !StringUtils.isNull(bkVar.getAddress())) {
            this.ahy.setVisibility(0);
            if (bkVar.rK() <= 0) {
                this.ahx.setVisibility(8);
            } else {
                this.ahx.setVisibility(0);
            }
            this.ahy.setText(bkVar.getAddress());
            z = true;
        } else {
            this.ahy.setVisibility(8);
            this.ahx.setVisibility(8);
        }
        b(bkVar);
        int rJ = bkVar.rJ();
        if (rJ > 0) {
            this.ahA.setVisibility(0);
            String v = ax.v(rJ);
            this.ahA.setText(String.format(this.mContext.getString(r.j.reply_num_tip), v));
            this.ahA.setContentDescription(String.valueOf(this.mContext.getString(r.j.reply_num)) + v);
            z = true;
        } else {
            this.ahA.setVisibility(4);
        }
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
        return z;
    }

    public void b(bk bkVar) {
        if (this.ahz != null && bkVar != null) {
            if (this.ahG && bkVar.rH() != null && bkVar.rH().getNum() > 0) {
                this.ahz.setVisibility(0);
                String v = ax.v(bkVar.rH().getNum());
                this.ahz.setText(v);
                this.ahz.setContentDescription(String.valueOf(this.mContext.getString(r.j.zan_num)) + v);
            } else {
                this.ahz.setVisibility(8);
            }
            com.baidu.tieba.graffiti.d.ak(this.ahz);
        }
    }

    public void tB() {
        at.j((View) this.ahv, r.d.cp_cont_c);
        at.j((View) this.ahw, r.d.cp_cont_c);
        at.l(this.ahx, r.d.cp_cont_c);
        at.j((View) this.ahy, r.d.cp_cont_c);
        at.j((View) this.ahz, r.d.cp_cont_c);
        if (this.ahz != null) {
            this.ahz.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_hand_normal_card_recommend), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        com.baidu.tieba.graffiti.d.ak(this.ahz);
        at.j((View) this.ahA, r.d.cp_cont_c);
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public TextView getBarNameTv() {
        return this.ahv;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ahI != null) {
            this.ahI.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.ahI);
        }
    }

    public void setLocationEnabled(boolean z) {
        this.ahE = z;
    }

    public View getCommentNumView() {
        return this.ahA;
    }

    public void setCommentNumClickListener(View.OnClickListener onClickListener) {
        this.ahA.setOnClickListener(onClickListener);
    }
}
