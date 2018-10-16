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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView aFM;
    private TextView aFN;
    private TextView aFO;
    private TextView aFP;
    private ViewGroup aFQ;
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
        View inflate = LayoutInflater.from(context).inflate(e.h.link_thread_item, (ViewGroup) this, true);
        this.aFQ = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aFM = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aFM.setDefaultBgResource(e.f.icon_card_url_n);
        this.aFM.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aFN = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aFO = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aFP = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aFM.setLongIconSupport(false);
        this.aFM.setGifIconSupport(false);
        W(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.zN() == null || ao.isEmpty(bbVar.zN().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad zN = bbVar.zN();
        if (!zN.xr() && zN.xq() != ad.anA) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aFM.setPageId(this.mTag);
        if (zN.xr()) {
            this.aFP.setVisibility(0);
            this.aFN.setVisibility(8);
            this.aFO.setVisibility(8);
            this.aFP.setText(zN.getLinkUrl());
            this.aFM.reset();
        } else {
            this.aFP.setVisibility(8);
            String xn = zN.xn();
            String xo = zN.xo();
            if (!ao.isEmpty(xn)) {
                this.aFN.setText(xn);
                this.aFN.setVisibility(0);
                this.aFO.setVisibility(8);
            } else {
                this.aFN.setVisibility(8);
                if (!ao.isEmpty(xo)) {
                    this.aFO.setText(xo);
                    this.aFO.setVisibility(0);
                } else {
                    this.aFO.setVisibility(4);
                }
            }
            if (!ao.isEmpty(zN.xp())) {
                this.aFM.startLoad(zN.xp(), 10, false);
            } else {
                this.aFM.reset();
            }
        }
        fZ(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aFM, e.d.cp_bg_line_b);
    }

    public void fZ(String str) {
        com.baidu.tieba.card.o.a(this.aFN, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aFP, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aFO, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aFQ != null && this.aFM != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aFQ.getLayoutParams();
            layoutParams.height = aO;
            this.aFQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aFM.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aFM.setLayoutParams(layoutParams2);
        }
    }
}
