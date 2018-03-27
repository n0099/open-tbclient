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
    private TbImageView bej;
    private TextView bek;
    private TextView bel;
    private TextView bem;
    private ViewGroup ben;
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
        this.ben = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bej = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bej.setDefaultBgResource(d.f.icon_card_url_n);
        this.bej.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bek = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bel = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bem = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bej.setLongIconSupport(false);
        this.bej.setGifIconSupport(false);
        bb(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.AB() == null || am.isEmpty(bdVar.AB().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad AB = bdVar.AB();
        if (!AB.ym() && AB.yl() != ad.aMT) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bej.setPageId(this.mTag);
        this.bej.changeGrayScaleMode(bdVar.AC());
        if (AB.ym()) {
            this.bem.setVisibility(0);
            this.bek.setVisibility(8);
            this.bel.setVisibility(8);
            this.bem.setText(AB.getLinkUrl());
            this.bej.reset();
        } else {
            this.bem.setVisibility(8);
            String yi = AB.yi();
            String yj = AB.yj();
            if (!am.isEmpty(yi)) {
                this.bek.setText(yi);
                this.bek.setVisibility(0);
                this.bel.setVisibility(8);
            } else {
                this.bek.setVisibility(8);
                if (!am.isEmpty(yj)) {
                    this.bel.setText(yj);
                    this.bel.setVisibility(0);
                } else {
                    this.bel.setVisibility(4);
                }
            }
            if (!am.isEmpty(AB.yk())) {
                this.bej.startLoad(AB.yk(), 10, false);
            } else {
                this.bej.reset();
            }
        }
        eW(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0141d.cp_bg_line_e);
        aj.t(this.bej, d.C0141d.cp_bg_line_b);
    }

    public void eW(String str) {
        com.baidu.tieba.card.j.a(this.bek, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bem, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bel, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
    }

    private void bb(View view) {
        if (this.ben != null && this.bej != null) {
            int ao = ((com.baidu.adp.lib.util.l.ao(this.mContext) - (com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ben.getLayoutParams();
            layoutParams.height = ao;
            this.ben.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bej.getLayoutParams();
            layoutParams2.width = ao;
            layoutParams2.height = ao;
            this.bej.setLayoutParams(layoutParams2);
        }
    }
}
