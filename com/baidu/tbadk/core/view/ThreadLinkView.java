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
    private TbImageView api;
    private TextView apj;
    private TextView apk;
    private TextView apl;
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
        this.api = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.api.setDefaultBgResource(d.g.ic_post_url_n);
        this.api.setDefaultErrorResource(d.g.ic_post_url_n);
        this.apj = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.apk = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.apl = (TextView) inflate.findViewById(d.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bl blVar) {
        if (blVar == null || blVar.sV() == null || al.isEmpty(blVar.sV().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        aj sV = blVar.sV();
        if (!sV.qq() && sV.qp() != aj.XE) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.api.setPageId(this.mTag);
        if (sV.qq()) {
            this.apl.setVisibility(0);
            this.apj.setVisibility(8);
            this.apk.setVisibility(8);
            this.apl.setText(sV.getLinkUrl());
            this.api.reset();
        } else {
            this.apl.setVisibility(8);
            String qm = sV.qm();
            String qn = sV.qn();
            if (!al.isEmpty(qm)) {
                this.apj.setText(qm);
                this.apj.setVisibility(0);
            } else {
                this.apj.setVisibility(4);
            }
            if (!al.isEmpty(qn)) {
                this.apk.setText(qn);
                this.apk.setVisibility(0);
            } else {
                this.apk.setVisibility(4);
            }
            if (al.dZ(qm) > 32) {
                this.apj.setMaxLines(2);
                this.apk.setMaxLines(1);
            } else {
                this.apj.setMaxLines(1);
                this.apk.setMaxLines(2);
            }
            if (!al.isEmpty(sV.qo())) {
                this.api.c(sV.qo(), 10, false);
            } else {
                this.api.reset();
            }
        }
        ev(blVar.getId());
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_e);
    }

    public void ev(String str) {
        com.baidu.tieba.card.m.a(this.apj, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.apl, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.apk, str, d.e.cp_cont_d, d.e.cp_cont_d);
    }
}
