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
    private TbImageView anJ;
    private TextView anK;
    private TextView anL;
    private TextView anM;
    private ViewGroup anN;
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
        this.anN = (ViewGroup) inflate.findViewById(d.h.root_layout);
        this.anJ = (TbImageView) inflate.findViewById(d.h.link_thread_head_img);
        this.anJ.setDefaultBgResource(d.g.icon_card_url_n);
        this.anJ.setDefaultErrorResource(d.g.icon_card_url_n);
        this.anK = (TextView) inflate.findViewById(d.h.link_thread_title);
        this.anL = (TextView) inflate.findViewById(d.h.link_thread_abstract);
        this.anM = (TextView) inflate.findViewById(d.h.link_thread_url);
        this.anJ.setLongIconSupport(false);
        this.anJ.setGifIconSupport(false);
        H(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.sF() == null || am.isEmpty(bhVar.sF().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ah sF = bhVar.sF();
        if (!sF.pZ() && sF.pY() != ah.WF) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.anJ.setPageId(this.mTag);
        if (sF.pZ()) {
            this.anM.setVisibility(0);
            this.anK.setVisibility(8);
            this.anL.setVisibility(8);
            this.anM.setText(sF.getLinkUrl());
            this.anJ.reset();
        } else {
            this.anM.setVisibility(8);
            String pV = sF.pV();
            String pW = sF.pW();
            if (!am.isEmpty(pV)) {
                this.anK.setText(pV);
                this.anK.setVisibility(0);
                this.anL.setVisibility(8);
            } else {
                this.anK.setVisibility(8);
                if (!am.isEmpty(pW)) {
                    this.anL.setText(pW);
                    this.anL.setVisibility(0);
                } else {
                    this.anL.setVisibility(4);
                }
            }
            if (!am.isEmpty(sF.pX())) {
                this.anJ.c(sF.pX(), 10, false);
            } else {
                this.anJ.reset();
            }
        }
        el(bhVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.e.cp_bg_line_e);
        aj.k(this.anJ, d.e.cp_bg_line_b);
    }

    public void el(String str) {
        m.a(this.anK, str, d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.anM, str, d.e.cp_cont_f, d.e.cp_cont_d);
        m.a(this.anL, str, d.e.cp_cont_f, d.e.cp_cont_d);
    }

    private void H(View view) {
        if (this.anN != null && this.anJ != null) {
            int ad = (((l.ad(this.mContext) - (l.f(this.mContext, d.f.ds34) * 2)) - (l.f(this.mContext, d.f.ds16) * 2)) - (l.f(this.mContext, d.f.ds16) * 5)) / 6;
            ViewGroup.LayoutParams layoutParams = this.anN.getLayoutParams();
            layoutParams.height = ad;
            this.anN.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.anJ.getLayoutParams();
            layoutParams2.width = ad;
            layoutParams2.height = ad;
            this.anJ.setLayoutParams(layoutParams2);
        }
    }
}
