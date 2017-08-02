package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView anP;
    private TextView anQ;
    private TextView anR;
    private TextView anS;
    private BdUniqueId mTag;

    public ThreadLinkView(Context context) {
        super(context);
        init(context);
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.link_thread_item, (ViewGroup) this, true);
        this.anP = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.anP.setDefaultBgResource(d.g.ic_post_url_n);
        this.anP.setDefaultErrorResource(d.g.ic_post_url_n);
        this.anQ = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.anR = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.anS = (TextView) inflate.findViewById(d.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bl blVar) {
        if (blVar == null || blVar.sL() == null || al.isEmpty(blVar.sL().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        aj sL = blVar.sL();
        if (!sL.qg() && sL.qf() != aj.Wi) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.anP.setPageId(this.mTag);
        if (sL.qg()) {
            this.anS.setVisibility(0);
            this.anQ.setVisibility(8);
            this.anR.setVisibility(8);
            this.anS.setText(sL.getLinkUrl());
            this.anP.reset();
        } else {
            this.anS.setVisibility(8);
            String qc = sL.qc();
            String qd = sL.qd();
            if (!al.isEmpty(qc)) {
                this.anQ.setText(qc);
                this.anQ.setVisibility(0);
            } else {
                this.anQ.setVisibility(4);
            }
            if (!al.isEmpty(qd)) {
                this.anR.setText(qd);
                this.anR.setVisibility(0);
            } else {
                this.anR.setVisibility(4);
            }
            if (al.dT(qc) > 32) {
                this.anQ.setMaxLines(2);
                this.anR.setMaxLines(1);
            } else {
                this.anQ.setMaxLines(1);
                this.anR.setMaxLines(2);
            }
            if (!al.isEmpty(sL.qe())) {
                this.anP.c(sL.qe(), 10, false);
            } else {
                this.anP.reset();
            }
        }
        ep(blVar.getId());
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_e);
    }

    public void ep(String str) {
        com.baidu.tieba.card.m.a(this.anQ, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.anS, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.anR, str, d.e.cp_cont_d, d.e.cp_cont_d);
    }
}
