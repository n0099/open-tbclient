package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TextView diA;
    private TextView diB;
    private TextView diC;
    private ViewGroup diD;
    private View diE;
    private TbImageView diz;
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
        this.diD = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.diz = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.diz.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.diz.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.diA = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.diB = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.diC = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.diE = inflate.findViewById(R.id.link_thread_content);
        this.diz.setLongIconSupport(false);
        this.diz.setGifIconSupport(false);
        this.diz.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.diz.setConrers(5);
        aZ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aDN() == null || aq.isEmpty(bjVar.aDN().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aDN = bjVar.aDN();
        if (!aDN.aAR() && aDN.aAQ() != ag.cPp) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.diz.setPageId(this.mTag);
        if (aDN.aAR()) {
            this.diC.setVisibility(0);
            this.diA.setVisibility(8);
            this.diB.setVisibility(8);
            this.diC.setText(aDN.getLinkUrl());
            this.diz.reset();
        } else {
            this.diC.setVisibility(8);
            String aAN = aDN.aAN();
            String aAO = aDN.aAO();
            if (!aq.isEmpty(aAN)) {
                this.diA.setText(aAN);
                this.diA.setVisibility(0);
                this.diB.setVisibility(8);
            } else {
                this.diA.setVisibility(8);
                if (!aq.isEmpty(aAO)) {
                    this.diB.setText(aAO);
                    this.diB.setVisibility(0);
                } else {
                    this.diB.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aDN.aAP())) {
                this.diz.startLoad(aDN.aAP(), 10, false);
            } else {
                this.diz.reset();
            }
        }
        tZ(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.diE, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.diz, R.drawable.shape_link_thread_head_bg);
    }

    public void tZ(String str) {
        com.baidu.tieba.card.l.a(this.diA, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diC, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diB, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aZ(View view) {
        if (this.diD != null && this.diz != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.diD.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.diD.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.diz.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.diz.setLayoutParams(layoutParams2);
        }
    }
}
