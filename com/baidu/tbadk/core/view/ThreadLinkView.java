package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView ekR;
    private TextView ekS;
    private TextView ekT;
    private TextView ekU;
    private ViewGroup ekV;
    private View ekW;
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
        this.ekV = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.ekR = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.ekR.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.ekR.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.ekS = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.ekT = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.ekU = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.ekW = inflate.findViewById(R.id.link_thread_content);
        this.ekR.setLongIconSupport(false);
        this.ekR.setGifIconSupport(false);
        this.ekR.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.ekR.setConrers(5);
        bh(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bv bvVar) {
        if (bvVar == null || bvVar.aXP() == null || as.isEmpty(bvVar.aXP().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        al aXP = bvVar.aXP();
        if (!aXP.aUH() && aXP.aUG() != al.dPs) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ekR.setPageId(this.mTag);
        if (aXP.aUH()) {
            this.ekU.setVisibility(0);
            this.ekS.setVisibility(8);
            this.ekT.setVisibility(8);
            this.ekU.setText(aXP.getLinkUrl());
            this.ekR.reset();
        } else {
            this.ekU.setVisibility(8);
            String aUD = aXP.aUD();
            String aUE = aXP.aUE();
            if (!as.isEmpty(aUD)) {
                this.ekS.setText(aUD);
                this.ekS.setVisibility(0);
                this.ekT.setVisibility(8);
            } else {
                this.ekS.setVisibility(8);
                if (!as.isEmpty(aUE)) {
                    this.ekT.setText(aUE);
                    this.ekT.setVisibility(0);
                } else {
                    this.ekT.setVisibility(4);
                }
            }
            if (!as.isEmpty(aXP.aUF())) {
                this.ekR.startLoad(aXP.aUF(), 10, false);
            } else {
                this.ekR.reset();
            }
        }
        ys(bvVar.getId());
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.ekW, R.color.cp_bg_line_e);
        ao.setBackgroundResource(this.ekR, R.drawable.shape_link_thread_head_bg);
    }

    public void ys(String str) {
        m.a(this.ekS, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.ekU, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.ekT, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bh(View view) {
        if (this.ekV != null && this.ekR != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ekV.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.ekV.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ekR.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.ekR.setLayoutParams(layoutParams2);
        }
    }
}
