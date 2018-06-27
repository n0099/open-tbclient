package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TextView ayA;
    private TextView ayB;
    private ViewGroup ayC;
    private TbImageView ayy;
    private TextView ayz;
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
        View inflate = LayoutInflater.from(context).inflate(d.i.link_thread_item, (ViewGroup) this, true);
        this.ayC = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.ayy = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.ayy.setDefaultBgResource(d.f.icon_card_url_n);
        this.ayy.setDefaultErrorResource(d.f.icon_card_url_n);
        this.ayz = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.ayA = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.ayB = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.ayy.setLongIconSupport(false);
        this.ayy.setGifIconSupport(false);
        K(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bc bcVar) {
        if (bcVar == null || bcVar.wJ() == null || ap.isEmpty(bcVar.wJ().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ae wJ = bcVar.wJ();
        if (!wJ.ut() && wJ.us() != ae.agL) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ayy.setPageId(this.mTag);
        if (wJ.ut()) {
            this.ayB.setVisibility(0);
            this.ayz.setVisibility(8);
            this.ayA.setVisibility(8);
            this.ayB.setText(wJ.getLinkUrl());
            this.ayy.reset();
        } else {
            this.ayB.setVisibility(8);
            String up = wJ.up();
            String uq = wJ.uq();
            if (!ap.isEmpty(up)) {
                this.ayz.setText(up);
                this.ayz.setVisibility(0);
                this.ayA.setVisibility(8);
            } else {
                this.ayz.setVisibility(8);
                if (!ap.isEmpty(uq)) {
                    this.ayA.setText(uq);
                    this.ayA.setVisibility(0);
                } else {
                    this.ayA.setVisibility(4);
                }
            }
            if (!ap.isEmpty(wJ.ur())) {
                this.ayy.startLoad(wJ.ur(), 10, false);
            } else {
                this.ayy.reset();
            }
        }
        fr(bcVar.getId());
    }

    public void onChangeSkinType() {
        am.j(this, d.C0142d.cp_bg_line_e);
        am.j(this.ayy, d.C0142d.cp_bg_line_b);
    }

    public void fr(String str) {
        o.a(this.ayz, str, d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
        o.a(this.ayB, str, d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
        o.a(this.ayA, str, d.C0142d.cp_cont_j, d.C0142d.cp_cont_d);
    }

    private void K(View view) {
        if (this.ayC != null && this.ayy != null) {
            int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - (com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ayC.getLayoutParams();
            layoutParams.height = ah;
            this.ayC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ayy.getLayoutParams();
            layoutParams2.width = ah;
            layoutParams2.height = ah;
            this.ayy.setLayoutParams(layoutParams2);
        }
    }
}
