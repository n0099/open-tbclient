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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ThreadCommentAndPraiseInfoLayout extends LinearLayout {
    private com.baidu.tbadk.core.data.z aeF;
    private TextView agA;
    private String agB;
    private String agC;
    private View.OnClickListener agD;
    private View.OnClickListener agE;
    private boolean agF;
    private CustomMessageListener agG;
    private TextView agx;
    private TextView agy;
    private TextView agz;
    private Context mContext;

    public void setYuelaouLocate(String str) {
        this.agC = str;
    }

    public void setStType(String str) {
        this.agB = str;
    }

    public ThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        this.agE = new w(this);
        this.agF = true;
        this.agG = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    public ThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agE = new w(this);
        this.agF = true;
        this.agG = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(n.h.thread_comment_and_praise_info_layout, (ViewGroup) this, true);
        this.agx = (TextView) inflate.findViewById(n.g.thread_info_bar_name);
        this.agy = (TextView) inflate.findViewById(n.g.thread_info_reply_time);
        this.agz = (TextView) inflate.findViewById(n.g.thread_info_praise_num);
        this.agA = (TextView) inflate.findViewById(n.g.thread_info_commont_num);
        this.mContext = context;
    }

    public void setShowPraiseNum(boolean z) {
        this.agF = z;
    }

    public void setData(com.baidu.tbadk.core.data.z zVar) {
        if (zVar != null) {
            this.aeF = zVar;
            if (!StringUtils.isNull(zVar.sv())) {
                this.agx.setVisibility(0);
                this.agx.setText(getContext().getString(n.j.chosen_pb_original_bar, UtilHelper.getFixedText(zVar.sv(), 4, true)));
                this.agx.setOnClickListener(this.agE);
            } else {
                this.agx.setVisibility(8);
            }
            this.agy.setText(ax.t(zVar.getLast_time_int() * 1000));
            a(zVar);
            int reply_num = zVar.getReply_num();
            if (reply_num > 0) {
                this.agA.setVisibility(0);
                this.agA.setText(ax.x(reply_num));
                return;
            }
            this.agA.setVisibility(8);
        }
    }

    public void a(com.baidu.tbadk.core.data.z zVar) {
        if (this.agz != null) {
            if (this.agF && zVar.getPraise() != null && zVar.getPraise().getNum() > 0) {
                this.agz.setVisibility(0);
                this.agz.setText(ax.x(zVar.getPraise().getNum()));
                return;
            }
            this.agz.setVisibility(8);
        }
    }

    public void tr() {
        as.h((View) this.agx, n.d.cp_cont_n);
        as.i((View) this.agx, n.f.label_bg_tie);
        as.h((View) this.agy, n.d.cp_cont_d);
        as.h((View) this.agz, n.d.cp_cont_d);
        if (this.agz != null) {
            this.agz.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        as.h((View) this.agA, n.d.cp_cont_d);
        if (this.agA != null) {
            this.agA.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.agD = onClickListener;
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.agG != null) {
            this.agG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.agG);
        }
    }
}
