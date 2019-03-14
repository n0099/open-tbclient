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
    private TbImageView bTt;
    private TextView bTu;
    private TextView bTv;
    private TextView bTw;
    private ViewGroup bTx;
    private View bTy;
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
        this.bTx = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bTt = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bTt.setDefaultBgResource(d.f.icon_card_url_n);
        this.bTt.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bTu = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bTv = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bTw = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bTy = inflate.findViewById(d.g.link_thread_content);
        this.bTt.setLongIconSupport(false);
        this.bTt.setGifIconSupport(false);
        this.bTt.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.tbds20));
        this.bTt.setConrers(5);
        aQ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bg bgVar) {
        if (bgVar == null || bgVar.aaq() == null || ap.isEmpty(bgVar.aaq().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af aaq = bgVar.aaq();
        if (!aaq.Xz() && aaq.Xy() != af.bzh) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTt.setPageId(this.mTag);
        if (aaq.Xz()) {
            this.bTw.setVisibility(0);
            this.bTu.setVisibility(8);
            this.bTv.setVisibility(8);
            this.bTw.setText(aaq.getLinkUrl());
            this.bTt.reset();
        } else {
            this.bTw.setVisibility(8);
            String Xv = aaq.Xv();
            String Xw = aaq.Xw();
            if (!ap.isEmpty(Xv)) {
                this.bTu.setText(Xv);
                this.bTu.setVisibility(0);
                this.bTv.setVisibility(8);
            } else {
                this.bTu.setVisibility(8);
                if (!ap.isEmpty(Xw)) {
                    this.bTv.setText(Xw);
                    this.bTv.setVisibility(0);
                } else {
                    this.bTv.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aaq.Xx())) {
                this.bTt.startLoad(aaq.Xx(), 10, false);
            } else {
                this.bTt.reset();
            }
        }
        nt(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.bTy, d.C0277d.cp_bg_line_e);
        al.k(this.bTt, d.f.shape_link_thread_head_bg);
    }

    public void nt(String str) {
        com.baidu.tieba.card.n.a(this.bTu, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTw, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTv, str, d.C0277d.cp_cont_j, d.C0277d.cp_cont_d);
    }

    private void aQ(View view) {
        if (this.bTx != null && this.bTt != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bTx.getLayoutParams();
            layoutParams.height = aO;
            this.bTx.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bTt.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.bTt.setLayoutParams(layoutParams2);
        }
    }
}
