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
    private TbImageView fiT;
    private TextView fiU;
    private TextView fiV;
    private TextView fiW;
    private ViewGroup fiX;
    private View fiY;
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
        this.fiX = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.fiT = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.fiT.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.fiU = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.fiV = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.fiW = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.fiY = inflate.findViewById(R.id.link_thread_content);
        this.fiT.setLongIconSupport(false);
        this.fiT.setGifIconSupport(false);
        this.fiT.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.fiT.setConrers(5);
        bJ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bz bzVar) {
        if (bzVar == null || bzVar.bpe() == null || at.isEmpty(bzVar.bpe().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ao bpe = bzVar.bpe();
        if (!bpe.blR() && bpe.blQ() != ao.eLP) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fiT.setPageId(this.mTag);
        if (bpe.blR()) {
            this.fiW.setVisibility(0);
            this.fiU.setVisibility(8);
            this.fiV.setVisibility(8);
            this.fiW.setText(bpe.getLinkUrl());
            this.fiT.reset();
        } else {
            this.fiW.setVisibility(8);
            String blN = bpe.blN();
            String blO = bpe.blO();
            if (!at.isEmpty(blN)) {
                this.fiU.setText(blN);
                this.fiU.setVisibility(0);
                this.fiV.setVisibility(8);
            } else {
                this.fiU.setVisibility(8);
                if (!at.isEmpty(blO)) {
                    this.fiV.setText(blO);
                    this.fiV.setVisibility(0);
                } else {
                    this.fiV.setVisibility(4);
                }
            }
            if (!at.isEmpty(bpe.blP())) {
                this.fiT.startLoad(bpe.blP(), 10, false);
            } else {
                this.fiT.reset();
            }
        }
        Bp(bzVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.fiY, R.color.CAM_X0205);
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.fiT, R.drawable.shape_link_thread_head_bg);
    }

    public void Bp(String str) {
        m.a(this.fiU, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fiW, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fiV, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bJ(View view) {
        if (this.fiX != null && this.fiT != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.fiX.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.fiX.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fiT.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.fiT.setLayoutParams(layoutParams2);
        }
    }
}
