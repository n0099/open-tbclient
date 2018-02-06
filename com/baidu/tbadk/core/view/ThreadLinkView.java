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
    private TbImageView bes;
    private TextView beu;
    private TextView bev;
    private TextView bew;
    private ViewGroup bex;
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
        this.bex = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.bes = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.bes.setDefaultBgResource(d.f.icon_card_url_n);
        this.bes.setDefaultErrorResource(d.f.icon_card_url_n);
        this.beu = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bev = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bew = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.bes.setLongIconSupport(false);
        this.bes.setGifIconSupport(false);
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
        if (!AB.ym() && AB.yl() != ad.aNd) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.bes.setPageId(this.mTag);
        if (AB.ym()) {
            this.bew.setVisibility(0);
            this.beu.setVisibility(8);
            this.bev.setVisibility(8);
            this.bew.setText(AB.getLinkUrl());
            this.bes.reset();
        } else {
            this.bew.setVisibility(8);
            String yi = AB.yi();
            String yj = AB.yj();
            if (!am.isEmpty(yi)) {
                this.beu.setText(yi);
                this.beu.setVisibility(0);
                this.bev.setVisibility(8);
            } else {
                this.beu.setVisibility(8);
                if (!am.isEmpty(yj)) {
                    this.bev.setText(yj);
                    this.bev.setVisibility(0);
                } else {
                    this.bev.setVisibility(4);
                }
            }
            if (!am.isEmpty(AB.yk())) {
                this.bes.startLoad(AB.yk(), 10, false);
            } else {
                this.bes.reset();
            }
        }
        eW(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0140d.cp_bg_line_e);
        aj.t(this.bes, d.C0140d.cp_bg_line_b);
    }

    public void eW(String str) {
        com.baidu.tieba.card.j.a(this.beu, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bew, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bev, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
    }

    private void bb(View view) {
        if (this.bex != null && this.bes != null) {
            int ao = ((com.baidu.adp.lib.util.l.ao(this.mContext) - (com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bex.getLayoutParams();
            layoutParams.height = ao;
            this.bex.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.bes.getLayoutParams();
            layoutParams2.width = ao;
            layoutParams2.height = ao;
            this.bes.setLayoutParams(layoutParams2);
        }
    }
}
