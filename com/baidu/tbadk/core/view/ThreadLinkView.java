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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView anV;
    private TextView anW;
    private TextView anX;
    private TextView anY;
    private ViewGroup anZ;
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
        View inflate = LayoutInflater.from(context).inflate(d.j.link_thread_item, (ViewGroup) this, true);
        this.anZ = (ViewGroup) inflate.findViewById(d.h.root_layout);
        this.anV = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.anV.setDefaultBgResource(d.g.icon_card_url_n);
        this.anV.setDefaultErrorResource(d.g.icon_card_url_n);
        this.anW = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.anX = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.anY = (TextView) inflate.findViewById(d.h.link_thread_url);
        this.anV.setLongIconSupport(false);
        this.anV.setGifIconSupport(false);
        H(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.sM() == null || am.isEmpty(bhVar.sM().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ah sM = bhVar.sM();
        if (!sM.qg() && sM.qf() != ah.WR) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.anV.setPageId(this.mTag);
        if (sM.qg()) {
            this.anY.setVisibility(0);
            this.anW.setVisibility(8);
            this.anX.setVisibility(8);
            this.anY.setText(sM.getLinkUrl());
            this.anV.reset();
        } else {
            this.anY.setVisibility(8);
            String qc = sM.qc();
            String qd = sM.qd();
            if (!am.isEmpty(qc)) {
                this.anW.setText(qc);
                this.anW.setVisibility(0);
                this.anX.setVisibility(8);
            } else {
                this.anW.setVisibility(8);
                if (!am.isEmpty(qd)) {
                    this.anX.setText(qd);
                    this.anX.setVisibility(0);
                } else {
                    this.anX.setVisibility(4);
                }
            }
            if (!am.isEmpty(sM.qe())) {
                this.anV.c(sM.qe(), 10, false);
            } else {
                this.anV.reset();
            }
        }
        em(bhVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_e);
        aj.k(this.anV, d.e.cp_bg_line_b);
    }

    public void em(String str) {
        m.a(this.anW, str, d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.anY, str, d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.anX, str, d.e.cp_cont_f, d.e.cp_cont_d);
    }

    private void H(View view) {
        if (this.anZ != null && this.anV != null) {
            int ad = (((l.ad(this.mContext) - (l.f(this.mContext, d.f.ds34) * 2)) - (l.f(this.mContext, d.f.ds16) * 2)) - (l.f(this.mContext, d.f.ds16) * 5)) / 6;
            ViewGroup.LayoutParams layoutParams = this.anZ.getLayoutParams();
            layoutParams.height = ad;
            this.anZ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.anV.getLayoutParams();
            layoutParams2.width = ad;
            layoutParams2.height = ad;
            this.anV.setLayoutParams(layoutParams2);
        }
    }
}
