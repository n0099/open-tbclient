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
    private TbImageView cbp;
    private TextView cbq;
    private TextView cbr;
    private TextView cbs;
    private ViewGroup cbt;
    private View cbu;
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
        this.cbt = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.cbp = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.cbp.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.cbp.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.cbq = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.cbr = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.cbs = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.cbu = inflate.findViewById(R.id.link_thread_content);
        this.cbp.setLongIconSupport(false);
        this.cbp.setGifIconSupport(false);
        this.cbp.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
        this.cbp.setConrers(5);
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
        if (!aeU.acd() && aeU.acc() != af.bGx) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cbp.setPageId(this.mTag);
        if (aeU.acd()) {
            this.cbs.setVisibility(0);
            this.cbq.setVisibility(8);
            this.cbr.setVisibility(8);
            this.cbs.setText(aeU.getLinkUrl());
            this.cbp.reset();
        } else {
            this.cbs.setVisibility(8);
            String abZ = aeU.abZ();
            String aca = aeU.aca();
            if (!ap.isEmpty(abZ)) {
                this.cbq.setText(abZ);
                this.cbq.setVisibility(0);
                this.cbr.setVisibility(8);
            } else {
                this.cbq.setVisibility(8);
                if (!ap.isEmpty(aca)) {
                    this.cbr.setText(aca);
                    this.cbr.setVisibility(0);
                } else {
                    this.cbr.setVisibility(4);
                }
            }
            if (!ap.isEmpty(aeU.acb())) {
                this.cbp.startLoad(aeU.acb(), 10, false);
            } else {
                this.cbp.reset();
            }
        }
        oD(bgVar.getId());
    }

    public void onChangeSkinType() {
        al.l(this.cbu, R.color.cp_bg_line_e);
        al.k(this.cbp, R.drawable.shape_link_thread_head_bg);
    }

    public void oD(String str) {
        com.baidu.tieba.card.n.a(this.cbq, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cbs, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cbr, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aW(View view) {
        if (this.cbt != null && this.cbp != null) {
            int af = (((com.baidu.adp.lib.util.l.af(this.mContext) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.cbt.getLayoutParams();
            layoutParams.height = af;
            this.cbt.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.cbp.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.cbp.setLayoutParams(layoutParams2);
        }
    }
}
