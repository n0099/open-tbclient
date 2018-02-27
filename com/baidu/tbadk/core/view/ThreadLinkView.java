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
    private TbImageView beg;
    private TextView beh;
    private TextView bei;
    private TextView bej;
    private ViewGroup bek;
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
        this.bek = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.beg = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.beg.setDefaultBgResource(d.f.icon_card_url_n);
        this.beg.setDefaultErrorResource(d.f.icon_card_url_n);
        this.beh = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.bei = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.bej = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.beg.setLongIconSupport(false);
        this.beg.setGifIconSupport(false);
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
        if (!AB.ym() && AB.yl() != ad.aMS) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.beg.setPageId(this.mTag);
        if (AB.ym()) {
            this.bej.setVisibility(0);
            this.beh.setVisibility(8);
            this.bei.setVisibility(8);
            this.bej.setText(AB.getLinkUrl());
            this.beg.reset();
        } else {
            this.bej.setVisibility(8);
            String yi = AB.yi();
            String yj = AB.yj();
            if (!am.isEmpty(yi)) {
                this.beh.setText(yi);
                this.beh.setVisibility(0);
                this.bei.setVisibility(8);
            } else {
                this.beh.setVisibility(8);
                if (!am.isEmpty(yj)) {
                    this.bei.setText(yj);
                    this.bei.setVisibility(0);
                } else {
                    this.bei.setVisibility(4);
                }
            }
            if (!am.isEmpty(AB.yk())) {
                this.beg.startLoad(AB.yk(), 10, false);
            } else {
                this.beg.reset();
            }
        }
        eW(bdVar.getId());
    }

    public void onChangeSkinType() {
        aj.t(this, d.C0141d.cp_bg_line_e);
        aj.t(this.beg, d.C0141d.cp_bg_line_b);
    }

    public void eW(String str) {
        com.baidu.tieba.card.j.a(this.beh, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bej, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        com.baidu.tieba.card.j.a(this.bei, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
    }

    private void bb(View view) {
        if (this.bek != null && this.beg != null) {
            int ao = ((com.baidu.adp.lib.util.l.ao(this.mContext) - (com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.bek.getLayoutParams();
            layoutParams.height = ao;
            this.bek.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.beg.getLayoutParams();
            layoutParams2.width = ao;
            layoutParams2.height = ao;
            this.beg.setLayoutParams(layoutParams2);
        }
    }
}
