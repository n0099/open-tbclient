package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView eeH;
    private TextView eeI;
    private TextView eeJ;
    private TextView eeK;
    private ViewGroup eeL;
    private View eeM;
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
        this.eeL = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.eeH = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.eeH.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.eeH.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.eeI = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.eeJ = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.eeK = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.eeM = inflate.findViewById(R.id.link_thread_content);
        this.eeH.setLongIconSupport(false);
        this.eeH.setGifIconSupport(false);
        this.eeH.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eeH.setConrers(5);
        bb(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bu buVar) {
        if (buVar == null || buVar.aTT() == null || ar.isEmpty(buVar.aTT().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ak aTT = buVar.aTT();
        if (!aTT.aQL() && aTT.aQK() != ak.dJh) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eeH.setPageId(this.mTag);
        if (aTT.aQL()) {
            this.eeK.setVisibility(0);
            this.eeI.setVisibility(8);
            this.eeJ.setVisibility(8);
            this.eeK.setText(aTT.getLinkUrl());
            this.eeH.reset();
        } else {
            this.eeK.setVisibility(8);
            String aQH = aTT.aQH();
            String aQI = aTT.aQI();
            if (!ar.isEmpty(aQH)) {
                this.eeI.setText(aQH);
                this.eeI.setVisibility(0);
                this.eeJ.setVisibility(8);
            } else {
                this.eeI.setVisibility(8);
                if (!ar.isEmpty(aQI)) {
                    this.eeJ.setText(aQI);
                    this.eeJ.setVisibility(0);
                } else {
                    this.eeJ.setVisibility(4);
                }
            }
            if (!ar.isEmpty(aTT.aQJ())) {
                this.eeH.startLoad(aTT.aQJ(), 10, false);
            } else {
                this.eeH.reset();
            }
        }
        xn(buVar.getId());
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this.eeM, R.color.cp_bg_line_e);
        an.setBackgroundResource(this.eeH, R.drawable.shape_link_thread_head_bg);
    }

    public void xn(String str) {
        m.a(this.eeI, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        m.a(this.eeK, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        m.a(this.eeJ, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void bb(View view) {
        if (this.eeL != null && this.eeH != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.eeL.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.eeL.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.eeH.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.eeH.setLayoutParams(layoutParams2);
        }
    }
}
