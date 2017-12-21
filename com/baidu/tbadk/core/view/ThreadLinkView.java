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
    private TbImageView aov;
    private TextView aow;
    private TextView aox;
    private TextView aoy;
    private ViewGroup aoz;
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
        this.aoz = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.aov = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.aov.setDefaultBgResource(d.f.icon_card_url_n);
        this.aov.setDefaultErrorResource(d.f.icon_card_url_n);
        this.aow = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.aox = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.aoy = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.aov.setLongIconSupport(false);
        this.aov.setGifIconSupport(false);
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
        if (!sN.qf() && sN.qe() != ad.Xn) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aov.setPageId(this.mTag);
        if (sN.qf()) {
            this.aoy.setVisibility(0);
            this.aow.setVisibility(8);
            this.aox.setVisibility(8);
            this.aoy.setText(sN.getLinkUrl());
            this.aov.reset();
        } else {
            this.aoy.setVisibility(8);
            String qb = sN.qb();
            String qc = sN.qc();
            if (!am.isEmpty(qb)) {
                this.aow.setText(qb);
                this.aow.setVisibility(0);
                this.aox.setVisibility(8);
            } else {
                this.aow.setVisibility(8);
                if (!am.isEmpty(qc)) {
                    this.aox.setText(qc);
                    this.aox.setVisibility(0);
                } else {
                    this.aox.setVisibility(4);
                }
            }
            if (!am.isEmpty(sN.qd())) {
                this.aov.startLoad(sN.qd(), 10, false);
            } else {
                this.aov.reset();
            }
        }
        ew(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0095d.cp_bg_line_e);
        aj.k(this.aov, d.C0095d.cp_bg_line_b);
    }

    public void ew(String str) {
        com.baidu.tieba.card.k.a(this.aow, str, d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.aoy, str, d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.aox, str, d.C0095d.cp_cont_j, d.C0095d.cp_cont_d);
    }

    private void I(View view) {
        if (this.aoz != null && this.aov != null) {
            int ac = ((l.ac(this.mContext) - (l.f(this.mContext, d.e.tbds44) * 2)) - l.f(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aoz.getLayoutParams();
            layoutParams.height = ac;
            this.aoz.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aov.getLayoutParams();
            layoutParams2.width = ac;
            layoutParams2.height = ac;
            this.aov.setLayoutParams(layoutParams2);
        }
    }
}
