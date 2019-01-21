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
    private TbImageView aKH;
    private TextView aKI;
    private TextView aKJ;
    private TextView aKK;
    private ViewGroup aKL;
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
        this.aKL = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aKH = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aKH.setDefaultBgResource(e.f.icon_card_url_n);
        this.aKH.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aKI = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aKJ = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aKK = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aKH.setLongIconSupport(false);
        this.aKH.setGifIconSupport(false);
        W(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.Bl() == null || ao.isEmpty(bbVar.Bl().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad Bl = bbVar.Bl();
        if (!Bl.yQ() && Bl.yP() != ad.asr) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aKH.setPageId(this.mTag);
        if (Bl.yQ()) {
            this.aKK.setVisibility(0);
            this.aKI.setVisibility(8);
            this.aKJ.setVisibility(8);
            this.aKK.setText(Bl.getLinkUrl());
            this.aKH.reset();
        } else {
            this.aKK.setVisibility(8);
            String yM = Bl.yM();
            String yN = Bl.yN();
            if (!ao.isEmpty(yM)) {
                this.aKI.setText(yM);
                this.aKI.setVisibility(0);
                this.aKJ.setVisibility(8);
            } else {
                this.aKI.setVisibility(8);
                if (!ao.isEmpty(yN)) {
                    this.aKJ.setText(yN);
                    this.aKJ.setVisibility(0);
                } else {
                    this.aKJ.setVisibility(4);
                }
            }
            if (!ao.isEmpty(Bl.yO())) {
                this.aKH.startLoad(Bl.yO(), 10, false);
            } else {
                this.aKH.reset();
            }
        }
        gH(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aKH, e.d.cp_bg_line_b);
    }

    public void gH(String str) {
        com.baidu.tieba.card.o.a(this.aKI, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKK, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKJ, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aKL != null && this.aKH != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aKL.getLayoutParams();
            layoutParams.height = aO;
            this.aKL.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aKH.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aKH.setLayoutParams(layoutParams2);
        }
    }
}
