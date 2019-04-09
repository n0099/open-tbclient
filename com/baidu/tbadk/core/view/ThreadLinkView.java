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
    private ViewGroup bTA;
    private View bTB;
    private TbImageView bTw;
    private TextView bTx;
    private TextView bTy;
    private TextView bTz;
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
        this.bTA = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bTw = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bTw.setDefaultBgResource(d.f.icon_card_url_n);
        this.bTw.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bTx = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bTy = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bTz = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bTB = inflate.findViewById(d.g.link_thread_content);
        this.bTw.setLongIconSupport(false);
        this.bTw.setGifIconSupport(false);
        this.bTw.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.tbds20));
        this.bTw.setConrers(5);
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
        if (!aan.Xw() && aan.Xv() != af.bzl) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTw.setPageId(this.mTag);
        if (aan.Xw()) {
            this.bTz.setVisibility(0);
            this.bTx.setVisibility(8);
            this.bTy.setVisibility(8);
            this.bTz.setText(aan.getLinkUrl());
            this.bTw.reset();
        } else {
            this.bTz.setVisibility(8);
            String Xs = aan.Xs();
            String Xt = aan.Xt();
            if (!ap.isEmpty(Xs)) {
                this.bTx.setText(Xs);
                this.bTx.setVisibility(0);
                this.bTy.setVisibility(8);
            } else {
                this.bTx.setVisibility(8);
                if (!ap.isEmpty(Xt)) {
                    this.bTy.setText(Xt);
                    this.bTy.setVisibility(0);
                } else {
                    this.bTy.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aan.Xu())) {
                this.bTw.startLoad(aan.Xu(), 10, false);
            } else {
                this.bTw.reset();
            }
        }
        nu(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.bTB, d.C0277d.cp_bg_line_e);
        al.k(this.bTw, d.f.shape_link_thread_head_bg);
    }

    public void nu(String str) {
        com.baidu.tieba.card.n.a(this.bTx, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTz, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTy, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
    }

    private void aQ(View view) {
        if (this.bTA != null && this.bTw != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bTA.getLayoutParams();
            layoutParams.height = aO;
            this.bTA.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bTw.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.bTw.setLayoutParams(layoutParams2);
        }
    }
}
