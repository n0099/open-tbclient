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
    private TbImageView aBf;
    private TextView aBg;
    private TextView aBh;
    private TextView aBi;
    private ViewGroup aBj;
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
        this.aBj = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aBf = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aBf.setDefaultBgResource(e.f.icon_card_url_n);
        this.aBf.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aBg = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aBh = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aBi = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aBf.setLongIconSupport(false);
        this.aBf.setGifIconSupport(false);
        W(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.xE() == null || ao.isEmpty(bbVar.xE().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad xE = bbVar.xE();
        if (!xE.vi() && xE.vh() != ad.aiF) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aBf.setPageId(this.mTag);
        if (xE.vi()) {
            this.aBi.setVisibility(0);
            this.aBg.setVisibility(8);
            this.aBh.setVisibility(8);
            this.aBi.setText(xE.getLinkUrl());
            this.aBf.reset();
        } else {
            this.aBi.setVisibility(8);
            String ve = xE.ve();
            String vf = xE.vf();
            if (!ao.isEmpty(ve)) {
                this.aBg.setText(ve);
                this.aBg.setVisibility(0);
                this.aBh.setVisibility(8);
            } else {
                this.aBg.setVisibility(8);
                if (!ao.isEmpty(vf)) {
                    this.aBh.setText(vf);
                    this.aBh.setVisibility(0);
                } else {
                    this.aBh.setVisibility(4);
                }
            }
            if (!ao.isEmpty(xE.vg())) {
                this.aBf.startLoad(xE.vg(), 10, false);
            } else {
                this.aBf.reset();
            }
        }
        fL(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aBf, e.d.cp_bg_line_b);
    }

    public void fL(String str) {
        com.baidu.tieba.card.o.a(this.aBg, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aBi, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aBh, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aBj != null && this.aBf != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aBj.getLayoutParams();
            layoutParams.height = aO;
            this.aBj.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aBf.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aBf.setLayoutParams(layoutParams2);
        }
    }
}
