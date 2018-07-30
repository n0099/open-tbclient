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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView ayl;
    private TextView aym;
    private TextView ayn;
    private TextView ayo;
    private ViewGroup ayp;
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
        this.ayp = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.ayl = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.ayl.setDefaultBgResource(d.f.icon_card_url_n);
        this.ayl.setDefaultErrorResource(d.f.icon_card_url_n);
        this.aym = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.ayn = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.ayo = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.ayl.setLongIconSupport(false);
        this.ayl.setGifIconSupport(false);
        K(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bb bbVar) {
        if (bbVar == null || bbVar.wy() == null || ap.isEmpty(bbVar.wy().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ad wy = bbVar.wy();
        if (!wy.ug() && wy.uf() != ad.agf) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ayl.setPageId(this.mTag);
        if (wy.ug()) {
            this.ayo.setVisibility(0);
            this.aym.setVisibility(8);
            this.ayn.setVisibility(8);
            this.ayo.setText(wy.getLinkUrl());
            this.ayl.reset();
        } else {
            this.ayo.setVisibility(8);
            String uc = wy.uc();
            String ud = wy.ud();
            if (!ap.isEmpty(uc)) {
                this.aym.setText(uc);
                this.aym.setVisibility(0);
                this.ayn.setVisibility(8);
            } else {
                this.aym.setVisibility(8);
                if (!ap.isEmpty(ud)) {
                    this.ayn.setText(ud);
                    this.ayn.setVisibility(0);
                } else {
                    this.ayn.setVisibility(4);
                }
            }
            if (!ap.isEmpty(wy.ue())) {
                this.ayl.startLoad(wy.ue(), 10, false);
            } else {
                this.ayl.reset();
            }
        }
        fq(bbVar.getId());
    }

    public void onChangeSkinType() {
        am.j(this, d.C0140d.cp_bg_line_e);
        am.j(this.ayl, d.C0140d.cp_bg_line_b);
    }

    public void fq(String str) {
        o.a(this.aym, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
        o.a(this.ayo, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
        o.a(this.ayn, str, d.C0140d.cp_cont_j, d.C0140d.cp_cont_d);
    }

    private void K(View view) {
        if (this.ayp != null && this.ayl != null) {
            int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - (com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ayp.getLayoutParams();
            layoutParams.height = ah;
            this.ayp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ayl.getLayoutParams();
            layoutParams2.width = ah;
            layoutParams2.height = ah;
            this.ayl.setLayoutParams(layoutParams2);
        }
    }
}
