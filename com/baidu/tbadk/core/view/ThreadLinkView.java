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
    private TbImageView bTs;
    private TextView bTt;
    private TextView bTu;
    private TextView bTv;
    private ViewGroup bTw;
    private View bTx;
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
        this.bTw = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bTs = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bTs.setDefaultBgResource(d.f.icon_card_url_n);
        this.bTs.setDefaultErrorResource(d.f.icon_card_url_n);
        this.bTt = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bTu = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bTv = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bTx = inflate.findViewById(d.g.link_thread_content);
        this.bTs.setLongIconSupport(false);
        this.bTs.setGifIconSupport(false);
        this.bTs.setRadius(com.baidu.adp.lib.util.l.h(context, d.e.tbds20));
        this.bTs.setConrers(5);
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
        if (!aaq.Xz() && aaq.Xy() != af.bzf) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bTs.setPageId(this.mTag);
        if (aaq.Xz()) {
            this.bTv.setVisibility(0);
            this.bTt.setVisibility(8);
            this.bTu.setVisibility(8);
            this.bTv.setText(aaq.getLinkUrl());
            this.bTs.reset();
        } else {
            this.bTv.setVisibility(8);
            String Xv = aaq.Xv();
            String Xw = aaq.Xw();
            if (!ap.isEmpty(Xv)) {
                this.bTt.setText(Xv);
                this.bTt.setVisibility(0);
                this.bTu.setVisibility(8);
            } else {
                this.bTt.setVisibility(8);
                if (!ap.isEmpty(Xw)) {
                    this.bTu.setText(Xw);
                    this.bTu.setVisibility(0);
                } else {
                    this.bTu.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aaq.Xx())) {
                this.bTs.startLoad(aaq.Xx(), 10, false);
            } else {
                this.bTs.reset();
            }
        }
        nt(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.bTx, d.C0236d.cp_bg_line_e);
        al.k(this.bTs, d.f.shape_link_thread_head_bg);
    }

    public void nt(String str) {
        com.baidu.tieba.card.n.a(this.bTt, str, d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTv, str, d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
        com.baidu.tieba.card.n.a(this.bTu, str, d.C0236d.cp_cont_j, d.C0236d.cp_cont_d);
    }

    private void aQ(View view) {
        if (this.bTw != null && this.bTs != null) {
            int aO = (((com.baidu.adp.lib.util.l.aO(this.mContext) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bTw.getLayoutParams();
            layoutParams.height = aO;
            this.bTw.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bTs.getLayoutParams();
            layoutParams2.width = aO;
            layoutParams2.height = aO;
            this.bTs.setLayoutParams(layoutParams2);
        }
    }
}
