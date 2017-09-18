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
    private TbImageView aoM;
    private TextView aoN;
    private TextView aoO;
    private TextView aoP;
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
        this.aoM = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.aoM.setDefaultBgResource(d.g.ic_post_url_n);
        this.aoM.setDefaultErrorResource(d.g.ic_post_url_n);
        this.aoN = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.aoO = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.aoP = (TextView) inflate.findViewById(d.h.link_thread_url);
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
        this.aoM.setPageId(this.mTag);
        if (sS.qm()) {
            this.aoP.setVisibility(0);
            this.aoN.setVisibility(8);
            this.aoO.setVisibility(8);
            this.aoP.setText(sS.getLinkUrl());
            this.aoM.reset();
        } else {
            this.aoP.setVisibility(8);
            String qi = sS.qi();
            String qj = sS.qj();
            if (!am.isEmpty(qi)) {
                this.aoN.setText(qi);
                this.aoN.setVisibility(0);
            } else {
                this.aoN.setVisibility(4);
            }
            if (!am.isEmpty(qj)) {
                this.aoO.setText(qj);
                this.aoO.setVisibility(0);
            } else {
                this.aoO.setVisibility(4);
            }
            if (am.dV(qi) > 32) {
                this.aoN.setMaxLines(2);
                this.aoO.setMaxLines(1);
            } else {
                this.aoN.setMaxLines(1);
                this.aoO.setMaxLines(2);
            }
            if (!am.isEmpty(sS.qk())) {
                this.aoM.c(sS.qk(), 10, false);
            } else {
                this.aoM.reset();
            }
        }
        es(bjVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aj.k(this, d.e.cp_bg_line_e);
    }

    public void es(String str) {
        com.baidu.tieba.card.m.a(this.aoN, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aoP, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.aoO, str, d.e.cp_cont_d, d.e.cp_cont_d);
    }
}
