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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView cbo;
    private TextView cbp;
    private TextView cbq;
    private TextView cbr;
    private ViewGroup cbs;
    private View cbt;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
        this.cbs = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.cbo = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.cbo.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.cbo.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.cbp = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.cbq = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.cbr = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.cbt = inflate.findViewById(R.id.link_thread_content);
        this.cbo.setLongIconSupport(false);
        this.cbo.setGifIconSupport(false);
        this.cbo.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
        this.cbo.setConrers(5);
        aW(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bg bgVar) {
        if (bgVar == null || bgVar.aeU() == null || ap.isEmpty(bgVar.aeU().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af aeU = bgVar.aeU();
        if (!aeU.acd() && aeU.acc() != af.bGw) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cbo.setPageId(this.mTag);
        if (aeU.acd()) {
            this.cbr.setVisibility(0);
            this.cbp.setVisibility(8);
            this.cbq.setVisibility(8);
            this.cbr.setText(aeU.getLinkUrl());
            this.cbo.reset();
        } else {
            this.cbr.setVisibility(8);
            String abZ = aeU.abZ();
            String aca = aeU.aca();
            if (!ap.isEmpty(abZ)) {
                this.cbp.setText(abZ);
                this.cbp.setVisibility(0);
                this.cbq.setVisibility(8);
            } else {
                this.cbp.setVisibility(8);
                if (!ap.isEmpty(aca)) {
                    this.cbq.setText(aca);
                    this.cbq.setVisibility(0);
                } else {
                    this.cbq.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aeU.acb())) {
                this.cbo.startLoad(aeU.acb(), 10, false);
            } else {
                this.cbo.reset();
            }
        }
        oE(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.cbt, R.color.cp_bg_line_e);
        al.k(this.cbo, R.drawable.shape_link_thread_head_bg);
    }

    public void oE(String str) {
        com.baidu.tieba.card.n.a(this.cbp, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cbr, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cbq, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aW(View view) {
        if (this.cbs != null && this.cbo != null) {
            int af = (((com.baidu.adp.lib.util.l.af(this.mContext) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.cbs.getLayoutParams();
            layoutParams.height = af;
            this.cbs.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.cbo.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.cbo.setLayoutParams(layoutParams2);
        }
    }
}
