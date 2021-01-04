package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView fnC;
    private TextView fnD;
    private TextView fnE;
    private TextView fnF;
    private ViewGroup fnG;
    private View fnH;
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
        this.fnG = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.fnC = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.fnC.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.fnD = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.fnE = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.fnF = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.fnH = inflate.findViewById(R.id.link_thread_content);
        this.fnC.setLongIconSupport(false);
        this.fnC.setGifIconSupport(false);
        this.fnC.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.fnC.setConrers(5);
        bJ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bz bzVar) {
        if (bzVar == null || bzVar.bsX() == null || at.isEmpty(bzVar.bsX().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ao bsX = bzVar.bsX();
        if (!bsX.bpK() && bsX.bpJ() != ao.eQA) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fnC.setPageId(this.mTag);
        if (bsX.bpK()) {
            this.fnF.setVisibility(0);
            this.fnD.setVisibility(8);
            this.fnE.setVisibility(8);
            this.fnF.setText(bsX.getLinkUrl());
            this.fnC.reset();
        } else {
            this.fnF.setVisibility(8);
            String bpG = bsX.bpG();
            String bpH = bsX.bpH();
            if (!at.isEmpty(bpG)) {
                this.fnD.setText(bpG);
                this.fnD.setVisibility(0);
                this.fnE.setVisibility(8);
            } else {
                this.fnD.setVisibility(8);
                if (!at.isEmpty(bpH)) {
                    this.fnE.setText(bpH);
                    this.fnE.setVisibility(0);
                } else {
                    this.fnE.setVisibility(4);
                }
            }
            if (!at.isEmpty(bsX.bpI())) {
                this.fnC.startLoad(bsX.bpI(), 10, false);
            } else {
                this.fnC.reset();
            }
        }
        CB(bzVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.fnH, R.color.CAM_X0205);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fnC, R.drawable.shape_link_thread_head_bg);
    }

    public void CB(String str) {
        m.a(this.fnD, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fnF, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fnE, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bJ(View view) {
        if (this.fnG != null && this.fnC != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.fnG.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.fnG.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fnC.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.fnC.setLayoutParams(layoutParams2);
        }
    }
}
