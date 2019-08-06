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
    private TextView ccA;
    private TextView ccB;
    private TextView ccC;
    private ViewGroup ccD;
    private View ccE;
    private TbImageView ccz;
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
        this.ccD = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.ccz = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.ccz.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.ccz.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.ccA = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.ccB = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.ccC = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.ccE = inflate.findViewById(R.id.link_thread_content);
        this.ccz.setLongIconSupport(false);
        this.ccz.setGifIconSupport(false);
        this.ccz.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
        this.ccz.setConrers(5);
        aY(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.afX() == null || aq.isEmpty(bhVar.afX().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af afX = bhVar.afX();
        if (!afX.adg() && afX.adf() != af.bHy) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ccz.setPageId(this.mTag);
        if (afX.adg()) {
            this.ccC.setVisibility(0);
            this.ccA.setVisibility(8);
            this.ccB.setVisibility(8);
            this.ccC.setText(afX.getLinkUrl());
            this.ccz.reset();
        } else {
            this.ccC.setVisibility(8);
            String adc = afX.adc();
            String add = afX.add();
            if (!aq.isEmpty(adc)) {
                this.ccA.setText(adc);
                this.ccA.setVisibility(0);
                this.ccB.setVisibility(8);
            } else {
                this.ccA.setVisibility(8);
                if (!aq.isEmpty(add)) {
                    this.ccB.setText(add);
                    this.ccB.setVisibility(0);
                } else {
                    this.ccB.setVisibility(4);
                }
            }
            if (!aq.isEmpty(afX.ade())) {
                this.ccz.startLoad(afX.ade(), 10, false);
            } else {
                this.ccz.reset();
            }
        }
        oU(bhVar.getId());
    }

    public void onChangeSkinType() {
        am.l(this.ccE, R.color.cp_bg_line_e);
        am.k(this.ccz, R.drawable.shape_link_thread_head_bg);
    }

    public void oU(String str) {
        com.baidu.tieba.card.n.a(this.ccA, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.ccC, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.ccB, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aY(View view) {
        if (this.ccD != null && this.ccz != null) {
            int af = (((com.baidu.adp.lib.util.l.af(this.mContext) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ccD.getLayoutParams();
            layoutParams.height = af;
            this.ccD.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ccz.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.ccz.setLayoutParams(layoutParams2);
        }
    }
}
