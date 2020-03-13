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
    private TbImageView diM;
    private TextView diN;
    private TextView diO;
    private TextView diP;
    private ViewGroup diQ;
    private View diR;
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
        this.diQ = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.diM = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.diM.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.diM.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.diN = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.diO = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.diP = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.diR = inflate.findViewById(R.id.link_thread_content);
        this.diM.setLongIconSupport(false);
        this.diM.setGifIconSupport(false);
        this.diM.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.diM.setConrers(5);
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
        if (!aDN.aAR() && aDN.aAQ() != ag.cPq) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.diM.setPageId(this.mTag);
        if (aDN.aAR()) {
            this.diP.setVisibility(0);
            this.diN.setVisibility(8);
            this.diO.setVisibility(8);
            this.diP.setText(aDN.getLinkUrl());
            this.diM.reset();
        } else {
            this.diP.setVisibility(8);
            String aAN = aDN.aAN();
            String aAO = aDN.aAO();
            if (!aq.isEmpty(aAN)) {
                this.diN.setText(aAN);
                this.diN.setVisibility(0);
                this.diO.setVisibility(8);
            } else {
                this.diN.setVisibility(8);
                if (!aq.isEmpty(aAO)) {
                    this.diO.setText(aAO);
                    this.diO.setVisibility(0);
                } else {
                    this.diO.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aDN.aAP())) {
                this.diM.startLoad(aDN.aAP(), 10, false);
            } else {
                this.diM.reset();
            }
        }
        ua(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.diR, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.diM, R.drawable.shape_link_thread_head_bg);
    }

    public void ua(String str) {
        com.baidu.tieba.card.l.a(this.diN, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diP, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diO, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aZ(View view) {
        if (this.diQ != null && this.diM != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.diQ.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.diQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.diM.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.diM.setLayoutParams(layoutParams2);
        }
    }
}
