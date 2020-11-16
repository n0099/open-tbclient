package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private ViewGroup eWA;
    private View eWB;
    private TbImageView eWw;
    private TextView eWx;
    private TextView eWy;
    private TextView eWz;
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
        this.eWA = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.eWw = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.eWw.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.eWw.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.eWx = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.eWy = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.eWz = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.eWB = inflate.findViewById(R.id.link_thread_content);
        this.eWw.setLongIconSupport(false);
        this.eWw.setGifIconSupport(false);
        this.eWw.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eWw.setConrers(5);
        bx(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bx bxVar) {
        if (bxVar == null || bxVar.bni() == null || au.isEmpty(bxVar.bni().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        an bni = bxVar.bni();
        if (!bni.bjY() && bni.bjX() != an.ezL) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eWw.setPageId(this.mTag);
        if (bni.bjY()) {
            this.eWz.setVisibility(0);
            this.eWx.setVisibility(8);
            this.eWy.setVisibility(8);
            this.eWz.setText(bni.getLinkUrl());
            this.eWw.reset();
        } else {
            this.eWz.setVisibility(8);
            String bjU = bni.bjU();
            String bjV = bni.bjV();
            if (!au.isEmpty(bjU)) {
                this.eWx.setText(bjU);
                this.eWx.setVisibility(0);
                this.eWy.setVisibility(8);
            } else {
                this.eWx.setVisibility(8);
                if (!au.isEmpty(bjV)) {
                    this.eWy.setText(bjV);
                    this.eWy.setVisibility(0);
                } else {
                    this.eWy.setVisibility(4);
                }
            }
            if (!au.isEmpty(bni.bjW())) {
                this.eWw.startLoad(bni.bjW(), 10, false);
            } else {
                this.eWw.reset();
            }
        }
        BV(bxVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eWB, R.color.CAM_X0205);
        ap.setBackgroundResource(this.eWw, R.drawable.shape_link_thread_head_bg);
    }

    public void BV(String str) {
        n.a(this.eWx, str, R.color.CAM_X0107, R.color.CAM_X0109);
        n.a(this.eWz, str, R.color.CAM_X0107, R.color.CAM_X0109);
        n.a(this.eWy, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bx(View view) {
        if (this.eWA != null && this.eWw != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.eWA.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.eWA.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.eWw.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.eWw.setLayoutParams(layoutParams2);
        }
    }
}
