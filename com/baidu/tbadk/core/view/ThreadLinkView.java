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
    private TbImageView diZ;
    private TextView dja;
    private TextView djb;
    private TextView djc;
    private ViewGroup djd;
    private View dje;
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
        this.djd = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.diZ = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.diZ.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.diZ.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.dja = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.djb = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.djc = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dje = inflate.findViewById(R.id.link_thread_content);
        this.diZ.setLongIconSupport(false);
        this.diZ.setGifIconSupport(false);
        this.diZ.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.diZ.setConrers(5);
        aZ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aDR() == null || aq.isEmpty(bjVar.aDR().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aDR = bjVar.aDR();
        if (!aDR.aAU() && aDR.aAT() != ag.cPD) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.diZ.setPageId(this.mTag);
        if (aDR.aAU()) {
            this.djc.setVisibility(0);
            this.dja.setVisibility(8);
            this.djb.setVisibility(8);
            this.djc.setText(aDR.getLinkUrl());
            this.diZ.reset();
        } else {
            this.djc.setVisibility(8);
            String aAQ = aDR.aAQ();
            String aAR = aDR.aAR();
            if (!aq.isEmpty(aAQ)) {
                this.dja.setText(aAQ);
                this.dja.setVisibility(0);
                this.djb.setVisibility(8);
            } else {
                this.dja.setVisibility(8);
                if (!aq.isEmpty(aAR)) {
                    this.djb.setText(aAR);
                    this.djb.setVisibility(0);
                } else {
                    this.djb.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aDR.aAS())) {
                this.diZ.startLoad(aDR.aAS(), 10, false);
            } else {
                this.diZ.reset();
            }
        }
        ua(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dje, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.diZ, R.drawable.shape_link_thread_head_bg);
    }

    public void ua(String str) {
        com.baidu.tieba.card.l.a(this.dja, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.djc, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.djb, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aZ(View view) {
        if (this.djd != null && this.diZ != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.djd.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.djd.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.diZ.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.diZ.setLayoutParams(layoutParams2);
        }
    }
}
