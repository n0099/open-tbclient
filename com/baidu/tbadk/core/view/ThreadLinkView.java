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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView cds;
    private TextView cdt;
    private TextView cdu;
    private TextView cdv;
    private ViewGroup cdw;
    private View cdx;
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
        this.cdw = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.cds = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.cds.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.cds.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.cdt = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.cdu = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.cdv = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.cdx = inflate.findViewById(R.id.link_thread_content);
        this.cds.setLongIconSupport(false);
        this.cds.setGifIconSupport(false);
        this.cds.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
        this.cds.setConrers(5);
        aY(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.agb() == null || aq.isEmpty(bhVar.agb().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af agb = bhVar.agb();
        if (!agb.adk() && agb.adj() != af.bHW) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cds.setPageId(this.mTag);
        if (agb.adk()) {
            this.cdv.setVisibility(0);
            this.cdt.setVisibility(8);
            this.cdu.setVisibility(8);
            this.cdv.setText(agb.getLinkUrl());
            this.cds.reset();
        } else {
            this.cdv.setVisibility(8);
            String adg = agb.adg();
            String adh = agb.adh();
            if (!aq.isEmpty(adg)) {
                this.cdt.setText(adg);
                this.cdt.setVisibility(0);
                this.cdu.setVisibility(8);
            } else {
                this.cdt.setVisibility(8);
                if (!aq.isEmpty(adh)) {
                    this.cdu.setText(adh);
                    this.cdu.setVisibility(0);
                } else {
                    this.cdu.setVisibility(4);
                }
            }
            if (!aq.isEmpty(agb.adi())) {
                this.cds.startLoad(agb.adi(), 10, false);
            } else {
                this.cds.reset();
            }
        }
        pc(bhVar.getId());
    }

    public void onChangeSkinType() {
        am.l(this.cdx, R.color.cp_bg_line_e);
        am.k(this.cds, R.drawable.shape_link_thread_head_bg);
    }

    public void pc(String str) {
        com.baidu.tieba.card.n.a(this.cdt, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cdv, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cdu, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aY(View view) {
        if (this.cdw != null && this.cds != null) {
            int af = (((com.baidu.adp.lib.util.l.af(this.mContext) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.cdw.getLayoutParams();
            layoutParams.height = af;
            this.cdw.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.cds.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.cds.setLayoutParams(layoutParams2);
        }
    }
}
