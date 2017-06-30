package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView ane;
    private TextView anf;
    private TextView ang;
    private TextView anh;
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
        View inflate = LayoutInflater.from(context).inflate(w.j.link_thread_item, (ViewGroup) this, true);
        this.ane = (TbImageView) inflate.findViewById(w.h.link_thread_head_img);
        this.ane.setDefaultBgResource(w.g.ic_post_url_n);
        this.ane.setDefaultErrorResource(w.g.ic_post_url_n);
        this.anf = (TextView) inflate.findViewById(w.h.link_thread_title);
        this.ang = (TextView) inflate.findViewById(w.h.link_thread_abstract);
        this.anh = (TextView) inflate.findViewById(w.h.link_thread_url);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bm bmVar) {
        if (bmVar == null || bmVar.sF() == null || com.baidu.tbadk.core.util.aw.isEmpty(bmVar.sF().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        com.baidu.tbadk.core.data.ak sF = bmVar.sF();
        if (!sF.qd() && sF.qc() != com.baidu.tbadk.core.data.ak.VS) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ane.setPageId(this.mTag);
        if (sF.qd()) {
            this.anh.setVisibility(0);
            this.anf.setVisibility(8);
            this.ang.setVisibility(8);
            this.anh.setText(sF.getLinkUrl());
            this.ane.reset();
        } else {
            this.anh.setVisibility(8);
            String pZ = sF.pZ();
            String qa = sF.qa();
            if (!com.baidu.tbadk.core.util.aw.isEmpty(pZ)) {
                this.anf.setText(pZ);
                this.anf.setVisibility(0);
            } else {
                this.anf.setVisibility(4);
            }
            if (!com.baidu.tbadk.core.util.aw.isEmpty(qa)) {
                this.ang.setText(qa);
                this.ang.setVisibility(0);
            } else {
                this.ang.setVisibility(4);
            }
            if (com.baidu.tbadk.core.util.aw.dQ(pZ) > 32) {
                this.anf.setMaxLines(2);
                this.ang.setMaxLines(1);
            } else {
                this.anf.setMaxLines(1);
                this.ang.setMaxLines(2);
            }
            if (!com.baidu.tbadk.core.util.aw.isEmpty(sF.qb())) {
                this.ane.c(sF.qb(), 10, false);
            } else {
                this.ane.reset();
            }
        }
        em(bmVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.k(this, w.e.cp_bg_line_e);
    }

    public void em(String str) {
        com.baidu.tieba.card.at.a(this.anf, str, w.e.cp_cont_b, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.anh, str, w.e.cp_cont_b, w.e.cp_cont_d);
        com.baidu.tieba.card.at.a(this.ang, str, w.e.cp_cont_d, w.e.cp_cont_d);
    }
}
