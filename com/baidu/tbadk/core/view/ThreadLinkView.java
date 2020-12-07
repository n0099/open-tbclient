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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView fdT;
    private TextView fdU;
    private TextView fdV;
    private TextView fdW;
    private ViewGroup fdX;
    private View fdY;
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
        this.fdX = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.fdT = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.fdT.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.fdT.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.fdU = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.fdV = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.fdW = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.fdY = inflate.findViewById(R.id.link_thread_content);
        this.fdT.setLongIconSupport(false);
        this.fdT.setGifIconSupport(false);
        this.fdT.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.fdT.setConrers(5);
        bA(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(by byVar) {
        if (byVar == null || byVar.bqv() == null || au.isEmpty(byVar.bqv().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ao bqv = byVar.bqv();
        if (!bqv.bnl() && bqv.bnk() != ao.eGK) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fdT.setPageId(this.mTag);
        if (bqv.bnl()) {
            this.fdW.setVisibility(0);
            this.fdU.setVisibility(8);
            this.fdV.setVisibility(8);
            this.fdW.setText(bqv.getLinkUrl());
            this.fdT.reset();
        } else {
            this.fdW.setVisibility(8);
            String bnh = bqv.bnh();
            String bni = bqv.bni();
            if (!au.isEmpty(bnh)) {
                this.fdU.setText(bnh);
                this.fdU.setVisibility(0);
                this.fdV.setVisibility(8);
            } else {
                this.fdU.setVisibility(8);
                if (!au.isEmpty(bni)) {
                    this.fdV.setText(bni);
                    this.fdV.setVisibility(0);
                } else {
                    this.fdV.setVisibility(4);
                }
            }
            if (!au.isEmpty(bqv.bnj())) {
                this.fdT.startLoad(bqv.bnj(), 10, false);
            } else {
                this.fdT.reset();
            }
        }
        CD(byVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.fdY, R.color.CAM_X0205);
        ap.setBackgroundResource(this.fdT, R.drawable.shape_link_thread_head_bg);
    }

    public void CD(String str) {
        n.a(this.fdU, str, R.color.CAM_X0107, R.color.CAM_X0109);
        n.a(this.fdW, str, R.color.CAM_X0107, R.color.CAM_X0109);
        n.a(this.fdV, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bA(View view) {
        if (this.fdX != null && this.fdT != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.fdX.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.fdX.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fdT.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.fdT.setLayoutParams(layoutParams2);
        }
    }
}
