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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView ayi;
    private TextView ayj;
    private TextView ayk;
    private TextView ayl;
    private ViewGroup aym;
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
        View inflate = LayoutInflater.from(context).inflate(f.h.link_thread_item, (ViewGroup) this, true);
        this.aym = (ViewGroup) inflate.findViewById(f.g.root_layout);
        this.ayi = (TbImageView) inflate.findViewById(f.g.link_thread_head_img);
        this.ayi.setDefaultBgResource(f.C0146f.icon_card_url_n);
        this.ayi.setDefaultErrorResource(f.C0146f.icon_card_url_n);
        this.ayj = (TextView) inflate.findViewById(f.g.link_thread_title);
        this.ayk = (TextView) inflate.findViewById(f.g.link_thread_abstract);
        this.ayl = (TextView) inflate.findViewById(f.g.link_thread_url);
        this.ayi.setLongIconSupport(false);
        this.ayi.setGifIconSupport(false);
        K(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.wx() == null || ap.isEmpty(bbVar.wx().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad wx = bbVar.wx();
        if (!wx.uf() && wx.ue() != ad.agf) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ayi.setPageId(this.mTag);
        if (wx.uf()) {
            this.ayl.setVisibility(0);
            this.ayj.setVisibility(8);
            this.ayk.setVisibility(8);
            this.ayl.setText(wx.getLinkUrl());
            this.ayi.reset();
        } else {
            this.ayl.setVisibility(8);
            String ub = wx.ub();
            String uc = wx.uc();
            if (!ap.isEmpty(ub)) {
                this.ayj.setText(ub);
                this.ayj.setVisibility(0);
                this.ayk.setVisibility(8);
            } else {
                this.ayj.setVisibility(8);
                if (!ap.isEmpty(uc)) {
                    this.ayk.setText(uc);
                    this.ayk.setVisibility(0);
                } else {
                    this.ayk.setVisibility(4);
                }
            }
            if (!ap.isEmpty(wx.ud())) {
                this.ayi.startLoad(wx.ud(), 10, false);
            } else {
                this.ayi.reset();
            }
        }
        fq(bbVar.getId());
    }

    public void onChangeSkinType() {
        am.j(this, f.d.cp_bg_line_e);
        am.j(this.ayi, f.d.cp_bg_line_b);
    }

    public void fq(String str) {
        o.a(this.ayj, str, f.d.cp_cont_j, f.d.cp_cont_d);
        o.a(this.ayl, str, f.d.cp_cont_j, f.d.cp_cont_d);
        o.a(this.ayk, str, f.d.cp_cont_j, f.d.cp_cont_d);
    }

    private void K(View view) {
        if (this.aym != null && this.ayi != null) {
            int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - (com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.aym.getLayoutParams();
            layoutParams.height = ah;
            this.aym.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ayi.getLayoutParams();
            layoutParams2.width = ah;
            layoutParams2.height = ah;
            this.ayi.setLayoutParams(layoutParams2);
        }
    }
}
