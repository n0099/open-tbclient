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
    private TbImageView aKc;
    private TextView aKd;
    private TextView aKe;
    private TextView aKf;
    private ViewGroup aKg;
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
        this.aKg = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aKc = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aKc.setDefaultBgResource(e.f.icon_card_url_n);
        this.aKc.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aKd = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aKe = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aKf = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aKc.setLongIconSupport(false);
        this.aKc.setGifIconSupport(false);
        W(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.AY() == null || ao.isEmpty(bbVar.AY().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad AY = bbVar.AY();
        if (!AY.yD() && AY.yC() != ad.arO) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.aKc.setPageId(this.mTag);
        if (AY.yD()) {
            this.aKf.setVisibility(0);
            this.aKd.setVisibility(8);
            this.aKe.setVisibility(8);
            this.aKf.setText(AY.getLinkUrl());
            this.aKc.reset();
        } else {
            this.aKf.setVisibility(8);
            String yz = AY.yz();
            String yA = AY.yA();
            if (!ao.isEmpty(yz)) {
                this.aKd.setText(yz);
                this.aKd.setVisibility(0);
                this.aKe.setVisibility(8);
            } else {
                this.aKd.setVisibility(8);
                if (!ao.isEmpty(yA)) {
                    this.aKe.setText(yA);
                    this.aKe.setVisibility(0);
                } else {
                    this.aKe.setVisibility(4);
                }
            }
            if (!ao.isEmpty(AY.yB())) {
                this.aKc.startLoad(AY.yB(), 10, false);
            } else {
                this.aKc.reset();
            }
        }
        gt(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aKc, e.d.cp_bg_line_b);
    }

    public void gt(String str) {
        com.baidu.tieba.card.o.a(this.aKd, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKf, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKe, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aKg != null && this.aKc != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aKg.getLayoutParams();
            layoutParams.height = aO;
            this.aKg.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aKc.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aKc.setLayoutParams(layoutParams2);
        }
    }
}
