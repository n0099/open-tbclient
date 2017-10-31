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
    private TbImageView aoe;
    private TextView aof;
    private TextView aog;
    private TextView aoh;
    private ViewGroup aoi;
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
        this.aoi = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.aoe = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.aoe.setDefaultBgResource(d.f.icon_card_url_n);
        this.aoe.setDefaultErrorResource(d.f.icon_card_url_n);
        this.aof = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.aog = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.aoh = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.aoe.setLongIconSupport(false);
        this.aoe.setGifIconSupport(false);
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
        if (!sM.qe() && sM.qd() != ah.WX) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aoe.setPageId(this.mTag);
        if (sM.qe()) {
            this.aoh.setVisibility(0);
            this.aof.setVisibility(8);
            this.aog.setVisibility(8);
            this.aoh.setText(sM.getLinkUrl());
            this.aoe.reset();
        } else {
            this.aoh.setVisibility(8);
            String qa = sM.qa();
            String qb = sM.qb();
            if (!am.isEmpty(qa)) {
                this.aof.setText(qa);
                this.aof.setVisibility(0);
                this.aog.setVisibility(8);
            } else {
                this.aof.setVisibility(8);
                if (!am.isEmpty(qb)) {
                    this.aog.setText(qb);
                    this.aog.setVisibility(0);
                } else {
                    this.aog.setVisibility(4);
                }
            }
            if (!am.isEmpty(sM.qc())) {
                this.aoe.startLoad(sM.qc(), 10, false);
            } else {
                this.aoe.reset();
            }
        }
        er(bhVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0080d.cp_bg_line_e);
        aj.k(this.aoe, d.C0080d.cp_bg_line_b);
    }

    public void er(String str) {
        m.a(this.aof, str, d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        m.a(this.aoh, str, d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
        m.a(this.aog, str, d.C0080d.cp_cont_f, d.C0080d.cp_cont_d);
    }

    private void H(View view) {
        if (this.aoi != null && this.aoe != null) {
            int ac = (((l.ac(this.mContext) - (l.f(this.mContext, d.e.ds34) * 2)) - (l.f(this.mContext, d.e.ds16) * 2)) - (l.f(this.mContext, d.e.ds16) * 5)) / 6;
            ViewGroup.LayoutParams layoutParams = this.aoi.getLayoutParams();
            layoutParams.height = ac;
            this.aoi.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aoe.getLayoutParams();
            layoutParams2.width = ac;
            layoutParams2.height = ac;
            this.aoe.setLayoutParams(layoutParams2);
        }
    }
}
