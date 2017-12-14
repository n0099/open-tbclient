package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView aos;
    private TextView aot;
    private TextView aou;
    private TextView aov;
    private ViewGroup aow;
    private Context mContext;
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
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(d.h.link_thread_item, (ViewGroup) this, true);
        this.aow = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.aos = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.aos.setDefaultBgResource(d.f.icon_card_url_n);
        this.aos.setDefaultErrorResource(d.f.icon_card_url_n);
        this.aot = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.aou = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.aov = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.aos.setLongIconSupport(false);
        this.aos.setGifIconSupport(false);
        I(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.sN() == null || am.isEmpty(bdVar.sN().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad sN = bdVar.sN();
        if (!sN.qf() && sN.qe() != ad.Xk) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aos.setPageId(this.mTag);
        if (sN.qf()) {
            this.aov.setVisibility(0);
            this.aot.setVisibility(8);
            this.aou.setVisibility(8);
            this.aov.setText(sN.getLinkUrl());
            this.aos.reset();
        } else {
            this.aov.setVisibility(8);
            String qb = sN.qb();
            String qc = sN.qc();
            if (!am.isEmpty(qb)) {
                this.aot.setText(qb);
                this.aot.setVisibility(0);
                this.aou.setVisibility(8);
            } else {
                this.aot.setVisibility(8);
                if (!am.isEmpty(qc)) {
                    this.aou.setText(qc);
                    this.aou.setVisibility(0);
                } else {
                    this.aou.setVisibility(4);
                }
            }
            if (!am.isEmpty(sN.qd())) {
                this.aos.startLoad(sN.qd(), 10, false);
            } else {
                this.aos.reset();
            }
        }
        ew(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0096d.cp_bg_line_e);
        aj.k(this.aos, d.C0096d.cp_bg_line_b);
    }

    public void ew(String str) {
        com.baidu.tieba.card.k.a(this.aot, str, d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.aov, str, d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.aou, str, d.C0096d.cp_cont_j, d.C0096d.cp_cont_d);
    }

    private void I(View view) {
        if (this.aow != null && this.aos != null) {
            int ac = ((l.ac(this.mContext) - (l.f(this.mContext, d.e.tbds44) * 2)) - l.f(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aow.getLayoutParams();
            layoutParams.height = ac;
            this.aow.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aos.getLayoutParams();
            layoutParams2.width = ac;
            layoutParams2.height = ac;
            this.aos.setLayoutParams(layoutParams2);
        }
    }
}
