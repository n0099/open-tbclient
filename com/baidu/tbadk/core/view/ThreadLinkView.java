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
    private TbImageView aKe;
    private TextView aKf;
    private TextView aKg;
    private TextView aKh;
    private ViewGroup aKi;
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
        this.aKi = (ViewGroup) inflate.findViewById(e.g.root_layout);
        this.aKe = (TbImageView) inflate.findViewById(e.g.link_thread_head_img);
        this.aKe.setDefaultBgResource(e.f.icon_card_url_n);
        this.aKe.setDefaultErrorResource(e.f.icon_card_url_n);
        this.aKf = (TextView) inflate.findViewById(e.g.link_thread_title);
        this.aKg = (TextView) inflate.findViewById(e.g.link_thread_abstract);
        this.aKh = (TextView) inflate.findViewById(e.g.link_thread_url);
        this.aKe.setLongIconSupport(false);
        this.aKe.setGifIconSupport(false);
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
        this.aKe.setPageId(this.mTag);
        if (AY.yD()) {
            this.aKh.setVisibility(0);
            this.aKf.setVisibility(8);
            this.aKg.setVisibility(8);
            this.aKh.setText(AY.getLinkUrl());
            this.aKe.reset();
        } else {
            this.aKh.setVisibility(8);
            String yz = AY.yz();
            String yA = AY.yA();
            if (!ao.isEmpty(yz)) {
                this.aKf.setText(yz);
                this.aKf.setVisibility(0);
                this.aKg.setVisibility(8);
            } else {
                this.aKf.setVisibility(8);
                if (!ao.isEmpty(yA)) {
                    this.aKg.setText(yA);
                    this.aKg.setVisibility(0);
                } else {
                    this.aKg.setVisibility(4);
                }
            }
            if (!ao.isEmpty(AY.yB())) {
                this.aKe.startLoad(AY.yB(), 10, false);
            } else {
                this.aKe.reset();
            }
        }
        gu(bbVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_e);
        al.j(this.aKe, e.d.cp_bg_line_b);
    }

    public void gu(String str) {
        com.baidu.tieba.card.o.a(this.aKf, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKh, str, e.d.cp_cont_j, e.d.cp_cont_d);
        com.baidu.tieba.card.o.a(this.aKg, str, e.d.cp_cont_j, e.d.cp_cont_d);
    }

    private void W(View view) {
        if (this.aKi != null && this.aKe != null) {
            int aO = ((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds44) * 2)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aKi.getLayoutParams();
            layoutParams.height = aO;
            this.aKi.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.aKe.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.aKe.setLayoutParams(layoutParams2);
        }
    }
}
