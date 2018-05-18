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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView apA;
    private TextView apB;
    private TextView apC;
    private TextView apD;
    private ViewGroup apE;
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
        View inflate = LayoutInflater.from(context).inflate(d.i.link_thread_item, (ViewGroup) this, true);
        this.apE = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.apA = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.apA.setDefaultBgResource(d.f.icon_card_url_n);
        this.apA.setDefaultErrorResource(d.f.icon_card_url_n);
        this.apB = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.apC = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.apD = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.apA.setLongIconSupport(false);
        this.apA.setGifIconSupport(false);
        J(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.tc() == null || an.isEmpty(bdVar.tc().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ae tc = bdVar.tc();
        if (!tc.qR() && tc.qQ() != ae.Yu) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.apA.setPageId(this.mTag);
        if (tc.qR()) {
            this.apD.setVisibility(0);
            this.apB.setVisibility(8);
            this.apC.setVisibility(8);
            this.apD.setText(tc.getLinkUrl());
            this.apA.reset();
        } else {
            this.apD.setVisibility(8);
            String qN = tc.qN();
            String qO = tc.qO();
            if (!an.isEmpty(qN)) {
                this.apB.setText(qN);
                this.apB.setVisibility(0);
                this.apC.setVisibility(8);
            } else {
                this.apB.setVisibility(8);
                if (!an.isEmpty(qO)) {
                    this.apC.setText(qO);
                    this.apC.setVisibility(0);
                } else {
                    this.apC.setVisibility(4);
                }
            }
            if (!an.isEmpty(tc.qP())) {
                this.apA.startLoad(tc.qP(), 10, false);
            } else {
                this.apA.reset();
            }
        }
        eO(bdVar.getId());
    }

    public void onChangeSkinType() {
        ak.j(this, d.C0126d.cp_bg_line_e);
        ak.j(this.apA, d.C0126d.cp_bg_line_b);
    }

    public void eO(String str) {
        o.a(this.apB, str, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
        o.a(this.apD, str, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
        o.a(this.apC, str, d.C0126d.cp_cont_j, d.C0126d.cp_cont_d);
    }

    private void J(View view2) {
        if (this.apE != null && this.apA != null) {
            int af = ((l.af(this.mContext) - (l.e(this.mContext, d.e.tbds44) * 2)) - l.e(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.apE.getLayoutParams();
            layoutParams.height = af;
            this.apE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.apA.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.apA.setLayoutParams(layoutParams2);
        }
    }
}
