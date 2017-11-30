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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView aoq;
    private TextView aor;
    private TextView aos;
    private TextView aot;
    private ViewGroup aou;
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
        this.aou = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.aoq = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.aoq.setDefaultBgResource(d.f.icon_card_url_n);
        this.aoq.setDefaultErrorResource(d.f.icon_card_url_n);
        this.aor = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.aos = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.aot = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.aoq.setLongIconSupport(false);
        this.aoq.setGifIconSupport(false);
        H(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.sP() == null || am.isEmpty(bdVar.sP().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad sP = bdVar.sP();
        if (!sP.qh() && sP.qg() != ad.Xq) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aoq.setPageId(this.mTag);
        if (sP.qh()) {
            this.aot.setVisibility(0);
            this.aor.setVisibility(8);
            this.aos.setVisibility(8);
            this.aot.setText(sP.getLinkUrl());
            this.aoq.reset();
        } else {
            this.aot.setVisibility(8);
            String qd = sP.qd();
            String qe = sP.qe();
            if (!am.isEmpty(qd)) {
                this.aor.setText(qd);
                this.aor.setVisibility(0);
                this.aos.setVisibility(8);
            } else {
                this.aor.setVisibility(8);
                if (!am.isEmpty(qe)) {
                    this.aos.setText(qe);
                    this.aos.setVisibility(0);
                } else {
                    this.aos.setVisibility(4);
                }
            }
            if (!am.isEmpty(sP.qf())) {
                this.aoq.startLoad(sP.qf(), 10, false);
            } else {
                this.aoq.reset();
            }
        }
        ew(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.k(this, d.C0082d.cp_bg_line_e);
        aj.k(this.aoq, d.C0082d.cp_bg_line_b);
    }

    public void ew(String str) {
        k.a(this.aor, str, d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
        k.a(this.aot, str, d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
        k.a(this.aos, str, d.C0082d.cp_cont_j, d.C0082d.cp_cont_d);
    }

    private void H(View view) {
        if (this.aou != null && this.aoq != null) {
            int ac = ((l.ac(this.mContext) - (l.f(this.mContext, d.e.tbds44) * 2)) - l.f(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aou.getLayoutParams();
            layoutParams.height = ac;
            this.aou.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aoq.getLayoutParams();
            layoutParams2.width = ac;
            layoutParams2.height = ac;
            this.aoq.setLayoutParams(layoutParams2);
        }
    }
}
