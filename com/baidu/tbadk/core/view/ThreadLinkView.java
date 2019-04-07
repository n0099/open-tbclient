package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private View bTA;
    private TbImageView bTv;
    private TextView bTw;
    private TextView bTx;
    private TextView bTy;
    private ViewGroup bTz;
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
        this.bTz = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bTv = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bTv.setDefaultBgResource(d.f.icon_card_url_n);
        this.bTv.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bTw = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bTx = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bTy = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bTA = inflate.findViewById(d.g.link_thread_content);
        this.bTv.setLongIconSupport(false);
        this.bTv.setGifIconSupport(false);
        this.bTv.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.tbds20));
        this.bTv.setConrers(5);
        aQ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bg bgVar) {
        if (bgVar == null || bgVar.aan() == null || ap.isEmpty(bgVar.aan().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af aan = bgVar.aan();
        if (!aan.Xw() && aan.Xv() != af.bzk) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTv.setPageId(this.mTag);
        if (aan.Xw()) {
            this.bTy.setVisibility(0);
            this.bTw.setVisibility(8);
            this.bTx.setVisibility(8);
            this.bTy.setText(aan.getLinkUrl());
            this.bTv.reset();
        } else {
            this.bTy.setVisibility(8);
            String Xs = aan.Xs();
            String Xt = aan.Xt();
            if (!ap.isEmpty(Xs)) {
                this.bTw.setText(Xs);
                this.bTw.setVisibility(0);
                this.bTx.setVisibility(8);
            } else {
                this.bTw.setVisibility(8);
                if (!ap.isEmpty(Xt)) {
                    this.bTx.setText(Xt);
                    this.bTx.setVisibility(0);
                } else {
                    this.bTx.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aan.Xu())) {
                this.bTv.startLoad(aan.Xu(), 10, false);
            } else {
                this.bTv.reset();
            }
        }
        nu(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.bTA, d.C0277d.cp_bg_line_e);
        al.k(this.bTv, d.f.shape_link_thread_head_bg);
    }

    public void nu(String str) {
        com.baidu.tieba.card.n.a(this.bTw, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTy, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTx, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
    }

    private void aQ(View view) {
        if (this.bTz != null && this.bTv != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bTz.getLayoutParams();
            layoutParams.height = aO;
            this.bTz.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bTv.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.bTv.setLayoutParams(layoutParams2);
        }
    }
}
