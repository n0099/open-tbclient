package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView bcu;
    private TextView bcv;
    private TextView bcw;
    private TextView bcx;
    private ViewGroup bcy;
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
        this.bcy = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bcu = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bcu.setDefaultBgResource(d.f.icon_card_url_n);
        this.bcu.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bcv = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bcw = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bcx = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bcu.setLongIconSupport(false);
        this.bcu.setGifIconSupport(false);
        bb(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(be beVar) {
        if (beVar == null || beVar.Ap() == null || am.isEmpty(beVar.Ap().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ae Ap = beVar.Ap();
        if (!Ap.xI() && Ap.xH() != ae.aLL) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bcu.setPageId(this.mTag);
        if (Ap.xI()) {
            this.bcx.setVisibility(0);
            this.bcv.setVisibility(8);
            this.bcw.setVisibility(8);
            this.bcx.setText(Ap.getLinkUrl());
            this.bcu.reset();
        } else {
            this.bcx.setVisibility(8);
            String xE = Ap.xE();
            String xF = Ap.xF();
            if (!am.isEmpty(xE)) {
                this.bcv.setText(xE);
                this.bcv.setVisibility(0);
                this.bcw.setVisibility(8);
            } else {
                this.bcv.setVisibility(8);
                if (!am.isEmpty(xF)) {
                    this.bcw.setText(xF);
                    this.bcw.setVisibility(0);
                } else {
                    this.bcw.setVisibility(4);
                }
            }
            if (!am.isEmpty(Ap.xG())) {
                this.bcu.startLoad(Ap.xG(), 10, false);
            } else {
                this.bcu.reset();
            }
        }
        eD(beVar.getId());
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0108d.cp_bg_line_e);
        aj.t(this.bcu, d.C0108d.cp_bg_line_b);
    }

    public void eD(String str) {
        com.baidu.tieba.card.k.a(this.bcv, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.bcx, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
        com.baidu.tieba.card.k.a(this.bcw, str, d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
    }

    private void bb(View view) {
        if (this.bcy != null && this.bcu != null) {
            int ao = ((com.baidu.adp.lib.util.l.ao(this.mContext) - (com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bcy.getLayoutParams();
            layoutParams.height = ao;
            this.bcy.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bcu.getLayoutParams();
            layoutParams2.width = ao;
            layoutParams2.height = ao;
            this.bcu.setLayoutParams(layoutParams2);
        }
    }
}
