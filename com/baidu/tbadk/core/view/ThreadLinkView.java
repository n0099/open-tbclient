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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView aoO;
    private TextView aoP;
    private TextView aoQ;
    private TextView aoR;
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
        this.aoO = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.aoO.setDefaultBgResource(d.g.ic_post_url_n);
        this.aoO.setDefaultErrorResource(d.g.ic_post_url_n);
        this.aoP = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.aoQ = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.aoR = (TextView) inflate.findViewById(d.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.sS() == null || am.isEmpty(bjVar.sS().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        aj sS = bjVar.sS();
        if (!sS.qm() && sS.ql() != aj.WQ) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aoO.setPageId(this.mTag);
        if (sS.qm()) {
            this.aoR.setVisibility(0);
            this.aoP.setVisibility(8);
            this.aoQ.setVisibility(8);
            this.aoR.setText(sS.getLinkUrl());
            this.aoO.reset();
        } else {
            this.aoR.setVisibility(8);
            String qi = sS.qi();
            String qj = sS.qj();
            if (!am.isEmpty(qi)) {
                this.aoP.setText(qi);
                this.aoP.setVisibility(0);
            } else {
                this.aoP.setVisibility(4);
            }
            if (!am.isEmpty(qj)) {
                this.aoQ.setText(qj);
                this.aoQ.setVisibility(0);
            } else {
                this.aoQ.setVisibility(4);
            }
            if (am.dV(qi) > 32) {
                this.aoP.setMaxLines(2);
                this.aoQ.setMaxLines(1);
            } else {
                this.aoP.setMaxLines(1);
                this.aoQ.setMaxLines(2);
            }
            if (!am.isEmpty(sS.qk())) {
                this.aoO.c(sS.qk(), 10, false);
            } else {
                this.aoO.reset();
            }
        }
        es(bjVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aj.k(this, d.e.cp_bg_line_e);
    }

    public void es(String str) {
        com.baidu.tieba.card.m.a(this.aoP, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aoR, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aoQ, str, d.e.cp_cont_d, d.e.cp_cont_d);
    }
}
