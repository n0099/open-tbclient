package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView bcC;
    private TextView bcD;
    private TextView bcE;
    private TextView bcF;
    private ViewGroup bcG;
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
        this.bcG = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bcC = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bcC.setDefaultBgResource(d.f.icon_card_url_n);
        this.bcC.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bcD = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bcE = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bcF = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bcC.setLongIconSupport(false);
        this.bcC.setGifIconSupport(false);
        bb(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.Ai() == null || am.isEmpty(bdVar.Ai().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad Ai = bdVar.Ai();
        if (!Ai.xG() && Ai.xF() != ad.aLK) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bcC.setPageId(this.mTag);
        if (Ai.xG()) {
            this.bcF.setVisibility(0);
            this.bcD.setVisibility(8);
            this.bcE.setVisibility(8);
            this.bcF.setText(Ai.getLinkUrl());
            this.bcC.reset();
        } else {
            this.bcF.setVisibility(8);
            String xC = Ai.xC();
            String xD = Ai.xD();
            if (!am.isEmpty(xC)) {
                this.bcD.setText(xC);
                this.bcD.setVisibility(0);
                this.bcE.setVisibility(8);
            } else {
                this.bcD.setVisibility(8);
                if (!am.isEmpty(xD)) {
                    this.bcE.setText(xD);
                    this.bcE.setVisibility(0);
                } else {
                    this.bcE.setVisibility(4);
                }
            }
            if (!am.isEmpty(Ai.xE())) {
                this.bcC.startLoad(Ai.xE(), 10, false);
            } else {
                this.bcC.reset();
            }
        }
        eL(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0108d.cp_bg_line_e);
        aj.t(this.bcC, d.C0108d.cp_bg_line_b);
    }

    public void eL(String str) {
        com.baidu.tieba.card.k.a(this.bcD, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.bcF, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.bcE, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
    }

    private void bb(View view) {
        if (this.bcG != null && this.bcC != null) {
            int ao = ((com.baidu.adp.lib.util.l.ao(this.mContext) - (com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bcG.getLayoutParams();
            layoutParams.height = ao;
            this.bcG.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bcC.getLayoutParams();
            layoutParams2.width = ao;
            layoutParams2.height = ao;
            this.bcC.setLayoutParams(layoutParams2);
        }
    }
}
