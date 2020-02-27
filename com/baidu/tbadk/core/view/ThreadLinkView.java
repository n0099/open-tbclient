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
    private ViewGroup diC;
    private View diD;
    private TbImageView diy;
    private TextView diz;
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
        this.diC = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.diy = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.diy.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.diy.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.diz = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.diA = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.diB = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.diD = inflate.findViewById(R.id.link_thread_content);
        this.diy.setLongIconSupport(false);
        this.diy.setGifIconSupport(false);
        this.diy.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.diy.setConrers(5);
        aZ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aDL() == null || aq.isEmpty(bjVar.aDL().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aDL = bjVar.aDL();
        if (!aDL.aAP() && aDL.aAO() != ag.cPo) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.diy.setPageId(this.mTag);
        if (aDL.aAP()) {
            this.diB.setVisibility(0);
            this.diz.setVisibility(8);
            this.diA.setVisibility(8);
            this.diB.setText(aDL.getLinkUrl());
            this.diy.reset();
        } else {
            this.diB.setVisibility(8);
            String aAL = aDL.aAL();
            String aAM = aDL.aAM();
            if (!aq.isEmpty(aAL)) {
                this.diz.setText(aAL);
                this.diz.setVisibility(0);
                this.diA.setVisibility(8);
            } else {
                this.diz.setVisibility(8);
                if (!aq.isEmpty(aAM)) {
                    this.diA.setText(aAM);
                    this.diA.setVisibility(0);
                } else {
                    this.diA.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aDL.aAN())) {
                this.diy.startLoad(aDL.aAN(), 10, false);
            } else {
                this.diy.reset();
            }
        }
        tZ(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.diD, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.diy, R.drawable.shape_link_thread_head_bg);
    }

    public void tZ(String str) {
        com.baidu.tieba.card.l.a(this.diz, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diB, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.diA, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aZ(View view) {
        if (this.diC != null && this.diy != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.diC.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.diC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.diy.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.diy.setLayoutParams(layoutParams2);
        }
    }
}
