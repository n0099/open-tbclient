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
    private TbImageView aGC;
    private TextView aGD;
    private TextView aGE;
    private TextView aGF;
    private ViewGroup aGG;
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
        this.aGG = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aGC = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aGC.setDefaultBgResource(e.f.icon_card_url_n);
        this.aGC.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aGD = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aGE = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aGF = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aGC.setLongIconSupport(false);
        this.aGC.setGifIconSupport(false);
        W(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.zU() == null || ao.isEmpty(bbVar.zU().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad zU = bbVar.zU();
        if (!zU.xz() && zU.xy() != ad.aon) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aGC.setPageId(this.mTag);
        if (zU.xz()) {
            this.aGF.setVisibility(0);
            this.aGD.setVisibility(8);
            this.aGE.setVisibility(8);
            this.aGF.setText(zU.getLinkUrl());
            this.aGC.reset();
        } else {
            this.aGF.setVisibility(8);
            String xv = zU.xv();
            String xw = zU.xw();
            if (!ao.isEmpty(xv)) {
                this.aGD.setText(xv);
                this.aGD.setVisibility(0);
                this.aGE.setVisibility(8);
            } else {
                this.aGD.setVisibility(8);
                if (!ao.isEmpty(xw)) {
                    this.aGE.setText(xw);
                    this.aGE.setVisibility(0);
                } else {
                    this.aGE.setVisibility(4);
                }
            }
            if (!ao.isEmpty(zU.xx())) {
                this.aGC.startLoad(zU.xx(), 10, false);
            } else {
                this.aGC.reset();
            }
        }
        ga(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aGC, e.d.cp_bg_line_b);
    }

    public void ga(String str) {
        com.baidu.tieba.card.o.a(this.aGD, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aGF, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aGE, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aGG != null && this.aGC != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aGG.getLayoutParams();
            layoutParams.height = aO;
            this.aGG.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aGC.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aGC.setLayoutParams(layoutParams2);
        }
    }
}
