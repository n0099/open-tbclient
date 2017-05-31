package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView amg;
    private TextView amh;
    private TextView ami;
    private TextView amj;
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
        View inflate = LayoutInflater.from(context).inflate(w.j.link_thread_item, (ViewGroup) this, true);
        this.amg = (TbImageView) inflate.findViewById(w.h.link_thread_head_img);
        this.amg.setDefaultBgResource(w.g.ic_post_url_n);
        this.amg.setDefaultErrorResource(w.g.ic_post_url_n);
        this.amh = (TextView) inflate.findViewById(w.h.link_thread_title);
        this.ami = (TextView) inflate.findViewById(w.h.link_thread_abstract);
        this.amj = (TextView) inflate.findViewById(w.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bl blVar) {
        if (blVar == null || blVar.sH() == null || com.baidu.tbadk.core.util.au.isEmpty(blVar.sH().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        com.baidu.tbadk.core.data.aj sH = blVar.sH();
        if (!sH.qg() && sH.qf() != com.baidu.tbadk.core.data.aj.VS) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.amg.setPageId(this.mTag);
        if (sH.qg()) {
            this.amj.setVisibility(0);
            this.amh.setVisibility(8);
            this.ami.setVisibility(8);
            this.amj.setText(sH.getLinkUrl());
            this.amg.reset();
        } else {
            this.amj.setVisibility(8);
            String qc = sH.qc();
            String qd = sH.qd();
            if (!com.baidu.tbadk.core.util.au.isEmpty(qc)) {
                this.amh.setText(qc);
                this.amh.setVisibility(0);
            } else {
                this.amh.setVisibility(4);
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(qd)) {
                this.ami.setText(qd);
                this.ami.setVisibility(0);
            } else {
                this.ami.setVisibility(4);
            }
            if (com.baidu.tbadk.core.util.au.dw(qc) > 32) {
                this.amh.setMaxLines(2);
                this.ami.setMaxLines(1);
            } else {
                this.amh.setMaxLines(1);
                this.ami.setMaxLines(2);
            }
            if (!com.baidu.tbadk.core.util.au.isEmpty(sH.qe())) {
                this.amg.c(sH.qe(), 10, false);
            } else {
                this.amg.reset();
            }
        }
        dS(blVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_e);
    }

    public void dS(String str) {
        com.baidu.tieba.card.at.a(this.amh, str, w.e.cp_cont_b, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.amj, str, w.e.cp_cont_b, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.ami, str, w.e.cp_cont_d, w.e.cp_cont_d);
    }
}
