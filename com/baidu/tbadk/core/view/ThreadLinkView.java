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
    private TbImageView apj;
    private TextView apk;
    private TextView apl;
    private TextView apm;
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
        this.apj = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.apj.setDefaultBgResource(d.g.ic_post_url_n);
        this.apj.setDefaultErrorResource(d.g.ic_post_url_n);
        this.apk = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.apl = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.apm = (TextView) inflate.findViewById(d.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bl blVar) {
        if (blVar == null || blVar.sW() == null || al.isEmpty(blVar.sW().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        aj sW = blVar.sW();
        if (!sW.qr() && sW.qq() != aj.XH) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.apj.setPageId(this.mTag);
        if (sW.qr()) {
            this.apm.setVisibility(0);
            this.apk.setVisibility(8);
            this.apl.setVisibility(8);
            this.apm.setText(sW.getLinkUrl());
            this.apj.reset();
        } else {
            this.apm.setVisibility(8);
            String qn = sW.qn();
            String qo = sW.qo();
            if (!al.isEmpty(qn)) {
                this.apk.setText(qn);
                this.apk.setVisibility(0);
            } else {
                this.apk.setVisibility(4);
            }
            if (!al.isEmpty(qo)) {
                this.apl.setText(qo);
                this.apl.setVisibility(0);
            } else {
                this.apl.setVisibility(4);
            }
            if (al.ed(qn) > 32) {
                this.apk.setMaxLines(2);
                this.apl.setMaxLines(1);
            } else {
                this.apk.setMaxLines(1);
                this.apl.setMaxLines(2);
            }
            if (!al.isEmpty(sW.qp())) {
                this.apj.c(sW.qp(), 10, false);
            } else {
                this.apj.reset();
            }
        }
        ez(blVar.getId());
    }

    public void onChangeSkinType() {
        ai.k(this, d.e.cp_bg_line_e);
    }

    public void ez(String str) {
        com.baidu.tieba.card.m.a(this.apk, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.apm, str, d.e.cp_cont_b, d.e.cp_cont_d);
        com.baidu.tieba.card.m.a(this.apl, str, d.e.cp_cont_d, d.e.cp_cont_d);
    }
}
